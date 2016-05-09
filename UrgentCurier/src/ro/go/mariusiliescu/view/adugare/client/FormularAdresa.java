package ro.go.mariusiliescu.view.adugare.client;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ro.go.mariusiliescu.entities.Adresa;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormularAdresa extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField judet;
	private JTextField tara;
	private JTextField sector;
	private JTextField oras;
	private JTextField strada;
	private JTextField numar;
	private JTextField bloc;
	private JTextField scara;
	private JTextField etaj;
	private JTextField apartament;
	
	public FormularAdresa(){
		super();
		initComponents();
		setLayout();
	}
	private void initComponents(){
		this.judet		= new JTextField();
		judet.setColumns(3);
		this.tara  		= new JTextField();
		this.sector		= new JTextField();
		this.oras 		= new JTextField();
		this.strada 	= new JTextField();
		this.numar 		= new JTextField();
		this.bloc		= new JTextField();
		this.scara 		= new JTextField();
		this.etaj		= new JTextField();
		this.apartament = new JTextField();
	}
	private void setLayout(){
		
		JLabel label = new JLabel("Tara");
		JLabel label_1 = new JLabel("Judet");
		JLabel label_2 = new JLabel("Oras");
		
		JLabel label_3 = new JLabel("Sector");

				
		JLabel label_4 = new JLabel("Strada");

		JLabel label_5 = new JLabel("Nr.");
		
		JLabel label_6 = new JLabel("Bl.");
		
		JLabel label_7 = new JLabel("Sc.");
		
		JLabel label_8 = new JLabel("Et.");
	
		JLabel label_9 = new JLabel("Ap.");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(strada, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(14)
							.addComponent(tara, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(judet, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
							.addGap(23)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_6)
							.addGap(0)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(bloc, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(oras, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scara, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_8)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(etaj, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sector, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(apartament, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(tara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(judet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_3)
							.addComponent(sector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2)
							.addComponent(oras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(numar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6)
						.addComponent(label_7)
						.addComponent(scara, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(etaj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_9)
						.addComponent(apartament, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(strada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bloc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
	
	public Adresa getAdresa(){
		return new Adresa(!tara.getText().equals("")? tara.getText():"-" , !judet.getText().equals("")? judet.getText():"-",
				!oras.getText().equals("")?oras.getText():"-", !strada.getText().equals("")?strada.getText():"-",
				!numar.getText().equals("")?numar.getText():"-",
				!bloc.getText().equals("-")?bloc.getText():"-",
				!scara.getText().equals("")?scara.getText():"-",
				!apartament.getText().equals("")?apartament.getText():"-");
	}
	
	public void resetFields(){
		judet.setText("");
		tara.setText("");
		sector.setText("");
		oras.setText("");
		strada.setText("");
		numar.setText("");
		bloc.setText("");
		scara.setText("");
		etaj.setText("");
		apartament.setText("");
	}
	
	public boolean esteFormularulDeAdresaCompletat(){
		if(judet.getText().equals("") || tara.getText().equals("") ||
			oras.getText().equals("") || strada.getText().equals("") ||numar.getText().equals(""))
			return false;
		else
			return true;
	}
}
