package com.fr.adaming.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.fr.adaming.dao.CandidatDAO;
import com.fr.adaming.entity.Candidat;



/**
 * @author Dylan
 *
 */
@ManagedBean(name ="candidatMB")
@RequestScoped
public class GestionCandidatManagedBeans {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String cv;
	private String lm;
	private String tel;
	private List<Candidat> filtered;
	
	
	
	public List<Candidat> getFiltered() {
		return filtered;
	}
	public void setFiltered(List<Candidat> filtered) {
		this.filtered = filtered;
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
	public GestionCandidatManagedBeans(int id, String nom, String prenom, String email, String cv, String lm, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.cv = cv;
		this.lm = lm;
		this.tel = tel;
	}
	public GestionCandidatManagedBeans(String nom, String prenom, String email, String cv, String lm, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.cv = cv;
		this.lm = lm;
		this.tel = tel;
	}
	public GestionCandidatManagedBeans() {
		super();
	}
	
	public String ajouter() {
		CandidatDAO candidatDAO = new CandidatDAO();
		Candidat candidat = new Candidat(this.nom,this.prenom,this.email,this.cv,this.lm,this.tel);
		candidatDAO.ajouter(candidat);
		return "candidature.xhtml";
		
	}
	
	public String modifier() {
		
		CandidatDAO candidatDAO = new CandidatDAO();
		Candidat candidature = new Candidat(this.id,this.nom,this.prenom,this.email,this.cv,this.lm,this.tel);
		candidatDAO.modifier(candidature);
		return "index.html";
	}
	
	public String supprimer(Candidat candidat) {
		CandidatDAO candidatDAO = new CandidatDAO();
		
		candidatDAO.supprimer(candidat.getId());
		return "AfficherCandidatures.xhtml";
	}
	
	public List<Candidat> afficher() {
		
		List<Candidat> candidat = CandidatDAO.getAll();
		return candidat;
	}
	

	
}
