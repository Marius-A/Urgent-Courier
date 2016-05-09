package ro.go.mariusiliescu.view.adugare.client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import ro.go.mariusiliescu.entities.persoane.Client;

@SuppressWarnings("serial")
public class FormularAdaugareClient extends JPanel{
	private ClientTypeSelector clientTypeSelector;
	private FormularAdaugareCompanie formularAdaugareCompanie;
	private FormularAdaugarePersoanaExpeditoare formularAdaugarePersoanaExpeditoare;
	private JPanel formular;

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
		
		this.addRadioButtonsListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				FormularAdaugareClient.this.formular.removeAll();
				FormularAdaugareClient.this.formular.revalidate();
				
				if(clientTypeSelector.getClientType()=="pers"){
					FormularAdaugareClient.this.formular.add(formularAdaugarePersoanaExpeditoare);
				}else if(clientTypeSelector.getClientType()== "comp"){
					FormularAdaugareClient.this.formular.add(formularAdaugareCompanie);
				}else{
					
				}
			}
		});
	}
	private void setLayout(){
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		//formular.setLayout(new BoxLayout);
		
		c.gridx = 0;
		c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        //
        c.weightx = 1.0;
		this.add(clientTypeSelector,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JSeparator(),c);
		
		if(clientTypeSelector.getClientType()=="pers"){
			formular.add(formularAdaugarePersoanaExpeditoare);
		}else if(clientTypeSelector.getClientType()== "comp"){
			formular.add(formularAdaugareCompanie);
		}else{
			
		}	
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(formular,c);
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
