/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigDTO.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          10/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.model.DTO;

import java.util.List;

import com.itap.model.DO.ITAPCrossBrowserGridDO;
import com.itap.model.DO.ITAPCrossBrowserOS;
import com.itap.model.DO.ITAPToolTestCaseDO;
import com.itap.model.DO.JenkinsConfigDO;

public class ITAPConfigDTO {
	private String configId;
	private String actionBy;
	private String codeCvg;
	private String projName;
	private String jobName;
	private String deployment;
	private String deplyoment;
	private String docker;
	private String enviorment;
	private String gridLabUrl;
	// ADDED BY VIKRAM
	private int gridUrlActualId;
	private String gridType;
	private String pckage;
	private String repoUrl;
	private String sanity;
	private String source;
	private String testCase;
	private String testSuite;
	private String testType;

	private String qualityGate1;
	private String qualityGate2;
	private String qualityGate3;
	private String criteria1;
	private String criteria2;
	private String criteria3;

	private String tstScrt;
	private String ftQalityGate1;
	private String ftQalityGate2;
	private String ftQalityGate3;
	private String ftCriteria1;
	private String ftCriteria2;
	private String ftCriteria3;

	private String sts;
	private String lastSuccess;
	private String lastFail;

	private String dcompare;

	private List<String> allJobs;
	private List<String> allEnvs;
	private List<String> allProjs;

	private String projName1;
	private String jobName1;

	private String postBuildInvoke;
	private String timer;
	private String toolName1;
	private boolean newOrEdit;

	private String uftPath;

	// Vikram Code Changes Start
	private List<ITAPToolTestCaseDO> bddTestCasesList;
	private List<ITAPToolTestCaseDO> apiTestingTestCasesList;

	// FOR BDD
	private String bddTestSuiteColumnName;
	private String bddTestSuiteColumnValue;
	private String bddSct;

	// FOR API TESTING
	private String apiTestSuiteColumnName;
	private String apiTestSuiteColumnValue;
	private String apiTest;

	// FOR CROSS BROWSER TESTING
	private List<String> optikTestSuiteList;
	private String optikTestSuiteColumnName;
	private String optikTestSuiteColumnValue;
	private String selectedTestCases;

	private String version;
	private String combinedBrowserCombo;
	private String combinedDeviceCombo;
	private List<ITAPConfigBrowCombo> browserComboList;

	private List<ITAPCrossBrowserTestsuite> testSuiteList;
	private List<String> selectMultipleTCList;
	private List<ITAPCrossBrowserGridDO> gridList;

	private List<String> browserList;
	private String browser;
	private List<ITAPCrossBrowserOS> osList;
	private String os;

	private List<String> deviceOsList;
	private List<String> deviceNames;

	private String perfectoDeviceName;
	private String perfectoDeviceUdid;
	private String executionType;

	// FOR FUNCTIONAL TESTING
	private List<ITAPToolTestCaseDO> toolSpecificTestCase;
	private String toolName;
	private String toolColumn;
	private String toolColumnValue;
	private String saveStatus;
	// added below attribute for TDM Integration
	private String selectedTestcaseIds;

	// For Sprint Test
	private String sprintTestSuiteColumnName;
	private String sprintTestSuiteColumnValue;
	private String sprintTest;

	private String optExeType;

	// team city
	// By Sushil Birajdar

	private long serverId;
	private List<JenkinsConfigDO> ciEnginsList;

	public List<String> getDeviceOsList() {
		return deviceOsList;
	}

	public void setDeviceOsList(List<String> deviceOsList) {
		this.deviceOsList = deviceOsList;
	}

	public List<String> getDeviceNames() {
		return deviceNames;
	}

	public void setDeviceNames(List<String> deviceNames) {
		this.deviceNames = deviceNames;
	}

	private List<String> selectedTestCasesList;

	public List<String> getSelectedTestCasesList() {
		return selectedTestCasesList;
	}

	public void setSelectedTestCasesList(List<String> selectedTestCasesList) {
		this.selectedTestCasesList = selectedTestCasesList;
	}

	private String toExecuteFlag;

	// Vikram Code Changes End

	public List<ITAPToolTestCaseDO> getBddTestCasesList() {
		return bddTestCasesList;
	}

	public void setBddTestCasesList(List<ITAPToolTestCaseDO> bddTestCasesList) {
		this.bddTestCasesList = bddTestCasesList;
	}

