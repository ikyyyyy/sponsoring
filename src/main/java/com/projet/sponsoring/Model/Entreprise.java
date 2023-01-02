package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
@Table(name = "entreprise")
public class Entreprise extends Organisme{
    private String type;
    private Double chiffre_d_affaire;

    @OneToOne(targetEntity = Login.class)
    private Login login;

    @OneToMany(fetch= FetchType.LAZY, targetEntity = Coordonnee.class, cascade = CascadeType.ALL)
    private List listeCoordonnees;

    public List getListeCoordonnees() {
        return listeCoordonnees;
    }

    public void setListeCoordonnees(List listeCoordonnees) {
        this.listeCoordonnees = listeCoordonnees;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

}
