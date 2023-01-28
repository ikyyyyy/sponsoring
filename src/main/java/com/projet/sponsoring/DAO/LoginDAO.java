package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Login;
import com.projet.sponsoring.Model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO extends JpaRepository<Login, Integer> {

    /*public void save(Login login){}

    public void delete(String username){}*/

    Login findByUsernameAndPasswd(String username, String passwd);

/*
    public Integer getByUsernameAndPasswd(String username, String passwd);
*/

}
