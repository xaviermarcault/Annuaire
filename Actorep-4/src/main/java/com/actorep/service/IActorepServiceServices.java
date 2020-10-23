package com.actorep.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.actorep.model.Services;

public interface IActorepServiceServices {

	public Collection<Services> listServices();

	public void saveService(Services services);

	public void deleteService(int id);

	public Services getService(int id);

	public Page<Services> findByServiceLibelleContains(String mc, Pageable pageable);
	
	/* public Services findByActeur(int id); */
}
