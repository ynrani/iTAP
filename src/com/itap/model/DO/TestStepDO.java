package com.itap.model.DO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the TEST_STEP database table.
 * 
 */
@Entity
@Table(name="TEST_STEP")
@NamedQuery(name="TestStepDO.findAll", query="SELECT t FROM TestStepDO t")
public class TestStepDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TC_ID")
	private String tcId;

	@Column(name="STEP_ACT_RES")
	private String stepActRes;

	@Column(name="STEP_DESC")
	private String stepDesc;

	@Column(name="STEP_EXP_RES")
	private String stepExpRes;

	@Column(name="TESTSTEP_ID")
	private String teststepId;

	//bi-directional many-to-one association to FrameworkDO
	@ManyToOne
	@JoinColumn(name="FRAMEWORK_ID")
	private FrameworkDO framework;

	//bi-directional one-to-one association to TestCaseDO
	@OneToOne
	@JoinColumn(name="TC_ID")
	private TestCaseDO testCase;

	public TestStepDO() {
	}

	public String getTcId() {
		return this.tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getStepActRes() {
		return this.stepActRes;
	}

	public void setStepActRes(String stepActRes) {
		this.stepActRes = stepActRes;
	}

	public String getStepDesc() {
		return this.stepDesc;
	}

	public void setStepDesc(String stepDesc) {
		this.stepDesc = stepDesc;
	}

	public String getStepExpRes() {
		return this.stepExpRes;
	}

	public void setStepExpRes(String stepExpRes) {
		this.stepExpRes = stepExpRes;
	}

	public String getTeststepId() {
		return this.teststepId;
	}

	public void setTeststepId(String teststepId) {
		this.teststepId = teststepId;
	}

	public FrameworkDO getFramework() {
		return this.framework;
	}

	public void setFramework(FrameworkDO framework) {
		this.framework = framework;
	}

	public TestCaseDO getTestCase() {
		return this.testCase;
	}

	public void setTestCase(TestCaseDO testCase) {
		this.testCase = testCase;
	}

}