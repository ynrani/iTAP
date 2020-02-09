package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the REMS_ENV_DTLS database table.
 * 
 */
@Entity
@Table(name = "REMS_ENV_DTLS")
@NamedQuery(name = "ITAPEnvDtlDO.findAll", query = "SELECT r FROM ITAPEnvDtlDO r")
public class ITAPEnvDtlDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ENV_ID")
	private String envId;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DT")
	private Timestamp actionDt;

	@Column(name = "APP_ID")
	private String appId;

	@Column(name = "ENV_APP_VER")
	private String envAppVer;

	@Column(name = "ENV_DESC")
	private String envDesc;

	@Column(name = "ENV_DOC_LNK1")
	private String envDocLnk1;

	@Column(name = "ENV_DOC_LNK2")
	private String envDocLnk2;

	@Column(name = "ENV_NAME")
	private String envName;

	@Column(name = "ENV_PURPOSE")
	private String envPurpose;

	@Column(name = "ENV_SPOC")
	private String envSpoc;

	@Column(name = "ENV_SPOC_EMAIL")
	private String envSpocEmail;

	@Column(name = "ENV_SPOC_PH")
	private String envSpocPh;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROD_DATA_EXP_DT")
	private Date prodDataExpDt;

	@Column(name = "TEST_DS")
	private String testDs;

	public ITAPEnvDtlDO() {
	}

	public String getEnvId() {
		return this.envId;
	}

	public void setEnvId(String envId) {
		this.envId = envId;
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

	public String getEnvAppVer() {
		return this.envAppVer;
	}

	public void setEnvAppVer(String envAppVer) {
		this.envAppVer = envAppVer;
	}

	public String getEnvDesc() {
		return this.envDesc;
	}

	public void setEnvDesc(String envDesc) {
		this.envDesc = envDesc;
	}

	public String getEnvDocLnk1() {
		return this.envDocLnk1;
	}

	public void setEnvDocLnk1(String envDocLnk1) {
		this.envDocLnk1 = envDocLnk1;
	}

	public String getEnvDocLnk2() {
		return this.envDocLnk2;
	}

	public void setEnvDocLnk2(String envDocLnk2) {
		this.envDocLnk2 = envDocLnk2;
	}

	public String getEnvName() {
		return this.envName;
	}

	public void setEnvName(String envName) {
		this.envName = envName;
	}

	public String getEnvPurpose() {
		return this.envPurpose;
	}

	public void setEnvPurpose(String envPurpose) {
		this.envPurpose = envPurpose;
	}

	public String getEnvSpoc() {
		return this.envSpoc;
	}

	public void setEnvSpoc(String envSpoc) {
		this.envSpoc = envSpoc;
	}

	public String getEnvSpocEmail() {
		return this.envSpocEmail;
	}

	public void setEnvSpocEmail(String envSpocEmail) {
		this.envSpocEmail = envSpocEmail;
	}

	public String getEnvSpocPh() {
		return this.envSpocPh;
	}

	public void setEnvSpocPh(String envSpocPh) {
		this.envSpocPh = envSpocPh;
	}

	public Date getProdDataExpDt() {
		return this.prodDataExpDt;
	}

	public void setProdDataExpDt(Date prodDataExpDt) {
		this.prodDataExpDt = prodDataExpDt;
	}

	public String getTestDs() {
		return this.testDs;
	}

	public void setTestDs(String testDs) {
		this.testDs = testDs;
	}

}