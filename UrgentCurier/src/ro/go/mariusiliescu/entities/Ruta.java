package ro.go.mariusiliescu.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "RUTA")
public class Ruta {
	
	@Id
    @GeneratedValue
    @Column(name="COD_RUTA")
	private long cod_ruta;
	
	@Embedded
	private Adresa destinatie;
	
    @Column(name="DISTANTA")
	private Double distanta;//km
	
	public Ruta(Adresa punctPlecare, Adresa destinatie, Double distanta) {
		super();
		this.destinatie = destinatie;
		this.distanta = distanta;
	}

	public Adresa getDestinatie() {
		return destinatie;
	}

	public void setDestinatie(Adresa destinatie) {
		this.destinatie = destinatie;
	}

	public Double getDistanta() {
		return distanta;
	}

	public void setDistanta(Double distanta) {
		this.distanta = distanta;
	}
	
}
