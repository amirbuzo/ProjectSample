package com.ikubinfo.project.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;
import org.primefaces.model.SortOrder;

import com.ikubinfo.project.entity.AEntity;

/**
 *
 * @author abuzo
 */
public abstract class AbstractFacade<T extends AEntity> {

	private Class<T> entityClass;

	private static final Logger LOG = LogManager
			.getLogger(AbstractFacade.class);

	public AbstractFacade(Class<T> entityClass) {

		this.entityClass = entityClass;
	}

	public abstract void edit(T entity);

	public abstract void create(T entity);

	public abstract void inactivate(T entity);

	public abstract void remove(T entity);

	public abstract void activate(T entity);

	public abstract T find(Object id);

	public abstract List<T> findAll();

	public abstract List<T> findAllActive();

	public abstract List<T> findRange(int[] range);

	public abstract int count();

	public abstract int count(Map<String, Object> filters);

	public abstract List<T> getResultList(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters);

}
