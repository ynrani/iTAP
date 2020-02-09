/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigServiceImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          03/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.itap.service.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPEnvConfigDAO;
import com.itap.exception.DAOException;
import com.itap.exception.ServiceException;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.service.ITAPJenkinsConfigService;

@Component
@Service("itapJenkinsConfigService")
@Transactional(propagation = Propagation.REQUIRED)
public class ITAPJenkinsConfigServiceImpl extends ITAPBaseServiceImpl implements
		ITAPJenkinsConfigService {

	@Autowired
	ITAPEnvConfigDAO itapEnvConfigDAO;

	@Override
	public String getJenkinsUrl(long id) throws ServiceException {
		try {

			EntityManager managerUser = openUserEntityManager();
			JenkinsConfigDO jenkinsConfigDO = itapEnvConfigDAO.selectCiEngine(id, managerUser);
			System.out.println("jenkinsConfigDOjenkinsConfigDOjenkinsConfigDO: " + jenkinsConfigDO);
			/*
			 * itapEnvConfigDAO.selectJenkinConfigToEdit(null, managerUser);
			 */
			closeUserEntityManager(managerUser);

			// System.out.println("Fine : "+jenkinsConfigDO.getUrl());
			// System.out.println("Use This url : "+"http://in-pnq-coe37:8080/jenkins");
			return jenkinsConfigDO.getUrl();
			// return "http://in-pnq-coe37:8080/jenkins";
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
	public JenkinsConfigDO getCiData(long id) throws ServiceException {
		try {

			EntityManager managerUser = openUserEntityManager();
			JenkinsConfigDO jenkinsConfigDO = itapEnvConfigDAO.selectCiEngine(id, managerUser);
			closeUserEntityManager(managerUser);

			return jenkinsConfigDO;
			// return "http://in-pnq-coe37:8080/jenkins";
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
