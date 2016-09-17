package com.mariusiliescu.model.entities;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "cursa")
public class Cursa {
	@Id
    @GeneratedValue
    @Column(name="cod_cursa")
	private long codCursa;
	private Time durataEstimativa;
	private Date dataPlecarii;
	private ArrayList<Ruta> listaRute;
	
	public Cursa(long codCursa, Time durataEstimativa, Date dataPlecarii, ArrayList<Ruta> listaRute) {
		this.codCursa = codCursa;
		this.durataEstimativa = durataEstimativa;
		this.dataPlecarii = dataPlecarii;
		this.listaRute = listaRute;
	}
	
	public Cursa() {
		this.codCursa = 0;
		this.durataEstimativa = new Time(0);
		this.dataPlecarii = new Date();
		this.listaRute = new ArrayList<Ruta>();
	}
	public long getCodCursa() {
		return codCursa;
	}

	public void setCodCursa(long codCursa) {
		this.codCursa = codCursa;
	}

	public Time getDurataEstimativa() {
		return durataEstimativa;
	}

	public void setDurataEstimativa(Time durataEstimativa) {
		this.durataEstimativa = durataEstimativa;
	}

	public Date getDataPlecarii() {
		return dataPlecarii;
	}

	public void setDataPlecarii(Date dataPlecarii) {
		this.dataPlecarii = dataPlecarii;
	}

	public ArrayList<Ruta> getListaRute() {
		return listaRute;
	}

	public void setListaRute(ArrayList<Ruta> listaRute) {
		this.listaRute = listaRute;
	}
}
