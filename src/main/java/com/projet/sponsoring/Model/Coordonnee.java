package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "coordonnee")
public class Coordonnee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_coordonnee;
    private String email;
    private String telephone;
    private String adresse;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_organisme")
    private Club club;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_organisme")
    private Entreprise entreprise;

    public Coordonnee(){

    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
