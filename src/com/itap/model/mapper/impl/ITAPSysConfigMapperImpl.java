/*---------------------------------------------------------------------------------------
 * Object Name: ITAPSysConfigMapperImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          10/03/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.model.mapper.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itap.model.DO.ITAPConfAllFileDO;
import com.itap.model.DO.ITAPSysConfigDO;
import com.itap.model.DTO.ITAPConfAllFilesDTO;
import com.itap.model.DTO.ITAPSysConfigDTO;
import com.itap.model.mapper.ITAPSysConfigMapper;

@Component
@Service("itapSysConfigMapper")
public class ITAPSysConfigMapperImpl implements ITAPSysConfigMapper {
	@Override
	public ITAPSysConfigDTO convertFromITAPSysConfigDOToITAPSysConfigDTO(
			ITAPSysConfigDO itapSysConfigDO, ITAPSysConfigDTO itapSysConfigDTO) {
		try {
			if (itapSysConfigDO.getSysConfigId() > 0) {
				itapSysConfigDTO.setSysConfigId(String.valueOf(itapSysConfigDO
						.getSysConfigId()));
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getActionBy())) {
				itapSysConfigDTO.setActionBy(itapSysConfigDO.getActionBy());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getBddPassowrd())) {
				itapSysConfigDTO.setBddPassowrd(itapSysConfigDO.getBddPassowrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getBddTstMgmtTool())) {
				itapSysConfigDTO.setBddTstMgmtTool(itapSysConfigDO.getBddTstMgmtTool());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getBddUrl())) {
				itapSysConfigDTO.setBddUrl(itapSysConfigDO.getBddUrl());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getBddUserName())) {
				itapSysConfigDTO.setBddUserName(itapSysConfigDO.getBddUserName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafMobAutoTool())) {
				itapSysConfigDTO.setCafMobAutoTool(itapSysConfigDO.getCafMobAutoTool());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafMobResult())) {
				itapSysConfigDTO.setCafMobResult(itapSysConfigDO.getCafMobResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafMobTstCase())) {
				itapSysConfigDTO.setCafMobTstCase(itapSysConfigDO.getCafMobTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafNxtResult())) {
				itapSysConfigDTO.setCafNxtResult(itapSysConfigDO.getCafNxtResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafNxtTstCase())) {
				itapSysConfigDTO.setCafNxtTstCase(itapSysConfigDO.getCafNxtTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafSeleEclPath())) {
				itapSysConfigDTO.setCafSeleEclPath(itapSysConfigDO.getCafSeleEclPath());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafSeleResult())) {
				itapSysConfigDTO.setCafSeleResult(itapSysConfigDO.getCafSeleResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getCafSeleTstCase())) {
				itapSysConfigDTO.setCafSeleTstCase(itapSysConfigDO.getCafSeleTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getDbHostName())) {
				itapSysConfigDTO.setDbHostName(itapSysConfigDO.getDbHostName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getDbPassowrd())) {
				itapSysConfigDTO.setDbPassowrd(itapSysConfigDO.getDbPassowrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getDbPort())) {
				itapSysConfigDTO.setDbPort(itapSysConfigDO.getDbPort());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getDbUrl())) {
				itapSysConfigDTO.setDbUrl(itapSysConfigDO.getDbUrl());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getDbUserName())) {
				itapSysConfigDTO.setDbUserName(itapSysConfigDO.getDbUserName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getOptGrd())) {
				itapSysConfigDTO.setOptGrd(itapSysConfigDO.getOptGrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getOptResult())) {
				itapSysConfigDTO.setOptResult(itapSysConfigDO.getOptResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getOptTstCase())) {
				itapSysConfigDTO.setOptTstCase(itapSysConfigDO.getOptTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getScmPassowrd())) {
				itapSysConfigDTO.setScmPassowrd(itapSysConfigDO.getScmPassowrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getScmSource())) {
				itapSysConfigDTO.setScmSource(itapSysConfigDO.getScmSource());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getScmUrl())) {
				itapSysConfigDTO.setScmUrl(itapSysConfigDO.getScmUrl());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getScmUserName())) {
				itapSysConfigDTO.setScmUserName(itapSysConfigDO.getScmUserName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getTwistResult())) {
				itapSysConfigDTO.setTwistResult(itapSysConfigDO.getTwistResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getTwistTstCase())) {
				itapSysConfigDTO.setTwistTstCase(itapSysConfigDO.getTwistTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDO.getTwistXpathGen())) {
				itapSysConfigDTO.setTwistXpathGen(itapSysConfigDO.getTwistXpathGen());
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapSysConfigDTO;
	}

	@Override
	public ITAPSysConfigDO convertFromITAPSysConfigDTOToITAPSysConfigDO(
			ITAPSysConfigDTO itapSysConfigDTO, ITAPSysConfigDO itapSysConfigDO) {
		try {
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getSysConfigId())) {
				itapSysConfigDO.setSysConfigId(Long.parseLong(itapSysConfigDTO
						.getSysConfigId()));
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getActionBy())) {
				itapSysConfigDO.setActionBy(itapSysConfigDTO.getActionBy());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getBddPassowrd())) {
				itapSysConfigDO.setBddPassowrd(itapSysConfigDTO.getBddPassowrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getBddTstMgmtTool())) {
				itapSysConfigDO.setBddTstMgmtTool(itapSysConfigDTO.getBddTstMgmtTool());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getBddUrl())) {
				itapSysConfigDO.setBddUrl(itapSysConfigDTO.getBddUrl());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getBddUserName())) {
				itapSysConfigDO.setBddUserName(itapSysConfigDTO.getBddUserName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafMobAutoTool())) {
				itapSysConfigDO.setCafMobAutoTool(itapSysConfigDTO.getCafMobAutoTool());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafMobResult())) {
				itapSysConfigDO.setCafMobResult(itapSysConfigDTO.getCafMobResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafMobTstCase())) {
				itapSysConfigDO.setCafMobTstCase(itapSysConfigDTO.getCafMobTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafNxtResult())) {
				itapSysConfigDO.setCafNxtResult(itapSysConfigDTO.getCafNxtResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafNxtTstCase())) {
				itapSysConfigDO.setCafNxtTstCase(itapSysConfigDTO.getCafNxtTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafSeleEclPath())) {
				itapSysConfigDO.setCafSeleEclPath(itapSysConfigDTO.getCafSeleEclPath());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafSeleResult())) {
				itapSysConfigDO.setCafSeleResult(itapSysConfigDTO.getCafSeleResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getCafSeleTstCase())) {
				itapSysConfigDO.setCafSeleTstCase(itapSysConfigDTO.getCafSeleTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getDbHostName())) {
				itapSysConfigDO.setDbHostName(itapSysConfigDTO.getDbHostName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getDbPassowrd())) {
				itapSysConfigDO.setDbPassowrd(itapSysConfigDTO.getDbPassowrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getDbPort())) {
				itapSysConfigDO.setDbPort(itapSysConfigDTO.getDbPort());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getDbUrl())) {
				itapSysConfigDO.setDbUrl(itapSysConfigDTO.getDbUrl());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getDbUserName())) {
				itapSysConfigDO.setDbUserName(itapSysConfigDTO.getDbUserName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getOptGrd())) {
				itapSysConfigDO.setOptGrd(itapSysConfigDTO.getOptGrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getOptResult())) {
				itapSysConfigDO.setOptResult(itapSysConfigDTO.getOptResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getOptTstCase())) {
				itapSysConfigDO.setOptTstCase(itapSysConfigDTO.getOptTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getScmPassowrd())) {
				itapSysConfigDO.setScmPassowrd(itapSysConfigDTO.getScmPassowrd());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getScmSource())) {
				itapSysConfigDO.setScmSource(itapSysConfigDTO.getScmSource());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getScmUrl())) {
				itapSysConfigDO.setScmUrl(itapSysConfigDTO.getScmUrl());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getScmUserName())) {
				itapSysConfigDO.setScmUserName(itapSysConfigDTO.getScmUserName());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getTwistResult())) {
				itapSysConfigDO.setTwistResult(itapSysConfigDTO.getTwistResult());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getTwistTstCase())) {
				itapSysConfigDO.setTwistTstCase(itapSysConfigDTO.getTwistTstCase());
			}
			if (StringUtils.isNotEmpty(itapSysConfigDTO.getTwistXpathGen())) {
				itapSysConfigDO.setTwistXpathGen(itapSysConfigDTO.getTwistXpathGen());
			}

			itapSysConfigDO.setActionBy(itapSysConfigDTO.getActionBy());
			itapSysConfigDO.setActionDt(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapSysConfigDO;
	}

	@Override
	public ITAPConfAllFilesDTO convertFromITAPConfAllFileDOToITAPConfAllFilesDTO(
			ITAPConfAllFileDO itapConfAllFileDO, ITAPConfAllFilesDTO itapConfAllFilesDTO) {
		try {
			if (null != itapConfAllFileDO) {
				if (itapConfAllFileDO.getConfAllFileId() > 0) {
					itapConfAllFilesDTO.setConfAllFileId(String.valueOf(itapConfAllFileDO
							.getConfAllFileId()));
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getActionBy())) {
					itapConfAllFilesDTO.setActionBy(itapConfAllFileDO.getActionBy());
				}

				if (StringUtils.isNotEmpty(itapConfAllFileDO.getBddFileName())) {
					itapConfAllFilesDTO.setBddFileName(itapConfAllFileDO.getBddFileName());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getBddFilePath())) {
					itapConfAllFilesDTO.setBddFilePath(itapConfAllFileDO.getBddFilePath());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getCafeMobfileName())) {
					itapConfAllFilesDTO.setCafeMobFileName(itapConfAllFileDO
							.getCafeMobfileName());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getCafeMobfilePath())) {
					itapConfAllFilesDTO.setCafeMobFilePath(itapConfAllFileDO
							.getCafeMobfilePath());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getCafeSelfileName())) {
					itapConfAllFilesDTO.setCafeSelFileName(itapConfAllFileDO
							.getCafeSelfileName());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getCafeSelfilePath())) {
					itapConfAllFilesDTO.setCafeSelFilePath(itapConfAllFileDO
							.getCafeSelfilePath());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getCafeUftfileName())) {
					itapConfAllFilesDTO.setCafeUftFileName(itapConfAllFileDO
							.getCafeUftfileName());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getCafeUftfilePath())) {
					itapConfAllFilesDTO.setCafeUftFilePath(itapConfAllFileDO
							.getCafeUftfilePath());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getOptikFileName())) {
					itapConfAllFilesDTO
							.setOptikFileName(itapConfAllFileDO.getOptikFileName());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getOptikFilePath())) {
					itapConfAllFilesDTO
							.setOptikFilePath(itapConfAllFileDO.getOptikFilePath());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getTwistFileName())) {
					itapConfAllFilesDTO
							.setTwistFileName(itapConfAllFileDO.getTwistFileName());
				}
				if (StringUtils.isNotEmpty(itapConfAllFileDO.getTwistFilePath())) {
					itapConfAllFilesDTO
							.setTwistFilePath(itapConfAllFileDO.getTwistFilePath());
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapConfAllFilesDTO;
	}

	@Override
	public ITAPConfAllFileDO convertFromITAPConfAllFilesDTOToITAPConfAllFileDO(
			ITAPConfAllFilesDTO itapConfAllFilesDTO, ITAPConfAllFileDO itapConfAllFileDO) {
		try {
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getConfAllFileId())) {
				itapConfAllFileDO.setConfAllFileId(Long.parseLong(itapConfAllFilesDTO
						.getConfAllFileId()));
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getActionBy())) {
				itapConfAllFileDO.setActionBy(itapConfAllFilesDTO.getActionBy().trim());
			}

			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getBddFileName())) {
				itapConfAllFileDO.setBddFileName(itapConfAllFilesDTO.getBddFileName().trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getBddFilePath())) {
				itapConfAllFileDO.setBddFilePath(itapConfAllFilesDTO.getBddFilePath().trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getCafeMobFileName())) {
				itapConfAllFileDO.setCafeMobfileName(itapConfAllFilesDTO.getCafeMobFileName()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getCafeMobFilePath())) {
				itapConfAllFileDO.setCafeMobfilePath(itapConfAllFilesDTO.getCafeMobFilePath()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getCafeSelFileName())) {
				itapConfAllFileDO.setCafeSelfileName(itapConfAllFilesDTO.getCafeSelFileName()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getCafeSelFilePath())) {
				itapConfAllFileDO.setCafeSelfilePath(itapConfAllFilesDTO.getCafeSelFilePath()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getCafeUftFileName())) {
				itapConfAllFileDO.setCafeUftfileName(itapConfAllFilesDTO.getCafeUftFileName()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getCafeUftFilePath())) {
				itapConfAllFileDO.setCafeUftfilePath(itapConfAllFilesDTO.getCafeUftFilePath()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getOptikFileName())) {
				itapConfAllFileDO.setOptikFileName(itapConfAllFilesDTO.getOptikFileName()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getOptikFilePath())) {
				itapConfAllFileDO.setOptikFilePath(itapConfAllFilesDTO.getOptikFilePath()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getTwistFileName())) {
				itapConfAllFileDO.setTwistFileName(itapConfAllFilesDTO.getTwistFileName()
						.trim());
			}
			if (StringUtils.isNotEmpty(itapConfAllFilesDTO.getTwistFilePath())) {
				itapConfAllFileDO.setTwistFilePath(itapConfAllFilesDTO.getTwistFilePath()
						.trim());
			}

			itapConfAllFileDO.setActionBy(itapConfAllFilesDTO.getActionBy());
			itapConfAllFileDO.setActionDate(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return itapConfAllFileDO;
	}

}

/**
 * Total String Fields in DO = 27
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

