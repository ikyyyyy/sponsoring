package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.PosteDAO;
import com.projet.sponsoring.Model.Poste;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PosteService {
    @Autowired
    public PosteDAO dao;

    public String deletePoste(Integer id) {
        //Integer id = p.getId_poste();
        dao.deleteById(id);
        return "Poste deleted successfully";
    }
    public void updatePoste(Optional<Poste> p){
        dao.save(p.get());
    }
    public Optional<Poste> findbyid(Integer id){
        return dao.findById(id);
    }
}
