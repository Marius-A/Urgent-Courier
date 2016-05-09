package ro.go.mariusiliescu.view.adugare.client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class ClientTypeSelector extends JPanel{
	JLabel info;
	JRadioButton selPersoanaFizica;
	JRadioButton selCompanie;
	
	public ClientTypeSelector(){
		super();
		initComponents();
		this.setLayout();
	}
	private void initComponents(){
		this.info = 			 new JLabel("Selectati tipul clientului: ");
		this.selCompanie = 		 new JRadioButton("Companie");
		this.selPersoanaFizica = new JRadioButton("Persoana Fizica");
		selPersoanaFizica.setSelected(true);
	}
	private void setLayout(){
		GridBagLayout gridB = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(gridB);
		
		ButtonGroup group = new ButtonGroup();	
		group.add(selCompanie);
		group.add(selPersoanaFizica);
		
		c.gridx = 0;
		c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
		this.add(info,c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(selCompanie,c);
		
		c.gridx = 1;
		c.gridy = 1;
		this.add(selPersoanaFizica,c);		
	}
	public void addRadioButtonsListener(ItemListener lis){
		selCompanie.addItemListener(lis);
		selPersoanaFizica.addItemListener(lis);
	}
	public String getClientType(){
		if(selPersoanaFizica.isSelected()) return "pers";
		if(selCompanie.isSelected()) return "comp";
		else
			return null;
	}
}
