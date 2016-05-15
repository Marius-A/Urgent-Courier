package com.mariusiliescu.swingcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;

import javax.swing.JOptionPane;

import com.mariusiliescu.Model;
import com.mariusiliescu.model.entities.Comanda;
import com.mariusiliescu.util.ComandaHibernateUtil;
import com.mariusiliescu.view.MainInterface;

public class MainController extends Observable{
	private ComandaHibernateUtil  hibernateUtil;
	
	public MainController(MainInterface view , Model model){
		
		view.butonAdaugarePachetListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Comanda c = new Comanda(new Date(),new Date(),model.getListaPachete().size()*10,model.getListaPachete(), view.getClient());
				if(view.esteFormularulDestinataruluiCompletat()){
				
					if(view.getPackList(c).size() == 0){
						JOptionPane.showMessageDialog(view,
	                            "Adaugati cel putin un pachet",
	                            "Pachet ",
	                            JOptionPane.ERROR_MESSAGE);
					}else{
						model.adaugareListaPachet(view.getPackList(c));
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
						
						view.resetJList();
						MainController.this.notifyObservers();
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
				new ViewManageController(view.getVizualizareComenzi() , hibernateUtil );
			}
		};
		Thread t = new Thread(c);
		t.start();
		
	}

}
