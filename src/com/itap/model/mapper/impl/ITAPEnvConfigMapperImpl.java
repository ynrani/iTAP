/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigMapperImpl.Java
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
package com.itap.model.mapper.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itap.model.DO.ITAPEnvConfigDO;
import com.itap.model.DO.JenkinsConfigDO;
import com.itap.model.DTO.ITAPEnvConfigDTO;
import com.itap.model.DTO.JenkinsConfigDTO;
import com.itap.model.mapper.ITAPEnvConfigMapper;

@Component
@Service("itapEnvConfigMapper")
public class ITAPEnvConfigMapperImpl implements ITAPEnvConfigMapper {
	@Override
	public ITAPEnvConfigDTO convertFromITAPEnvConfigDOToITAPEnvConfigDTO(
			ITAPEnvConfigDO itapEnvConfigDO, ITAPEnvConfigDTO itapEnvConfigDTO) {
		try {
			if (itapEnvConfigDO.getEnvConfigId() > 0) {
				itapEnvConfigDTO.setEnvConfigId(String.valueOf(itapEnvConfigDO.getEnvConfigId()));
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getActionBy())) {
				itapEnvConfigDTO.setActionBy(itapEnvConfigDO.getActionBy());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvDesc())) {
				itapEnvConfigDTO.setEnvDesc(itapEnvConfigDO.getEnvDesc());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvDockUrl())) {
				itapEnvConfigDTO.setEnvDockUrl(itapEnvConfigDO.getEnvDockUrl());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvHost())) {
				itapEnvConfigDTO.setEnvHost(itapEnvConfigDO.getEnvHost());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvIp())) {
				itapEnvConfigDTO.setEnvIp(itapEnvConfigDO.getEnvIp());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvName())) {
				itapEnvConfigDTO.setEnvName(itapEnvConfigDO.getEnvName());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvPassowrd())) {
				itapEnvConfigDTO.setEnvPassowrd(itapEnvConfigDO.getEnvPassowrd());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvSsl())) {
				itapEnvConfigDTO.setEnvSsl(itapEnvConfigDO.getEnvSsl());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvType())) {
				itapEnvConfigDTO.setEnvType(itapEnvConfigDO.getEnvType());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDO.getEnvUserName())) {
				itapEnvConfigDTO.setEnvUserName(itapEnvConfigDO.getEnvUserName());
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapEnvConfigDTO;
	}

	@Override
	public ITAPEnvConfigDO convertFromITAPEnvConfigDTOToITAPEnvConfigDO(
			ITAPEnvConfigDTO itapEnvConfigDTO, ITAPEnvConfigDO itapEnvConfigDO) {
		try {
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvConfigId())) {
				itapEnvConfigDO.setEnvConfigId(Long.parseLong(itapEnvConfigDTO.getEnvConfigId()));
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getActionBy())) {
				itapEnvConfigDO.setActionBy(itapEnvConfigDTO.getActionBy());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvDesc())) {
				itapEnvConfigDO.setEnvDesc(itapEnvConfigDTO.getEnvDesc());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvDockUrl())) {
				itapEnvConfigDO.setEnvDockUrl(itapEnvConfigDTO.getEnvDockUrl());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvHost())) {
				itapEnvConfigDO.setEnvHost(itapEnvConfigDTO.getEnvHost());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvIp())) {
				itapEnvConfigDO.setEnvIp(itapEnvConfigDTO.getEnvIp());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvName())) {
				itapEnvConfigDO.setEnvName(itapEnvConfigDTO.getEnvName());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvPassowrd())) {
				itapEnvConfigDO.setEnvPassowrd(itapEnvConfigDTO.getEnvPassowrd());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvSsl())) {
				itapEnvConfigDO.setEnvSsl(itapEnvConfigDTO.getEnvSsl());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvType())) {
				itapEnvConfigDO.setEnvType(itapEnvConfigDTO.getEnvType());
			}
			if (StringUtils.isNotEmpty(itapEnvConfigDTO.getEnvUserName())) {
				itapEnvConfigDO.setEnvUserName(itapEnvConfigDTO.getEnvUserName());
			}

			itapEnvConfigDO.setActionBy(itapEnvConfigDO.getActionBy());
			itapEnvConfigDO.setActionDt(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapEnvConfigDO;
	}

	@Override
	public JenkinsConfigDTO convertFromJenkinsConfigDOToJenkinsConfigDTO(
			JenkinsConfigDO jenkinsConfigDO, JenkinsConfigDTO jenkinsConfigDTO) {
		try {
			if (jenkinsConfigDO.getJenkinsId() > 0) {
				jenkinsConfigDTO.setJenkinsId(jenkinsConfigDO.getJenkinsId());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDO.getActionBy())) {
				jenkinsConfigDTO.setActionBy(jenkinsConfigDO.getActionBy());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDO.getJenkinsName())) {
				jenkinsConfigDTO.setJenkinsName(jenkinsConfigDO.getJenkinsName());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDO.getUrl())) {
				jenkinsConfigDTO.setUrl(jenkinsConfigDO.getUrl());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDO.getUserName())) {
				jenkinsConfigDTO.setUserName(jenkinsConfigDO.getUserName());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDO.getPass())) {
				jenkinsConfigDTO.setPass(jenkinsConfigDO.getPass());
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return jenkinsConfigDTO;
	}

	@Override
	public JenkinsConfigDO convertFromJenkinsConfigDTOToJenkinsConfigDO(
			JenkinsConfigDTO jenkinsConfigDTO, JenkinsConfigDO jenkinsConfigDO) {
		try {
			if (0 < jenkinsConfigDTO.getJenkinsId()) {
				jenkinsConfigDO.setJenkinsId(jenkinsConfigDTO.getJenkinsId());
			}

			if (StringUtils.isNotEmpty(jenkinsConfigDTO.getActionBy())) {
				jenkinsConfigDO.setActionBy(jenkinsConfigDTO.getActionBy());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDTO.getJenkinsName())) {
				jenkinsConfigDO.setJenkinsName(jenkinsConfigDTO.getJenkinsName());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDTO.getUrl())) {
				jenkinsConfigDO.setUrl(jenkinsConfigDTO.getUrl());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDTO.getUserName())) {
				jenkinsConfigDO.setUserName(jenkinsConfigDTO.getUserName());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDTO.getPass())) {
				jenkinsConfigDO.setPass(jenkinsConfigDTO.getPass());
			}
			if (StringUtils.isNotEmpty(jenkinsConfigDTO.getCiName())) {
				jenkinsConfigDO.setCiName(jenkinsConfigDTO.getCiName());
			}
			jenkinsConfigDO.setActionBy(jenkinsConfigDTO.getActionBy());
			jenkinsConfigDO.setActionDt(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return jenkinsConfigDO;
	}

	@Override
	public List<JenkinsConfigDO> convertFromJenkinsConfigDTOToJenkinsConfigDOList(
			JenkinsConfigDTO jenkinsConfigDTO, List<JenkinsConfigDO> jenkinsConfigDOList) {

		/*
		 * JenkinsConfigDO jenkinsConfigDO = new JenkinsConfigDO();
		 * JenkinsConfigDO teamCityConfigDO = new JenkinsConfigDO();
		 * 
		 * try {
		 * 
		 * if (0 < jenkinsConfigDTO.getJenkinsId()) {
		 * jenkinsConfigDO.setJenkinsId(jenkinsConfigDTO.getJenkinsId()); }
		 * 
		 * if (StringUtils.isNotEmpty(jenkinsConfigDTO.getActionBy())) {
		 * jenkinsConfigDO.setActionBy(jenkinsConfigDTO.getActionBy()); } if
		 * (StringUtils.isNotEmpty(jenkinsConfigDTO.getJenkinsName())) {
		 * jenkinsConfigDO.setJenkinsName(jenkinsConfigDTO.getJenkinsName()); }
		 * if (StringUtils.isNotEmpty(jenkinsConfigDTO.getUrl())) {
		 * jenkinsConfigDO.setUrl(jenkinsConfigDTO.getUrl()); } if
		 * (StringUtils.isNotEmpty(jenkinsConfigDTO.getUserName())) {
		 * jenkinsConfigDO.setUserName(jenkinsConfigDTO.getUserName()); } if
		 * (StringUtils.isNotEmpty(jenkinsConfigDTO.getPass())) {
		 * jenkinsConfigDO.setPass(jenkinsConfigDTO.getPass()); } if
		 * (StringUtils.isNotEmpty(jenkinsConfigDTO.getCiName())) {
		 * jenkinsConfigDO.setCiName(jenkinsConfigDTO.getCiName()); }
		 * jenkinsConfigDO.setActionBy(jenkinsConfigDTO.getActionBy());
		 * jenkinsConfigDO.setActionDt(new Timestamp(new Date().getTime()));
		 * 
		 * if (0 < jenkinsConfigDTO.getTeamCityServerId()) {
		 * teamCityConfigDO.setJenkinsId
		 * (jenkinsConfigDTO.getTeamCityServerId()); }
		 * 
		 * if (StringUtils.isNotEmpty(jenkinsConfigDTO.getTeamCityActionBy())) {
		 * teamCityConfigDO.setActionBy(jenkinsConfigDTO.getTeamCityActionBy());
		 * } if (StringUtils.isNotEmpty(jenkinsConfigDTO.getTeamCityName())) {
		 * teamCityConfigDO.setJenkinsName(jenkinsConfigDTO.getTeamCityName());
		 * } if (StringUtils.isNotEmpty(jenkinsConfigDTO.getTeamCityUrl())) {
		 * teamCityConfigDO.setUrl(jenkinsConfigDTO.getTeamCityUrl()); } if
		 * (StringUtils.isNotEmpty(jenkinsConfigDTO.getTeamCityUserName())) {
		 * teamCityConfigDO.setUserName(jenkinsConfigDTO.getTeamCityUserName());
		 * } if (StringUtils.isNotEmpty(jenkinsConfigDTO.getTeamCityPass())) {
		 * teamCityConfigDO.setPass(jenkinsConfigDTO.getTeamCityPass()); } if
		 * (StringUtils.isNotEmpty(jenkinsConfigDTO.getTeamCityPass())) {
		 * teamCityConfigDO.setCiName(jenkinsConfigDTO.getTeamCityCiName()); }
		 * teamCityConfigDO.setActionBy(jenkinsConfigDTO.getTeamCityActionBy());
		 * teamCityConfigDO.setActionDt(new Timestamp(new Date().getTime()));
		 * 
		 * jenkinsConfigDOList.add(jenkinsConfigDO);
		 * jenkinsConfigDOList.add(teamCityConfigDO);
		 * 
		 * } catch (Throwable t) { t.printStackTrace(); }
		 */
		return jenkinsConfigDOList;
	}

	@Override
	public JenkinsConfigDTO convertFromJenkinsConfigDOToJenkinsConfigDTO(
			List<JenkinsConfigDO> jenkinsList, JenkinsConfigDTO jenkinsConfigDTO) {

		List<JenkinsConfigDTO> jenkinsDTOList = jenkinsConfigDTO.getJenkinsDTOList();

		for (JenkinsConfigDO jenkinsConfigDO : jenkinsList) {

			JenkinsConfigDTO tempJenkinsConfigDTO = new JenkinsConfigDTO();
			try {
				if (jenkinsConfigDO.getJenkinsId() > 0) {
					tempJenkinsConfigDTO.setJenkinsId(jenkinsConfigDO.getJenkinsId());
				}
				if (StringUtils.isNotEmpty(jenkinsConfigDO.getActionBy())) {
					tempJenkinsConfigDTO.setActionBy(jenkinsConfigDO.getActionBy());
				}
				if (StringUtils.isNotEmpty(jenkinsConfigDO.getJenkinsName())) {
					tempJenkinsConfigDTO.setJenkinsName(jenkinsConfigDO.getJenkinsName());
				}
				if (StringUtils.isNotEmpty(jenkinsConfigDO.getUrl())) {
					tempJenkinsConfigDTO.setUrl(jenkinsConfigDO.getUrl());
				}
				if (StringUtils.isNotEmpty(jenkinsConfigDO.getUserName())) {
					tempJenkinsConfigDTO.setUserName(jenkinsConfigDO.getUserName());
				}
				if (StringUtils.isNotEmpty(jenkinsConfigDO.getPass())) {
					tempJenkinsConfigDTO.setPass(jenkinsConfigDO.getPass());
				}
				if (StringUtils.isNotEmpty(jenkinsConfigDO.getCiName())) {
					tempJenkinsConfigDTO.setCiName(jenkinsConfigDO.getCiName());
				}

			} catch (Throwable t) {
				t.printStackTrace();
			}
			jenkinsDTOList.add(tempJenkinsConfigDTO);

			/*
			 * } else if
			 * (jenkinsConfigDO.getCiName().equalsIgnoreCase("TeamCity")) { try
			 * { if (jenkinsConfigDO.getJenkinsId() > 0) {
			 * jenkinsConfigDTO.setTeamCityServerId
			 * (jenkinsConfigDO.getJenkinsId()); } if
			 * (StringUtils.isNotEmpty(jenkinsConfigDO.getActionBy())) {
			 * jenkinsConfigDTO
			 * .setTeamCityActionBy(jenkinsConfigDO.getActionBy()); } if
			 * (StringUtils.isNotEmpty(jenkinsConfigDO.getJenkinsName())) {
			 * jenkinsConfigDTO
			 * .setTeamCityName(jenkinsConfigDO.getJenkinsName()); } if
			 * (StringUtils.isNotEmpty(jenkinsConfigDO.getUrl())) {
			 * jenkinsConfigDTO.setTeamCityUrl(jenkinsConfigDO.getUrl()); } if
			 * (StringUtils.isNotEmpty(jenkinsConfigDO.getUserName())) {
			 * jenkinsConfigDTO
			 * .setTeamCityUserName(jenkinsConfigDO.getUserName()); } if
			 * (StringUtils.isNotEmpty(jenkinsConfigDO.getPass())) {
			 * jenkinsConfigDTO.setTeamCityPass(jenkinsConfigDO.getPass()); } if
			 * (StringUtils.isNotEmpty(jenkinsConfigDO.getCiName())) {
			 * jenkinsConfigDTO.setTeamCityCiName(jenkinsConfigDO.getCiName());
			 * }
			 * 
			 * } catch (Throwable t) { t.printStackTrace(); } }
			 */
		}

		return jenkinsConfigDTO;
	}
}

/**
 * Total String Fields in DO = 10
 *
 * Total BigDecimal Fields in DO = 0
 *
 * Total Date Fields in DO = 0
 *
 * Total Byte Fields in DO = 0
 *
 * Total Long Fields in DO = 1
 *
 * Total List Fields in DO = 0
 *
 * Above Fields does not include count for ActionBy and ActionDate Fields and
 * Serial Version Id
 **/

