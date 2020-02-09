package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "AUTO_HUB_JENKINS_CONFIG")
@NamedQuery(name = "JenkinsConfigDO.findAll", query = "SELECT a FROM JenkinsConfigDO a")
public class JenkinsConfigDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "JENKINS_ID")
	private long jenkinsId;

	@Column(name = "JENKINS_NAME")
	private String jenkinsName;

	@Column(name = "CI_NAME")
	private String ciName;

	@Column(name = "URL")
	private String url;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASS_WORD")
	private String pass;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DATE")
	private Timestamp actionDt;

	public JenkinsConfigDO() {
	}

	public long getJenkinsId() {
		return jenkinsId;
	}

	public void setJenkinsId(long jenkinsId) {
		this.jenkinsId = jenkinsId;
	}

	public String getJenkinsName() {
		return jenkinsName;
	}

	public void setJenkinsName(String jenkinsName) {
		this.jenkinsName = jenkinsName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Timestamp getActionDt() {
		return actionDt;
	}

	public void setActionDt(Timestamp actionDt) {
		this.actionDt = actionDt;
	}

	public String getCiName() {
		return ciName;
	}

	public void setCiName(String ciName) {
		this.ciName = ciName;
	}

}