package com.actorep.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(of= {"adresseId", "adresseNumero", "adresseRue"})

@Entity
public class Adresse implements Serializable {

	@Id @NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable=false)
	private int adresseId;
	
	@ManyToOne
	@JoinColumn(name = "ville_Id")
	private Ville ville;
	
	@OneToMany(mappedBy = "adresse", cascade = CascadeType.ALL)
	private Collection<Acteur> acteurs;
	
	@Column(name="adresse_numero",nullable=false, length=10)
	private String adresseNumero;
	
	@Column(name="adresse_rue",nullable=false, length=50)
	private String adresseRue;
	
}
