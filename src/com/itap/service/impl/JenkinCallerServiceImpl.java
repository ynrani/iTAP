package com.itap.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itap.dao.JobDetailsDao;
import com.itap.exception.ServiceException;
import com.itap.model.DO.JobDetailsDO;
import com.itap.service.ITAPJenkinsConfigService;
import com.itap.service.JenkinCallerService;
import com.itap.util.DateService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Component
@Service("jenkinCaller")
public class JenkinCallerServiceImpl implements JenkinCallerService {

	@Autowired
	private JobDetailsDao jobDetailsDao;

	@Autowired
	ITAPJenkinsConfigService itapJenkinsConfigService;

	private long serverId = 1l;

	@Override
	public void reRunJob(String newJobName, String JobURL) {
		HttpResponse responseCode = null;
		String jenkinUrl = null;
		try {
			jenkinUrl = itapJenkinsConfigService.getJenkinsUrl(serverId);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		StringBuffer url = new StringBuffer(jenkinUrl);
		try {

			HttpClient client = HttpClientBuilder.create().build();
			String finalUrl = url + "/job/" + newJobName + "/build";

			HttpGet get = new HttpGet(finalUrl);
			responseCode = client.execute(get);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getJenkinResponse() {
		Client client = Client.create();

		String jenkinUrl = null;
		try {
			jenkinUrl = itapJenkinsConfigService.getJenkinsUrl(serverId);
		} catch (ServiceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		WebResource webResource = client.resource(jenkinUrl + "/api/json");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);

		client.destroy();
		return jsonResponse;
	}

	/*
	 * 1) pass jobdetailsmodel object to this method to schedule and run the job
	 * as per the conditions 2) pending means that the job is not schedule 3)
	 * building means that the job is scheduled 4) anime means job is cuurently
	 * building 5) red means fail the given job and so on
	 */
	@Override
	public void scheduleAndRunJob(JobDetailsDO model, EntityManager entityManager) {

		String checkStatus = model.getDailyJobStatus();
		if (checkStatus.contains("pending")) {
			jenkinCaller(model, entityManager);
		}

		try {
			Date jobDate = DateService.getDateFromJobStatus(checkStatus);
			System.out.println(model);
			if (jobDate.compareTo(new Date()) == -1 && checkStatus.contains("building")) {
				initializeJsonJobs(model);
				jobDetailsDao.updateDailyJobStatus(model, entityManager);
			}

			if (checkStatus.contains("anime") || checkStatus.contains("red")
					|| checkStatus.contains("notbuilt")) {
				initializeJsonJobs(model);
				if (!model.getDailyJobStatus().contains("blue")) {
					reRunJob(model.getJobName(), null);
				} else {
					jobDetailsDao.updateDailyJobStatus(model, entityManager);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public HttpResponse buildJobWithSchedule(String jobName, long delay) {

		HttpResponse responseCode = null;
		try {
			HttpClient client = HttpClientBuilder.create().build();

			String jenkinUrl = null;
			try {
				jenkinUrl = itapJenkinsConfigService.getJenkinsUrl(serverId);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String finalUrl = jenkinUrl + "/job/" + jobName + "/build";
			if (delay > 0) {
				finalUrl = finalUrl + "?delay=" + delay;
			}
			HttpGet get = new HttpGet(finalUrl);
			responseCode = client.execute(get);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseCode;
	}

	@Override
	public long getDelayedNanoSeconds(JobDetailsDO jobDetails) {

		long nanosecond = 0;
		try {
			String str = jobDetails.getDailyJobStatus().substring(0,
					jobDetails.getDailyJobStatus().lastIndexOf("$"));
			final String textTime = str + ":00";

			final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			final java.util.Date date = sdf.parse(textTime);
			final java.sql.Timestamp scheduledTimestamp = new java.sql.Timestamp(date.getTime());
			final java.util.Date currentDate = new java.util.Date();
			final java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(
					currentDate.getTime());
			final long diffNano = scheduledTimestamp.getTime() - currentTimestamp.getTime();
			if (diffNano < 0) {
				nanosecond = 0;
			} else {
				nanosecond = diffNano;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nanosecond;
	}

	/*
	 * This method is actually schedule the job with given delay
	 */

	private void jenkinCaller(JobDetailsDO model, EntityManager entityManager) {
		long nanoDelay = getDelayedNanoSeconds(model);
		double seconds = nanoDelay / 1000.0;
		long finalDelay = (new Double(seconds)).longValue();

		buildJobWithSchedule(model.getJobName(), finalDelay);
		String updateStatus = model.getDailyJobStatus();
		updateStatus = updateStatus.substring(0, updateStatus.lastIndexOf("$"));
		updateStatus = updateStatus + "$building";
		model.setDailyJobStatus(updateStatus);

		jobDetailsDao.updateDailyJobStatus(model, entityManager);
	}

	private void initializeJsonJobs(JobDetailsDO jobModel) {
		String jsonResponse = getJenkinResponse();
		try {
			JSONObject json = new JSONObject(jsonResponse);
			org.json.JSONArray arr = json.getJSONArray("jobs"); // new

			for (int i = 0; i < arr.length(); i++) {
				JSONObject jsonTemp = arr.getJSONObject(i);

				if (jobModel.getJobName().equalsIgnoreCase(jsonTemp.getString("name"))) {
					String color = jsonTemp.getString("color");

					jobModel.setJobStatus(color);
					jobModel.setJobColor(jsonTemp.getString("color"));
					jobModel.setJobUrl(jsonTemp.getString("url"));
					String str = jobModel.getDailyJobStatus();
					String finalString = str.substring(0, str.lastIndexOf("$"));
					finalString = finalString + "$" + jsonTemp.getString("color");

					jobModel.setDailyJobStatus(finalString);
					break;
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}


	@Override
	public String getJenkinsTestResult(String jobUrl) {
		Client client = Client.create();

		WebResource webResource = client.resource(jobUrl);
		ClientResponse clientresponse = webResource.type("application/json").post(
				ClientResponse.class);
		String jsonResponse = clientresponse.getEntity(String.class);

		client.destroy();
		return jsonResponse;
	}

}
