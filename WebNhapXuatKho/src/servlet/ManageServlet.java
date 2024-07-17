package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import model.Category;
import model.Product;
import model.Size;
import model.Supplier;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
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
		
		List<Category> listc = em.createQuery("from Category").getResultList();
		request.setAttribute("listc", listc);
		List<Supplier> listncc = em.createQuery("from Supplier").getResultList();
		request.setAttribute("listncc", listncc);
		List<Product> listp = em.createQuery("from Product").getResultList();
		request.setAttribute("listp", listp);
		
		em.getTransaction().commit();
		em.close();
		ef.close();
		
		RequestDispatcher rd = request.getRequestDispatcher("views/manage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
