package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Adresse;

public interface IActorepServiceAdresse {

	public Collection<Adresse> listAdresses();

	public void saveAdresse(Adresse adresse);

	public void deleteAdresse(int id);

	public Adresse getAdresse(int id);

	
	
}
