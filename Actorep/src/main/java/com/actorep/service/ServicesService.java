package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.ServicesRepository;
import com.actorep.model.Services;


@Service
@Transactional
public class ServicesService implements IActorepServiceServices {
	
	@Autowired
	private ServicesRepository servicesRepository;

	@Override
	public Collection<Services> listServices() {
		return servicesRepository.findAll();
	}

	@Override
	public void saveService(Services services) {
		servicesRepository.save(services);		
	}

	@Override
	public void deleteService(int id) {
		servicesRepository.deleteById(id);		
	}

	@Override
	public Services getService(int id) {
		return servicesRepository.findById(id).get();
	}

}