	public List<ITAPToolTestCaseDO> getApiTestingTestCasesList() {
		return apiTestingTestCasesList;
	}

	public void setApiTestingTestCasesList(List<ITAPToolTestCaseDO> apiTestingTestCasesList) {
		this.apiTestingTestCasesList = apiTestingTestCasesList;
	}

	public List<String> getOptikTestSuiteList() {
		return optikTestSuiteList;
	}

	public void setOptikTestSuiteList(List<String> optikTestSuiteList) {
		this.optikTestSuiteList = optikTestSuiteList;
	}

	public List<ITAPConfigBrowCombo> getBrowserComboList() {
		return browserComboList;
	}

	public void setBrowserComboList(List<ITAPConfigBrowCombo> browserComboList) {
		this.browserComboList = browserComboList;
	}

	public List<String> getSelectMultipleTCList() {
		return selectMultipleTCList;
	}

	public void setSelectMultipleTCList(List<String> selectMultipleTCList) {
		this.selectMultipleTCList = selectMultipleTCList;
	}

	public String getBddTestSuiteColumnName() {
		return bddTestSuiteColumnName;
	}

	public void setBddTestSuiteColumnName(String bddTestSuiteColumnName) {
		this.bddTestSuiteColumnName = bddTestSuiteColumnName;
	}

	public String getBddTestSuiteColumnValue() {
		return bddTestSuiteColumnValue;
	}

	public void setBddTestSuiteColumnValue(String bddTestSuiteColumnValue) {
		this.bddTestSuiteColumnValue = bddTestSuiteColumnValue;
	}

	public String getApiTestSuiteColumnName() {
		return apiTestSuiteColumnName;
	}

	public void setApiTestSuiteColumnName(String apiTestSuiteColumnName) {
		this.apiTestSuiteColumnName = apiTestSuiteColumnName;
	}

	public String getApiTestSuiteColumnValue() {
		return apiTestSuiteColumnValue;
	}

	public void setApiTestSuiteColumnValue(String apiTestSuiteColumnValue) {
		this.apiTestSuiteColumnValue = apiTestSuiteColumnValue;
	}

	public String getOptikTestSuiteColumnName() {
		return optikTestSuiteColumnName;
	}

	public void setOptikTestSuiteColumnName(String optikTestSuiteColumnName) {
		this.optikTestSuiteColumnName = optikTestSuiteColumnName;
	}

	public String getOptikTestSuiteColumnValue() {
		return optikTestSuiteColumnValue;
	}

	public void setOptikTestSuiteColumnValue(String optikTestSuiteColumnValue) {
		this.optikTestSuiteColumnValue = optikTestSuiteColumnValue;
	}

	public String getSelectedTestCases() {
		return selectedTestCases;
	}

	public void setSelectedTestCases(String selectedTestCases) {
		this.selectedTestCases = selectedTestCases;
	}

	public List<ITAPToolTestCaseDO> getToolSpecificTestCase() {
		return toolSpecificTestCase;
	}

	public void setToolSpecificTestCase(List<ITAPToolTestCaseDO> toolSpecificTestCase) {
		this.toolSpecificTestCase = toolSpecificTestCase;
	}

	public String getToExecuteFlag() {
		return toExecuteFlag;
	}

	public void setToExecuteFlag(String toExecuteFlag) {
		this.toExecuteFlag = toExecuteFlag;
	}

	public String getCombinedBrowserCombo() {
		return combinedBrowserCombo;
	}

	public void setCombinedBrowserCombo(String combinedBrowserCombo) {
		this.combinedBrowserCombo = combinedBrowserCombo;
	}

	public List<ITAPCrossBrowserOS> getOsList() {
		return osList;
	}

	public void setOsList(List<ITAPCrossBrowserOS> osList) {
		this.osList = osList;
	}

	public List<ITAPCrossBrowserGridDO> getGridList() {
		return gridList;
	}

	public void setGridList(List<ITAPCrossBrowserGridDO> gridList) {
		this.gridList = gridList;
	}

	public List<String> getBrowserList() {
		return browserList;
	}

