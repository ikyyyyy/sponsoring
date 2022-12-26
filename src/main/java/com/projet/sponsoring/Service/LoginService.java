package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.Model.Login;
/*
import jakarta.transaction.Transactional;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    public LoginDAO dao;
    public String addUser(Login login){
        //daoLayer.saveUser
        dao.save(login);
        return "new user added successfully ; " + login.getUsername();
    }

    public Login getUser(Integer id){
        return dao.findById(id).get();
    }

    public void deleteUser(Integer id){
        dao.deleteById(id);
    }

    public List<Login> listAllUser() {
        List<Login> users = new ArrayList<>();
        dao.findAll().forEach(users::add);
        return users;
    }

    /*public String deleteUser(String username){
        Integer id = this.getId_log();
        dao.deleteById(id);
        return "user: " + username+ " deleted successfully";
    }*/
}
