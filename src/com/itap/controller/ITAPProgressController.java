/*---------------------------------------------------------------------------------------
 * Object Name: ITAPProgressController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          10/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.itap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itap.constant.ITAPConstants;
import com.itap.exception.BaseException;
import com.itap.model.DTO.ITAPProgressDTO;
import com.itap.service.ITAPConfigService;
import com.itap.service.ITAPJenkinsConfigService;
import com.itap.service.JenkinCallerService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class ITAPProgressController {

	private static final Logger LOGGER = Logger
			.getLogger(ITAPProgressController.class);

	@Resource(name = "itapConfigService")
	ITAPConfigService itapConfigService;

	@Autowired
	ITAPJenkinsConfigService itapJenkinsConfigService;
	@Autowired
	JenkinCallerService jenkinCallerService;

	
	@RequestMapping(value = "/itapProgress", method = RequestMethod.GET)
	public String configurationSysGet(
			@ModelAttribute("itapProgressDTO") ITAPProgressDTO itapProgressDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id,
			@RequestParam(value = "serId", required = false) String serId,
			ModelMap modelmap, HttpServletRequest request,
			HttpServletResponse response) {
		String strReturnPage = "itapProgress";
		String jenkinsUrl = null;
		try {
			// get all projects
			List<String> allProjs = itapConfigService.allProjs();
			if (StringUtils.isNotEmpty(serId)) {
				jenkinsUrl = itapJenkinsConfigService.getJenkinsUrl(Long
						.parseLong(serId));

			} else {
				jenkinsUrl = itapJenkinsConfigService.getJenkinsUrl(1l);
			}

			itapProgressDTO.setAllProjs(allProjs);
			modelmap.addAttribute("itapProgressDTO", itapProgressDTO);
			modelmap.addAttribute("jenkinsUrl", jenkinsUrl);

			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode()
					|| baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR,
					ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapProgressDTO", itapProgressDTO);
			modelmap.addAttribute("jenkinsUrl", jenkinsUrl);
			return strReturnPage;
		}

	}

	@RequestMapping(value = "/itapGetLast5Builds", method = RequestMethod.GET)
	public @ResponseBody List<ITAPProgressDTO> itapGetLast5Builds(
			@ModelAttribute("itapProgressDTO") ITAPProgressDTO itapProgressDTO,
			@RequestParam(value = "job", required = false) String job,
			@RequestParam(value = "serId", required = false) String serId,
			ModelMap modelmap, HttpServletRequest request,
			HttpServletResponse response) {
		List<ITAPProgressDTO> allJobs = null;
		try {

			if (StringUtils.isNotEmpty(serId)) {
				itapProgressDTO.setServerId(Long.parseLong(serId));
			} else {
				itapProgressDTO.setServerId(1l);
			}
			// get all projects
			allJobs = itapConfigService.itapGetLast5Builds(job,
					itapProgressDTO.getServerId());

			if (null == allJobs) {
				allJobs = new ArrayList<ITAPProgressDTO>();
			}
			modelmap.addAttribute("allJobs", allJobs);
			return allJobs;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode()
					|| baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return allJobs;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR,
					ITAPConstants.EXCEPTION_ADMIN);
			return allJobs;
		}

	}
	@RequestMapping(value = "/junitReport", method = RequestMethod.GET)
	public void jobJunitReportGet(
			@RequestParam(value = "jenkinUrl", required = true) String jenkinUrl,
			HttpServletRequest request, HttpServletResponse response) {
		String server37Url = jenkinUrl + "/testReport/api/xml?depth=1";
	//	server37Url = "http://in-pnq-coe37:8080/jenkins/job/AntJunitTest/2/testReport/api/xml?depth=1";
		String testResultResponseXML = jenkinCallerService
				.getJenkinsTestResult(server37Url);
		JSONObject xmlJSONObj = null;
		try {
			xmlJSONObj = XML.toJSONObject(testResultResponseXML);
		} catch (JSONException je) {
			System.out.println(je.toString());
		}
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(xmlJSONObj!=null)
		{
		pw.print(xmlJSONObj.toString());

		}
		else{
			pw.print("no job found");

		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.setStatus(200);

	}


}
