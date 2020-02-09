package com.itap.model.DO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TRACKING_JOBS")
public class JobDetailsDO implements Comparable<JobDetailsDO> {

	@Id
	@Column(name = "ID")
	private long id;

	@Column(name = "job_Name")
	private String jobName;

	@Transient
	private String jobUrl;

	@Transient
	private String jobColor;

	@Column(name = "DATEANDTIME")
	private Timestamp dateAndTime;

	@Column(name = "job_Status")
	private String jobStatus;

	// Every day, weekly, monthly
	@Column(name = "RUN_JOBS")
	private String jobRunType;

	@Column(name = "DAILY_JOB_STATUS")
	private String dailyJobStatus;

	public String getDailyJobStatus() {
		return dailyJobStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDailyJobStatus(String dailyJobStatus) {
		this.dailyJobStatus = dailyJobStatus;
	}

	public Timestamp getDateAndTime() {
		return this.dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

	public String getJobRunType() {
		return jobRunType;
	}

	public void setJobRunType(String jobRunType) {
		this.jobRunType = jobRunType;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}

	public String getJobColor() {
		return jobColor;
	}

	public void setJobColor(String jobColor) {
		this.jobColor = jobColor;
	}

	 

	@Override
	public int compareTo(JobDetailsDO model) {
		if (dateAndTime != null) {
			return dateAndTime.compareTo(model.getDateAndTime());
		}
		return 0;
	}

}