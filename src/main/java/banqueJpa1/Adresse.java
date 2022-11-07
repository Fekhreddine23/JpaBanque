package banqueJpa1;

import javax.persistence.Column;
import javax.persistence.Embeddable;
 

@Embeddable
public class Adresse {
	
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int id;
	
	
	@Column(name = "Numero")
	private int numero;
	
	@Column(name = "Rue")
	private String rue;
	
	@Column(name = "Code_Postal")
	private String codePostal;
	
	@Column(name = "Ville")
	private String ville;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}



	public Adresse() {
		// TODO Auto-generated constructor stub
	}

}
