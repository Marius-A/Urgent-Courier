package com.mariusiliescu.view.vizualizarecomenzi;

import javax.swing.table.DefaultTableModel;

import com.mariusiliescu.model.entities.Comanda;


@SuppressWarnings("serial")
public class CustomTableModel extends DefaultTableModel{

	public CustomTableModel(String[] s) {
		for(int i = 0 ; i < s.length ; i++){
			addColumn(s[i]);
		}
	}
	public void insertRow(int row, Comanda C) {
		//insertRow(row, new Object[]{p.getProdName(),p.getProdPrice(),p.getQuantity(),p.getCategory().getCompany().getCompanyName(),p.getCategory().getCategoryName(),p.getCategory().getCategoryId(),p.getCategory().getCompany().getCompanyAddress(),p.getExpDate()});	
	}
}
