package com.itap.model.DTO;

public class ITAPTrainViewDTO {

	private long id;
	private String actionBy;
	private String trainName;
	private String trainFrstJobName;
	private String projectName;
	private String trainJobs;

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainFrstJobName() {
		return trainFrstJobName;
	}

	public void setTrainFrstJobName(String trainFrstJobName) {
		this.trainFrstJobName = trainFrstJobName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrainJobs() {
		return trainJobs;
	}

	public void setTrainJobs(String trainJobs) {
		this.trainJobs = trainJobs;
	}

}