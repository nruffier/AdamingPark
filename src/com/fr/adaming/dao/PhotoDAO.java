package com.fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;

import com.fr.adaming.entity.Photo;
import com.fr.adaming.util.ConnectDB;

/**
 * 
 * @author BRIAS Guillaume
 *
 */
public class PhotoDAO {
	public static void ajouter(Photo photo) {
		ConnectDB.getConnection().beginTransaction();

		ConnectDB.getConnection().save(photo);

		ConnectDB.getConnection().getTransaction().commit();
	}

	public static void supprimer(String nom) {
		ConnectDB.getConnection().beginTransaction();
		List<Photo> photos = chercherParNom(nom);
		if (photos != null) {
			for (Photo photo : photos) {
				ConnectDB.getConnection().delete(photo);

			}
		}
		ConnectDB.getConnection().getTransaction().commit();

	}

	public static void supprimerphoto(String nom, String url) {
		ConnectDB.getConnection().beginTransaction();
		List<Photo> photos = chercherParNom(nom);

		if (photos != null) {
			for (Photo photo : photos) {
				if (photo.getUrl() == url) {
					ConnectDB.getConnection().delete(photo);
				}
			}
		}

		ConnectDB.getConnection().getTransaction().commit();

	}

	public static List<Photo> getAllPhotos() {

		List<Photo> getAllPhotos = new ArrayList<Photo>();

		String hql = "from Photo";

		Query<Photo> query = ConnectDB.getConnection().createQuery(hql, Photo.class);

		getAllPhotos = query.getResultList();

		return getAllPhotos;
	}

	public static List<Photo> chercherParNom(String nom) {

		String sql = "select * from photo where id_attraction = (select id from attraction where nom like :x)";

		Query<Photo> query = ConnectDB.getConnection().createNativeQuery(sql, Photo.class);

		query.setParameter("x", nom);

		List<Photo> photos = null;

		try {
			photos = query.getResultList();
		} catch (NoResultException e) {

		} catch (Exception e) {

		}

		return photos;
	}

	public static Photo chercherPhotoParNom(String nom, String url) {

		String sql = "select * from photo where id_attraction = (select id from attraction where nom like :x)";

		Query<Photo> query = ConnectDB.getConnection().createNativeQuery(sql, Photo.class);

		query.setParameter("x", nom);

		List<Photo> photos = null;

		try {
			photos = query.getResultList();
		} catch (NoResultException e) {

		} catch (Exception e) {

		}

		Photo photoInitiale = null;
		for (Photo photo : photos) {
			if (photo.getUrl() == url) {
				photoInitiale = photo;
			}
		}

		return photoInitiale;
	}
}
