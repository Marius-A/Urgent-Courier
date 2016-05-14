package com.mariusiliescu.view.vizualizarecomenzi;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class ViewComenzi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField searchedKey;
	private JComboBox<String> comboBox;
    private JPopupMenu menuT;
	private JMenuItem[] menuModel;
	
	public ViewComenzi() {
		initComponents();
		setLayout();
		addTableClickListener();
	}
	private void initComponents(){
		final String[] combomboModel = new String[]{"id_client","codComanda"};
		menuModel = new JMenuItem[]{new JMenuItem("Arata factura"),new JMenuItem("Arata client")};
		
		menuT = new JPopupMenu();
		for(JMenuItem m : menuModel)
			menuT.add(m);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		searchedKey = new JTextField();
		comboBox = new JComboBox<String>(combomboModel);
	}
	private void setLayout(){
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setViewportView(table);
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		searchedKey.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchedKey, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
					.addGap(140))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchedKey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		this.setLayout(groupLayout);
	}
	public void addTableClickListener(){
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int r = table.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < table.getRowCount()) {
		            table.setRowSelectionInterval(r, r);
		        } else {
		            table.clearSelection();
		        }

		        int rowindex = table.getSelectedRow();
		        if (rowindex < 0)
		            return;
				if ( e.getButton() == 3 ){ // 1-left, 2-middle, 3-right button
	                ViewComenzi.this.menuT.show(e.getComponent(), e.getX(), e.getY());
	            }
			}		
		});
	}
	public void addMenuComenziListener(ActionListener[] listeners){
		int i=0;
		for(JMenuItem m : menuModel){
			m.addActionListener(listeners[i]);
			i++;
		}
	}
	public String getSelectedRowClientId(){
		
		int row =table.getSelectedRow();
		
		System.out.println(table.getValueAt(row,5).toString());
		return table.getValueAt(row,5).toString();
	}
	public String getSelectedRowOderId(){
		
		int row =table.getSelectedRow();

		return table.getValueAt(row,0).toString();
	}
	public void setTableModel(ResultSet rs){
		table.setModel(DbUtils.resultSetToTableModel(rs));
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
