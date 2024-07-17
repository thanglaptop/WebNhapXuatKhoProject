package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Supplier;

/**
 * Servlet implementation class EditSupplier
 */
@WebServlet("/EditSupplier")
public class EditSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("WNXK");
		EntityManager em = ef.createEntityManager();
		em.getTransaction().begin();
		
		int s_id = Integer.parseInt(request.getParameter("sid"));
		String s_name = request.getParameter("sname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Supplier s = new Supplier();
		s.setSup_id(s_id);
		s.setSup_name(s_name);
		s.setAddress(address);
		s.setPhone(phone);
		
		em.merge(s);
		
		em.getTransaction().commit();
		em.close();
		ef.close();
		
		response.sendRedirect("ManageServlet#NCC");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
