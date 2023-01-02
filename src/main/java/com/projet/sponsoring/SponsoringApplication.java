package com.projet.sponsoring;

import com.projet.sponsoring.DAO.ClubDAO;
import com.projet.sponsoring.DAO.CoordonneeDAO;
import com.projet.sponsoring.DAO.EntrepriseDAO;
import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.Model.Club;
import com.projet.sponsoring.Model.Coordonnee;
import com.projet.sponsoring.Model.Entreprise;
import com.projet.sponsoring.Model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class SponsoringApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SponsoringApplication.class, args);
	}

	@Autowired
	LoginDAO daoLogin;
	@Autowired
	EntrepriseDAO daoEntreprise;
	@Autowired
	ClubDAO daoCLub;
	@Autowired
	CoordonneeDAO daoCoord;

	@Override
	public void run(String... args) throws Exception {
		/*Login loginEntreprise = new Login();
		loginEntreprise.setUsername("login1");
		loginEntreprise.setPassword("sdfg");

		List listeCoordE = new ArrayList<Coordonnee>();
		List listeCoordC = new ArrayList<Coordonnee>();

		Coordonnee c1 = new Coordonnee();
		c1.setEmail("asdj@gmail.com");
		c1.setTelephone("0823854");
		c1.setAdresse("707, mellousa");

		Coordonnee c2 = new Coordonnee();
		c2.setEmail("asdasfj@gmail.com");
		c2.setTelephone("0987654");
		c2.setAdresse("707, mastdfusa");

		listeCoordE.add(c1);
		listeCoordE.add(c2);


		Entreprise entreprise = new Entreprise();
		entreprise.setLogin(loginEntreprise);
		entreprise.setDomaine("IT");
		entreprise.setNom("Logitech");
		entreprise.setType("SARL");
		entreprise.setDate_construction("10/05/1993");
		entreprise.setActivite("sales & production");
		entreprise.setChiffre_d_affaire(10323249.0);
		c1.setEntreprise(entreprise);
		c2.setEntreprise(entreprise);
		entreprise.setListeCoordonnees(listeCoordE);
		loginEntreprise.setEntreprise(entreprise);


		daoLogin.save(loginEntreprise);
		daoEntreprise.save(entreprise);
		daoCoord.save(c1);
		daoCoord.save(c2);*/




		/*Login loginClub = new Login();
		loginClub.setUsername("login2");
		loginClub.setPassword("sdfg");

		Club club = new Club();
		club.setNom("CSC");
		club.setDescription("computer science club");
		club.setDomaine("IT");
		club.setActivite("parascolaire");
		club.setDate_construction("10/13/2007");
		club.setLogin(loginClub);

		loginClub.setClub(club);

		List listeCoordC = new ArrayList<Coordonnee>();

		Coordonnee c1 = new Coordonnee();
		c1.setEmail("asdj@gmail.com");
		c1.setTelephone("0823854");
		c1.setAdresse("707, mellousa");

		Coordonnee c2 = new Coordonnee();
		c2.setEmail("asdasfj@gmail.com");
		c2.setTelephone("0987654");
		c2.setAdresse("707, mastdfusa");

		listeCoordC.add(c1);
		listeCoordC.add(c2);

		c1.setClub(club);
		c2.setClub(club);
		club.setListeCoordonnees(listeCoordC);

		daoLogin.save(loginClub);
		daoCLub.save(club);
		daoCoord.save(c1);
		daoCoord.save(c2);*/


	}
}
