package com.fr.adaming.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.fr.adaming.dao.AdminDAO;



/**
 * @author Guillaume VITTOZ
 *
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginManagedBean {

	private String username;
	private String pwd;

	@Override
	public String toString() {
		return "loginManagedBean [username=" + username + ", pwd=" + pwd + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public LoginManagedBean() {
		super();
	}

	public LoginManagedBean(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	public String login() {
		System.out.println("DEBUG email : " + this.username);
		System.out.println("DEBUG pwd : " + this.pwd);

		if (AdminDAO.login(username, pwd) == true) {
			// SUCCESS
			System.out.println("DEBUG SUCCESS");
			return "SUCCESS";
		} else {
			// FAIL
			System.out.println("DEBUG FAIL !!");
			return "FAIL";
		}

	}
	
	public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "INDEX";
}
}
