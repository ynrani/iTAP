package com.itap.alm.service;

import java.util.HashMap;

import com.itap.alm.beans.RestConnector;

public interface AlmIntegrationService {

	public int createNewDefect(RestConnector restConnector, final HashMap<String, String> fieldMap,String rootPath)throws Exception;
	
	public String createEntity(final RestConnector connector, final String collectionUrl, final String postedEntityXml)throws Exception;
	
}
