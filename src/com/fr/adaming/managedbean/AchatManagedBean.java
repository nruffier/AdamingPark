package com.fr.adaming.managedbean;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.fr.adaming.dao.BilletDAO;
import com.fr.adaming.dao.ClientDAO;
import com.fr.adaming.dao.TypeDAO;
import com.fr.adaming.entity.Billet;
import com.fr.adaming.entity.Client;
import com.fr.adaming.entity.Type;

/**
 * @author Thibaud Guilard
 * debug +Guillaume Vittoz
 */
@ManagedBean (name="achatMB")
@RequestScoped
public class AchatManagedBean {
	
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private Date dateDebut;
	private Date dateFin;
	private int normal;
	private int reduit;
	
	
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getNormal() {
		return normal;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}

	public int getReduit() {
		return reduit;
	}

	public void setReduit(int reduit) {
		this.reduit = reduit;
	}

	public double acheter() {
		
		double total;

		Date dateAchat = Date.from(Instant.now());
		
		int duree = calculDuree(dateDebut, dateFin);
		System.out.println("DEBUG calcul durée");
			
			double prixJnormal = TypeDAO.getPrixJ("normal")*duree;
			System.out.println("DEBUG recup valeur prix");
			
			double prixJreduit = TypeDAO.getPrixJ("reduit")*duree;
			System.out.println("DEBUG recup valeur prix");

			total = prixJnormal*normal+prixJreduit*reduit;
			System.out.println("DEBUG calcul total");
		
		Client client = new Client(nom, prenom, email, tel);
		
		if (ClientDAO.exist(client)==false) {
			System.out.println("DEBUG verif existence client");
			ClientDAO.register(client);
			System.out.println("DEBUG enregistrement client");
			enregistrerBillets(prixJnormal, prixJreduit, dateAchat, dateDebut, dateFin, client);
		}else {
			Client clientAvecId = ClientDAO.getClient(client);
			enregistrerBillets(prixJnormal, prixJreduit, dateAchat, dateDebut, dateFin, clientAvecId);
		}
		System.out.println(client);
		System.out.println("DEBUG assoc client/billet");
		
		
		
		return total;
	}
	
	public int calculDuree(Date popup, Date popup1) {
		Instant instantDebut = Instant.ofEpochMilli(popup.getTime());
		Instant instantFin = Instant.ofEpochMilli(popup1.getTime());
		
		LocalDateTime localdatetimeDebut = LocalDateTime.ofInstant(instantDebut, ZoneId.systemDefault());
		LocalDateTime localdatetimeFin = LocalDateTime.ofInstant(instantFin, ZoneId.systemDefault());
		
		LocalDate localDateDebut = localdatetimeDebut.toLocalDate();
		LocalDate localDateFin = localdatetimeFin.toLocalDate();
		
		Period period = Period.between(localDateDebut, localDateFin);
		int duree = period.getDays();
		return duree;
	}
	
	private void enregistrerBillets(double prixJnormal,double prixJreduit,Date dateAchat,Date dateDebut,Date dateFin,Client client) {
		int i;
		for (i=1 ; i<=(normal); i++) {
			Type type = TypeDAO.getType("normal");
			Billet billet = new Billet(prixJnormal, dateAchat, dateDebut, dateFin, type, client);
			System.out.println(client);
			BilletDAO.register(billet);
		}
		for (i=1 ; i<=(reduit); i++) {
			Type type = TypeDAO.getType("reduit");
			Billet billet = new Billet(prixJreduit, dateAchat, dateDebut, dateFin, type, client);
			BilletDAO.register(billet);
		}
		System.out.println("DEBUG enregistrement billet");
	}

}
