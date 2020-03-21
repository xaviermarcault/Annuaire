package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.OrganisationRepository;
import com.actorep.model.Organisation;


@Service
@Transactional
public class OrganisationService implements IActorepServiceOrganisation {

	@Autowired
	private OrganisationRepository organisationRepository;

	@Override
	public Collection<Organisation> listOrganisations() {
		return organisationRepository.findAll();
	}

	@Override
	public void saveOrganisation(Organisation organisation) {
		organisationRepository.save(organisation);
		
	}

	@Override
	public void deleteOrganisation(int id) {
		organisationRepository.deleteById(id);
		
	}

	@Override
	public Organisation getOrganisation(int id) {
		return organisationRepository.findById(id).get();
	}
	
	
		

}
