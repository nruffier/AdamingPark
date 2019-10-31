package com.fr.adaming.managedbean;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "langageMB")
@SessionScoped
public class LangageManagedBean {
	
	private Locale locale;
	
	public void change(String langage) {
		
		this.locale = new Locale(langage);
		
		FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
		
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	
}
