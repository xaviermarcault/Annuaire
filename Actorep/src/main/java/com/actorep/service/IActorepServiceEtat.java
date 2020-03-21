package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Etat;

public interface IActorepServiceEtat {

	public Collection<Etat> listEtats();

	public void saveEtat(Etat etat);

	public void deleteEtat(int id);

	public Etat getEtat(int id);

	
	
}
