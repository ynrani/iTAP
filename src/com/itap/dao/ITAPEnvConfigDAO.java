package com.itap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPEnvConfigDO;
import com.itap.model.DO.JenkinsConfigDO;

public interface ITAPEnvConfigDAO {

	public ITAPEnvConfigDO selectStsConfigToEdit(String id, EntityManager managerUser)
			throws DAOException;

	public String saveEnvConfigDetails(ITAPEnvConfigDO itapEnvConfigDO, EntityManager managerUser)
			throws DAOException;

	public JenkinsConfigDO selectJenkinConfigToEdit(String id, EntityManager managerUser)
			throws DAOException;

	public String saveJenkinConfigDetails(JenkinsConfigDO jenkinsConfigDO, EntityManager managerUser)
			throws DAOException;

	public List<JenkinsConfigDO> getAllCiEngine(EntityManager managerApp) throws DAOException;

	JenkinsConfigDO selectCiEngine(long id, EntityManager managerUser) throws DAOException;

	public String saveJenkinListConfigDetails(List<JenkinsConfigDO> jenkinsConfigDoList,
			EntityManager managerUser) throws DAOException;

	public String deleteConfigDetails(String cIId, EntityManager managerUser) throws DAOException;
}
