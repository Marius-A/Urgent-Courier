package com.mariusiliescu.model.entities.persoane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.mariusiliescu.model.entities.CategoriPermise;


@Entity
@Table(name="curier")
@PrimaryKeyJoinColumn(name="id_angajat")
public class Curier extends Angajat{
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tip_permis_de_conducere")
	private CategoriPermise tipPermisDetinut;
	
	@Column(name = "ani_exp")
	private int aniExp;
	
	/*@OneToMany(mappedBy="codPachet")
	private Set<Pachet> listaPachete;
	
	public Curier(String cnp, String nume, String prenume, Adresa adresa, String eMail, String nrTelefon,
			Date dataAngajarii , CategoriPermise tipPermis , int aniExp) {
		super(cnp, nume, prenume, adresa, eMail, nrTelefon, dataAngajarii);
		this.tipPermisDetinut = tipPermis;
		this.aniExp = aniExp;
	}
	*/
	public Curier(Curier c) {
		super(c.cnp, c.nume, c.prenume, c.adresa, c.eMail, c.nrTelefon, c.dataAngajarii);
		this.tipPermisDetinut = c.tipPermisDetinut;
		this.aniExp = c.aniExp;
	}
	
	public Curier() {
		super();
		this.tipPermisDetinut = CategoriPermise.None;
		this.aniExp = 0;
	}
	
	
	public int getAniExp() {
		return aniExp;
	}

	public void setAniExp(int aniExp) {
		this.aniExp = aniExp;
	}
}
