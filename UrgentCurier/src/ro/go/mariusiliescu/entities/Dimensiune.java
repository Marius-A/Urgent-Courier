package ro.go.mariusiliescu.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.PROPERTY)
public class Dimensiune {
	private float inaltime;
	private float latime;
	private float lungime;
	
	public Dimensiune(float inaltime, float latime, float lungime) {
		super();
		this.inaltime = inaltime;
		this.latime = latime;
		this.lungime = lungime;
	}
	public Dimensiune(){
		this.inaltime =0;
		this.latime = 0;
		this.lungime = 0;
	}

	public float getInaltime() {
		return inaltime;
	}

	public void setInaltime(float inaltime) {
		this.inaltime = inaltime;
	}

	public float getLatime() {
		return latime;
	}

	public void setLatime(float latime) {
		this.latime = latime;
	}

	public float getLungime() {
		return lungime;
	}

	public void setLungime(float lungime) {
		this.lungime = lungime;
	}
}
