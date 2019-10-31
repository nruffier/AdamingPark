package com.fr.adaming.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fr.adaming.dao.AdminDAO;
import com.fr.adaming.entity.Admin;

/**
 * 
 * @author BRIAS Guillaume
 *
 */
@ManagedBean(name = "adminMB")
@SessionScoped
public class AdminManagedBean {
	private String nom;
	private String prenom;
	private String email;
	private String username;
	private String pwd;
	private List<Admin> filtered;
	
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public List<Admin> getFiltered() {
		return filtered;
	}
	public void setFiltered(List<Admin> filtered) {
		this.filtered = filtered;
	}
	
	public AdminManagedBean() {
		super();
	}
	public AdminManagedBean(String nom, String prenom, String email, String username, String pwd,
			List<Admin> filtered) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.username = username;
		this.pwd = pwd;
		this.filtered = filtered;
	}
	// USERNAME UNIQUE ?
	// REDIRECTION ?
	public List<Admin> afficher() {
		
		List<Admin> admins = AdminDAO.getAllAdmins();
		
		return admins;
	}
	// REDIRECTION ?
	public String update(Admin admin) {
		this.nom = admin.getNom();
		this.prenom = admin.getPrenom();
		this.email = admin.getEmail();
		this.username = admin.getUsername();
		this.pwd = admin.getPwd();
		
		return "SUCCESS";
	}
	
	public String modifier() {
		
		Admin admin = new Admin(this.nom,this.prenom,this.email,this.username,this.pwd);
		
		AdminDAO.modifier(admin);
		
		return "SUCCESS";
		
	}
	// REDIRECTION ?
	public void supprimer(Admin admin) {
		
		AdminDAO.supprimer(admin.getUsername());
		
	}
	// REDIRECTION ?
	public void ajouter() {
		Admin admin = new Admin(this.nom, this.prenom, this.email, this.username, this.pwd);
		AdminDAO.ajouter(admin);
		
		this.nom = null;
		this.prenom = null;
		this.email = null;
		this.username = null;
		this.pwd = null;
		
	}
}
