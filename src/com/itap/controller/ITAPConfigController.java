/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigController.Java
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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.itap.alm.service.ITAPTdmService;
import com.itap.constant.ITAPConstants;
import com.itap.exception.BaseException;
import com.itap.model.DO.ITAPCrossBrowserGridDO;
import com.itap.model.DO.ITAPCrossBrowserOS;
import com.itap.model.DO.ITAPToolTestCaseDO;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.model.DTO.ITAPConfigBrowCombo;
import com.itap.model.DTO.ITAPConfigDTO;
import com.itap.model.DTO.ITAPConfigMultipleTrainsDTO;
import com.itap.model.DTO.ITAPCrossBrowserTestsuite;
import com.itap.model.DTO.ITAPSearchBookingDTO;
import com.itap.model.DTO.ITAPTrainViewDTO;
import com.itap.service.ITAPConfigService;
import com.itap.service.ITAPEnvConfigService;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class ITAPConfigController {

	// private static final Logger LOGGER =
	// Logger.getLogger(ITAPConfigController.class);

	@Resource(name = "itapConfigService")
	ITAPConfigService itapConfigService;

	@Resource(name = "itapTdmService")
	ITAPTdmService itapTdmService;

	@Autowired
	ITAPEnvConfigService itapEnvConfigService;

	@Autowired
	private MessageSource messageSource;

	/* Application Pages */

	@RequestMapping(value = "/checkStatus", method = RequestMethod.GET)
	public void checkStatus(HttpServletRequest request, HttpServletResponse response) {

		String saveStatus = (String) request.getSession().getAttribute("saveStautus");

		request.getSession().removeAttribute("saveStautus");

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.println(String.valueOf(saveStatus).trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/configuration", method = RequestMethod.GET)
	public String configuration(@ModelAttribute("itapConfigDTO") ITAPConfigDTO itapConfigDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id,
			@RequestParam(value = "serverId", required = false) String serverId, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {

		try {
			if (null != id) {
				itapConfigDTO.setServerId(Long.parseLong(serverId));
				itapConfigDTO = itapConfigService.selectConfigToEdit(id, itapConfigDTO);
			}

			List<String> allProjs = itapConfigService.allProjs();
			List<JenkinsConfigDO> ciEngineList = itapEnvConfigService.getAllCiEngines();
			itapConfigDTO.setCiEnginsList(ciEngineList);

			itapConfigDTO.setAllProjs(allProjs);
			List<String> allEnvs = itapConfigService.allEnvs();
			itapConfigDTO.setAllEnvs(allEnvs);

			List<ITAPCrossBrowserTestsuite> testSuiteList = itapConfigService
					.getTestSuiteList(messageSource.getMessage(
							ITAPConstants.CROSS_BROWSER_TESTSUITE_FOLDER_PATH, null, null));
			itapConfigDTO.setTestSuiteList(testSuiteList);
			List<ITAPCrossBrowserGridDO> itapCrossBrowserList = itapConfigService.getGidList();
			itapConfigDTO.setGridList(itapCrossBrowserList);
			List<ITAPCrossBrowserOS> itapCrossBrowserOSDOList = itapConfigService.getOSList();

			itapConfigDTO.setOsList(itapCrossBrowserOSDOList);
			itapConfigDTO.setToolSpecificTestCase(new ArrayList<ITAPToolTestCaseDO>());

			List<ITAPToolTestCaseDO> bddTestCasesList = itapConfigService
					.toolBasedTestCasesList("BDD");
			List<ITAPToolTestCaseDO> apiTestingTestCasesList = itapConfigService
					.toolBasedTestCasesList("APITESTING");
			List<String> optikTestSuiteList = itapConfigService.optikTestSuiteList();

			if (optikTestSuiteList.size() > 0) {
				HashSet<String> optikTestSuiteSet = new HashSet<String>(optikTestSuiteList);
				itapConfigDTO.setOptikTestSuiteList(new ArrayList<String>(optikTestSuiteSet));
			} else {
				itapConfigDTO.setOptikTestSuiteList(optikTestSuiteList);
			}

			itapConfigDTO.setBddTestCasesList(bddTestCasesList);
			itapConfigDTO.setApiTestingTestCasesList(apiTestingTestCasesList);

			modelmap.addAttribute("itapConfigDTO", itapConfigDTO);

			return "configuration";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "configuration";
				}
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			modelmap.addAttribute("itapConfigDTO", itapConfigDTO);
			return "configuration";
		}
	}

	private String getSelectedTestCases(ITAPConfigDTO itapConfigDTO) {
		StringBuffer strBuffer = new StringBuffer("");
		if (StringUtils.isNotEmpty(itapConfigDTO.getBddSct())) {
			// result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(entityManager,
			// "BDD", itapConfigDTO.getBddSct()));
			if (itapConfigDTO.getBddSct().contains(",")) {
				String[] strSplits = itapConfigDTO.getBddSct().split(",");
				for (int i = 0; i < strSplits.length; i++) {
					if (strSplits[i].contains("#")) {
						strBuffer.append(strSplits[i].substring(strSplits[i].indexOf("#") + 1,
								strSplits[i].length()));
						if (strSplits.length != i + 1) {
							strBuffer.append(",");
						}
					}
				}
			} else {
				if (itapConfigDTO.getBddSct().contains("#")) {
					strBuffer.append(itapConfigDTO.getBddSct().substring(
							itapConfigDTO.getBddSct().indexOf("#") + 1,
							itapConfigDTO.getBddSct().length()));
				}
			}
		}
		if (StringUtils.isNotEmpty(itapConfigDTO.getApiTest())) {
			// strBuffer = new StringBuffer("");
			if (itapConfigDTO.getApiTest().contains(",")) {
				String[] strSplits = itapConfigDTO.getApiTest().split(",");
				if (!strBuffer.toString().trim().isEmpty() && strSplits.length > 0)
					strBuffer.append(",");
				for (int i = 0; i < strSplits.length; i++) {
					if (strSplits[i].contains("#")) {
						strBuffer.append(strSplits[i].substring(strSplits[i].indexOf("#") + 1,
								strSplits[i].length()));
						if (strSplits.length != i + 1) {
							strBuffer.append(",");
						}
					}
				}
			} else {
				if (itapConfigDTO.getApiTest().contains("#")) {
					if (!strBuffer.toString().trim().isEmpty())
						strBuffer.append(",");
					strBuffer.append(itapConfigDTO.getApiTest().substring(
							itapConfigDTO.getApiTest().indexOf("#") + 1,
							itapConfigDTO.getApiTest().length()));
				}
			}
		}
		if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCases())) {
			if (itapConfigDTO.getSelectedTestCases().contains(",")) {
				String[] strSplits = itapConfigDTO.getSelectedTestCases().split(",");
				if (!strBuffer.toString().trim().isEmpty() && strSplits.length > 0)
					strBuffer.append(",");
				for (int i = 0; i < strSplits.length; i++) {
					if (strSplits[i].contains("#")) {
						strBuffer.append(strSplits[i].substring(strSplits[i].indexOf("#") + 1,
								strSplits[i].length()));
						if (strSplits.length != i + 1) {
							strBuffer.append(",");
						}
					}
				}
			} else {
				if (itapConfigDTO.getSelectedTestCases().contains("#")) {
					if (!strBuffer.toString().trim().isEmpty())
						strBuffer.append(",");
					strBuffer.append(itapConfigDTO.getSelectedTestCases().substring(
							itapConfigDTO.getSelectedTestCases().indexOf("#") + 1,
							itapConfigDTO.getSelectedTestCases().length()));
				}
			}
		}
		if (itapConfigDTO.getSelectedTestCasesList() != null
				&& !itapConfigDTO.getSelectedTestCasesList().isEmpty()) {
			// StringBuffer buffer = new StringBuffer();
			if (!strBuffer.toString().trim().isEmpty())
				strBuffer.append(",");
			for (int i = 0; i < itapConfigDTO.getSelectedTestCasesList().size(); i++) {

				if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCasesList().get(i))
						&& !"null"
								.equalsIgnoreCase(itapConfigDTO.getSelectedTestCasesList().get(i))) {
					if (itapConfigDTO.getSelectedTestCasesList().get(i).contains("#")) {
						strBuffer.append(itapConfigDTO
								.getSelectedTestCasesList()
								.get(i)
								.substring(
										itapConfigDTO.getSelectedTestCasesList().get(i)
												.indexOf("#") + 1,
										itapConfigDTO.getSelectedTestCasesList().get(i).length()));
						if (itapConfigDTO.getSelectedTestCasesList().size() != i + 1)
							strBuffer.append(",");
					}
				}
			}
			// strBuffer.append(itapConfigDTO.getSelectedTestCasesList().get(i));

		}

		return strBuffer.toString();
	}

	private ITAPConfigDTO modifiedITAPConfigDTO(ITAPConfigDTO itapConfigDTO) {
		StringBuffer strBuffer = new StringBuffer("");
		if (StringUtils.isNotEmpty(itapConfigDTO.getBddSct())) {
			// result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(entityManager,
			// "BDD", itapConfigDTO.getBddSct()));
			if (itapConfigDTO.getBddSct().contains(",")) {
				String[] strSplits = itapConfigDTO.getBddSct().split(",");
				for (int i = 0; i < strSplits.length; i++) {
					if (strSplits[i].contains("#")) {
						strBuffer.append(strSplits[i].substring(0, strSplits[i].indexOf("#")));
						if (strSplits.length != i + 1) {
							strBuffer.append(",");
						}
					}
				}
			} else {
				if (itapConfigDTO.getBddSct().contains("#")) {
					strBuffer.append(itapConfigDTO.getBddSct().substring(0,
							itapConfigDTO.getBddSct().indexOf("#")));
				}
			}
			itapConfigDTO.setBddSct(strBuffer.toString());
		}
		if (StringUtils.isNotEmpty(itapConfigDTO.getApiTest())) {
			strBuffer = new StringBuffer("");
			if (itapConfigDTO.getApiTest().contains(",")) {
				String[] strSplits = itapConfigDTO.getApiTest().split(",");
				if (!strBuffer.toString().trim().isEmpty() && strSplits.length > 0)
					strBuffer.append(",");
				for (int i = 0; i < strSplits.length; i++) {
					if (strSplits[i].contains("#")) {
						strBuffer.append(strSplits[i].substring(0, strSplits[i].indexOf("#")));
						if (strSplits.length != i + 1) {
							strBuffer.append(",");
						}
					}
				}
			} else {
				if (itapConfigDTO.getApiTest().contains("#")) {
					if (!strBuffer.toString().trim().isEmpty())
						strBuffer.append(",");
					strBuffer.append(itapConfigDTO.getApiTest().substring(0,
							itapConfigDTO.getApiTest().indexOf("#")));
				}
			}
			itapConfigDTO.setApiTest(strBuffer.toString());
		}
		if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCases())) {
			strBuffer = new StringBuffer("");
			if (itapConfigDTO.getSelectedTestCases().contains(",")) {
				String[] strSplits = itapConfigDTO.getSelectedTestCases().split(",");
				if (!strBuffer.toString().trim().isEmpty() && strSplits.length > 0)
					strBuffer.append(",");
				for (int i = 0; i < strSplits.length; i++) {
					if (strSplits[i].contains("#")) {
						strBuffer.append(strSplits[i].substring(0, strSplits[i].indexOf("#")));
						if (strSplits.length != i + 1) {
							strBuffer.append(",");
						}
					}
				}
			} else {
				if (itapConfigDTO.getSelectedTestCases().contains("#")) {
					if (!strBuffer.toString().trim().isEmpty())
						strBuffer.append(",");
					strBuffer.append(itapConfigDTO.getSelectedTestCases().substring(0,
							itapConfigDTO.getSelectedTestCases().indexOf("#")));
				}
			}
			itapConfigDTO.setSelectedTestCases(strBuffer.toString());
		}

		if (itapConfigDTO.getSelectedTestCasesList() != null
				&& !itapConfigDTO.getSelectedTestCasesList().isEmpty()) {
			List<String> lstString = new ArrayList<String>();
			for (int i = 0; i < itapConfigDTO.getSelectedTestCasesList().size(); i++) {
				if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCasesList().get(i))
						&& !"null"
								.equalsIgnoreCase(itapConfigDTO.getSelectedTestCasesList().get(i))) {
					if (itapConfigDTO.getSelectedTestCasesList().get(i).contains("#")) {
						lstString.add(itapConfigDTO
								.getSelectedTestCasesList()
								.get(i)
								.substring(
										0,
										itapConfigDTO.getSelectedTestCasesList().get(i)
												.indexOf("#")));
					}
				}
			}
			itapConfigDTO.setSelectedTestCasesList(lstString);
		}
		return itapConfigDTO;
	}

	@RequestMapping(value = "/configuration", method = RequestMethod.POST)
	public String configurationPost(

	@ModelAttribute("itapConfigDTO") ITAPConfigDTO itapConfigDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnJobsPage = "configuration";

		try {

			String testCasesIds = getSelectedTestCases(itapConfigDTO);
			// itapConfigDTO = modifiedITAPConfigDTO(itapConfigDTO);
			itapConfigDTO.setActionBy(String.valueOf(request.getSession().getAttribute(
					ITAPConstants.SESSION_UID)));

			if (StringUtils.isNotEmpty(itapConfigDTO.getToExecuteFlag())
					&& !"unreserve".equalsIgnoreCase(itapConfigDTO.getToExecuteFlag())) {
				itapConfigDTO = modifiedITAPConfigDTO(itapConfigDTO);
				// Set<String> lstTestCaseId =
				// itapTdmService.doCheckTestData(testCasesIds);
				// end of dumping data
				// List<String> lstTestCaseId =
				// itapTdmService.getSelectedTestCasesId(itapConfigDTO);
				/*
				 * StringBuffer strBuffer = new StringBuffer(""); int iCount =
				 * 1; if (lstTestCaseId != null) for (String testCaseId :
				 * lstTestCaseId) { strBuffer.append(testCaseId); if (iCount !=
				 * lstTestCaseId.size()) strBuffer.append(","); iCount++; }
				 */
				itapTdmService.doCheckTestData(testCasesIds);
				itapConfigDTO.setTestCase(testCasesIds);
				if (itapConfigDTO.getToExecuteFlag() != null) {

					if (itapConfigDTO.getToExecuteFlag().equals("false")) {
						itapConfigDTO = itapConfigService.saveConfigDetails(itapConfigDTO);
						request.getSession().setAttribute("saveStautus", "success");

						List<ITAPConfigBrowCombo> list = new ArrayList<ITAPConfigBrowCombo>();
						if (itapConfigDTO.getCombinedBrowserCombo() != null
								&& itapConfigDTO.getCombinedBrowserCombo().length() > 0) {
							String[] browserCombo = itapConfigDTO.getCombinedBrowserCombo().split(
									";");
							if (browserCombo.length > 0) {
								for (int count = 0; count < browserCombo.length; count++) {
									try {
										ITAPConfigBrowCombo itapConfigBrowCombo = new ITAPConfigBrowCombo();
										String combo = browserCombo[count];
										String os = combo.split(",")[0];
										String browser = combo.split(",")[1];
										String version = combo.split(",")[2];
										itapConfigBrowCombo.setBrowser(browser);
										itapConfigBrowCombo.setOperating(os);
										itapConfigBrowCombo.setVersion(version);
										list.add(itapConfigBrowCombo);
									} catch (Exception e) {
										list = new ArrayList<ITAPConfigBrowCombo>();
									}
								}
							}
						}
						List<String> testCaseList = itapConfigService.getTestCaseListForTestSuite(
								messageSource.getMessage(
										ITAPConstants.CROSS_BROWSER_TESTSUITE_FOLDER_PATH, null,
										null), itapConfigDTO.getTestSuite());
						itapConfigDTO.setSelectMultipleTCList(testCaseList);
						itapConfigDTO.setBrowserComboList(list);

						List<String> allProjs = itapConfigService.allProjs();
						itapConfigDTO.setAllProjs(allProjs);
						List<String> allEnvs = itapConfigService.allEnvs();
						itapConfigDTO.setAllEnvs(allEnvs);

						List<ITAPCrossBrowserTestsuite> testSuiteList = itapConfigService
								.getTestSuiteList(messageSource.getMessage(
										ITAPConstants.CROSS_BROWSER_TESTSUITE_FOLDER_PATH, null,
										null));
						itapConfigDTO.setTestSuiteList(testSuiteList);
						List<ITAPCrossBrowserGridDO> itapCrossBrowserList = itapConfigService
								.getGidList();
						itapConfigDTO.setGridList(itapCrossBrowserList);
						List<ITAPCrossBrowserOS> itapCrossBrowserOSDOList = itapConfigService
								.getOSList();
						itapConfigDTO.setOsList(itapCrossBrowserOSDOList);
						List<ITAPToolTestCaseDO> testCaseDO = itapConfigService.getTestCaseList(
								itapConfigDTO.getToolName(), itapConfigDTO.getToolColumn(),
								itapConfigDTO.getToolColumnValue());

						if (itapConfigDTO.getTestCase() != null
								&& itapConfigDTO.getTestCase().length() > 0) {
							String[] testCaseArr = itapConfigDTO.getTestCase().split(",");
							if (testCaseArr.length > 0) {
								List<String> testCaseListNew = Arrays.asList(testCaseArr);
								for (ITAPToolTestCaseDO itapToolTestCaseDO : testCaseDO) {
									if (testCaseListNew.contains(itapToolTestCaseDO.getTestCase())) {
										String testName = itapToolTestCaseDO.getTestCase();
										itapToolTestCaseDO.setIsSelected(testName);
									}
								}
							}
						}
						itapConfigDTO.setToolSpecificTestCase(testCaseDO);
						// request.getSession().setAttribute("saveStautus","success");

						strReturnJobsPage = "redirect:configuration";
					} else if (itapConfigDTO.getToExecuteFlag().equals("true")) {
						itapConfigService.saveConfigDetails(itapConfigDTO);
						request.getSession().setAttribute("saveStautus", "success");
						strReturnJobsPage = "redirect:itapBuildTrain";
					}
				} else if (StringUtils.isNotEmpty(itapConfigDTO.getToExecuteFlag())
						&& "unreserve".equalsIgnoreCase(itapConfigDTO.getToExecuteFlag())) {
					itapTdmService.unreserveRecordsFromTDM(testCasesIds);
				}

			}

			return strReturnJobsPage;
		} catch (BaseException baseEx) {
			request.getSession().setAttribute("saveStautus", "fail");
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return strReturnJobsPage;
				}
			}

			try {
				List<ITAPCrossBrowserTestsuite> testSuiteList = itapConfigService
						.getTestSuiteList(messageSource.getMessage(
								ITAPConstants.CROSS_BROWSER_TESTSUITE_FOLDER_PATH, null, null));
				itapConfigDTO.setTestSuiteList(testSuiteList);

				List<ITAPCrossBrowserGridDO> itapCrossBrowserList = itapConfigService.getGidList();
				itapConfigDTO.setGridList(itapCrossBrowserList);

				List<ITAPCrossBrowserOS> itapCrossBrowserOSDOList = itapConfigService.getOSList();
				itapConfigDTO.setOsList(itapCrossBrowserOSDOList);

				List<ITAPToolTestCaseDO> testCaseDO = new ArrayList<ITAPToolTestCaseDO>();
				itapConfigDTO.setToolSpecificTestCase(testCaseDO);

			} catch (BaseException bEx) {

				if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
					if (baseEx.getErrorCode().startsWith("")) {
						return strReturnJobsPage;
					}
				}
				modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
				return strReturnJobsPage;
			}
			modelmap.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return strReturnJobsPage;
		}
	}

	@RequestMapping("/configurationView")
	public String configurationView(@ModelAttribute("itapConfigDTO") ITAPConfigDTO itapConfigDTO,
			@RequestParam(value = ITAPConstants.PAGE, required = false) String page,
			@RequestParam(value = "serId", required = false) String serId, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		List<ITAPConfigDTO> itapConfigDTOs = null;

		try {
			// hard code set the jenkin id
			if (StringUtils.isNotEmpty(serId)) {
				itapConfigDTO.setServerId(Long.parseLong(serId));
			} else {
				itapConfigDTO.setServerId(1l);
			}
			itapConfigDTOs = itapConfigService.configurationView(0, 0, true, (String) request
					.getSession().getAttribute(ITAPConstants.SESSION_UID), itapConfigDTO);

			modelmap.addAttribute("itapConfigDTOs", itapConfigDTOs);
			return "configurationView";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "configurationView";
				}
			}
			return "configurationView";
		}
	}

	@RequestMapping(value = "/deleteMultipleConfiguration")
	public String daleteMultipleApp(/*
									 * @RequestParam(value = "checksDelete",
									 * required = false) String checksDelete
									 */
	@ModelAttribute("itapConfigDTO") ITAPConfigDTO itapConfigDTO, ModelMap model,
			@RequestParam(value = "serId", required = false) String serId,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		/*
		 * String[] posts = request.getParameterValues("checksDelete");
		 */

		itapConfigDTO.setServerId(Long.parseLong(serId));
		List<String> allJobs = itapConfigDTO.getAllJobs();
		/*
		 * System.out.println("__________");
		 * 
		 * for (String str : allJobs) { System.out.println(str); }
		 * System.out.println("__________");
		 */

		if (allJobs != null) {
			for (String str : allJobs) {
				try {
					itapConfigService.deleteConfiguration(str, itapConfigDTO.getServerId());
					// return "redirect:configurationView";
				} catch (BaseException baseEx) {
					if (null != baseEx.getErrorCode()
							|| baseEx.getErrorCode().equalsIgnoreCase("null")) {
						if (baseEx.getErrorCode().startsWith("")) {
							return "redirect:configurationView?serId="
									+ itapConfigDTO.getServerId();
						}
					}
					model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
				}
			}
		}

		return "redirect:configurationView?serId=" + itapConfigDTO.getServerId();

	}

	@RequestMapping(value = "/deleteConfiguration")
	public String daleteApp(@RequestParam(value = ITAPConstants.ID, required = false) String id,
			@RequestParam(value = "serverId", required = false) String serverId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		String redirectPage = "redirect:configurationView?serId=" + serverId;
		JenkinsConfigDO jenkinSerDo = itapConfigService.getCiDetails(Long.parseLong(serverId));

		try {

			if (jenkinSerDo.getCiName() != null
					&& jenkinSerDo.getCiName().equalsIgnoreCase("teamCity")) {

				itapConfigService.deleteConfigurationFromTeamCity(id + "_123",
						Long.parseLong(serverId));
				redirectPage = "redirect:configurationViewTeamCity?serId=" + serverId;
			} else {

				itapConfigService.deleteConfiguration(id, Long.parseLong(serverId));
				redirectPage = "redirect:configurationView?serId=" + serverId;
			}
			return redirectPage;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (jenkinSerDo.getCiName().equalsIgnoreCase("teamCity")
						&& baseEx.getErrorCode().startsWith("")) {
					return "redirect:configurationViewTeamCity?serId=" + serverId;
				} else if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:configurationView?serId=" + serverId;
				}

			}
			model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			if (jenkinSerDo.getCiName().equalsIgnoreCase("teamCity")) {
				return "redirect:configurationViewTeamCity?serId=" + serverId;
			}
			return "redirect:configurationView?serId=" + serverId;
		}
	}

	@RequestMapping(value = "/configurationJobBuild")
	public String buildApp(@RequestParam(value = ITAPConstants.ID, required = false) String id,
			@RequestParam(value = "serId", required = false) String serId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		try {

			// set Hard code jenkins server id here
			//
			long serverId = 1l;
			if (StringUtils.isNotEmpty(serId)) {
				serverId = Long.parseLong(serId);
			}

			itapConfigService.buildJob(id, serverId);
			return "redirect:configurationView?serId=" + serId;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:configurationView?serId=" + serId;
				}
			}
			model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return "redirect:configurationView?serId=" + serId;
		}
	}

	@RequestMapping(value = "/configurationAllJobs", method = RequestMethod.GET)
	public @ResponseBody List<String> getAllJobNames(
			@RequestParam(value = "projName", required = false) String projName, ModelMap model,
			@RequestParam(value = "serId", required = false) String serId,
			HttpServletRequest request, HttpServletResponse response) {
		List<String> list = null;

		// Set default jenkin server id

		long serverId = 1l;
		if (StringUtils.isNotEmpty(serId)) {
			serverId = Long.parseLong(serId);
		}

		try {
			list = itapConfigService.getAllJobNames(projName, serverId);
			return list;
		} catch (BaseException baseEx) {

			if (baseEx.getErrorCode().startsWith("")) {
				return list;
			}
		}
		return list;
	}

	@RequestMapping(value = "/configurationEdit", method = RequestMethod.GET)
	public @ResponseBody ITAPConfigDTO configurationEdit(
			@ModelAttribute("itapConfigDTO") ITAPConfigDTO itapConfigDTO,
			@RequestParam(value = "job", required = false) String job,
			@RequestParam(value = "serId", required = false) String serId, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try {

			itapConfigDTO.setServerId(Long.parseLong(serId));

			itapConfigDTO = itapConfigService.configurationEdit(job, itapConfigDTO.getServerId());
			itapConfigDTO.setNewOrEdit(true);
			modelmap.addAttribute("itapConfigDTO", itapConfigDTO);
			return itapConfigDTO;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return itapConfigDTO;
				}
			}
			return itapConfigDTO;
		}
	}

	@RequestMapping(value = "/getBrowserList", method = RequestMethod.GET)
	public @ResponseBody List<String> getBrowserList(
			@RequestParam(value = "osId", required = false) String osId, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			int osID = Integer.parseInt(osId);
			List<String> browserOptionList = itapConfigService.getBrowserList(osID);
			return browserOptionList;
		} catch (Exception baseEx) {
			return new ArrayList<String>();
		}
	}

	@RequestMapping(value = "/getVersionList", method = RequestMethod.GET)
	public @ResponseBody List<String> getVersionList(
			@RequestParam(value = "osId", required = false) String osId,
			@RequestParam(value = "browser", required = false) String browser, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			int osID = Integer.parseInt(osId);
			List<String> browserOptionList = itapConfigService.getBrowserList(osID, browser);
			return browserOptionList;
		} catch (Exception baseEx) {
			return new ArrayList<String>();
		}
	}

	@RequestMapping(value = "/fetchUrlsForGridType", method = RequestMethod.GET)
	public @ResponseBody List<ITAPCrossBrowserGridDO> fetchUrlsForGridType(
			@RequestParam(value = "gridType", required = false) String gridType, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ITAPCrossBrowserGridDO> gridList = itapConfigService
					.fetchUrlsForGridType(gridType);
			return gridList;
		} catch (Exception baseEx) {
			return new ArrayList<ITAPCrossBrowserGridDO>();
		}
	}

	@RequestMapping(value = "/getToolTestCaseList", method = RequestMethod.GET)
	public @ResponseBody List<ITAPToolTestCaseDO> getToolTestCaseList(
			@RequestParam(value = "toolName", required = false) String toolName,
			@RequestParam(value = "toolColumn", required = false) String toolColumn,
			@RequestParam(value = "toolColumnValue", required = false) String toolColumnValue,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ITAPToolTestCaseDO> testCaseList = itapConfigService.getTestCaseList(toolName,
					toolColumn, toolColumnValue);
			return testCaseList;
		} catch (Exception baseEx) {
			return new ArrayList<ITAPToolTestCaseDO>();
		}
	}

	@RequestMapping(value = "/getToolTestCaseListForOPTIK", method = RequestMethod.GET)
	public @ResponseBody List<ITAPToolTestCaseDO> getToolTestCaseListForOPTIK(
			@RequestParam(value = "testSuite", required = false) String testSuite,
			@RequestParam(value = "toolName", required = false) String toolName,
			@RequestParam(value = "toolColumn", required = false) String toolColumn,
			@RequestParam(value = "toolColumnValue", required = false) String toolColumnValue,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ITAPToolTestCaseDO> testCaseList = itapConfigService.getTestCaseList(toolName,
					toolColumn, toolColumnValue, testSuite);
			return testCaseList;
		} catch (Exception baseEx) {
			return new ArrayList<ITAPToolTestCaseDO>();
		}
	}

	@RequestMapping(value = "/getToolColumnValues", method = RequestMethod.GET)
	public @ResponseBody List<String> getToolColumnValues(
			@RequestParam(value = "toolName", required = false) String toolName,
			@RequestParam(value = "toolColumn", required = false) String toolColumn,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		try {
			List<String> testCaseList = itapConfigService.getToolColumnValues(toolName, toolColumn);
			return testCaseList;
		} catch (Exception baseEx) {
			return new ArrayList<String>();
		}
	}

	@RequestMapping(value = "/getOTCForSeleTS", method = RequestMethod.GET)
	public @ResponseBody List<ITAPToolTestCaseDO> getOTCForSeleTS(
			@RequestParam(value = "selectedTS", required = true) String selectedTS,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (!selectedTS.equals("Select")) {
				List<ITAPToolTestCaseDO> testCaseList = itapConfigService
						.getOTCForSeleTS(selectedTS);
				return testCaseList;
			} else {
				return new ArrayList<ITAPToolTestCaseDO>();
			}
		} catch (Exception baseEx) {
			return new ArrayList<ITAPToolTestCaseDO>();
		}
	}

	@RequestMapping(value = "/getTestColValuesForOPTIKNCol", method = RequestMethod.GET)
	public @ResponseBody List<String> getTestColValuesForOPTIKNCol(
			@RequestParam(value = "testSuite", required = true) String testSuite,
			@RequestParam(value = "toolColumn", required = true) String toolColumn,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (!testSuite.equals("Select")) {
				List<String> testCaseList = itapConfigService
						.getOTCForSeleTS(testSuite, toolColumn);
				testCaseList.remove(null);
				HashSet<String> set = new HashSet<String>(testCaseList);
				testCaseList = new ArrayList<String>(set);
				return testCaseList;
			} else {
				return new ArrayList<String>();
			}
		} catch (Exception baseEx) {
			return new ArrayList<String>();
		}
	}

	@RequestMapping(value = "/getPerfectoDevicesForGivenGrid", method = RequestMethod.GET)
	public @ResponseBody List<String> getPerfectoDevicesForGivenGrid(
			@RequestParam(value = "gridId", required = true) String gridId, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			if (gridId != null && gridId.length() > 0) {
				int gridIdNumber = Integer.parseInt(gridId);
				List<String> deviceNameList = itapConfigService.getDeviceNameList(gridIdNumber);
				return deviceNameList;
			} else {
				return new ArrayList<String>();
			}
		} catch (Exception baseEx) {
			return new ArrayList<String>();
		}
	}

	@RequestMapping(value = "/getPerfectoDevicesUdid", method = RequestMethod.GET)
	public @ResponseBody List<String> getPerfectoDevicesUdid(
			@RequestParam(value = "gridId", required = true) String gridId,
			@RequestParam(value = "deviceName", required = true) String deviceName,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		try {
			if (deviceName != null && gridId != null && deviceName.length() > 0
					&& gridId.length() > 0) {
				int gridIdNumber = Integer.parseInt(gridId);
				List<String> deviceNameList = itapConfigService.getDeviceListForGivenDeviceName(
						deviceName, gridIdNumber);
				return deviceNameList;
			} else {
				return new ArrayList<String>();
			}
		} catch (Exception baseEx) {
			return new ArrayList<String>();
		}
	}

	@RequestMapping("/configurationTrainView")
	public String configurationTrainView(
			@ModelAttribute("itapTrainViewDTO") ITAPTrainViewDTO itapTrainViewDTO,
			@RequestParam(value = ITAPConstants.PAGE, required = false) String page,
			ModelMap modelmap, HttpServletRequest request, HttpServletResponse response) {
		List<ITAPTrainViewDTO> itapTrainViewDTOs = null;
		try {
			itapTrainViewDTOs = itapConfigService.configurationTrainView(0, 0, true,
					(String) request.getSession().getAttribute(ITAPConstants.SESSION_UID),
					itapTrainViewDTO);

			modelmap.addAttribute("itapTrainViewDTOs", itapTrainViewDTOs);
			return "configurationTrainView";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "configurationTrainView";
				}
			}
			return "configurationTrainView";
		}
	}

	@RequestMapping(value = "/deleteTrain")
	public String deleteTrainConfig(
			@RequestParam(value = ITAPConstants.ID, required = false) String id,
			@RequestParam(value = "serId", required = false) String serId,
			@RequestParam(value = "jobs", required = false) String jobs, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		try {
			// set Default jenkin server Id
			long serverId = Long.parseLong(serId);
			itapConfigService.deleteTrain(id, jobs, serverId);
			return "redirect:configurationTrainView";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:configurationTrainView";
				}
			}
			model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return "redirect:configurationTrainView";
		}
		// return "redirect:configurationTrainView";
	}

	@RequestMapping(value = "/deleteMultipleTrain")
	public String deleteMultipleTrainConfig(
			@ModelAttribute("itapConfigMultipleTrainsDTO") ITAPConfigMultipleTrainsDTO itapConfigMultipleTrainsDTO,
			@RequestParam(value = "serId", required = false) String serId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		itapConfigMultipleTrainsDTO.setServerId(Long.parseLong(serId));

		List<String> list = itapConfigMultipleTrainsDTO.getTrainJobs();

		for (String id : list) {

			String jobDetails = itapConfigService.getTrainJob(id,
					itapConfigMultipleTrainsDTO.getServerId());

			try {
				itapConfigService.deleteTrain(id, jobDetails,
						itapConfigMultipleTrainsDTO.getServerId());

			} catch (BaseException baseEx) {
				baseEx.printStackTrace();
				if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
					if (baseEx.getErrorCode().startsWith("")) {
						return "redirect:configurationTrainView";
					}
				}
			}
		}
		model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
		return "redirect:configurationTrainView";
	}

	@RequestMapping(value = "/configTrainJobBuild")
	public String configTrainJobBuild(
			@RequestParam(value = ITAPConstants.ID, required = false) String id,
			@RequestParam(value = "serId", required = false) String serId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		try {

			long serverId = Long.parseLong(serId);
			itapConfigService.buildJob(id, serverId);
			return "redirect:configurationTrainView";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:configurationTrainView";
				}
			}
			model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return "redirect:configurationTrainView";
		}
	}

	@RequestMapping(value = "/itapEnvCheck", method = RequestMethod.GET)
	public void itapEnvCheck(HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		Map<String, String[]> data = request.getParameterMap();
		String envId = "";
		for (Entry<String, String[]> entry : data.entrySet()) {
			if (entry.getKey() != "" && entry.getKey() != null) {
				envId = entry.getKey();
			}

		}

		ITAPSearchBookingDTO remsSearchBookingDTO = itapConfigService.checkEnvAvilability(envId);

		Gson gson = new Gson();
		String envJson = gson.toJson(remsSearchBookingDTO);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.println(envJson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * @RequestMapping(value = "/itapEnvCheck", method = RequestMethod.GET)
	 * public String itapEnvCheck(
	 * 
	 * @ModelAttribute("remsSearchBookingDTO") ITAPSearchBookingDTO
	 * remsSearchBookingDTO,
	 * 
	 * @RequestParam(value = "envId", required = false) String envId, ModelMap
	 * model, HttpServletRequest request, HttpServletResponse response) throws
	 * BaseException {
	 * 
	 * try { remsSearchBookingDTO = itapConfigService
	 * .checkEnvAvilability(envId);
	 * 
	 * Gson gson = new Gson(); String envJson =
	 * gson.toJson(remsSearchBookingDTO); System.out.println(envJson);
	 * model.addAttribute("remsSearchBookingDTO", remsSearchBookingDTO); return
	 * "itapEnvCheck"; } catch (BaseException baseEx) { if (null !=
	 * baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
	 * { if (baseEx.getErrorCode().startsWith("")) { return "itapEnvCheck"; } }
	 * return "itapEnvCheck"; } }
	 */

	@RequestMapping("/configurationViewTeamCity")
	public String configurationViewTeamCity(
			@ModelAttribute("itapConfigDTO") ITAPConfigDTO itapConfigDTO,
			@RequestParam(value = ITAPConstants.PAGE, required = false) String page,
			@RequestParam(value = "serId", required = false) String serId, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		List<ITAPConfigDTO> itapConfigDTOs = null;
		try {

			// set default teamcity server Id
			itapConfigDTO.setServerId(Long.parseLong(serId));
			itapConfigDTOs = itapConfigService.configurationViewTeamCity(itapConfigDTO);
			modelmap.addAttribute("itapConfigDTOs", itapConfigDTOs);
			return "configurationViewTeamCity";
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "configurationViewTeamCity";
				}
			}
			return "configurationViewTeamCity";
		}
	}

	@RequestMapping(value = "/configurationJobBuildTeamCity")
	public String configurationJobBuildTeamCity(
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {

		// setDefault teamcity id;

		long serverId = 2l;
		try {
			itapConfigService.configurationJobBuildTeamCity(id, serverId);
			return "redirect:configurationViewTeamCity?serId=" + serverId;
		} catch (BaseException baseEx) {
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				if (baseEx.getErrorCode().startsWith("")) {
					return "redirect:configurationViewTeamCity?serId=" + serverId;
				}
			}
			model.addAttribute(ITAPConstants.ERROR, ITAPConstants.EXCEPTION_ADMIN);
			return "redirect:configurationViewTeamCity?serId=" + serverId;
		}
	}
}
