package com.itap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPCrossBrowserOS;

public interface ITAPCrossBrowserOSDAO {
	public List<ITAPCrossBrowserOS> getOsList(EntityManager managerUser)throws DAOException;
}
