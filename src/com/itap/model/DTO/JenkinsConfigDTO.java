/*---------------------------------------------------------------------------------------
 * Object Name: JenkinsConfigDTO.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          30/04/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.model.DTO;

import java.util.List;

public class JenkinsConfigDTO {
	private long jenkinsId;
	private String jenkinsName;
	private String url;
	private String userName;
	private String pass;
	private String actionBy;
	private String ciName;

	// Sushil Birajdar
	// TeamCity Configuration

	private List<JenkinsConfigDTO> jenkinsDTOList;// private long serverId;

	public long getJenkinsId() {
		return jenkinsId;
	}

	public void setJenkinsId(long jenkinsId) {
		this.jenkinsId = jenkinsId;
	}

	public String getJenkinsName() {
		return jenkinsName;
	}

	public void setJenkinsName(String jenkinsName) {
		this.jenkinsName = jenkinsName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getCiName() {
		return ciName;
	}

	public void setCiName(String ciName) {
		this.ciName = ciName;
	}

	public List<JenkinsConfigDTO> getJenkinsDTOList() {
		return jenkinsDTOList;
	}

	public void setJenkinsDTOList(List<JenkinsConfigDTO> jenkinsDTOList) {
		this.jenkinsDTOList = jenkinsDTOList;
	}

	/*
	 * private long teamCityServerId; private String teamCityName; private
	 * String teamCityUrl; private String teamCityUserName; private String
	 * teamCityPass;
	 * 
	 * private String teamCityActionBy; private String teamCityCiName;
	 */

	// Sushil Birajdar
	// All CI Engines added/retrieve

	/*
	 * public String getTeamCityName() { return teamCityName; }
	 * 
	 * public void setTeamCityName(String teamCityName) { this.teamCityName =
	 * teamCityName; }
	 * 
	 * public String getTeamCityUrl() { return teamCityUrl; }
	 * 
	 * public void setTeamCityUrl(String teamCityUrl) { this.teamCityUrl =
	 * teamCityUrl; }
	 * 
	 * public String getTeamCityUserName() { return teamCityUserName; }
	 * 
	 * public void setTeamCityUserName(String teamCityUserName) {
	 * this.teamCityUserName = teamCityUserName; }
	 * 
	 * public String getTeamCityPass() { return teamCityPass; }
	 * 
	 * public void setTeamCityPass(String teamCityPass) { this.teamCityPass =
	 * teamCityPass; }
	 * 
	 * public long getTeamCityServerId() { return teamCityServerId; }
	 * 
	 * public void setTeamCityServerId(long teamCityServerId) {
	 * this.teamCityServerId = teamCityServerId; }
	 * 
	 * public String getTeamCityActionBy() { return teamCityActionBy; }
	 * 
	 * public void setTeamCityActionBy(String teamCityActionBy) {
	 * this.teamCityActionBy = teamCityActionBy; }
	 * 
	 * public String getTeamCityCiName() { return teamCityCiName; }
	 * 
	 * public void setTeamCityCiName(String teamCityCiName) {
	 * this.teamCityCiName = teamCityCiName; }
	 */

	/*
	 * public long getServerId() { return serverId; }
	 * 
	 * public void setServerId(long serverId) { this.serverId = serverId; }
	 */

}