package com.mariusiliescu.swingcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import com.itextpdf.text.DocumentException;
import com.mariusiliescu.model.entities.Comanda;
import com.mariusiliescu.model.entities.Factura;
import com.mariusiliescu.model.entities.persoane.Receptioner;
import com.mariusiliescu.util.ComandaHibernateUtil;
import com.mariusiliescu.util.PDFBuilder;
import com.mariusiliescu.view.vizualizarecomenzi.VizualizareComenzi;

public class ViewManageController implements Observer {
	private ViewComenziController comenziController;
	private ViewPacheteController pacheteController;
	private ViewClientiController clientiController;
	
	public ViewManageController(VizualizareComenzi view , ComandaHibernateUtil hib){
		
		comenziController = new ViewComenziController(view.getViewComenzi() , hib);
		pacheteController = new ViewPacheteController(view.getViewPachete() , hib);
		clientiController = new ViewClientiController(view.getViewClienti() , hib);
		
		view.addRadioButtonsListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String comand = e.getActionCommand();		
				if(comand == "Comenzi"){
					view.showPanel("1");
				}else if(comand == "Pachete"){
					view.showPanel("2");
				}else if(comand == "Clienti"){
					view.showPanel("3");
				}
			}
		});
		
		view.getViewComenzi().addMenuComenziListener(new ActionListener[]{new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					String idComanda  = view.getViewComenzi().getSelectedRowOderId();
					Comanda c = hib.getComanda(Long.parseLong(idComanda));
					Factura f = new Factura(10.2, new Receptioner(), c);
					try {
						PDFBuilder.creareFactura(f);
					} catch (IOException | DocumentException e1) {
						e1.printStackTrace();
					}
				}
			}, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					view.showPanel("3");
					view.setSelButton(3);
					String idClinet = view.getViewComenzi().getSelectedRowClientId();
					view.getViewClienti().hilightRowWithClientId(idClinet);
				}
			}	
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		comenziController.updateTable();
		pacheteController.updateTable();
		clientiController.updateTable();
	}
}
