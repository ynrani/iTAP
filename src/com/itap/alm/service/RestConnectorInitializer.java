package com.itap.alm.service;

import com.itap.alm.beans.RestConnector;

public interface RestConnectorInitializer {
	
	public RestConnector readRestConnectorMappingFromExcel(final String excelMappingFilePath);
}
