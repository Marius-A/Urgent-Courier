package ro.go.mariusiliescu.entities.persoane;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.Adresa;
import ro.go.mariusiliescu.entities.LoginData;

@Entity
@Table(name= "Receptioner")
@PrimaryKeyJoinColumn(name="ID_ANGAJAT")
public class Receptioner extends Angajat {

	@Embedded
	LoginData data;
	
	public Receptioner(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon,
			Date dataAngajarii) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon, dataAngajarii);
	}

	
	public Receptioner(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon,
			Date dataAngajarii , LoginData data) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon, dataAngajarii);
		this.data = data;
	}
	
	
	public Receptioner(Angajat a) {
		super(a);
	}
	
	
	public LoginData getLoginData(){
		return this.data;
	}
}
