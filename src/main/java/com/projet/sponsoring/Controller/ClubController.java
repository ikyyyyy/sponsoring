package com.projet.sponsoring.Controller;

import com.projet.sponsoring.DAO.ClubDAO;
import com.projet.sponsoring.Service.ClubService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClubController {
    @Autowired
    ClubService club;
/*
    @GetMapping("/signup")
    public String signup(){
        return "signup1";
    }*/


    @PostMapping("/signupClub")
    public String signupClub(String username, String passwd,String domaine, String nom, String type, String date_construction, String activite, String description, HttpServletRequest request){
      club.AddClub(username, passwd, domaine, nom, type, date_construction, activite,description);

        return "redirect:/signup";
    }

}
