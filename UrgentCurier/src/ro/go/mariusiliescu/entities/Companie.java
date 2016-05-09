package ro.go.mariusiliescu.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.persoane.Client;

@Entity
@Table(name= "COMPANIE")
@PrimaryKeyJoinColumn(name="ID_CLIENT")
public class Companie extends Client {

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
		
}
