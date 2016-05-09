package ro.go.mariusiliescu.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.persoane.Client;

@Entity
@Table(name="COMANDA")
public class Comanda {
	
    @Id @GeneratedValue
    @Column(name = "COD_COMANDA")
	private long codComanda;
    
    @Column(name = "NUMAR_PRODUSE")
	private int numarProduse;
    
    @Column(name = "DATA_PRELUARE")
	private Date dataPreluare;
    
    @Column(name = "DATA_EXPEDIERE")
	private Date dataExpediere;
    
    @Column(name = "COST_TRANSPORT")
	private float costTransport;
	
	@OneToMany(mappedBy="comanda" , cascade=CascadeType.ALL)
	private Set<Pachet> listaPachete;
	
	@ManyToOne
    @JoinColumn(name="ID_CLIENT")
	private Client expeditor;
	
	
	/*//quaternar bound
	private Set<Vehicul> listaVehivule;
	private Set<Ruta> listaRute;
	private Set<Curier> listaCurieri;*/
	
	
	public Comanda(Date dataPreluare, Date dataExpediere, float costTransport,
			Set<Pachet> listaPachete, Client expeditor) {
		super();
		this.dataPreluare = dataPreluare;
		this.dataExpediere = dataExpediere;
		this.costTransport = costTransport;
		this.listaPachete = listaPachete;
		this.expeditor = expeditor;
		this.numarProduse = listaPachete.size();
	}

	
	public Set<Pachet> getListaPachete() {
		return listaPachete;
	}


	public long getCodComanda() {
		return codComanda;
	}

	public void setCodComanda(long codComanda) {
		this.codComanda = codComanda;
	}

	public int getNumarProduse() {
		return numarProduse;
	}

	public void setNumarProduse(int numarProduse) {
		this.numarProduse = numarProduse;
	}

	public Date getDataPreluare() {
		return dataPreluare;
	}

	public void setDataPreluare(Date dataPreluare) {
		this.dataPreluare = dataPreluare;
	}

	public Date getDataExpediere() {
		return dataExpediere;
	}

	public void setDataExpediere(Date dataExpediere) {
		this.dataExpediere = dataExpediere;
	}

	public float getCostTransport() {
		return costTransport;
	}

	public void setCostTransport(float costTransport) {
		this.costTransport = costTransport;
	}

	public Client getExpeditor() {
		return expeditor;
	}

	public void setExpeditor(Client expeditor) {
		this.expeditor = expeditor;
	}
}
