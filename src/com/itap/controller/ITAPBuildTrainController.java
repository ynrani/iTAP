/*---------------------------------------------------------------------------------------
 * Object Name: ITAPBuildTrainController.Java
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

package com.itap.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itap.alm.service.ITAPTdmService;
import com.itap.constant.ITAPConstants;
import com.itap.exception.BaseException;
import com.itap.model.DTO.ITAPBuildTrainDTO;
import com.itap.service.ITAPBuildTrainService;
import com.itap.service.ITAPConfigService;
import com.itap.service.impl.JobTrackarServiceImpl;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class ITAPBuildTrainController {

	private static final Logger LOGGER = Logger.getLogger(ITAPBuildTrainController.class);

	@Resource(name = "itapBuildTrainService")
	ITAPBuildTrainService itapBuildTrainService;

	@Resource(name = "itapConfigService")
	ITAPConfigService itapConfigService;

	@Resource(name = "itapTdmService")
	ITAPTdmService itapTdmService;

	@Resource(name = "jobTrackar")
	JobTrackarServiceImpl jobTracker;

	/* Train Pages */

	@RequestMapping(value = "/itapBuildTrain", method = RequestMethod.GET)
	public String configuration(
			@ModelAttribute("itapBuildTrainDTO") ITAPBuildTrainDTO itapBuildTrainDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "itapBuildTrain";

		try {
			// get all projects
			List<String> allProjs = itapConfigService.allProjs();
			itapBuildTrainDTO.setSaveStatus((String) request.getSession().getAttribute(
					"saveStautus"));
			request.getSession().removeAttribute("saveStautus");
			itapBuildTrainDTO.setAllProjs(allProjs);

			List<String> hourList = new ArrayList<String>();
			for (int count = 0; count <= 23; count++) {
				if (count < 10)
					hourList.add("0" + String.valueOf(count));
				else {
					hourList.add("0" + String.valueOf(count));
				}
			}

			List<String> minList = new ArrayList<String>();
			for (int count = 0; count <= 60; count++) {
				if (count < 10)
					minList.add("0" + String.valueOf(count));
				else {
					minList.add("0" + String.valueOf(count));
				}
			}

			itapBuildTrainDTO.setHourList(hourList);
			itapBuildTrainDTO.setMinList(minList);

			modelmap.addAttribute("itapBuildTrainDTO", itapBuildTrainDTO);
			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapBuildTrainDTO", itapBuildTrainDTO);
			return strReturnPage;
		}
	}

	@RequestMapping(value = "/itapBuildTrain", method = RequestMethod.POST)
	public String configurationPost(@RequestParam(value = "exec", required = false) String exec,
			@ModelAttribute("itapBuildTrainDTO") ITAPBuildTrainDTO itapBuildTrainDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		String check = request.getParameter("trackJobs");
		String runningStatus = request.getParameter("runStatus");
		String serverId = request.getParameter("serverId");
		String strReturnJobsPage = "redirect:itapProgress?serId=" + serverId;

		itapBuildTrainDTO.setServerId(Long.parseLong(serverId));

		try {
			List<String> strJobs = new ArrayList<String>();
			itapBuildTrainDTO.setActionBy(String.valueOf(request.getSession().getAttribute(
					ITAPConstants.SESSION_UID)));
			if (null != exec) {
				// Tdm Integration started

				if (StringUtils.isNotEmpty(itapBuildTrainDTO.getJobsSel())) {
					if (itapBuildTrainDTO.getJobsSel().contains(",")) {
						String[] jobsSelected = itapBuildTrainDTO.getJobsSel().split(",");
						for (int i = 0; i < jobsSelected.length; i++) {
							strJobs.add(jobsSelected[i].contains("_") ? jobsSelected[i].substring(
									0, jobsSelected[i].indexOf("_")) : jobsSelected[i]);
						}
					}
					strJobs.add(itapBuildTrainDTO.getJobsSel().contains("_") ? itapBuildTrainDTO
							.getJobsSel().substring(0, itapBuildTrainDTO.getJobsSel().indexOf("_"))
							: itapBuildTrainDTO.getJobsSel());

				}

				Set<String> listTestCases = new HashSet<String>(
						itapConfigService.getTestCaseListByJobsNames(strJobs));

				Set<String> lstTestcase = new HashSet<String>();

				for (String strValues : listTestCases) {

					if (strValues.contains(",")) {
						String[] splitVals = strValues.split(",");
						for (int i = 0; i < splitVals.length; i++) {
							if (StringUtils.isNotEmpty(splitVals[i].trim()))
								lstTestcase.add(splitVals[i].trim());
						}
					} else {
						lstTestcase.add(strValues);
					}
				}
				List<String> lstPassed = new ArrayList<String>(lstTestcase);
				itapTdmService.doCheckTestData(lstPassed);
				// End
				itapBuildTrainService.buildTrain(itapBuildTrainDTO);
			}
			if (check != null && check.equalsIgnoreCase("trackJobs")) {
				jobTracker.track(itapBuildTrainDTO, runningStatus);
			}
			modelmap.addAttribute("itapBuildTrainDTO", itapBuildTrainDTO);
			return strReturnJobsPage;
		} catch (BaseException baseEx) {

			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "itapBuildTrain";
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapBuildTrainDTO", itapBuildTrainDTO);
			return "itapBuildTrain";
		}
	}
}
