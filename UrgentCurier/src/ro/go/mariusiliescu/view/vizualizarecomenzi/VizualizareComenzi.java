package ro.go.mariusiliescu.view.vizualizarecomenzi;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.util.Date;

import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class VizualizareComenzi extends JPanel {
    private  JScrollPane tableView;
	private JTable table;
	
	public VizualizareComenzi() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		tableView = new  JScrollPane();
		table = new JTable();
		
		table.setModel(new CustomTableModel(
	            new String [] {
	                "Id Comanda", "Data Preluare", "Data Expediere", "Nume Client"
	            }
	        ) {
				Class<?>[] types = new Class [] {
	                String.class, Date.class, Date.class, String.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false
	            };

				public Class<?> getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
	        
	    	tableView.setViewportView(table);
	        if (table.getColumnModel().getColumnCount() > 0) {
	            table.getColumnModel().getColumn(0).setResizable(false);
	            table.getColumnModel().getColumn(1).setResizable(false);
	            table.getColumnModel().getColumn(2).setResizable(false);
	            table.getColumnModel().getColumn(3).setResizable(false);
	        }
		table.setColumnSelectionAllowed(true);
		this.add(tableView);
	}

}
