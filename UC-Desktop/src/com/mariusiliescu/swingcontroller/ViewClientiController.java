package com.mariusiliescu.swingcontroller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mariusiliescu.util.ComandaHibernateUtil;
import com.mariusiliescu.view.vizualizarecomenzi.ViewClienti;

public class ViewClientiController {
	private ViewClienti view;
	private ComandaHibernateUtil hib;
	
	public ViewClientiController(ViewClienti view, ComandaHibernateUtil hib)
	{
		this.view=view;
		this.hib = hib;
		updateTable();
		
		view.addTextFieldKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				final String filter = view.getFilter();
				final String searchedKey = view.getSearchedKey();
				//final String queryPersF= new String("Select * from Persoanafizica");
				final String queryCom = new String("Select C.id_client  , Co.numeC , Co.eMail , Co.cui , Co.nrTelefonC FROM Client AS C , companie as Co WHERE C.id_client = Co.id_client AND Co."+filter+" like '%"+searchedKey+"%'");
				System.out.println(queryCom);
				try {
					view.setTableCompanieModel(hib.getRS(queryCom));
					//view.setTablePersoanaFizicaModel(hib.getRS(queryPersF));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public void updateTable(){
		ResultSet rsCompany = null;
		ResultSet rsPF = null;
		try {
			rsCompany = hib.getRS("Select C.id_client  , Co.numeC , Co.eMail , Co.cui , Co.nrTelefonC FROM Client AS C , companie as Co WHERE C.id_client = Co.id_client");
			rsPF	  = hib.getRS("Select C.id_client  FROM client as C ");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		view.setTableCompanieModel(rsCompany);
		view.setTablePersoanaFizicaModel(rsPF);
	}
}
