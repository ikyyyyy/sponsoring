package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.ApprouverDAO;
import com.projet.sponsoring.DAO.PosteDAO;
import com.projet.sponsoring.Model.Approuver;
import com.projet.sponsoring.Model.Poste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileDescriptor;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class PosteService {
    @Autowired
    public PosteDAO dao;
    @Autowired
    public ApprouverDAO dao2;
    public void approuverPoste(Integer e , Integer c){
        Date d= new Date();
        Approuver app = new Approuver((java.sql.Date) d, e, c);
        app.setD((java.sql.Date) d);
        dao2.save(app);
    }
    public void createPoste(String contenu, MultipartFile f){
        Poste p = new Poste();
        p.setContenu(contenu);
        dao.save(p);
    }
    public String deletePoste(Integer id) {
        dao.deleteById(id);
        return "Poste deleted successfully";
    }
    public Poste findbyid(Integer id_poste){
        return dao.findById(id_poste).get();
    }

    public List<Poste> listAllPostes() {
        List<Poste> postes = new ArrayList<>();
        dao.findAll().forEach(postes::add);
        return postes;
    }
    public boolean updatePoste(Integer id, String contenu){
        List<Poste> p = listAllPostes();
        Poste t;
        for(int i=0; i<p.size(); i++){
            if(p.get(i).getId_poste()==id){
                p.get(i).setContenu(contenu);
                dao.save(p.get(i));
                return true;
            }
        }
        return false;

    }
}
