package com.mariusiliescu.spring.model.entities.persoane;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.mariusiliescu.spring.model.entities.Adresa;


@Entity
@Access(value=AccessType.FIELD)
public class Destinatar extends Persoana {
	@Id
	@GeneratedValue
	private long idDestinatar;
	
	public Destinatar(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon );
	}
	public Destinatar() {
		super();
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
