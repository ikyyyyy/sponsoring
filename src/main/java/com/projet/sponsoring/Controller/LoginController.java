package com.projet.sponsoring.Controller;

import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.Model.Club;
import com.projet.sponsoring.Model.Entreprise;
import com.projet.sponsoring.Model.Login;
import com.projet.sponsoring.Service.ClubService;
import com.projet.sponsoring.Service.EntrepriseService;
import com.projet.sponsoring.Service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.SessionListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SessionAttributeMethodArgumentResolver;

import java.util.List;
import java.util.Objects;

@RestController
@Scope("session")
public class LoginController {
    @Autowired
    private LoginService userService;
    @Autowired
    private ClubService clubservice;
    @Autowired
    private EntrepriseService entrepriseservice;
    @GetMapping(value="/login")
    public ModelAndView index(){
        return new ModelAndView("login");
    }
    @RequestMapping  (value="/loginPage",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView LoginPage(@RequestParam  String username, String password,HttpServletRequest request, HttpServletResponse response){
        //System.out.println(username+" "+password);
        HttpSession httpSession = request.getSession();
        if(userService.login(username, password, userService.listAllUser())==2){
            Club club = clubservice.findbyname(username);
            httpSession.setAttribute("club", club);
            System.out.println("welcome_club");
            return new ModelAndView("club_home");
        }
        if(userService.login(username, password, userService.listAllUser())==1) {
            Entreprise entreprise = entrepriseservice.findbyname(username);
            httpSession.setAttribute("Entreprise", entreprise);
            System.out.println("welcome_entreprise");
            return new ModelAndView("Entreprise_home");
        }
        else{
            System.out.println("try again");
            return new ModelAndView("index");
        }
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        return "index.html";
    }

   /* @RequestMapping ("/signup")
    public List<Login> getAllUsers(){
        return userService.listAllUser();
    }*/
 /*   @GetMapping("")
    public List<Login> list() {
        return userService.listAllUser();
    }*/

   /* @RequestMapping (method=RequestMethod.POST, value = "/signup")
    public String addUser(@RequestBody Login login){
        //serviceClass.method who can save user
        return userService.addUser(login);
    }

    @RequestMapping ("/signup")
    public List<Login> getAllUsers(){
        return userService.listAllUser();
    }*/

/*
    @DeleteMapping Mapping("/delete{username}")
    public String removeUser(@PathVariable String username){
        return userService.deleteUser(username);
    }*/


}
