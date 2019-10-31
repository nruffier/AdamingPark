package com.fr.adaming.entity;

import javax.persistence.Entity;

/**
 * @author Nicolas :)
 *
 */
@Entity
public class Client extends Personne {

	private String tel;

	public Client(int id, String nom, String prenom, String email, String tel) {
		super(id, nom, prenom, email);
		this.tel = tel;
	}

	public Client(String nom, String prenom, String email, String tel) {
		super(nom, prenom, email);
		this.tel = tel;
	}

	public Client() {
		super();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
