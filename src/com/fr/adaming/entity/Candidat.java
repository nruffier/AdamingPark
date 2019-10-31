package com.fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Nicolas :)
 *
 */
@Entity
public class Candidat extends Personne {

	@Column
	private String cv;
	@Column
	private String lm;
	@Column
	private String tel;

	public Candidat(int id, String nom, String prenom, String email, String cv, String lm, String tel) {
		super(id, nom, prenom, email);
		this.cv = cv;
		this.lm = lm;
		this.tel = tel;
	}

	public Candidat(String nom, String prenom, String email, String cv, String lm, String tel) {
		super(nom, prenom, email);
		this.cv = cv;
		this.lm = lm;
		this.tel = tel;
	}

	public Candidat(int id, String nom, String prenom, String email, String cv, String tel) {
		super(id, nom, prenom, email);
		this.cv = cv;
		this.tel = tel;
	}

	public Candidat(String nom, String prenom, String email, String cv, String tel) {
		super(nom, prenom, email);
		this.cv = cv;
		this.tel = tel;
	}

	public Candidat() {
		super();
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getLm() {
		return lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	
}
