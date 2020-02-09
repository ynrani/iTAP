package com.itap.service;

import java.util.List;

import com.itap.model.DTO.ITAPDefectDTO;
import com.itap.model.DTO.ITAPToolDefects;

public interface ITAPDefectLoggerService {
	
	List<ITAPToolDefects> getDefectsList();
	
	List<ITAPDefectDTO> logDefects(List<ITAPToolDefects> toolDefects);
	
}
