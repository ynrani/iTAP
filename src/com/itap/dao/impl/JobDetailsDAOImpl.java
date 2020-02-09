package com.itap.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.itap.dao.JobDetailsDao;
import com.itap.model.DO.JobDetailsDO;

//import com.itap.database.DatabaseConnection;
/*
 import com.cg.model.JenkinProjectModel;*/

@Component("jobDetailsDao")
public class JobDetailsDAOImpl implements JobDetailsDao {

	// public static Date systemDate = getSystemCurrentDate();

	@Override
	public void insertInto(JobDetailsDO model, EntityManager entityManager) {
		// DatabaseConnection db = new DatabaseConnection();
		try {

			// String select = "select max(ID) AS id from JobDetailsDO";

			// long id_val = (Long) entityManager.createQuery(
			// "SELECT NVL(MAX(p.id),0) from JobDetailsDO p").getSingleResult();
			long id_val = (Long) entityManager.createQuery(
					"SELECT COALESCE(MAX(p.id),0) from JobDetailsDO p").getSingleResult();

			if (id_val <= 0) {
				model.setId(1);
			} else {
				model.setId(id_val + 1);
			}

			entityManager.getTransaction().begin();
			entityManager.merge(model);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<JobDetailsDO> selectAll(EntityManager entityManager) {
		List<JobDetailsDO> jobList = null;
		try {

			jobList = entityManager
					.createQuery(
							"select p from JobDetailsDO p  where RUN_JOBS='onlyOnce' AND (job_Status='red' OR job_Status='pending')")
					.getResultList();
			Collections.sort(jobList);
		} catch (Exception e) {
			jobList = null;
		}
		return jobList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobDetailsDO> selectDailyMonthly(String typeOfScedule, EntityManager entityManager) {

		List<JobDetailsDO> jobList = null;
		try {
			String query = "select p from JobDetailsDO p where RUN_JOBS='" + typeOfScedule + "'";

			javax.persistence.Query queryObje = entityManager.createQuery(query);

			if (queryObje != null) {
				jobList = queryObje.getResultList();
			}
		} catch (Exception e) {
			jobList = null;

		}

		if (null != jobList)
			for (JobDetailsDO model : jobList) {
				compareUpdateDailyStatus(model, getSystemCurrentDate(), entityManager);
			}
		return jobList;
	}

	@Override
	public void updateDailyJobStatus(JobDetailsDO jobModel, EntityManager entityManager) {

		JobDetailsDO job = entityManager.find(JobDetailsDO.class, jobModel.getId());
		job.setDailyJobStatus(jobModel.getDailyJobStatus());

		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
	}

	@Override
	public void updateJobStatus(JobDetailsDO jobModel, EntityManager entityManager) {

		JobDetailsDO job = entityManager.find(JobDetailsDO.class, jobModel.getId());
		job.setJobStatus(jobModel.getJobStatus());
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
	}

	@Override
	public Date getSystemCurrentDate() {
		SimpleDateFormat systemformate = new SimpleDateFormat("MM/dd/yyyy");

		String date = systemformate.format(new Date());

		Date dateObj = null;
		try {
			dateObj = systemformate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateObj;
	}

	private void compareUpdateDailyStatus(JobDetailsDO jobModel, Date systemDate,
			EntityManager entityManager) {

		String tempDate = jobModel.getDailyJobStatus();
		String priviousDate = tempDate.substring(0, tempDate.lastIndexOf("$"));
		String time = priviousDate.substring(priviousDate.lastIndexOf(" ")).trim();
		SimpleDateFormat currentDate = new SimpleDateFormat("MM/dd/yyyy");

		try {
			Date date = currentDate.parse(priviousDate);
			if (systemDate.compareTo(date) == 1) {
				String currentDateStr = currentDate.format(systemDate) + " " + time + "$pending";
				jobModel.setDailyJobStatus(currentDateStr);
				updateDailyJobStatus(jobModel, entityManager);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
