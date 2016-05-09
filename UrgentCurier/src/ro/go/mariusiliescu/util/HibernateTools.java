package ro.go.mariusiliescu.util;

import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateTools {
    private static SessionFactory sessionFactory ;
    
	public HibernateTools(){
    	sessionFactory =  new Configuration().configure().buildSessionFactory();
    }
    
	public <T> void save(T obj){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.save(obj);
		tx.commit();
		session.close();
	}
	public <T> void delete(T obj){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		session.close();
	}
	
	public <T> void update(T newObj){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(newObj);
		session.getTransaction().commit();
		session.close();
	}
	
	public void closeSessionFactory(){
		if(!sessionFactory.isClosed())
			sessionFactory.close();
	}
}
