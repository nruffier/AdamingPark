package com.fr.adaming.managedbean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fr.adaming.dao.BilletDAO;
import com.fr.adaming.entity.Billet;
import com.fr.adaming.entity.Client;
import com.fr.adaming.entity.Type;


/**
 * @author Dylan
 *
 */
@ManagedBean(name ="affbilletMB")
@ViewScoped
public class AffichageBilletManagedBeans {

	private int id;
	private double prix;
	private Date dateAchat;
	private Date dateDebut;
	private Date dateFin;
	private Type type;
	private Client client;
	private List<Billet> filtered;
	
	
	
	
	
	

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

	

	public List<Billet> getFiltered() {
		return filtered;
	}

	public void setFiltered(List<Billet> filtered) {
		this.filtered = filtered;
	}

	public AffichageBilletManagedBeans() {
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

	public AffichageBilletManagedBeans(List<Billet> filtered) {
		super();
		this.filtered = filtered;
	}
	
	

public AffichageBilletManagedBeans(int id, double prix, Date dateAchat, Date dateDebut, Date dateFin, Type type,
			Client client, List<Billet> filtered) {
		super();
		this.id = id;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
		this.client = client;
		this.filtered = filtered;
	}

public List<Billet> afficher() {
		
		List<Billet> billet = BilletDAO.getAll();
		return billet;
	}	
}
