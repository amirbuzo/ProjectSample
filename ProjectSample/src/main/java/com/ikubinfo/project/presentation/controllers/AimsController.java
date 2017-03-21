package com.ikubinfo.project.presentation.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ikubinfo.project.entity.Aim;
import com.ikubinfo.project.service.AimsFacade;
import com.ikubinfo.project.utils.JsfUtil;
import com.ikubinfo.project.utils.JsfUtil.PersistAction;

@ManagedBean(name = "aimsController")
@ViewScoped
public class AimsController implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager
			.getLogger(AimsController.class);

	@ManagedProperty(value = "#{AimsFacade}")
	private AimsFacade aimsFacade;

	private List<Aim> items = null;

	private Aim selected;

	@PostConstruct
	public void init() {
		aimsFacade = new AimsFacade();

	}

	public List<Aim> getItems() {
		if (items == null) {
			items = getFacade().findAll();
		}
		return items;
	}

	public Aim getSelected() {
		return selected;
	}

	public void setSelected(Aim selected) {
		this.selected = selected;
	}

	public AimsFacade getFacade() {
		return aimsFacade;
	}

	public Aim prepareCreate() {
		selected = new Aim();

		return selected;
	}

	public void create() {
		persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle")
				.getString("AimsCreated"));
		if (!JsfUtil.isValidationFailed()) {
			items = null; // Invalidate list of items to trigger re-query.
		}
	}

	public void update() {
		persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle")
				.getString("AimsUpdated"));
		items = null;
	}

	public void destroy() {
		persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle")
				.getString("AimsDeleted"));
		if (!JsfUtil.isValidationFailed()) {
			selected = null; // Remove selection
			items = null; // Invalidate list of items to trigger re-query.
		}
	}

	private void persist(PersistAction persistAction, String successMessage) {
		if (selected != null) {
			try {
				if (persistAction == PersistAction.DELETE) {
					getFacade().inactivate(selected);

				} else if (persistAction == PersistAction.UPDATE) {
					getFacade().edit(selected);

				} else if (persistAction == PersistAction.CREATE) {
					getFacade().create(selected);
				}
				JsfUtil.addSuccessMessage(successMessage);
			} catch (RuntimeException ex) {// TransactionsException
				String msg = "";
				Throwable cause = ex.getCause();
				if (cause != null) {
					msg = cause.getLocalizedMessage();
				}
				if (msg.length() > 0) {
					JsfUtil.addErrorMessage(msg);
				} else {
					JsfUtil.addErrorMessage(
							ex,
							ResourceBundle.getBundle("/Bundle").getString(
									"PersistenceErrorOccured"));
				}
			} catch (Exception ex) {
				LOG.log(Level.ERROR, ex.getMessage(), ex);
				JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle")
						.getString("PersistenceErrorOccured"));
			}
		}
	}

	public Aim getAims(java.lang.Integer id) {
		return getFacade().find(id);
	}

	public List<Aim> getItemsAvailableSelectMany() {
		return getFacade().findAll();
	}

	public List<Aim> getItemsAvailableSelectOne() {
		return getFacade().findAll();
	}

	public AimsFacade getAimsFacade() {
		return aimsFacade;
	}

	public void setAimsFacade(AimsFacade aimsFacade) {
		this.aimsFacade = aimsFacade;
	}

}
