package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Services;

public interface IActorepServiceServices {

	public Collection<Services> listServices();

	public void saveService(Services services);

	public void deleteService(int id);

	public Services getService(int id);

	
}
