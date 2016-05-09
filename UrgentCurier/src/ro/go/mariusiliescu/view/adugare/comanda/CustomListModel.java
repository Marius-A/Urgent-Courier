package ro.go.mariusiliescu.view.adugare.comanda;

import java.util.HashSet;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import ro.go.mariusiliescu.Model;
import ro.go.mariusiliescu.entities.Pachet;

@SuppressWarnings("serial")
public class CustomListModel extends DefaultListModel<Pachet>{
	
	public CustomListModel(Model prod) {
		HashSet<Pachet> listPach = (HashSet<Pachet>) prod.getListaPachete();
		Iterator<Pachet> iter = listPach.iterator();
		while(iter.hasNext()){
			Pachet p = new Pachet(iter.next());
			addElement(p);
		}
	}
}
