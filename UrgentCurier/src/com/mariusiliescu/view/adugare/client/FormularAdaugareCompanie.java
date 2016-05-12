package com.mariusiliescu.view.adugare.client;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.mariusiliescu.model.entities.Companie;
import com.mariusiliescu.model.entities.TipClient;
import com.mariusiliescu.model.entities.persoane.Client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FormularAdaugareCompanie extends JPanel {
	private JTextField cui;//cod unic ..
	private JTextField numeCompanie;
	private JTextField numarTelefon;
	private JTextField adresaEmail;
	private FormularAdresa adresa;
	
	public FormularAdaugareCompanie(){
		super();
		initComponents();
		setLayout();
	}
	private void initComponents(){
		cui			 = new JTextField();
		numeCompanie = new JTextField();
		numarTelefon = new JTextField();
		adresaEmail  = new JTextField();
		adresa		 = new FormularAdresa();
	}
	private void setLayout(){	
		this.setLayout(new GridBagLayout());
		
		
		JPanel compDet = new JPanel();		
		compDet.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
		
		
		c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0,0,5,0);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        compDet.add(new JLabel("CUI"),c);
		
        c.gridx = 1;
        c.gridy = 0;
        compDet.add(cui,c);
		
		//this.add(new JSeparator(),c);
		
        c.gridx = 0;
        c.gridy = 1;
        compDet.add(new JLabel("Nume Companie"),c);
		
        c.gridx = 1;
        c.gridy = 1;
        compDet.add(numeCompanie,c);
		
		//this.add(new JSeparator(),c);
		
        c.gridx = 0;
        c.gridy = 2;
        compDet.add(new JLabel("Numar de Telefon"),c);
		
        c.gridx = 1;
        c.gridy = 2;
        compDet.add(numarTelefon,c);
		
		//this.add(new JSeparator(),c);
		
        c.gridx = 0;
        c.gridy = 3;
        compDet.add(new JLabel("E-mail"),c);
		
        c.gridx = 1;
        c.gridy = 3;
        compDet.add(adresaEmail,c);
        
        compDet.setBorder(compound);
		
        c.gridx = 0;
        c.gridy = 0;
		this.add(compDet,c);
		
		JPanel panelAdresa = new JPanel();
		panelAdresa.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
		panelAdresa.add (new JLabel("Adresa Expeditor"),c);
		
        c.gridx = 0;
        c.gridy = 1;
		panelAdresa.add(adresa,c);
		panelAdresa.setBorder(compound);
		this.add(panelAdresa,c);
			
	}
	
	public Client getDateCompanie(){
		return new Companie(TipClient.fidel ,cui.getText(),numeCompanie.getText(),adresaEmail.getText(),
				adresa.getAdresa(), numarTelefon.getText());
	}
	public boolean esteFormularulCompanieiCompletat(){
		if(	cui.getText().equals("") || numeCompanie.getText().equals("") ||
				numarTelefon.getText().equals("") || adresaEmail.getText().equals("") ||
				!adresa.esteFormularulDeAdresaCompletat())
			return false;
		else
			return true;
	}
	public void resetFields(){
		cui.setText("");
		numeCompanie.setText("");
		numarTelefon.setText("");
		adresaEmail.setText("");
		adresa.resetFields();
	}
}
