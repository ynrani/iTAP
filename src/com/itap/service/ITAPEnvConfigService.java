package com.itap.service;

import java.util.List;

import com.itap.exception.ServiceException;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.model.DTO.ITAPEnvConfigDTO;
import com.itap.model.DTO.JenkinsConfigDTO;

public interface ITAPEnvConfigService {

	ITAPEnvConfigDTO selectEnvConfigToEdit(String id, ITAPEnvConfigDTO itapEnvConfigDTO)
			throws ServiceException;

	String deleteCiConfigDetails(String id) throws ServiceException;

	String saveEnvConfigDetails(ITAPEnvConfigDTO itapEnvConfigDTO) throws ServiceException;

	JenkinsConfigDTO selectJenkinConfigToEdit(String id, JenkinsConfigDTO jenkinsConfigDTO)
			throws ServiceException;

	String saveJenkinConfigDetails(JenkinsConfigDTO jenkinsConfigDTO) throws ServiceException;

	List<JenkinsConfigDO> getAllCiEngines() throws ServiceException;
}
