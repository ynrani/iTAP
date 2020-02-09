package com.itap.alm.service;

import java.util.HashMap;
import java.util.List;

import com.itap.alm.beans.ExcelMappingDO;

public interface FieldMappingInitializer {
	
	public HashMap<String, String> getStaticFiedlMappingsFromExcel(final String xmlMappingFilePath);
	
	public List<ExcelMappingDO> getDynamicFieldMappingsFromExcel(final String xmlMappingFilePath, final String projectName);
}
