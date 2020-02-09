package com.itap.alm.service.impl;

import java.io.File;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.itap.alm.beans.*;
import com.itap.alm.service.RestConnectorInitializer;

@Component("restConnectorInitializer")
public class RestConnectorInitializerImpl implements RestConnectorInitializer{

	private static String CREDENTIAL_TAB_NAME = "ConnectivityCredentials";

	public RestConnector readRestConnectorMappingFromExcel(final String excelMappingFilePath) {
		final RestConnector restConnector = new RestConnector();
		try {
			final File mappingFile = new File(excelMappingFilePath);
			if (mappingFile != null) {
				final jxl.Workbook workBook = jxl.Workbook.getWorkbook(mappingFile);
				final jxl.Sheet sheet = workBook.getSheet(CREDENTIAL_TAB_NAME);
				final String userName = sheet.getCell(1, 0).getContents().trim();
				final String password = sheet.getCell(1, 1).getContents().trim();
				final String url = sheet.getCell(1, 2).getContents().trim();
				final String project = sheet.getCell(1, 3).getContents().trim();
				final String domain = sheet.getCell(1, 4).getContents().trim();

				restConnector.setUserName(userName);
				restConnector.setPassword(password);
				restConnector.setProject(project);
				restConnector.setDomain(domain);
				restConnector.setServerUrl(url);
				restConnector.setCookies(new HashMap<String, String>());
			}
			return restConnector;
		} catch (final Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
