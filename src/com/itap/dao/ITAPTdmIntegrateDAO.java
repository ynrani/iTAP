package com.itap.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.itap.exception.DAOException;
import com.itap.model.DO.TcFrameworkConfValDO;
import com.itap.model.DO.TcFrameworkConfigDO;
import com.itap.model.DO.TestCaseDO;
import com.itap.model.DTO.TDMBankReservationDTO;

public interface ITAPTdmIntegrateDAO{
	public List<TcFrameworkConfigDO> getTcFrameworkConfigDOList(EntityManager entityManager)
			throws DAOException;

	public List<String> getTcFrameworkConfigDOList(EntityManager entityManager,
			List<String> testCaseIds) throws DAOException;

	public List<TcFrameworkConfValDO> getTcFrameworkConfValDOList(EntityManager entityManager)
			throws DAOException;

	public Map<String, Long> getTcFrameworkConfValDOSize(EntityManager entityManager,
			List<String> testCaseIds) throws DAOException;

	public void saveTestCaseResultDetails(EntityManager entityManager,TDMBankReservationDTO tdmBankReservationDTO) throws DAOException;


	List<TestCaseDO> getTestCaseDOList(EntityManager entityManager, String testCaseIds)
			throws DAOException;

	public List<String> getTcFrameworkConfValDOs(EntityManager manager,
			String testCasesIds) throws DAOException;

	void unreserveTdmData(EntityManager entityManager, String testCasesIds) throws DAOException;
}
