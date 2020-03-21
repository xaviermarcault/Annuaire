package com.actorep.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.validation.constraints.Email;


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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Acteur implements Serializable {
	@Id @NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acteur_id",nullable = false)
	private int acteurId;

	@Email
	@Column(name="acteur_email",nullable = false, length = 100, unique = true)
	private String acteurEmail;

	@Column(name="acteur_mdp",nullable = false, length = 50)
	private String acteurMDP;

	@Column(name="acteur_question",nullable = false, length = 500)
	private String acteurQuestion;

	@Column(name="acteur_reponse",nullable = false, length = 50)
	private String acteurReponse;

	@Column(name="acteur_tel",length = 20)
	private String acteurTel;

	@Column(name="acteur_experience",length = 2000)
	private String acteurExperience;

	@Column(name="acteur_video",length = 500)
	private String acteurVideo;

	@Column(name="acteur_image",length = 500)
	private String acteurImage;

	@Column(name="acteur_site",length = 500)
	private String acteurSite;

	@Column(name="acteur_valid",nullable = false)
	private boolean acteurValid;

	@Column(name="acteur_inscription", nullable=false)
	private Date acteurInscription;

	@ManyToOne
	@JoinColumn(name = "categorie_Id")
	private Categorie categorie;

	@OneToMany(mappedBy = "acteur", cascade = CascadeType.ALL)
	private Collection<Services> services;

	@OneToMany(mappedBy = "acteur", cascade = CascadeType.ALL)
	private Collection<Photo> photos;

	@ManyToOne
	@JoinColumn(name = "etat_Id")
	private Etat etat;

	@ManyToOne
	@JoinColumn(name = "adresse_Id")
	private Adresse adresse;

}
