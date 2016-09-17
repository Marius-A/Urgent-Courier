package com.mariusiliescu.view.adugare.comanda;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mariusiliescu.model.entities.persoane.Destinatar;
import com.mariusiliescu.view.adugare.client.FormularAdresa;

import java.awt.Font;

public class DetaliiDestinatar extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3656562063611697410L;
	
	private JLabel panelName;
	private JLabel cnp;
	private JLabel nume;
	private JLabel prenume;
	private JLabel nrTelefon;
	private JLabel email;
	
	private JTextField cnpDestinatar;
	private JTextField numeDestinatar;
	private JTextField prenumeDestinatar;
	private JTextField nrTelDestinatar;
	private JTextField emailDestinatar;
	private FormularAdresa adresaDestinatar;
	
	public DetaliiDestinatar() {
		initComponents();
		setLayout();
	}

	private void initComponents(){
		nrTelefon 			= new JLabel("Nr. Tel.");
		adresaDestinatar 	= new FormularAdresa();
		nrTelDestinatar 	= new JTextField();
		nume 				= new JLabel("Nume");
		prenume 			= new JLabel("Prenume");
		cnp 				= new JLabel("CNP");
		prenumeDestinatar 	= new JTextField();
		numeDestinatar		= new JTextField();
		panelName			= new JLabel("Adaugare Destinatar");
		panelName.setFont(new Font("Tahoma", Font.BOLD, 20));
		email	 			= new JLabel("E-mail");
		
		cnpDestinatar		= new JTextField();
		emailDestinatar 	= new JTextField();
	}
	
	private void setLayout(){
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelName)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(cnp)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cnpDestinatar, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
									.addGap(23)
									.addComponent(email))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(nume)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(numeDestinatar, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(prenume)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(prenumeDestinatar, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(nrTelefon)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nrTelDestinatar, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
								.addComponent(emailDestinatar, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
						.addComponent(adresaDestinatar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 513, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nume)
						.addComponent(numeDestinatar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(prenume)
						.addComponent(prenumeDestinatar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nrTelefon)
						.addComponent(nrTelDestinatar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cnp)
						.addComponent(cnpDestinatar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(email)
						.addComponent(emailDestinatar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(adresaDestinatar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		setLayout(groupLayout);
	}
	
	public Destinatar getDestinatar(){
		return new Destinatar(cnpDestinatar.getText(), numeDestinatar.getText()
				, prenumeDestinatar.getText(),adresaDestinatar.getAdresa(),emailDestinatar.getText()
				, nrTelDestinatar.getText());
	}
	public boolean esteFormularulDestinataruluiCompletat(){
		if(	cnpDestinatar.getText().equals("") || numeDestinatar.getText().equals("") ||
				prenumeDestinatar.getText().equals("") || nrTelDestinatar.getText().equals("") ||
				emailDestinatar.getText().equals("") || !adresaDestinatar.esteFormularulDeAdresaCompletat())
			return false;
		else
			return true;
	}
	public void resetFields(){
		cnpDestinatar.setText("");;
		numeDestinatar.setText("");;
		prenumeDestinatar.setText("");;
		nrTelDestinatar.setText("");;
		emailDestinatar.setText("");;
		adresaDestinatar.resetFields();
	}
}
