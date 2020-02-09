package com.itap.service;

import com.itap.exception.ServiceException;
import com.itap.model.DTO.ITAPConfAllFilesDTO;
import com.itap.model.DTO.ITAPSysConfigDTO;

public interface ITAPSysConfigService {

	ITAPSysConfigDTO selectSysConfigToEdit(String id, ITAPSysConfigDTO itapSysConfigDTO)
			throws ServiceException;

	String saveSysConfigDetails(ITAPSysConfigDTO itapSysConfigDTO) throws ServiceException;

	ITAPConfAllFilesDTO configAllFilesGet(String id,
			ITAPConfAllFilesDTO itapConfAllFilesDTO) throws ServiceException;

	String configAllFilesPost(String id, ITAPConfAllFilesDTO itapConfAllFilesDTO)
			throws ServiceException;

}
