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
public class Photo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PHOTO_ID", nullable = false)
	private int photoId;

	@Column(name="PHOTO_URL", nullable = false, length=200)
	private String photoUrl;

	@ManyToOne
	@JoinColumn(name="acteur_Id")
	private Acteur acteur;
}
