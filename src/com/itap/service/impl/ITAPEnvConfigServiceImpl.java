/*---------------------------------------------------------------------------------------
 * Object Name: ITAPEnvConfigServiceImpl.Java
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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPEnvConfigDAO;
import com.itap.exception.DAOException;
import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPEnvConfigDO;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.model.DTO.ITAPEnvConfigDTO;
import com.itap.model.DTO.JenkinsConfigDTO;
import com.itap.model.mapper.ITAPEnvConfigMapper;
import com.itap.service.ITAPEnvConfigService;

@Component
@Service("itapEnvConfigService")
@Transactional(propagation = Propagation.REQUIRED)
public class ITAPEnvConfigServiceImpl extends ITAPBaseServiceImpl implements ITAPEnvConfigService {
	private static Logger LOGGER = Logger.getLogger(ITAPEnvConfigServiceImpl.class);

	@Autowired
	ITAPEnvConfigDAO itapEnvConfigDAO;

	@Autowired
	ITAPEnvConfigMapper itapEnvConfigMapper;

	@Override
	public ITAPEnvConfigDTO selectEnvConfigToEdit(String id, ITAPEnvConfigDTO itapEnvConfigDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			itapEnvConfigDTO = itapEnvConfigMapper.convertFromITAPEnvConfigDOToITAPEnvConfigDTO(
					itapEnvConfigDAO.selectStsConfigToEdit(id, managerUser), itapEnvConfigDTO);
			closeUserEntityManager(managerUser);
			return itapEnvConfigDTO;
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
	public String saveEnvConfigDetails(ITAPEnvConfigDTO itapEnvConfigDTO) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String sts = itapEnvConfigDAO.saveEnvConfigDetails(itapEnvConfigMapper
					.convertFromITAPEnvConfigDTOToITAPEnvConfigDO(itapEnvConfigDTO,
							new ITAPEnvConfigDO()), managerUser);
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
	public JenkinsConfigDTO selectJenkinConfigToEdit(String id, JenkinsConfigDTO jenkinsConfigDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();

			List<JenkinsConfigDO> list = itapEnvConfigDAO.getAllCiEngine(managerUser);

			List<JenkinsConfigDTO> jenkinsDTOlist = new ArrayList<JenkinsConfigDTO>();
			jenkinsConfigDTO.setJenkinsDTOList(jenkinsDTOlist);

			itapEnvConfigMapper
					.convertFromJenkinsConfigDOToJenkinsConfigDTO(list, jenkinsConfigDTO);

			// list of data
			/*
			 * jenkinsConfigDTO =
			 * itapEnvConfigMapper.convertFromJenkinsConfigDOToJenkinsConfigDTO(
			 * itapEnvConfigDAO.selectCiEngine(jenkinsConfigDTO.getJenkinsId(),
			 * managerUser), jenkinsConfigDTO);
			 */

			closeUserEntityManager(managerUser);
			return jenkinsConfigDTO;
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
	public String saveJenkinConfigDetails(JenkinsConfigDTO jenkinsConfigDTO)
			throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			List<JenkinsConfigDTO> jenkinsConfigDTOList = jenkinsConfigDTO.getJenkinsDTOList();
			String sts = "";
			for (JenkinsConfigDTO dto : jenkinsConfigDTOList) {
				sts = itapEnvConfigDAO.saveJenkinConfigDetails(itapEnvConfigMapper
						.convertFromJenkinsConfigDTOToJenkinsConfigDO(dto, new JenkinsConfigDO()),
						managerUser);
			}
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
	public List<JenkinsConfigDO> getAllCiEngines() throws ServiceException {

		try {
			EntityManager managerUser = openUserEntityManager();
			// EntityManager managerUser = openUserEntityManager();
			List<JenkinsConfigDO> list = itapEnvConfigDAO.getAllCiEngine(managerUser);
			closeUserEntityManager(managerUser);
			return list;
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

		// return null;
	}

	@Override
	public String deleteCiConfigDetails(String id) throws ServiceException {
		try {
			EntityManager managerUser = openUserEntityManager();
			String result = itapEnvConfigDAO.deleteConfigDetails(id, managerUser);
			closeUserEntityManager(managerUser);
			return result;

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
