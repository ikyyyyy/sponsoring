package com.projet.sponsoring.DAO;


import com.projet.sponsoring.Model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteDAO extends JpaRepository<Poste, Integer> {

}
