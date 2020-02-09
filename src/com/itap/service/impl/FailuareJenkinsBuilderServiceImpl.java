package com.itap.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.constant.ITAPConstants;
import com.itap.dao.JobDetailsDao;
import com.itap.model.DO.JobDetailsDO;
import com.itap.service.JenkinCallerService;
import com.itap.service.RunnableJobs;

@Component
@Service("failuareJenkinsBuilder")
@Transactional(propagation = Propagation.REQUIRED)
public class FailuareJenkinsBuilderServiceImpl extends ITAPBaseServiceImpl implements RunnableJobs,
		Runnable {
	private static Logger LOGGER = Logger.getLogger(FailuareJenkinsBuilderServiceImpl.class);

	@Autowired
	private JenkinCallerService jenkinCaller;

	@Autowired
	private JobDetailsDao jobDetailsDao;

	private boolean flag = true;
	private EntityManager entityManager;

	@PostConstruct
	public void runThread() {
		Thread tr = new Thread(this);
		tr.start();

	}

	public void stopThread() {
		closeUserEntityManager(entityManager);
		flag = false;
	}

	@Override
	public void run() {
		entityManager = openUserEntityManager();
		while (flag) {
			try {
				initialiseTrackingJobs();
				Thread.sleep(ITAPConstants.THREADTIME);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialiseTrackingJobs() {

		List<JobDetailsDO> jobList = jobDetailsDao.selectAll(entityManager);

		if (null != jobList) {
			for (JobDetailsDO model : jobList) {
				if (model.getDateAndTime().compareTo(new Date()) <= 0) {
					initializeFailedJobjs(model);

					if (model.getJobUrl() != null && !model.getJobColor().equalsIgnoreCase("blue")) {
						jenkinCaller.reRunJob(model.getJobName(), null);
					}

					jobDetailsDao.updateJobStatus(model, entityManager);

				} else {
					break;
				}
			}
		}
	}

	private void initializeFailedJobjs(JobDetailsDO jobModel) {

		String jsonResponse = jenkinCaller.getJenkinResponse();
		try {
			JSONObject json = new JSONObject(jsonResponse);
			org.json.JSONArray arr = json.getJSONArray("jobs"); // new

			for (int i = 0; i < arr.length(); i++) {
				JSONObject jsonTemp = arr.getJSONObject(i);
				if (jobModel.getJobName().equalsIgnoreCase(jsonTemp.getString("name"))) {
					String color = jsonTemp.getString("color");
					if (color.equalsIgnoreCase("red")) {

						jobModel.setJobStatus(color);
						jobModel.setJobColor(jsonTemp.getString("color"));
						jobModel.setJobUrl(jsonTemp.getString("url"));
						break;
					}
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
