package com.itap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPBookDtlDO;
import com.itap.model.DO.ITAPConfigDO;
import com.itap.model.DO.ITAPEnvDtlDO;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DTO.ITAPConfigDTO;

public interface ITAPConfigDAO {

	public List<ITAPTrainViewDO> getJobsByProjectName(EntityManager managerApp, String porjectName);

	public ITAPConfigDO selectConfigToEdit(String id, EntityManager managerUser)
			throws DAOException;

	public ITAPConfigDO saveConfigDetails(ITAPConfigDO itapConfigDO, EntityManager managerUser)
			throws DAOException;

	public Long configurationViewCnt(String userId, ITAPConfigDTO itapConfigDTO,
			EntityManager managerUser) throws DAOException;

	public List<ITAPConfigDO> configurationView(int offSet, int recordsperpage, boolean b,
			String userId, ITAPConfigDTO itapConfigDTO, EntityManager managerUser)
			throws DAOException;

	public String deleteConfiguration(String id, EntityManager managerUser) throws DAOException;

	public List<String> allProjs(EntityManager managerUser) throws DAOException;

	public String saveTrainDetails(ITAPTrainViewDO itapTrainViewDO, EntityManager managerUser)
			throws DAOException;

	public List<ITAPTrainViewDO> configurationTrainView(EntityManager managerUser, String userId)
			throws DAOException;

	public String deleteTrain(String id, EntityManager managerUser) throws DAOException;

	List<ITAPEnvDtlDO> getAllEnvs(EntityManager managerEnv) throws DAOException;

	public ITAPEnvDtlDO getEnv(String envId, EntityManager managerUser) throws DAOException;

	public List<ITAPBookDtlDO> getBookedEnv(String envId, EntityManager managerUser)
			throws DAOException;

	List<ITAPConfigDO> getAllTestcasesIdByJobs(EntityManager managerUser, List<String> lstJobs)
			throws DAOException;

	public String getTrainJobs(String trainId, EntityManager managerUser) throws DAOException;

}
