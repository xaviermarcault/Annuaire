package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.AdresseRepository;
import com.actorep.model.Adresse;

@Service
@Transactional
public class AdresseService implements IActorepServiceAdresse {
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	@Override
	public Collection<Adresse> listAdresses() {
		return adresseRepository.findAll();
	}
	
	@Override
	public void saveAdresse(Adresse adresse) {
		adresseRepository.save(adresse);
	}
	
	@Override
	public void deleteAdresse(int id) {
		adresseRepository.deleteById(id);
	}
	
	@Override
	public Adresse getAdresse(int id) {
		return adresseRepository.findById(id).get();
	}

}
