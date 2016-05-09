package ro.go.mariusiliescu.util;

import ro.go.mariusiliescu.entities.Comanda;
import ro.go.mariusiliescu.entities.Companie;
import ro.go.mariusiliescu.entities.Pachet;
import ro.go.mariusiliescu.entities.persoane.Client;
import ro.go.mariusiliescu.entities.persoane.Destinatar;
import ro.go.mariusiliescu.entities.persoane.PersoanaExpeditoare;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


public class ComandaHibernateUtil {
	
	@PersistenceContext
	EntityManager entityManager;
	
	HibernateTools hibernateTools = new HibernateTools();
	
	public void addComanda(Comanda c){
		for(Pachet p : c.getListaPachete()){
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
		/*if(c.getExpeditor() instanceof PersoanaExpeditoare){
			if(!persFizicaExpExista((PersoanaExpeditoare)c.getExpeditor())){
				hibernateTools.save((PersoanaExpeditoare)c.getExpeditor());//salvam persoana fizica expeditoare
			}
		}*/
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
	public  List<Destinatar> getDestinatari(){
		return entityManager.createQuery("SELECT o FROM Destinatar o", Destinatar.class).getResultList();
	}
	public <T> void save(T obj){
		hibernateTools.save(obj);
	}
}
