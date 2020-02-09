package com.itap.model.DO;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the AUTO_HUB_TRAIN_VIEW database table.
 * 
 */
@Entity
@Table(name = "AUTO_HUB_TRAIN_VIEW")
@NamedQuery(name = "ITAPTrainViewDO.findAll", query = "SELECT a FROM ITAPTrainViewDO a")
public class ITAPTrainViewDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "ACTION_BY")
	private String actionBy;

	@Column(name = "ACTION_DATE")
	private Timestamp actionDt;

	@Column(name = "TRAIN_NAME")
	private String trainName;

	@Column(name = "TRAIN_FRST_JOB_NAME")
	private String trainFrstJobName;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "TRAIN_JOBS")
	private String trainJobs;

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public Timestamp getActionDt() {
		return actionDt;
	}

	public void setActionDt(Timestamp actionDt) {
		this.actionDt = actionDt;
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