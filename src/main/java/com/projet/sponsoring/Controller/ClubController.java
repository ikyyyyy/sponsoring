package com.projet.sponsoring.Controller;

import com.projet.sponsoring.Service.ClubService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClubController {
    @Autowired
    ClubService club;

    @GetMapping("/signup1")
    public String signup() {
        return "signup1";
    }


    @PostMapping("/signupClub")
    public String signupClub(String username, String passwd,String domaine, String nom, String type, String date_construction, String activite, String description, HttpServletRequest request){
      club.AddClub(username, passwd, domaine, nom, type, date_construction, activite,description);

        return "redirect:/signup";
    }
    @GetMapping("/profile_club")
    public String profile() {
        return "redirect:/profile_club";
    }



}
