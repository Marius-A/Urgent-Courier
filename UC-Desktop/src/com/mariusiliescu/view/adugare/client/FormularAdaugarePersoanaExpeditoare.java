package com.mariusiliescu.view.adugare.client;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.mariusiliescu.model.entities.persoane.PersoanaExpeditoare;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class FormularAdaugarePersoanaExpeditoare extends JPanel{
	private JTextField cnp;
	private JTextField nume;
	private JTextField prenume;
	private JTextField numarTelefon;
	private JTextField adresaEmail;
	private FormularAdresa adresa;
	
	public FormularAdaugarePersoanaExpeditoare(){
		super();
		initComponents();
		setLayout();
	}
	private void initComponents(){
		cnp 			= new JTextField();
		nume			= new JTextField();
		prenume 		= new JTextField();
		numarTelefon	= new JTextField();
		adresaEmail 	= new JTextField();
		adresa 			= new FormularAdresa();
	}
	private void setLayout(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
		
		JPanel panel1 = new JPanel(new GridBagLayout());
		
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(0,0,5,0);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(new JLabel("CNP"),c);
		
        c.gridx = 1;
        c.gridy = 0;
		panel1.add(cnp,c);
		
		//this.add(new JSeparator());
		
        c.gridx = 0;
        c.gridy = 1;
		panel1.add(new JLabel("Nume"),c);
		
        c.gridx = 1;
        c.gridy = 1;
		panel1.add(nume,c);
		
		//this.add(new JSeparator());
		
        c.gridx = 0;
        c.gridy = 2;
		panel1.add(new JLabel("Prenume"),c);
		
        c.gridx = 1;
        c.gridy = 2;
		panel1.add(prenume,c);
		
		//this.add(new JSeparator());
		
        c.gridx = 0;
        c.gridy = 3;
		panel1.add(new JLabel("Numar de telefon"),c);
		
        c.gridx = 1;
        c.gridy = 3;
		panel1.add(numarTelefon,c);
		
		
	//	this.add(new JSeparator());
		
        c.gridx = 0;
        c.gridy = 4;
		panel1.add(new JLabel("Adresa de E-mail"),c);
		
        c.gridx = 1;
        c.gridy = 4;
		panel1.add(adresaEmail,c);
		
		//this.add(new JSeparator());
		
	
		JPanel panel2 = new JPanel(new GridBagLayout());
		c.gridx = 0;
        c.gridy = 0;
		panel2.add (new JLabel("Adresa Expeditor"),c);
			
        c.gridx = 0;
        c.gridy = 1;
		panel2.add(adresa,c);
		
		c.gridx = 0;
        c.gridy = 0;
        panel1.setBorder(compound);
		this.add(panel1, c);
        c.gridx = 0;
        c.gridy = 1;
        panel2.setBorder(compound);
		this.add(panel2, c);
	}
	
	public PersoanaExpeditoare getDataPE(){
		return new PersoanaExpeditoare(cnp.getText(),nume.getText()
				,prenume.getText(),adresa.getAdresa(),adresaEmail.getText()
				,numarTelefon.getText());
	}
	
	public boolean esteFormularulPersExpCompletat(){
		if(	cnp.getText().equals("") || nume.getText().equals("") ||
				prenume.getText().equals("") || numarTelefon.getText().equals("") ||
				adresaEmail.getText().equals("") || !adresa.esteFormularulDeAdresaCompletat())
			return false;
		else
			return true;
	}
	public void resetFields(){
		cnp.setText("");
		nume.setText("");
		prenume.setText("");
		numarTelefon.setText("");
		adresaEmail.setText("");
		adresa.resetFields();
	}
}

