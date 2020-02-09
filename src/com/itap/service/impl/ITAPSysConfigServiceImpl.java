/*---------------------------------------------------------------------------------------
 * Object Name: ITAPSysConfigServiceImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          10/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.itap.service.impl;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPSysConfigDAO;
import com.itap.exception.DAOException;
import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPConfAllFileDO;
import com.itap.model.DO.ITAPSysConfigDO;
import com.itap.model.DTO.ITAPConfAllFilesDTO;
import com.itap.model.DTO.ITAPSysConfigDTO;
import com.itap.model.mapper.ITAPSysConfigMapper;
import com.itap.service.ITAPSysConfigService;

@Component
@Service("itapSysConfigService")
@Transactional(propagation = Propagation.REQUIRED)
public class ITAPSysConfigServiceImpl extends ITAPBaseServiceImpl implements ITAPSysConfigService {
	private static Logger LOGGER = Logger.getLogger(ITAPSysConfigServiceImpl.class);

	@Autowired
	ITAPSysConfigDAO itapSysConfigDAO;

	@Autowired
	ITAPSysConfigMapper itapSysConfigMapper;

	@Override
	public ITAPSysConfigDTO selectSysConfigToEdit(String id, ITAPSysConfigDTO itapSysConfigDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			itapSysConfigDTO = itapSysConfigMapper.convertFromITAPSysConfigDOToITAPSysConfigDTO(
					itapSysConfigDAO.selectStsConfigToEdit(id, managerUser), itapSysConfigDTO);
			closeUserEntityManager(managerUser);

			return itapSysConfigDTO;
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
	public String saveSysConfigDetails(ITAPSysConfigDTO itapSysConfigDTO) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String sts = itapSysConfigDAO.saveSysConfigDetails(itapSysConfigMapper
					.convertFromITAPSysConfigDTOToITAPSysConfigDO(itapSysConfigDTO,
							new ITAPSysConfigDO()), managerUser);
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
	public ITAPConfAllFilesDTO configAllFilesGet(String id, ITAPConfAllFilesDTO itapConfAllFilesDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			itapConfAllFilesDTO = itapSysConfigMapper
					.convertFromITAPConfAllFileDOToITAPConfAllFilesDTO(
							itapSysConfigDAO.configAllFilesGet(id, managerUser),
							itapConfAllFilesDTO);
			closeUserEntityManager(managerUser);
			return itapConfAllFilesDTO;
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
	public String configAllFilesPost(String id, ITAPConfAllFilesDTO itapConfAllFilesDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String sts = itapSysConfigDAO.configAllFilesPost(itapSysConfigMapper
					.convertFromITAPConfAllFilesDTOToITAPConfAllFileDO(itapConfAllFilesDTO,
							new ITAPConfAllFileDO()), managerUser);
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
}
