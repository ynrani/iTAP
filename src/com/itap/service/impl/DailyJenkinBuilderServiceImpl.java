package com.itap.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.itap.model.DO.JobDetailsDO;
import com.itap.service.JenkinCallerService;

@Component
@Service("dailyJenkinBuilder")
@Transactional(propagation = Propagation.REQUIRED)
public class DailyJenkinBuilderServiceImpl extends ITAPBaseServiceImpl implements Runnable {

	private static Logger LOGGER = Logger.getLogger(DailyJenkinBuilderServiceImpl.class);
	@Autowired
	private com.itap.dao.JobDetailsDao jobDetailsDao;

	@Autowired
	private JenkinCallerService jenkinCaller;

	private EntityManager entityManager;
	private boolean flag = true;

	@PostConstruct
	public void runThread() {
		Thread tr = new Thread(this);
		tr.start();
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

	public void stopThread() {
		closeUserEntityManager(entityManager);
		flag = false;
	}

	public void initialiseTrackingJobs() {
		List<JobDetailsDO> jobList = jobDetailsDao.selectDailyMonthly("daily", entityManager);

		if (jobList != null) {
			for (JobDetailsDO model : jobList) {
				try {
					String textTime = model.getDailyJobStatus().substring(0,
							model.getDailyJobStatus().lastIndexOf(" "));

					final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					java.util.Date modelDate = sdf.parse(textTime);
					Date systemDate = jobDetailsDao.getSystemCurrentDate();
					if (modelDate.compareTo(systemDate) == 0) {
						jenkinCaller.scheduleAndRunJob(model, entityManager);
					}
				} catch (ParseException e) {
					closeUserEntityManager(entityManager);
					e.printStackTrace();
				}
			}
		}
	}
}
