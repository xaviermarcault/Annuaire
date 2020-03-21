package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.VilleRepository;
import com.actorep.model.Ville;

@Service
@Transactional
public class VilleService implements IActorepServiceVille {
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Override
	public Collection<Ville> listVilles() {
		return villeRepository.findAll();
	}
	
	@Override
	public void saveVille(Ville ville) {
		villeRepository.save(ville);
	}
	
	@Override
	public void deleteVille(int id) {
		villeRepository.deleteById(id);
	}
	
	@Override
	public Ville getVille(int id) {
		return villeRepository.findById(id).get();
	}

}
