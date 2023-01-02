package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.ClubDAO;
import com.projet.sponsoring.Model.Club;

import java.util.List;

public class ClubService {
    ClubDAO clubdao;
    public Club findbyname(String username){
        List<Club> l= clubdao.findAll();
        Club d=null;
        for(int i=0; i<l.size();i++){
             d = l.get(i);
            if(username==d.getNom()){
                return d;
            }
        }
        return d;
    }
}
