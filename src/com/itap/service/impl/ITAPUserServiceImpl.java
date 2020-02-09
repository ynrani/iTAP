/*---------------------------------------------------------------------------------------
 * Object Name: ITAPUserController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          26/02/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.itap.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPUserDAO;
import com.itap.exception.DAOException;
import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPUserAppAccessDO;
import com.itap.model.DO.ITAPUserDtlDO;
import com.itap.model.DTO.ITAPUserAppAccessDTO;
import com.itap.model.DTO.ITAPUserDtlDTO;
import com.itap.model.mapper.ITAPUserDtlMapper;
import com.itap.service.ITAPUserService;

@Component
@Service("itapUserService")
@Transactional(propagation = Propagation.REQUIRED)
public class ITAPUserServiceImpl extends ITAPBaseServiceImpl implements ITAPUserService {
	private static Logger LOGGER = Logger.getLogger(ITAPUserServiceImpl.class);

	@Autowired
	ITAPUserDAO itapUserDAO;

	@Autowired
	ITAPUserDtlMapper itapUserDtlMapper;

	@Override
	public ITAPUserDtlDTO selectUserToEdit(String id, ITAPUserDtlDTO itapUserDtlDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			itapUserDtlDTO = itapUserDtlMapper.convertFromITAPUserDtlDOToITAPUserDtlDTO(
					itapUserDAO.selectUserToEdit(id, managerUser), itapUserDtlDTO);
			closeUserEntityManager(managerUser);
			return itapUserDtlDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String saveUserDetails(ITAPUserDtlDTO itapUserDtlDTO) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String sts = itapUserDAO.saveUserDetails(itapUserDtlMapper
					.convertFromITAPUserDtlDTOToITAPUserDtlDO(itapUserDtlDTO, new ITAPUserDtlDO()),
					managerUser);
			closeUserEntityManager(managerUser);
			return sts;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long itapViewUserCnt(String userId, ITAPUserDtlDTO itapUserDtlDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			Long cnt = itapUserDAO.itapViewUserCnt(userId, itapUserDtlDTO, managerUser);
			closeUserEntityManager(managerUser);
			return cnt;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPUserDtlDTO> itapViewUser(int offSet, int recordsperpage, boolean b,
			String userId, ITAPUserDtlDTO itapUserDtlDTO) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			List<ITAPUserDtlDTO> itapUserDtlDTOs = itapUserDtlMapper
					.converITAPUserDtlDOsToITAPUserDtlDTOs(itapUserDAO.itapViewUser(offSet,
							recordsperpage, b, userId, itapUserDtlDTO, managerUser));
			closeUserEntityManager(managerUser);
			return itapUserDtlDTOs;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String daleteUser(String id) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String str = itapUserDAO.daleteUser(id, managerUser);
			closeUserEntityManager(managerUser);
			return str;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

/*	@Override
	public ITAPUserAppAccessDTO selectUserAccessToEdit(String id,
			ITAPUserAppAccessDTO itapUserAppAccessDTO) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			itapUserAppAccessDTO = itapUserDtlMapper
					.convertFromITAPUserAppAccessDOToITAPUserAppAccessDTO(
							itapUserDAO.selectUserAccessToEdit(id, managerUser),
							itapUserAppAccessDTO);
			closeUserEntityManager(managerUser);
			return itapUserAppAccessDTO;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String saveUserAccessDetails(ITAPUserAppAccessDTO itapUserAppAccessDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String sts = itapUserDAO.saveUserAccessDetails(itapUserDtlMapper
					.convertFromITAPUserAppAccessDTOToITAPUserAppAccessDO(itapUserAppAccessDTO,
							new ITAPUserAppAccessDO()), managerUser);
			closeUserEntityManager(managerUser);
			return sts;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long itapViewAllocAppCnt(String userId, ITAPUserAppAccessDTO itapUserAppAccessDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			Long cnt = itapUserDAO.itapViewAllocAppCnt(userId, itapUserAppAccessDTO, managerUser);
			closeUserEntityManager(managerUser);
			return cnt;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPUserAppAccessDTO> itapViewAllocApp(int offSet, int recordsperpage, boolean b,
			String userId, ITAPUserAppAccessDTO itapUserAppAccessDTO) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			List<ITAPUserAppAccessDTO> itapUserAppAccessDTOs = itapUserDtlMapper
					.convertFromITAPUserAppAccessDOsToITAPUserAppAccessDTOs(itapUserDAO
							.itapViewAllocApp(offSet, recordsperpage, b, userId,
									itapUserAppAccessDTO, managerUser));
			closeUserEntityManager(managerUser);
			return itapUserAppAccessDTOs;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String daleteAllocApp(String id) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String str = itapUserDAO.daleteAllocApp(id, managerUser);
			closeUserEntityManager(managerUser);
			return str;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String itapCheckAllApp(String appId, String userId) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String msg = itapUserDAO.itapCheckAllApp(appId, userId, managerUser);
			closeUserEntityManager(managerUser);
			return msg;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String itapCheckUserAvail(String userId) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String msg = itapUserDAO.itapCheckUserAvail(userId, managerUser);
			closeUserEntityManager(managerUser);
			return msg;
		} catch (NullPointerException nullPointerEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (DAOException daoEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			// releaseEntityMgrForRollback(entityManager);
			throw new ServiceException(ITAPConstants.SERVICE_EXCEPTION, otherEx);
		}
	}
*/
}
