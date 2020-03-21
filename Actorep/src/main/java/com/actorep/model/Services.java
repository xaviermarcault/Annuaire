package com.actorep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Services implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SERVICE_ID", nullable = false)
	private int serviceId;

	@Column(name="SERVICE_LIBELLE", nullable = false, length = 50)
	private String serviceLibelle;

	@Column(name="SERVICE_DESCRIPTIF", nullable = false, length = 5000)
	private String serviceDescriptif;

	@Column(name="SERVICE_VALID", nullable = false)
	private boolean serviceValid;

	@ManyToOne
	@JoinColumn(name = "acteurId")
	private Acteur acteur;

}
