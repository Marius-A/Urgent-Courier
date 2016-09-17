package com.mariusiliescu.view.adugare.comanda;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mariusiliescu.model.entities.Dimensiune;

public class DimensionsView extends JPanel {
	private static final long serialVersionUID = 1L;
	JTextField height;
	JTextField width;
	JTextField length;
	
	public DimensionsView() {
		initComponents();
		setLayout();
	}
	private void initComponents(){
		this.height	 = new JTextField();
		this.width	 = new JTextField();
		this.length  = new JTextField();
	}
	private void setLayout(){
		this.setLayout(new GridLayout(1,6, 10 , 10));
		
		this.add(new JLabel("Height"));
		this.add(height);
		
		this.add(new JLabel("Width"));
		this.add(width);
		
		this.add(new JLabel("Length"));
		this.add(length);
	}
	public Dimensiune getDimensions(){
		return new Dimensiune(Float.parseFloat(height.getText()),Float.parseFloat(width.getText()),Float.parseFloat(length.getText()));
	}
	
	public Boolean areAllFieldsCompleted(){
		if(height.getText().equals("") || width.getText().equals("") || length.getText().equals("")) 
			return false;
		else
			return true;
	}
}
