package com.itap.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
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
import com.itap.util.DateService;

@Component
@Service("weeklyJenkinBuilder")
@Transactional(propagation = Propagation.REQUIRED)
public class WeeklyJobScheduleServiceImpl extends ITAPBaseServiceImpl implements RunnableJobs,
		Runnable {

	private static Logger LOGGER = Logger.getLogger(WeeklyJobScheduleServiceImpl.class);

	@Autowired
	private JobDetailsDao jobDetailsDao;

	@Autowired
	private JenkinCallerService jenkinCaller;

	private List<JobDetailsDO> list = null;

	private EntityManager entityManager;
	/* private JobDetailsDao dao; */
	private boolean flag = true;

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

	public void stopThread() {
		closeUserEntityManager(entityManager);
		flag = false;
	}

	@Override
	public void initialiseTrackingJobs() {

		list = jobDetailsDao.selectDailyMonthly("weekly", entityManager);
		if (null != list) {
			for (JobDetailsDO model : list) {
				Date modelPriDate = model.getDateAndTime();
				Date jobScheduleDate = DateService.getDateFromJobStatus(model.getDailyJobStatus());

				if (jobScheduleDate.getDay() == modelPriDate.getDay()) {
					jenkinCaller.scheduleAndRunJob(model, entityManager);
				}
			}
		}
	}

	@PostConstruct
	public void runThread() {
		Thread tr = new Thread(this);
		tr.start();

	}

}
