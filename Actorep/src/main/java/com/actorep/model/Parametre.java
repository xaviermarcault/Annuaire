package com.actorep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString(of= {"parametreId", "parametreLibelle", "parametreValeur"})
@Entity
public class Parametre implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PARAMETRE_ID", nullable=false)
	private int parametreId;
	
	@Column(name="PARAMETRE_LIBELLE", nullable=false, length=100)
	private String parametreLibelle;
	
	@Column(name="PARAMETRE_VALEUR", nullable=false, length=100)
	private String parametreValeur;

}
