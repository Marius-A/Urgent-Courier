package com.mariusiliescu.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateTools {
    private static SessionFactory sessionFactory ;
    
	public HibernateTools(){
    	sessionFactory =  new Configuration().configure().buildSessionFactory();
    }
    
	public <T> void save(T obj){
		Session session = getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.saveOrUpdate(obj);
		tx.commit();
		session.close();
	}
	public <T> void persist(T obj){
		Session session = getSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.persist(obj);
		tx.commit();
		session.flush();
		session.close();
	}
	public <T> void delete(T obj){
		Session session = getSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		session.close();
	}
	
	public <T> void update(T newObj){
		Session session = getSession();
		session.beginTransaction();
		session.update(newObj);
		session.getTransaction().commit();
		session.close();
	}
	
	public void closeSessionFactory(){
		if(!sessionFactory.isClosed())
			sessionFactory.close();
	}
	
	public ResultSet getRs(String query) throws SQLException{
		Session session = sessionFactory.openSession();
		Connection con = ((SessionImpl)session).connection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
		return ps.executeQuery();
		
	}
	
	public Session getSession(){
		Session sess = null;       
		   try {         
		       sess = sessionFactory.getCurrentSession();  
		   } catch (org.hibernate.HibernateException he) {  
		       sess = sessionFactory.openSession();     
		   }             
		   return sess;
	}
}
