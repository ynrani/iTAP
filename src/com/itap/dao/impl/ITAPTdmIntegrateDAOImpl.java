package com.itap.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPTdmIntegrateDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.FrameworkDO;
import com.itap.model.DO.TcFrameworkConfValDO;
import com.itap.model.DO.TcFrameworkConfigDO;
import com.itap.model.DO.TestCaseDO;
import com.itap.model.DTO.TDMBankReservationDTO;

@Component("itapTdmIntegrateDAO")
public class ITAPTdmIntegrateDAOImpl implements ITAPTdmIntegrateDAO {

	// private static final String FETCH_CONFIG_VALUES =
	// "SELECT  count(p),FROM TcFrameworkConfValDO p where p.toolName='OPTIK'"

	@Override
	public List<TcFrameworkConfigDO> getTcFrameworkConfigDOList(EntityManager entityManager)
			throws DAOException {

		return null;
	}

	@Override
	public List<String> getTcFrameworkConfigDOList(EntityManager entityManager,
			List<String> testCaseIds) throws DAOException {

		return null;
	}

	@Override
	public List<TestCaseDO> getTestCaseDOList(EntityManager entityManager, String testCaseIds)
			throws DAOException {

		String query = "SELECT p FROM TestCaseDO p WHERE p.tcId IN(" + testCaseIds + ")";
		List<TestCaseDO> queryResult = entityManager.createQuery(query, TestCaseDO.class)
				.getResultList();

		return queryResult;
	}

	@Override
	public List<TcFrameworkConfValDO> getTcFrameworkConfValDOList(EntityManager entityManager)
			throws DAOException {

		return null;
	}

	@Override
	public Map<String, Long> getTcFrameworkConfValDOSize(EntityManager entityManager,
			List<String> testCaseIds) throws DAOException {
		StringBuffer strBuffer = new StringBuffer("");
		if (testCaseIds != null) {
			int iTotalSize = testCaseIds.size();
			for (int i = 0; i < testCaseIds.size(); i++) {
				strBuffer.append("'").append(testCaseIds.get(i)).append("'");
				if (iTotalSize != i + 1)
					strBuffer.append(",");
			}
		}
		String query = "SELECT count(p),p.testCase.tcId FROM TcFrameworkConfValDO p WHERE p.testCase.tcId IN("
				+ strBuffer.toString() + ") GROUP BY p.testCase.tcId";
		@SuppressWarnings("rawtypes")
		List queryResult = entityManager.createQuery(query).getResultList();
		Map<String, Long> mapresult = new HashMap<String, Long>();
		for (Object obj : queryResult) {
			Object[] objs = (Object[]) obj;
			mapresult.put(String.valueOf(objs[1]), Long.parseLong(objs[0] + ""));
		}
		return mapresult;
	}

