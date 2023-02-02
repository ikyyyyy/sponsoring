package com.projet.sponsoring.Controller;

import com.projet.sponsoring.Model.Entreprise;
import com.projet.sponsoring.Model.Poste;
import com.projet.sponsoring.Service.EntrepriseService;
import com.projet.sponsoring.Service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


public class PosteController {
    @Autowired
    public PosteService posteservice;
    @Autowired
    public EntrepriseService entrepriseService;
    @PostMapping(value="/createPoste")
    public ModelAndView createPoste( @RequestParam("file") String contenu, MultipartFile file ){
        posteservice.createPoste(contenu, file);
        return new ModelAndView("club_home");
    }
    @DeleteMapping("/delete{id}")
    public String removePoste(@RequestParam Integer id){
        return posteservice.deletePoste(id);
    }

    @RequestMapping(value="/updatePoste",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updatePoste(@RequestParam Integer id, String contenu){
        posteservice.updatePoste(id,contenu);
        return new ModelAndView("club_home");
    }

    @RequestMapping ("/listePostes")
    public List<Poste> getAllPostes(){
        return posteservice.listAllPostes();
    }

    @PutMapping(value="/approuverPoste")
    @ResponseBody
    public ModelAndView approuverPoste(@RequestParam Integer idposte,String name){
        Entreprise e = entrepriseService.findbyname(name);
        posteservice.approuverPoste(idposte,e.getId_organisme());
        return new ModelAndView("Entreprise_home");
    }

}
