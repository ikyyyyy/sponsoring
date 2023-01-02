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

    @GetMapping("/signup")
    public String signup(){
        return "signupTest";
    }

    @PostMapping("/signupEntreprise")
    public String signupEntreprise(String username, String passwd,String domaine, String nom, String type, String date_construction, String activite, Double chiffre_d_affaire, HttpServletRequest request){
        entreprise.AddEntreprise(username, passwd, domaine, nom, type, date_construction, activite, chiffre_d_affaire);
        return "redirect:/signup";
    }

}
