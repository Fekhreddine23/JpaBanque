package banqueJpa1;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	@Column(name = "Beneficiaire")
	private String beneficiare;

	public String getBeneficiare() {
		return beneficiare;
	}

	public void setBeneficiare(String beneficiare) {
		this.beneficiare = beneficiare;
	}

	public Virement() {
		// TODO Auto-generated constructor stub
	}
	
	public Virement(double montant, Compte compte, String beneficiare) {
		super();
		this.beneficiare = beneficiare;
	}

}
