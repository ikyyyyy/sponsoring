package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Organisme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismeDAO extends JpaRepository<Organisme, Integer> {
}
