package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Organisation;

public interface IActorepServiceOrganisation {
	
	public Collection<Organisation> listOrganisations();

	public void saveOrganisation(Organisation organisation);

	public void deleteOrganisation(int id);

	public Organisation getOrganisation(int id);
	
	
}
