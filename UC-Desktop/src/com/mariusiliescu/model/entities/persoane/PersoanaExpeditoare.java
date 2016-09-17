package com.mariusiliescu.model.entities.persoane;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.mariusiliescu.model.entities.Adresa;


@Entity
@Table(name="persoana_expeditoare")
@PrimaryKeyJoinColumn(name="id_client")
public class PersoanaExpeditoare extends Persoana{
	@Id
	@GeneratedValue
	private long peId;
	public PersoanaExpeditoare(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon);
		// TODO Auto-generated constructor stub
	}
	
	public PersoanaExpeditoare() {
		super();
		// TODO Auto-generated constructor stub
	}

}
