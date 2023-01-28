package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.PosteDAO;
import com.projet.sponsoring.Model.Login;
import com.projet.sponsoring.Model.Poste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PosteService {
    @Autowired
    public PosteDAO dao;

    public void listAllPostes_Clubs(){
        List<Object[]> p = dao.listAllPostes();

        for (Object[] object : p) {
            String bet = (String) object[0];
            String name = (String) object[1];
            String week = (String) object[2];

            System.out.println(bet + " " + name + " " + week);
        }
    }

    public void listClubPostes(Integer id){
        List<Object[]> p = dao.listAllPostesByClubId(2);

        for (Object[] object : p) {
            String bet = (String) object[0];
            String name = (String) object[1];
            String week = (String) object[2];

            System.out.println(bet + " " + name + " " + week);
        }
    }

    public String deletePoste(Integer id) {
        //Integer id = p.getId_poste();
        dao.deleteById(id);
        return "Poste deleted successfully";
    }
    public Poste findbyid(Integer id_poste){
        return dao.findById(id_poste).get();
    }

    public boolean updateposte(Poste p){
        dao.save(p);
        return true;
    }


   /* public List<Poste> listAllPostesClub(Integer club_id_organisme) {
        List<Poste> postes = new ArrayList<>();
        dao.findAllByclub_id_organisme(club_id_organisme).forEach(postes::add);
        return postes;
    }*/
}
