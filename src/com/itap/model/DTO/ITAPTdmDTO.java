/*
 * Object Name : ITAPTdmDTO.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  vkrish14		11:09:26 AM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.itap.model.DTO;

/**
 * @author vkrish14
 *
 */
public class ITAPTdmDTO{
	
	private String testCaseName;
	private String testCaseId;
	private String testCriteria;
	private String testNoOfRecords;
	public String getTestCaseName(){
		return testCaseName;
	}
	public void setTestCaseName(String testCaseName){
		this.testCaseName = testCaseName;
	}
	public String getTestCaseId(){
		return testCaseId;
	}
	public void setTestCaseId(String testCaseId){
		this.testCaseId = testCaseId;
	}
	public String getTestCriteria(){
		return testCriteria;
	}
	public void setTestCriteria(String testCriteria){
		this.testCriteria = testCriteria;
	}
	public String getTestNoOfRecords(){
		return testNoOfRecords;
	}
	public void setTestNoOfRecords(String testNoOfRecords){
		this.testNoOfRecords = testNoOfRecords;
	}
	
	
}
