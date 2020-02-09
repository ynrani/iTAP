package com.itap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.itap.constant.ITAPConstants;
import com.itap.dao.ITAPUserDAO;
import com.itap.exception.DAOException;
import com.itap.model.DO.ITAPUserAppAccessDO;
import com.itap.model.DO.ITAPUserDtlDO;
import com.itap.model.DTO.ITAPUserAppAccessDTO;
import com.itap.model.DTO.ITAPUserDtlDTO;

@Component("itapUserDAO")
public class ITAPUserDAOImpl implements ITAPUserDAO {

	@Override
	public ITAPUserDtlDO selectUserToEdit(String userId, EntityManager managerUser)
			throws DAOException {
		try {
			ITAPUserDtlDO itapUserDtlDO = (ITAPUserDtlDO) managerUser.createQuery(
					"SELECT p FROM ITAPUserDtlDO p where p.userId='" + userId + "'")
					.getSingleResult();
			return itapUserDtlDO;
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
	public String saveUserDetails(ITAPUserDtlDO itapUserDtlDO, EntityManager managerUser)
			throws DAOException {
		try {
			if (null != managerUser) {
				managerUser.getTransaction().begin();
				itapUserDtlDO = managerUser.merge(itapUserDtlDO);
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
	public Long itapViewUserCnt(String userId, ITAPUserDtlDTO itapUserDtlDTO,
			EntityManager managerUser) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT count(*) FROM ITAPUserDtlDO p Where 1=1 AND p.userId !='" + userId
							+ "'");

			Long count = (Long) managerUser.createQuery(query + "").getSingleResult();
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
	public List<ITAPUserDtlDO> itapViewUser(int offSet, int recordsperpage, boolean b,
			String userId, ITAPUserDtlDTO itapUserDtlDTO, EntityManager managerUser)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT p FROM ITAPUserDtlDO p Where p.userId !='" + userId + "'");

			List<ITAPUserDtlDO> itapUserDtlDOs = managerUser.createQuery(query + "")
					.getResultList();
			return itapUserDtlDOs;
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
	public String daleteUser(String id, EntityManager managerUser) throws DAOException {
		try {
			managerUser.getTransaction().begin();

			Query q2 = managerUser.createQuery("DELETE FROM  ITAPEnvDtlDO p where p.actionBy ='"
					+ id + "'");
			q2.executeUpdate();

			Query q1 = managerUser
					.createQuery("DELETE FROM  ITAPUserAppAccessDO p where p.userId ='" + id + "'");
			q1.executeUpdate();
			Query q = managerUser.createQuery("DELETE FROM  ITAPUserDtlDO p where p.userId ='" + id
					+ "'");
			q.executeUpdate();

			managerUser.getTransaction().commit();
			return id;
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
/*
	@Override
	public ITAPUserAppAccessDO selectUserAccessToEdit(String id, EntityManager managerUser)
			throws DAOException {
		try {
			ITAPUserAppAccessDO itapUserAppAccessDO = (ITAPUserAppAccessDO) managerUser
					.createQuery(
							"SELECT p FROM ITAPUserAppAccessDO p where p.id='" + Long.parseLong(id)
									+ "'").getSingleResult();
			return itapUserAppAccessDO;
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
	public String saveUserAccessDetails(ITAPUserAppAccessDO itapUserAppAccessDO,
			EntityManager managerUser) throws DAOException {
		try {
			if (null != managerUser) {
				long noo = 0;
				if (0 == itapUserAppAccessDO.getId()) {
					long no = (Long) managerUser.createQuery(
							"SELECT COALESCE(MAX(p.id),0)  from ITAPUserAppAccessDO p")
							.getSingleResult();
					if (0 <= no) {
						noo = no + 1;
					} else {
						noo = 1;
					}
					itapUserAppAccessDO.setId(noo);
				}
				managerUser.getTransaction().begin();
				itapUserAppAccessDO = managerUser.merge(itapUserAppAccessDO);
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
	public Long itapViewAllocAppCnt(String userId, ITAPUserAppAccessDTO itapUserAppAccessDTO,
			EntityManager managerUser) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT count(*) FROM ITAPUserAppAccessDO p Where 1=1 AND P.userId ='" + userId
							+ "'");

			Long count = (Long) managerUser.createQuery(query + "").getSingleResult();
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
	public List<ITAPUserAppAccessDO> itapViewAllocApp(int offSet, int recordsperpage, boolean b,
			String userId, ITAPUserAppAccessDTO itapUserAppAccessDTO, EntityManager managerUser)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT p FROM ITAPUserAppAccessDO p Where p.userId ='" + userId + "'");
			List<ITAPUserAppAccessDO> itapUserAppAccessDOs = managerUser.createQuery(query + "")
					.getResultList();
			return itapUserAppAccessDOs;
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
	public String daleteAllocApp(String id, EntityManager managerUser) throws DAOException {
		try {
			managerUser.getTransaction().begin();
			Query q = managerUser.createQuery("DELETE FROM  ITAPUserAppAccessDO p where p.id ="
					+ Long.parseLong(id));
			q.executeUpdate();
			managerUser.getTransaction().commit();
			return id;
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
	public String itapCheckAllApp(String appId, String userId, EntityManager managerUser)
			throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT count(*) FROM ITAPUserAppAccessDO p Where 1=1 AND p.appId='" + appId
							+ "' AND p.userId ='" + userId + "'");

			Long count = (Long) managerUser.createQuery(query + "").getSingleResult();
			String msg = null;
			if (0 < count) {
				msg = "Y";
			}

			return msg;
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
	public String itapCheckUserAvail(String userId, EntityManager managerUser) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT count(*) FROM ITAPUserDtlDO p Where 1=1 AND p.userId ='" + userId + "'");

			Long count = (Long) managerUser.createQuery(query + "").getSingleResult();
			String msg = null;
			if (0 < count) {
				msg = "Y";
			}

			return msg;
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
	}*/
}
