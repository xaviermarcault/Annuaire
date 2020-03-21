package com.actorep.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actorep.model.Acteur;

public interface ActeurRepository extends JpaRepository<Acteur, Integer>{

}