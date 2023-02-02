package com.projet.sponsoring.Service;
import com.projet.sponsoring.DAO.ClubDAO;
import com.projet.sponsoring.DAO.CoordonneeDAO;
import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.Model.Club;
import com.projet.sponsoring.Model.Login;
import org.springframework.beans.factory.annotation.Autowired;


import com.projet.sponsoring.DAO.ClubDAO;
import com.projet.sponsoring.Model.Club;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    ClubDAO daoClub;
    @Autowired
    LoginDAO daoLogin;
    @Autowired
    CoordonneeDAO daoCoord;

public Club findbyname(String username){
        List<Club> l= daoClub.findAll();
        Club d=null;
        for(int i=0; i<l.size();i++){
             d = l.get(i);
            //System.out.println("name club "+ d.getNom());
            if(username==d.getNom()){

                return d;
            }
        }
        return d;
    }
    public void AddClub(String username, String passwd,String domaine, String nom, String type, String date_construction, String activite, String description){
        Login loginClub = new Login();
        loginClub.setUsername(username);
        loginClub.setPassword(passwd);

        Club club = new Club();
        club.setLogin(loginClub);
        club.setDomaine(domaine);
        club.setNom(nom);
        club.setDate_construction(date_construction);
        club.setActivite(activite);
        club.setDescription(description);
        loginClub.setClub(club);


        daoLogin.save(loginClub);
        daoClub.save(club);
    }

    public void AddCoordonne(){}

    public void SupprimerCoordonne(){}

}


