package banqueJpa1;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class LivretA extends Compte {

	/** Taux */
	@Column(name = "Taux")
	private double taux;

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public LivretA() {
		// TODO Auto-generated constructor stub
	}

}
