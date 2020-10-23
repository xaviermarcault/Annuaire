package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Individu;

public interface IActorepServiceIndividu {

	public Collection<Individu> listIndividus();

	public void saveIndividu(Individu individu);

	public void deleteIndividu(int id);

	public Individu getIndividu(int id);
	
	
}
