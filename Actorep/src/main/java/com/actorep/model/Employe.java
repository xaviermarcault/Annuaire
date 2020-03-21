package com.actorep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

@ToString(of= {"employeId", "employeNom","employePrenom","employeMdp","employeEmail","employeQuestion","employeReponse",})
@Entity
public class Employe implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employe_id",nullable=false)
	private int employeId;
	
	@ManyToOne
	@JoinColumn(name = "role_Id")
	private Role role;
	
	@Column(name="employe_nom",nullable=false, length=100)
	private String employeNom;
	
	@Column(name="employe_prenom",nullable=false, length=100)
	private String employePrenom;
	
	@Column(name="employe_mdp",nullable=false, length=50)
	private String employeMdp;
	
	@Email
	@Column(name="employe_email",nullable=false, length=100)
	private String employeEmail;
	
	@Column(name="employe_question",nullable=false, length=500)
	private String employeQuestion;
	
	@Column(name="employe_reponse",nullable=false, length=50)
	private String employeReponse;

}
