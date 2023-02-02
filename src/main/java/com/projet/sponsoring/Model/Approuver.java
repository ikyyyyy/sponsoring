package com.projet.sponsoring.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


import java.sql.Date;
@Entity
@Data
@ToString
@Table(name = "approuver")
public class Approuver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Date d;
    @OneToOne(targetEntity = Organisme.class)
    @JoinColumn(referencedColumnName = "id_organisme")
    Integer id_entreprise;
    @OneToOne(targetEntity = Poste.class)
    @JoinColumn(referencedColumnName = "id_poste")
    Integer id_poste;

    public Approuver(Date d, Integer id_entreprise, Integer id_poste) {
        this.d = d;
        this.id_entreprise=id_entreprise;
        this.id_poste=id_poste;
    }

    public Approuver(java.util.Date d) {

    }

    public Approuver() {

    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }
}