package com.actorep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actorep.model.Acteur;
import com.actorep.model.Categorie;

public interface ActeurRepository extends JpaRepository<Acteur, Integer>{


}