	public void setBrowserList(List<String> browserList) {
		this.browserList = browserList;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<ITAPCrossBrowserTestsuite> getTestSuiteList() {
		return testSuiteList;
	}

	public void setTestSuiteList(List<ITAPCrossBrowserTestsuite> testSuiteList) {
		this.testSuiteList = testSuiteList;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getConfigId() {
		return configId;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setBddSct(String bddSct) {
		this.bddSct = bddSct;
	}

	public String getBddSct() {
		return bddSct;
	}

	public void setCodeCvg(String codeCvg) {
		this.codeCvg = codeCvg;
	}

	public String getCodeCvg() {
		return codeCvg;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getProjName() {
		return projName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setDeployment(String deployment) {
		this.deployment = deployment;
	}

	public String getDeployment() {
		return deployment;
	}

	public void setDeplyoment(String deplyoment) {
		this.deplyoment = deplyoment;
	}

	public String getDeplyoment() {
		return deplyoment;
	}

	public void setDocker(String docker) {
		this.docker = docker;
	}

	public String getDocker() {
		return docker;
	}

	public void setEnviorment(String enviorment) {
		this.enviorment = enviorment;
	}

	public String getEnviorment() {
		return enviorment;
	}

	public void setGridLabUrl(String gridLabUrl) {
		this.gridLabUrl = gridLabUrl;
	}

	public String getGridLabUrl() {
		return gridLabUrl;
	}

	public void setGridType(String gridType) {
		this.gridType = gridType;
	}

	public String getGridType() {
		return gridType;
	}

	public void setPckage(String pckage) {
		this.pckage = pckage;
	}

	public String getPckage() {
		return pckage;
	}

	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}

	public String getRepoUrl() {
		return repoUrl;
	}

	public void setSanity(String sanity) {
		this.sanity = sanity;
	}

	public String getSanity() {
		return sanity;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestSuite(String testSuite) {
		this.testSuite = testSuite;
	}

	public String getTestSuite() {
		return testSuite;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTestType() {
		return testType;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getLastSuccess() {
		return lastSuccess;
	}

	public void setLastSuccess(String lastSuccess) {
		this.lastSuccess = lastSuccess;
	}

	public String getLastFail() {
		return lastFail;
	}

	public void setLastFail(String lastFail) {
		this.lastFail = lastFail;
	}

	public String getQualityGate1() {
		return qualityGate1;
	}

	public void setQualityGate1(String qualityGate1) {
		this.qualityGate1 = qualityGate1;
	}

	public String getQualityGate2() {
		return qualityGate2;
	}

	public void setQualityGate2(String qualityGate2) {
		this.qualityGate2 = qualityGate2;
	}

	public String getQualityGate3() {
		return qualityGate3;
	}

	public void setQualityGate3(String qualityGate3) {
		this.qualityGate3 = qualityGate3;
	}

	public String getCriteria1() {
		return criteria1;
	}

	public void setCriteria1(String criteria1) {
		this.criteria1 = criteria1;
	}

	public String getCriteria2() {
		return criteria2;
	}

	public void setCriteria2(String criteria2) {
		this.criteria2 = criteria2;
	}

	public String getCriteria3() {
		return criteria3;
	}

	public void setCriteria3(String criteria3) {
		this.criteria3 = criteria3;
	}

	public String getApiTest() {
		return apiTest;
	}

	public void setApiTest(String apiTest) {
		this.apiTest = apiTest;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public String getTstScrt() {
		return tstScrt;
	}

	public void setTstScrt(String tstScrt) {
		this.tstScrt = tstScrt;
	}

	public String getFtQalityGate1() {
		return ftQalityGate1;
	}

	public void setFtQalityGate1(String ftQalityGate1) {
		this.ftQalityGate1 = ftQalityGate1;
	}

	public String getFtQalityGate2() {
		return ftQalityGate2;
	}

	public void setFtQalityGate2(String ftQalityGate2) {
		this.ftQalityGate2 = ftQalityGate2;
	}

	public String getFtQalityGate3() {
		return ftQalityGate3;
	}

	public void setFtQalityGate3(String ftQalityGate3) {
		this.ftQalityGate3 = ftQalityGate3;
	}

	public String getFtCriteria1() {
		return ftCriteria1;
	}

	public void setFtCriteria1(String ftCriteria1) {
		this.ftCriteria1 = ftCriteria1;
	}

	public String getFtCriteria2() {
		return ftCriteria2;
	}

	public void setFtCriteria2(String ftCriteria2) {
		this.ftCriteria2 = ftCriteria2;
	}

	public String getFtCriteria3() {
		return ftCriteria3;
	}

	public void setFtCriteria3(String ftCriteria3) {
		this.ftCriteria3 = ftCriteria3;
	}

	public List<String> getAllJobs() {
		return allJobs;
	}

	public void setAllJobs(List<String> allJobs) {
		this.allJobs = allJobs;
	}

	public String getProjName1() {
		return projName1;
	}

	public void setProjName1(String projName1) {
		this.projName1 = projName1;
	}

	public String getJobName1() {
		return jobName1;
	}

	public void setJobName1(String jobName1) {
		this.jobName1 = jobName1;
	}

	public String getPostBuildInvoke() {
		return postBuildInvoke;
	}

	public void setPostBuildInvoke(String postBuildInvoke) {
		this.postBuildInvoke = postBuildInvoke;
	}

	public String getTimer() {
		return timer;
	}

	public void setTimer(String timer) {
		this.timer = timer;
	}

	public List<String> getAllProjs() {
		return allProjs;
	}

	public void setAllProjs(List<String> allProjs) {
		this.allProjs = allProjs;
	}

	public boolean getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(boolean newOrEdit) {
		this.newOrEdit = newOrEdit;
	}

	public List<String> getAllEnvs() {
		return allEnvs;
	}

	public void setAllEnvs(List<String> allEnvs) {
		this.allEnvs = allEnvs;
	}

	public String getToolColumn() {
		return toolColumn;
	}

	public void setToolColumn(String toolColumn) {
		this.toolColumn = toolColumn;
	}

	public String getToolColumnValue() {
		return toolColumnValue;
	}

	public void setToolColumnValue(String toolColumnValue) {
		this.toolColumnValue = toolColumnValue;
	}

	public String getDcompare() {
		return dcompare;
	}

	public void setDcompare(String dcompare) {
		this.dcompare = dcompare;
	}

	public int getGridUrlActualId() {
		return gridUrlActualId;
	}

	public void setGridUrlActualId(int gridUrlActualId) {
		this.gridUrlActualId = gridUrlActualId;
	}

	public String getPerfectoDeviceName() {
		return perfectoDeviceName;
	}

	public void setPerfectoDeviceName(String perfectoDeviceName) {
		this.perfectoDeviceName = perfectoDeviceName;
	}

	public String getPerfectoDeviceUdid() {
		return perfectoDeviceUdid;
	}

	public void setPerfectoDeviceUdid(String perfectoDeviceUdid) {
		this.perfectoDeviceUdid = perfectoDeviceUdid;
	}

	public String getCombinedDeviceCombo() {
		return combinedDeviceCombo;
	}

	public void setCombinedDeviceCombo(String combinedDeviceCombo) {
		this.combinedDeviceCombo = combinedDeviceCombo;
	}

	public String getExecutionType() {
		return executionType;
	}

	public void setExecutionType(String executionType) {
		this.executionType = executionType;
	}

	public String getSelectedTestcaseIds() {
		return selectedTestcaseIds;
	}

	public void setSelectedTestcaseIds(String selectedTestcaseIds) {
		this.selectedTestcaseIds = selectedTestcaseIds;
	}

	public String getSaveStatus() {
		return saveStatus;
	}

	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
	}

	public String getToolName1() {
		return toolName1;
	}

	public void setToolName1(String toolName1) {
		this.toolName1 = toolName1;
	}

	public List<JenkinsConfigDO> getCiEnginsList() {
		return ciEnginsList;
	}

	public void setCiEnginsList(List<JenkinsConfigDO> ciEnginsList) {
		this.ciEnginsList = ciEnginsList;
	}

	public long getServerId() {
		return serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}

	public String getUftPath() {
		return uftPath;
	}

	public void setUftPath(String uftPath) {
		this.uftPath = uftPath;
	}

	public String getSprintTestSuiteColumnName() {
		return sprintTestSuiteColumnName;
	}

	public void setSprintTestSuiteColumnName(String sprintTestSuiteColumnName) {
		this.sprintTestSuiteColumnName = sprintTestSuiteColumnName;
	}

	public String getSprintTestSuiteColumnValue() {
		return sprintTestSuiteColumnValue;
	}

	public void setSprintTestSuiteColumnValue(String sprintTestSuiteColumnValue) {
		this.sprintTestSuiteColumnValue = sprintTestSuiteColumnValue;
	}

	public String getSprintTest() {
		return sprintTest;
	}

	public void setSprintTest(String sprintTest) {
		this.sprintTest = sprintTest;
	}

	public String getOptExeType() {
		return optExeType;
	}

	public void setOptExeType(String optExeType) {
		this.optExeType = optExeType;
	}
}