package com.mariusiliescu.spring.model.entities;

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
    @Column(name="cod_ruta")
	private long cod_ruta;
	
	@Embedded
	private Adresa destinatie;
	
    @Column(name="distanta")
	private Double distanta;//km
	
	public Ruta(Adresa punctPlecare, Adresa destinatie, Double distanta) {
		super();
		this.destinatie = destinatie;
		this.distanta = distanta;
	}
	
	public Ruta() {
		super();
		this.destinatie = new Adresa();
		this.distanta = 0.0;
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
