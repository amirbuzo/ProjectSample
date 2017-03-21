package com.ikubinfo.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Interface for all JPA entities to implement.
 *
 * @author Amir Buzo
 *
 */
public abstract class AEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * All entities must have an ID field.
	 */
	protected Integer id;

	@NotNull
	protected Date createdDate;

	protected Date modifiedDate;

	@NotNull
	protected boolean isActive = true;

	@NotNull
	protected Integer userCreated;

	protected Integer userModified;

	public abstract Integer getId();

	@Override
	public abstract boolean equals(Object object);

	public abstract String getShortDescription();

	@Override
	public abstract int hashCode();

	public abstract void setId(Integer id);

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {

		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {

		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {

		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {

		this.modifiedDate = modifiedDate;
	}

	public boolean getIsActive() {

		return isActive;
	}

	public void setIsActive(boolean isActive) {

		this.isActive = isActive;
	}

	public Integer getUserCreated() {

		return userCreated;
	}

	public void setUserCreated(Integer userCreated) {

		this.userCreated = userCreated;
	}

	/**
	 * @return the userModified
	 */
	public Integer getUserModified() {

		return userModified;
	}

	/**
	 * @param userModified
	 *            the userModified to set
	 */
	public void setUserModified(Integer userModified) {

		this.userModified = userModified;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setActive(boolean isActive) {

		this.isActive = isActive;
	}

}
