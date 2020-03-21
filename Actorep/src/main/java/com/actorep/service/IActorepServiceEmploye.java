package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Employe;

public interface IActorepServiceEmploye {
	
	public Collection<Employe> listEmployes();
	
	public void deleteEmploye(int id);
	
	public void saveEmploye(Employe employe);
	
	public Employe getEmploye(int id);

	
}
