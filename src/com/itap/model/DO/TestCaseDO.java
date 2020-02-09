package com.itap.model.DO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * The persistent class for the TEST_CASE database table.
 * 
 */
@Entity
@Table(name="TEST_CASE")
@NamedQuery(name="TestCaseDO.findAll", query="SELECT t FROM TestCaseDO t")
public class TestCaseDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TC_ID")
	private String tcId;

	@Column(name="ACTUAL_RESULT_IN_ITERATION_1")
	private String actualResultInIteration1;

	@Column(name="ACTUAL_RESULT_IN_ITERATION_2")
	private String actualResultInIteration2;

	@Column(name="ACTUAL_RESULT_IN_ITERATION_3")
	private String actualResultInIteration3;

	@Column(name="ASSOCIATED_AUTOMATION_SCRIPT")
	private String associatedAutomationScript;

	@Column(name="ASSOCIATES_REGR_TEST_CASES")
	private String associatesRegrTestCases;

	@Column(name="AUTOMATION_TOOL")
	private String automationTool;

	@Column(name="BUSINESS_PRIORITY")
	private String businessPriority;

	@Column(name="BUSINESS_SEVERITY")
	private String businessSeverity;

	@Column(name="CODE_DEVELOPED_BY")
	private String codeDevelopedBy;

	private String column1;

	@Column(name="CONDITION_DESCRIPTION")
	private String conditionDescription;

	@Column(name="CONDITION_NO")
	private String conditionNo;

	@Column(name="CRITICALITY_USER_IMPACT")
	private String criticalityUserImpact;

	@Column(name="DEVELOPER_CODED")
	private String developerCoded;

	@Column(name="END_DATE")
	private String endDate;

	private String environment;

	@Column(name="EXPECTED_RESULT")
	private String expectedResult;

	@Column(name="FIRST_TIME_FAILURE")
	private String firstTimeFailure;

	@Column(name="FIRST_TIME_PASS")
	private String firstTimePass;

	@Column(name="INPUT_FILE_NAMES_TEST_DATA")
	private String inputFileNamesTestData;

	@Column(name="INPUT_OUTPUT__FILE_NAMES")
	private String inputOutputFileNames;

	@Column(name="NO_OF_FAILURES_OF_TEST_CASE")
	private String noOfFailuresOfTestCase;

	@Column(name="OUTPUT_FILE_NAMES")
	private String outputFileNames;

	@Column(name="PREPARED_ON_DATE")
	private String preparedOnDate;

	@Column(name="RECORDS_REQUIRED")
	private BigDecimal recordsRequired;

	private String remarks;

	@Column(name="RISK_INDEX_R_A_G")
	private String riskIndexRAG;

	@Column(name="SCEN_NO")
	private String scenNo;

	@Column(name="SCENARIO_DESCRIPTION")
	private String scenarioDescription;

	@Column(name="SOURCE_CODE_VERSION")
	private String sourceCodeVersion;

	@Column(name="START_DATE")
	private String startDate;

	private String status;

	@Column(name="TC_DESC")
	private String tcDesc;

	@Column(name="TC_NAME")
	private String tcName;

	@Column(name="TDM_CENTRAL_RELATED_DETAILS")
	private String tdmCentralRelatedDetails;

	@Column(name="TEST_DATA_ID")
	private String testDataId;

	@Column(name="TEST_ENVIRONMENT")
	private String testEnvironment;

	@Column(name="TESTED_BY")
	private String testedBy;

	@Column(name="TESTING_STAGE")
	private String testingStage;

	@Column(name="TIME_TO_EXECUTE_THE_TEST_CASE")
	private String timeToExecuteTheTestCase;

	//bi-directional many-to-one association to TcFrameworkConfigDO
	@OneToMany(mappedBy="testCase")
	@Cascade({ CascadeType.ALL })
	private List<TcFrameworkConfigDO> tcFrameworkConfigs;

	//bi-directional many-to-one association to TcFrameworkConfValDO
	@OneToMany(mappedBy="testCase")
	@Cascade({ CascadeType.ALL })
	private List<TcFrameworkConfValDO> tcFrameworkConfVals;

	//bi-directional many-to-one association to FrameworkDO
	@ManyToOne
	@JoinColumn(name="FRAMEWORK_ID")
	private FrameworkDO framework;

	//bi-directional one-to-one association to TestStepDO
	@OneToOne(mappedBy="testCase")
	private TestStepDO testStep;

	public TestCaseDO() {
	}

	public String getTcId() {
		return this.tcId;
	}

	public void setTcId(String tcId) {
		this.tcId = tcId;
	}

	public String getActualResultInIteration1() {
		return this.actualResultInIteration1;
	}

	public void setActualResultInIteration1(String actualResultInIteration1) {
		this.actualResultInIteration1 = actualResultInIteration1;
	}

	public String getActualResultInIteration2() {
		return this.actualResultInIteration2;
	}

	public void setActualResultInIteration2(String actualResultInIteration2) {
		this.actualResultInIteration2 = actualResultInIteration2;
	}

	public String getActualResultInIteration3() {
		return this.actualResultInIteration3;
	}

	public void setActualResultInIteration3(String actualResultInIteration3) {
		this.actualResultInIteration3 = actualResultInIteration3;
	}

	public String getAssociatedAutomationScript() {
		return this.associatedAutomationScript;
	}

	public void setAssociatedAutomationScript(String associatedAutomationScript) {
		this.associatedAutomationScript = associatedAutomationScript;
	}

	public String getAssociatesRegrTestCases() {
		return this.associatesRegrTestCases;
	}

	public void setAssociatesRegrTestCases(String associatesRegrTestCases) {
		this.associatesRegrTestCases = associatesRegrTestCases;
	}

	public String getAutomationTool() {
		return this.automationTool;
	}

	public void setAutomationTool(String automationTool) {
		this.automationTool = automationTool;
	}

	public String getBusinessPriority() {
		return this.businessPriority;
	}

	public void setBusinessPriority(String businessPriority) {
		this.businessPriority = businessPriority;
	}

	public String getBusinessSeverity() {
		return this.businessSeverity;
	}

	public void setBusinessSeverity(String businessSeverity) {
		this.businessSeverity = businessSeverity;
	}

	public String getCodeDevelopedBy() {
		return this.codeDevelopedBy;
	}

	public void setCodeDevelopedBy(String codeDevelopedBy) {
		this.codeDevelopedBy = codeDevelopedBy;
	}

	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getConditionDescription() {
		return this.conditionDescription;
	}

	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}

	public String getConditionNo() {
		return this.conditionNo;
	}

	public void setConditionNo(String conditionNo) {
		this.conditionNo = conditionNo;
	}

	public String getCriticalityUserImpact() {
		return this.criticalityUserImpact;
	}

	public void setCriticalityUserImpact(String criticalityUserImpact) {
		this.criticalityUserImpact = criticalityUserImpact;
	}

	public String getDeveloperCoded() {
		return this.developerCoded;
	}

	public void setDeveloperCoded(String developerCoded) {
		this.developerCoded = developerCoded;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getExpectedResult() {
		return this.expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String getFirstTimeFailure() {
		return this.firstTimeFailure;
	}

	public void setFirstTimeFailure(String firstTimeFailure) {
		this.firstTimeFailure = firstTimeFailure;
	}

	public String getFirstTimePass() {
		return this.firstTimePass;
	}

	public void setFirstTimePass(String firstTimePass) {
		this.firstTimePass = firstTimePass;
	}

	public String getInputFileNamesTestData() {
		return this.inputFileNamesTestData;
	}

	public void setInputFileNamesTestData(String inputFileNamesTestData) {
		this.inputFileNamesTestData = inputFileNamesTestData;
	}

	public String getInputOutputFileNames() {
		return this.inputOutputFileNames;
	}

	public void setInputOutputFileNames(String inputOutputFileNames) {
		this.inputOutputFileNames = inputOutputFileNames;
	}

	public String getNoOfFailuresOfTestCase() {
		return this.noOfFailuresOfTestCase;
	}

	public void setNoOfFailuresOfTestCase(String noOfFailuresOfTestCase) {
		this.noOfFailuresOfTestCase = noOfFailuresOfTestCase;
	}

	public String getOutputFileNames() {
		return this.outputFileNames;
	}

	public void setOutputFileNames(String outputFileNames) {
		this.outputFileNames = outputFileNames;
	}

	public String getPreparedOnDate() {
		return this.preparedOnDate;
	}

	public void setPreparedOnDate(String preparedOnDate) {
		this.preparedOnDate = preparedOnDate;
	}

	public BigDecimal getRecordsRequired() {
		return this.recordsRequired;
	}

	public void setRecordsRequired(BigDecimal recordsRequired) {
		this.recordsRequired = recordsRequired;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRiskIndexRAG() {
		return this.riskIndexRAG;
	}

	public void setRiskIndexRAG(String riskIndexRAG) {
		this.riskIndexRAG = riskIndexRAG;
	}

	public String getScenNo() {
		return this.scenNo;
	}

	public void setScenNo(String scenNo) {
		this.scenNo = scenNo;
	}

	public String getScenarioDescription() {
		return this.scenarioDescription;
	}

	public void setScenarioDescription(String scenarioDescription) {
		this.scenarioDescription = scenarioDescription;
	}

	public String getSourceCodeVersion() {
		return this.sourceCodeVersion;
	}

	public void setSourceCodeVersion(String sourceCodeVersion) {
		this.sourceCodeVersion = sourceCodeVersion;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTcDesc() {
		return this.tcDesc;
	}

	public void setTcDesc(String tcDesc) {
		this.tcDesc = tcDesc;
	}

	public String getTcName() {
		return this.tcName;
	}

	public void setTcName(String tcName) {
		this.tcName = tcName;
	}

	public String getTdmCentralRelatedDetails() {
		return this.tdmCentralRelatedDetails;
	}

	public void setTdmCentralRelatedDetails(String tdmCentralRelatedDetails) {
		this.tdmCentralRelatedDetails = tdmCentralRelatedDetails;
	}

	public String getTestDataId() {
		return this.testDataId;
	}

	public void setTestDataId(String testDataId) {
		this.testDataId = testDataId;
	}

	public String getTestEnvironment() {
		return this.testEnvironment;
	}

	public void setTestEnvironment(String testEnvironment) {
		this.testEnvironment = testEnvironment;
	}

	public String getTestedBy() {
		return this.testedBy;
	}

	public void setTestedBy(String testedBy) {
		this.testedBy = testedBy;
	}

	public String getTestingStage() {
		return this.testingStage;
	}

	public void setTestingStage(String testingStage) {
		this.testingStage = testingStage;
	}

	public String getTimeToExecuteTheTestCase() {
		return this.timeToExecuteTheTestCase;
	}

	public void setTimeToExecuteTheTestCase(String timeToExecuteTheTestCase) {
		this.timeToExecuteTheTestCase = timeToExecuteTheTestCase;
	}

	public List<TcFrameworkConfigDO> getTcFrameworkConfigs() {
		return this.tcFrameworkConfigs;
	}

	public void setTcFrameworkConfigs(List<TcFrameworkConfigDO> tcFrameworkConfigs) {
		this.tcFrameworkConfigs = tcFrameworkConfigs;
	}

	public TcFrameworkConfigDO addTcFrameworkConfig(TcFrameworkConfigDO tcFrameworkConfig) {
		getTcFrameworkConfigs().add(tcFrameworkConfig);
		tcFrameworkConfig.setTestCase(this);

		return tcFrameworkConfig;
	}

	public TcFrameworkConfigDO removeTcFrameworkConfig(TcFrameworkConfigDO tcFrameworkConfig) {
		getTcFrameworkConfigs().remove(tcFrameworkConfig);
		tcFrameworkConfig.setTestCase(null);

		return tcFrameworkConfig;
	}

	public List<TcFrameworkConfValDO> getTcFrameworkConfVals() {
		return this.tcFrameworkConfVals;
	}

	public void setTcFrameworkConfVals(List<TcFrameworkConfValDO> tcFrameworkConfVals) {
		this.tcFrameworkConfVals = tcFrameworkConfVals;
	}

	public TcFrameworkConfValDO addTcFrameworkConfVal(TcFrameworkConfValDO tcFrameworkConfVal) {
		getTcFrameworkConfVals().add(tcFrameworkConfVal);
		tcFrameworkConfVal.setTestCase(this);

		return tcFrameworkConfVal;
	}

	public TcFrameworkConfValDO removeTcFrameworkConfVal(TcFrameworkConfValDO tcFrameworkConfVal) {
		getTcFrameworkConfVals().remove(tcFrameworkConfVal);
		tcFrameworkConfVal.setTestCase(null);

		return tcFrameworkConfVal;
	}

	public FrameworkDO getFramework() {
		return this.framework;
	}

	public void setFramework(FrameworkDO framework) {
		this.framework = framework;
	}

	public TestStepDO getTestStep() {
		return this.testStep;
	}

	public void setTestStep(TestStepDO testStep) {
		this.testStep = testStep;
	}

}