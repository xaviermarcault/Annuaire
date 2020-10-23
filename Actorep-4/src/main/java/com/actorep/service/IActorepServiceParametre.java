package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Parametre;

public interface IActorepServiceParametre {
	
	public Collection<Parametre> listParametres();
	
	public void saveParametre(Parametre parametre);
	
	public Parametre getParametre(int id);
	
	public void deleteParametre(int id);
}
