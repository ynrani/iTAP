/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigMapperImpl.Java
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
package com.itap.model.mapper.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPConfigDO;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DO.ITAPBookDtlDO;
import com.itap.model.DO.ITAPEnvDtlDO;
import com.itap.model.DTO.ITAPConfigDTO;
import com.itap.model.DTO.ITAPTrainViewDTO;
import com.itap.model.DTO.ITAPBookEnvDTO;
import com.itap.model.DTO.ITAPSearchBookingDTO;
import com.itap.model.mapper.ITAPConfigMapper;
import com.itap.util.CalendarDateUtils;
import com.itap.util.DateUtils;

@Component
@Service("itapConfigMapper")
public class ITAPConfigMapperImpl implements ITAPConfigMapper {
	@Override
	public ITAPConfigDTO convertFromITAPConfigDOToITAPConfigDTO(
			ITAPConfigDO itapConfigDO, ITAPConfigDTO itapConfigDTO) {
		try {
			if (itapConfigDO.getConfigId() > 0) {
				itapConfigDTO.setConfigId(String.valueOf(itapConfigDO.getConfigId()));
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getActionBy())) {
				itapConfigDTO.setActionBy(itapConfigDO.getActionBy());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getBddSct())) {
				itapConfigDTO.setBddSct(itapConfigDO.getBddSct());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getCodeCvg())) {
				itapConfigDTO.setCodeCvg(itapConfigDO.getCodeCvg());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getProjName())) {
				itapConfigDTO.setProjName(itapConfigDO.getProjName());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getJobName())) {
				itapConfigDTO.setJobName(itapConfigDO.getJobName());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getDeployment())) {
				itapConfigDTO.setDeployment(itapConfigDO.getDeployment());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getDeplyoment())) {
				itapConfigDTO.setDeplyoment(itapConfigDO.getDeplyoment());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getDocker())) {
				itapConfigDTO.setDocker(itapConfigDO.getDocker());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getEnviorment())) {
				itapConfigDTO.setEnviorment(itapConfigDO.getEnviorment());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getGridLabUrl())) {
				itapConfigDTO.setGridLabUrl(itapConfigDO.getGridLabUrl());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getGridType())) {
				itapConfigDTO.setGridType(itapConfigDO.getGridType());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getPckage())) {
				itapConfigDTO.setPckage(itapConfigDO.getPckage());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getRepoUrl())) {
				itapConfigDTO.setRepoUrl(itapConfigDO.getRepoUrl());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getSanity())) {
				itapConfigDTO.setSanity(itapConfigDO.getSanity());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getSource())) {
				itapConfigDTO.setSource(itapConfigDO.getSource());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getTestCase())) {
				itapConfigDTO.setTestCase(itapConfigDO.getTestCase());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getTestSuite())) {
				itapConfigDTO.setTestSuite(itapConfigDO.getTestSuite());
			}
			if (StringUtils.isNotEmpty(itapConfigDO.getTestType())) {
				itapConfigDTO.setTestType(itapConfigDO.getTestType());
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapConfigDTO;
	}

	@Override
	public ITAPConfigDO convertFromITAPConfigDTOToITAPConfigDO(
			ITAPConfigDTO itapConfigDTO, ITAPConfigDO itapConfigDO) {
		try {
			if (StringUtils.isNotEmpty(itapConfigDTO.getConfigId())) {
				itapConfigDO.setConfigId(Long.parseLong(itapConfigDTO.getConfigId()));
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getActionBy())) {
				itapConfigDO.setActionBy(itapConfigDTO.getActionBy());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getBddSct())) {
				itapConfigDO.setBddSct(itapConfigDTO.getBddSct());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getCodeCvg())) {
				itapConfigDO.setCodeCvg(itapConfigDTO.getCodeCvg());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getProjName())) {
				itapConfigDO.setProjName(itapConfigDTO.getProjName());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getJobName())) {
				itapConfigDO.setJobName(itapConfigDTO.getJobName());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getDeployment())) {
				itapConfigDO.setDeployment(itapConfigDTO.getDeployment());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getDeplyoment())) {
				itapConfigDO.setDeplyoment(itapConfigDTO.getDeplyoment());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getDocker())) {
				itapConfigDO.setDocker(itapConfigDTO.getDocker());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getEnviorment())) {
				itapConfigDO.setEnviorment(itapConfigDTO.getEnviorment());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getGridLabUrl())) {
				itapConfigDO.setGridLabUrl(itapConfigDTO.getGridLabUrl());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getGridType())) {
				itapConfigDO.setGridType(itapConfigDTO.getGridType());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getPckage())) {
				itapConfigDO.setPckage(itapConfigDTO.getPckage());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getRepoUrl())) {
				itapConfigDO.setRepoUrl(itapConfigDTO.getRepoUrl());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getSanity())) {
				itapConfigDO.setSanity(itapConfigDTO.getSanity());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getSource())) {
				itapConfigDO.setSource(itapConfigDTO.getSource());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getTestCase())) {
				itapConfigDO.setTestCase(itapConfigDTO.getTestCase());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getTestSuite())) {
				itapConfigDO.setTestSuite(itapConfigDTO.getTestSuite());
			}
			if (StringUtils.isNotEmpty(itapConfigDTO.getTestType())) {
				itapConfigDO.setTestType(itapConfigDTO.getTestType());
			}

			itapConfigDO.setActionBy(itapConfigDTO.getActionBy());
			itapConfigDO.setActionDt(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapConfigDO;
	}

	@Override
	public List<ITAPConfigDTO> convertFromITAPConfigDOsToITAPConfigDTOs(
			List<ITAPConfigDO> itapConfigDOs) {

		ITAPConfigDTO itapConfigDTO = null;
		List<ITAPConfigDTO> itapConfigDTOs = null;
		if (null != itapConfigDOs) {
			itapConfigDTOs = new ArrayList<ITAPConfigDTO>();
			for (ITAPConfigDO itapConfigDO : itapConfigDOs) {
				itapConfigDTO = new ITAPConfigDTO();
				itapConfigDTO = convertFromITAPConfigDOToITAPConfigDTO(itapConfigDO,
						itapConfigDTO);
				itapConfigDTOs.add(itapConfigDTO);
			}

		}
		return itapConfigDTOs;

	}

	// TODO
	@Override
	public ITAPTrainViewDTO convertFromITAPTrainViewDOToITAPTrainViewDTO(
			ITAPTrainViewDO itapTrainViewDO, ITAPTrainViewDTO itapTrainViewDTO) {
		try {

			if (0 < itapTrainViewDO.getId()) {
				itapTrainViewDTO.setId(itapTrainViewDO.getId());
			}

			if (StringUtils.isNotEmpty(itapTrainViewDO.getTrainJobs())) {
				itapTrainViewDTO.setTrainJobs(itapTrainViewDO.getTrainJobs());
			}

			if (StringUtils.isNotEmpty(itapTrainViewDO.getActionBy())) {
				itapTrainViewDTO.setActionBy(itapTrainViewDO.getActionBy());
			}
			if (StringUtils.isNotEmpty(itapTrainViewDO.getTrainName())) {
				itapTrainViewDTO.setTrainName(itapTrainViewDO.getTrainName());
			}
			if (StringUtils.isNotEmpty(itapTrainViewDO.getTrainFrstJobName())) {
				itapTrainViewDTO.setTrainFrstJobName(itapTrainViewDO.getTrainFrstJobName());
			}
			if (StringUtils.isNotEmpty(itapTrainViewDO.getProjectName())) {
				itapTrainViewDTO.setProjectName(itapTrainViewDO.getProjectName());
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapTrainViewDTO;
	}

	@Override
	public ITAPTrainViewDO convertFromITAPTrainViewDTOToITAPTrainViewDO(
			ITAPTrainViewDTO itapTrainViewDTO, ITAPTrainViewDO itapTrainViewDO) {
		try {

			if (0 < itapTrainViewDTO.getId()) {
				itapTrainViewDO.setId(itapTrainViewDTO.getId());
			}

			if (StringUtils.isNotEmpty(itapTrainViewDTO.getTrainJobs())) {
				itapTrainViewDO.setTrainJobs(itapTrainViewDTO.getTrainJobs());
			}

			if (StringUtils.isNotEmpty(itapTrainViewDTO.getTrainName())) {
				itapTrainViewDO.setTrainName(itapTrainViewDTO.getTrainName());
			}

			if (StringUtils.isNotEmpty(itapTrainViewDTO.getTrainFrstJobName())) {
				itapTrainViewDO.setTrainFrstJobName(itapTrainViewDTO.getTrainFrstJobName());
			}
			if (StringUtils.isNotEmpty(itapTrainViewDTO.getProjectName())) {
				itapTrainViewDO.setProjectName(itapTrainViewDTO.getProjectName());
			}

			itapTrainViewDO.setActionBy(itapTrainViewDTO.getActionBy());
			itapTrainViewDO.setActionDt(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapTrainViewDO;
	}

	@Override
	public List<ITAPTrainViewDTO> convertFromITAPTrainViewDOsToITAPTrainViewDTOs(
			List<ITAPTrainViewDO> itapTrainViewDOs) {

		ITAPTrainViewDTO itapTrainViewDTO = null;
		List<ITAPTrainViewDTO> itapTrainViewDTOs = null;
		if (null != itapTrainViewDOs) {
			itapTrainViewDTOs = new ArrayList<ITAPTrainViewDTO>();
			for (ITAPTrainViewDO itapConfigDO : itapTrainViewDOs) {
				itapTrainViewDTO = new ITAPTrainViewDTO();
				itapTrainViewDTO = convertFromITAPTrainViewDOToITAPTrainViewDTO(
						itapConfigDO, itapTrainViewDTO);
				itapTrainViewDTOs.add(itapTrainViewDTO);
			}

		}
		return itapTrainViewDTOs;

	}

	@Override
	public ITAPSearchBookingDTO getFinalCalView(ITAPEnvDtlDO remsEnvDtlDO,
			List<ITAPBookDtlDO> remsBookDtlDOs, List<String> dates,
			ITAPSearchBookingDTO remsSearchBookingDTO) throws ServiceException {
		if (null != remsEnvDtlDO) {
			ITAPBookEnvDTO remsBookEnvDTO = new ITAPBookEnvDTO();

			/** Set apps and envs */
			remsBookEnvDTO.setAppName(remsEnvDtlDO.getAppId());
			remsBookEnvDTO.setEnvName(remsEnvDtlDO.getEnvId());

			/** Set Dates */
			List<String> avilableDates = new ArrayList<String>();
			ITAPBookDtlDO remsBookDtlDO = null;
			List<String> strtEndDates = null;

			for (String date : dates) {

				if (null != remsBookDtlDOs && 0 < remsBookDtlDOs.size()) {
					for (int j = 0; j < remsBookDtlDOs.size(); j++) {
						remsBookDtlDO = remsBookDtlDOs.get(j);
						/**
						 * Get Between dates with start and end dates from
						 * remsBookDtlDO
						 */
						if (remsEnvDtlDO.getAppId().equalsIgnoreCase(remsBookDtlDO.getAppId())
								&& remsEnvDtlDO.getEnvId().equalsIgnoreCase(
										remsBookDtlDO.getEnvId())) {
							strtEndDates = CalendarDateUtils
									.getDatesBetween(DateUtils
											.converDateToStringNotUI(remsBookDtlDO
													.getBookStrtDtTst()), DateUtils
											.converDateToStringNotUI(remsBookDtlDO.getBookEndDt()));

							remsBookEnvDTO.setProjIdUrNo(remsBookDtlDO.getProjIdUrNo());
							remsBookEnvDTO.setBookReqtBy(remsBookDtlDO.getBookReqtBy());
							remsBookEnvDTO.setBookId(remsBookDtlDO.getBookId());
							/**
							 * Check whether this date is blocked or not
							 */

							for (String strtEndDate : strtEndDates) {

								if (date.equalsIgnoreCase(strtEndDate)) {
									if ("Dedicated".equalsIgnoreCase(remsBookDtlDO.getBookType())) {
										date += "_D";
										remsBookEnvDTO.setBookId(remsBookDtlDO.getBookId());
									} else if ("Shared".equalsIgnoreCase(remsBookDtlDO
											.getBookType())) {
										date += "_S";
										remsBookEnvDTO.setBookId(remsBookDtlDO.getBookId());
									}
								}

							}

						}
					}
				} else {

				}
				avilableDates.add(date);
			}
			remsBookEnvDTO.setAvilableDates(avilableDates);
			List<ITAPBookEnvDTO> remsBookEnvDTOs = new ArrayList<ITAPBookEnvDTO>();
			remsBookEnvDTOs.add(remsBookEnvDTO);
			remsSearchBookingDTO.setPassedDates(dates);
			remsSearchBookingDTO.setListITAPBookEnvDTO(remsBookEnvDTOs);
		}
		return remsSearchBookingDTO;
	}

}

/**
 * Total String Fields in DO = 18
 *
 * Total BigDecimal Fields in DO = 0
 *
 * Total Date Fields in DO = 0
 *
 * Total Byte Fields in DO = 0
 *
 * Total Long Fields in DO = 1
 *
 * Total List Fields in DO = 0
 *
 * Above Fields does not include count for ActionBy and ActionDate Fields and
 * Serial Version Id
 **/

