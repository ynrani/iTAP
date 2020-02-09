package com.itap.dao.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPConfigDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPBookDtlDO;
import com.itap.model.DO.ITAPConfigDO;
import com.itap.model.DO.ITAPEnvDtlDO;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DTO.ITAPConfigDTO;

@Component("itapConfigDAO")
public class ITAPConfigDAOImpl implements ITAPConfigDAO {

	@Override
	public ITAPConfigDO selectConfigToEdit(String configId, EntityManager managerApp)
			throws DAOException {
		try {
			ITAPConfigDO remsAppDtlDO = (ITAPConfigDO) managerApp.createQuery(
					"SELECT p FROM ITAPConfigDO p where p.configId=" + Long.parseLong(configId))
					.getSingleResult();
			return remsAppDtlDO;
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
	public ITAPConfigDO saveConfigDetails(ITAPConfigDO remsAppsDtlDO, EntityManager managerApp)
			throws DAOException {
		try {
			if (null != managerApp) {

				long noo = 0;
				if (0 == remsAppsDtlDO.getConfigId()) {

					/*
					 * System.out.println(">>>>>>>>" + managerApp.createQuery(
					 * "SELECT NVL(MAX(p.configId),0)  from ITAPConfigDO p")
					 * .getSingleResult());
					 */

					long no = (Long) managerApp.createQuery(
							"SELECT COALESCE(MAX(p.configId),0)  from ITAPConfigDO p")
							.getSingleResult();
					if (0 <= no) {
						noo = no + 1;
					} else {
						noo = 1;
					}
					remsAppsDtlDO.setConfigId(noo);

				}
				managerApp.getTransaction().begin();
				remsAppsDtlDO = managerApp.merge(remsAppsDtlDO);
				managerApp.getTransaction().commit();
			}
			return remsAppsDtlDO;
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
	public Long configurationViewCnt(String configId, ITAPConfigDTO itapConfigDTO,
			EntityManager managerApp) throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT count(*) FROM ITAPConfigDO p Where 1=1");
			Long count = (Long) managerApp.createQuery(query + "").getSingleResult();
			return count;
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
	public List<ITAPConfigDO> configurationView(int offSet, int recordsperpage, boolean b,
			String userId, ITAPConfigDTO itapConfigDTO, EntityManager managerApp)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM ITAPConfigDO p Where 1=1");
			List<ITAPConfigDO> remsAppDtlDOs = managerApp.createQuery(query + "").getResultList();
			return remsAppDtlDOs;
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
	public String deleteConfiguration(String configId, EntityManager managerApp)
			throws DAOException {
		try {
			managerApp.getTransaction().begin();
			Query q = managerApp.createQuery("DELETE FROM  ITAPConfigDO p where p.configId ="
					+ Long.parseLong(configId));
			int str = q.executeUpdate();
			managerApp.getTransaction().commit();
			return str + "";
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

	private class AllJobListSorting implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {

			if (o1 != null && o2 != null) {

				return o1.compareTo(o2);
			}

			return -1;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> allProjs(EntityManager managerApp) throws DAOException {

		try {
			StringBuffer query = new StringBuffer("SELECT DISTINCT(p.projName) FROM ITAPConfigDO p");
			List<String> allProjs = managerApp.createQuery(query + "").getResultList();

			try {
				Collections.sort(allProjs, new AllJobListSorting());
			} catch (Exception e) {
				e.printStackTrace();
			}

			return allProjs;
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
	public String saveTrainDetails(ITAPTrainViewDO itapTrainViewDO, EntityManager managerApp)
			throws DAOException {
		try {
			if (null != managerApp) {

				long noo = 0;
				if (0 == itapTrainViewDO.getId()) {

					long no = (Long) managerApp.createQuery(
							"SELECT COALESCE(MAX(p.id),0)  from ITAPTrainViewDO p")
							.getSingleResult();
					/*
					 * long no = (Long) managerApp.createQuery(
					 * "SELECT NVL(MAX(p.id),0)  from ITAPTrainViewDO p"
					 * ).getSingleResult();
					 */
					if (0 <= no) {
						noo = no + 1;
					} else {
						noo = 1;
					}
					itapTrainViewDO.setId(noo);
				}

				managerApp.getTransaction().begin();
				itapTrainViewDO = managerApp.merge(itapTrainViewDO);
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
	public List<ITAPTrainViewDO> configurationTrainView(EntityManager managerUser, String userId)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM ITAPTrainViewDO p Where 1=1");
			@SuppressWarnings("unchecked")
			List<ITAPTrainViewDO> itapTrainViewDOs = managerUser.createQuery(query + "")
					.getResultList();
			return itapTrainViewDOs;
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
	public String deleteTrain(String id, EntityManager managerUser) throws DAOException {
		try {
			managerUser.getTransaction().begin();

			Query q3 = managerUser.createQuery("DELETE FROM  ITAPTrainViewDO p where p.id ='" + id
					+ "'");
			int str3 = q3.executeUpdate();

			managerUser.getTransaction().commit();
			return str3 + "";
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

	// TODO

	@SuppressWarnings(ITAPConstants.UNCHECKED)
	@Override
	public List<ITAPEnvDtlDO> getAllEnvs(EntityManager managerEnv) throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM ITAPEnvDtlDO p Where 1=1");

			List<ITAPEnvDtlDO> remsEnvDtlDOs = managerEnv.createQuery(query + "").getResultList();
			return remsEnvDtlDOs;
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
	public ITAPEnvDtlDO getEnv(String envId, EntityManager managerUser) throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM ITAPEnvDtlDO p Where 1=1");
			query.append(" AND p.envId ='" + envId + "'");
			ITAPEnvDtlDO remsEnvDtlDO = (ITAPEnvDtlDO) managerUser.createQuery(query + "")
					.getSingleResult();
			return remsEnvDtlDO;
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
	public List<ITAPBookDtlDO> getBookedEnv(String envId, EntityManager managerUser)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM ITAPBookDtlDO p Where 1=1");
			query.append(" AND p.envId ='" + envId + "'");
			@SuppressWarnings("unchecked")
			List<ITAPBookDtlDO> remsEnvDtlDO = managerUser.createQuery(query + "").getResultList();
			return remsEnvDtlDO;
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
	public List<ITAPConfigDO> getAllTestcasesIdByJobs(EntityManager managerUser,
			List<String> lstJobs) throws DAOException {
		try {
			StringBuffer query = new StringBuffer("SELECT p FROM ITAPConfigDO p Where 1=1 ");
			for (String strJob : lstJobs)
				query.append(" AND p.jobName LIKE '").append(strJob).append("%'  ");
			List<ITAPConfigDO> remsAppDtlDOs = managerUser.createQuery(query + "",
					ITAPConfigDO.class).getResultList();
			return remsAppDtlDOs;
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
	public List<ITAPTrainViewDO> getJobsByProjectName(EntityManager managerApp, String porjectName) {

		String query = "SELECT p FROM ITAPTrainViewDO p where PROJECT_NAME='" + porjectName + "'";
		@SuppressWarnings("unchecked")
		List<ITAPTrainViewDO> jobsLisDB = managerApp.createQuery(query + "").getResultList();

		// TODO Auto-generated method stub
		return jobsLisDB;
	}

	@Override
	public String getTrainJobs(String trainId, EntityManager managerUser) throws DAOException {

		managerUser.getTransaction().begin();
		try {
			Query q3 = managerUser.createQuery("SELECT p FROM  ITAPTrainViewDO p where p.id ='"
					+ trainId + "'");
			ITAPTrainViewDO doObject = (ITAPTrainViewDO) q3.getSingleResult();

			return doObject.getTrainJobs();
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
