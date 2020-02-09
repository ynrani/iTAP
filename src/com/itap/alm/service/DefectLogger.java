package com.itap.alm.service;

import java.util.HashMap;
import java.util.List;

import com.itap.alm.beans.ExcelMappingDO;
import com.itap.alm.beans.RestConnector;
import com.itap.model.DTO.ITAPDefectDTO;

public interface DefectLogger {
	public ITAPDefectDTO readXmlAndRaiseDefect(final ITAPDefectDTO autoDefectDTO, final HashMap<String, String> fieldMap,
			final List<ExcelMappingDO> excelMappingDOList, final RestConnector restConnector,final String rootPath);
	
	
}
