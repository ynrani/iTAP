/*---------------------------------------------------------------------------------------
 * Object Name: ITAPProgressDTO.Java
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

public class ITAPProgressDTO {
	private String projName;
	private List<String> allProjs;
	private String allJobs;

	private String jobNo;
	private String jobName;
	private String jobSts;
	private String jobTime;
	private String jobDuri;
	private String jobEstDuri;
	private String jobConsoleUrl;
	// Sushil Birajdar
	private long serverId;

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public List<String> getAllProjs() {
		return allProjs;
	}

	public void setAllProjs(List<String> allProjs) {
		this.allProjs = allProjs;
	}

	public String getAllJobs() {
		return allJobs;
	}

	public void setAllJobs(String allJobs) {
		this.allJobs = allJobs;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobSts() {
		return jobSts;
	}

	public void setJobSts(String jobSts) {
		this.jobSts = jobSts;
	}

	public String getJobTime() {
		return jobTime;
	}

	public void setJobTime(String jobTime) {
		this.jobTime = jobTime;
	}

	public String getJobDuri() {
		return jobDuri;
	}

	public void setJobDuri(String jobDuri) {
		this.jobDuri = jobDuri;
	}

	public String getJobEstDuri() {
		return jobEstDuri;
	}

	public void setJobEstDuri(String jobEstDuri) {
		this.jobEstDuri = jobEstDuri;
	}

	public long getServerId() {
		return serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}

	public String getJobConsoleUrl() {
		return jobConsoleUrl;
	}

	public void setJobConsoleUrl(String jobConsoleUrl) {
		this.jobConsoleUrl = jobConsoleUrl;
	}

}