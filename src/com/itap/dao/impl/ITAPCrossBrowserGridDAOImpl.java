package com.itap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPCrossBrowserGridDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPCrossBrowserGridDO;

@Component("itapCrossBrowserGridDAO")
public class ITAPCrossBrowserGridDAOImpl implements ITAPCrossBrowserGridDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<ITAPCrossBrowserGridDO> getGridList(EntityManager managerUser)
			throws DAOException {
		try {
			List<ITAPCrossBrowserGridDO> itapCrossBrowserGridList = managerUser.createQuery(
					"SELECT a FROM ITAPCrossBrowserGridDO a").getResultList();
			return itapCrossBrowserGridList;
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
