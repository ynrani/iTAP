package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the AUTO_HUB_SYS_CONFIG database table.
 * 
 */
@Entity
@Table(name = "AUTO_HUB_SYS_CONFIG")
@NamedQuery(name = "ITAPSysConfigDO.findAll", query = "SELECT a FROM ITAPSysConfigDO a")
public class ITAPSysConfigDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "SYS_CONFIG_ID")
	private long sysConfigId;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DT")
	private Timestamp actionDt;

	@Column(name = "BDD_PASSOWRD")
	private String bddPassowrd;

	@Column(name = "BDD_TST_MGMT_TOOL")
	private String bddTstMgmtTool;

	@Column(name = "BDD_URL")
	private String bddUrl;

	@Column(name = "BDD_USER_NAME")
	private String bddUserName;

	@Column(name = "CAF_MOB_AUTO_TOOL")
	private String cafMobAutoTool;

	@Column(name = "CAF_MOB_RESULT")
	private String cafMobResult;

	@Column(name = "CAF_MOB_TST_CASE")
	private String cafMobTstCase;

	@Column(name = "CAF_NXT_RESULT")
	private String cafNxtResult;

	@Column(name = "CAF_NXT_TST_CASE")
	private String cafNxtTstCase;

	@Column(name = "CAF_SELE_ECL_PATH")
	private String cafSeleEclPath;

	@Column(name = "CAF_SELE_RESULT")
	private String cafSeleResult;

	@Column(name = "CAF_SELE_TST_CASE")
	private String cafSeleTstCase;

	@Column(name = "DB_HOST_NAME")
	private String dbHostName;

	@Column(name = "DB_PASSOWRD")
	private String dbPassowrd;

	@Column(name = "DB_PORT")
	private String dbPort;

	@Column(name = "DB_URL")
	private String dbUrl;

	@Column(name = "DB_USER_NAME")
	private String dbUserName;

	@Column(name = "OPT_GRD")
	private String optGrd;

	@Column(name = "OPT_RESULT")
	private String optResult;

	@Column(name = "OPT_TST_CASE")
	private String optTstCase;

	@Column(name = "SCM_PASSOWRD")
	private String scmPassowrd;

	@Column(name = "SCM_SOURCE")
	private String scmSource;

	@Column(name = "SCM_URL")
	private String scmUrl;

	@Column(name = "SCM_USER_NAME")
	private String scmUserName;

	@Column(name = "TWIST_RESULT")
	private String twistResult;

	@Column(name = "TWIST_TST_CASE")
	private String twistTstCase;

	@Column(name = "TWIST_XPATH_GEN")
	private String twistXpathGen;

	public ITAPSysConfigDO()
	{
	}

	public long getSysConfigId() {
		return this.sysConfigId;
	}

	public void setSysConfigId(long sysConfigId) {
		this.sysConfigId = sysConfigId;
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

	public String getBddPassowrd() {
		return this.bddPassowrd;
	}

	public void setBddPassowrd(String bddPassowrd) {
		this.bddPassowrd = bddPassowrd;
	}

	public String getBddTstMgmtTool() {
		return this.bddTstMgmtTool;
	}

	public void setBddTstMgmtTool(String bddTstMgmtTool) {
		this.bddTstMgmtTool = bddTstMgmtTool;
	}

	public String getBddUrl() {
		return this.bddUrl;
	}

	public void setBddUrl(String bddUrl) {
		this.bddUrl = bddUrl;
	}

	public String getBddUserName() {
		return this.bddUserName;
	}

	public void setBddUserName(String bddUserName) {
		this.bddUserName = bddUserName;
	}

	public String getCafMobAutoTool() {
		return this.cafMobAutoTool;
	}

	public void setCafMobAutoTool(String cafMobAutoTool) {
		this.cafMobAutoTool = cafMobAutoTool;
	}

	public String getCafMobResult() {
		return this.cafMobResult;
	}

	public void setCafMobResult(String cafMobResult) {
		this.cafMobResult = cafMobResult;
	}

	public String getCafMobTstCase() {
		return this.cafMobTstCase;
	}

	public void setCafMobTstCase(String cafMobTstCase) {
		this.cafMobTstCase = cafMobTstCase;
	}

	public String getCafNxtResult() {
		return this.cafNxtResult;
	}

	public void setCafNxtResult(String cafNxtResult) {
		this.cafNxtResult = cafNxtResult;
	}

	public String getCafNxtTstCase() {
		return this.cafNxtTstCase;
	}

	public void setCafNxtTstCase(String cafNxtTstCase) {
		this.cafNxtTstCase = cafNxtTstCase;
	}

	public String getCafSeleEclPath() {
		return this.cafSeleEclPath;
	}

	public void setCafSeleEclPath(String cafSeleEclPath) {
		this.cafSeleEclPath = cafSeleEclPath;
	}

	public String getCafSeleResult() {
		return this.cafSeleResult;
	}

	public void setCafSeleResult(String cafSeleResult) {
		this.cafSeleResult = cafSeleResult;
	}

	public String getCafSeleTstCase() {
		return this.cafSeleTstCase;
	}

	public void setCafSeleTstCase(String cafSeleTstCase) {
		this.cafSeleTstCase = cafSeleTstCase;
	}

	public String getDbHostName() {
		return this.dbHostName;
	}

	public void setDbHostName(String dbHostName) {
		this.dbHostName = dbHostName;
	}

	public String getDbPassowrd() {
		return this.dbPassowrd;
	}

	public void setDbPassowrd(String dbPassowrd) {
		this.dbPassowrd = dbPassowrd;
	}

	public String getDbPort() {
		return this.dbPort;
	}

	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}

	public String getDbUrl() {
		return this.dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUserName() {
		return this.dbUserName;
	}

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	public String getOptGrd() {
		return this.optGrd;
	}

	public void setOptGrd(String optGrd) {
		this.optGrd = optGrd;
	}

	public String getOptResult() {
		return this.optResult;
	}

	public void setOptResult(String optResult) {
		this.optResult = optResult;
	}

	public String getOptTstCase() {
		return this.optTstCase;
	}

	public void setOptTstCase(String optTstCase) {
		this.optTstCase = optTstCase;
	}

	public String getScmPassowrd() {
		return this.scmPassowrd;
	}

	public void setScmPassowrd(String scmPassowrd) {
		this.scmPassowrd = scmPassowrd;
	}

	public String getScmUrl() {
		return this.scmUrl;
	}

	public void setScmUrl(String scmUrl) {
		this.scmUrl = scmUrl;
	}

	public String getScmUserName() {
		return this.scmUserName;
	}

	public void setScmUserName(String scmUserName) {
		this.scmUserName = scmUserName;
	}

	public String getTwistResult() {
		return this.twistResult;
	}

	public void setTwistResult(String twistResult) {
		this.twistResult = twistResult;
	}

	public String getTwistTstCase() {
		return this.twistTstCase;
	}

	public void setTwistTstCase(String twistTstCase) {
		this.twistTstCase = twistTstCase;
	}

	public String getTwistXpathGen() {
		return this.twistXpathGen;
	}

	public void setTwistXpathGen(String twistXpathGen) {
		this.twistXpathGen = twistXpathGen;
	}

	public String getScmSource() {
		return scmSource;
	}

	public void setScmSource(String scmSource) {
		this.scmSource = scmSource;
	}

}