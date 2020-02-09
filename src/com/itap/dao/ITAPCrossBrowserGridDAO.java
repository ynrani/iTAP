package com.itap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPCrossBrowserGridDO;

public interface ITAPCrossBrowserGridDAO {
	public List<ITAPCrossBrowserGridDO> getGridList(EntityManager managerUser)throws DAOException;
}
