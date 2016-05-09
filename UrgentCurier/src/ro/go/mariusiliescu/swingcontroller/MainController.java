package ro.go.mariusiliescu.swingcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

import ro.go.mariusiliescu.Model;
import ro.go.mariusiliescu.entities.Comanda;
import ro.go.mariusiliescu.util.ComandaHibernateUtil;
import ro.go.mariusiliescu.view.MainInterface;

public class MainController {
	private ComandaHibernateUtil hibernateUtil;
	
	public MainController(MainInterface view , Model model){

		view.butonAdaugarePachetListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(view.esteFormularulDestinataruluiCompletat()){
					if(view.getPackList().size() == 0){
						JOptionPane.showMessageDialog(view,
	                            "Adaugati cel putin un pachet",
	                            "Pachet ",
	                            JOptionPane.ERROR_MESSAGE);
					}else{
						model.adaugareListaPachet(view.getPackList());
						view.setModel(model);
						view.resetPackListPanelFields();
					}
				}else{
					JOptionPane.showMessageDialog(view,
                            "Competati toate campurile",
                            "Destinatar ",
                            JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	
		view.butonAdaugareComandaListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(view.esteFormularulClientuluiCompletat()){
					if(model.getListaPachete().size() == 0){
						JOptionPane.showMessageDialog(view,
	                            "Adaugati cel putin un pachet",
	                            "Pachet ",
	                            JOptionPane.ERROR_MESSAGE);
					}else{
						Comanda c = new Comanda(new Date(),new Date(),model.getListaPachete().size()*10,model.getListaPachete(), view.getClient());
						model.adaugareComanda(c);
						hibernateUtil.addComanda(c);
						model.getListaPachete().removeAll(model.getListaPachete());
						view.resetPackListPanelFields();
						view.resetClientFields();
						JOptionPane.showMessageDialog(view,
	                            "Comanda a fost adaugata in baza de date",
	                            "Pachet ",
	                            JOptionPane.OK_OPTION);
					}
				}else{
					JOptionPane.showMessageDialog(view,
                            "Completati formularul clientului",
                            "Client ",
                            JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		Runnable c =new Runnable() {
			
			@Override
			public void run() {
				hibernateUtil = new ComandaHibernateUtil();	
			}
		};
		Thread t = new Thread(c);
		t.start();
		
	}

}
