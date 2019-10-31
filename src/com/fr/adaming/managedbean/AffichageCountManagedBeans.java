package com.fr.adaming.managedbean;


import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import com.fr.adaming.dao.AttractionDAO;
import com.fr.adaming.dao.BilletDAO;
import com.fr.adaming.dao.CandidatDAO;
import com.fr.adaming.dao.ClientDAO;



/**
 * @author Dylan
 *
 */
@ManagedBean(name ="countMB")
@ViewScoped
public class AffichageCountManagedBeans {

	
	
	public int afficherCandidat() {
		
		int count = CandidatDAO.getCount();
		return count;
	}
	
public int afficherBillet() {
		
		int count = BilletDAO.getCount();
		return count;
	}

public int afficherClient() {
	
	int count = ClientDAO.getCount();
	return count;
}

public int afficherAttraction() {
	
	int count = AttractionDAO.getCount();
	return count;
}

}
