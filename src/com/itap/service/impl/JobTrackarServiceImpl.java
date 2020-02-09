package com.itap.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itap.dao.JobDetailsDao;
import com.itap.model.DO.JobDetailsDO;
import com.itap.model.DTO.ITAPBuildTrainDTO;
import com.itap.util.DateUtils;

@Component
@Service("jobTrackar")
public class JobTrackarServiceImpl extends ITAPBaseServiceImpl {

	@Autowired
	private JobDetailsDao jobDetailsDao;

	public void track(ITAPBuildTrainDTO itapBuildTrainDTO, String jobRunType) {
		String[] jobs = itapBuildTrainDTO.getJobsSel().split(",");

		String dateString = itapBuildTrainDTO.getDate();
		if (!dateString.equalsIgnoreCase("")) {

			String hour = getNumberString(itapBuildTrainDTO.getHourToSchedule());
			String minutes = getNumberString(itapBuildTrainDTO.getMinutesToSchedule());
			String validDate = dateString + " " + hour + ":" + minutes;
			try {

				for (String job : jobs) {
					JobDetailsDO model = new JobDetailsDO();

					model.setDateAndTime(DateUtils
							.converStringTimeStampToSqlTimeStampWithHHMM(validDate));
					model.setJobName(job);
					model.setJobStatus("notbuild");

					model.setJobRunType(jobRunType);
					model.setDailyJobStatus(validDate + "$pending");
					EntityManager entityManager = openUserEntityManager();
					jobDetailsDao.insertInto(model, entityManager);
					closeUserEntityManager(entityManager);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String getNumberString(String number) {
		try {
			return Integer.parseInt(number.trim()) + "";
		} catch (Exception e) {
			return "00";
		}
	}
}
