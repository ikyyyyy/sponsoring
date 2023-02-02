package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Approuver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprouverDAO extends JpaRepository<Approuver, Integer> {

}
