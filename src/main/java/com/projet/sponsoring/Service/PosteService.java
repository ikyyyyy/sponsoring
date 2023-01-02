package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.PosteDAO;
import com.projet.sponsoring.Model.Login;
import com.projet.sponsoring.Model.Poste;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PosteService {
    @Autowired
    public PosteDAO dao;

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

    public List<Poste> listAllPostes() {
        List<Poste> postes = new ArrayList<>();
        dao.findAll().forEach(postes::add);
        return postes;
    }
}
