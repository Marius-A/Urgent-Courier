package ro.go.mariusiliescu.view.adugare.comanda;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ro.go.mariusiliescu.entities.Pachet;
import ro.go.mariusiliescu.entities.SpecialConditions;
import ro.go.mariusiliescu.entities.StarePachet;
import ro.go.mariusiliescu.entities.persoane.Destinatar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PacketDetails extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7801601114857018285L;
	
	JTextField weight;
	DimensionsView dimensions;
	JComboBox<SpecialConditions> specialCondition;
	
	public PacketDetails(){
		super();
		initComponents();
		setLayout();
	}
	
	private void initComponents(){
		weight = new JTextField();
		dimensions = new DimensionsView();
		specialCondition = new JComboBox<SpecialConditions>(SpecialConditions.values());
	}
	
	private void setLayout(){
		
		JLabel label = new JLabel("Weight");
		JLabel label_2 = new JLabel("Special Conditions");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(specialCondition, 0, 110, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dimensions, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(weight, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(28))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(weight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_2)
							.addComponent(specialCondition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(dimensions, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public Pachet getPacketDetails(Destinatar dst){
		return new Pachet(Float.parseFloat(weight.getText()), dimensions.getDimensions(),(SpecialConditions)specialCondition.getSelectedItem(),StarePachet.inCursDeExpediere, dst);
	}
	
	public Boolean areAllFieldsCompleted(){
		if(weight.getText().equals("") || !dimensions.areAllFieldsCompleted() )
			return false;
		else
			return true;
	}
}
