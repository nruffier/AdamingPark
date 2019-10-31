package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.fr.adaming.entity.*;
import com.fr.adaming.util.*;



/**
 * @author Dylan
 *
 */
public class CandidatDAO{

	public static void ajouter (Candidat candidat) {
		ConnectDB.getConnection().beginTransaction();
		ConnectDB.getConnection().save(candidat);
		ConnectDB.getConnection().getTransaction().commit();
		
		
		
		
	}
	
	
	public static void supprimer(int id) {
		ConnectDB.getConnection().beginTransaction();
		String sql = "SELECT * FROM Candidat WHERE id =:x";
		Query<Candidat> query = ConnectDB.getConnection().createNativeQuery(sql,Candidat.class);
		query.setParameter ("x", id);
		Candidat candidat = query.getSingleResult();
		ConnectDB.getConnection().delete(candidat);
		ConnectDB.getConnection().getTransaction().commit();
		
	}
	
	public static void modifier(Candidat candidat) {
		
		
		
		ConnectDB.getConnection().beginTransaction();
		ConnectDB.getConnection().merge(candidat);
		ConnectDB.getConnection().getTransaction().commit();
	}
	
	public static List<Candidat> getAll() {
		Query<Candidat> query = ConnectDB.getConnection().createNativeQuery("SELECT * FROM Candidat",Candidat.class);
		List<Candidat> listCandidat = query.getResultList();
		return listCandidat;
	}
	
	public static int getCount() {
		Query<Candidat> query = ConnectDB.getConnection().createNativeQuery("SELECT * FROM Candidat", Candidat.class);
		List<Candidat> list = query.getResultList();
		int count = list.size();
		System.out.println(count);
		return count;
	}
	
	
}
