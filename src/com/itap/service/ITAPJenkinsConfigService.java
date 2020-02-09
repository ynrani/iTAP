package com.itap.service;

import com.itap.exception.ServiceException;
import com.itap.model.DO.JenkinsConfigDO;

public interface ITAPJenkinsConfigService {

	String getJenkinsUrl(long id) throws ServiceException;

	JenkinsConfigDO getCiData(long id) throws ServiceException;

}
