package banqueJpa1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * Classe Compte qui peut être un LivretA ou une AssuranceVie
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Compte")
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Numero")
	private String numero;

	@Column(name = "Solde")
	private double solde;

	// ici manytomany
	// liste de clients
	// faire jointure

	@OneToMany(mappedBy = "compte") //un compte peut avoir plusieurs operations
	private List<Operation> operations = new ArrayList<Operation>();
	 
    //liste de clients
	@ManyToMany
	@JoinTable(name = "Client_compte", 
	joinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "id"))

	private List<Client> clients = new ArrayList<Client>(); // arraylist Client

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Compte() {
		// TODO Auto-generated constructor stub
	}

}
