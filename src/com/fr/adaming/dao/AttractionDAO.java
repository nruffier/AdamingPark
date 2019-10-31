package com.fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;

import com.fr.adaming.entity.Attraction;
import com.fr.adaming.entity.Photo;
import com.fr.adaming.util.ConnectDB;

/**
 * 
 * @author BRIAS Guillaume
 *
 */
public class AttractionDAO {
	
	public static void ajouter(Attraction attraction) {
		ConnectDB.getConnection().beginTransaction();
		
		ConnectDB.getConnection().save(attraction);

		ConnectDB.getConnection().getTransaction().commit();
	}

	public static void supprimer(String nom) {
		
		Attraction attraction = chercherParNom(nom);

		if (attraction != null) {
			PhotoDAO.supprimer(nom);
			ConnectDB.getConnection().beginTransaction();
			ConnectDB.getConnection().delete(attraction);
			ConnectDB.getConnection().getTransaction().commit();
		}

		

	}

	public static void modifier(Attraction attraction) {
		ConnectDB.getConnection().beginTransaction();
		Attraction attractionInitiale = chercherParNom(attraction.getNom());

		attractionInitiale.setNom(attraction.getNom());
		attractionInitiale.setStatut(attraction.isStatut());
		attractionInitiale.setInfo(attraction.getInfo());

		ConnectDB.getConnection().update(attractionInitiale);

		ConnectDB.getConnection().getTransaction().commit();

	}
	
	public static List<Attraction> getAllAttractions() {

		List<Attraction> getAllAttractions = new ArrayList<Attraction>();

		String hql = "from Attraction";

		Query<Attraction> query = ConnectDB.getConnection().createQuery(hql, Attraction.class);

		getAllAttractions = query.getResultList();
		
		for(Attraction attraction : getAllAttractions) {
			attraction = AttractionDAO.getAllAttractionPhotos(attraction.getNom());
		}

		return getAllAttractions;
	}
	
	public static Attraction getAllAttractionPhotos(String nom) {

		Attraction attraction = chercherParNom(nom);

		List<Photo> getAllAttractionPhotos = new ArrayList<Photo>();

		String sql = "Select * from photo where id_attraction = (select id from attraction where nom like :x)";

		Query<Photo> query = ConnectDB.getConnection().createNativeQuery(sql, Photo.class);

		query.setParameter("x", nom);

		getAllAttractionPhotos = query.getResultList();

		attraction.setPhotos(getAllAttractionPhotos);

		return attraction;
	}

	public static Attraction chercherParNom(String nom) {

		String hql = "from Attraction where nom = :x";

		Query<Attraction> query = ConnectDB.getConnection().createQuery(hql, Attraction.class);

		query.setParameter("x", nom);

		Attraction attraction = null;

		try {
			attraction = query.getSingleResult();
		} catch (NoResultException e) {

		} catch (Exception e) {

		}

		return attraction;
	}
	
	public static int getCount() {
		Query<Attraction> query = ConnectDB.getConnection().createQuery("from Attraction where statut = true", Attraction.class);
		List<Attraction> list = query.getResultList();
		int count = list.size();
		return count;

	}

}
