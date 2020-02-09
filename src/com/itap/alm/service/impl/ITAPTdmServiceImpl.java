/*
 * Object Name : ITAPTdmServiceImpl.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  vkrish14		2:44:24 PM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.itap.alm.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itap.alm.service.ITAPTdmService;
import com.itap.dao.ITAPTdmIntegrateDAO;
import com.itap.dao.ITAPToolTestCaseDAO;
import com.itap.model.DO.ITAPToolTestCaseDO;
import com.itap.model.DO.TestCaseDO;
import com.itap.model.DTO.ITAPConfigDTO;
import com.itap.model.DTO.TDMBankReservationDTO;
import com.itap.service.impl.ITAPBaseServiceImpl;

/**
 * @author vkrish14
 *
 */
@Component("itapTdmService")
public class ITAPTdmServiceImpl extends ITAPBaseServiceImpl implements ITAPTdmService {

	private static final String TDM_URL = "http://in-pnq-coe12:8080/TDMCentralBankingWA/";
	// private static final String
	// TDM_URL="http://localhost:8898/TDMCentralBankingWA/servicesFTDWithReserve?";
	@Autowired
	ITAPTdmIntegrateDAO itapTdmIntegrateDAO;

	@Autowired
	ITAPToolTestCaseDAO itapToolTestCaseDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.itap.alm.service.ITAPTdmService#doCheckTestData(com.itap.model.DTO
	 * .ITAPConfigDTO )
	 */
	@Override
	public Set<String> doCheckTestData(ITAPConfigDTO itapConfigDTO) {
		EntityManager entityManager = null;
		try {
			entityManager = openUserEntityManager();
			Set<String> lstTestCaseName = new HashSet<String>();
			if (itapConfigDTO != null) {
				StringBuffer strBuffer = new StringBuffer("");
				List<ITAPToolTestCaseDO> result = new ArrayList<ITAPToolTestCaseDO>();
				if (StringUtils.isNotEmpty(itapConfigDTO.getBddSct())) {
					// result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(entityManager,
					// "BDD", itapConfigDTO.getBddSct()));
					if (itapConfigDTO.getBddSct().contains(",")) {
						String[] strSplits = itapConfigDTO.getBddSct().split(",");
						for (int i = 0; i < strSplits.length; i++) {
							strBuffer.append("'").append(strSplits[i]).append("'");
							if (strSplits.length != i + 1)
								strBuffer.append(",");
						}
					} else {
						strBuffer.append("'").append(itapConfigDTO.getBddSct()).append("'");
						// lstTestCaseName.add(itapConfigDTO.getBddSct());
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "BDD", strBuffer.toString()));
				}
				if (StringUtils.isNotEmpty(itapConfigDTO.getApiTest())) {
					strBuffer = new StringBuffer("");
					//
					if (itapConfigDTO.getApiTest().contains(",")) {
						String[] strSplits = itapConfigDTO.getApiTest().split(",");
						for (int i = 0; i < strSplits.length; i++) {
							strBuffer.append("'").append(strSplits[i]).append("'");
							if (strSplits.length != i + 1)
								strBuffer.append(",");
						}
					} else {
						strBuffer.append("'").append(itapConfigDTO.getApiTest()).append("'");
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "APITESTING", strBuffer.toString()));
				}
				if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCases())) {
					if (itapConfigDTO.getSelectedTestCases().contains(",")) {
						String[] strSplits = itapConfigDTO.getSelectedTestCases().split(",");
						for (int i = 0; i < strSplits.length; i++) {
							strBuffer.append("'").append(strSplits[i]).append("'");
							if (strSplits.length != i + 1) {
								strBuffer.append(",");
							}
						}
					} else {
						strBuffer.append("'").append(itapConfigDTO.getSelectedTestCases())
								.append("'");
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "OPTIK", strBuffer.toString()));
				}
				if (itapConfigDTO.getSelectedTestCasesList() != null
						&& !itapConfigDTO.getSelectedTestCasesList().isEmpty()) {
					StringBuffer buffer = new StringBuffer();
					for (int i = 0; i < itapConfigDTO.getSelectedTestCasesList().size(); i++) {
						if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCasesList().get(i))
								&& !"null".equalsIgnoreCase(itapConfigDTO
										.getSelectedTestCasesList().get(i))) {
							buffer.append("'")
									.append(itapConfigDTO.getSelectedTestCasesList().get(i))
									.append("'");
							if (itapConfigDTO.getSelectedTestCasesList().size() != i + 1)
								buffer.append(",");
						}
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "UFT','Mobile", buffer.toString()));
				}
				if (null != result && !result.isEmpty()) {
					for (ITAPToolTestCaseDO dos : result)
						lstTestCaseName.add(dos.getTestCaseId() + "");
				}
				List<String> lst = new ArrayList<String>(lstTestCaseName);
				Map<String, Long> mapResult = null;
				if (null != lst && !lst.isEmpty()) {
					mapResult = itapTdmIntegrateDAO.getTcFrameworkConfValDOSize(entityManager, lst);
				}
				// for (int i = 0; i <
				// itapConfigDTO.getApiTestingTestCasesList().size(); i++) {
				if (mapResult != null && !mapResult.isEmpty()) {
					for (Map.Entry<String, Long> mapEntry : mapResult.entrySet()) {
						for (ITAPToolTestCaseDO dos : result) {
							if (!mapEntry.getKey().equalsIgnoreCase("" + dos.getTestCaseId())) {
								// dto.getListTDMBankReservationDTO().addAll(
								TDMBankReservationDTO dto = doAsynchCallForFetchRecords(
										dos.getTestCaseId() + "", dos.getTestCase(),
										dos.getTdmCriteria(),
										dos.getTdmNoOfRecords() != null ? dos.getTdmNoOfRecords()
												: 0);
								if (dto != null && null != dto.getListTDMBankReservationDTO()
										&& !dto.getListTDMBankReservationDTO().isEmpty())
									itapTdmIntegrateDAO.saveTestCaseResultDetails(entityManager,
											dto);
							}
						}
						// if
						// (lst.get(i).getTestCaseId().equalsIgnoreCase(mapEntry.getKey()))
						// {
						/*
						 * if (lstTestCaseName.contains(mapEntry.getKey())) { }
						 * else { TDMBankReservationDTO dto =
						 * doAsynchCallForFetchRecords( dos.getTestCaseId()+"",
						 * dos.getTestCase(), dos.getTdmCriteria(),
						 * dos.getTdmNoOfRecords()); if(dto != null && null !=
						 * dto.getListTDMBankReservationDTO() &&
						 * !dto.getListTDMBankReservationDTO().isEmpty())
						 * itapTdmIntegrateDAO
						 * .saveTestCaseResultDetails(manager, dto);
						 * dto.getListTDMBankReservationDTO().addAll(
						 * doAsynchCallForFetchRecords( mapEntry.getKey(),
						 * mapEntry.getKey(), "", mapEntry.getValue())
						 * .getListTDMBankReservationDTO()); }
						 */
					}
				} else {
					for (ITAPToolTestCaseDO dos : result) {
						TDMBankReservationDTO dto = doAsynchCallForFetchRecords(dos.getTestCaseId()
								+ "", dos.getTestCase(), dos.getTdmCriteria(),
								dos.getTdmNoOfRecords() != null ? dos.getTdmNoOfRecords() : 0);
						if (dto != null && null != dto.getListTDMBankReservationDTO()
								&& !dto.getListTDMBankReservationDTO().isEmpty())
							itapTdmIntegrateDAO.saveTestCaseResultDetails(entityManager, dto);
					}
				}
				closeUserEntityManager(entityManager);
				return lstTestCaseName;
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void doCheckTestData(List<String> lstTestCaseName) {
		EntityManager entityManager = null;
		try {
			entityManager = openUserEntityManager();
			// List<String> lstTestCaseName = new ArrayList<String>();
			StringBuffer strTestCases = new StringBuffer("");
			if (lstTestCaseName != null && !lstTestCaseName.isEmpty()) {
				for (int i = 0; i < lstTestCaseName.size(); i++) {
					strTestCases.append("'").append(lstTestCaseName.get(i)).append("'");
					if (lstTestCaseName.size() != i + 1)
						strTestCases.append(",");
				}

				List<ITAPToolTestCaseDO> result = itapToolTestCaseDAO.getITAPToolTestCaseDOList(
						entityManager, strTestCases.toString());

				/*
				 * for(ITAPToolTestCaseDO dos : result)
				 * lstTestCaseName.add(dos.getTestCaseId()+"");
				 */
				Map<String, Long> mapResult = itapTdmIntegrateDAO.getTcFrameworkConfValDOSize(
						entityManager, lstTestCaseName);
				// for (int i = 0; i <
				// itapConfigDTO.getApiTestingTestCasesList().size(); i++) {
				if (mapResult != null && !mapResult.isEmpty()) {
					for (Map.Entry<String, Long> mapEntry : mapResult.entrySet()) {
						for (ITAPToolTestCaseDO dos : result) {
							if (!mapEntry.getKey().equalsIgnoreCase("" + dos.getTestCaseId())) {
								// dto.getListTDMBankReservationDTO().addAll(
								TDMBankReservationDTO dto = doAsynchCallForFetchRecords(
										dos.getTestCaseId() + "", dos.getTestCase(),
										dos.getTdmCriteria(),
										dos.getTdmNoOfRecords() != null ? dos.getTdmNoOfRecords()
												: 0);
								if (dto != null && null != dto.getListTDMBankReservationDTO()
										&& !dto.getListTDMBankReservationDTO().isEmpty())
									itapTdmIntegrateDAO.saveTestCaseResultDetails(entityManager,
											dto);
							}
						}
						// if
						// (lst.get(i).getTestCaseId().equalsIgnoreCase(mapEntry.getKey()))
						// {
						/*
						 * if (lstTestCaseName.contains(mapEntry.getKey())) { }
						 * else { TDMBankReservationDTO dto =
						 * doAsynchCallForFetchRecords( dos.getTestCaseId()+"",
						 * dos.getTestCase(), dos.getTdmCriteria(),
						 * dos.getTdmNoOfRecords()); if(dto != null && null !=
						 * dto.getListTDMBankReservationDTO() &&
						 * !dto.getListTDMBankReservationDTO().isEmpty())
						 * itapTdmIntegrateDAO
						 * .saveTestCaseResultDetails(manager, dto);
						 * dto.getListTDMBankReservationDTO().addAll(
						 * doAsynchCallForFetchRecords( mapEntry.getKey(),
						 * mapEntry.getKey(), "", mapEntry.getValue())
						 * .getListTDMBankReservationDTO()); }
						 */
					}
				} else {
					for (ITAPToolTestCaseDO dos : result) {
						TDMBankReservationDTO dto = doAsynchCallForFetchRecords(dos.getTestCaseId()
								+ "", dos.getTestCase(), dos.getTdmCriteria(),
								dos.getTdmNoOfRecords() != null ? dos.getTdmNoOfRecords() : 0);
						if (dto != null && null != dto.getListTDMBankReservationDTO()
								&& !dto.getListTDMBankReservationDTO().isEmpty())
							itapTdmIntegrateDAO.saveTestCaseResultDetails(entityManager, dto);
					}
				}
				closeUserEntityManager(entityManager);
			}
			// }
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	public TDMBankReservationDTO doAsynchCallForFetchRecords(String testCaseId,
			String testCaseName, String testCriteria, long noOfRecords)
			throws MalformedURLException, IOException {
		HttpURLConnection con = (HttpURLConnection) new URL(TDM_URL
				+ "servicesFTDWithReserve?TestCaseId=" + testCaseId + "&TestCaseName="
				+ testCaseName.replaceAll(" ", "") + "&" + testCriteria).openConnection();
		con.setRequestMethod("GET");
		TDMBankReservationDTO dto = null;
		InputStream inputStream;
		try {
			inputStream = con.getInputStream();
			JAXBContext context = JAXBContext.newInstance(TDMBankReservationDTO.class);
			Unmarshaller shaller = context.createUnmarshaller();
			dto = (TDMBankReservationDTO) shaller.unmarshal(inputStream);
		} catch (final Exception e) {
			inputStream = con.getErrorStream();
			// ret.setFailure(e);
		}
		return dto;
	}

	public int doAsynchCallForTDMUnreserveRecords(String accountNumbers)
			throws MalformedURLException, IOException {
		HttpURLConnection con = (HttpURLConnection) new URL(TDM_URL
				+ "serviceUnreserve?AccountNumbers=" + accountNumbers).openConnection();
		con.setRequestMethod("GET");
		InputStream inputStream;
		int iCount = 0;
		try {
			inputStream = con.getInputStream();
			JAXBContext context = JAXBContext.newInstance(Integer.class);
			Unmarshaller shaller = context.createUnmarshaller();
			iCount = (Integer) shaller.unmarshal(inputStream);
		} catch (final Exception e) {
			inputStream = con.getErrorStream();
			// ret.setFailure(e);
		}
		return iCount;
	}

	@Override
	public List<String> getSelectedTestCasesId(ITAPConfigDTO itapConfigDTO) {
		EntityManager entityManager = null;
		try {
			entityManager = openUserEntityManager();
			List<String> lstTestCaseName = new ArrayList<String>();
			if (itapConfigDTO != null) {
				StringBuffer strBuffer = new StringBuffer("");
				List<ITAPToolTestCaseDO> result = new ArrayList<ITAPToolTestCaseDO>();
				if (StringUtils.isNotEmpty(itapConfigDTO.getBddSct())) {
					// result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(entityManager,
					// "BDD", itapConfigDTO.getBddSct()));
					if (itapConfigDTO.getBddSct().contains(",")) {
						String[] strSplits = itapConfigDTO.getBddSct().split(",");
						for (int i = 0; i < strSplits.length; i++) {
							strBuffer.append("'").append(strSplits[i]).append("'");
							if (strSplits.length != i + 1)
								strBuffer.append(",");
						}
					} else {
						strBuffer.append("'").append(itapConfigDTO.getBddSct()).append("'");
						// lstTestCaseName.add(itapConfigDTO.getBddSct());
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "BDD", strBuffer.toString()));
				}
				if (StringUtils.isNotEmpty(itapConfigDTO.getApiTest())) {
					strBuffer = new StringBuffer("");
					//
					if (itapConfigDTO.getApiTest().contains(",")) {
						String[] strSplits = itapConfigDTO.getApiTest().split(",");
						for (int i = 0; i < strSplits.length; i++) {
							strBuffer.append("'").append(strSplits[i]).append("'");
							if (strSplits.length != i + 1)
								strBuffer.append(",");
						}
					} else {
						strBuffer.append("'").append(itapConfigDTO.getApiTest()).append("'");
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "APITESTING", strBuffer.toString()));
				}
				if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCases())) {
					if (itapConfigDTO.getSelectedTestCases().contains(",")) {
						String[] strSplits = itapConfigDTO.getSelectedTestCases().split(",");
						for (int i = 0; i < strSplits.length; i++) {
							strBuffer.append("'").append(strSplits[i]).append("'");
							if (strSplits.length != i + 1) {
								strBuffer.append(",");
							}
						}
					} else {
						strBuffer.append("'").append(itapConfigDTO.getSelectedTestCases())
								.append("'");
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "OPTIK", strBuffer.toString()));
				}
				if (itapConfigDTO.getSelectedTestCasesList() != null
						&& !itapConfigDTO.getSelectedTestCasesList().isEmpty()) {
					StringBuffer buffer = new StringBuffer();
					for (int i = 0; i < itapConfigDTO.getSelectedTestCasesList().size(); i++) {
						if (StringUtils.isNotEmpty(itapConfigDTO.getSelectedTestCasesList().get(i))
								&& !"null".equalsIgnoreCase(itapConfigDTO
										.getSelectedTestCasesList().get(i))) {
							buffer.append("'")
									.append(itapConfigDTO.getSelectedTestCasesList().get(i))
									.append("'");
							if (itapConfigDTO.getSelectedTestCasesList().size() != i + 1)
								buffer.append(",");
						}
					}
					result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(
							entityManager, "UFT','Mobile", buffer.toString()));
				}
				for (ITAPToolTestCaseDO dos : result)
					lstTestCaseName.add(dos.getTestCaseId() + "");
				return lstTestCaseName;
			}
		} catch (final Exception e) {
			// inputStream = con.getErrorStream();
			// ret.setFailure(e);
			return null;
		} finally {
			if (entityManager != null)
				closeUserEntityManager(entityManager);
		}
		return null;
	}

	@Override
	public void doCheckTestData(String testCasesIds) {
		EntityManager entityManager = null;
		try {
			entityManager = openUserEntityManager();
			Set<String> lstTestCaseName = new HashSet<String>();
			if (StringUtils.isNotEmpty(testCasesIds)) {
				List<ITAPToolTestCaseDO> result = new ArrayList<ITAPToolTestCaseDO>();
				result.addAll(itapToolTestCaseDAO.getITAPToolTestCaseDOListForTDM(entityManager,
						null, testCasesIds));
				if (result != null && !result.isEmpty()) {
					for (ITAPToolTestCaseDO dos : result)
						lstTestCaseName.add(dos.getTestCaseId() + "");
				}
				List<String> lst = new ArrayList<String>(lstTestCaseName);
				Map<String, Long> mapResult = null;
				if (lst != null && !lst.isEmpty()) {
					mapResult = itapTdmIntegrateDAO.getTcFrameworkConfValDOSize(entityManager, lst);
				}
				// for (int i = 0; i <
				// itapConfigDTO.getApiTestingTestCasesList().size(); i++) {
				if (mapResult != null && !mapResult.isEmpty()) {
					for (Map.Entry<String, Long> mapEntry : mapResult.entrySet()) {
						for (ITAPToolTestCaseDO dos : result) {
							if (!mapEntry.getKey().equalsIgnoreCase("" + dos.getTestCaseId())) {
								// dto.getListTDMBankReservationDTO().addAll(
								TDMBankReservationDTO dto = doAsynchCallForFetchRecords(
										dos.getTestCaseId() + "", dos.getTestCase(),
										dos.getTdmCriteria(),
										dos.getTdmNoOfRecords() != null ? dos.getTdmNoOfRecords()
												: 0);
								if (dto != null && null != dto.getListTDMBankReservationDTO()
										&& !dto.getListTDMBankReservationDTO().isEmpty())
									itapTdmIntegrateDAO.saveTestCaseResultDetails(entityManager,
											dto);
							}
						}
						// if
						// (lst.get(i).getTestCaseId().equalsIgnoreCase(mapEntry.getKey()))
						// {
						/*
						 * if (lstTestCaseName.contains(mapEntry.getKey())) { }
						 * else { TDMBankReservationDTO dto =
						 * doAsynchCallForFetchRecords( dos.getTestCaseId()+"",
						 * dos.getTestCase(), dos.getTdmCriteria(),
						 * dos.getTdmNoOfRecords()); if(dto != null && null !=
						 * dto.getListTDMBankReservationDTO() &&
						 * !dto.getListTDMBankReservationDTO().isEmpty())
						 * itapTdmIntegrateDAO
						 * .saveTestCaseResultDetails(manager, dto);
						 * dto.getListTDMBankReservationDTO().addAll(
						 * doAsynchCallForFetchRecords( mapEntry.getKey(),
						 * mapEntry.getKey(), "", mapEntry.getValue())
						 * .getListTDMBankReservationDTO()); }
						 */
					}
				} else {
					for (ITAPToolTestCaseDO dos : result) {
						TDMBankReservationDTO dto = doAsynchCallForFetchRecords(dos.getTestCaseId()
								+ "", dos.getTestCase(), dos.getTdmCriteria(),
								dos.getTdmNoOfRecords() != null ? dos.getTdmNoOfRecords() : 0);
						if (dto != null && null != dto.getListTDMBankReservationDTO()
								&& !dto.getListTDMBankReservationDTO().isEmpty())
							itapTdmIntegrateDAO.saveTestCaseResultDetails(entityManager, dto);
					}
				}

				List<TestCaseDO> lstTestData = itapTdmIntegrateDAO.getTestCaseDOList(entityManager,
						testCasesIds);
				StringBuffer strUpdateTestCasesId = new StringBuffer("");
				for (TestCaseDO caseDO : lstTestData) {
					if (!strUpdateTestCasesId.toString().trim().isEmpty())
						strUpdateTestCasesId.append(",");
					strUpdateTestCasesId.append(caseDO.getTcId());
				}
				if (StringUtils.isNotEmpty(strUpdateTestCasesId.toString()))
					itapToolTestCaseDAO.updateTdmIntegratedData(entityManager,
							strUpdateTestCasesId.toString(), true);
				closeUserEntityManager(entityManager);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void unreserveRecordsFromTDM(String testCasesIds) {
		EntityManager entityManager = null;
		try {
			entityManager = openUserEntityManager();
			// doAsynchCallForTDMUnreserveRecords
			if (testCasesIds != null) {
				List<String> lst = itapTdmIntegrateDAO.getTcFrameworkConfValDOs(entityManager,
						testCasesIds);
				StringBuffer accountNumbers = new StringBuffer("");
				if (lst != null && !lst.isEmpty()) {
					for (String dos : lst) {
						if (!accountNumbers.toString().trim().isEmpty())
							accountNumbers.append(",");
						// following code is hardcoded as per dao layer
						accountNumbers.append(dos);
					}
					int iResult = doAsynchCallForTDMUnreserveRecords(accountNumbers.toString());

					itapTdmIntegrateDAO.unreserveTdmData(entityManager, testCasesIds);
					itapToolTestCaseDAO.updateTdmIntegratedData(entityManager, testCasesIds, false);

					if (lst.size() == iResult) {

					} else {
						// needs to rollback transaction

					}
				}
				closeUserEntityManager(entityManager);
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
