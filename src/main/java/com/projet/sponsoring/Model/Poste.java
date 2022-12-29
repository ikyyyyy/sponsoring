package com.projet.sponsoring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.w3c.dom.Text;

import java.sql.Date;

@Entity
@Table(name="poste")
public class Poste {
    @Id
    private Integer id_poste;
    private String id_club;
    private Date date_org;
    private String contenu;
    private int priorite ;

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

    public String getId_club() {
        return id_club;
    }

    public void setId_club(String id_club) {
        this.id_club = id_club;
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
