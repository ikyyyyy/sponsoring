package com.projet.sponsoring.Controller;

import com.projet.sponsoring.Model.Poste;
import com.projet.sponsoring.Service.PosteService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public class PosteController {
    @Autowired
    public PosteService posteservice;

    @RequestMapping(value="/updatePoste",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView updatePoste(@RequestParam Integer id){
        Optional<Poste> p =posteservice.findbyid(id);
        posteservice.updatePoste(p);
        return new ModelAndView("index");

    }
    @DeleteMapping("/delete{id}")
    public String removeUser(@RequestParam Integer id){
        return posteservice.deletePoste(id);
    }
}
