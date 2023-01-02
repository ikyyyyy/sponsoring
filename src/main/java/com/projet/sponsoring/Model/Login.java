package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Table(name="login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_log;
    private String username;
    private String passwd;

    @OneToOne(targetEntity = Club.class, cascade=CascadeType.ALL)
    private Club club;

    @OneToOne(targetEntity = Entreprise.class, cascade=CascadeType.ALL)
    private Entreprise entreprise;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

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