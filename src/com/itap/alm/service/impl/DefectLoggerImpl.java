package com.itap.alm.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.itap.alm.beans.ExcelMappingDO;
import com.itap.alm.beans.RestConnector;
import com.itap.alm.service.DefectLogger;
import com.itap.constant.ALMFieldConstants;
import com.itap.constant.AlmConstants;
import com.itap.model.DTO.ITAPDefectDTO;
import com.itap.util.DateUtility;

@Component("defectLogger")
public class DefectLoggerImpl implements DefectLogger {

	@Autowired
	private MessageSource messageSource;

	@Override
	public ITAPDefectDTO readXmlAndRaiseDefect(ITAPDefectDTO autoDefectDTO,
			HashMap<String, String> fieldMap, List<ExcelMappingDO> excelMappingDOList,
			RestConnector restConnector, String rootPath) {

		final Logger LOGGER = Logger.getLogger(DefectLoggerImpl.class);

		String itapProjectFolderURL = "\\\\"
				+ messageSource.getMessage(AlmConstants.SERVER_MACHINE_NAME, null, null)
				+ File.separator
				+ messageSource.getMessage(AlmConstants.SERVER_AUTOHUB_FOLDER, null, null)
				+ File.separator
				+ messageSource.getMessage(AlmConstants.SERVER_AUTOHUB_ROOT_FOLDER, null, null)
				+ File.separator
				+ messageSource.getMessage(AlmConstants.SERVER_PROJECT_FOLDER, null, null);

		try {

			String xmlFilePath = itapProjectFolderURL + File.separator
					+ autoDefectDTO.getToolName() + File.separator + "XML" + File.separator
					+ autoDefectDTO.getDefectReportXmlName();
			File file = new File(xmlFilePath);

			if (file != null && file.exists()) {
				final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				final org.w3c.dom.Document doc = dBuilder.parse(file);
				doc.getDocumentElement().normalize();
				final NodeList testCaseNodes = doc
						.getElementsByTagName(ALMFieldConstants.REPORT_XML_TAGNAME_TESTCASE);
				for (int testCaseNodeCounter = 0; testCaseNodeCounter < testCaseNodes.getLength(); testCaseNodeCounter++) {

					final Node testCaseNode = testCaseNodes.item(testCaseNodeCounter);

					if (testCaseNode.getNodeType() == Node.ELEMENT_NODE) {
						final Element testCaseNodeElement = (Element) testCaseNode;

						final String thisTestCaseName = testCaseNodeElement
								.getElementsByTagName(ALMFieldConstants.TEST_CASE_DESCRIPTION_TAG)
								.item(0).getTextContent();

						final String testCaseStepNumber = testCaseNodeElement
								.getElementsByTagName(
										ALMFieldConstants.REPORT_XML_TESTCASE_STEP_NUMBER).item(0)
								.getTextContent();

						final String screenshotPath = rootPath
								+ testCaseNodeElement
										.getElementsByTagName(
												messageSource
														.getMessage(
																ALMFieldConstants.REPORT_XML_TESTCASE_SCREENSHOTPATH,
																null, null)).item(0)
										.getTextContent();

						if (thisTestCaseName.equals(autoDefectDTO.getTestCaseName())
								&& testCaseStepNumber.equals(autoDefectDTO.getTestCaseStepNumber())) {

							fieldMap.put(ALMFieldConstants.TEST_CASE_DESCRIPTION_TAG,
									thisTestCaseName);

							for (final ExcelMappingDO excelMappingDO : excelMappingDOList) {

								if (excelMappingDO.getFieldScopeType().equalsIgnoreCase(
										ALMFieldConstants.EXCEL_FIELD_SCOPE_TYPE_TESTCASE)
										|| excelMappingDO.getFieldScopeType().equalsIgnoreCase(
												ALMFieldConstants.EXCEL_FIELD_SCOPE_TYPE_TESTSTEP)) {

									final String xmlFieldName = excelMappingDO.getXmlFieldName();
									final String almFieldName = excelMappingDO.getAlmFieldName();

									if (testCaseNodeElement.getElementsByTagName(xmlFieldName)
											.getLength() > 0) {
										final String fieldValue = testCaseNodeElement
												.getElementsByTagName(xmlFieldName).item(0)
												.getTextContent();
										if (almFieldName
												.equals(ALMFieldConstants.ALM_XML_TAGNAME_DESCRIPTION)) {
											final String descValue = fieldMap
													.get(ALMFieldConstants.ALM_XML_TAGNAME_DESCRIPTION);
											if (descValue != null) {
												final String newDescriptionValue = descValue + ","
														+ xmlFieldName + "-" + fieldValue;
												fieldMap.put(almFieldName, newDescriptionValue);
											} else {
												fieldMap.put(almFieldName, fieldValue);
											}
										} else {
											fieldMap.put(almFieldName, fieldValue);
										}
									}
								}
							}

							final String testCaseName = fieldMap
									.get(ALMFieldConstants.TEST_CASE_DESCRIPTION_TAG);
							fieldMap.remove(ALMFieldConstants.TEST_CASE_DESCRIPTION_TAG);

							fieldMap.put("detected-by", restConnector.getUserName());
							fieldMap.put("creation-time", DateUtility.getCurrentDate("yyyy-MM-dd"));
							fieldMap.put("owner", restConnector.getUserName());

							final String defectName = autoDefectDTO.getToolName() + "-"
									+ testCaseName;
							fieldMap.put("name", defectName);

							final int retValue = raiseDefect(restConnector, fieldMap,
									screenshotPath);
							autoDefectDTO.setDefectId(retValue);

							if (retValue != 0) {
								final Element ele = (Element) testCaseNodeElement
										.getElementsByTagName(
												ALMFieldConstants.REPORT_XML_TAGNAME_IS_DEFECT_LOGGED)
										.item(0);
								ele.setTextContent(ALMFieldConstants.YES_CHAR);

								final Element eleApproved = (Element) testCaseNodeElement
										.getElementsByTagName(
												ALMFieldConstants.REPORT_XML_TAGNAME_APPROVED)
										.item(0);
								eleApproved.setTextContent(ALMFieldConstants.YES_CHAR);

								ele.setAttribute("defect-Id", String.valueOf(retValue));
								final TransformerFactory transformerFactory = TransformerFactory
										.newInstance();
								final javax.xml.transform.Transformer transformer = transformerFactory
										.newTransformer();
								final DOMSource source = new DOMSource(doc);
								final StreamResult consoleResult = new StreamResult(file);
								transformer.transform(source, consoleResult);
							}
						}
					}
				}
			}
		} catch (final Exception e) {
			LOGGER.error("Error in readXmlAndRaiseDefect method : " + e.getMessage());
			autoDefectDTO.setDefectId(0);
			return autoDefectDTO;
		}
		return autoDefectDTO;
	}

	private static int raiseDefect(final RestConnector restConnector,
			final HashMap<String, String> fieldMap, String screenshotPath) {
		int defectId = 0;
		try {
			new AlmAuthenticationImpl().login(restConnector);
			defectId = new AlmIntegrationServiceImpl().createNewDefect(restConnector, fieldMap,
					screenshotPath);
			return defectId;
		} catch (final Exception e) {
			return defectId;
		}
	}
}
