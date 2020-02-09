package com.itap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPEnvConfigDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPEnvConfigDO;
import com.itap.model.DO.JenkinsConfigDO;

@Component("itapEnvConfigDAO")
public class ITAPEnvConfigDAOImpl implements ITAPEnvConfigDAO {

	@Override
	public ITAPEnvConfigDO selectStsConfigToEdit(String sysConfigId, EntityManager managerApp)
			throws DAOException {
		try {
			ITAPEnvConfigDO itapEnvConfigDO = (ITAPEnvConfigDO) managerApp.createQuery(
					"SELECT p FROM ITAPEnvConfigDO p where 1=1").getSingleResult();
			return itapEnvConfigDO;
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
	public String saveEnvConfigDetails(ITAPEnvConfigDO itapEnvConfigDO, EntityManager managerApp)
			throws DAOException {
		try {
			if (null != managerApp) {

				long noo = 0;
				if (0 == itapEnvConfigDO.getEnvConfigId()) {
					long no = (Long) managerApp.createQuery(
							"SELECT COALESCE(MAX(p.envConfigId),0)  from ITAPEnvConfigDO p")
							.getSingleResult();
					if (0 <= no) {
						noo = no + 1;
					} else {
						noo = 1;
					}
					itapEnvConfigDO.setEnvConfigId(noo);
				}

				managerApp.getTransaction().begin();
				itapEnvConfigDO = managerApp.merge(itapEnvConfigDO);
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
	public JenkinsConfigDO selectJenkinConfigToEdit(String id, EntityManager managerUser)
			throws DAOException {
		try {
			JenkinsConfigDO jenkinsConfigDO = (JenkinsConfigDO) managerUser.createQuery(
					"SELECT p FROM JenkinsConfigDO p where 1=1 AND p.ciName='Jenkins'")
					.getSingleResult();

			return jenkinsConfigDO;
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
	public JenkinsConfigDO selectCiEngine(long id, EntityManager managerUser) throws DAOException {
		try {

			JenkinsConfigDO jenkinsConfigDO = (JenkinsConfigDO) managerUser.createQuery(
					"SELECT p FROM JenkinsConfigDO p where jenkinsId=" + id).getSingleResult();
			return jenkinsConfigDO;
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
	public String saveJenkinConfigDetails(JenkinsConfigDO jenkinsConfigDO, EntityManager managerUser)
			throws DAOException {
		try {
			if (null != managerUser) {

				long noo = 0;
				if (0 == jenkinsConfigDO.getJenkinsId()) {
					long no = (Long) managerUser.createQuery(
							"SELECT COALESCE(MAX(p.jenkinsId),0)  from JenkinsConfigDO p")
							.getSingleResult();
					if (0 <= no) {
						noo = no + 1;
					} else {
						noo = 1;
					}
					jenkinsConfigDO.setJenkinsId(noo);
				}

				managerUser.getTransaction().begin();
				jenkinsConfigDO = managerUser.merge(jenkinsConfigDO);
				managerUser.getTransaction().commit();
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
	public String saveJenkinListConfigDetails(List<JenkinsConfigDO> jenkinsConfigDoList,
			EntityManager managerUser) throws DAOException {

		try {
			if (null != managerUser) {
				for (JenkinsConfigDO jenkinsConfigDO : jenkinsConfigDoList) {

					long noo = 0;
					if (0 == jenkinsConfigDO.getJenkinsId()) {
						long no = (Long) managerUser.createQuery(
								"SELECT COALESCE(MAX(p.jenkinsId),0)  from JenkinsConfigDO p")
								.getSingleResult();
						if (0 <= no) {
							noo = no + 1;
						} else {
							noo = 1;
						}
						jenkinsConfigDO.setJenkinsId(noo);
					}

					managerUser.getTransaction().begin();
					jenkinsConfigDO = managerUser.merge(jenkinsConfigDO);
					managerUser.getTransaction().commit();
				}

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
	public List<JenkinsConfigDO> getAllCiEngine(EntityManager managerApp) throws DAOException {
		try {

			StringBuffer query = new StringBuffer("SELECT p FROM JenkinsConfigDO p Where 1=1");
			List<JenkinsConfigDO> jenkinsConfigDO = managerApp.createQuery(query + "")
					.getResultList();

			return jenkinsConfigDO;
		} catch (IllegalStateException illegalStateEx) {
			illegalStateEx.printStackTrace();
			throw new DAOException(ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			illegalArgEx.printStackTrace();
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String deleteConfigDetails(String cIId, EntityManager managerUser) throws DAOException {
		try {
			managerUser.getTransaction().begin();
			Query q = managerUser.createQuery("DELETE FROM JenkinsConfigDO p Where p.jenkinsId = "
					+ Long.parseLong(cIId));
			int str = q.executeUpdate();
			managerUser.getTransaction().commit();
			return str + "";

		} catch (IllegalStateException illegalStateEx) {
			illegalStateEx.printStackTrace();
			throw new DAOException(ITAPConstants.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			illegalArgEx.printStackTrace();
			throw new DAOException(ITAPConstants.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			throw new DAOException(ITAPConstants.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			otherEx.printStackTrace();
			throw new DAOException(ITAPConstants.DATABASE_EXCEPTION, otherEx);
		}
	}

}
