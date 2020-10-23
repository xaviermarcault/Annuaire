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
public class Etat implements Serializable {

	@Id @NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="etat_id",nullable = false)
	private int etatId;

	@Column(name="etat_libelle",nullable = false, length = 20)
	private String etatLibelle;

	@OneToMany(mappedBy = "etat", cascade = CascadeType.ALL)
	private Collection<Acteur> acteurs;
}
