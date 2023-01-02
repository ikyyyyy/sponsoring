package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "organisme")
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Organisme {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id_organisme;
    private String nom;
    private String activite;
    private String domaine;
    private String date_construction;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

/*  public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }*/

    public Organisme(){

    }


}
