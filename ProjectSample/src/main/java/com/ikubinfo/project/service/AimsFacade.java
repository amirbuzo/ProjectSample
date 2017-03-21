/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package com.ikubinfo.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.SortOrder;

import com.ikubinfo.project.entity.Aim;
import com.ikubinfo.project.presentation.controllers.LoginBean;

/**
 *
 * @author abuzo
 */
@NoneScoped
@ManagedBean(name = "AimsFacade")
public class AimsFacade extends AbstractFacade<Aim> {

	private static final Logger LOG = LogManager.getLogger(AimsFacade.class);

	private List<Aim> list = new ArrayList<Aim>();

	public AimsFacade() {
		super(Aim.class);

		list.add(new Aim(1, "Per Subjekt", true, new Date(), new Date()));
		list.add(new Aim(2, "Per Qellim2", true, new Date(), new Date()));
		list.add(new Aim(3, "Per Qellim3", true, new Date(), new Date()));
		list.add(new Aim(4, "Per Qellim4", true, new Date(), new Date()));
		list.add(new Aim(6, "Per Qellim5", true, new Date(), new Date()));
		list.add(new Aim(8, "Per Qellim6", true, new Date(), new Date()));
		list.add(new Aim(9, "Per Qellim9", true, new Date(), new Date()));

	}

	@Override
	public void edit(Aim entity) {
	}

	@Override
	public void inactivate(Aim entity) {
		LOG.log(Level.INFO, "Contatin" + list.contains(entity));
		LOG.log(Level.INFO, "Count" + list.size());
		entity.setActive(false);
		list.remove(entity);
		LOG.log(Level.INFO, "Count" + list.size());

	}

	@Override
	public void remove(Aim entity) {
		// TODO Auto-generated method stub
		LOG.log(Level.INFO, "Contatin" + list.contains(entity));
		LOG.log(Level.INFO, "Count" + list.size());
		list.remove(entity);
		LOG.log(Level.INFO, "Count" + list.size());

	}

	@Override
	public void activate(Aim entity) {
		// TODO Auto-generated method stub
		entity.setActive(true);
	}

	@Override
	public Aim find(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aim> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Aim> findAllActive() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Aim> findRange(int[] range) {
		// TODO Auto-generated method stub
		return list.subList(range[0], range[1]);
	}

	@Override
	public int count(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Aim> getResultList(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void create(Aim entity) {
		list.add(entity);

	}
}
