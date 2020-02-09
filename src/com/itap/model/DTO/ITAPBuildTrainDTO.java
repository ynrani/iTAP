/*---------------------------------------------------------------------------------------
 * Object Name: ITAPBuildTrainDTO.Java
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

public class ITAPBuildTrainDTO {
	private String jobsAct;
	private String jobsSel;
	private String trainName;
	private String projName;

	private List<String> allProjs;
	private String trigger;
	private String actionBy;

	private String isToBeScheduled;
	private String date;

	private List<String> hourList;
	private List<String> minList;

	private String hourToSchedule;
	private String minutesToSchedule;
	private String saveStatus;

	private long serverId;

	public String getIsToBeScheduled() {
		return isToBeScheduled;
	}

	public void setIsToBeScheduled(String isToBeScheduled) {
		this.isToBeScheduled = isToBeScheduled;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<String> getHourList() {
		return hourList;
	}

	public void setHourList(List<String> hourList) {
		this.hourList = hourList;
	}

	public List<String> getMinList() {
		return minList;
	}

	public void setMinList(List<String> minList) {
		this.minList = minList;
	}

	public String getHourToSchedule() {
		return hourToSchedule;
	}

	public void setHourToSchedule(String hourToSchedule) {
		this.hourToSchedule = hourToSchedule;
	}

	public String getMinutesToSchedule() {
		return minutesToSchedule;
	}

	public void setMinutesToSchedule(String minutesToSchedule) {
		this.minutesToSchedule = minutesToSchedule;
	}

	public String getJobsAct() {
		return jobsAct;
	}

	public void setJobsAct(String jobsAct) {
		this.jobsAct = jobsAct;
	}

	public String getJobsSel() {
		return jobsSel;
	}

	public void setJobsSel(String jobsSel) {
		this.jobsSel = jobsSel;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public List<String> getAllProjs() {

		return allProjs;
	}

	public void setAllProjs(List<String> allProjs) {
		this.allProjs = allProjs;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getTrigger() {
		return trigger;
	}

	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getSaveStatus() {
		return saveStatus;
	}

	public void setSaveStatus(String saveStatus) {
		this.saveStatus = saveStatus;
	}

	public long getServerId() {
		return serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}

}