package com.actorep.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

import com.actorep.model.Acteur;
import com.actorep.model.Services;

public interface ServicesRepository extends JpaRepository<Services, Integer> {

	/*
	 * @Query("select service_id,service_descriptif,service_libelle from services order by service_id desc"
	 * )
	 */
	/* List<Services>findServices(Pageable pageable); */
	public Page<Services> findByServiceLibelleContains(String mc, Pageable pageable);
	
	/*
	 * @Query(
	 * value="select a.organisation_nom,a.individu_nom from services s,acteur a where\r\n"
	 * + "	  s.acteur_id=a.acteur_id") public List<Services>
	 * findServicesByActeur(Model model);
	 */
	
	
	/*
	 * @Query(value= "select s from services s where s.acteur.id",nativeQuery =
	 * true) public Services findByActeur(int id);
	 */
	 
}
