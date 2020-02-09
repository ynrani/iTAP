package com.itap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPUserAppAccessDO;
import com.itap.model.DO.ITAPUserDtlDO;
import com.itap.model.DTO.ITAPUserDtlDTO;

public interface ITAPUserDAO {

	public ITAPUserDtlDO selectUserToEdit(String id, EntityManager managerUser) throws DAOException;

	public String saveUserDetails(ITAPUserDtlDO convertFromITAPUserDtlDTOToITAPUserDtlDO,
			EntityManager managerUser) throws DAOException;

	public Long itapViewUserCnt(String userId, ITAPUserDtlDTO itapUserDtlDTO,
			EntityManager managerUser) throws DAOException;

	public List<ITAPUserDtlDO> itapViewUser(int offSet, int recordsperpage, boolean b,
			String userId, ITAPUserDtlDTO itapUserDtlDTO, EntityManager managerUser)
			throws DAOException;

	public String daleteUser(String id, EntityManager managerUser) throws DAOException;

/*	public ITAPUserAppAccessDO selectUserAccessToEdit(String id, EntityManager managerUser)
			throws DAOException;

	public String saveUserAccessDetails(ITAPUserAppAccessDO itapUserAppAccessDO,
			EntityManager managerUser) throws DAOException;

	public Long itapViewAllocAppCnt(String userId, ITAPUserAppAccessDTO itapUserAppAccessDTO,
			EntityManager managerUser) throws DAOException;

	public List<ITAPUserAppAccessDO> itapViewAllocApp(int offSet, int recordsperpage, boolean b,
			String userId, ITAPUserAppAccessDTO itapUserAppAccessDTO, EntityManager managerUser)
			throws DAOException;

	public String daleteAllocApp(String id, EntityManager managerUser) throws DAOException;

	public String itapCheckAllApp(String appId, String userId, EntityManager managerUser)
			throws DAOException;

	public String itapCheckUserAvail(String userId, EntityManager managerUser) throws DAOException;
*/
}
