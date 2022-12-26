package com.projet.sponsoring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class Login {
    @Id
    private Integer id_log;
    private String username;
    private String password;

    public Login(){}

    public Login(int id, String name, String pass){
        id_log = id;
        username = name;
        password = pass;
    }

    public int getId_log() {
        return id_log;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId_log(int id_log) {
        this.id_log = id_log;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
