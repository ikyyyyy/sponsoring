package com.projet.sponsoring.Controller;

import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.DAO.PosteDAO;
import com.projet.sponsoring.Model.Club;
import com.projet.sponsoring.Model.Entreprise;
import com.projet.sponsoring.Model.Login;
import com.projet.sponsoring.Model.Poste;
import com.projet.sponsoring.Service.ClubService;
import com.projet.sponsoring.Service.EntrepriseService;
import com.projet.sponsoring.Service.LoginService;
import com.projet.sponsoring.Service.PosteService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.SessionListener;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SessionAttributeMethodArgumentResolver;

import java.io.IOException;
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

    @Autowired
    private PosteService posteservice;
    @GetMapping(value="/login")
    public ModelAndView index(){
        return new ModelAndView("login");
    }




   @GetMapping("/club_home")
    public ModelAndView processClub(Model model, HttpSession session){
        Integer id = (Integer) session.getAttribute("clubID");
        model.addAttribute("id", id);
        //System.out.println("id "+id);
       List<Object[]> allPostes = posteservice.listAllPostes();
       model.addAttribute("allPostes", allPostes);

       List<Object[]> myPostes = posteservice.listClubPostes(id);
       model.addAttribute("myPostes", myPostes);

        return new ModelAndView("club_home");
    }

    @GetMapping("/entreprise_home")
    public ModelAndView processEntreprise(Model model, HttpSession session){
        Integer id = (Integer) session.getAttribute("entrepriseID");
        model.addAttribute("id", id);
        //System.out.println("id "+id);
        List<Object[]> allPostes = posteservice.listAllPostes();
        model.addAttribute("allPostes", allPostes);


        return new ModelAndView("Entreprise_home");
    }




    @RequestMapping  (value="/loginPage",method = RequestMethod.POST)
    public void LoginPage(@RequestParam  String username, String password,HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*HttpSession httpSession = request.getSession();*/
        if (userService.login(username, password, userService.listAllUser()) == 2) {
            Login d = null;
            List<Login> l = userService.listAllUser();
            for (int i = 0; i < l.size(); i++) {
                d = l.get(i);
                if (username.equals(d.getUsername()) && password.equals(d.getPassword())) {
                    System.out.println("hahowaaa " + d.getClub().getId_organisme());
                    //System.out.println(club);
                    request.getSession().setAttribute("clubID", d.getClub().getId_organisme());
                    response.sendRedirect("club_home");
                }
            }
        }
        if (userService.login(username, password, userService.listAllUser()) == 1) {
            Login d = null;
            List<Login> l = userService.listAllUser();
            for (int i = 0; i < l.size(); i++) {
                d = l.get(i);
                if (username.equals(d.getUsername()) && password.equals(d.getPassword())) {
                    System.out.println("hahowa " + d.getEntreprise().getId_organisme());
                    //System.out.println(club);
                    request.getSession().setAttribute("entrepriseID", d.getEntreprise().getId_organisme());
                    response.sendRedirect("entreprise_home");
                }
            }
        }

        /*ystem.out.println("try again");
        return "redirect:/index";*/

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
