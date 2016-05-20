package com.mariusiliescu.spring.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariusiliescu.spring.dao.ClientDao;
import com.mariusiliescu.spring.model.entities.persoane.Client;

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
	
	public void adaugareFacturi(){
		clientDao.adaugareFacturi();
	}
}
