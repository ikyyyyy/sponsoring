package com.projet.sponsoring.Controller;

import com.projet.sponsoring.DAO.EntrepriseDAO;
import com.projet.sponsoring.Service.EntrepriseService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntrepriseController {
    @Autowired
    EntrepriseService entreprise;

    @GetMapping("/")
    public String home(){
        return "signupTest";
    }

    @PostMapping("/signup")
    public String signup(String login, String pass,String domaine, String nom, String type, String dateConst, String activite, Double chiffre_d_affaire, HttpServletRequest request){
        entreprise.AddEntreprise(login, pass, domaine, nom, type, dateConst, activite, chiffre_d_affaire);
        return "redirect:/";
    }

}
