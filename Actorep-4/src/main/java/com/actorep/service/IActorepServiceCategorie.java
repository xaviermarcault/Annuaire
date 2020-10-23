package com.actorep.service;

import java.util.Collection;

import com.actorep.model.Categorie;

public interface IActorepServiceCategorie {

	public Collection<Categorie> listCategories();

	public void saveCategorie(Categorie categorie);

	public void deleteCategorie(int id);

	public Categorie getCategorie(int id);
	
}
