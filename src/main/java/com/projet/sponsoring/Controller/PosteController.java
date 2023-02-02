package com.projet.sponsoring.Controller;

import com.projet.sponsoring.Model.Poste;
import com.projet.sponsoring.Service.PosteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class PosteController {
    @Autowired
    public PosteService posteservice;


    @RequestMapping(value="/myPosts", method = RequestMethod.POST)
    public ModelAndView myPosts(Model model, HttpSession session){
        Integer id = (Integer) session.getAttribute("clubID");
        /*model.addAttribute("id", id);*/
        List<Object[]> myPostes = posteservice.listClubPostes(id);
        model.addAttribute("myPostes", myPostes);

        return new ModelAndView("poste_club");
    }

    @RequestMapping(value="/updatePoste",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updatePoste(@RequestParam Integer id){
        Poste p =posteservice.findbyid(id);
        posteservice.updateposte(p);
        return new ModelAndView("home");
    }
    @DeleteMapping("/delete{id}")
    public String removePoste(@RequestParam Integer id){
        return posteservice.deletePoste(id);
    }

    /*@RequestMapping ("/listePostes")
    public List<Poste> getAllPostes(){
        return posteservice.listAllPostes_Clubs();
    }*/
}
