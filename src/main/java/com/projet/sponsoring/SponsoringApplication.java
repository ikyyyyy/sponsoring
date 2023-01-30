package com.projet.sponsoring;

import com.projet.sponsoring.DAO.ClubDAO;
import com.projet.sponsoring.DAO.EntrepriseDAO;
import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.DAO.PosteDAO;
import com.projet.sponsoring.Model.*;
import com.projet.sponsoring.Service.LoginService;
import com.projet.sponsoring.Service.PosteService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
	public class SponsoringApplication implements CommandLineRunner {

	@Autowired
	LoginDAO daoLogin;

	@Autowired
	EntrepriseDAO daoEntreprise;

	@Autowired
	ClubDAO daoClub;

	@Autowired
	private PosteDAO daoPoste;


	public static void main(String[] args) {

		SpringApplication.run(SponsoringApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*List<Object[]> p = daoPoste.listAllPostesByClubId(2);

		for (Object[] object : p) {
			String bet = (String) object[0];
			String name = (String) object[1];
			String week = (String) object[2];

			System.out.println(bet + " " + name + " " + week);
		}*/

		/*Login the_login = daoLogin.findByUsernameAndPasswd("ikram", "passwd");
		Integer the_id = the_login.getClub_id_organisme();
		Club the_club = the_login.getClub();
		System.out.println(the_club);
		List<Poste> liste = the_club.getListePostes();
		for(int i=0; i< liste.size(); i++){
			System.out.println(liste.get(i));
		}*/


	}


		/*Login loginEntreprise = new Login();
		loginEntreprise.setUsername("username");
		loginEntreprise.setPassword("passwd");

		Entreprise entreprise = new Entreprise();
		entreprise.setLogin(loginEntreprise);
		entreprise.setDomaine("domaine");
		entreprise.setNom("nom");
		entreprise.setType("type");
		entreprise.setDate_construction("date_construction");
		entreprise.setActivite("activite");
		entreprise.setChiffre_d_affaire(3456789.987);
		loginEntreprise.setEntreprise(entreprise);
		daoLogin.save(loginEntreprise);
		daoEntreprise.save(entreprise);*/


/*
		Login loginClub = new Login();
		loginClub.setUsername("username");
		loginClub.setPassword("passwd");

		Club club = new Club();
		club.setLogin(loginClub);
		club.setDomaine("domaine");
		club.setNom("nom");
		club.setDate_construction("date_construction");
		club.setActivite("activite");
		club.setDescription("description");
		loginClub.setClub(club);

		Poste poste1 = new Poste();
		poste1.setClub(club);
		poste1.setContenu("link");
		poste1.setPriorite(0);

		Poste poste2 = new Poste();
		poste2.setClub(club);
		poste2.setContenu("link");
		poste2.setPriorite(0);

		List postes = new ArrayList<Poste>();
		postes.add(poste1);
		postes.add(poste2);
		club.setListePostes(postes);


		daoLogin.save(loginClub);
		daoClub.save(club);
		daoPoste.save(poste1);
		daoPoste.save(poste2);*/


/*

		Login loginClub1 = new Login();
		loginClub1.setUsername("ikram");
		loginClub1.setPassword("passwd");

		Club club1 = new Club();
		club1.setLogin(loginClub1);
		club1.setDomaine("domaine");
		club1.setNom("nom");
		club1.setDate_construction("date_construction");
		club1.setActivite("activite");
		club1.setDescription("description");
		loginClub1.setClub(club1);

		Poste poste = new Poste();
		poste.setClub(club1);
		poste.setContenu("link");
		poste.setPriorite(0);

		List postes = new ArrayList<Poste>();
		postes.add(poste);
		club1.setListePostes(postes);

		daoLogin.save(loginClub1);
		daoClub.save(club1);
		daoPoste.save(poste);


		/*List<Poste> liste = daoPoste.findAll();
		liste.forEach(p->{
			System.out.println(p);
			});*/



}
