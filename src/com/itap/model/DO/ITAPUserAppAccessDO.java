package com.itap.model.DO;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the REMS_USER_APP_ACCESS database table.
 * 
 */
@Entity
@Table(name="REMS_USER_APP_ACCESS")
@NamedQuery(name="ITAPUserAppAccessDO.findAll", query="SELECT r FROM ITAPUserAppAccessDO r")
public class ITAPUserAppAccessDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="ACTION_BY")
	private String actionBy;

	@Column(name="ACTION_DT")
	private Timestamp actionDt;

	@Column(name="APP_ID")
	private String appId;

	@Column(name="USER_ACCESS")
	private String userAccess;

	@Column(name="USER_ID")
	private String userId;

	public ITAPUserAppAccessDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActionBy() {
		return this.actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Timestamp getActionDt() {
		return this.actionDt;
	}

	public void setActionDt(Timestamp actionDt) {
		this.actionDt = actionDt;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getUserAccess() {
		return this.userAccess;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}