package com.projet.sponsoring.Controller;

import com.projet.sponsoring.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EntrepriseController {

    public LoginService service;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/signup")
    public String Signup(){
        return "signup";
    }

    @GetMapping("/login")
    public String Login(){
        return "login";
    }

    /*@PostMapping("/saveEntreprise")
    public ModelAndView saveEntreprise(@ModelAttribute Login user){
        service.addUser(user);
        return new ModelAndView("redirect:/");
    }*/
}
