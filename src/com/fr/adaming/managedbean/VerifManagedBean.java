package com.fr.adaming.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import javax.annotation.PostConstruct;


/**
 * @author Nicolas et Mehdi (et surtout pas Guillaume VITTOZ mais l'intention y etait)
 *
 */
@ManagedBean(name = "verifMB")
@ViewScoped
public class VerifManagedBean {

	@ManagedProperty("#{loginMB}")
	private LoginManagedBean loginMb;

	public LoginManagedBean getLoginMb() {
		return loginMb;
	}

	public void setLoginMb(LoginManagedBean loginMb) {
		this.loginMb = loginMb;
	}

	@PostConstruct
	public void access() {
		if (this.loginMb.getUsername()==null) {
		System.out.println("DEBUG preRenderView with username : " + this.loginMb.getUsername());
		FacesContext context = FacesContext.getCurrentInstance();
		context.getApplication().getNavigationHandler().handleNavigation(context, null, "login.xhtml");
//		try {
//			context.getExternalContext().redirect("login.xhtml");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		}
	}

}
