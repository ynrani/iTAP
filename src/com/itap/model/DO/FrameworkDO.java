package com.itap.model.DO;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FRAMEWORK database table.
 * 
 */
@Entity
@Table(name="FRAMEWORK")
@NamedQuery(name="FrameworkDO.findAll", query="SELECT f FROM FrameworkDO f")
public class FrameworkDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FRAMEWORK_ID")
	private String frameworkId;

	@Column(name="FRAMEWORK_NAME")
	private String frameworkName;

	//bi-directional many-to-one association to TestCaseDO
	@OneToMany(mappedBy="framework")
	private List<TestCaseDO> testCases;

	//bi-directional many-to-one association to TestStepDO
	@OneToMany(mappedBy="framework")
	private List<TestStepDO> testSteps;

	public FrameworkDO() {
	}

	public String getFrameworkId() {
		return this.frameworkId;
	}

	public void setFrameworkId(String frameworkId) {
		this.frameworkId = frameworkId;
	}

	public String getFrameworkName() {
		return this.frameworkName;
	}

	public void setFrameworkName(String frameworkName) {
		this.frameworkName = frameworkName;
	}

	public List<TestCaseDO> getTestCases() {
		return this.testCases;
	}

	public void setTestCases(List<TestCaseDO> testCases) {
		this.testCases = testCases;
	}

	public TestCaseDO addTestCas(TestCaseDO testCas) {
		getTestCases().add(testCas);
		testCas.setFramework(this);

		return testCas;
	}

	public TestCaseDO removeTestCas(TestCaseDO testCas) {
		getTestCases().remove(testCas);
		testCas.setFramework(null);

		return testCas;
	}

	public List<TestStepDO> getTestSteps() {
		return this.testSteps;
	}

	public void setTestSteps(List<TestStepDO> testSteps) {
		this.testSteps = testSteps;
	}

	public TestStepDO addTestStep(TestStepDO testStep) {
		getTestSteps().add(testStep);
		testStep.setFramework(this);

		return testStep;
	}

	public TestStepDO removeTestStep(TestStepDO testStep) {
		getTestSteps().remove(testStep);
		testStep.setFramework(null);

		return testStep;
	}

}