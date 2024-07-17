package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.controller;
import model.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("WNXK");
		EntityManager em = ef.createEntityManager();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		controller cdao = new controller();
		
		if(cdao.checkLogin(username, password) == true) {
			String sql = "from Admin a where a.username = :username and a.password = :password";
			TypedQuery<Admin> a = em.createQuery(sql, Admin.class);
			a.setParameter("username", username);
			a.setParameter("password", password);
			Admin ad = a.getSingleResult();
			request.getSession().setAttribute("fullname", ad.getFullname());
			response.sendRedirect("views/main.jsp");
		}
		else {
			response.sendRedirect("index.jsp?error=true");
		}
	}

}
