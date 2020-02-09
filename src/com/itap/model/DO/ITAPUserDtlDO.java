package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the REMS_USER_DTL database table.
 * 
 */
@Entity
@Table(name = "REMS_USER_DTL")
@NamedQuery(name = "ITAPUserDtlDO.findAll", query = "SELECT r FROM ITAPUserDtlDO r")
public class ITAPUserDtlDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DT")
	private Timestamp actionDt;

	private String enabled;

	@Column(name = "PASS_WORD")
	private String passWord;

	@Column(name = "USER_ACCESS")
	private String userAccess;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "USER_PH")
	private String userPh;

	@Column(name = "USER_STS")
	private String userSts;

	@Column(name = "USER_TYPE")
	private String userType;

	public ITAPUserDtlDO()
	{
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserAccess() {
		return this.userAccess;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPh() {
		return this.userPh;
	}

	public void setUserPh(String userPh) {
		this.userPh = userPh;
	}

	public String getUserSts() {
		return this.userSts;
	}

	public void setUserSts(String userSts) {
		this.userSts = userSts;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}