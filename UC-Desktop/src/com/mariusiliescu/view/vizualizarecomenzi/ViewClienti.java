package com.mariusiliescu.view.vizualizarecomenzi;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.KeyListener;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;

public class ViewClienti extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableCompany;
	private JTable tablePf;
	private JTextField searchedKey;
	private JComboBox<String> comboBox;
	private JPanel panel_1;
	
	public ViewClienti() {
		initComponents();
		setLayout();
	}
	private void initComponents(){
		searchedKey = new JTextField();
		comboBox = new JComboBox<String>(new String[]{"numeC ","cui"});
		comboBox.setMaximumRowCount(200);
	}
	private void setLayout(){
		searchedKey.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		tablePf = new JTable();
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setViewportView(tablePf);
		
		JSplitPane splitPane = new JSplitPane();
		panel_1.add(splitPane);
		tableCompany = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		splitPane.setRightComponent(scrollPane2);
		scrollPane.setViewportView(tableCompany);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchedKey, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchedKey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	public void hilightRowWithClientId(String clientId){
		for(int i=0 ; i<tableCompany.getRowCount() ; i++){
			System.out.println(tableCompany.getValueAt(i, 0).toString());
			if(tableCompany.getValueAt(i, 0).toString().equals(clientId)){
				tableCompany.setRowSelectionInterval(i,i);
			}
		}
	}
	public void setTableCompanieModel(ResultSet rs){
		tableCompany.setModel(DbUtils.resultSetToTableModel(rs));
	}
	public void setTablePersoanaFizicaModel(ResultSet rs){
		tablePf.setModel(DbUtils.resultSetToTableModel(rs));
	}
	public void addTextFieldKeyListener(KeyListener k){
		searchedKey.addKeyListener(k);
	}
	public String getSearchedKey(){
		return searchedKey.getText();
	}
	public String getFilter(){
		return comboBox.getSelectedItem().toString();
	}
}
