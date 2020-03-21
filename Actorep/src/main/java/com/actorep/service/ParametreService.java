package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.ParametreRepository;
import com.actorep.model.Parametre;

@Service
@Transactional
public class ParametreService implements IActorepServiceParametre {

	@Autowired
	private ParametreRepository parametreRepository;
	
	@Override
	public Collection<Parametre> listParametres() {
		return parametreRepository.findAll();
	}

	@Override
	public void saveParametre(Parametre parametre) {
		parametreRepository.save(parametre);
	}

	@Override
	public Parametre getParametre(int id) {
		return parametreRepository.findById(id).get();
	}

	@Override
	public void deleteParametre(int id) {
		parametreRepository.deleteById(id);
	}





}
