package com.itap.model.DTO;

import java.util.List;

public class ITAPCrossBrowserTestsuite {
	
	private String testSuiteName;
	private List<String> testCaseNameList;
	
	public String getTestSuiteName() {
		return testSuiteName;
	}
	public void setTestSuiteName(String testSuiteName) {
		this.testSuiteName = testSuiteName;
	}
	public List<String> getTestCaseNameList() {
		return testCaseNameList;
	}
	public void setTestCaseNameList(List<String> testCaseNameList) {
		this.testCaseNameList = testCaseNameList;
	}
}
