package com.itap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPToolTestCaseDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPCrossBrowserGridDO;
import com.itap.model.DO.ITAPToolTestCaseDO;

@Component
public class ITAPToolTestCaseDAOImpl implements ITAPToolTestCaseDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOList(
			EntityManager entityManager, String toolName, String toolColumn,
			String toolColumnValue) throws DAOException {
		try {

			if (toolColumn == null || toolColumn.equals("None")
					|| toolColumnValue == null
					|| toolColumnValue.equals("None")) {
				List<ITAPToolTestCaseDO> itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
						.createQuery(
								"SELECT p FROM ITAPToolTestCaseDO p where p.toolName='"
										+ toolName + "'").getResultList();
				return itapToolTestCaseDOList;
			}else{
				List<ITAPToolTestCaseDO> itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
						.createQuery(
								"SELECT p FROM ITAPToolTestCaseDO p where p.toolName='"
										+ toolName + "' AND p."+toolColumn+"='"+toolColumnValue+"'").getResultList();
				return itapToolTestCaseDOList;
			}

		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOListForTDM(
			EntityManager entityManager, String toolName, String testCaseNames) throws DAOException {
		try {
			List<ITAPToolTestCaseDO> itapToolTestCaseDOList = null;
			if(toolName != null){				
				itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
						.createQuery(
								"SELECT p FROM ITAPToolTestCaseDO p where p.toolName IN('"
										+ toolName + "') AND p.testCaseId IN("+testCaseNames+") AND p.tdmCriteria IS NOT NULL").getResultList();
			}else{
					itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
							.createQuery(
									"SELECT p FROM ITAPToolTestCaseDO p where p.testCaseId IN("+testCaseNames+") AND p.tdmCriteria IS NOT NULL").getResultList();
				}
				return itapToolTestCaseDOList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getToolColumnValues(EntityManager entityManager,
			String toolName, String toolColumn) throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<String> toolColumnValueList = (List<String>) entityManager
					.createQuery(
							"SELECT p."
									+ toolColumn
									+ " FROM ITAPToolTestCaseDO p where p.toolName='"
									+ toolName + "'").getResultList();
			return toolColumnValueList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPToolTestCaseDO> toolBasedTestCasesList(
			EntityManager entityManager, String toolName) throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<ITAPToolTestCaseDO> toolColumnValueList = (List<ITAPToolTestCaseDO>) entityManager
					.createQuery(
							"SELECT p FROM ITAPToolTestCaseDO p where p.toolName='"
									+ toolName + "'").getResultList();
			return toolColumnValueList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> optikTestSuiteList(EntityManager entityManager)
			throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<String> optikTestSuiteList = (List<String>) entityManager
					.createQuery(
							"SELECT p.requirement FROM ITAPToolTestCaseDO p where p.toolName='OPTIK'").getResultList();
			return optikTestSuiteList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPToolTestCaseDO> getOTCForSeleTS(
			EntityManager entityManager, String testSuite) throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<ITAPToolTestCaseDO> optikTCList = (List<ITAPToolTestCaseDO>) entityManager
					.createQuery(
							"SELECT p FROM ITAPToolTestCaseDO p where p.toolName='OPTIK' AND p.requirement='"+testSuite+"'").getResultList();
			return optikTCList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getOTCForSeleTS(EntityManager entityManager,
			String toolColumn, String testSuite) throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<String> optikTestSuiteList = (List<String>) entityManager
					.createQuery(
							"SELECT p."+toolColumn+" FROM ITAPToolTestCaseDO p where p.toolName='OPTIK' AND p.requirement='"+testSuite+"'").getResultList();
			return optikTestSuiteList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getToolColumnValues(EntityManager entityManager,
			String toolName, String toolColumn, String testSuite)
			throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<String> toolColumnValueList = (List<String>) entityManager
					.createQuery(
							"SELECT p."
									+ toolColumn
									+ " FROM ITAPToolTestCaseDO p where p.toolName='"
									+ toolName + "'").getResultList();
			return toolColumnValueList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOList(
			EntityManager entityManager, String toolName, String toolColumn,
			String toolColumnValue, String testSuite) throws DAOException {
		try {

			if (toolColumn == null || toolColumn.equals("None")
					|| toolColumnValue == null
					|| toolColumnValue.equals("None")) {
				
				List<ITAPToolTestCaseDO> itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
						.createQuery(
								"SELECT p FROM ITAPToolTestCaseDO p where p.toolName='OPTIK' AND p.requirement='"+testSuite+"'").getResultList();
				return itapToolTestCaseDOList;
			}else{
				List<ITAPToolTestCaseDO> itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
						.createQuery(
								"SELECT p FROM ITAPToolTestCaseDO p where p.toolName='OPTIK' AND p."+toolColumn+"='"+toolColumnValue+"' AND p.requirement='"+testSuite+"'").getResultList();
				return itapToolTestCaseDOList;
			}

		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getDeviceNameList(EntityManager entityManager,int gridUrlId) throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<String> deviceNameList = (List<String>) entityManager
					.createQuery(
							"SELECT d.deviceName FROM DevicesDO d WHERE d.gridUrlId ="+gridUrlId).getResultList();
			return deviceNameList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<String> getDeviceListForGivenDeviceName(EntityManager entityManager,String deviceName,int gridUrlId)
			throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<String> deviceList = (List<String>) entityManager
					.createQuery(
							"SELECT d.deviceUdid FROM DevicesDO d WHERE d.deviceName ='"+deviceName+"' AND d.gridUrlId="+gridUrlId).getResultList();
			return deviceList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<ITAPCrossBrowserGridDO> fetchUrlsForGridType(EntityManager entityManager,
			String gridType) throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<ITAPCrossBrowserGridDO> gridList = (List<ITAPCrossBrowserGridDO>) entityManager
					.createQuery(
							"SELECT d FROM ITAPCrossBrowserGridDO d WHERE d.gridType ='"+gridType+"'").getResultList();
			return gridList;
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}
	
	@Override
	public List<ITAPToolTestCaseDO> getITAPToolTestCaseDOList(EntityManager entityManager,
			String strTestCases) throws DAOException{
		try {

				List<ITAPToolTestCaseDO> itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
						.createQuery(
								"SELECT p FROM ITAPToolTestCaseDO p where p.testCaseId IN("+strTestCases+")",ITAPToolTestCaseDO.class).getResultList();
				return itapToolTestCaseDOList;
			
		} catch (IllegalStateException illegalStateEx) {
			throw new DAOException(
					ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
					illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
					nullPointerEx);
		} catch (Exception otherEx) {
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}


	@Override
	public void updateTdmIntegratedData(EntityManager entityManager, String strTestCasesId,boolean isForTdmReservation)
			throws DAOException{
		try {

			List<ITAPToolTestCaseDO> itapToolTestCaseDOList = (List<ITAPToolTestCaseDO>) entityManager
					.createQuery(
							"SELECT p FROM ITAPToolTestCaseDO p where p.testCaseId IN("+strTestCasesId+")",ITAPToolTestCaseDO.class).getResultList();
			entityManager.getTransaction().begin();
			for(ITAPToolTestCaseDO itapTc : itapToolTestCaseDOList){
				if(isForTdmReservation)
				itapTc.setTdmDataExist("Y");
				else
					itapTc.setTdmDataExist("N");
				entityManager.merge(itapTc);
			}
			entityManager.getTransaction().commit();
		
	} catch (IllegalStateException illegalStateEx) {
		throw new DAOException(
				ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
				illegalStateEx);
	} catch (IllegalArgumentException illegalArgEx) {
		throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION,
				illegalArgEx);
	} catch (NullPointerException nullPointerEx) {
		throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION,
				nullPointerEx);
	} catch (Exception otherEx) {
		throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
	}
}
}
