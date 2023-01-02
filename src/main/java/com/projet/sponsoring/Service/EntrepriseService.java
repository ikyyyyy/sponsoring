package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.CoordonneeDAO;
import com.projet.sponsoring.DAO.EntrepriseDAO;
import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.Model.Club;
import com.projet.sponsoring.Model.Coordonnee;
import com.projet.sponsoring.Model.Entreprise;
import com.projet.sponsoring.Model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrepriseService {
    @Autowired
    EntrepriseDAO daoEntreprise;
    @Autowired
    LoginDAO daoLogin;
    @Autowired
    CoordonneeDAO daoCoord;

    public Entreprise findbyname(String username){
        List<Entreprise> l= daoEntreprise.findAll();
        Entreprise d=null;
        for(int i=0; i<l.size();i++){
            d = l.get(i);
            if(username==d.getNom()){
                return d;
            }
        }
        return d;
    }


    public void AddEntreprise(String login, String pass,String domaine, String nom, String type, String dateConst, String activite, Double chiffreAff){
        Login loginEntreprise = new Login();
        loginEntreprise.setUsername(login);
        loginEntreprise.setPassword(pass);

        List listeCoordE = new ArrayList<Coordonnee>();

        /*Coordonnee c1 = new Coordonnee();
        c1.setEmail(email);
        c1.setTelephone(telephone);
        c1.setAdresse(address);
        listeCoordE.add(c1);*/

        /*Coordonnee c2 = new Coordonnee();
        c2.setEmail("asdasfj@gmail.com");
        c2.setTelephone("0987654");
        c2.setAdresse("707, mastdfusa");
        listeCoordE.add(c2);*/


        Entreprise entreprise = new Entreprise();
        entreprise.setLogin(loginEntreprise);
        entreprise.setDomaine(domaine);
        entreprise.setNom(nom);
        entreprise.setType(type);
        entreprise.setDate_construction(dateConst);
        entreprise.setActivite(activite);
        entreprise.setChiffre_d_affaire(chiffreAff);
        //c1.setEntreprise(entreprise);
        // c2.setEntreprise(entreprise);
        entreprise.setListeCoordonnees(listeCoordE);
        loginEntreprise.setEntreprise(entreprise);


        daoLogin.save(loginEntreprise);
        daoEntreprise.save(entreprise);
        //daoCoord.save(c1);
        // daoCoord.save(c2);
    }

    public void AddCoordonne(){}

    public void SupprimerCoordonne(){}
}
