package com.actorep.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.actorep.model.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Integer>{

public Page<Organisation>findByOrganisationNomContains(String mc, Pageable pageable);
	
}
