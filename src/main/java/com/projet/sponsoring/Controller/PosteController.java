package com.projet.sponsoring.Controller;

import com.projet.sponsoring.Model.Entreprise;
import com.projet.sponsoring.Model.Poste;
import com.projet.sponsoring.Service.EntrepriseService;
import com.projet.sponsoring.Service.PosteService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PosteController {
    @Autowired
    public PosteService posteservice;
    @Autowired
    public EntrepriseService entrepriseService;
    @GetMapping("/create")
    public String create(){
        return "postecreate";
    }
    @PostMapping("/createPost")
    @ResponseBody
    public String createPost(@RequestParam String contenu){
        Poste post = new Poste(contenu);
        posteservice.createPost(contenu);
        return "redirect:/postecreate";
    }
    @RequestMapping(value="/updatePoste",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updatePoste(@RequestParam Integer id, String contenu){
//        //Poste p =posteservice.findbyid(id);
//        //posteservice.updateposte(p);
        posteservice.updatePoste(id,contenu);
        return new ModelAndView("club_home");
    }
    @DeleteMapping("/delete{id}")
    public String removePoste(@RequestParam Integer id){
        return posteservice.deletePoste(id);
    }

//    @RequestMapping ("/listePostes")
//    public List<Poste> getAllPostes(){
//        return posteservice.listAllPostes();
//    }

    @RequestMapping(value="/approuverPoste",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView approuverPoste(@RequestParam Integer idposte,String name){
        Poste p =posteservice.findbyid(idposte);
        Entreprise e = entrepriseService.findbyname(name);
        return new ModelAndView("Entreprise_home");
    }
}
