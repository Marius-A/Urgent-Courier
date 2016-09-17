package com.mariusiliescu.view.adugare.client;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import com.mariusiliescu.model.entities.persoane.Client;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


@SuppressWarnings("serial")
public class FormularAdaugareClient extends JPanel{
	private ClientTypeSelector clientTypeSelector;
	private FormularAdaugareCompanie formularAdaugareCompanie;
	private FormularAdaugarePersoanaExpeditoare formularAdaugarePersoanaExpeditoare;
	private JPanel formular;
	private CardLayout cLayout;

	public FormularAdaugareClient(){
		super();
		initComponents();
		setLayout();
		this.setVisible(true);
	}
	private void initComponents(){
		formular							= new JPanel();
		clientTypeSelector				    = new ClientTypeSelector();
		formularAdaugareCompanie 			= new FormularAdaugareCompanie();
		formularAdaugarePersoanaExpeditoare = new FormularAdaugarePersoanaExpeditoare();
		cLayout								= new CardLayout();
		
		this.addRadioButtonsListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(clientTypeSelector.getClientType()=="pers"){
					cLayout.show(formular, "1");
				}else if(clientTypeSelector.getClientType()== "comp"){
					cLayout.show(formular, "2");
				}else{
					
				}
			}
		});
	}
	private void setLayout(){
		
		formular.setLayout(cLayout);
		formular.add(formularAdaugarePersoanaExpeditoare , "1");
		formular.add(formularAdaugareCompanie,"2");
		cLayout.show(formular, "2");
			
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(clientTypeSelector, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(formular, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
							.addGap(3))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(clientTypeSelector, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(formular, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	public void addRadioButtonsListener(ItemListener lis){
		clientTypeSelector.addRadioButtonsListener(lis);
	}
	public Client getClientData(){
		return formularAdaugareCompanie.getDateCompanie();
		/*TODO FIX pers exp inheritance
		 * if(clientTypeSelector.getClientType()=="comp") 
			return formularAdaugareCompanie.getDateCompanie();
		else
			return formularAdaugarePersoanaExpeditoare.getDataPE();*/
	}
	public boolean esteFormularulClientuluiCompletat(){
		return (clientTypeSelector.getClientType()=="comp" )?formularAdaugareCompanie.esteFormularulCompanieiCompletat():
			formularAdaugarePersoanaExpeditoare.esteFormularulPersExpCompletat();
	}
	public void resetFields(){
		formularAdaugareCompanie.resetFields();
		formularAdaugarePersoanaExpeditoare.resetFields();
	}
}
