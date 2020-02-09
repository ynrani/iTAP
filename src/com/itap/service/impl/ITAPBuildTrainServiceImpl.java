/*---------------------------------------------------------------------------------------
 * Object Name: ITAPBuildTrainServiceImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          03/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.service.impl;

import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPConfigDAO;
import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DTO.ITAPBuildTrainDTO;
import com.itap.model.DTO.ITAPTrainViewDTO;
import com.itap.model.mapper.ITAPConfigMapper;
import com.itap.service.ITAPBuildTrainService;
import com.itap.service.ITAPJenkinsConfigService;
import com.itap.util.CreateJenkinsJob;

@Component
@Service("itapBuildTrainService")
@Transactional(propagation = Propagation.REQUIRED)
public class ITAPBuildTrainServiceImpl extends ITAPBaseServiceImpl implements ITAPBuildTrainService {
	private static Logger LOGGER = Logger.getLogger(ITAPBuildTrainServiceImpl.class);

	@Autowired
	ITAPConfigDAO itapConfigDAO;

	@Autowired
	ITAPConfigMapper itapConfigMapper;

	// private long serverId = 1l;
	@Autowired
	ITAPJenkinsConfigService itapJenkinsConfigService;

	@Override
	public String buildTrain(ITAPBuildTrainDTO itapBuildTrainDTO) throws ServiceException {
		try {
			String[] jobs = itapBuildTrainDTO.getJobsSel().split(",");
			if (null != jobs) {
				String trainJobs = "";
				for (int i = 0; i < jobs.length; i++) {
					// Read Job
					String jsonResponse = CreateJenkinsJob
							.readJob(itapJenkinsConfigService.getJenkinsUrl(itapBuildTrainDTO
									.getServerId()), jobs[i] + "");
					String oldJobPostBuild = null;

					if (null != jsonResponse && jsonResponse.contains("publishers")) {

						if (jsonResponse.contains("<publishers>")) {
							oldJobPostBuild = StringUtils.substringBetween(jsonResponse,
									"<publishers>", "</publishers>");
						} else if (jsonResponse.contains("<publishers/>")) {
							oldJobPostBuild = "";
						}

						StringBuffer input = new StringBuffer("<hudson.tasks.BuildTrigger>");
						input.append("<childProjects>");
						if (i < jobs.length - 1) {
							input.append(String.valueOf(jobs[i + 1]) + "_"
									+ itapBuildTrainDTO.getTrainName());
						}
						input.append("</childProjects>");
						input.append("<threshold>");

						if (null != itapBuildTrainDTO.getTrigger()
								&& "buildStable".equalsIgnoreCase(itapBuildTrainDTO.getTrigger())) {
							input.append("<name>SUCCESS</name>");
							input.append("<ordinal>0</ordinal>");
							input.append("<color>BLUE</color>");
						} else if (null != itapBuildTrainDTO.getTrigger()
								&& "buildFails".equalsIgnoreCase(itapBuildTrainDTO.getTrigger())) {
							input.append("<name>FAILURE</name>");
							input.append("<ordinal>2</ordinal>");
							input.append("<color>RED</color>");
						}
						input.append("<completeBuild>true</completeBuild>");
						input.append("</threshold>");
						input.append("</hudson.tasks.BuildTrigger>");

						oldJobPostBuild = input + "";

						if (jsonResponse.contains("<publishers>")) {
							jsonResponse = jsonResponse.replaceAll(
									"(<publishers>)[^&]*(</publishers>)", "$1" + oldJobPostBuild
											+ "$2");
						} else if (jsonResponse.contains("<publishers/>")) {
							jsonResponse = jsonResponse.replaceAll("<publishers/>", "<publishers>"
									+ oldJobPostBuild + "</publishers>");
						}

						String oldJobName = StringUtils.substringBetween(jsonResponse,
								"<description>", "</description>");
						String newJobName = null;
						if (StringUtils.isNotEmpty(oldJobName)) {
							newJobName = oldJobName + "_" + itapBuildTrainDTO.getTrainName();
						} else {
							newJobName = jobs[i] + "_" + itapBuildTrainDTO.getTrainName();
						}
						jsonResponse = jsonResponse.replaceAll(
								"(<description>)[^&]*(</description>)", "$1" + newJobName + "$2");

						// Create copy job in train
						CreateJenkinsJob.createJob(itapJenkinsConfigService
								.getJenkinsUrl(itapBuildTrainDTO.getServerId()), newJobName,
								jsonResponse);
						trainJobs += newJobName + ",";
					}
					System.out.println("Pair : " + jobs[i]);
				}

				String newJobName = jobs[0] + "_" + itapBuildTrainDTO.getTrainName();
				if (itapBuildTrainDTO.getIsToBeScheduled() != null
						&& itapBuildTrainDTO.getIsToBeScheduled().equals("Y")) {
					long nanoDelay = getDelayedNanoSeconds(itapBuildTrainDTO);
					double seconds = nanoDelay / 1000.0;
					long finalDelay = (new Double(seconds)).longValue();
					CreateJenkinsJob
							.buildJob(itapJenkinsConfigService.getJenkinsUrl(itapBuildTrainDTO
									.getServerId()), newJobName, finalDelay);

				} else {
					CreateJenkinsJob
							.buildJob(itapJenkinsConfigService.getJenkinsUrl(itapBuildTrainDTO
									.getServerId()), newJobName);
				}

				/**
				 * Save job in DB
				 */
				ITAPTrainViewDTO itapTrainViewDTO = new ITAPTrainViewDTO();
				itapTrainViewDTO.setActionBy(itapBuildTrainDTO.getActionBy());
				itapTrainViewDTO.setTrainName(itapBuildTrainDTO.getTrainName());
				itapTrainViewDTO.setTrainFrstJobName(newJobName);
				itapTrainViewDTO.setProjectName(newJobName.substring(0, newJobName.indexOf("_")));
				itapTrainViewDTO.setTrainJobs(trainJobs);
				EntityManager managerUser = openUserEntityManager();
				itapConfigDAO.saveTrainDetails(itapConfigMapper
						.convertFromITAPTrainViewDTOToITAPTrainViewDO(itapTrainViewDTO,
								new ITAPTrainViewDO()), managerUser);
				closeUserEntityManager(managerUser);

				// CreateJenkinsJob.createJob("", null, null);

			}
			return "";

		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}

	}

	private long getDelayedNanoSeconds(final ITAPBuildTrainDTO itapBuildTrainDTO) {

		long nanosecond = 0;
		try {
			final String textTime = itapBuildTrainDTO.getDate() + " "
					+ itapBuildTrainDTO.getHourToSchedule() + ":"
					+ itapBuildTrainDTO.getMinutesToSchedule() + ":00";
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
		} catch (final Exception e) {
			LOGGER.error(e.getMessage());
		}
		return nanosecond;

	}
}
