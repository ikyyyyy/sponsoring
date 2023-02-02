package com.projet.sponsoring.Controller;
import com.projet.sponsoring.Model.Club;
import com.projet.sponsoring.Model.Entreprise;
import com.projet.sponsoring.Service.ClubService;
import com.projet.sponsoring.Service.EntrepriseService;
import com.projet.sponsoring.Service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Scope("session")
public class LoginController {
    @Autowired
    private LoginService userService;
    @Autowired
    private ClubService clubservice;
    @Autowired
    private EntrepriseService entrepriseservice;
    static HttpSession httpSession;
    @GetMapping(value="/login")
    public ModelAndView index(){
        return new ModelAndView("login");
    }
    @RequestMapping  (value="/loginPage",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView LoginPage(@RequestParam  String username, String password,HttpServletRequest request, HttpServletResponse response){

        httpSession = request.getSession();
        if(userService.login(username, password, userService.listAllUser())==2){
            Club club = clubservice.findbyname(username);
            System.out.println(club.getId_organisme());
            httpSession.setAttribute("CLUB_ID", club.getId_organisme());
            System.out.println("welcome_club");
            return new ModelAndView("club_home");
        }
        if(userService.login(username, password, userService.listAllUser())==1) {
            Entreprise entreprise = entrepriseservice.findbyname(username);
            System.out.println(entreprise.getId_organisme());
            httpSession.setAttribute("ENTREPRISE_ID", entreprise.getId_organisme());
            System.out.println("welcome_entreprise");
            return new ModelAndView("Entreprise_home");
        }
        else{
            System.out.println("try again");
            return new ModelAndView("index");
        }
    }
    @GetMapping(value = {"/logout"})
    public ModelAndView logout(){
        httpSession.invalidate();
        return new ModelAndView("index");
    }


/*
    @DeleteMapping Mapping("/delete{username}")
    public String removeUser(@PathVariable String username){
        return userService.deleteUser(username);
    }*/


}
