package com.actorep.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.actorep.dao.CategorieRepository;
import com.actorep.model.Categorie;

@Service
@Transactional
public class CategorieService implements IActorepServiceCategorie {
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Override
	public Collection<Categorie> listCategories() {
		return categorieRepository.findAll();
	}
	
	@Override
	public void saveCategorie(Categorie categorie) {
		categorieRepository.save(categorie);
	}
	
	@Override
	public void deleteCategorie(int id) {
		categorieRepository.deleteById(id);
	}
	
	@Override
	public Categorie getCategorie(int id) {
		return categorieRepository.findById(id).get();
	}

}
