package com.projet.sponsoring.DAO;


import com.projet.sponsoring.Model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosteDAO extends JpaRepository<Poste, Integer> {
    @Query(value = "SELECT p.contenu, p.date_org, c.nom, p.description, c.photo_profile from poste p inner join club c on c.id_organisme=p.club_id_organisme order by p.date_org DESC;", nativeQuery = true)
    List<Object[]> listAllPostes();

    @Query(value = "SELECT p.contenu, p.date_org, c.nom, p.description, c.photo_profile from poste p inner join club c on c.id_organisme=p.club_id_organisme where club_id_organisme = ? order by p.date_org DESC;", nativeQuery = true)
    List<Object[]> listAllPostesByClubId(Integer idClub);
}
