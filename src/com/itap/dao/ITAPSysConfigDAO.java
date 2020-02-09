package com.itap.dao;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPConfAllFileDO;
import com.itap.model.DO.ITAPSysConfigDO;

public interface ITAPSysConfigDAO {

	public ITAPSysConfigDO selectStsConfigToEdit(String id, EntityManager managerUser)
			throws DAOException;

	public String saveSysConfigDetails(ITAPSysConfigDO itapSysConfigDO,
			EntityManager managerUser) throws DAOException;

	public ITAPConfAllFileDO configAllFilesGet(String id, EntityManager managerUser)
			throws DAOException;

	public String configAllFilesPost(
			ITAPConfAllFileDO convertFromITAPConfAllFilesDTOToITAPConfAllFileDO,
			EntityManager managerUser) throws DAOException;

}
