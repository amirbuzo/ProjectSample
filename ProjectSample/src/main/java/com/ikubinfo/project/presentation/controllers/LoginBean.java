package com.ikubinfo.project.presentation.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

	private static final Logger LOG = LogManager.getLogger(LoginBean.class);

	private String username;

	private String password;

	@PostConstruct
	public void init() {

	}

	/**
	 * @return the username
	 */
	public String getUsername() {

		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {

		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {

		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	public String login() {

		FacesContext context = FacesContext.getCurrentInstance();

		if (this.username.equals(this.password)) {
			LOG.log(Level.INFO, username + " Login successfully!");
			return "success";
		}
		LOG.log(Level.INFO, username + " Login Failure!");

		return "failure";
	}

	public String logout() {

		LOG.log(Level.INFO, username + " Logout!");
		return "/login.xhtml?faces-redirect=true";// something you should not do
													// anymore
	}
}
