package com.itap.model.DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOOL_TESTCASE")
public class ITAPToolTestCaseDO {
	
	@Id
	@Column(name = "TOOL_TESTCASE_ID")
	private int testCaseId;
	
	@Column(name = "REQUIREMENT")
	private String requirement;
	
	@Column(name = "TEST_SCENARIO")
	private String testScenario;
	
	@Column(name = "TEST_CASE")
	private String testCase;
	
	@Column(name = "MANUAL_AUTO_FLAG")
	private String manualOrAutoFlag;
	
	@Column(name = "EST_MANUAL_EFFORT")
	private String estManualEff;
	
	@Column(name = "EST_AUTOMAT_EFFORT")
	private String estAutomateEff;
	
	@Column(name = "PRIORITY")
	private String priority;
	
	@Column(name = "CRITICALITY")
	private String criticality;
	
	@Column(name = "DEFECT")
	private String defect;
	
	@Column(name = "tool")
	private String toolName;
	
	@Column(name="TDM_CRITERIA")
	private String tdmCriteria;
	
	@Column(name="TDM_NO_RECORDS")
	private Long tdmNoOfRecords;
	
	@Column(name="TDM_DATA_EXIST")
	private String tdmDataExist;
	
	@Column(name="TEST_SET") 
	private String testSet;
	
	private transient String isSelected;
	
	public String getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}
	public int getTestCaseId() {
		return testCaseId;
	}
	public void setTestCaseId(int testCaseId) {
		this.testCaseId = testCaseId;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getTestScenario() {
		return testScenario;
	}
	public void setTestScenario(String testScenario) {
		this.testScenario = testScenario;
	}
	public String getTestCase() {
		return testCase;
	}
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}
	public String getManualOrAutoFlag() {
		return manualOrAutoFlag;
	}
	public void setManualOrAutoFlag(String manualOrAutoFlag) {
		this.manualOrAutoFlag = manualOrAutoFlag;
	}
	public String getEstManualEff() {
		return estManualEff;
	}
	public void setEstManualEff(String estManualEff) {
		this.estManualEff = estManualEff;
	}
	public String getEstAutomateEff() {
		return estAutomateEff;
	}
	public void setEstAutomateEff(String estAutomateEff) {
		this.estAutomateEff = estAutomateEff;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCriticality() {
		return criticality;
	}
	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}
	public String getDefect() {
		return defect;
	}
	public void setDefect(String defect) {
		this.defect = defect;
	}
	public String getToolName() {
		return toolName;
	}
	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	public String getTdmCriteria(){
		return tdmCriteria;
	}
	public void setTdmCriteria(String tdmCriteria){
		this.tdmCriteria = tdmCriteria;
	}
	
	public Long getTdmNoOfRecords(){
		return tdmNoOfRecords;
	}
	public void setTdmNoOfRecords(Long tdmNoOfRecords){
		this.tdmNoOfRecords = tdmNoOfRecords;
	}
	public String getTdmDataExist(){
		return tdmDataExist;
	}
	public void setTdmDataExist(String tdmDataExist){
		this.tdmDataExist = tdmDataExist;
	}
	
	public String getTestSet() {
		return testSet;
	}
	
	public void setTestSet(String testSet) {
		this.testSet = testSet;
	}
}
