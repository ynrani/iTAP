package com.itap.service;

import java.util.List;

import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPCrossBrowserGridDO;
import com.itap.model.DO.ITAPCrossBrowserOS;
import com.itap.model.DO.ITAPToolTestCaseDO;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.model.DTO.ITAPConfigDTO;
import com.itap.model.DTO.ITAPCrossBrowserTestsuite;
import com.itap.model.DTO.ITAPProgressDTO;
import com.itap.model.DTO.ITAPSearchBookingDTO;
import com.itap.model.DTO.ITAPTrainViewDTO;

public interface ITAPConfigService {
	List<ITAPTrainViewDO> getJobsByProjectName(String projectName);

	ITAPConfigDTO selectConfigToEdit(String id, ITAPConfigDTO itapConfigDTO)
			throws ServiceException;

	ITAPConfigDTO saveConfigDetails(ITAPConfigDTO itapConfigDTO) throws ServiceException;

	List<ITAPConfigDTO> configurationView(int offSet, int recordsperpage, boolean b, String userId,
			ITAPConfigDTO itapConfigDTO) throws ServiceException;

	String deleteConfiguration(String id, long serverId) throws ServiceException;

	String deleteConfigurationFromTeamCity(String jobName, long serverId) throws ServiceException;

	String buildJob(String id, long serverId) throws ServiceException;

	List<String> getAllJobNames(String projName, long serverId) throws ServiceException;

	List<String> allProjs() throws ServiceException;

	ITAPConfigDTO configurationEdit(String job, long serverId) throws ServiceException;

	List<ITAPProgressDTO> itapGetLast5Builds(String job, long serverId) throws ServiceException;

	List<ITAPCrossBrowserTestsuite> getTestSuiteList(String folderPath);

	List<ITAPCrossBrowserGridDO> getGidList() throws ServiceException;

	List<ITAPCrossBrowserOS> getOSList() throws ServiceException;

	List<String> getBrowserList(final int osId) throws ServiceException;

	List<String> getBrowserList(final int osId, final String browserName) throws ServiceException;

	List<ITAPToolTestCaseDO> getTestCaseList(final String toolName, String toolColumn,
			String toolColumnValue) throws ServiceException;

	List<ITAPToolTestCaseDO> getTestCaseList(final String toolName, String toolColumn,
			String toolColumnValue, String testSuite) throws ServiceException;

	List<String> allEnvs() throws ServiceException;

	List<String> getToolColumnValues(final String toolName, final String toolColumn)
			throws ServiceException;

	List<ITAPTrainViewDTO> configurationTrainView(int offSet, int recordsperpage, boolean b,
			String attribute, ITAPTrainViewDTO itapTrainViewDTO) throws ServiceException;

	String deleteTrain(String id, String jobs, long serverId) throws ServiceException;

	List<String> getTestCaseListForTestSuite(String folderPath, String testSuiteName);

	ITAPSearchBookingDTO checkEnvAvilability(String envId) throws ServiceException;

	List<ITAPToolTestCaseDO> toolBasedTestCasesList(String toolName) throws ServiceException;

	List<String> optikTestSuiteList() throws ServiceException;

	List<ITAPToolTestCaseDO> getOTCForSeleTS(String testSuite) throws ServiceException;

	List<String> getOTCForSeleTS(String toolColumnName, String testSuite) throws ServiceException;

	List<String> getDeviceNameList(int gridUrlId) throws ServiceException;

	List<String> getDeviceListForGivenDeviceName(String deviceName, int gridId)
			throws ServiceException;

	List<ITAPCrossBrowserGridDO> fetchUrlsForGridType(String gridType) throws ServiceException;

	List<String> getTestCaseListByJobsNames(List<String> lstJobs) throws ServiceException;

	List<ITAPConfigDTO> configurationViewTeamCity(ITAPConfigDTO itapConfigDTO)
			throws ServiceException;

	String configurationJobBuildTeamCity(String id, long serverId) throws ServiceException;

	String getTrainJob(String trainId, long serverId) throws ServiceException;

	JenkinsConfigDO getCiDetails(long id) throws ServiceException;
}
