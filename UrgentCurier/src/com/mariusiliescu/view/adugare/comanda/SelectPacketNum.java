package com.mariusiliescu.view.adugare.comanda;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import com.mariusiliescu.model.entities.Pachet;
import com.mariusiliescu.model.entities.persoane.Destinatar;

public class SelectPacketNum extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField numprod;
	private Integer numPachete;
	private JButton addPacket;
	private JButton delButton;
	private Vector<PacketDetails> packDetList;
	private JPanel pacPanel;
    JScrollPane listScroller;
    private JButton btnAdaugarePachet;
	
	public SelectPacketNum() {
		initComponents();
		setLayout();
		
		addListeners();
	}
	
	private void initComponents(){
		numPachete=0;
		numprod = new JTextField(20);
		addPacket = new JButton("+");
		delButton = new JButton("-");
		listScroller = new JScrollPane();
		listScroller.setViewportBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		packDetList = new Vector<>();
		listScroller.setPreferredSize(new Dimension(685,200));
	    pacPanel = new JPanel();
		btnAdaugarePachet = new JButton("Adaugare pachet");
	}
	private void setLayout(){
		JPanel intro = new JPanel();
		numprod.setText(numPachete.toString());
		intro.add(new JLabel("Pachete:"));
		intro.add(numprod);
		intro.add(addPacket);
		intro.add(new JLabel(" <-> "));
		intro.add(delButton);
		
		pacPanel.add(listScroller);
		

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(intro, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
						.addComponent(pacPanel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(intro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pacPanel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		intro.add(btnAdaugarePachet);
		setLayout(groupLayout);
		
	}
	private void addListeners(){
		addPacket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Box box =  Box.createVerticalBox();
				if(numPachete < 20){
					GridBagConstraints c= new GridBagConstraints();
					numPachete++;
					numprod.setText(numPachete.toString());
					packDetList.add(new PacketDetails());
					int i=0;
					for(PacketDetails pack : packDetList ){
						c.gridy = i+1;
						c.gridx = 0;
				        c.anchor = GridBagConstraints.FIRST_LINE_START;  
				        c.insets = new Insets(0,0,0,0);
						box.add(pack,c);
						i++;
					}
					listScroller.setViewportView(box);
					SelectPacketNum.this.pacPanel.repaint();
					SelectPacketNum.this.pacPanel.revalidate();
				}
			}
		});
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(numPachete < 2){
					SelectPacketNum.this.delButton.setEnabled(false);
				}
				if(numPachete > 1){
					GridBagConstraints c= new GridBagConstraints();
					Box box =  Box.createVerticalBox();
					numPachete --;
					numprod.setText(numPachete.toString());
					packDetList.removeElementAt(packDetList.size()-1);
					int i=0;
					for(PacketDetails pack : packDetList ){
						c.gridy = i+1;
						c.gridx = 0;
				        c.anchor = GridBagConstraints.FIRST_LINE_START;  
				        c.insets = new Insets(0,0,0,0);
						box.add(pack,c);
						i++;
					}
					listScroller.setViewportView(box);
					SelectPacketNum.this.pacPanel.repaint();
					SelectPacketNum.this.pacPanel.revalidate();
				}
			}
		});
	}
	
	public ArrayList<Pachet> getPackList(Destinatar d){
		ArrayList<Pachet> listPack = new ArrayList<>();
		for(PacketDetails p : packDetList){
			if(p.areAllFieldsCompleted())
				listPack.add(p.getPacketDetails(d));
		}
		return listPack;
	}
	
	public void butonAdaugarePachetListener(ActionListener lis){
		btnAdaugarePachet.addActionListener(lis);
	}
	public void resetFields(){
		GridBagConstraints c= new GridBagConstraints();
		Box box =  Box.createVerticalBox();
		numPachete = 1;
		numprod.setText(numPachete.toString());
		packDetList.removeAllElements();
		packDetList.addElement(new PacketDetails());
		int i=0;
		for(PacketDetails pack : packDetList ){
			c.gridy = i+1;
			c.gridx = 0;
	        c.anchor = GridBagConstraints.FIRST_LINE_START;  
	        c.insets = new Insets(0,0,0,0);
			box.add(pack,c);
			i++;
		}
		listScroller.setViewportView(box);
		SelectPacketNum.this.pacPanel.repaint();
		SelectPacketNum.this.pacPanel.revalidate();
	}
}
