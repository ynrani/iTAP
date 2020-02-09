/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigServiceImpl.Java
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPConfigDAO;
import com.itap.dao.ITAPCrossBrowserGridDAO;
import com.itap.dao.ITAPCrossBrowserOSDAO;
import com.itap.dao.ITAPCrossBrowserOptionsDAO;
import com.itap.dao.ITAPToolTestCaseDAO;
import com.itap.exception.DAOException;
import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPBookDtlDO;
import com.itap.model.DO.ITAPConfigDO;
import com.itap.model.DO.ITAPCrossBrowserGridDO;
import com.itap.model.DO.ITAPCrossBrowserOS;
import com.itap.model.DO.ITAPCrossBrowserOptions;
import com.itap.model.DO.ITAPEnvDtlDO;
import com.itap.model.DO.ITAPToolTestCaseDO;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.model.DTO.ITAPConfigDTO;
import com.itap.model.DTO.ITAPCrossBrowserTestsuite;
import com.itap.model.DTO.ITAPProgressDTO;
import com.itap.model.DTO.ITAPSearchBookingDTO;
import com.itap.model.DTO.ITAPTrainViewDTO;
import com.itap.model.mapper.ITAPConfigMapper;
import com.itap.service.ITAPConfigService;
import com.itap.service.ITAPJenkinsConfigService;
import com.itap.util.CalendarDateUtils;
import com.itap.util.CopyFolderUtil;
import com.itap.util.CreateJenkinsJob;
import com.itap.util.CreateTeamCityJob;
import com.itap.util.DateUtils;

@Component
@Service("itapConfigService")
@Transactional(propagation = Propagation.REQUIRED)
public class ITAPConfigServiceImpl extends ITAPBaseServiceImpl implements ITAPConfigService {
	private static Logger LOGGER = Logger.getLogger(ITAPConfigServiceImpl.class);

	@Autowired
	ITAPConfigDAO itapConfigDAO;

