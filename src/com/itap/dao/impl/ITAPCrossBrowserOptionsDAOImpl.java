package com.itap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPCrossBrowserOptionsDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPCrossBrowserOptions;

@Component("itapCrossBrowserOptionsDAO")
public class ITAPCrossBrowserOptionsDAOImpl implements ITAPCrossBrowserOptionsDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<com.itap.model.DO.ITAPCrossBrowserOptions> getBrowserList(
			EntityManager entityManager, int osId)throws DAOException {
		try {
			List<com.itap.model.DO.ITAPCrossBrowserOptions> itapCrossBrowserOptionsList = entityManager.createQuery(
					"SELECT a FROM ITAPCrossBrowserOptions a where a.osId=" + osId).getResultList();
			return itapCrossBrowserOptionsList;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ITAPCrossBrowserOptions> getBrowserList(
			EntityManager entityManager, int osId, String browserName)
			throws DAOException {
		try {
			List<com.itap.model.DO.ITAPCrossBrowserOptions> itapCrossBrowserOptionsList = entityManager.createQuery(
					"SELECT a FROM ITAPCrossBrowserOptions a where a.osId=" + osId+" AND a.browserName='"+browserName+"'").getResultList();
			return itapCrossBrowserOptionsList;
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
