package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="login")
public class Login {
    @Id
    private Integer id_log;
    private String username;

    private String passwd;

    public Login(){}

    public Login(Integer d_log,String name, String pass){
        id_log = d_log;
        username = name;
        passwd = pass;
    }

    public int getId_log() {
        return id_log;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setId_log(int id_log) {
        this.id_log = id_log;
    }

    public void setPasswd(String password) {
        this.passwd = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
