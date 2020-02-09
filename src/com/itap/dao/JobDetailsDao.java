package com.itap.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.itap.model.DO.JobDetailsDO;

public interface JobDetailsDao {
	public void insertInto(JobDetailsDO model, EntityManager entityManager);

	public List<JobDetailsDO> selectAll(EntityManager entityManager);

	public List<JobDetailsDO> selectDailyMonthly(String typeOfScedule, EntityManager entityManager);

	public void updateDailyJobStatus(JobDetailsDO jobModel, EntityManager entityManager);

	public void updateJobStatus(JobDetailsDO jobModel, EntityManager entityManager);

	public Date getSystemCurrentDate();

}
