package ro.go.mariusiliescu.entities.persoane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ro.go.mariusiliescu.entities.CategoriPermise;

@Entity
@Table(name="CURIER")
@PrimaryKeyJoinColumn(name="ID_ANGAJAT")
public class Curier extends Angajat{
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIP_PERMIS_DE_CONDUCERE")
	private CategoriPermise tipPermisDetinut;
	
	@Column(name = "ANI_EXP")
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
	
	
	public int getAniExp() {
		return aniExp;
	}

	public void setAniExp(int aniExp) {
		this.aniExp = aniExp;
	}
}
