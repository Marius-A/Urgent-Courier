package ro.go.mariusiliescu.entities.persoane;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import ro.go.mariusiliescu.entities.TipClient;

@Entity
@Table(name= "CLIENT")
@Inheritance(strategy=InheritanceType.JOINED) //Least normalisation strategy 
public abstract class Client {
	
	@Id
    @GeneratedValue
    @Column(name="ID_CLIENT")
	int idClient=0;
	
	@Enumerated(EnumType.STRING)
	TipClient tipClient = TipClient.nou;
	
	
}
