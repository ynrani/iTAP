package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the AUTO_HUB_CONFIG database table.
 * 
 */
@Entity
@Table(name = "AUTO_HUB_CONFIG")
@NamedQuery(name = "ITAPConfigDO.findAll", query = "SELECT a FROM ITAPConfigDO a")
public class ITAPConfigDO implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONFIG_ID")
	private long configId;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DT")
	private Timestamp actionDt;

	@Column(name = "BDD_SCT")
	private String bddSct;

	@Column(name = "CODE_CVG")
	private String codeCvg;

	@Column(name = "PROJ_NAME")
	private String projName;

	@Column(name = "JOB_NAME")
	private String jobName;

	private String deployment;

	private String deplyoment;

	private String docker;

	private String enviorment;

	@Column(name = "GRID_LAB_URL")
	private String gridLabUrl;

	@Column(name = "GRID_TYPE")
	private String gridType;

	private String pckage;

	@Column(name = "REPO_URL")
	private String repoUrl;

	private String sanity;

	private String source;

	@Column(name = "TEST_CASE")
	private String testCase;

	@Column(name = "TEST_SUITE")
	private String testSuite;

	@Column(name = "TEST_TYPE")
	private String testType;

	public ITAPConfigDO()
	{
	}

	public long getConfigId() {
		return this.configId;
	}

	public void setConfigId(long configId) {
		this.configId = configId;
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

	public String getBddSct() {
		return this.bddSct;
	}

	public void setBddSct(String bddSct) {
		this.bddSct = bddSct;
	}

	public String getCodeCvg() {
		return this.codeCvg;
	}

	public void setCodeCvg(String codeCvg) {
		this.codeCvg = codeCvg;
	}

	public String getDeployment() {
		return this.deployment;
	}

	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}

	public String getDeplyoment() {
		return this.deplyoment;
	}

	public void setDeplyoment(String deplyoment) {
		this.deplyoment = deplyoment;
	}

	public String getDocker() {
		return this.docker;
	}

	public void setDocker(String docker) {
		this.docker = docker;
	}

	public String getEnviorment() {
		return this.enviorment;
	}

	public void setEnviorment(String enviorment) {
		this.enviorment = enviorment;
	}

	public String getGridLabUrl() {
		return this.gridLabUrl;
	}

	public void setGridLabUrl(String gridLabUrl) {
		this.gridLabUrl = gridLabUrl;
	}

	public String getGridType() {
		return this.gridType;
	}

	public void setGridType(String gridType) {
		this.gridType = gridType;
	}

	public String getPckage() {
		return this.pckage;
	}

	public void setPckage(String pckage) {
		this.pckage = pckage;
	}

	public String getRepoUrl() {
		return this.repoUrl;
	}

	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}

	public String getSanity() {
		return this.sanity;
	}

	public void setSanity(String sanity) {
		this.sanity = sanity;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTestCase() {
		return this.testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public String getTestSuite() {
		return this.testSuite;
	}

	public void setTestSuite(String testSuite) {
		this.testSuite = testSuite;
	}

	public String getTestType() {
		return this.testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}