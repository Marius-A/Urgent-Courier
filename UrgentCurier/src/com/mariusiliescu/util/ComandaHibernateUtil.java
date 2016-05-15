package com.mariusiliescu.util;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.itextpdf.text.DocumentException;
import com.mariusiliescu.model.entities.Adresa;
import com.mariusiliescu.model.entities.Comanda;
import com.mariusiliescu.model.entities.Companie;
import com.mariusiliescu.model.entities.Factura;
import com.mariusiliescu.model.entities.Pachet;
import com.mariusiliescu.model.entities.persoane.Client;
import com.mariusiliescu.model.entities.persoane.Destinatar;
import com.mariusiliescu.model.entities.persoane.PersoanaExpeditoare;
import com.mariusiliescu.model.entities.persoane.Receptioner;

public class ComandaHibernateUtil {
	
	@PersistenceContext
	EntityManager entityManager;
	
	HibernateTools hibernateTools = new HibernateTools();
	
	public void addComanda(Comanda c){
		List<Destinatar> listaDestinatariExistenti = getDestinatari();
		List<Destinatar> listaDestinatariInserati = new ArrayList<>();
		for(Pachet p : c.getListaPachete()){
			if(listaDestinatariExistenti.isEmpty()){
				if(!listaDestinatariInserati.contains(p.getDestinatar()))
					listaDestinatariInserati.add(p.getDestinatar());
			}else{
				for(Destinatar d : listaDestinatariExistenti){
					if(!d.getCnp().equals(p.getDestinatar().getCnp())){
						listaDestinatariInserati.add(p.getDestinatar());
					}
				}
			}
		}
		for(Destinatar d : listaDestinatariInserati)
			hibernateTools.save(d);
		
		hibernateTools.save(c);
		
		Comanda DBComanda = getComanda(c.getExpeditor().getSSNCUI());
		@SuppressWarnings("deprecation")
		Receptioner re = new Receptioner("19423412541225", "Dan", 
				"Ion ", new Adresa(), "danion@uc.com", "0752312541", new Date(2000, 4, 6));
		
		Receptioner TMPReceptioner = re;
		if(getReceptioner(re.getCnp()) == null){
			hibernateTools.save(TMPReceptioner);
			TMPReceptioner = getReceptioner(re.getCnp());
		}else{
			TMPReceptioner = getReceptioner(re.getCnp());
		}
		
		
		Factura f = new Factura(10.0,TMPReceptioner,DBComanda);
		//hibernateTools.save(f);
		
		
		try {
			PDFBuilder.creareFactura(f);
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Companie gasesteCompanie(Long id) {
		TypedQuery<Companie> q = entityManager.createQuery("SELECT o FROM Destinatar AS o WHERE o.ID_CLIENT = :ID_CLIENT", Companie.class);
        q.setParameter("ID_CLIENT",id);
        
        return q.getSingleResult();
    }
	@SuppressWarnings("unchecked")
	public Comanda getComanda(String ssncui){
		List<Comanda> list = hibernateTools.getSession().createCriteria(Comanda.class).list();
		hibernateTools.getSession().close();
		for (Comanda c : list){
			if(c.getExpeditor().getSSNCUI().equals(ssncui))
				return c;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public Receptioner getReceptioner(String cnp){
		List<Receptioner> list = hibernateTools.getSession().createCriteria(Receptioner.class).list();
		hibernateTools.getSession().close();
		for (Receptioner c : list){
			if(c.getCnp().equals(cnp))
				return c;
		}
		return null;
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

	public  Comanda getComanda(long idComanda){
		Comanda c = (Comanda) hibernateTools.getSession().get(Comanda.class, idComanda);
		hibernateTools.closeSessionFactory();
		return c;
	}
	public <T> void save(T obj){
		hibernateTools.save(obj);
	}
	
	public ResultSet getRS(String query) throws SQLException{
		return hibernateTools.getRs(query);
	}
}
