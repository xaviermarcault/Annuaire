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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString(of= {"villeId", "villeNom", "villeCodePostal"})
@Entity
public class Ville implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="VILLE_ID", nullable=false)
	private int villeId;
	
	@ManyToOne
	@JoinColumn(name = "pays_Id")
	private Pays pays;
	
	@OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
	private Collection<Adresse> adresses;
	
	@Column(name="VILLE_NOM", nullable=false, length=50)
	private String villeNom;
	
	@Column(name="VILLE_CODE_POSTAL", nullable=false, length=10)
	private String villeCodePostal;

}
