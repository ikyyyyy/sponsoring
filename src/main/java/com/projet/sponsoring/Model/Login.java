package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@ToString
@Table(name="login")
public class Login {
    @Id
    private Integer id_log;
    private String username;
    private String passwd;

    public Login(){}

    public Login(int id, String name, String pass){
        id_log = id;
        username = name;
        passwd = pass;
    }

    public int getId_log() {
        return id_log;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return passwd;
    }

    public void setId_log(int id_log) {
        this.id_log = id_log;
    }

    public void setPassword(String password) {
        this.passwd = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}