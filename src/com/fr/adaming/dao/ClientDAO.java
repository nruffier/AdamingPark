package com.fr.adaming.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;

import com.fr.adaming.entity.Client;

import com.fr.adaming.util.ConnectDB;



/**
 * @author Dylan
 * @author Thibault
 *
 */
public class ClientDAO {
	
	public static boolean exist(Client client) {
		String sql = "FROM Client WHERE email LIKE :sqlemail AND nom LIKE :sqlnom AND prenom LIKE :sqlprenom AND tel LIKE :sqltel";
		boolean result = false;
		Query<Client> query = ConnectDB.getConnection().createQuery(sql, Client.class);
		
		String email = client.getEmail();
		String nom = client.getNom();
		String prenom = client.getPrenom();
		String tel = client.getTel();

		query.setParameter("sqlemail", email);
		query.setParameter("sqlnom", nom);
		query.setParameter("sqlprenom", prenom);
		query.setParameter("sqltel", tel);
		
		
		try {
			Client c = query.getSingleResult();
			if (c != null) {
				// succes
				result = true;
			}
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public static boolean register(Client client) {
		ConnectDB.getConnection().beginTransaction();
		ConnectDB.getConnection().save(client);
		ConnectDB.getConnection().getTransaction().commit();
		return true;
	}
	
	public static List<Client> getAll() {
		Query<Client> query = ConnectDB.getConnection().createQuery("FROM Client", Client.class);
		List<Client> listClient = query.getResultList();
		return listClient;
	}
	
	public static Client getClient(Client client) {
		String sql = "FROM Client WHERE email LIKE :sqlemail AND nom LIKE :sqlnom AND prenom LIKE :sqlprenom AND tel LIKE :sqltel";
		Query<Client> query = ConnectDB.getConnection().createQuery(sql, Client.class);
		
		String email = client.getEmail();
		String nom = client.getNom();
		String prenom = client.getPrenom();
		String tel = client.getTel();

		query.setParameter("sqlemail", email);
		query.setParameter("sqlnom", nom);
		query.setParameter("sqlprenom", prenom);
		query.setParameter("sqltel", tel);
		
		Client c = query.getSingleResult();
		
		Client clientAvecId = new Client(c.getId(), nom, prenom, email, tel);
		
		return clientAvecId;
	}
	
	public static int getCount() {
		Query<Client> query = ConnectDB.getConnection().createNativeQuery("SELECT * FROM Client", Client.class);
		List<Client> list = query.getResultList();
		int count = list.size();
		System.out.println(count);
		return count;
	}
	

}
