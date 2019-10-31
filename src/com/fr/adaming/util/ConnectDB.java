package com.fr.adaming.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectDB {
	private static Session session;
	private static SessionFactory sFactory;
	
	private ConnectDB() {
		sFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		session = sFactory.openSession();
	}


	public static Session getConnection() {
		if (session == null) {
		new ConnectDB();
		}
		return session;
	}
	
	public static void closeSession() {
		session.close();
		sFactory.close();
	}
}
