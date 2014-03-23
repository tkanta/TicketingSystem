package com.tm.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BaseDomain implements Serializable{
	private static final long serialVersionUID = -4632184588426390600L;

	private Long createdByUserId;
	private Date createdOn;
	private Long updatedByUserId;
	private Date updatedOn;
	
	@Column (name = "created_by")
	public Long getCreatedByUserId() {
		return createdByUserId;
	}
	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "created_on")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column (name = "updated_by")
	public Long getUpdatedByUserId() {
		return updatedByUserId;
	}
	public void setUpdatedByUserId(Long updatedByUserId) {
		this.updatedByUserId = updatedByUserId;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "updated_on")
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	
}
