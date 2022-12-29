package com.projet.sponsoring.Controller;

import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.Model.Login;
import com.projet.sponsoring.Service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@RestController
public class LoginController {
    @Autowired
    private LoginService userService;
    @GetMapping(value="/login")
    public ModelAndView index(){
        return new ModelAndView("login");
    }
    @RequestMapping  (value="/loginPage",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView LoginPage(@RequestParam  String username, String password, HttpServletResponse response){
        System.out.println(username+" "+password);
        if(userService.login(username, password, userService.listAllUser())){
            System.out.println("welcome");
            return new ModelAndView("home");
        }else{
            System.out.println("try again");
            return new ModelAndView("index");
        }
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response){
        return "index.html";
    }

    @RequestMapping ("/signup")
    public List<Login> getAllUsers(){
        return userService.listAllUser();
    }
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
