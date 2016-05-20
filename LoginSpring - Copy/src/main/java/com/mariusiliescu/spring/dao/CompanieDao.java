package com.mariusiliescu.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mariusiliescu.spring.model.entities.Companie;

@Repository
public class CompanieDao {

	@PersistenceContext
    private EntityManager entityManager;
     
	public long countCompanies() {
        return entityManager.createQuery("SELECT COUNT(o) FROM Client o", Long.class).getSingleResult();
    }

	public List<Companie> findAllCompanies() {
        return entityManager.createQuery("SELECT o FROM Companie o", Companie.class).getResultList();
    }

	public Companie findCompany(Long id) {
        if (id == null) return null;
        return entityManager.find(Companie.class, id);
    }

	public List<Companie> findCompanyEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM Companie o", Companie.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	@Transactional
    public void persist(Companie Companie) {
        this.entityManager.persist(Companie);
    }

	@Transactional
    public void remove(Companie Companie) {
        if (this.entityManager.contains(Companie)) {
            this.entityManager.remove(Companie);
        } else {
        	Companie attached = findCompany(Companie.getId());
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
    public Companie merge(Companie Companie) {
		Companie merged = entityManager.merge(Companie);
        this.entityManager.flush();
        return merged;
    }
	
	public TypedQuery<Companie> findCompanysByNameEquals(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        TypedQuery<Companie> q = entityManager.createQuery("SELECT o FROM Companie AS o WHERE o.nameC = :name", Companie.class);
        q.setParameter("name", name);
        
        return q;
    }
}
