package com.mariusiliescu.spring.model.entities.persoane;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.mariusiliescu.spring.model.entities.Factura;
import com.mariusiliescu.spring.model.entities.TipClient;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Client {
	
	@Id
    @GeneratedValue
    @Column(name="id_client")
	protected long idClient=0;
	
	@Enumerated(EnumType.STRING)
	protected TipClient tipClient = TipClient.nou;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "cod_factura")
	protected Collection<Factura> listaFacturi = new ArrayList<Factura>();
	
	public long getId(){
		return idClient;
	}
	
	public abstract String getNume();
	
	public abstract String getSSNCUI();
	
	public abstract String getPassword();
	
	public abstract void adaugareFactura(Factura f);
	
	public abstract Collection<Factura> getListaFacturi();
	
	
	
}
