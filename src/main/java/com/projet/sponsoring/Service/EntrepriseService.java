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
    public Integer findbylogin(String username){
        List<Entreprise> l = daoEntreprise.findAll();
        Entreprise d=null;
        for(int i=0; i<l.size();i++){
            d = l.get(i);
            if(username==d.getNom()){
                return d.getId_organisme() ;
            }
        }
        Integer log=null;
        return log;
    }

    public void AddEntreprise(String username, String passwd,String domaine, String nom, String type, String date_construction, String activite, Double chiffre_d_affaire){
        Login loginEntreprise = new Login();
        loginEntreprise.setUsername(username);
        loginEntreprise.setPassword(passwd);

        Entreprise entreprise = new Entreprise();
        entreprise.setLogin(loginEntreprise);
        entreprise.setDomaine(domaine);
        entreprise.setNom(nom);
        entreprise.setType(type);
        entreprise.setDate_construction(date_construction);
        entreprise.setActivite(activite);
        entreprise.setChiffre_d_affaire(chiffre_d_affaire);
        loginEntreprise.setEntreprise(entreprise);


        daoLogin.save(loginEntreprise);
        daoEntreprise.save(entreprise);
    }

    public void AddCoordonne(){}

    public void SupprimerCoordonne(){}
}
