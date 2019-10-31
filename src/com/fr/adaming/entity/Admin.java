package com.fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Nicolas :)
 *
 */
@Entity
public class Admin extends Personne {
	
	@Column(unique = true, nullable = true)
	private String username;
	@Column(nullable = true)
	private String pwd;
	
	public Admin(int id, String nom, String prenom, String email, String username, String pwd) {
		super(id, nom, prenom, email);
		this.username = username;
		this.pwd = pwd;
	}

	public Admin(String nom, String prenom, String email, String username, String pwd) {
		super(nom, prenom, email);
		this.username = username;
		this.pwd = pwd;
	}

	public Admin() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
