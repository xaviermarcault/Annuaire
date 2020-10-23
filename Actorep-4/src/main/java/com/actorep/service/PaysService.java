package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.PaysRepository;
import com.actorep.model.Pays;

@Service
@Transactional
public class PaysService implements IActorepServicePays {
	
	@Autowired
	private PaysRepository paysRepository;
	
	@Override
	public Collection<Pays> listPays() {
		return paysRepository.findAll();
	}
	
	@Override
	public void savePays(Pays Pays) {
		paysRepository.save(Pays);
	}
	
	@Override
	public void deletePays(int id) {
		paysRepository.deleteById(id);
	}
	
	@Override
	public Pays getPays(int id) {
		return paysRepository.findById(id).get();
	}

}
