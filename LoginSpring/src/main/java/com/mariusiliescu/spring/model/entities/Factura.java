package com.mariusiliescu.spring.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mariusiliescu.spring.model.entities.persoane.Receptioner;


@Entity
@Table(name= "factura")
public class Factura {
	enum StatusFactura{
		platita,
		neplatita,
		inCurs
	};
	@Id
    @GeneratedValue
    @Column(name="cod_factura")
	private long codFactura;
	
	@Column(name="valoare_totala")
	private Double valoareTotala;
	
	@Column(name="valoare_disount")
	private Double valoareDiscount;
	
	@Column(name="valoare_efectiva")
	private Double valoareEfectiva;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idAngajat")
	private Receptioner intemeietor;
		
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codcomanda")
	private Comanda comanda;
	
	
	
	
	
	public Factura(Double valoareDiscount,
			Receptioner intemeietor, Comanda comanda) {
		super();
		this.valoareEfectiva = (double) comanda.getCostTransport();
		this.valoareTotala = valoareEfectiva-(valoareDiscount*valoareEfectiva);
		this.valoareDiscount = valoareDiscount;
		this.intemeietor = intemeietor;
		this.comanda = comanda;
		this.comanda.getExpeditor().adaugareFactura(this);
	}
	
	public Factura() {
		super();
		this.codFactura = 0;
		this.valoareTotala = 0.0;
		this.valoareDiscount = 0.0;
		this.valoareEfectiva = 0.0;
		this.intemeietor = new Receptioner();
		this.comanda = new Comanda();
	}

	public long getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(long codFactura) {
		this.codFactura = codFactura;
	}

	public Double getValoareTotala() {
		return valoareTotala;
	}

	public void setValoareTotala(Double valoareTotala) {
		this.valoareTotala = valoareTotala;
	}

	public Double getValoareDiscount() {
		return valoareDiscount;
	}

	public void setValoareDiscount(Double valoareDiscount) {
		this.valoareDiscount = valoareDiscount;
	}

	public Double getValoareEfectiva() {
		return valoareEfectiva;
	}

	public void setValoareEfectiva(Double valoareEfectiva) {
		this.valoareEfectiva = valoareEfectiva;
	}

	public Receptioner getIntemeietor() {
		return intemeietor;
	}

	public void setIntemeietor(Receptioner intemeietor) {
		this.intemeietor = intemeietor;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	@Override
	public String toString() {
		return "codFactura=" + codFactura + ", valoareTotala=" + valoareTotala + ", valoareDiscount="
				+ valoareDiscount + ", valoareEfectiva=" + valoareEfectiva + ", intemeietor=" + intemeietor.getNume() +"  "+intemeietor.getPrenume()+
				", Cod comanda " + comanda.getCodComanda() + "  "+comanda.getNumarProduse()+" pachete";
	}
	
	
}
