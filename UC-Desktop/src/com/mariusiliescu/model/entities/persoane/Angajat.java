package com.mariusiliescu.model.entities.persoane;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.mariusiliescu.model.entities.Adresa;


@Entity
@Table(name = "angajat")
@Inheritance(strategy=InheritanceType.JOINED)
public class Angajat extends Persoana {
	@Id
    @GeneratedValue
	@Column(name = "idAngajat")
   // @AttributeOverride(name = "person_id", column = @Column(name = "id_angajat"))
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
