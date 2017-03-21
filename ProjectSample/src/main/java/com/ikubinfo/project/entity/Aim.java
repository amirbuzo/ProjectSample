package com.ikubinfo.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author abuzo
 */
public class Aim extends AEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 1, max = 50)
	private String aimDescription;

	public Aim() {

	}

	public Aim(Integer id) {

		this.id = id;
	}

	public Aim(Integer id, String aimDescription, boolean isActive,
			Date createdDate, Date modifiedDate) {

		this.id = id;
		this.aimDescription = aimDescription;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	@Override
	public Integer getId() {

		return id;
	}

	@Override
	public void setId(Integer id) {

		this.id = id;
	}

	public String getAimDescription() {

		return aimDescription;
	}

	public void setAimDescription(String aimDescription) {

		this.aimDescription = aimDescription;
	}

	@Override
	public boolean getIsActive() {

		return isActive;
	}

	@Override
	public void setIsActive(boolean isActive) {

		this.isActive = isActive;
	}

	@Override
	public Date getCreatedDate() {

		return createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {

		this.createdDate = createdDate;
	}

	@Override
	public Date getModifiedDate() {

		return modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {

		this.modifiedDate = modifiedDate;
	}

	@Override
	public int hashCode() {

		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Aim)) {
			return false;
		}
		Aim other = (Aim) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {

		return aimDescription;
	}

	@Override
	public String getShortDescription() {

		return aimDescription;
	}
}
