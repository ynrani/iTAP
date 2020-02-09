package com.itap.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPCrossBrowserGridDO;
import com.itap.model.DO.ITAPToolTestCaseDO;

public interface ITAPToolTestCaseDAO {

	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOList(EntityManager entityManager,String toolName,String toolColumn,String toolColumnValue) throws DAOException;
	
	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOList(EntityManager entityManager,String toolName,String toolColumn,String toolColumnValue,String testSuite) throws DAOException;
	
	public List<String> getToolColumnValues(EntityManager entityManager,String toolName,String toolColumn) throws DAOException;
	
	public List<String> getToolColumnValues(EntityManager entityManager,String toolName,String toolColumn,String testSuite) throws DAOException;
	
	public List<ITAPToolTestCaseDO> toolBasedTestCasesList(EntityManager entityManager,String toolName) throws DAOException;
	
	public List<String> optikTestSuiteList(EntityManager entityManager) throws DAOException;
	
	public List<ITAPToolTestCaseDO> getOTCForSeleTS(EntityManager entityManager ,  String testSuite) throws DAOException;
	
	public List<String> getOTCForSeleTS(EntityManager entityManager ,  String testSuite,String toolColumn) throws DAOException;
	
	public List<String> getDeviceNameList(EntityManager entityManager,int gridUrlId)throws DAOException;
	
	public List<String> getDeviceListForGivenDeviceName(EntityManager entityManager, String deviceName,int gridId)throws DAOException;
	
	public List<ITAPCrossBrowserGridDO> fetchUrlsForGridType(EntityManager entityManager, String gridType) throws DAOException;
	
	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOListForTDM(EntityManager entityManager,
			String toolName, String testCaseNames) throws DAOException;

	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOList(EntityManager entityManager,
			String strTestCases) throws DAOException;

	public void updateTdmIntegratedData(EntityManager entityManager, String string,boolean isForTdmDataReservation)throws DAOException;
}
