package com.itap.model.DO;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the AUTO_HUB_ENV_CONFIG database table.
 * 
 */
@Entity
@Table(name="AUTO_HUB_ENV_CONFIG")
@NamedQuery(name="ITAPEnvConfigDO.findAll", query="SELECT a FROM ITAPEnvConfigDO a")
public class ITAPEnvConfigDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ENV_CONFIG_ID")
	private long envConfigId;

	@Column(name="ACTION_BY")
	private String actionBy;

	@Column(name="ACTION_DT")
	private Timestamp actionDt;

	@Column(name="ENV_DESC")
	private String envDesc;

	@Column(name="ENV_DOCK_URL")
	private String envDockUrl;

	@Column(name="ENV_HOST")
	private String envHost;

	@Column(name="ENV_IP")
	private String envIp;

	@Column(name="ENV_NAME")
	private String envName;

	@Column(name="ENV_PASSOWRD")
	private String envPassowrd;

	@Column(name="ENV_SSL")
	private String envSsl;

	@Column(name="ENV_TYPE")
	private String envType;

	@Column(name="ENV_USER_NAME")
	private String envUserName;

	public ITAPEnvConfigDO() {
	}

	public long getEnvConfigId() {
		return this.envConfigId;
	}

	public void setEnvConfigId(long envConfigId) {
		this.envConfigId = envConfigId;
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

	public String getEnvDesc() {
		return this.envDesc;
	}

	public void setEnvDesc(String envDesc) {
		this.envDesc = envDesc;
	}

	public String getEnvDockUrl() {
		return this.envDockUrl;
	}

	public void setEnvDockUrl(String envDockUrl) {
		this.envDockUrl = envDockUrl;
	}

	public String getEnvHost() {
		return this.envHost;
	}

	public void setEnvHost(String envHost) {
		this.envHost = envHost;
	}

	public String getEnvIp() {
		return this.envIp;
	}

	public void setEnvIp(String envIp) {
		this.envIp = envIp;
	}

	public String getEnvName() {
		return this.envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getEnvPassowrd() {
		return this.envPassowrd;
	}

	public void setEnvPassowrd(String envPassowrd) {
		this.envPassowrd = envPassowrd;
	}

	public String getEnvSsl() {
		return this.envSsl;
	}

	public void setEnvSsl(String envSsl) {
		this.envSsl = envSsl;
	}

	public String getEnvType() {
		return this.envType;
	}

	public void setEnvType(String envType) {
		this.envType = envType;
	}

	public String getEnvUserName() {
		return this.envUserName;
	}

	public void setEnvUserName(String envUserName) {
		this.envUserName = envUserName;
	}

}