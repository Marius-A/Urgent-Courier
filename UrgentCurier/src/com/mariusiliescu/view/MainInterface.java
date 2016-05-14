package com.mariusiliescu.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mariusiliescu.Model;
import com.mariusiliescu.model.entities.Comanda;
import com.mariusiliescu.model.entities.Pachet;
import com.mariusiliescu.model.entities.persoane.Client;
import com.mariusiliescu.view.adugare.client.FormularAdaugareClient;
import com.mariusiliescu.view.adugare.comanda.FormularAdaugareComanda;
import com.mariusiliescu.view.adugare.comanda.VizualizatePacheteTmp;
import com.mariusiliescu.view.vizualizarecomenzi.VizualizareComenzi;
import javax.swing.BoxLayout;

public class MainInterface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane ;
	private JPanel addOrders;
	private JPanel panel1;
	private VizualizareComenzi manageOrders;
	
	private FormularAdaugareClient adaugareClient;
	private FormularAdaugareComanda adaugareComanda;
	private VizualizatePacheteTmp vizualizatePacheteTmp;
	
	private CardLayout cLayout;
	
	private JToolBar toolBar;
	
	private JButton next;
	private JButton back;
	
	
	public MainInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initComponents();
		setLayout();
		setNavButtonListener();
		this.setVisible(true);
	}
	
	private void initComponents(){
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		manageOrders = new VizualizareComenzi();
		
		panel1 = new JPanel();
		addOrders = new JPanel();
		cLayout = new CardLayout();
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		
		adaugareClient = new FormularAdaugareClient();
		adaugareComanda = new FormularAdaugareComanda();
		vizualizatePacheteTmp = new VizualizatePacheteTmp();
		
		back = new JButton("<--");
		back.setFont(new Font("Tahoma", Font.BOLD, 18));
		next = new JButton("-->");
		next.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
	}
	
	private void setLayout(){
		getContentPane().add(tabbedPane, BorderLayout.NORTH);		
		MainInterface.this.back.setVisible(false);
		tabbedPane.addTab("Adaugare comanda", null, panel1, null);
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addGap(5)
					.addComponent(addOrders, GroupLayout.PREFERRED_SIZE, 801, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel1.createSequentialGroup()
							.addGap(18)
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(vizualizatePacheteTmp, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)))
					.addGap(165))
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel1.createSequentialGroup()
					.addGap(5)
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(vizualizatePacheteTmp, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(addOrders, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel1.setLayout(gl_panel1);
		tabbedPane.addTab("Lista de comenzi", null, manageOrders, null);
		tabbedPane.setEnabledAt(1, true);
		manageOrders.setLayout(new BoxLayout(manageOrders, BoxLayout.Y_AXIS));
		setTabAddLayout();
		setTabViewLayout();
		this.pack();
	}
	
	private void setTabAddLayout(){
		toolBar.add(back);
		toolBar.add(next);
		//addOrders.add(toolBar, BorderLayout.SOUTH);
		
		addOrders.setLayout(cLayout);
		addOrders.add(adaugareClient,"1");
		
		addOrders.add(adaugareComanda,"2");
		cLayout.show(addOrders, "1");
	}
	
	private void setTabViewLayout(){
		
	}
	
	private void setNavButtonListener(){
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cLayout.show(addOrders, "2");
				MainInterface.this.next.setVisible(false);
				MainInterface.this.back.setVisible(true);
			}
		});
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cLayout.show(addOrders, "1");
				MainInterface.this.back.setVisible(false);
				MainInterface.this.next.setVisible(true);
			}
		});
	}
	public void resetJList(){
		vizualizatePacheteTmp.resetJList();
	}
	public VizualizareComenzi getVizualizareComenzi(){
		return manageOrders;
	}
	public void butonAdaugarePachetListener(ActionListener lis){
		adaugareComanda.butonAdaugarePachetListener(lis);
	}
	
	public void butonAdaugareComandaListener(ActionListener lis){
		vizualizatePacheteTmp.btnAdaugareComandaListener(lis);
	}
	
	public ArrayList<Pachet> getPackList(Comanda c){
		return adaugareComanda.getPackList(c);
	}
	
	public Client getClient(){
		return adaugareClient.getClientData();
	}
	
	public void setModel(Model listP){
		vizualizatePacheteTmp.setModel(listP);
	}
	
	public void resetPackListPanelFields(){
		adaugareComanda.resetFields();
	}
	
	public boolean esteFormularulClientuluiCompletat(){
		return adaugareClient.esteFormularulClientuluiCompletat();
	}
	
	public void resetClientFields(){
		adaugareClient.resetFields();
	}
	public boolean esteFormularulDestinataruluiCompletat(){
		return adaugareComanda.esteFormularulDestinataruluiCompletat();
	}

}

