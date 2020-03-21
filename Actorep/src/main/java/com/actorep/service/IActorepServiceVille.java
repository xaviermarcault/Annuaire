package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Ville;

public interface IActorepServiceVille {

	public Collection<Ville> listVilles();

	public void saveVille(Ville ville);

	public void deleteVille(int id);

	public Ville getVille(int id);
	
	
}
