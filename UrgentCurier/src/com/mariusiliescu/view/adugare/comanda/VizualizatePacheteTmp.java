package com.mariusiliescu.view.adugare.comanda;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mariusiliescu.Model;
import com.mariusiliescu.model.entities.Pachet;

import javax.swing.JSeparator;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VizualizatePacheteTmp extends JPanel {

	private JLabel label;
	private JList<Pachet> list;
	private JButton btnAdaugareComanda;
	
	public VizualizatePacheteTmp() {
		initComponents();
		setLayout();
	}

	private void initComponents(){
		label = new JLabel("Lista Pachete");
		list = new JList<Pachet>();
		btnAdaugareComanda = new JButton("Adaugare comanda");
	}
	
	private void setLayout(){
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JSeparator separator = new JSeparator();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(list, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
								.addComponent(label)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
							.addComponent(btnAdaugareComanda)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdaugareComanda))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void setModel(Model listP){
		list.setModel(new CustomListModel(listP));
	}
	
	public void btnAdaugareComandaListener(ActionListener lis){
		btnAdaugareComanda.addActionListener(lis);
	}
}
