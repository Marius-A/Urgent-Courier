package ro.go.mariusiliescu.entities.persoane;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.Adresa;

@Entity
@Table(name= "Destinatari")
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class Destinatar extends Persoana {
		
	public Destinatar(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon );
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnp == null) ? 0 : cnp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destinatar other = (Destinatar) obj;
		if (cnp == null) {
			if (other.cnp != null)
				return false;
		} else if (!cnp.equals(other.cnp))
			return false;
		return true;
	}


}
