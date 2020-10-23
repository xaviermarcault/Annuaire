package com.actorep.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actorep.model.Pays;

public interface PaysRepository extends JpaRepository<Pays, Integer>{

	/* public List<Pays>findByNameContains(String mc); */
	
}
