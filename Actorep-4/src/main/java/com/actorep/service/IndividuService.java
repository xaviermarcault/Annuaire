package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.IndividuRepository;
import com.actorep.model.Individu;


@Service
@Transactional
public class IndividuService implements IActorepServiceIndividu {

	@Autowired
	private IndividuRepository individuRepository;
	
	@Override
	public Collection<Individu> listIndividus()  {
		return individuRepository.findAll();
	}

	@Override
	public void saveIndividu(Individu individu) {
		individuRepository.save(individu);		
	}

	@Override
	public void deleteIndividu(int id) {
		individuRepository.deleteById(id);		
	}

	@Override
	public Individu getIndividu(int id) {
		return individuRepository.findById(id).get();
	}
		

}
