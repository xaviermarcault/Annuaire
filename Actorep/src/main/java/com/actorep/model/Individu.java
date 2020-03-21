package com.actorep.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Individu extends Acteur {

	@Column(name="individu_nom",nullable = true, length = 100)
	private String nom;

	@Column(name="individu_prenom",nullable = true, length = 100)
	private String prenom;

	@Column(name="individu_naissance",nullable = true, length = 100)
	private String nomNaissance;

}
