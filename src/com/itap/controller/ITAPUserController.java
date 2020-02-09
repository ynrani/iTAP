/*---------------------------------------------------------------------------------------
 * Object Name: ITAPUserController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          26/02/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.itap.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.itap.constant.ITAPConstants;
import com.itap.exception.BaseException;
import com.itap.model.DTO.ITAPUserDtlDTO;
import com.itap.service.ITAPUserService;

import com.itap.util.PaginationUtil;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

/*ITAPUserServiceImpl*/
@Controller
public class ITAPUserController {

	private static final Logger LOGGER = Logger.getLogger(ITAPUserController.class);

	@Resource(name = "itapUserService")
	ITAPUserService itapUserService;

	
	
	
	/*@Resource(name = "itapUtilService")
	ITAPUtilService itapUtilService;*/

	List<String> allApps = new ArrayList<String>();

	/* User Pages */

	@RequestMapping(value = "/itapCreateUser", method = RequestMethod.GET)
	public String itapCreateUser(@ModelAttribute("itapUserDtlDTO") ITAPUserDtlDTO itapUserDtlDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			if (null != id) {
				itapUserDtlDTO = itapUserService.selectUserToEdit(id, itapUserDtlDTO);
			}
			modelmap.addAttribute("itapUserDtlDTO", itapUserDtlDTO);
			return "itapCreateUser";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "itapCreateUser";
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapUserDtlDTO", itapUserDtlDTO);
			return "itapCreateUser";
		}
	}

	@RequestMapping(value = "/itapCreateUser", method = RequestMethod.POST)
	public String itapCreateUserPost(
			@ModelAttribute("itapUserDtlDTO") ITAPUserDtlDTO itapUserDtlDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "redirect:itapViewUsers";
		try {
			itapUserDtlDTO.setActionBy(String.valueOf(request.getSession().getAttribute(
					ITAPConstants.SESSION_UID)));
			itapUserService.saveUserDetails(itapUserDtlDTO);
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

	@RequestMapping("/itapViewUsers")
	public String itapViewUser(@ModelAttribute("itapUserDtlDTO") ITAPUserDtlDTO itapUserDtlDTO,
			@RequestParam(value = ITAPConstants.PAGE, required = false) String page,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		Long totalRecords = 0L;
		PaginationUtil pagenation = new PaginationUtil();
		int recordsperpage = 100;
		List<ITAPUserDtlDTO> itapUserDtlDTOs = null;
		try {

			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = itapUserService.itapViewUserCnt((String) request.getSession()
					.getAttribute(ITAPConstants.SESSION_UID), itapUserDtlDTO);
			if (0 < totalRecords) {
				itapUserDtlDTOs = itapUserService.itapViewUser(offSet, recordsperpage, true,
						(String) request.getSession().getAttribute(ITAPConstants.SESSION_UID),
						itapUserDtlDTO);
			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(ITAPConstants.NO_OF_PAGES, noOfPages);
			modelmap.addAttribute("itapUserDtlDTOs", itapUserDtlDTOs);
			return "itapViewUsers";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "itapViewUsers";
				}
			}
			return "itapViewUsers";
		}

	}

	@RequestMapping(value = "/itapDeleteUser")
	public String daleteUser(@RequestParam(value = ITAPConstants.ID, required = false) String id,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		try {
			itapUserService.daleteUser(id);
			return "redirect:itapViewUsers";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:itapViewUsers";
				}
			}
			model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return "redirect:itapViewUsers";
		}
	}

	/*@RequestMapping(value = "/itapAllocApp", method = RequestMethod.GET)
	public String itapAllocAppUser(
			@ModelAttribute("itapUserAppAccessDTO") ITAPUserAppAccessDTO itapUserAppAccessDTO,
			@RequestParam(value = SmartFoundryConstants.ID, required = false) String id,
			@RequestParam(value = "uid", required = false) String uid, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try {

			itapUserAppAccessDTO.setUsers(itapUtilService.getAllUsers());
			allApps = itapUtilService.getAppsFromJson();
			itapUserAppAccessDTO.setApps(allApps);

			if (null != id) {
				itapUserAppAccessDTO = itapUserService.selectUserAccessToEdit(id,
						itapUserAppAccessDTO);
			}
			if (null != uid) {
				itapUserAppAccessDTO.setUid(uid);

			}
			if (null == itapUserAppAccessDTO.getUserId()) {
				itapUserAppAccessDTO.setUserId(uid);
			}

			modelmap.addAttribute("itapUserAppAccessDTO", itapUserAppAccessDTO);
			return "itapAllocApp";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "itapAllocApp";
				}
			}
			modelmap.addAttribute(SmartFoundryConstants.ERROR, SmartFoundryConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapUserAppAccessDTO", itapUserAppAccessDTO);
			return "itapAllocApp";
		}

	}

	@RequestMapping(value = "/itapAllocApp", method = RequestMethod.POST)
	public String itapAllocAppUserPost(
			@ModelAttribute("itapUserAppAccessDTO") ITAPUserAppAccessDTO itapUserAppAccessDTO,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {

		String strReturnPage = "redirect:itapViewAllocApp?id=" + itapUserAppAccessDTO.getUserId();
		try {
			itapUserAppAccessDTO.setActionBy(String.valueOf(request.getSession().getAttribute(
					SmartFoundryConstants.SESSION_UID)));
			itapUserService.saveUserAccessDetails(itapUserAppAccessDTO);
			return strReturnPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnPage;
				}
			}
			modelmap.addAttribute(SmartFoundryConstants.ERROR, SmartFoundryConstants.EXCEPTION_ADMIN);
			return strReturnPage;
		}

	}

	@RequestMapping(value = "/itapViewAllocApp", method = RequestMethod.GET)
	public String itapViewAllocApp(
			@ModelAttribute("itapUserAppAccessDTO") ITAPUserAppAccessDTO itapUserAppAccessDTO,
			@RequestParam(value = SmartFoundryConstants.ID, required = false) String userId,
			@RequestParam(value = SmartFoundryConstants.PAGE, required = false) String page,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {

		Long totalRecords = 0L;
		PaginationUtil pagenation = new PaginationUtil();
		int recordsperpage = 100;
		List<ITAPUserAppAccessDTO> itapUserAppAccessDTOs = null;

		try {

			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = itapUserService.itapViewAllocAppCnt(userId, itapUserAppAccessDTO);
			if (0 < totalRecords) {
				itapUserAppAccessDTOs = itapUserService.itapViewAllocApp(offSet, recordsperpage,
						true, userId, itapUserAppAccessDTO);

			}
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(SmartFoundryConstants.NO_OF_PAGES, noOfPages);
			modelmap.addAttribute("itapUserAppAccessDTOs", itapUserAppAccessDTOs);
			modelmap.addAttribute("userId", userId);
			return "itapViewAllocApp";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "itapViewAllocApp";
				}
			}
			return "itapViewAllocApp";
		}

	}

	@RequestMapping(value = "/itapDeleteAllocApp")
	public String daleteAllocApp(
			@RequestParam(value = SmartFoundryConstants.ID, required = false) String id,
			@RequestParam(value = "uid", required = false) String userId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		try {
			itapUserService.daleteAllocApp(id);
			return "redirect:itapViewAllocApp?id=" + userId;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:itapViewAllocApp?id=" + userId;
				}
			}
			model.addAttribute(SmartFoundryConstants.ERROR, SmartFoundryConstants.EXCEPTION_ADMIN);
			return "redirect:itapViewAllocApp?id=" + userId;
		}
	}

	@RequestMapping(value = "/itapCheckAllApp", method = RequestMethod.GET)
	public @ResponseBody String itapCheckAllApp(
			@RequestParam(value = "appId", required = false) String appId,
			@RequestParam(value = "userId", required = false) String userId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		String msg = null;
		try {
			msg = itapUserService.itapCheckAllApp(appId, userId);
			return msg;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return msg;
				}
			}
			model.addAttribute(SmartFoundryConstants.ERROR, SmartFoundryConstants.EXCEPTION_ADMIN);
			return msg;
		}
	}

	@RequestMapping(value = "/itapCheckUserAvail", method = RequestMethod.GET)
	public @ResponseBody String itapCheckUserAvail(
			@RequestParam(value = "name", required = false) String userId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		String msg = null;
		if (allApps.contains("userId")) {
			msg = "Y";
		}
		// msg = itapUserService.itapCheckUserAvail(userId);
		return msg;
	}*/
}
