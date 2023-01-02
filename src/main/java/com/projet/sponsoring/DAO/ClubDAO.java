package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubDAO extends JpaRepository<Club, Integer> {
}
