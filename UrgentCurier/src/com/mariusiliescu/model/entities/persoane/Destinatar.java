package com.mariusiliescu.model.entities.persoane;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.mariusiliescu.model.entities.Adresa;


@Entity
@Table(name= "destinatar")
public class Destinatar extends Persoana {
	@Id
	@GeneratedValue
	private long idDestinatar;
   /* @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_SEQ_POJO_ONE")
	@Column(name = "id_destinatar")
    @AttributeOverride(name = "person_id", column = @Column(name = "id_destinatar"))
	protected long idDestinatar;*/
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
