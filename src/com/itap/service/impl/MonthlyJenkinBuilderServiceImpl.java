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

@Component
@Service("monthlyJenkinBuilder")
@Transactional(propagation = Propagation.REQUIRED)
public class MonthlyJenkinBuilderServiceImpl extends ITAPBaseServiceImpl implements RunnableJobs,
		Runnable {

	private static Logger LOGGER = Logger.getLogger(MonthlyJenkinBuilderServiceImpl.class);
	@Autowired
	private JobDetailsDao jobDetailsDao;

	@Autowired
	private JenkinCallerService jenkinCaller;

	private List<JobDetailsDO> list = null;
	private boolean flag = true;
	private EntityManager entityManager;

	@PostConstruct
	public void runThread() {
		entityManager = openUserEntityManager();
		Thread tr = new Thread(this);
		tr.start();
	}

	public void stopThread() {

		flag = false;
		closeUserEntityManager(entityManager);
	}

	@Override
	public void run() {
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

		list = jobDetailsDao.selectDailyMonthly("monthly", entityManager);
		Date systemDate = new Date();
		if (null != list) {
			for (JobDetailsDO model : list) {
				Date jobDate = model.getDateAndTime();
				if (jobDate.compareTo(systemDate) == -1
						&& jobDate.getDate() == systemDate.getDate()) {
					jenkinCaller.scheduleAndRunJob(model, entityManager);
				}
			}
		}
	}
}
