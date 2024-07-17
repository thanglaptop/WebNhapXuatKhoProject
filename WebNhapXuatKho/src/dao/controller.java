package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Admin;
import model.Product;
import model.Size;

public class controller {
	private EntityManagerFactory ef = Persistence.createEntityManagerFactory("webbandaokeo");
	private EntityManager em = ef.createEntityManager();
	
	public boolean checkLogin(String username, String password) {
		TypedQuery<Admin> query = em.createQuery("select a from Admin a where a.username = :username", Admin.class);
		query.setParameter("username", username);
		Admin ad = null;
		try {
			ad = query.getSingleResult();
		} catch (Exception e) {
			
		}
		if(ad != null && ad.getPassword().equals(password)) {
			return true;
		}
		else return false;
	}
}
