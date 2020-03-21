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

@ToString(of = { "roleId", "roleLibelle" })
@Entity
public class Role implements Serializable {

	@Id @NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROLE_ID", nullable = false)
	private int roleId;

	// champ ou attribut de relation
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Collection<Employe> employes;  

	// champ ou attribut de métier (modèle)
	@Column(name="ROLE_LIBELLE", nullable=false, length = 50)
	private String roleLibelle;

}
