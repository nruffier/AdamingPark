package com.fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Nicolas :)
 *
 */
@Entity
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private double prixJ;
	
	
	public Type(int id, String nom, double prixJ) {
		super();
		this.id = id;
		this.nom = nom;
		this.prixJ = prixJ;
	}

	public Type(String nom, double prixJ) {
		super();
		this.nom = nom;
		this.prixJ = prixJ;
	}

	public Type() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrixJ() {
		return prixJ;
	}

	public void setPrixJ(double prixJ) {
		this.prixJ = prixJ;
	}
	
	
	
}
