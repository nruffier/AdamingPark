package com.fr.adaming.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Nicolas :)
 *
 */
@Entity
public class Attraction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private boolean statut;
	@OneToMany(mappedBy = "attraction")
	private List<Photo> photos;
	@Column
	private String info;

	public Attraction(int id, String nom, boolean statut, List<Photo> photos, String info) {
		super();
		this.id = id;
		this.nom = nom;
		this.statut = statut;
		this.photos = photos;
		this.info = info;
	}

	public Attraction(String nom, boolean statut, List<Photo> photos, String info) {
		super();
		this.nom = nom;
		this.statut = statut;
		this.photos = photos;
		this.info = info;
	}

	public Attraction(String nom, boolean statut, String info) {
		super();
		this.nom = nom;
		this.statut = statut;
		this.info = info;
	}

	public Attraction() {
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

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
