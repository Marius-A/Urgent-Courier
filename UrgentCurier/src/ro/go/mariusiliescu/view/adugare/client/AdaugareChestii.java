package ro.go.mariusiliescu.view.adugare.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ro.go.mariusiliescu.view.adugare.comanda.PacketDetails;
import ro.go.mariusiliescu.view.adugare.comanda.SelectPacketNum;

@SuppressWarnings("serial")
public class AdaugareChestii extends JFrame{
	private FormularAdaugareClient formularAdaugareClient;
	private SelectPacketNum selectPacketNum;
	private JScrollPane packList;
	
	public AdaugareChestii(){
		super();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setSize(new Dimension(1300,600));
        this.setMinimumSize(new Dimension(1200,600));
        this.setName("AdaugareClient");
        
        initComponents();
        setLayout();
	}
	private void initComponents(){
		formularAdaugareClient = new FormularAdaugareClient();
		selectPacketNum = new SelectPacketNum();
		packList = new JScrollPane();
	}
	private void setLayout(){
		getContentPane().setLayout(
			    new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
		);
		this.add(formularAdaugareClient,BorderLayout.BEFORE_FIRST_LINE);
		
		this.add(selectPacketNum,BorderLayout.LINE_END);
		this.add(packList);
		//this.pack();
	}

	public void addToFrame(PacketDetails p){
		packList.add(p);
		this.add(p);
		packList.repaint();
	}
	public void removeFromFrame(int index){
		packList.remove(index);
		this.remove(index);
		packList.repaint();
	}
}