	@Override
	public void saveTestCaseResultDetails(EntityManager entityManager,
			TDMBankReservationDTO tdmBankReservationDTO) throws DAOException {
		try {

			TcFrameworkConfigDO configDO = new TcFrameworkConfigDO();
			// TcFrameworkConfValDO valConfigDO = new TcFrameworkConfValDO();

			if (null != entityManager) {
				FrameworkDO frameworkDo = entityManager.createQuery("SELECT f FROM FrameworkDO f ",
						FrameworkDO.class).getSingleResult();
				long configId = 0;
				try {
					configId = (Long) entityManager
							.createQuery(
									"SELECT COALESCE(MAX(p.frameworkConfigId),0)  from TcFrameworkConfigDO p")
							.getSingleResult();
				} catch (Exception e) {
				}
				// if(configId ==0)
				configId++;
				long valConfigId = 0;
				try {
					valConfigId = (Long) entityManager
							.createQuery(
									"SELECT COALESCE(MAX(p.frameworkConfigValId),0)  from TcFrameworkConfValDO p")
							.getSingleResult();
				} catch (Exception e) {
				}
				if (valConfigId == 0)
					valConfigId++;// = configId+1;
				TestCaseDO testDo = new TestCaseDO();

				// testDo.setTcId(tdmBankReservationDTO.getListTDMBankReservationDTO().get(0).getTestCaseId());
				testDo.setTcId(tdmBankReservationDTO.getListTDMBankReservationDTO().get(0)
						.getTestCaseId());
				testDo.setFramework(frameworkDo);
				testDo.setTcName(tdmBankReservationDTO.getListTDMBankReservationDTO().get(0)
						.getTestCaseName());
				entityManager.getTransaction().begin();
				// entityManager.persist(testDo);
				configDO.setFrameworkConfigId(configId);
				configDO.setFrameworkId("FRM_ID1");
				configDO.setTestCase(testDo);

				configDO.setFld1("accNum");
				configDO.setFld2("accBal");
				configDO.setFld3("branchCode");
				configDO.setFld4("accStatus");
				configDO.setFld5("title");
				configDO.setFld6("custName");
				configDO.setFld7("custSurName");
				configDO.setFld8("custNum");
				configDO.setFld9("buildingNum");
				configDO.setFld10("addrLn1");
				configDO.setFld11("addrLn2");
				configDO.setFld12("city");
				configDO.setFld13("country");
				configDO.setFld14("zipCode");
				configDO.setFld15("custType");
				configDO.setFld16("creditCardNum");
				configDO.setFld17("unreserveYN");
				configDO.setFld18("reserveDate");
				configDO.setFld19("unreservDate");

				// entityManager.merge(configDO);
				List<TcFrameworkConfValDO> list = new ArrayList<TcFrameworkConfValDO>();
				for (TDMBankReservationDTO dto : tdmBankReservationDTO
						.getListTDMBankReservationDTO()) {
					TcFrameworkConfValDO valConfigDO = new TcFrameworkConfValDO();
					valConfigDO.setFrameworkConfigValId(valConfigId++);
					valConfigDO.setTcFrameworkConfig(configDO);
					valConfigDO.setFrameworkId("FRM_ID1");
					valConfigDO.setTestCase(testDo);
					valConfigDO.setFld1(dto.getAccNum());
					valConfigDO.setFld2(dto.getAccBal());
					valConfigDO.setFld3(dto.getBranchCode());
					valConfigDO.setFld4(dto.getAccStatus());
					valConfigDO.setFld5(dto.getTitle());
					valConfigDO.setFld6(dto.getCustName());
					valConfigDO.setFld7(dto.getCustSurName());
					valConfigDO.setFld8(dto.getCustNum());
					valConfigDO.setFld9(dto.getBuildingNum());
					valConfigDO.setFld10(dto.getAddrLn1());
					valConfigDO.setFld11(dto.getAddrLn2());
					valConfigDO.setFld12(dto.getCity());
					valConfigDO.setFld13(dto.getCountry());
					valConfigDO.setFld14(dto.getZipCode());
					valConfigDO.setFld15(dto.getCustType());
					valConfigDO.setFld16(dto.getCreditCardNum());
					valConfigDO.setFld17(dto.getUnreserveYN());
					valConfigDO.setFld18(dto.getReserveDate());
					valConfigDO.setFld19(dto.getUnreservDate());

					list.add(valConfigDO);

					// entityManager.merge(valConfigDO);
					// entityManager.getTransaction().commit();
				}
				configDO.setTcFrameworkConfVals(list);
				entityManager.persist(configDO);
				entityManager.getTransaction().commit();

			}
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
	public List<String> getTcFrameworkConfValDOs(EntityManager entityManager, String testCasesIds)
			throws DAOException {
		try {
			List<String> lst = new ArrayList<String>();
			if (null != entityManager) {
				List result = entityManager.createQuery(
						"SELECT f.fld1 FROM TcFrameworkConfValDO f WHERE f.testCase.tcId IN("
								+ testCasesIds + ")").getResultList();
				for (Object obj : result) {
					// Object[] objs = (Object[])obj;
					lst.add(String.valueOf(obj));
				}
				return lst;
			}
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
		return null;
	}

	@Override
	public void unreserveTdmData(EntityManager entityManager, String testCasesIds)
			throws DAOException {
		try {
			if (null != entityManager) {
				/*
				 * List<TcFrameworkConfValDO> resultTcFrameworkConfValDO =
				 * entityManager.createQuery(
				 * "SELECT f FROM TcFrameworkConfValDO f WHERE f.testCase.tcId IN("
				 * + testCasesIds + ")",
				 * TcFrameworkConfValDO.class).getResultList();
				 */
				/*
				 * List<TcFrameworkConfigDO> resultTcFrameworkConfigDO =
				 * entityManager.createQuery(
				 * "SELECT f FROM TcFrameworkConfigDO f WHERE f.testCase.tcId IN("
				 * + testCasesIds + ")",
				 * TcFrameworkConfigDO.class).getResultList();
				 */
				/*
				 * List<TestCaseDO> resultTestCaseDO =
				 * entityManager.createQuery(
				 * "SELECT f FROM TestCaseDO f WHERE f.tcId IN(" + testCasesIds
				 * + ")", TestCaseDO.class).getResultList();
				 */
				entityManager.getTransaction().begin();
				Query q1 = entityManager
						.createQuery("DELETE FROM  TcFrameworkConfValDO p where p.testCase.tcId IN("
								+ testCasesIds + ")");
				// q1.setParameter("userId", userId);
				q1.executeUpdate();
				Query q2 = entityManager
						.createQuery("DELETE FROM  TcFrameworkConfigDO p where p.testCase.tcId IN("
								+ testCasesIds + ")");
				// q1.setParameter("userId", userId);
				q2.executeUpdate();
				Query q3 = entityManager.createQuery("DELETE FROM  TestCaseDO p where p.tcId IN("
						+ testCasesIds + ")");
				// q1.setParameter("userId", userId);
				q3.executeUpdate();
				/*
				 * for(TcFrameworkConfValDO tcFrameworkConfValDO :
				 * resultTcFrameworkConfValDO)
				 * entityManager.remove(tcFrameworkConfValDO);
				 */
				/*
				 * for(TcFrameworkConfigDO tcFrameworkConfigDO :
				 * resultTcFrameworkConfigDO)
				 * entityManager.remove(tcFrameworkConfigDO);
				 */
				/*
				 * for(TestCaseDO testCaseDO : resultTestCaseDO){
				 * //entityManager.remove(testCaseDO.getTcFrameworkConfigs());
				 * entityManager.remove(testCaseDO); }
				 */
				entityManager.getTransaction().commit();
			}
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
