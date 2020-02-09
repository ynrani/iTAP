/*---------------------------------------------------------------------------------------
 * Object Name: ITAPSysConfigController.Java
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
import com.itap.model.DTO.ITAPConfAllFilesDTO;
import com.itap.model.DTO.ITAPSysConfigDTO;
import com.itap.service.ITAPSysConfigService;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class ITAPSysConfigController {

	private static final Logger LOGGER = Logger.getLogger(ITAPSysConfigController.class);

	@Resource(name = "itapSysConfigService")
	ITAPSysConfigService itapSysConfigService;

	/* Application Pages */

	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String configurationSysGet(
			@ModelAttribute("itapSysConfigDTO") ITAPSysConfigDTO itapSysConfigDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "config";
		try {
			itapSysConfigDTO = itapSysConfigService.selectSysConfigToEdit(id,
					itapSysConfigDTO);
			modelmap.addAttribute("itapConfigDTO", itapSysConfigDTO);
			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapSysConfigDTO", itapSysConfigDTO);
			return strReturnPage;
		}
	}

	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public String configurationSysPost(
			@ModelAttribute("itapSysConfigDTO") ITAPSysConfigDTO itapSysConfigDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "config";
		try {

			itapSysConfigDTO.setActionBy(String.valueOf(request.getSession().getAttribute(
					ITAPConstants.SESSION_UID)));
			itapSysConfigService.saveSysConfigDetails(itapSysConfigDTO);

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

	@RequestMapping(value = "/itapMgmtSuit", method = RequestMethod.GET)
	public String itapMgmtSuitGet(
			@ModelAttribute("itapSysConfigDTO") ITAPSysConfigDTO itapSysConfigDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap) {
		String strReturnPage = "itapMgmtSuit";
		modelmap.addAttribute("itapConfigDTO", itapSysConfigDTO);
		return strReturnPage;
	}

	@RequestMapping(value = "/configAllFiles", method = RequestMethod.GET)
	public String configAllFilesGet(
			@ModelAttribute("itapConfAllFilesDTO") ITAPConfAllFilesDTO itapConfAllFilesDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "configAllFiles";
		try {
			itapConfAllFilesDTO.setActionBy(String.valueOf(request.getSession().getAttribute(
					ITAPConstants.SESSION_UID)));

			itapConfAllFilesDTO = itapSysConfigService.configAllFilesGet(id,
					itapConfAllFilesDTO);
			modelmap.addAttribute("itapConfAllFilesDTO", itapConfAllFilesDTO);
			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapConfAllFilesDTO", itapConfAllFilesDTO);
			return strReturnPage;
		}
	}

	@RequestMapping(value = "/configAllFiles", method = RequestMethod.POST)
	public String configAllFilesPost(
			@ModelAttribute("itapConfAllFilesDTO") ITAPConfAllFilesDTO itapConfAllFilesDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "configAllFiles";
		try {
			String sts = itapSysConfigService.configAllFilesPost(id, itapConfAllFilesDTO);
			modelmap.addAttribute("itapConfAllFilesDTO", itapConfAllFilesDTO);
			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapConfAllFilesDTO", itapConfAllFilesDTO);
			return strReturnPage;
		}
	}
}
