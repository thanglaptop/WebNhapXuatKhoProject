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
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
@MultipartConfig(maxFileSize = 16234234)
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

		EntityManagerFactory ef = Persistence.createEntityManagerFactory("WNXK");
		EntityManager em = ef.createEntityManager();
		em.getTransaction().begin();
		
		int proid = Integer.parseInt(request.getParameter("edit_proid"));
		Product p = em.find(Product.class, proid);
		
		String proname = request.getParameter("edit_proname");
		Category cate = em.find(Category.class, Integer.parseInt(request.getParameter("edit_category")));
		Supplier sup = em.find(Supplier.class, Integer.parseInt(request.getParameter("edit_supplier")));
		
		p.setPname(proname);
		p.setCategory(cate);
		p.setSupplier(sup);
		
		
//		get image
		Part part = request.getPart("edit_image");
		if(part.getInputStream().read() != -1) {
			InputStream imgdata = part.getInputStream();
			byte[] img = new byte[imgdata.available()];
			imgdata.read(img);
			p.setImage(img);
		}
		
		
//		get list size
		String listsize = request.getParameter("edit_arraySize");
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
		
		
		em.getTransaction().commit();
		em.close();
		ef.close();
		
		response.sendRedirect("ManageServlet#SP");
	}

}
