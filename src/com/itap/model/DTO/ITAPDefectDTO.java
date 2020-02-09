package com.itap.model.DTO;

/**
 * This data transfer object serves as a bean for communicating information on XML level.
 * 
 * @author vmullick
 *
 */
public class ITAPDefectDTO {

	private String toolName;
	private String projectName;
	private String defectReportXmlName;
	private String testCaseName;
	private String testCaseNumber;
	
	private String testCaseStatus;
	private String isApproved;
	private String logDefect;
	private String testCaseStepDescription;
	private String testCaseStepNumber;
	private String expectedResults;
	private String actualResults;
	private String stepResult;
	private String stepExceptionLog;
	private String stepScreenshotPath;
	
	private int defectId;
	
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDefectReportXmlName() {
		return defectReportXmlName;
	}
	public void setDefectReportXmlName(String defectReportXmlName) {
		this.defectReportXmlName = defectReportXmlName;
	}
	public String getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}
	public String getTestCaseNumber() {
		return testCaseNumber;
	}
	public void setTestCaseNumber(String testCaseNumber) {
		this.testCaseNumber = testCaseNumber;
	}
	public String getTestCaseStatus() {
		return testCaseStatus;
	}
	public void setTestCaseStatus(String testCaseStatus) {
		this.testCaseStatus = testCaseStatus;
	}
	public String getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}
	public String getLogDefect() {
		return logDefect;
	}
	public void setLogDefect(String logDefect) {
		this.logDefect = logDefect;
	}
	public String getTestCaseStepDescription() {
		return testCaseStepDescription;
	}
	public void setTestCaseStepDescription(String testCaseStepDescription) {
		this.testCaseStepDescription = testCaseStepDescription;
	}
	public String getTestCaseStepNumber() {
		return testCaseStepNumber;
	}
	public void setTestCaseStepNumber(String testCaseStepNumber) {
		this.testCaseStepNumber = testCaseStepNumber;
	}
	public String getExpectedResults() {
		return expectedResults;
	}
	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}
	public String getActualResults() {
		return actualResults;
	}
	public void setActualResults(String actualResults) {
		this.actualResults = actualResults;
	}
	public String getStepResult() {
		return stepResult;
	}
	public void setStepResult(String stepResult) {
		this.stepResult = stepResult;
	}
	public String getStepExceptionLog() {
		return stepExceptionLog;
	}
	public void setStepExceptionLog(String stepExceptionLog) {
		this.stepExceptionLog = stepExceptionLog;
	}
	public String getStepScreenshotPath() {
		return stepScreenshotPath;
	}
	public void setStepScreenshotPath(String stepScreenshotPath) {
		this.stepScreenshotPath = stepScreenshotPath;
	}
	public int getDefectId() {
		return defectId;
	}
	public void setDefectId(int defectId) {
		this.defectId = defectId;
	}
}
