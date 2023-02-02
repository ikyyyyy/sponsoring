package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Approuver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface ApprouverDAO extends JpaRepository<Approuver, Integer> {

}
