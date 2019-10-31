package com.fr.adaming.dao;

import com.fr.adaming.entity.Admin;
import com.fr.adaming.util.ConnectDB;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.query.Query;

/**
 * @author Guillaume VITTOZ / Guillaume BRIAS
 *
 */
public class AdminDAO {

	public static boolean login(String username, String pwd) {
		String hql = "FROM Admin WHERE username=:usernameX AND pwd=:pwdX";

		Query<Admin> query = ConnectDB.getConnection().createQuery(hql, Admin.class);

		query.setParameter("usernameX", username);
		query.setParameter("pwdX", pwd);

		boolean result = false;

		try {
			Admin admin = query.getSingleResult();
			result = true;
		} catch (NoResultException e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}

	public static boolean register(Admin admin) {
		ConnectDB.getConnection().beginTransaction();
		ConnectDB.getConnection().save(admin);
		ConnectDB.getConnection().getTransaction().commit();

		boolean result = false;

		if (login(admin.getUsername(), admin.getPwd()) == true) {
			result = true;
		}

		return result;
	}
	
	public static List<Admin> getAll() {
		Query<Admin> query = ConnectDB.getConnection().createQuery("FROM Utilisateur", Admin.class);

		return query.list();
	}

	public static void ajouter(Admin admin) {
		ConnectDB.getConnection().beginTransaction();

		ConnectDB.getConnection().save(admin);

		ConnectDB.getConnection().getTransaction().commit();
	}

	public static void supprimer(String username) {
		ConnectDB.getConnection().beginTransaction();
		Admin admin = chercherParUsername(username);

		if (admin != null) {
			ConnectDB.getConnection().delete(admin);
		}

		ConnectDB.getConnection().getTransaction().commit();

	}

	public static void modifier(Admin admin) {
		ConnectDB.getConnection().beginTransaction();
		Admin adminInitial = chercherParUsername(admin.getUsername());

		adminInitial.setNom(admin.getNom());
		adminInitial.setPrenom(admin.getPrenom());
		adminInitial.setEmail(admin.getEmail());
		adminInitial.setPwd(admin.getPwd());

		ConnectDB.getConnection().update(adminInitial);

		ConnectDB.getConnection().getTransaction().commit();

	}

	public static List<Admin> getAllAdmins() {

		List<Admin> getAllAdmins = new ArrayList<Admin>();

		String hql = "from Admin";

		Query<Admin> query = ConnectDB.getConnection().createQuery(hql, Admin.class);

		getAllAdmins = query.getResultList();

		return getAllAdmins;
	}

	public static boolean existByUsername(String username) {

		boolean isSuccess = false;

		Admin admin = chercherParUsername(username);

		if (admin != null) {
			isSuccess = true;
		}

		return isSuccess;
	}

	public static Admin chercherParUsername(String username) {

		String hql = "from Admin where username = :x";

		Query<Admin> query = ConnectDB.getConnection().createQuery(hql, Admin.class);

		query.setParameter("x", username);

		Admin admin = null;

		try {
			admin = query.getSingleResult();
		} catch (NoResultException e) {

		} catch (Exception e) {

		}

		return admin;

	}

}
