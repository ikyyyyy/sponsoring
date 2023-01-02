package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Coordonnee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordonneeDAO extends JpaRepository<Coordonnee, Integer> {
}
