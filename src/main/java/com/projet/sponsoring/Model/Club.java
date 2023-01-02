package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
@Table(name = "club")
public class Club extends Organisme{
    private String description;
    @OneToOne(targetEntity = Login.class)
    private Login login;

    @OneToMany(fetch= FetchType.LAZY, targetEntity = Coordonnee.class, cascade = CascadeType.ALL)
    private List listeCoordonnees;

    @OneToMany(fetch= FetchType.LAZY, targetEntity = Poste.class, cascade = CascadeType.ALL)
    private List listePostes;

    public List getListePostes() {
        return listePostes;
    }

    public void setListePostes(List listePostes) {
        this.listePostes = listePostes;
    }

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
