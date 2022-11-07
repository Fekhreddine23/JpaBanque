package banqueJpa1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "Date_de_naissance")
	private LocalDate dateDeNaissance;

	@ManyToOne // un client a une seule banque
	@JoinColumn(name = "ID_BANQUE")
	private Banque banque;

	@Embedded // reference entre client qui possede une seule adresse
	private Adresse adresse;

	// ici manytomany
	// liste de comptes
	// faire jointure

	@ManyToMany
	@JoinTable(name = "Client_compte", joinColumns = {
			@JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID") })
	
	private List<Compte> comptes = new ArrayList<Compte>(); // arraylist Compte

	public Client() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissanceDate=" + dateDeNaissance
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate localDate) {
		this.dateDeNaissance = localDate;
	}

	/**
	 * Setter pour l'attribut adresse
	 *
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter pour l'attribut banque
	 *
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * Setter pour l'attribut banque
	 * 
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * Getter pour l'attribut comptes
	 *
	 * @return the comptes
	 */

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

}
