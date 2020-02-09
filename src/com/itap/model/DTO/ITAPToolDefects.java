package com.itap.model.DTO;

import java.util.List;

public class ITAPToolDefects {
	
	private String toolName;
	private String projectName;
	
	private String releaseNo;
	private String demandStory;
	private String host;
	private String browser;
	private String iteration;
	private String environment;
	private String operatingSystem;
	private String user;
	
	private List<ITAPDefectDTO> defectsList;
	
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
	public String getReleaseNo() {
		return releaseNo;
	}
	public void setReleaseNo(String releaseNo) {
		this.releaseNo = releaseNo;
	}
	public String getDemandStory() {
		return demandStory;
	}
	public void setDemandStory(String demandStory) {
		this.demandStory = demandStory;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getIteration() {
		return iteration;
	}
	public void setIteration(String iteration) {
		this.iteration = iteration;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<ITAPDefectDTO> getDefectsList() {
		return defectsList;
	}
	public void setDefectsList(List<ITAPDefectDTO> defectsList) {
		this.defectsList = defectsList;
	}
}
