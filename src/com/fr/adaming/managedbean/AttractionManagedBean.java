package com.fr.adaming.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.fr.adaming.dao.AttractionDAO;
import com.fr.adaming.dao.PhotoDAO;
import com.fr.adaming.entity.Attraction;
import com.fr.adaming.entity.Photo;

/**
 * 
 * @author BRIAS Guillaume
 *
 */
@ManagedBean(name = "attractionMB")
@SessionScoped
public class AttractionManagedBean {

	private String nom;
	private boolean statut;
	private String info;
	private String photoAjoutee;
	private List<String> photos = new ArrayList<String>();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPhotoAjoutee() {
		return photoAjoutee;
	}

	public void setPhotoAjoutee(String photoAjoutee) {
		this.photoAjoutee = photoAjoutee;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public AttractionManagedBean() {
		super();
	}

	public AttractionManagedBean(String nom, boolean statut, String info, String photoAjoutee, List<String> photos) {
		super();
		this.nom = nom;
		this.statut = statut;
		this.info = info;
		this.photoAjoutee = photoAjoutee;
		this.photos = photos;
	}

	public List<Attraction> afficher() {

		List<Attraction> allAttractions = AttractionDAO.getAllAttractions();

		return allAttractions;

	}
	
	public String modifier(Attraction attraction) {
		
		this.nom = attraction.getNom();
		this.statut = attraction.isStatut();
		this.info = attraction.getInfo();
		List<Photo> listPhoto = PhotoDAO.chercherParNom(this.nom);
		this.photos.clear();
		for(Photo photo : listPhoto) {
			this.photos.add(photo.getUrl());
		}
		
		return "SUCCESS";
	}

	public String update() {

		Attraction attraction = new Attraction(this.nom, this.statut, this.info);
		AttractionDAO.modifier(attraction);
		PhotoDAO.supprimer(this.nom);
		for (String url : this.photos) {
			Photo photo = new Photo(url, AttractionDAO.chercherParNom(this.nom));
			PhotoDAO.ajouter(photo);
		}
		
		this.nom = null;
		this.statut = false;
		this.info = null;
		this.photoAjoutee = null;
		this.photos.clear();

		return "SUCCESS";

	}

	public String supprimer(Attraction attraction) {

		AttractionDAO.supprimer(attraction.getNom());

		return null;

	}

	public String supprimerPhoto(String photo) {

		this.photos.remove(photo);

		return null;
	}

	public String create() {

		Attraction attraction = new Attraction(this.nom, this.statut, this.info);
		AttractionDAO.ajouter(attraction);

		for (String url : this.photos) {
			Photo photo = new Photo(url, attraction);
			PhotoDAO.ajouter(photo);
		}
		
		this.nom = null;
		this.statut = false;
		this.info = null;
		this.photoAjoutee = null;
		this.photos.clear();

		return "SUCCESS";
	}

	public String sauverPhoto() {
		this.photos.add(this.photoAjoutee);
		this.photoAjoutee = null;
		return null;
	}

}
