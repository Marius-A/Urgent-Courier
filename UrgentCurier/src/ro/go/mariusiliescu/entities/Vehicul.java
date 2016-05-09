package ro.go.mariusiliescu.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICUL")
public class Vehicul {
	
	enum StareTehnica{
		noua,
		nevoieReparatiiMinore,
		pentruCasare
	};
    @Id @GeneratedValue
    @Column(name = "cod_vehicul")
	private long codVehicul;
    
	private String numarInmatriculare;
	
	@Enumerated(EnumType.STRING)
	private StareTehnica stareTehnica;
	private float capacitate;
	private float consumMediu;
	
	public Vehicul(long codVehicul, String numarInmatriculare, StareTehnica stareTehnica, float capacitate,
			float consumMediu) {
		this.codVehicul = codVehicul;
		this.numarInmatriculare = numarInmatriculare;
		this.stareTehnica = stareTehnica;
		this.capacitate = capacitate;
		this.consumMediu = consumMediu;
	}

	public long getCodVehicul() {
		return codVehicul;
	}

	public void setCodVehicul(long codVehicul) {
		this.codVehicul = codVehicul;
	}

	public String getNumarInmatriculare() {
		return numarInmatriculare;
	}

	public void setNumarInmatriculare(String numarInmatriculare) {
		this.numarInmatriculare = numarInmatriculare;
	}

	public StareTehnica getStareTehnica() {
		return stareTehnica;
	}

	public void setStareTehnica(StareTehnica stareTehnica) {
		this.stareTehnica = stareTehnica;
	}

	public float getCapacitate() {
		return capacitate;
	}

	public void setCapacitate(float capacitate) {
		this.capacitate = capacitate;
	}

	public float getConsumMediu() {
		return consumMediu;
	}

	public void setConsumMediu(float consumMediu) {
		this.consumMediu = consumMediu;
	}
}
