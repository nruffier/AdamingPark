package com.fr.adaming.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.fr.adaming.entity.Billet;
import com.fr.adaming.util.ConnectDB;


/**
 * @author Dylan
 * @author THibault
 *
 */
public class BilletDAO {
	
	
	
	public static boolean register(Billet billet) {
		ConnectDB.getConnection().beginTransaction();
		ConnectDB.getConnection().save(billet);
		ConnectDB.getConnection().getTransaction().commit();
		return true;
	}
	
	public static List<Billet> getAll() {
		Query<Billet> query = ConnectDB.getConnection().createQuery("FROM Billet", Billet.class);
		List<Billet> listBillet = query.getResultList();
		return listBillet;
	}
	
	public static Billet getBilletById(int id) {
	String sql = "FROM Billet where id = :sqlid";
	Query<Billet> query = ConnectDB.getConnection().createQuery(sql, Billet.class);
	query.setParameter("sqlid", id);
	Billet billet = query.getSingleResult();
	return billet;
		
	}
	
	public static void supprimerBillet(int id) {
		Billet billet = getBilletById(id);
		ConnectDB.getConnection().beginTransaction();
		ConnectDB.getConnection().delete(billet);
		ConnectDB.getConnection().getTransaction().commit();
	}
	
	public static int getCount() {
		Query<Billet> query = ConnectDB.getConnection().createNativeQuery("SELECT * FROM Billet", Billet.class);
		List<Billet> list = query.getResultList();
		int count = list.size();
		System.out.println(count);
		return count;
	}

}
