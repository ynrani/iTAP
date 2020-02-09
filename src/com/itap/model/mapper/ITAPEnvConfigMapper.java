/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigMapper.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          03/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.model.mapper;

import java.util.List;

import com.itap.model.DO.ITAPEnvConfigDO;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.model.DTO.ITAPEnvConfigDTO;
import com.itap.model.DTO.JenkinsConfigDTO;

public interface ITAPEnvConfigMapper {
	public ITAPEnvConfigDTO convertFromITAPEnvConfigDOToITAPEnvConfigDTO(
			ITAPEnvConfigDO itapEnvConfigDO, ITAPEnvConfigDTO itapEnvConfigDTO);

	public ITAPEnvConfigDO convertFromITAPEnvConfigDTOToITAPEnvConfigDO(
			ITAPEnvConfigDTO itapEnvConfigDTO, ITAPEnvConfigDO itapEnvConfigDO);

	public JenkinsConfigDTO convertFromJenkinsConfigDOToJenkinsConfigDTO(
			JenkinsConfigDO jenkinsConfigDO, JenkinsConfigDTO jenkinsConfigDTO);

	public JenkinsConfigDO convertFromJenkinsConfigDTOToJenkinsConfigDO(
			JenkinsConfigDTO jenkinsConfigDTO, JenkinsConfigDO jenkinsConfigDO);

	public JenkinsConfigDTO convertFromJenkinsConfigDOToJenkinsConfigDTO(
			List<JenkinsConfigDO> jenkinsList, JenkinsConfigDTO jenkinsConfigDTO);

	public List<JenkinsConfigDO> convertFromJenkinsConfigDTOToJenkinsConfigDOList(
			JenkinsConfigDTO jenkinsConfigDTO, List<JenkinsConfigDO> jenkinsConfigDOList);

}
