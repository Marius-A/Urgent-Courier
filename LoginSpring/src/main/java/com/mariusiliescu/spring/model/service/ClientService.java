package com.mariusiliescu.spring.model.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariusiliescu.spring.dao.ClientDao;
import com.mariusiliescu.spring.model.entities.Adresa;
import com.mariusiliescu.spring.model.entities.Comanda;
import com.mariusiliescu.spring.model.entities.Companie;
import com.mariusiliescu.spring.model.entities.Dimensiune;
import com.mariusiliescu.spring.model.entities.Factura;
import com.mariusiliescu.spring.model.entities.Pachet;
import com.mariusiliescu.spring.model.entities.SpecialConditions;
import com.mariusiliescu.spring.model.entities.StarePachet;
import com.mariusiliescu.spring.model.entities.TipClient;
import com.mariusiliescu.spring.model.entities.persoane.Client;
import com.mariusiliescu.spring.model.entities.persoane.Destinatar;
import com.mariusiliescu.spring.model.entities.persoane.Receptioner;

@Service
public class ClientService {
	
	@Autowired
	private ClientDao clientDao = new ClientDao();
	
	public long countAllClients() {
        return clientDao.countClients();
    }

	public void deleteClient(Client Client) {
		clientDao.remove(Client);
    }

	public Client findClient(Long id) {
        return clientDao.findClient(id);
    }
	
	public Client findClient(String name) {;
		Client c = null;
		try{
			c= clientDao.findClientsByNameEquals(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
    }

	public List<Client> findAllClients() {
        return clientDao.findAllClients();
    }

	public List<Client> findClientEntries(int firstResult, int maxResults) {
        return clientDao.findClientEntries(firstResult, maxResults);
    }

	public void saveClient(Client Client) {
		clientDao.persist(Client);
    }

	public Client updateClient(Client Client) {
        return clientDao.merge(Client);
    }

	public Client loginClient(String userId, String password) {
		Client Client = this.findClient(userId);
		
		if(Client == null)
			return null;
		if (Client != null && Client.getPassword().equals(password)) {
			return Client;
		}
		return null;
	}
	
	public Client getTmpClient(){
		
		Client cl = new Companie(TipClient.fidel,"123542135123456","emag","emaag@tcvufc.ro",new Adresa("Romania", "Dolj","Craiova","Gheorghe Turdu","7", "-","-","-"),"0752132451");
		
		Destinatar d1 = new Destinatar("1945213254122", "Matei", "Marius", new Adresa(), "ddd", "0752123561");
		Destinatar d2 = new Destinatar("1902545232541", "Ion", "Dan", new Adresa(), "ddd", "0752123561");
		Destinatar d3 = new Destinatar("1845236525540", "Vasile", "Florin", new Adresa(), "ddd", "0752123561");
		
		
		HashSet<Pachet> pac1 = new HashSet<Pachet>();
		HashSet<Pachet> pac2 = new HashSet<Pachet>();
		Pachet p1 = new Pachet(250,
				new Dimensiune(),SpecialConditions.fragile, StarePachet.inCursDeExpediere
				, d3);
		p1.setCodPachet(6165163);
		Pachet p2 = new Pachet(190,
				new Dimensiune(),SpecialConditions.precious, StarePachet.inCursDeExpediere
				, d1);
		p2.setCodPachet(54478521);
		Pachet p3 = new Pachet(350,
				new Dimensiune(),SpecialConditions.dangerous, StarePachet.inCursDeExpediere
				, d2);
		p3.setCodPachet(12356412);
		
		pac1.add(p1);
		pac1.add(p2);
		
		pac2.add(p1);
		pac2.add(p3);
		pac2.add(p2);
		
		Comanda c1 = new Comanda(new Date(),
				new Date(), 205, pac1, cl);
		
		Comanda c2 = new Comanda(new Date(),
				new Date(), 327, pac2, cl);
		
		for(Pachet pac : c1.getListaPachete())
			pac.setComanda(c1);
		for(Pachet pac : c2.getListaPachete())
			pac.setComanda(c2);
		
		
		Factura f1 = new Factura(0.2,
				new Receptioner("19246523158", "Ion", "Matei", new Adresa(),
						"csd@#sdcsd.com", "0545454545", new Date()) , c1);
		f1.setCodFactura(255124124);
		
		Factura f2 = new Factura(0.1,
				new Receptioner("4546626595", "Dan", "Ion", new Adresa(),
						"csd@#sdcsd.com", "0545454545", new Date()) , c2);
		f2.setCodFactura(542105214);
		
		
		return cl;
	}
}
