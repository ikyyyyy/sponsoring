package com.projet.sponsoring.DAO;

import com.projet.sponsoring.Model.Poste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteDAO extends CrudRepository<Poste, Integer> {

}
