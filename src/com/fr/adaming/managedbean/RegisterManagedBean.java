package com.fr.adaming.managedbean;

import javax.faces.bean.ManagedBean;

import com.fr.adaming.dao.AdminDAO;
import com.fr.adaming.entity.Admin;

@ManagedBean(name = "registerMB")
public class RegisterManagedBean {
	private String nom;
	private String prenom;
	private String username;
	private String email;
	private String pwd;
	public RegisterManagedBean(String nom, String prenom, String username, String email, String pwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.email = email;
		this.pwd = pwd;
	}
	public RegisterManagedBean() {
		super();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "RegisterManagedBean [nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", email=" + email
				+ ", pwd=" + pwd + "]";
	}
	
	public String register() {
		System.out.println("DEBUG username : " + this.username);
		System.out.println("DEBUG pwd : " + this.pwd);

		Admin admin = new Admin(this.nom, this.prenom, this.email, this.username, this.pwd);

		if (AdminDAO.register(admin) == true) {
			// SUCCESS
			System.out.println("DEBUG SUCCESS");
			return "SUCCESS";
		} else {
			// FAIL
			System.out.println("DEBUG FAIL !!");
			return "FAIL";
		}

	}
}
