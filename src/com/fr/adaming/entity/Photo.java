package com.fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Guillaume Brias
 *
 */
@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String url;

	@ManyToOne
	@JoinColumn(name = "id_attraction")
	private Attraction attraction;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Attraction getAttraction() {
		return attraction;
	}

	public void setAttraction(Attraction attraction) {
		this.attraction = attraction;
	}

	public Photo(int id, String url, Attraction attraction) {
		super();
		this.id = id;
		this.url = url;
		this.attraction = attraction;
	}

	public Photo(String url, Attraction attraction) {
		super();
		this.url = url;
		this.attraction = attraction;
	}

	public Photo() {
		super();
	}
	
	

}
