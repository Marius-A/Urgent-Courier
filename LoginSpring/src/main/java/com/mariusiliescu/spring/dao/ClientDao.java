package com.mariusiliescu.spring.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mariusiliescu.spring.model.entities.Adresa;
import com.mariusiliescu.spring.model.entities.Comanda;
import com.mariusiliescu.spring.model.entities.Companie;
import com.mariusiliescu.spring.model.entities.Dimensiune;
import com.mariusiliescu.spring.model.entities.Factura;
import com.mariusiliescu.spring.model.entities.Pachet;
import com.mariusiliescu.spring.model.entities.SpecialConditions;
import com.mariusiliescu.spring.model.entities.StarePachet;
import com.mariusiliescu.spring.model.entities.persoane.Client;
import com.mariusiliescu.spring.model.entities.persoane.Destinatar;
import com.mariusiliescu.spring.model.entities.persoane.Receptioner;

@Repository("DBRepository")
public class ClientDao {

	@PersistenceContext
	EntityManager entityManager;

	
	public long countClients() {
        return entityManager.createQuery("SELECT COUNT(o) FROM client o", Long.class).getSingleResult();
    }

	public List<Client> findAllClients() {
        return entityManager.createQuery("SELECT o FROM Client o", Client.class).getResultList();
    }
	public List<Comanda> gasesteComenzile() {
        return entityManager.createQuery("SELECT o FROM Comanda o", Comanda.class).getResultList();
    }
	public Client findClient(Long id) {
        if (id == null) return null;
        return entityManager.find(Client.class, id);
    }

	public List<Client> findClientEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM Client o", Client.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist(Client Client) {
        this.entityManager.persist(Client);
    }

	@Transactional
    public void remove(Client Client) {
        if (this.entityManager.contains(Client)) {
            this.entityManager.remove(Client);
        } else {
            Client attached = findClient(Client.getId());
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        this.entityManager.clear();
    }

	@Transactional
    public Client merge(Client Client) {
        Client merged = entityManager.merge(Client);
        this.entityManager.flush();
        return merged;
    }
	
	public List<Factura> gasesteFactura(long idClient) {
      
        TypedQuery<Factura> q1 = entityManager.createQuery("SELECT o FROM Factura AS o, Comanda AS c WHERE  o.codcomanda =c.codcomanda and c.id_client =:id", Factura.class);
        q1.setParameter("id", idClient);
        
        List<Factura> c = new ArrayList<Factura>();
        try {
            c=q1.getResultList();
		} catch (Exception e) {
			System.out.println("error");
		}
        
        //TODO if c == null -> there is no company with that name , .... check if is a person
        
        return c;
    }
	
	public Client findClientsByNameEquals(String name) {
 
        List<Comanda> listC = gasesteComenzile();
        TypedQuery<Companie> q1 = entityManager.createQuery("SELECT o FROM Companie AS o , Client as c WHERE  o.idClient= c.idClient  AND o.numeC = :name", Companie.class);
        q1.setParameter("name", name);
        
        Client c =null;
        try {
            c=q1.getSingleResult();
            for(Factura f:gasesteFactura(c.getId())){
            	c.adaugareFactura(f);
            }
		} catch (Exception e) {
			System.out.println("error");
		}
        
        //TODO if c == null -> there is no company with that name , .... check if is a person
        
        return c;
    }
}