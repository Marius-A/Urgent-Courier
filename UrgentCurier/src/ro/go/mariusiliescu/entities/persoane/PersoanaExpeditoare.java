package ro.go.mariusiliescu.entities.persoane;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.Adresa;

@Entity
@Table(name="Persoana_Expeditoare")
@PrimaryKeyJoinColumn(name="ID_CLIENT")
public class PersoanaExpeditoare extends Persoana{

	public PersoanaExpeditoare(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon);
		// TODO Auto-generated constructor stub
	}

}
