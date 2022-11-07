package banqueJpa1;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTestBanque {

	public static void main(String[] args) {
		// Créer une instance d’entityManagerFactory
		// Créer une instance d’entityManager
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		// creation banque
		Banque banque1 = new Banque();
		banque1.setNom("Banque Populaire");
		em.persist(banque1);

		// creation banque2
		Banque banque2 = new Banque();
		banque2.setNom("Societe generale");
		em.persist(banque2);

		// creation adresse
		// embedded donc pas en base de données
		Adresse adr1 = new Adresse();
		adr1.setNumero(75);
		adr1.setRue("rue de la chance");
		adr1.setCodePostal("75000");
		adr1.setVille("Paris");
		//em.persist(adr1);

		Adresse adr2 = new Adresse();
		adr2.setNumero(23);
		adr2.setRue("Avenue de Jeanne d'Arc");
		adr2.setCodePostal("45000");
		adr2.setVille("Orléans");
		//em.persist(adr2); //on persist pas des tables qui existe pas

		// creation client
		Client clt1 = new Client();
		clt1.setNom("John");
		clt1.setPrenom("Doe");
		clt1.setDateDeNaissance(LocalDate.of(1998, 3, 6));
		clt1.setAdresse(adr1);
		clt1.setBanque(banque1);
		em.persist(clt1);

		Client clt2 = new Client();
		clt2.setNom("John");
		clt2.setPrenom("Wick");
		clt2.setDateDeNaissance(LocalDate.of(1970, 12, 24));
		clt2.setAdresse(adr2);
		clt2.setBanque(banque2);
		em.persist(clt2);

		// creation compte
		Compte cpt1 = new Compte();
		cpt1.setNumero("fr254617825");
		cpt1.setSolde(78000.00);
		em.persist(cpt1);

		Compte cpt2 = new Compte();
		cpt2.setNumero("fr478963535");
		cpt2.setSolde(34000.00);
		em.persist(cpt2);

		// association client et compte
		clt1.getComptes().add(cpt1);
		clt2.getComptes().add(cpt2);

		// creation livret A
		LivretA livret1 = new LivretA();
		livret1.setNumero("LA123456789");
		livret1.setSolde(36500);
		livret1.setTaux(2.3);
		em.persist(livret1);

		clt1.getComptes().add(livret1);

		

		// creation assuranceVie
		AssuranceVie assu1 = new AssuranceVie();
		assu1.setNumero("ASSU123456789");
		assu1.setSolde(4555.22);
		assu1.setDateFin(LocalDate.of(2030, 11, 07));
		assu1.setTaux(2.3);
		em.persist(assu1);

		clt1.getComptes().add(assu1);

		// new operation
		Operation op1 = new Operation();
		op1.setDateOperation(LocalDate.of(2022, 11, 06));
		op1.setMontant(56.00);
		op1.setMotif("achat");
		
		//clt2.getComptes().add(op1);
		em.persist(op1);

		// virement
		Virement op2 = new Virement();
		op2.setMontant(30.00);
		op2.setCompte(assu1);
		op2.setMotif("remboursement");
		em.persist(op2);
		
		
		
		transaction.commit();

	}

}
