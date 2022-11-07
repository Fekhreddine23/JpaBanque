package banqueJpa1;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class AssuranceVie extends Compte {

	@Column(name = "Date_fin")
	private LocalDate dateFin;

	@Column(name = "Taux")
	private double taux;

	public AssuranceVie() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
