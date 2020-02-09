package com.itap.service;

import javax.persistence.EntityManager;

import org.apache.http.HttpResponse;
import org.springframework.web.context.WebApplicationContext;

import com.itap.model.DO.JobDetailsDO;


public interface JenkinCallerService {

	public void reRunJob(String newJobName, String JobURL);
	public String getJenkinResponse();
	public void scheduleAndRunJob(JobDetailsDO model,EntityManager entityManager);
	public HttpResponse buildJobWithSchedule(String jobName,long delay);
	public long getDelayedNanoSeconds(JobDetailsDO jobDetails);
	public String getJenkinsTestResult(String jobUrl);
	
	
	
}
