package ro.go.mariusiliescu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.persoane.Receptioner;

@Entity
@Table(name= "FACTURA")
public class Factura {
	enum StatusFactura{
		platita,
		neplatita,
		inCurs
	};
	@Id
    @GeneratedValue
    @Column(name="COD_FACTURA")
	private long codFactura;
	
	@Column(name="VALOARE_TOTALA")
	private Double valoareTotala;
	
	@Column(name="VALOARE_DISCOUNT")
	private Double valoareDiscount;
	
	@Column(name="VALOARE_EVECTIVA")
	private Double valoareEfectiva;
	
	@ManyToOne
	@JoinColumn(name="ID_ANGAJAT")
	private Receptioner intemeietor;
	
	@OneToOne
    @JoinColumn(name = "COD_COMANDA")
	private Comanda comanda;
	
	public Factura(long codFactura, Double valoareTotala, Double valoareDiscount, Double valoareEfectiva,
			Receptioner intemeietor, Comanda comanda) {
		super();
		this.codFactura = codFactura;
		this.valoareTotala = valoareTotala;
		this.valoareDiscount = valoareDiscount;
		this.valoareEfectiva = valoareEfectiva;
		this.intemeietor = intemeietor;
		this.comanda = comanda;
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
}
