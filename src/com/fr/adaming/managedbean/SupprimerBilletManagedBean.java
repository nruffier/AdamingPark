package com.fr.adaming.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.fr.adaming.dao.BilletDAO;

/**
 * @author Thibaud Guilard
 *
 */
@ManagedBean (name="supprimerBilletMB")
@RequestScoped
public class SupprimerBilletManagedBean {
	
	
	public void suppression(int id) {
		BilletDAO.supprimerBillet(id);

	}

}
