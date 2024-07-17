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
 * Servlet implementation class test
 */
@WebServlet("/test")
@MultipartConfig(maxFileSize = 16234234)
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
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
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("webbandaokeo");
		EntityManager em = ef.createEntityManager();
		em.getTransaction().begin();
		
		String proname = request.getParameter("edit_proname");
		Category cate = em.find(Category.class, Integer.parseInt(request.getParameter("edit_category")));
		Supplier sup = em.find(Supplier.class, Integer.parseInt(request.getParameter("edit_supplier")));
		
		
		
//		get image
		Part part = request.getPart("edit_image");
//		InputStream is = null;
//		if(part != null) {
//			is = part.getInputStream();
//		}
//		byte[] img = new byte[is.available()];
//		is.read(img);
		
		System.out.println("tên: " +proname);
		System.out.println("loại: " + cate.getName());
		System.out.println("ncc: " + sup.getSup_name());
//		System.out.println("hình: " + img.toString());
		System.out.println("part: " + part.getInputStream().read());
		
		em.getTransaction().commit();
		em.close();
		ef.close();
		
	}

}
