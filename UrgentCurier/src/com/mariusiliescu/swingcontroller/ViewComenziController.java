package com.mariusiliescu.swingcontroller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mariusiliescu.util.ComandaHibernateUtil;
import com.mariusiliescu.view.vizualizarecomenzi.ViewComenzi;

public class ViewComenziController {
	private ViewComenzi view;
	private ComandaHibernateUtil hib;
	
	public ViewComenziController(ViewComenzi view, ComandaHibernateUtil hib)
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
				final String query = new String("Select * from Comanda as c where c."+filter+" like '%"+searchedKey+"%'");
				System.out.println(query);
				try {
					view.setTableModel(hib.getRS(query));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
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
		ResultSet rs = null;
		try {
			rs = hib.getRS("Select * from Comanda");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		view.setTableModel(rs);
	}
}
