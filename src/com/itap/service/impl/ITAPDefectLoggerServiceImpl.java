package com.itap.service.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.itap.alm.beans.*;
import com.itap.alm.service.DefectLogger;
import com.itap.alm.service.FieldMappingInitializer;
import com.itap.alm.service.RestConnectorInitializer;
import com.itap.constant.AlmConstants;
import com.itap.dao.ITAPEnvConfigDAO;
import com.itap.model.DO.ITAPEnvConfigDO;
import com.itap.model.DTO.ITAPDefectDTO;
import com.itap.model.DTO.ITAPToolDefects;
import com.itap.service.ITAPDefectLoggerService;

@Component
@Service("itapDefectLoggerService")
public class ITAPDefectLoggerServiceImpl implements
		ITAPDefectLoggerService{
	
	private static final Logger LOGGER = Logger.getLogger(ITAPDefectLoggerServiceImpl.class);
	
	@Autowired
	RestConnectorInitializer restConnectorInitializer;

	@Autowired
	FieldMappingInitializer fieldMappingInitializer;

	@Autowired
	DefectLogger defectLogger;
	
	@Autowired
	ITAPEnvConfigDAO itapEnvConfigDAO;
	
	@Override
	public List<ITAPToolDefects> getDefectsList() {
		List<ITAPToolDefects> toolDefectList = new ArrayList<ITAPToolDefects>();
		try {

			String itapDefectFolderURL = "\\\\"
					+ AlmConstants.SERVER_MACHINE_NAME + File.separator
					+ AlmConstants.SERVER_AUTOHUB_FOLDER + File.separator
					+ AlmConstants.SERVER_AUTOHUB_ROOT_FOLDER + File.separator
					+ AlmConstants.SERVER_PROJECT_FOLDER;

			final File projectFolder = new File(itapDefectFolderURL);

			final File[] subFoldersOfProject = projectFolder.listFiles();
			final List<File> fileList = new ArrayList<File>(
					Arrays.asList(subFoldersOfProject));

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

			for (final File file : fileList) {
				if (file.isDirectory()) {
					final String thisProjectFolderPath = file.getPath();
					String toolFolderName = thisProjectFolderPath
							.substring(thisProjectFolderPath.lastIndexOf("\\"));
					toolFolderName = toolFolderName.replace("\\", "");
					System.out.println("TOOL : "+toolFolderName);

					ITAPToolDefects itapToolDefect = new ITAPToolDefects();
					itapToolDefect.setToolName(toolFolderName);
					itapToolDefect.setProjectName("CIA");

					final String xmlFolderPath = thisProjectFolderPath
							+ "\\XML";
					final File xmlFolder = new File(xmlFolderPath);

					final GenericExtFilter filter = new GenericExtFilter(".xml");
					final File[] thisProjectFolderFailureXMLS = xmlFolder
							.listFiles(filter);
					final List<File> defectXMLFileList = Arrays
							.asList(thisProjectFolderFailureXMLS);

					List<ITAPDefectDTO> defectList = new ArrayList<ITAPDefectDTO>();
					for (final File fXmlFile : defectXMLFileList) {

						final String filePath = fXmlFile.getPath();
						final String fileName = filePath.substring(filePath
								.lastIndexOf("\\"));
						System.out.println("IN FILE : "+fileName);

						final DocumentBuilderFactory dbFactory = DocumentBuilderFactory
								.newInstance();
						final DocumentBuilder dBuilder = dbFactory
								.newDocumentBuilder();
						Document doc = dBuilder.parse(fXmlFile);
						doc.getDocumentElement().normalize();

						String releaseNo = doc
								.getElementsByTagName("ReleaseNo").item(0)
								.getTextContent();
						String iterationNo = doc
								.getElementsByTagName("IterationNo").item(0)
								.getTextContent();
						String demandStoryNo = doc
								.getElementsByTagName(
										"DemandStoryNo_Or_Feature").item(0)
								.getTextContent();
						String environment = doc
								.getElementsByTagName("Environment").item(0)
								.getTextContent();
						String host = doc.getElementsByTagName("Host").item(0)
								.getTextContent();
						String os = doc.getElementsByTagName("OS").item(0)
								.getTextContent();
						String browser = doc.getElementsByTagName("Browser")
								.item(0).getTextContent();
						String user = doc.getElementsByTagName("User").item(0)
								.getTextContent();

						itapToolDefect.setReleaseNo(releaseNo);
						itapToolDefect.setIteration(iterationNo);
						itapToolDefect.setDemandStory(demandStoryNo);
						itapToolDefect.setEnvironment(environment);
						itapToolDefect.setHost(host);
						itapToolDefect.setOperatingSystem(os);
						itapToolDefect.setBrowser(browser);
						itapToolDefect.setUser(user);

						final NodeList nList1 = doc
								.getElementsByTagName("TestCases");
						for (int temp = 0; temp < nList1.getLength(); temp++) {
							final Node nNode = nList1.item(temp);
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {
								final Element eElement = (Element) nNode;
								final NodeList nList2 = eElement
										.getElementsByTagName("TestCase");
								for (int temp1 = 0; temp1 < nList2.getLength(); temp1++) {
									final Node nNode1 = nList2.item(temp1);
									if (nNode1.getNodeType() == Node.ELEMENT_NODE) {

										final Element eElement1 = (Element) nNode1;
										final NodeList nList3 = eElement1
												.getElementsByTagName("TC_Step");
										for (int temp2 = 0; temp2 < nList3
												.getLength(); temp2++) {
											final Node nNode2 = nList3
													.item(temp2);

											if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

												final String isApproved = eElement
														.getElementsByTagName(
																"Approved")
														.item(temp1)
														.getTextContent();
												final String isLogged = eElement
														.getElementsByTagName(
																"IsDefectLogged")
														.item(temp1)
														.getTextContent();

												if (isApproved.equals("N")
														|| (isApproved
																.equalsIgnoreCase("Y") && isLogged
																.equalsIgnoreCase("N"))) {

													String testCaseDescription = eElement
															.getElementsByTagName(
																	"TC_Description")
															.item(temp1)
															.getTextContent();
													String testCaseNumber = eElement
															.getElementsByTagName(
																	"TC_Number")
															.item(temp1)
															.getTextContent();
													String testCaseStatus = eElement
															.getElementsByTagName(
																	"TC_Exec_Status")
															.item(temp1)
															.getTextContent();
													String testCaseStepNumber = eElement1
															.getElementsByTagName(
																	"TC_Step_Number")
															.item(temp2)
															.getTextContent();
													String testCaseStepDescr = eElement1
															.getElementsByTagName(
																	"TC_Step_Description")
															.item(temp2)
															.getTextContent();
													String testCaseStepActDet = eElement1
															.getElementsByTagName(
																	"Actual_Details")
															.item(temp2)
															.getTextContent();
													String testCaseExpDet = eElement1
															.getElementsByTagName(
																	"Expected_Details")
															.item(temp2)
															.getTextContent();
													String testCaseStepResult = eElement1
															.getElementsByTagName(
																	"Step_Result")
															.item(temp2)
															.getTextContent();
													String screenshotPath = eElement1
															.getElementsByTagName(
																	"Step_Screnshot_FilePath")
															.item(temp2)
															.getTextContent();
													String testCaseStepMsgLog = eElement1
															.getElementsByTagName(
																	"step_exception_msglog")
															.item(temp2)
															.getTextContent();

													ITAPDefectDTO itapDefectDTO = new ITAPDefectDTO();
													itapDefectDTO
															.setToolName(toolFolderName);
													itapDefectDTO
															.setProjectName("CIA");
													itapDefectDTO
															.setDefectReportXmlName(fileName);
													itapDefectDTO
															.setTestCaseName(testCaseDescription);
													itapDefectDTO
															.setTestCaseNumber(testCaseNumber);

													itapDefectDTO
															.setTestCaseStatus(testCaseStatus);
													itapDefectDTO
															.setIsApproved(isApproved);
													itapDefectDTO
															.setLogDefect(isLogged);
													itapDefectDTO
															.setTestCaseStepDescription(testCaseStepDescr);
													itapDefectDTO
															.setTestCaseStepNumber(testCaseStepNumber);
													itapDefectDTO
															.setExpectedResults(testCaseExpDet);
													itapDefectDTO
															.setActualResults(testCaseStepActDet);
													itapDefectDTO
															.setStepResult(testCaseStepResult);
													itapDefectDTO
															.setStepExceptionLog(testCaseStepMsgLog);
													itapDefectDTO
															.setStepScreenshotPath(screenshotPath);
													defectList
															.add(itapDefectDTO);
												}
											}
										}
									}
								}
							}
						}
					}
					itapToolDefect.setDefectsList(defectList);
					toolDefectList.add(itapToolDefect);
				}
			}
			return toolDefectList;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getDefectsList method : "+e.getMessage());
			return toolDefectList;
		}
	}

	@Override
	public List<ITAPDefectDTO> logDefects(
			List<ITAPToolDefects> toolDefects) {
		List<ITAPDefectDTO> itapDefectDTOList = new ArrayList<ITAPDefectDTO>();
		try {
			for (ITAPToolDefects itapToolDefects : toolDefects) {
				itapDefectDTOList.addAll(raiseDefectForThisTool(itapToolDefects));
			}
		} catch (Exception e) {
			LOGGER.error("Error in logDefects method : "+e.getMessage());
		}
		return itapDefectDTOList;
	}

	private List<ITAPDefectDTO> raiseDefectForThisTool(ITAPToolDefects itapToolDefects) {
		String itapProjectFolderURL = "\\\\"
				+ AlmConstants.SERVER_MACHINE_NAME + File.separator
				+ AlmConstants.SERVER_AUTOHUB_FOLDER + File.separator
				+ AlmConstants.SERVER_AUTOHUB_ROOT_FOLDER + File.separator
				+ AlmConstants.SERVER_PROJECT_FOLDER;

		List<ITAPDefectDTO> itapDefectDTOList = new ArrayList<ITAPDefectDTO>();
		try {
			String excelMappingFile = itapToolDefects.getToolName()
					+ "_AlmMapping.xls";
			String excelMappingFilePath = itapProjectFolderURL
					+ File.separator + itapToolDefects.getToolName()
					+ File.separator + excelMappingFile;

			RestConnector restConnector = restConnectorInitializer
					.readRestConnectorMappingFromExcel(excelMappingFilePath);
			HashMap<String, String> fieldMaps = fieldMappingInitializer
					.getStaticFiedlMappingsFromExcel(excelMappingFilePath);
			List<ExcelMappingDO> mappingDOList = fieldMappingInitializer
					.getDynamicFieldMappingsFromExcel(excelMappingFilePath,
							"CIA");

			for (ITAPDefectDTO itapDefectDTO : itapToolDefects
					.getDefectsList()) {
				if (itapDefectDTO.getIsApproved().equalsIgnoreCase("Y")) {
					ITAPDefectDTO itapDefectDTOAfterLogged = defectLogger
							.readXmlAndRaiseDefect(itapDefectDTO, fieldMaps,
									mappingDOList, restConnector,itapProjectFolderURL);
					if (itapDefectDTOAfterLogged.getDefectId() > 0) {
						itapDefectDTOList.add(itapDefectDTOAfterLogged);
					}
				}
			}
			return itapDefectDTOList;
		} catch (Exception e) {
			LOGGER.error("Error in raiseDefectForThisTool method : "+e.getMessage());
			return new ArrayList<ITAPDefectDTO>();
		}
	}
}
