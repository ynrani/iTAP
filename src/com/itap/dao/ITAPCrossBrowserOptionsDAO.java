package com.itap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPCrossBrowserOptions;

public interface ITAPCrossBrowserOptionsDAO {
	
	public List<ITAPCrossBrowserOptions> getBrowserList(EntityManager entityManager, int osId) throws DAOException;
	public List<ITAPCrossBrowserOptions> getBrowserList(EntityManager entityManager, int osId,final String browserName) throws DAOException;

}
