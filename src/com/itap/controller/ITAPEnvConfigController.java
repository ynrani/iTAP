/*---------------------------------------------------------------------------------------
 * Object Name: ITAPEnvConfigController.Java
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

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itap.constant.ITAPConstants;
import com.itap.exception.BaseException;
import com.itap.model.DTO.ITAPEnvConfigDTO;
import com.itap.model.DTO.JenkinsConfigDTO;
import com.itap.service.ITAPEnvConfigService;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class ITAPEnvConfigController {

	private static final Logger LOGGER = Logger.getLogger(ITAPEnvConfigController.class);

	@Resource(name = "itapEnvConfigService")
	ITAPEnvConfigService itapEnvConfigService;

	/* Application Pages */

	@RequestMapping(value = "/envConfig", method = RequestMethod.GET)
	public String configurationSysGet(
			@ModelAttribute("itapEnvConfigDTO") ITAPEnvConfigDTO itapEnvConfigDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "envConfig";
		try {
			itapEnvConfigDTO = itapEnvConfigService.selectEnvConfigToEdit(id, itapEnvConfigDTO);
			modelmap.addAttribute("itapConfigDTO", itapEnvConfigDTO);
			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapEnvConfigDTO", itapEnvConfigDTO);
			return strReturnPage;
		}
	}

	@RequestMapping(value = "/envConfig", method = RequestMethod.POST)
	public String configurationSysPost(
			@ModelAttribute("itapEnvConfigDTO") ITAPEnvConfigDTO itapEnvConfigDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "envConfig";
		try {

			itapEnvConfigDTO.setActionBy(String.valueOf(request.getSession().getAttribute(
					ITAPConstants.SESSION_UID)));
			itapEnvConfigService.saveEnvConfigDetails(itapEnvConfigDTO);

			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return strReturnPage;
		}
	}

	@RequestMapping(value = "/jenkinsConfig", method = RequestMethod.GET)
	public String jenkinsConfigGet(
			@ModelAttribute("jenkinsConfigDTO") JenkinsConfigDTO jenkinsConfigDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "jenkinsConfig";
		try {

			jenkinsConfigDTO = itapEnvConfigService.selectJenkinConfigToEdit(id, jenkinsConfigDTO);
			modelmap.addAttribute("jenkinsConfigDTO", jenkinsConfigDTO);

			return strReturnPage;
		} catch (BaseException baseEx) {
			baseEx.printStackTrace();
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("jenkinsConfigDTO", jenkinsConfigDTO);

			return strReturnPage;
		}
	}

	/*
	 * @RequestMapping(value = "/jenkinsConfig", method = RequestMethod.POST)
	 * public String jenkinsConfigPost(
	 * 
	 * @ModelAttribute("jenkinsConfigDTO") JenkinsConfigDTO jenkinsConfigDTO,
	 * ModelMap modelmap, HttpServletRequest request, HttpServletResponse
	 * response) { String strReturnPage = "jenkinsConfig"; try {
	 * 
	 * jenkinsConfigDTO.setActionBy(String.valueOf(request.getSession().getAttribute
	 * ( ITAPConstants.SESSION_UID)));
	 * 
	 * 
	 * jenkinsConfigDTO.setTeamCityActionBy(String.valueOf(request.
	 * getSession().getAttribute( ITAPConstants.SESSION_UID)));
	 * 
	 * 
	 * itapEnvConfigService.saveJenkinConfigDetails(jenkinsConfigDTO);
	 * 
	 * return strReturnPage; } catch (BaseException baseEx) { if (null !=
	 * baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
	 * { if (baseEx.getErrorCode().startsWith("")) { return strReturnPage; } }
	 * modelmap.addAttribute(ITAPConstants.ERROR,
	 * ITAPConstants.EXCEPTION_ADMIN); return strReturnPage; } }
	 */

	@RequestMapping(value = "/jenkinsConfig", method = RequestMethod.POST)
	public String jenkinsConfigTestPost(
			@ModelAttribute("jenkinsConfigDTO") JenkinsConfigDTO jenkinsConfigDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "redirect:jenkinsConfig";

		String actionBy = String.valueOf(request.getSession().getAttribute(
				ITAPConstants.SESSION_UID));

		String ciTypes[] = request.getParameterValues("ciType");
		String ciViewNameList[] = request.getParameterValues("ciViewNameList");
		String ciCityUrl[] = request.getParameterValues("ciCityUrl");
		String ciUserNameList[] = request.getParameterValues("ciUserNameList");
		String ciPassList[] = request.getParameterValues("ciPassList");

		List<JenkinsConfigDTO> jenkinsList = jenkinsConfigDTO.getJenkinsDTOList();
		/*
		 * System.out.println("out side jenkinsList :" + jenkinsList.size());
		 */
		try {

			if (ciCityUrl != null) {

				for (int i = 0; i < ciCityUrl.length; i++) {

					JenkinsConfigDTO tempJenkinsConfigDTO = new JenkinsConfigDTO();
					tempJenkinsConfigDTO.setActionBy(actionBy);
					tempJenkinsConfigDTO.setJenkinsName(ciViewNameList[i]);
					tempJenkinsConfigDTO.setUrl(ciCityUrl[i]);
					tempJenkinsConfigDTO.setUserName(ciUserNameList[i]);
					tempJenkinsConfigDTO.setPass(ciPassList[i]);
					tempJenkinsConfigDTO.setCiName(ciTypes[i]);
					jenkinsList.add(tempJenkinsConfigDTO);
					/*
					 * try { itapEnvConfigService.saveJenkinConfigDetails(
					 * tempJenkinsConfigDTO ); } catch (BaseException baseEx) {
					 * baseEx.printStackTrace(); if (null !=
					 * baseEx.getErrorCode() ||
					 * baseEx.getErrorCode().equalsIgnoreCase("null")) { if
					 * (baseEx.getErrorCode().startsWith("")) { return
					 * strReturnPage; } }
					 * modelmap.addAttribute(ITAPConstants.ERROR,
					 * ITAPConstants.EXCEPTION_ADMIN); return strReturnPage; }
					 * 
					 * System.out.println("saved : " + i);
					 */
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			itapEnvConfigService.saveJenkinConfigDetails(jenkinsConfigDTO);
		} catch (BaseException baseEx) {
			baseEx.printStackTrace();
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return strReturnPage;
		}

		return strReturnPage;

	}

	@RequestMapping(value = "/deleteCIEngine", method = RequestMethod.GET)
	public String jenkinsConfigDelete(ModelMap modelmap, HttpServletRequest request,
			HttpServletResponse response) {

		String strReturnPage = "redirect:jenkinsConfig";

		try {
			if (request.getParameter("cIId") != null) {
				itapEnvConfigService.deleteCiConfigDetails(request.getParameter("cIId"));
			}
		} catch (BaseException baseEx) {
			baseEx.printStackTrace();
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return strReturnPage;
		}

		return strReturnPage;

	}

}
