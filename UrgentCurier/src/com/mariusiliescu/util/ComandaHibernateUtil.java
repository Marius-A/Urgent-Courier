package com.mariusiliescu.util;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
		
		
		hibernateTools.save(c.getExpeditor());
		Client cl = getClient(c.getExpeditor().getSSNCUI());
		for(Factura f : gasesteFacturi(cl))
			cl.adaugareFactura(f);
			
		c.setExpeditor(cl);
		
		
		//Comanda DBComanda = getComanda(c.getExpeditor().getSSNCUI());
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
		
		Factura f = new Factura(10.0,TMPReceptioner,c);
		f.getComanda().getExpeditor().adaugareFactura(f);
		
		hibernateTools.save(f);
		
		
		try {
			PDFBuilder.creareFactura(f);
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Companie gasesteCompanie(Long id) {
		hibernateTools.getSession().close();
		TypedQuery<Companie> q = entityManager.createQuery("SELECT o FROM Destinatar AS o WHERE o.ID_CLIENT = :ID_CLIENT", Companie.class);
        q.setParameter("ID_CLIENT",id);
        
        return q.getSingleResult();
    }
	@SuppressWarnings("unchecked")
	public Factura gasesteFactura(Comanda c) {
		hibernateTools.getSession().close();
		List<Factura> list = hibernateTools.getSession().createCriteria(Factura.class).list();
        for(Factura f : list){
        	if (f.getComanda().getCodComanda() == c.getCodComanda()){
        		return f;
        	}
        }
        return null;
    }
	@SuppressWarnings("unchecked")
	public Collection<Factura> gasesteFacturi(Client c) {
		List<Factura> listaFacturi = new ArrayList<>();
		hibernateTools.getSession().close();
		List<Factura> list = hibernateTools.getSession().createCriteria(Factura.class).list();
        for(Factura f : list){
        	if (f.getComanda().getExpeditor().getSSNCUI().equals(c.getSSNCUI())){
        		listaFacturi.add(f);
        	}
        }
        return listaFacturi;
    }
	@SuppressWarnings("unchecked")
	public Comanda getComanda(String ssncui){
		hibernateTools.getSession().close();
		List<Comanda> list = hibernateTools.getSession().createCriteria(Comanda.class).list();
		for (Comanda c : list){
			if(c.getExpeditor().getSSNCUI().equals(ssncui))
				return c;
		}
		return null;
	}
	public Client getClient(String cnpcui){
		hibernateTools.getSession().close();
		@SuppressWarnings("unchecked")
		List<Client> list = hibernateTools.getSession().createCriteria(Client.class).list();
		for (Client c : list){
			if(c.getSSNCUI().equals(cnpcui))
				return c;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public Receptioner getReceptioner(String cnp){
		hibernateTools.getSession().close();
		List<Receptioner> list = hibernateTools.getSession().createCriteria(Receptioner.class).list();
		for (Receptioner c : list){
			if(c.getCnp().equals(cnp))
				return c;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public  List<Destinatar> getDestinatari(){
		List<Destinatar> list = hibernateTools.getSession().createCriteria(Destinatar.class).list();
		return list;
	}

	public  Comanda getComanda(long idComanda){
		Comanda c = (Comanda) hibernateTools.getSession().get(Comanda.class, idComanda);
		return c;
	}
	public <T> void save(T obj){
		hibernateTools.save(obj);
	}
	
	public ResultSet getRS(String query) throws SQLException{
		return hibernateTools.getRs(query);
	}
}
