package com.itap.service;

import java.util.List;

import com.itap.exception.BaseException;
import com.itap.model.DO.MasterSlaveDetailsDO;

public interface ITAPMasterSlaveService {

	public List<MasterSlaveDetailsDO> getAllMasterSlaveNodes() throws BaseException;

}
