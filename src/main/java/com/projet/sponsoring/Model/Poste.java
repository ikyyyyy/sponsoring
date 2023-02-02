package com.projet.sponsoring.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.Text;

import java.sql.Date;

@Entity
@Data

@Table(name="poste")
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_poste;
    private Date date_org;
    private String contenu;
    private Integer priorite ;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id_organisme")
    private Club club;

    public void setClub(Club club) {
        this.club = club;
    }

    public Club getClub() {
        return club;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_org() {
        return date_org;
    }

    public void setDate_org(Date date_org) {
        this.date_org = date_org;
    }


    public Integer getId_poste() {
        return id_poste;
    }

    public void setId_poste(Integer id_poste) {
        this.id_poste = id_poste;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }


}
