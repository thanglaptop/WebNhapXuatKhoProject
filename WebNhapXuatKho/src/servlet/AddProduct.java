 package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Category;
import model.Product;
import model.Size;
import model.Supplier;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig(maxFileSize = 16234234)
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

		EntityManagerFactory ef = Persistence.createEntityManagerFactory("WNXK");
		EntityManager em = ef.createEntityManager();
		em.getTransaction().begin();
		
		Product p = new Product();
		String proname = request.getParameter("product_name");
		Category cate = em.find(Category.class, Integer.parseInt(request.getParameter("category")));
		Supplier sup = em.find(Supplier.class, Integer.parseInt(request.getParameter("supplier")));
		
		p.setPname(proname);
		p.setCategory(cate);
		p.setSupplier(sup);
		
//		get image
		Part part = request.getPart("image");
		InputStream is = null;
		if(part != null) {
			is = part.getInputStream();
			byte[] img = new byte[is.available()];
			is.read(img);
			p.setImage(img);
		}
		
		
		
//		get list size
		String listsize = request.getParameter("arraySize");
		if(listsize != null && !listsize.isEmpty()) {
			String[] sizenames = listsize.split(",");
			for(String sizename : sizenames) {
					String sql = "from Size s where sizename = :sizename";
					TypedQuery<Size> si = em.createQuery(sql, Size.class);
					si.setParameter("sizename", sizename.trim());
					Size s = null;
					try {
						s = si.getSingleResult();
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(s == null) {
						Size newone = new Size();
						newone.setSizename(sizename);
						em.persist(newone);
						p.getListsize().add(newone);
					}
					else {
						p.getListsize().add(s);
					}
			}
		}
		
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
		ef.close();
		
		response.sendRedirect("ManageServlet#SP");
	}

}
