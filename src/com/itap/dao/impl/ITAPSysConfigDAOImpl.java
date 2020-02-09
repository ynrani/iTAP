package com.itap.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPSysConfigDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPConfAllFileDO;
import com.itap.model.DO.ITAPSysConfigDO;

@Component("itapSysConfigDAO")
public class ITAPSysConfigDAOImpl implements ITAPSysConfigDAO {

	@Override
	public ITAPSysConfigDO selectStsConfigToEdit(String sysConfigId, EntityManager managerApp)
			throws DAOException {
		try {
			ITAPSysConfigDO itapSysConfigDO = (ITAPSysConfigDO) managerApp.createQuery(
					"SELECT p FROM ITAPSysConfigDO p where 1=1").getSingleResult();
			return itapSysConfigDO;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String saveSysConfigDetails(ITAPSysConfigDO itapSysConfigDO,
			EntityManager managerApp) throws DAOException {
		try {
			if (null != managerApp) {

				long noo = 0;
				if (0 == itapSysConfigDO.getSysConfigId()) {
					long no = (Long) managerApp.createQuery(
							"SELECT COALESCE(MAX(p.sysConfigId),0)  from ITAPSysConfigDO p")
							.getSingleResult();
					if (0 <= no) {
						noo = no + 1;
					} else {
						noo = 1;
					}
					itapSysConfigDO.setSysConfigId(noo);
				}
				managerApp.getTransaction().begin();
				itapSysConfigDO = managerApp.merge(itapSysConfigDO);
				managerApp.getTransaction().commit();
			}
			return "SUCCESS";
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public ITAPConfAllFileDO configAllFilesGet(String id, EntityManager managerApp)
			throws DAOException {
		try {
			ITAPConfAllFileDO itapConfAllFileDO = null;
			if (0 < (Long) managerApp.createQuery(
					"SELECT COUNT(p) FROM ITAPConfAllFileDO p where 1=1").getSingleResult()) {
				itapConfAllFileDO = (ITAPConfAllFileDO) managerApp.createQuery(
						"SELECT p FROM ITAPConfAllFileDO p where 1=1").getSingleResult();
			}
			return itapConfAllFileDO;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String configAllFilesPost(ITAPConfAllFileDO itapConfAllFileDO,
			EntityManager managerApp) throws DAOException {
		try {
			if (null != managerApp) {

				long noo = 0;
				if (0 == itapConfAllFileDO.getConfAllFileId()) {
					long no = (Long) managerApp.createQuery(
							"SELECT COALESCE(MAX(p.confAllFileId),0)  from ITAPConfAllFileDO p")
							.getSingleResult();
					if (0 <= no) {
						noo = no + 1;
					} else {
						noo = 1;
					}
					itapConfAllFileDO.setConfAllFileId(noo);
				}

				managerApp.getTransaction().begin();
				itapConfAllFileDO = managerApp.merge(itapConfAllFileDO);
				managerApp.getTransaction().commit();
			}
			return "SUCCESS";
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

}
