package com.fr.adaming.dao;

import org.hibernate.query.Query;

import com.fr.adaming.entity.Type;
import com.fr.adaming.util.ConnectDB;

/**
 * @author Thibaud Guilard
 *
 */
public class TypeDAO {
	
	
	public static double getPrixJ(String type) {
	String sql = "SELECT prixJ FROM Type where nom = :sqltype";
	Query<Double> query = ConnectDB.getConnection().createQuery(sql, Double.class);
	query.setParameter("sqltype", type);
	double prixJ = (double) query.getSingleResult();
	return prixJ;
	}
	
	public static Type getType(String nomType) {
		String sql = "FROM Type where nom = :sqlnomType";
		Query<Type> query = ConnectDB.getConnection().createQuery(sql, Type.class);
		query.setParameter("sqlnomType", nomType);
		Type type = query.getSingleResult();
		return type;
	}

}
