package ro.go.mariusiliescu.entities;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.persoane.Angajat;


@Entity
@Table(name= "Sediu")
public class Sediu {
	@Id
    @GeneratedValue
    @Column(name="ID_SEDIU")
	private long idSediu;
	
	private Adresa adresa;
	private ArrayList<Vehicul> listaVehicule;
	private ArrayList<Angajat> listaAngajati;
	
	public Sediu(long idSediu, Adresa adresa, ArrayList<Vehicul> listaVehicule, ArrayList<Angajat> listaAngajati) {
		this.idSediu = idSediu;
		this.adresa = adresa;
		this.listaVehicule = listaVehicule;
		this.listaAngajati = listaAngajati;
	}

	public long getIdSediu() {
		return idSediu;
	}

	public void setIdSediu(long idSediu) {
		this.idSediu = idSediu;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public ArrayList<Vehicul> getListaVehicule() {
		return listaVehicule;
	}

	public void setListaVehicule(ArrayList<Vehicul> listaVehicule) {
		this.listaVehicule = listaVehicule;
	}

	public ArrayList<Angajat> getListaAngajati() {
		return listaAngajati;
	}

	public void setListaAngajati(ArrayList<Angajat> listaAngajati) {
		this.listaAngajati = listaAngajati;
	}
}
