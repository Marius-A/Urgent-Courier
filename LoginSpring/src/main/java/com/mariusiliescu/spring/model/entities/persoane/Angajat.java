package com.mariusiliescu.spring.model.entities.persoane;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import com.mariusiliescu.spring.model.entities.Adresa;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Access(value=AccessType.FIELD)
public class Angajat extends Persoana {
	@Id
    @GeneratedValue
	@Column(name = "idAngajat")
	protected long idAngajat;
	
    @Column(name = "data_angajarii")
	protected Date dataAngajarii;
	
	public Angajat(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon,
			Date dataAngajarii) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon);
		this.setDataAngajarii(dataAngajarii);
	}
	
	public Angajat() {
		super();
		dataAngajarii = new Date();
	}

	public Angajat(Persoana a){
		super(a);
		//TODO auto increment ser reg
	}

	public Date getDataAngajarii() {
		return dataAngajarii;
	}

	public void setDataAngajarii(Date dataAngajarii) {
		this.dataAngajarii = dataAngajarii;
	}
}
