package com.actorep.service;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.actorep.model.Pays;

public interface IActorepServicePays {

	public Collection<Pays> listPays();

	public void savePays(Pays Pays);

	public void deletePays(int id);

	public Pays getPays(int id);

	public Page<Pays> pagesPays(int page, int size);

	
	
}
