package com.projet.sponsoring.Service;

import com.projet.sponsoring.DAO.LoginDAO;
import com.projet.sponsoring.Model.Club;
import com.projet.sponsoring.Model.Entreprise;
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
    public int login(String username, String password, List<Login> l) {
        //List<Login> users = l;
        Login d =null;
        System.out.println("loginservice traitment");
        for(int i =0 ; i < l.size() ; i++){
            d =l.get(i);
            System.out.println("username is: "+d.getUsername()+" and password is: "+d.getPassword());
            if(username.equals(d.getUsername()) && password.equals(d.getPassword())){
                System.out.println(d.getClub_id_organisme());
                if(d.getClub_id_organisme()==null){
                    System.out.println("its an entreprise");
                    return 1;
                }
                System.out.println("its a club");
                return 2;
            }
        }
        return 0;
    }

   /* public int getLoginId(String username, String password) {
        Login d =null;
        List<Login> l = new ArrayList<>();
        for(int i =0 ; i < l.size() ; i++) {
            d = l.get(i);
            if (username.equals(d.getUsername()) && password.equals(d.getPassword())) {
                return d.getClub_id_organisme();
            }
        }
        return 0;
    }*/


    /*public Login getUser(Integer id){
        return dao.findById(id).get();
    }

    public void deleteUser(Integer id){
        dao.deleteById(id);
    }
*/
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
