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
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

@ToString(of={"paysId", "paysNom", "paysIso"})
@Entity
public class Pays implements Serializable {
	
	@Id @NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PAYS_ID", nullable=false)
	private int paysId;
	
	@OneToMany(mappedBy = "pays", cascade = CascadeType.ALL)
	private Collection<Ville> villes;
	
	@Column(name="PAYS_NOM", nullable=false, length=50)
	private String paysNom;
	
	@Column(name="PAYS_ISO", nullable=false, length=40)
	private String paysIso;

}
