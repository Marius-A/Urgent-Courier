package ro.go.mariusiliescu.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.PROPERTY)
public class Adresa {
	private String tara;
	private String judet;
	private String localitate;
	private String strada;
	private String numar;
	private String bloc;
	private String apartament;
	private String scara;
	
	public Adresa(String tara, String judet, String localitate, String strada, String numar, String bloc, String scara,
			String apartament) {
		this.tara = tara;
		this.judet = judet;
		this.localitate = localitate;
		this.strada = strada;
		this.numar = numar;
		this.bloc = bloc;
		this.scara = scara;
		this.apartament = apartament;
	}
	public Adresa() {
		this.tara = new String();
		this.judet = new String();
		this.localitate = new String();
		this.strada = new String();
		this.numar = new String();
		this.bloc = new String();
		this.scara = new String();
		this.apartament = new String();
	}
	public Adresa(Adresa a){
		this.tara = a.tara;
		this.judet = a.judet;
		this.localitate = a.localitate;
		this.strada = a.strada;
		this.numar = a.numar;
		this.bloc = a.bloc;
		this.scara = a.scara;
		this.apartament = a.apartament;
	}
	
	public String getTara() {
		return tara;
	}
	public void setTara(String tara) {
		this.tara = tara;
	}
	public String getJudet() {
		return judet;
	}
	public void setJudet(String judet) {
		this.judet = judet;
	}
	public String getLocalitate() {
		return localitate;
	}
	public void setLocalitate(String localitate) {
		this.localitate = localitate;
	}
	public String getStrada() {
		return strada;
	}
	public void setStrada(String strada) {
		this.strada = strada;
	}
	public String getNumar() {
		return numar;
	}
	public void setNumar(String numar) {
		this.numar = numar;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	public String getApartament() {
		return apartament;
	}
	public void setApartament(String apartament) {
		this.apartament = apartament;
	}
	public String getScara() {
		return scara;
	}
	public void setScara(String scara) {
		this.scara = scara;
	}
}
