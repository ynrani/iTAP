package com.itap.service;

import com.itap.exception.ServiceException;
import com.itap.model.DTO.ITAPBuildTrainDTO;

public interface ITAPBuildTrainService {

	String buildTrain(ITAPBuildTrainDTO itapBuildTrainDTO) throws ServiceException;

}
