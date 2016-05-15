package com.mariusiliescu.model.entities;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.mariusiliescu.model.entities.persoane.Client;


@Entity
@Table(name= "Companie")
@PrimaryKeyJoinColumn(name="id_client")
public class Companie extends Client {
	
	@Column(unique=true)
	private String cui;
	
	private String numeC;
	private String eMail;
	
	@Embedded
	private Adresa adresaC;
	private String nrTelefonC;
	
	public Companie(TipClient tipClient, String cui, String numeC, String eMail, Adresa adresaC,
			String nrTelefonC) {
		this.cui = cui;
		this.numeC = numeC;
		this.eMail = eMail;
		this.adresaC = adresaC;
		this.nrTelefonC = nrTelefonC;
		this.listaFacturi = new ArrayList<Factura>();
	}
	
	public Companie() {
		this.cui = new String();
		this.numeC = new String();
		this.eMail = new String();
		this.adresaC = new Adresa();
		this.nrTelefonC = new String();
	}


	public String getCui() {
		return cui;
	}


	public void setCui(String cui) {
		this.cui = cui;
	}


	public String getNumeC() {
		return numeC;
	}


	public void setNumeC(String numeC) {
		this.numeC = numeC;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public Adresa getAdresaC() {
		return adresaC;
	}


	public void setAdresaC(Adresa adresaC) {
		this.adresaC = adresaC;
	}


	public String getNrTelefonC() {
		return nrTelefonC;
	}


	public void setNrTelefonC(String nrTelefonC) {
		this.nrTelefonC = nrTelefonC;
	}

	@Override
	public String getNume() {
		return this.numeC;
	}

	@Override
	public String getPassword() {
		return this.cui.substring(cui.length()-6, cui.length());
	}

	@Override
	public Collection<Factura> getListaFacturi() {
		return this.listaFacturi;
	}

	@Override
	public void adaugareFactura(Factura f) {
		this.listaFacturi.add(f);
	}

	@Override
	public String getSSNCUI() {
		return cui;
	}
		
}
