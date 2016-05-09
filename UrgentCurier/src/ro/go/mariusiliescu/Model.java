package ro.go.mariusiliescu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ro.go.mariusiliescu.entities.Comanda;
import ro.go.mariusiliescu.entities.Pachet;
/**
 * 
 * @author Marius Iliescu
 * Aceasta clasa reprezinta modelul aplicatiei
 *
 */
public class Model {

	private Set<Comanda> listaComenzi;
	private Set<Pachet> listaPachete;
	
	public Model() {
		listaComenzi = new HashSet<>();
		listaPachete = new HashSet<>();
	}
	/**
	 * Adaugare pachet
	 * @param p 
	 */
	public void adaugarePachet(Pachet p){
		listaPachete.add(p);
	}
	/**
	 * Adaugare lista pachete
	 * @param pachete 
	 */
	public void adaugareListaPachet(ArrayList<Pachet> pachete){
		for(Pachet p : pachete)
			listaPachete.add(p);
	}
	/**
	 * Adaugare comanda
	 * @param c
	 */
	public void adaugareComanda(Comanda c){
		listaComenzi.add(c);
	}
	/**
	 * Getter
	 * @return lista comenzi
	 */
	public Set<Comanda> getListaComenzi() {
		return listaComenzi;
	}
	/**
	 * Getter
	 * @return lista pachete
	 */
	public Set<Pachet> getListaPachete() {
		return listaPachete;
	}
	
	
	
}
