package com.projet.sponsoring.Controller;

import com.projet.sponsoring.Model.Login;
import com.projet.sponsoring.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService userService;

 /*   @GetMapping("")
    public List<Login> list() {
        return userService.listAllUser();
    }*/

    @RequestMapping (method=RequestMethod.POST, value = "/signup")
    public String addUser(@RequestBody Login login){
        //serviceClass.method who can save user
        return userService.addUser(login);
    }

    @RequestMapping ("/signup")
    public List<Login> getAllUsers(){
        return userService.listAllUser();
    }

/*
    @DeleteMapping Mapping("/delete{username}")
    public String removeUser(@PathVariable String username){
        //serviceClass.method who can save user
        return userService.deleteUser(username);
    }*/


}
