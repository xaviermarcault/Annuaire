package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.EtatRepository;
import com.actorep.model.Etat;

@Service
@Transactional
public class EtatService implements IActorepServiceEtat {
	
	@Autowired
	private EtatRepository etatRepository;
	
	@Override
	public Collection<Etat> listEtats() {
		return etatRepository.findAll();
	}
	
	@Override
	public void saveEtat(Etat etat) {
		etatRepository.save(etat);
	}
	
	@Override
	public void deleteEtat(int id) {
		etatRepository.deleteById(id);
	}
	
	@Override
	public Etat getEtat(int id) {
		return etatRepository.findById(id).get();
	}

}