	/*
	 * @Autowired ITAPEnvConfigDAO itapEnvConfigDAO;
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	ITAPCrossBrowserGridDAO itapCrossBrowserGridDAO;

	@Autowired
	ITAPConfigMapper itapConfigMapper;

	@Autowired
	ITAPCrossBrowserOSDAO itapCrossBrowserOSDAO;

	@Autowired
	ITAPCrossBrowserOptionsDAO itapCrossBrowserOptionsDAO;

	@Autowired
	ITAPToolTestCaseDAO itapToolTestCaseDAO;

	@Autowired
	ITAPJenkinsConfigService itapJenkinsConfigService;

	// private long serverId = 1l;

	@Override
	public ITAPConfigDTO selectConfigToEdit(String id, ITAPConfigDTO itapConfigDTO)
			throws ServiceException {
		try {
			String jsonResponse = CreateJenkinsJob.readJob(
					itapJenkinsConfigService.getJenkinsUrl(itapConfigDTO.getServerId()), id);
			// TODO
			String regexString = null;
			Pattern p = Pattern.compile(Pattern.quote("<remote>") + "(.*?)"
					+ Pattern.quote("</remote>"));
			Matcher m = p.matcher(jsonResponse);
			while (m.find()) {
				regexString = m.group(1);
			}
			itapConfigDTO.setJobName(id);
			itapConfigDTO.setSource("SVN");
			itapConfigDTO.setRepoUrl(regexString);

			EntityManager managerUser = openUserEntityManager();
			itapConfigDTO = itapConfigMapper.convertFromITAPConfigDOToITAPConfigDTO(
					itapConfigDAO.selectConfigToEdit(id, managerUser), itapConfigDTO);
			closeUserEntityManager(managerUser);

			return itapConfigDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public ITAPConfigDTO saveConfigDetails(ITAPConfigDTO itapConfigDTO) throws ServiceException {
		try {

			// Copy file from original
			String rootPath = messageSource.getMessage(ITAPConstants.FT_ITAP, null, null);
			String uftPath = null;
			// FUNCTIONAL TESTING excel write
			if (itapConfigDTO.getTestSuite() != null
					&& !itapConfigDTO.getTestSuite().equals("Select")) {

				String browserComboString = itapConfigDTO.getCombinedBrowserCombo().trim();

				if (itapConfigDTO.getGridType() != null
						&& itapConfigDTO.getGridType().equals("In-house Grid")
						&& browserComboString != null
						&& itapConfigDTO.getCombinedBrowserCombo().length() > 0) {
					writeOsBrowserCombo(itapConfigDTO);
					writeTestCaseSelectionStepsForOptik(itapConfigDTO);
				}

				String deviceComboString = itapConfigDTO.getCombinedDeviceCombo().trim();
				if (deviceComboString != null && deviceComboString.length() > 0) {
					writeTestCaseAndDeviceSelectionStepsForOptikPerfecto(itapConfigDTO);
				}
			}
			// FUNCTIONAL TESTING excel write
			if (itapConfigDTO.getToolName() != null && !itapConfigDTO.getToolName().equals("None")) {
				// UFT
				if (itapConfigDTO.getToolName().equals("UFT")) {

					String excelPath = messageSource.getMessage(
							ITAPConstants.FT_UFT_MAINSCRIPT_PATH, null, null)
							+ File.separator
							+ messageSource.getMessage(ITAPConstants.FT_UFT_MAINSCRIPT, null, null);

					// new path
					String newpath = itapConfigDTO.getProjName() + "\\"
							+ itapConfigDTO.getProjName() + "_" + itapConfigDTO.getJobName()
							+ "\\UFT";

					CopyFolderUtil.copyFolder(excelPath, newpath, rootPath);
					uftPath = rootPath + newpath;
					StringBuffer data = new StringBuffer(
							"cd \\AutoHub\\CyclosWorkSpace\\CycloseUsingCafeNext\\");
					data.append('\n');
					data.append("Auto-HuB-Cafe-Next-Dynamic-Batch-Execution.vbs ");
					data.append(uftPath + "\\ MainScript.xls");
					FileOutputStream out = new FileOutputStream(rootPath + newpath + "\\BATCH.bat");
					out.write(data.toString().getBytes());
					out.close();

					writeTestCaseSelectionStepsForUFT(itapConfigDTO, newpath);
				}
				// Selenium
				// Test Complete
			}

			// Perfecto excel write
			if (itapConfigDTO.getGridType() != null
					&& itapConfigDTO.getGridType().equals("Perfecto")
					&& itapConfigDTO.getSelectedTestCases() != null
					&& itapConfigDTO.getSelectedTestCases().length() > 0) {
				writeToolBasedTestCase(itapConfigDTO);
			}
			if (!itapConfigDTO.getNewOrEdit()) {
				System.out.println("_______________New Or Edit ______________");
				EntityManager managerUser = openUserEntityManager();
				ITAPConfigDO itapConfigDO = itapConfigDAO.saveConfigDetails(itapConfigMapper
						.convertFromITAPConfigDTOToITAPConfigDO(itapConfigDTO, new ITAPConfigDO()),
						managerUser);

				itapConfigDTO.setConfigId(String.valueOf(itapConfigDO.getConfigId()));
				closeUserEntityManager(managerUser);

				if (null != uftPath) {
					itapConfigDTO.setUftPath(uftPath + "\\BATCH.bat");
				}
				// Creates Jobs in jenkins
				List<ITAPConfigDTO> itapConfigDTOs = getJobs(itapConfigDTO);

				if (null != itapConfigDTOs) {
					long id = itapConfigDTO.getServerId();
					JenkinsConfigDO jenkinsConfigDO = itapJenkinsConfigService.getCiData(id);

					if (jenkinsConfigDO.getCiName().equalsIgnoreCase("TeamCity")) {
						// create project if it is teamcity

						CreateTeamCityJob.createProject(jenkinsConfigDO.getUrl(), itapConfigDTO);
						for (ITAPConfigDTO itapConfigDTO2 : itapConfigDTOs) {
							// url, jobName, jobId, parentId);(
							// createAndbuildProjectJobs(String url, String
							// jobName, String parentId)
							CreateTeamCityJob.createAndbuildProjectJobs(jenkinsConfigDO.getUrl(),
									itapConfigDTO2.getJobName(), itapConfigDTO.getProjName()
											+ "_123");
						}

					}
					if (jenkinsConfigDO.getCiName().equalsIgnoreCase("Jenkins")) {
						for (ITAPConfigDTO itapConfigDTO2 : itapConfigDTOs) {
							// creates each time one individual job

							// create jobs in jenkins
							String str = CreateJenkinsJob.getJobCreateXml(itapConfigDTO2);
							CreateJenkinsJob.createJob(jenkinsConfigDO.getUrl(),
									itapConfigDTO2.getJobName(), str);
							/*
							 * CreateJenkinsJob.createJob(itapJenkinsConfigService
							 * .getJenkinsUrl(), itapConfigDTO2.getJobName(),
							 * str);
							 */
						}
					}

				}
			}
			// TODO

			return itapConfigDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	private boolean writeTestCaseAndDeviceSelectionStepsForOptikPerfecto(ITAPConfigDTO itapConfigDTO)
			throws ServiceException {
		try {

			String filePath = messageSource.getMessage(
					ITAPConstants.CROSS_BROWSER_COMBO_EXCEL_FOLDER_PATH_PERFECTO, null, null);
			FileInputStream fileIO = new FileInputStream(new File(filePath));
			HSSFWorkbook workBook = new HSSFWorkbook(fileIO);
			HSSFSheet sheet = workBook.getSheet("Sheet1");
			int existingRowSize = sheet.getPhysicalNumberOfRows();

			int testCaseRowStart = 11;
			String testSuite = itapConfigDTO.getTestSuite();
			String[] testCases = itapConfigDTO.getSelectedTestCases().split(",");
			List<String> testCaseList = new ArrayList<String>(Arrays.asList(testCases));

			for (String testCaseName : testCaseList) {
				String zeroCell = "CheckBoxSelect";
				String firstCell = "id";
				String secondCell = testCaseName;
				String thirdCell = testSuite + ".xls";

				HSSFRow thisRow = sheet.createRow(testCaseRowStart);

				Cell zeroCellOb = thisRow.createCell(0);
				zeroCellOb.setCellValue(zeroCell);

				Cell firstCellOb = thisRow.createCell(1);
				firstCellOb.setCellValue(firstCell);

				Cell secondCellOb = thisRow.createCell(2);
				secondCellOb.setCellValue(secondCell);

				Cell thirdCellOb = thisRow.createCell(3);
				thirdCellOb.setCellValue(thirdCell);

				testCaseRowStart++;
			}

			String comboDevices = itapConfigDTO.getCombinedDeviceCombo();
			String[] comboDevicesArr = comboDevices.split(";");
			List<String> comboDevicesList = new ArrayList<String>(Arrays.asList(comboDevicesArr));
			for (String deviceCombo : comboDevicesList) {
				String zeroCell = "SelectList_Value";
				String firstCell = "id";
				String deviceName = deviceCombo.split(",")[0];
				String deviceUdid = deviceCombo.split(",")[1];

				HSSFRow thisRow = sheet.createRow(testCaseRowStart);

				Cell zeroCellOb = thisRow.createCell(0);
				zeroCellOb.setCellValue(zeroCell);

				Cell firstCellOb = thisRow.createCell(1);
				firstCellOb.setCellValue(firstCell);

				Cell secondCellOb = thisRow.createCell(2);
				secondCellOb.setCellValue("perfectoMobileDropdown");

				Cell thirdCellOb = thisRow.createCell(3);
				thirdCellOb.setCellValue(deviceName);

				testCaseRowStart++;

				HSSFRow thisRowTwo = sheet.createRow(testCaseRowStart);

				Cell zeroCellOb1 = thisRowTwo.createCell(0);
				zeroCellOb1.setCellValue(zeroCell);

				Cell firstCellOb2 = thisRowTwo.createCell(1);
				firstCellOb2.setCellValue("name");

				Cell secondCellOb2 = thisRowTwo.createCell(2);
				secondCellOb2.setCellValue("perfectoMobileUdidDropdown");

				Cell thirdCellOb2 = thisRowTwo.createCell(3);
				thirdCellOb2.setCellValue(deviceUdid);

				testCaseRowStart++;
			}

			HSSFRow thisRowThree = sheet.createRow(testCaseRowStart);

			Cell ZEROCellOb2 = thisRowThree.createCell(0);
			ZEROCellOb2.setCellValue("click_On_Button");

			Cell firstCellOb2 = thisRowThree.createCell(1);
			firstCellOb2.setCellValue("name");

			Cell secondCellOb2 = thisRowThree.createCell(2);
			secondCellOb2.setCellValue("Add Device");

			testCaseRowStart++;

			HSSFRow thisRowFour = sheet.createRow(testCaseRowStart);

			Cell ZEROCellOb3 = thisRowFour.createCell(0);
			ZEROCellOb3.setCellValue("click_On_Button");

			Cell firstCellOb3 = thisRowFour.createCell(1);
			firstCellOb3.setCellValue("id");

			Cell secondCellOb3 = thisRowFour.createCell(2);
			secondCellOb3.setCellValue("startExecution");

			testCaseRowStart++;

			HSSFRow thisRowFive = sheet.createRow(testCaseRowStart);

			Cell secondCellOb5 = thisRowFive.createCell(0);
			secondCellOb5.setCellValue("close_Browser");

			testCaseRowStart++;

			while (existingRowSize >= testCaseRowStart) {
				HSSFRow row = sheet.getRow(existingRowSize);
				if (row != null) {
					sheet.removeRow(row);
				}
				existingRowSize--;
			}

			HSSFRow urlRow = sheet.getRow(7);
			if (urlRow != null) {
				Cell urlCell = urlRow.createCell(3);
				if (StringUtils.isNotEmpty(itapConfigDTO.getOptExeType())
						&& "FN".equalsIgnoreCase(itapConfigDTO.getOptExeType())) {
					urlCell.setCellValue("http://in-pnq-coe19:8081/OPTIK/execution");
				} else if (StringUtils.isNotEmpty(itapConfigDTO.getOptExeType())
						&& "UI".equalsIgnoreCase(itapConfigDTO.getOptExeType())) {
					urlCell.setCellValue("http://in-pnq-coe19:8081/OPTIK/executionFunctionalUI");
				}

			}

			FileOutputStream outputTempExcelFile = new FileOutputStream(new File(filePath));
			workBook.write(outputTempExcelFile);

			workBook.close();
			outputTempExcelFile.close();

			return true;
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	private boolean writeTestCaseSelectionStepsForOptik(ITAPConfigDTO itapConfigDTO)
			throws ServiceException {
		try {
			String excelPath = messageSource.getMessage(
					ITAPConstants.CROSS_BROWSER_COMBO_EXCEL_FOLDER_PATH, null, null)
					+ File.separator
					+ messageSource.getMessage(ITAPConstants.CROSS_BROWSER_COMBO_EXCEL_NAME, null,
							null);
			File file = new File(excelPath);
			if (file.exists()) {
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
				HSSFSheet sheet = workbook.getSheet(messageSource.getMessage(
						ITAPConstants.CROSS_BROWSER_Sheet, null, null));
				if (sheet != null) {
					int rowCounter = 13;
					// int rowCounter = 15;

					String[] testCases = itapConfigDTO.getSelectedTestCases().split(",");
					List<String> testCasesList = new ArrayList<String>(Arrays.asList(testCases));
					int totalRowsExisting = sheet.getPhysicalNumberOfRows();

					for (String testCaseName : testCasesList) {
						String checkBox = "CheckBoxSelect";
						String id = "id";
						String testSuiteName = itapConfigDTO.getTestSuite() + ".xls";

						HSSFRow rowThis = sheet.createRow(rowCounter);

						rowThis.createCell(0).setCellValue(checkBox);

						rowThis.createCell(1).setCellValue(id);

						rowThis.createCell(2).setCellValue(testCaseName);

						rowThis.createCell(3).setCellValue(testSuiteName);

						rowCounter++;
					}

					String testSuiteName = itapConfigDTO.getTestSuite() + ".xls";

					HSSFRow rowThis = sheet.createRow(rowCounter);
					rowThis.createCell(0).setCellValue("CheckBoxSelect");
					rowThis.createCell(1).setCellValue("xpath");
					rowThis.createCell(2).setCellValue("DeviceCheckBoxXpath");
					rowThis.createCell(3).setCellValue(testSuiteName);

					rowCounter++;

					HSSFRow rowThisTwo = sheet.createRow(rowCounter);
					rowThisTwo.createCell(0).setCellValue("BrowserSelections");
					rowThisTwo.createCell(1).setCellValue("null");
					rowThisTwo.createCell(2).setCellValue("null");
					rowThisTwo.createCell(3).setCellValue("Yes");

					rowCounter++;

					HSSFRow rowThisThree = sheet.createRow(rowCounter);
					rowThisThree.createCell(0).setCellValue("click_On_Button");
					rowThisThree.createCell(1).setCellValue("id");
					rowThisThree.createCell(2).setCellValue("startExecution");
					rowThisThree.createCell(3).setCellValue("");

					rowCounter++;

					HSSFRow rowThisFour = sheet.createRow(rowCounter);
					rowThisFour.createCell(0).setCellValue("close_Browser");
					rowThisFour.createCell(1).setCellValue("");
					rowThisFour.createCell(2).setCellValue("");
					rowThisFour.createCell(3).setCellValue("");

					rowCounter++;

					while (totalRowsExisting >= rowCounter) {
						HSSFRow row = sheet.getRow(totalRowsExisting);
						if (row != null) {
							sheet.removeRow(row);
						}
						totalRowsExisting--;
					}

				}

				HSSFRow urlRow = sheet.getRow(7);
				if (urlRow != null) {
					Cell urlCell = urlRow.createCell(3);
					if (StringUtils.isNotEmpty(itapConfigDTO.getOptExeType())
							&& "FN".equalsIgnoreCase(itapConfigDTO.getOptExeType())) {
						urlCell.setCellValue("http://in-pnq-coe19:8081/OPTIK/execution");
					} else if (StringUtils.isNotEmpty(itapConfigDTO.getOptExeType())
							&& "UI".equalsIgnoreCase(itapConfigDTO.getOptExeType())) {
						urlCell.setCellValue("http://in-pnq-coe19:8081/OPTIK/executionFunctionalUI");
					}
				}

				FileOutputStream outputTempExcelFile = new FileOutputStream(new File(excelPath));
				workbook.write(outputTempExcelFile);

				workbook.close();
				outputTempExcelFile.close();
			}
			return true;
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	private boolean writeToolBasedTestCase(ITAPConfigDTO itapConfigDTO) throws ServiceException {
		try {
			String excelPath = messageSource.getMessage(
					ITAPConstants.CROSS_BROWSER_MAINSCRIPT_PATH, null, null)
					+ File.separator
					+ messageSource.getMessage(ITAPConstants.CROSS_BROWSER_MAINSCRIPT, null, null);
			File file = new File(excelPath);
			if (file.exists()) {
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
				HSSFSheet sheet = workbook.getSheet(messageSource.getMessage(
						ITAPConstants.CROSS_BROWSER_MAINSCRIPT_SHEET, null, null));
				if (sheet != null) {
					int rowCounter = 1;
					int totalRowCount = sheet.getPhysicalNumberOfRows();
					while (rowCounter < totalRowCount) {
						HSSFRow rowThis = sheet.getRow(rowCounter);
						if (rowThis != null) {
							HSSFCell cellThis = rowThis.getCell(0);
							if (cellThis != null) {
								String testCaseName = cellThis.getStringCellValue();
								testCaseName = testCaseName.trim();

								if (itapConfigDTO.getSelectedTestCases().contains(testCaseName)) {
									sheet.getRow(rowCounter).getCell(1).setCellValue("YES");
								} else {
									sheet.getRow(rowCounter).getCell(1).setCellValue("NO");
								}
							}
						}
						rowCounter++;
					}
				}
				FileOutputStream outputTempExcelFile = new FileOutputStream(new File(excelPath));
				workbook.write(outputTempExcelFile);
				workbook.close();
				outputTempExcelFile.close();
			}
			return true;
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	private boolean writeTestCaseSelectionStepsForUFT(ITAPConfigDTO itapConfigDTO, String newpath)
			throws ServiceException {
		try {

			File file = new File(newpath);
			if (file.exists()) {
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
				HSSFSheet sheet = workbook.getSheet(messageSource.getMessage(
						ITAPConstants.FT_UFT_MAINSCRIPT_SHEET, null, null));
				if (sheet != null) {
					int rowCounter = 1;
					int totalRowCount = sheet.getPhysicalNumberOfRows();
					while (rowCounter < totalRowCount) {
						HSSFRow rowThis = sheet.getRow(rowCounter);
						if (rowThis != null) {
							HSSFCell cellThis = rowThis.getCell(0);
							if (cellThis != null) {
								String testCaseName = cellThis.getStringCellValue();
								testCaseName = testCaseName.trim();

								if (itapConfigDTO.getSelectedTestCasesList().contains(testCaseName)) {
									sheet.getRow(rowCounter).getCell(1).setCellValue("YES");
								} else {
									sheet.getRow(rowCounter).getCell(1).setCellValue("NO");
								}
							}
						}
						rowCounter++;
					}
				}
				FileOutputStream outputTempExcelFile = new FileOutputStream(new File(newpath));
				workbook.write(outputTempExcelFile);
				workbook.close();
				outputTempExcelFile.close();
			}
			return true;
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	private boolean writeOsBrowserCombo(ITAPConfigDTO itapConfigDTO) throws ServiceException {
		try {

			String excelPath = messageSource.getMessage(
					ITAPConstants.CROSS_BROWSER_COMBO_EXCEL_FOLDER_PATH, null, null)
					+ File.separator
					+ messageSource.getMessage(ITAPConstants.CROSS_BROWSER_COMBO_EXCEL_NAME, null,
							null);
			File excelFile = new File(excelPath);
			if (excelFile.exists()) {
				FileInputStream fileIO = new FileInputStream(excelFile);
				HSSFWorkbook excelSheet = new HSSFWorkbook(fileIO);
				final HSSFSheet sheet = excelSheet.getSheet(messageSource.getMessage(
						ITAPConstants.CROSS_BROWSER_COMBO_TAB, null, null));
				int totalRowCount = sheet.getPhysicalNumberOfRows();

				int rowCounter = 2;
				String browserCombo = itapConfigDTO.getCombinedBrowserCombo();
				String[] browsers = browserCombo.split(";");
				List<String> browsersList = Arrays.asList(browsers);
				if (null != browsersList && 0 < browsersList.size()) {
					for (String browserC : browsersList) {
						if (StringUtils.isNotEmpty(browserC)) {
							String os = browserC.split(",")[0];
							String browser = browserC.split(",")[1];
							String version = browserC.split(",")[2];
							String osId = "operatingSystemDiv-" + os;
							String browserId = "browserNameDiv-" + os + "-" + browser;
							String versionId = "browserVersionDiv-" + os + "-" + browser + "-"
									+ version;
							String osComboStr = os + browser + version;

							HSSFRow row = sheet.createRow(rowCounter);

							final HSSFCell osComboCell = row.createCell(0, Cell.CELL_TYPE_STRING);
							osComboCell.setCellValue(osComboStr);

							final HSSFCell osCell = row.createCell(1, Cell.CELL_TYPE_STRING);
							osCell.setCellValue(os);

							final HSSFCell browserCell = row.createCell(2, Cell.CELL_TYPE_STRING);
							browserCell.setCellValue(browser);

							final HSSFCell versionCell = row.createCell(3, Cell.CELL_TYPE_STRING);
							versionCell.setCellValue(version);

							final HSSFCell osIdCell = row.createCell(4, Cell.CELL_TYPE_STRING);
							osIdCell.setCellValue(osId);

							final HSSFCell browserIdCell = row.createCell(5, Cell.CELL_TYPE_STRING);
							browserIdCell.setCellValue(browserId);

							final HSSFCell versionIdCell = row.createCell(6, Cell.CELL_TYPE_STRING);
							versionIdCell.setCellValue(versionId);

							rowCounter++;
						}
					}
				}

				while (totalRowCount >= rowCounter) {
					HSSFRow row = sheet.getRow(totalRowCount);
					if (row != null) {
						sheet.removeRow(row);
					}
					totalRowCount--;
				}

				HSSFRow rowThisFive = sheet.createRow(0);
				rowThisFive.createCell(1).setCellValue(browsersList.size());

				FileOutputStream outputTempExcelFile = new FileOutputStream(new File(excelPath));
				excelSheet.write(outputTempExcelFile);
				fileIO.close();
				excelSheet.close();
				outputTempExcelFile.close();

			}
			return true;
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<ITAPConfigDTO> configurationView(int offSet, int recordsperpage, boolean b,
			String userId, ITAPConfigDTO itapConfigDTO) throws ServiceException {
		try {
			List<ITAPConfigDTO> itapConfigDTOs = null;
			String[] jobs = CreateJenkinsJob.listJobs(itapJenkinsConfigService
					.getJenkinsUrl(itapConfigDTO.getServerId()));

			itapConfigDTOs = new ArrayList<ITAPConfigDTO>();
			for (String job : jobs) {
				String[] names = job.split("name>");
				String[] colors = job.split("color>");

				itapConfigDTO = new ITAPConfigDTO();
				if (names.length == 3) {
					String name = names[1];
					name = name.substring(0, name.length() - 2); // Take off </
																	// for the
																	// closing
																	// name
																	// tag:
																	// </name>
					itapConfigDTO.setJobName(name);
				}

				if (colors.length == 3) {
					String color = colors[1];
					color = color.substring(0, color.length() - 2); // Take off
																	// </ for
																	// the
																	// closing
																	// name
					if ("blue".equalsIgnoreCase(color)) {
						itapConfigDTO.setSts("Success");
					} else if ("red".equalsIgnoreCase(color)) {
						itapConfigDTO.setSts("Failed");
					} else if ("yellow".equalsIgnoreCase(color)) {
						itapConfigDTO.setSts("UnStable");
					} else if ("notbuilt".equalsIgnoreCase(color)) {
						itapConfigDTO.setSts("Not Built");
					}

					// System.out.println("name:"+name);
				}
				if (colors.length == 3 || names.length == 3) {
					itapConfigDTOs.add(itapConfigDTO);
				}
			}

			return itapConfigDTOs;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String deleteConfiguration(String jobName, long serverId) throws ServiceException {
		try {
			String str = null;
			System.out.println("JobName : : : " + jobName);
			CreateJenkinsJob.deleteJob(itapJenkinsConfigService.getJenkinsUrl(serverId), jobName);
			return str;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String deleteConfigurationFromTeamCity(String jobName, long serverId)
			throws ServiceException {
		try {
			String str = null;
			CreateTeamCityJob.deleteJobFromTeamCity(
					itapJenkinsConfigService.getJenkinsUrl(serverId), jobName);
			return str;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String buildJob(String jobName, long serverId) throws ServiceException {
		try {
			String str = null;
			CreateJenkinsJob.buildJob(itapJenkinsConfigService.getJenkinsUrl(serverId), jobName);
			return str;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<String> getAllJobNames(String projName, long serverId) throws ServiceException {
		try {
			List<String> allJobs = null;
			String[] jobs = CreateJenkinsJob.listJobs(itapJenkinsConfigService
					.getJenkinsUrl(serverId));

			allJobs = new ArrayList<String>();
			for (String job : jobs) {
				String[] names = job.split("name>");

				if (names.length == 3) {
					String name = names[1];
					name = name.substring(0, name.length() - 2); // Take off </
																	// for the
																	// closing
																	// name
					if (name.contains(projName + "_")) {
						allJobs.add(name.trim());
					}
				}
			}

			return allJobs;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> allProjs() throws ServiceException {
		try {

			EntityManager managerUser = openUserEntityManager();
			List<String> allProjs = itapConfigDAO.allProjs(managerUser);

			closeUserEntityManager(managerUser);

			// TODO
			return allProjs;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	private List<ITAPConfigDTO> getJobs(ITAPConfigDTO itapConfigDTO) {
		List<ITAPConfigDTO> itapConfigDTOs = null;
		if (null != itapConfigDTO) {

			itapConfigDTOs = new ArrayList<ITAPConfigDTO>();
			// Job 1 SOURCE CONFIGURATION MANAGEMENT
			if (StringUtils.isNotEmpty(itapConfigDTO.getSource())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_SCM_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setSource(itapConfigDTO.getSource());
				itapConfigDTO1.setRepoUrl(itapConfigDTO.getRepoUrl());
				itapConfigDTOs.add(itapConfigDTO1);
			}
			// Job 2 CODE COVERAGE ANALYSIS
			if (StringUtils.isNotEmpty(itapConfigDTO.getCodeCvg())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_CODECOVERAGE_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setJobName(itapConfigDTO.getProjName() + "_CODECOVERAGE_"
						+ itapConfigDTO.getJobName());
				itapConfigDTO1.setCodeCvg(itapConfigDTO.getCodeCvg());
				itapConfigDTOs.add(itapConfigDTO1);
			}
			// Job 3 UNIT TEST
			if (StringUtils.isNotEmpty(itapConfigDTO.getTestType())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_UNITTEST_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setTestType(itapConfigDTO.getTestType());
				itapConfigDTOs.add(itapConfigDTO1);
			}
			// Job 4 ENVIRONMENT SETUP
			if (StringUtils.isNotEmpty(itapConfigDTO.getEnviorment())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_ENVSET_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setEnviorment(itapConfigDTO.getEnviorment());
				itapConfigDTO1.setSanity(itapConfigDTO.getSanity());
				itapConfigDTO1.setDocker(itapConfigDTO.getDocker());
				itapConfigDTOs.add(itapConfigDTO1);
			}
			// Job 5 BUILD & DEPLOY
			if (StringUtils.isNotEmpty(itapConfigDTO.getPckage())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_BUILDDEP_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setPckage(itapConfigDTO.getPckage()); //
				itapConfigDTO1.setDeployment(itapConfigDTO.getDeployment());
				itapConfigDTO1.setQualityGate1(itapConfigDTO.getQualityGate1());
				itapConfigDTO1.setCriteria1(itapConfigDTO.getCriteria1());
				itapConfigDTO1.setQualityGate2(itapConfigDTO.getQualityGate2());
				itapConfigDTO1.setCriteria2(itapConfigDTO.getCriteria2());
				itapConfigDTO1.setQualityGate3(itapConfigDTO.getQualityGate3());
				itapConfigDTO1.setCriteria3(itapConfigDTO.getCriteria3());
				itapConfigDTOs.add(itapConfigDTO1);
			}
			// Job 6 TESTING BDD
			if (StringUtils.isNotEmpty(itapConfigDTO.getBddSct())) {

				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_BDD_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setBddSct(itapConfigDTO.getBddSct());
				itapConfigDTOs.add(itapConfigDTO1);

			}
			// Job 7 TESTING API TESTING
			if (StringUtils.isNotEmpty(itapConfigDTO.getApiTest())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_APITEST_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setApiTest(itapConfigDTO.getApiTest());
				itapConfigDTOs.add(itapConfigDTO1);

			}
			// Job 11 TESTING SPRINT TESTING
			if (StringUtils.isNotEmpty(itapConfigDTO.getSprintTestSuiteColumnName())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_SPTEST_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setSprintTest(itapConfigDTO.getSprintTestSuiteColumnName());
				itapConfigDTOs.add(itapConfigDTO1);

			}
			// Job 8 TESTING CROSS BROWSER TESTING
			if (StringUtils.isNotEmpty(itapConfigDTO.getTestSuite())
					&& !"Select".equalsIgnoreCase(itapConfigDTO.getTestSuite())) {

				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_OPTIK_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setTestSuite(itapConfigDTO.getTestSuite());
				itapConfigDTO1.setTestCase(itapConfigDTO.getTestCase());
				itapConfigDTO1.setGridType(itapConfigDTO.getGridType());
				itapConfigDTO1.setGridLabUrl(itapConfigDTO.getGridLabUrl());
				itapConfigDTOs.add(itapConfigDTO1);
			}
			// Job 9 TESTING FUNCTIONAL TESTING
			if (StringUtils.isNotEmpty(itapConfigDTO.getToolName())
					&& !"None".equalsIgnoreCase(itapConfigDTO.getToolName())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();

				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_FUNCTIONALTEST_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");

				itapConfigDTO1.setUftPath(itapConfigDTO.getUftPath()); //
				itapConfigDTO1.setToolName(itapConfigDTO.getToolName()); //
				itapConfigDTO1.setTstScrt(itapConfigDTO.getTstScrt());
				itapConfigDTO1.setFtQalityGate1(itapConfigDTO.getFtQalityGate1());
				itapConfigDTO1.setFtCriteria1(itapConfigDTO.getFtCriteria1());
				itapConfigDTO1.setFtQalityGate2(itapConfigDTO.getFtQalityGate2());
				itapConfigDTO1.setFtCriteria2(itapConfigDTO.getFtCriteria2());
				itapConfigDTO1.setFtQalityGate3(itapConfigDTO.getFtQalityGate3());
				itapConfigDTO1.setFtCriteria3(itapConfigDTO.getFtCriteria3());
				itapConfigDTOs.add(itapConfigDTO1);
			}
			// Job 9 TESTING FUNCTIONAL TESTING
			if (StringUtils.isNotEmpty(itapConfigDTO.getDcompare())) {
				ITAPConfigDTO itapConfigDTO1 = new ITAPConfigDTO();
				StringBuffer jobName = new StringBuffer(itapConfigDTO.getProjName());
				jobName.append("_DATACOMPARE_");
				jobName.append(itapConfigDTO.getJobName());
				itapConfigDTO1.setJobName(jobName + "");
				itapConfigDTOs.add(itapConfigDTO1);
			}

		}
		return itapConfigDTOs;
	}

	@Override
	public ITAPConfigDTO configurationEdit(String job, long serverId) throws ServiceException {
		try {
			ITAPConfigDTO itapConfigDTO = new ITAPConfigDTO();

			if (null != job) {
				// Read Job
				String jsonResponse = CreateJenkinsJob.readJob(
						itapJenkinsConfigService.getJenkinsUrl(serverId), job);

				itapConfigDTO.setSource("SVN");
				itapConfigDTO.setRepoUrl(StringUtils.substringBetween(jsonResponse, "<remote>",
						"</remote>"));
			}
			return itapConfigDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPProgressDTO> itapGetLast5Builds(String job, long serverId)
			throws ServiceException {
		try {
			List<ITAPProgressDTO> last5Buils = null;
			ITAPProgressDTO itapProgressDTO = null;
			/* Get Xml file from jenkins */
			String jsonResponse = CreateJenkinsJob.readAnyXmlFromJenkins(itapJenkinsConfigService
					.getJenkinsUrl(serverId) + "/job/" + job + "/api/xml/lastBuild");
			List<Integer> buildNo = new ArrayList<Integer>();
			String regexString = null;
			/* gives all number which present in <number>? </number> */
			Pattern p = Pattern.compile(Pattern.quote("<number>") + "(.*?)"
					+ Pattern.quote("</number>"));
			Matcher m = p.matcher(jsonResponse);
			while (m.find()) {
				regexString = m.group(1);
				buildNo.add(Integer.parseInt(regexString));
			}
			/* Remove duplicates */
			buildNo = new ArrayList<Integer>(new LinkedHashSet<Integer>(buildNo));
			/* Sort descending order */
			Collections.sort(buildNo, Collections.reverseOrder());
			/* gives top 5 or less if <5 */
			buildNo = buildNo.subList(0, 5 > buildNo.size() ? buildNo.size() : 5);

			if (0 < buildNo.size()) {
				last5Buils = new ArrayList<ITAPProgressDTO>();
			}
			/* Read Each job and add to List */
			for (Integer integer : buildNo) {

				jsonResponse = CreateJenkinsJob.readAnyXmlFromJenkins(itapJenkinsConfigService
						.getJenkinsUrl(serverId) + "/job/" + job + "/" + integer + "/api/xml");

				itapProgressDTO = new ITAPProgressDTO();

				regexString = null;
				// Build No
				p = Pattern.compile(Pattern.quote("<displayName>") + "(.*?)"
						+ Pattern.quote("</displayName>"));
				m = p.matcher(jsonResponse);
				while (m.find()) {
					regexString = m.group(1);
					itapProgressDTO.setJobNo(regexString);
				}
				// Full Name
				p = Pattern.compile(Pattern.quote("<fullDisplayName>") + "(.*?)"
						+ Pattern.quote("</fullDisplayName>"));
				m = p.matcher(jsonResponse);
				while (m.find()) {
					regexString = m.group(1);
					itapProgressDTO.setJobName(regexString);
				}
				// Status
				p = Pattern.compile(Pattern.quote("<result>") + "(.*?)"
						+ Pattern.quote("</result>"));
				m = p.matcher(jsonResponse);
				while (m.find()) {
					regexString = m.group(1);
					itapProgressDTO.setJobSts(regexString);
				}
				// Est Duration
				p = Pattern.compile(Pattern.quote("<estimatedDuration>") + "(.*?)"
						+ Pattern.quote("</estimatedDuration>"));
				m = p.matcher(jsonResponse);
				while (m.find()) {
					regexString = m.group(1);

					itapProgressDTO.setJobEstDuri(DateUtils.convertMilToMinandSec(regexString));
				}
				// Duration
				p = Pattern.compile(Pattern.quote("<duration>") + "(.*?)"
						+ Pattern.quote("</duration>"));
				m = p.matcher(jsonResponse);
				while (m.find()) {
					regexString = m.group(1);

					itapProgressDTO.setJobDuri(DateUtils.convertMilToMinandSec(regexString));
				}
				// Time
				p = Pattern.compile(Pattern.quote("<timestamp>") + "(.*?)"
						+ Pattern.quote("</timestamp>"));
				m = p.matcher(jsonResponse);
				while (m.find()) {
					regexString = m.group(1);
					itapProgressDTO.setJobTime(DateUtils.usingDateFormatter(Long
							.parseLong(regexString)));

				}

				// ConsoleUrl
				p = Pattern.compile(Pattern.quote("<url>") + "(.*?)" + Pattern.quote("</url>"));
				m = p.matcher(jsonResponse);
				while (m.find()) {
					regexString = m.group(1);
					itapProgressDTO.setJobConsoleUrl(regexString + "console");

				}

				last5Buils.add(itapProgressDTO);
			}

			return last5Buils;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPCrossBrowserTestsuite> getTestSuiteList(String folderPath) {
		List<ITAPCrossBrowserTestsuite> testSuiteList = new ArrayList<ITAPCrossBrowserTestsuite>();

		class GenericExtFilter implements FilenameFilter {
			private final String ext;

			public GenericExtFilter(final String ext) {
				this.ext = ext;
			}

			@Override
			public boolean accept(final File dir, final String name) {
				return name.endsWith(ext);
			}
		}

		final GenericExtFilter filter = new GenericExtFilter(".xls");

		try {
			File testSuiteFolder = new File(folderPath);
			if (folderPath != null) {
				final File[] testSuiteFiles = testSuiteFolder.listFiles(filter);
				if (testSuiteFiles != null) {
					final List<File> testSuiteFilesList = Arrays.asList(testSuiteFiles);

					for (final File testSuite : testSuiteFilesList) {
						ITAPCrossBrowserTestsuite itapCrossBrow = new ITAPCrossBrowserTestsuite();
						final jxl.Workbook workBook = jxl.Workbook.getWorkbook(testSuite);
						List<String> tabNames = Arrays.asList(workBook.getSheetNames());
						String fileName = testSuite.getName().split(".xls")[0];
						itapCrossBrow.setTestSuiteName(fileName);
						itapCrossBrow.setTestCaseNameList(tabNames);
						testSuiteList.add(itapCrossBrow);
					}
				}
			}
			return testSuiteList;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return testSuiteList;
	}

	@Override
	public List<String> getTestCaseListForTestSuite(String folderPath, String testSuiteName) {
		List<String> testCaseList = new ArrayList<String>();

		class GenericExtFilter implements FilenameFilter {
			private final String ext;

			public GenericExtFilter(final String ext) {
				this.ext = ext;
			}

			@Override
			public boolean accept(final File dir, final String name) {
				return name.endsWith(ext);
			}
		}

		final GenericExtFilter filter = new GenericExtFilter(".xls");

		try {
			File testSuiteFolder = new File(folderPath);
			if (folderPath != null) {
				final File[] testSuiteFiles = testSuiteFolder.listFiles(filter);
				final List<File> testSuiteFilesList = Arrays.asList(testSuiteFiles);

				for (final File testSuite : testSuiteFilesList) {
					ITAPCrossBrowserTestsuite itapCrossBrow = new ITAPCrossBrowserTestsuite();
					final jxl.Workbook workBook = jxl.Workbook.getWorkbook(testSuite);
					List<String> tabNames = Arrays.asList(workBook.getSheetNames());
					String fileName = testSuite.getName().split(".xls")[0];
					if (fileName.equals(testSuiteName)) {
						testCaseList.addAll(tabNames);
					}
				}
			}
			return testCaseList;
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return testCaseList;
	}

	@Override
	public List<ITAPCrossBrowserGridDO> getGidList() throws ServiceException {
		List<ITAPCrossBrowserGridDO> itapCrossBrowserGridList = new ArrayList<ITAPCrossBrowserGridDO>();
		try {
			EntityManager managerUser = openUserEntityManager();
			itapCrossBrowserGridList = itapCrossBrowserGridDAO.getGridList(managerUser);
			closeUserEntityManager(managerUser);
			return itapCrossBrowserGridList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPCrossBrowserOS> getOSList() throws ServiceException {
		List<ITAPCrossBrowserOS> itapCrossBrowserOSList = new ArrayList<ITAPCrossBrowserOS>();
		try {
			EntityManager managerUser = openUserEntityManager();
			itapCrossBrowserOSList = itapCrossBrowserOSDAO.getOsList(managerUser);
			closeUserEntityManager(managerUser);
			return itapCrossBrowserOSList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getBrowserList(final int osId) throws ServiceException {
		Set<String> setRet = new HashSet<String>();
		try {
			EntityManager managerUser = openUserEntityManager();
			List<ITAPCrossBrowserOptions> itapCrossBrowserOptionList = itapCrossBrowserOptionsDAO
					.getBrowserList(managerUser, osId);
			closeUserEntityManager(managerUser);
			for (ITAPCrossBrowserOptions obj : itapCrossBrowserOptionList) {
				setRet.add(obj.getBrowserName());
			}

			List<String> listStr = new ArrayList<String>();
			listStr.addAll(setRet);
			return listStr;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getBrowserList(int osId, String browserName) throws ServiceException {
		List<String> versionList = new ArrayList<String>();
		try {
			EntityManager managerUser = openUserEntityManager();
			List<ITAPCrossBrowserOptions> itapCrossBrowserOptionList = itapCrossBrowserOptionsDAO
					.getBrowserList(managerUser, osId, browserName);
			closeUserEntityManager(managerUser);
			for (ITAPCrossBrowserOptions obj : itapCrossBrowserOptionList) {
				versionList.add(obj.getBrowserVersion());
			}
			return versionList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPTrainViewDTO> configurationTrainView(int offSet, int recordsperpage, boolean b,
			String userId, ITAPTrainViewDTO itapTrainViewDTO) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			List<ITAPTrainViewDTO> itapTrainViewDTOs = itapConfigMapper
					.convertFromITAPTrainViewDOsToITAPTrainViewDTOs(itapConfigDAO
							.configurationTrainView(managerUser, userId));
			closeUserEntityManager(managerUser);

			return itapTrainViewDTOs;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String deleteTrain(String id, String job, long serverId) throws ServiceException {
		try {
			String jobs[] = job.split(",");
			for (int i = 0; i < jobs.length; i++) {
				deleteConfiguration(jobs[i] + "", serverId);
			}

			EntityManager managerUser = openUserEntityManager();
			String str = itapConfigDAO.deleteTrain(id, managerUser);
			closeUserEntityManager(managerUser);

			return str;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPToolTestCaseDO> getTestCaseList(String toolName, String toolColumn,
			String toolColumnValue) throws ServiceException {
		List<ITAPToolTestCaseDO> testCaseList = new ArrayList<ITAPToolTestCaseDO>();
		try {
			EntityManager managerUser = openUserEntityManager();
			testCaseList = itapToolTestCaseDAO.getITAPToolTestCaseDOList(managerUser, toolName,
					toolColumn, toolColumnValue);
			closeUserEntityManager(managerUser);
			return testCaseList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> allEnvs() throws ServiceException {
		try {
			List<String> allEnv = new ArrayList<String>();
			EntityManager managerUser = openUserEntityManager();
			List<ITAPEnvDtlDO> allEnvs = itapConfigDAO.getAllEnvs(managerUser);
			closeUserEntityManager(managerUser);
			for (ITAPEnvDtlDO remsEnvDtlDO : allEnvs) {
				allEnv.add(remsEnvDtlDO.getEnvId());
			}
			// TODO
			return allEnv;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public ITAPSearchBookingDTO checkEnvAvilability(String envId) throws ServiceException {
		ITAPSearchBookingDTO remsSearchBookingDTO = new ITAPSearchBookingDTO();
		try {
			EntityManager managerUser = openUserEntityManager();

			ITAPEnvDtlDO remsEnvDtlDO = null;
			List<ITAPBookDtlDO> remsBookDtlDOs = null;

			/** Get App and env which is passed to ITAPEnvDtlDO */
			remsEnvDtlDO = itapConfigDAO.getEnv(envId, managerUser);

			remsBookDtlDOs = itapConfigDAO.getBookedEnv(envId, managerUser);
			/** Get 30 Days Dates */
			List<String> dates = CalendarDateUtils.getMonthCalDates(null);
			/** Place all 3 into remsSearchBookingDTO */
			remsSearchBookingDTO = itapConfigMapper.getFinalCalView(remsEnvDtlDO, remsBookDtlDOs,
					dates, remsSearchBookingDTO);

			closeUserEntityManager(managerUser);

			return remsSearchBookingDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getToolColumnValues(String toolName, String toolColumn)
			throws ServiceException {
		List<String> toolColumnValues = new ArrayList<String>();
		EntityManager managerUser = openUserEntityManager();
		try {

			toolColumnValues = itapToolTestCaseDAO.getToolColumnValues(managerUser, toolName,
					toolColumn);
			closeUserEntityManager(managerUser);
			if (toolColumnValues.size() > 0) {
				Set<String> toolColumnValueSet = new HashSet<String>(toolColumnValues);
				toolColumnValueSet.remove(null);
				return new ArrayList<String>(toolColumnValueSet);
			} else {
				return toolColumnValues;
			}
		} catch (NullPointerException nullPointerEx) {
			closeUserEntityManager(managerUser);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			closeUserEntityManager(managerUser);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPToolTestCaseDO> toolBasedTestCasesList(String toolName) throws ServiceException {
		List<ITAPToolTestCaseDO> toolBasedTestCasesList = new ArrayList<ITAPToolTestCaseDO>();
		EntityManager managerUser = openUserEntityManager();
		try {

			toolBasedTestCasesList = itapToolTestCaseDAO.toolBasedTestCasesList(managerUser,
					toolName);
			closeUserEntityManager(managerUser);
			return toolBasedTestCasesList;
		} catch (Exception e) {
			closeUserEntityManager(managerUser);
			return new ArrayList<ITAPToolTestCaseDO>();
		}
	}

	@Override
	public List<String> optikTestSuiteList() throws ServiceException {
		List<String> optikTestSuiteList = new ArrayList<String>();
		EntityManager managerUser = openUserEntityManager();
		try {

			optikTestSuiteList = itapToolTestCaseDAO.optikTestSuiteList(managerUser);
			closeUserEntityManager(managerUser);
			return optikTestSuiteList;
		} catch (Exception e) {
			closeUserEntityManager(managerUser);
			return new ArrayList<String>();
		}
	}

	@Override
	public List<ITAPToolTestCaseDO> getOTCForSeleTS(String testSuite) throws ServiceException {
		List<ITAPToolTestCaseDO> oTCListForSeleTS = new ArrayList<ITAPToolTestCaseDO>();
		try {
			EntityManager managerUser = openUserEntityManager();
			oTCListForSeleTS = itapToolTestCaseDAO.getOTCForSeleTS(managerUser, testSuite);
			closeUserEntityManager(managerUser);
			return oTCListForSeleTS;
		} catch (Exception e) {
			return new ArrayList<ITAPToolTestCaseDO>();
		}
	}

	@Override
	public List<String> getOTCForSeleTS(String toolColumnName, String testSuite)
			throws ServiceException {
		List<String> colValueList = new ArrayList<String>();
		try {
			EntityManager managerUser = openUserEntityManager();
			colValueList = itapToolTestCaseDAO.getOTCForSeleTS(managerUser, testSuite,
					toolColumnName);
			closeUserEntityManager(managerUser);
			return colValueList;
		} catch (Exception e) {
			return new ArrayList<String>();
		}
	}

	@Override
	public List<ITAPToolTestCaseDO> getTestCaseList(String toolName, String toolColumn,
			String toolColumnValue, String testSuite) throws ServiceException {
		List<ITAPToolTestCaseDO> testCaseList = new ArrayList<ITAPToolTestCaseDO>();
		try {
			EntityManager managerUser = openUserEntityManager();
			testCaseList = itapToolTestCaseDAO.getITAPToolTestCaseDOList(managerUser, toolName,
					toolColumn, toolColumnValue, testSuite);
			closeUserEntityManager(managerUser);
			return testCaseList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getDeviceNameList(int gridUrlId) throws ServiceException {
		List<String> deviceNameList = new ArrayList<String>();
		try {
			EntityManager managerUser = openUserEntityManager();
			deviceNameList = itapToolTestCaseDAO.getDeviceNameList(managerUser, gridUrlId);
			closeUserEntityManager(managerUser);
			return deviceNameList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getDeviceListForGivenDeviceName(String deviceName, int gridId)
			throws ServiceException {
		List<String> deviceList = new ArrayList<String>();
		try {
			EntityManager managerUser = openUserEntityManager();
			deviceList = itapToolTestCaseDAO.getDeviceListForGivenDeviceName(managerUser,
					deviceName, gridId);
			closeUserEntityManager(managerUser);
			return deviceList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPCrossBrowserGridDO> fetchUrlsForGridType(String gridType)
			throws ServiceException {
		List<ITAPCrossBrowserGridDO> gridUrlList = new ArrayList<ITAPCrossBrowserGridDO>();
		try {
			EntityManager managerUser = openUserEntityManager();
			gridUrlList = itapToolTestCaseDAO.fetchUrlsForGridType(managerUser, gridType);
			closeUserEntityManager(managerUser);
			return gridUrlList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getTestCaseListByJobsNames(List<String> lstJobs) throws ServiceException {
		// TODO Auto-generated method stub
		List<String> testCaseList = new ArrayList<String>();
		try {
			EntityManager managerUser = openUserEntityManager();
			List<ITAPConfigDO> testCases = itapConfigDAO.getAllTestcasesIdByJobs(managerUser,
					lstJobs);
			for (ITAPConfigDO dos : testCases) {
				if (StringUtils.isNotEmpty(dos.getTestCase()))
					testCaseList.add(dos.getTestCase());
			}
			closeUserEntityManager(managerUser);
			return testCaseList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPConfigDTO> configurationViewTeamCity(ITAPConfigDTO itapConfigDTO)
			throws ServiceException {
		try {
			List<ITAPConfigDTO> itapConfigDTOs = null;
			List<String> jobs = CreateTeamCityJob.allListProjectJobs(itapJenkinsConfigService
					.getJenkinsUrl(itapConfigDTO.getServerId()));
			;

			/*
			 * List<String> jobs[] = CreateTeamCityJob
			 * .allListProjectJobs("http://in-pnq-coe30:11000/");
			 */
			// CreateTeamCityJob.listProjectJobs("http://in-pnq-coe30:11000/",
			// "Cyc01");
			// System.out.println("Jobs :  " + jobs);

			itapConfigDTOs = new ArrayList<ITAPConfigDTO>();

			try {
				for (String job : jobs) {

					itapConfigDTO = new ITAPConfigDTO();

					Pattern p = Pattern.compile("\"([^\"]*)\"");
					Matcher m = p.matcher(job);
					int i = 0;
					while (m.find()) {
						switch (i) {
						case 0:
							itapConfigDTO.setJobName1(m.group(1));
							break;
						case 1:
							itapConfigDTO.setJobName(m.group(1));
							break;
						case 2:
							itapConfigDTO.setApiTest(m.group(1));
							break;
						default:
							break;
						}
						i++;
					}
					itapConfigDTOs.add(itapConfigDTO);
					i = 0;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return itapConfigDTOs;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String configurationJobBuildTeamCity(String id, long serverId) throws ServiceException {
		try {
			String jobs = CreateTeamCityJob.buildJobNormal1(
					itapJenkinsConfigService.getJenkinsUrl(serverId), id);

			return jobs;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPTrainViewDO> getJobsByProjectName(String projectName) {
		// TODO Auto-generated method stub
		EntityManager managerUser = openUserEntityManager();
		List<ITAPTrainViewDO> list = itapConfigDAO.getJobsByProjectName(managerUser, projectName);
		closeUserEntityManager(managerUser);
		return list;
	}

	@Override
	public String getTrainJob(String trainId, long serverId) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String jobDetails = itapConfigDAO.getTrainJobs(trainId, managerUser);

			closeUserEntityManager(managerUser);
			return jobDetails;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}

	}

	@Override
	public JenkinsConfigDO getCiDetails(long id) throws ServiceException {
		JenkinsConfigDO jenkinDo = itapJenkinsConfigService.getCiData(id);
		return jenkinDo;
	}

}
