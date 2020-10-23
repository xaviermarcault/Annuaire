package com.actorep.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@DiscriminatorValue("Organisation")
public class Organisation extends Acteur {

	@Column(name="ORGANISATION_NOM", nullable = true, length = 100)
	private String organisationNom;

	@Column(name="ORGANISATION_NUMERO", nullable = true, length = 50)
	private String organisationNumero;

}
