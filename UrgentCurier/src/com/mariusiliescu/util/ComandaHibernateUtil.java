package com.mariusiliescu.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mariusiliescu.model.entities.Comanda;
import com.mariusiliescu.model.entities.Companie;
import com.mariusiliescu.model.entities.Pachet;
import com.mariusiliescu.model.entities.persoane.Client;
import com.mariusiliescu.model.entities.persoane.Destinatar;
import com.mariusiliescu.model.entities.persoane.PersoanaExpeditoare;

public class ComandaHibernateUtil {
	
	@PersistenceContext
	EntityManager entityManager;
	
	HibernateTools hibernateTools = new HibernateTools();
	
	public void addComanda(Comanda c){
/*		for(Pachet p : c.getListaPachete()){
			if(!destinatarulExista(p.getDestinatar())){
				hibernateTools.save(p.getDestinatar());//salvam destinatarii
			}
			hibernateTools.save(p);//salvam pachetele
		}
		if(c.getExpeditor() instanceof Companie){
			if(!companiaExista((Companie)c.getExpeditor())){
				hibernateTools.save((Companie)c.getExpeditor());//salvam compania expeditoare
			}
		}
		if(c.getExpeditor() instanceof PersoanaExpeditoare){
			if(!persFizicaExpExista((PersoanaExpeditoare)c.getExpeditor())){
				hibernateTools.save((PersoanaExpeditoare)c.getExpeditor());//salvam persoana fizica expeditoare
			}
		}*/
		List<Destinatar> listaDestinatariExistenti = getDestinatari();
		List<Destinatar> listaDestinatariInserati = new ArrayList<>();
		for(Pachet p : c.getListaPachete()){
			for(Destinatar d : listaDestinatariExistenti){
				if(!d.getCnp().equals(p.getDestinatar().getCnp())){
					listaDestinatariInserati.add(p.getDestinatar());
				}
			}
		}
		for(Destinatar d : listaDestinatariInserati)
			hibernateTools.save(d);
		hibernateTools.save(c);
	}
	
	
	public Companie gasesteCompanie(Long id) {
		TypedQuery<Companie> q = entityManager.createQuery("SELECT o FROM Destinatar AS o WHERE o.ID_CLIENT = :ID_CLIENT", Companie.class);
        q.setParameter("ID_CLIENT",id);
        
        return q.getSingleResult();
    }
	
	public boolean destinatarulExista(Destinatar d){
        TypedQuery<Destinatar> q = entityManager.createQuery("SELECT p FROM persoane AS p ,destinatari as o WHERE o.PERSON_ID = p.PERSON_ID", Destinatar.class);;
        List<Destinatar> list = q.getResultList();
        for(Destinatar dest : list){
        	if(dest.getCnp().equals(d.getCnp()))
        		return true;
        	else
        		return false;
        }
        return false;
	}
	public boolean clientulExista(Client c){
		return true;
	}
	public boolean companiaExista(Companie c){
        TypedQuery<Companie> q = entityManager.createQuery("SELECT o FROM Destinatar AS o WHERE o.cui = :cui", Companie.class);
        q.setParameter("cui", c.getCui());
        
        return !q.getResultList().isEmpty();
	}
	public boolean persFizicaExpExista(PersoanaExpeditoare c){
        TypedQuery<Companie> q = entityManager.createQuery("SELECT o FROM PersoanaFizica AS o WHERE o.cnp = :cnp", Companie.class);
        q.setParameter("cnp", c.getCnp());
        
        return !q.getResultList().isEmpty();
	}
	
	public List<Comanda> getComenzi(){
		return entityManager.createQuery("SELECT o FROM Comanda o", Comanda.class).getResultList();
	}
	public  List<Pachet> getPachete(){
		return entityManager.createQuery("SELECT o FROM Pachet o", Pachet.class).getResultList();
	}
	public  List<Client> getClienti(){
		return entityManager.createQuery("SELECT o FROM Client o", Client.class).getResultList();
	}
	public  List<Companie> getCompanii(){
		return entityManager.createQuery("SELECT o FROM Companie o", Companie.class).getResultList();
	}
	@SuppressWarnings("unchecked")
	public  List<Destinatar> getDestinatari(){
		List<Destinatar> list = hibernateTools.getSession().createCriteria(Destinatar.class).list();
		return list;
	}
	public <T> void save(T obj){
		hibernateTools.save(obj);
	}
	
	public ResultSet getRS(String query) throws SQLException{
		return hibernateTools.getRs(query);
	}
}
