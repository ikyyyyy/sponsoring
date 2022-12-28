package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginDAO extends CrudRepository<Login, Integer> {
    /*public void save(Login login){}

    public void delete(String username){}*/

}
