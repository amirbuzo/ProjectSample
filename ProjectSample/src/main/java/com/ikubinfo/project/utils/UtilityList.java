package com.ikubinfo.project.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * {@link UtilityList} implements Serializable
 * <p>
 * Purpose:
 * </p>
 * This bean is created to get lists of values for specific attributes. These
 * values are stored into a properties file in order to facilitate the update
 * process.
 * <p>
 * <b>Details:</b> Class name - UtilityList <br/>
 * Bean name - utils <br/>
 * Bean scope - ApplicationScoped
 *
 * @author ProjectSample
 * @since January 2017
 * @version 1.0
 */
@ApplicationScoped
@ManagedBean(name = "utils")
public class UtilityList implements Serializable {

	private static final long serialVersionUID = 5904158831472098657L;

	public Map<Integer, String> status;

	public Map<Integer, String> place;

	public Map<Integer, String> getStatus() {
		return status;
	}

	public void setStatus(Map<Integer, String> status) {
		this.status = status;
	}

	public Map<Integer, String> getPlace() {
		return place;
	}

	public void setPlace(Map<Integer, String> place) {
		this.place = place;
	}

}
