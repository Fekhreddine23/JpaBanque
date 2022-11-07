package banqueJpa1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Operation")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Date")
	private LocalDate dateOperation;

	@Column(name = "Montant")
	private Double montant;

	@Column(name = "Motif")
	private String motif;

	@ManyToOne // des operations ont un seul compte
	@JoinColumn(name = "ID_COMPTE")
	private Compte compte;

	//private List<Compte> comptes = new ArrayList<Compte>(); // liste des comptes

	public Operation() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(LocalDate localDate) {
		this.dateOperation = localDate;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	 

}
