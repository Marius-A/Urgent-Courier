package com.mariusiliescu.view.adugare.comanda;

import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mariusiliescu.model.entities.Pachet;

@SuppressWarnings("serial")
public class FormularAdaugareComanda extends JPanel {

	private DetaliiDestinatar detaliiDestinatar;
	private SelectPacketNum selectPacketNum;
	
	public FormularAdaugareComanda() {
		super();
		initComponents();
		setLayout();
	}

	private void initComponents(){
		detaliiDestinatar = new DetaliiDestinatar();
		selectPacketNum = new SelectPacketNum();
	}
	
	private void setLayout(){
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(detaliiDestinatar, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
						.addComponent(selectPacketNum, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(detaliiDestinatar, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(selectPacketNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		setLayout(groupLayout);
	}
	
	public ArrayList<Pachet> getPackList(){
		return selectPacketNum.getPackList(detaliiDestinatar.getDestinatar());
	}
	public void butonAdaugarePachetListener(ActionListener lis){
		selectPacketNum.butonAdaugarePachetListener(lis);
	}
	
	public void resetFields(){
		selectPacketNum.resetFields();
		detaliiDestinatar.resetFields();
	}
	
	public boolean esteFormularulDestinataruluiCompletat(){
		return detaliiDestinatar.esteFormularulDestinataruluiCompletat();
	}
}
