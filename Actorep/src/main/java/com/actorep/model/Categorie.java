package com.actorep.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@Entity
public class Categorie implements Serializable {

	@Id @NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categorie_id",nullable = false)
	private int categorieId;

	@Column(name="categorie_libelle",nullable = false, length = 100)
	private String categorieLibelle;

	@Column(name="categorie_valid",nullable = false)
	private boolean categorieValid;

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private Collection<Acteur> acteurs;

}
