package com.fr.adaming.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Nicolas :)
 *
 */
@Entity
public class Billet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private double prix;
	@Column
	private Date dateAchat;
	@Column
	private Date dateDebut;
	@Column
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name = "id_type")
	private Type type;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

	public Billet(int id, double prix, Date dateAchat, Date dateDebut, Date dateFin, Type type, Client client) {
		super();
		this.id = id;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
		this.client = client;
	}

	public Billet(double prix, Date dateAchat, Date dateDebut, Date dateFin, Type type, Client client) {
		super();
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
		this.client = client;
	}

	public Billet() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
}
