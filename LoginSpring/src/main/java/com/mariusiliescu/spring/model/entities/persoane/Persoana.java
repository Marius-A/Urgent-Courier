package com.mariusiliescu.spring.model.entities.persoane;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import com.mariusiliescu.spring.model.entities.Adresa;

@MappedSuperclass
public class Persoana {

    @Column(name = "person_id")
	protected String cnp;
	
	protected String nume;
	protected String prenume;
	
	@Embedded
	protected Adresa adresa;
	
	protected String eMail;
	protected String nrTelefon;
	
	public Persoana(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon) {
		this.cnp = cnp;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.eMail = eMail;
		this.nrTelefon = nrTelefon;
	}
	
	public Persoana(Persoana p){
		this.cnp = p.cnp;
		this.nume = p.nume;
		this.prenume = p.prenume;
		this.adresa = p.adresa;
		this.eMail = p.eMail;
		this.nrTelefon = p.nrTelefon;
	}
	
	public Persoana(){
		this.cnp = new String();
		this.nume = new String();
		this.prenume = new String();
		this.adresa = new Adresa();
		this.eMail = new String();
		this.nrTelefon = new String();
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getNrTelefon() {
		return nrTelefon;
	}

	public void setNrTelefon(String nrTelefon) {
		this.nrTelefon = nrTelefon;
	}
}
