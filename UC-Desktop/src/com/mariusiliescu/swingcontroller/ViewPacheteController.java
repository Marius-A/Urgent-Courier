package com.mariusiliescu.swingcontroller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mariusiliescu.util.ComandaHibernateUtil;
import com.mariusiliescu.view.vizualizarecomenzi.ViewPachete;

public class ViewPacheteController {
	private ViewPachete view;
	private ComandaHibernateUtil hib;
	
	public ViewPacheteController(ViewPachete view, ComandaHibernateUtil hib)
	{
		this.view = view;
		this.hib = hib;
		updateTable();
		
		view.addTextFieldKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String query = new String("Select * from Pachet");
				/*String filter = view.getFilter();
				String searchedKey = view.getSearchedKey();*/
				//TODO get result set , make interogation  set TABLE MODEL
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
			rs = hib.getRS("Select * from Pachet");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		view.setTableModel(rs);
	}
}
