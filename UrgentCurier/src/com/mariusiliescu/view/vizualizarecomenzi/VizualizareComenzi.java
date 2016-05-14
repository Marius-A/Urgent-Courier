 package com.mariusiliescu.view.vizualizarecomenzi;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

@SuppressWarnings("serial")
public class VizualizareComenzi extends JPanel {
    private ViewComenzi comenzi;
    private ViewPachete pachete;
    private ViewClienti clienti;
	private CardLayout cLayout;
	private JPanel tabPanel;
    
	JRadioButton rdbtnComenzi ;
	JRadioButton rdbtnPachete ;	
	JRadioButton rdbtnClienti ;

	public VizualizareComenzi() {
		initComponents();
		setLayout();
	}
	
	private void initComponents(){
		comenzi = new ViewComenzi();
		comenzi.setBackground(Color.RED);
		pachete = new ViewPachete();
		pachete.setBackground(Color.GREEN);
		clienti = new ViewClienti();
		clienti.setBackground(Color.BLUE);
		cLayout = new CardLayout();
		tabPanel = new JPanel();
		
		rdbtnClienti = new JRadioButton("Clienti");
		rdbtnPachete = new JRadioButton("Pachete");
		rdbtnComenzi = new JRadioButton("Comenzi");
		
		ButtonGroup group = new ButtonGroup();	
		group.add(rdbtnPachete);
		group.add(rdbtnClienti);
		group.add(rdbtnComenzi);
		rdbtnComenzi.setSelected(true);
		
	}
	private void setLayout(){
		
		JPanel panel = new JPanel();
			
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(tabPanel, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(tabPanel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.add(rdbtnComenzi);
		panel.add(rdbtnPachete);
		panel.add(rdbtnClienti);
		setLayout(groupLayout);
		
		tabPanel.setLayout(cLayout);
		
		tabPanel.add(comenzi,"1");
		tabPanel.add(pachete,"2");
		tabPanel.add(clienti,"3");	
		
		cLayout.show(tabPanel, "1");
	}

	public void addRadioButtonsListener(ActionListener lis){
		rdbtnClienti.addActionListener(lis);
		rdbtnPachete.addActionListener(lis);
		rdbtnComenzi.addActionListener(lis);
	}
	public void setSelButton(int n){
		switch (n) {
		case 1:
			rdbtnComenzi.setSelected(true);
			break;
		case 2:
			rdbtnPachete.setSelected(true);
			break;
		case 3:
			rdbtnClienti.setSelected(true);
			break;

		default:
			break;
		}
	}
	public ViewComenzi getViewComenzi(){
		return comenzi;
	}
	public ViewPachete getViewPachete(){
		return pachete;
	}
	public ViewClienti getViewClienti(){
		return clienti;
	}
	public void showPanel(String s){
		cLayout.show(tabPanel,s);
	}
	
	public void addMenuComenziListener(ActionListener[] listeners){
		comenzi.addMenuComenziListener(listeners);
	}
}
