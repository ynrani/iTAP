/*---------------------------------------------------------------------------------------
 * Object Name: ITAPSysConfigMapper.Java
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
package com.itap.model.mapper;

import com.itap.model.DO.ITAPConfAllFileDO;
import com.itap.model.DO.ITAPSysConfigDO;
import com.itap.model.DTO.ITAPConfAllFilesDTO;
import com.itap.model.DTO.ITAPSysConfigDTO;

public interface ITAPSysConfigMapper {
	public ITAPSysConfigDTO convertFromITAPSysConfigDOToITAPSysConfigDTO(
			ITAPSysConfigDO itapSysConfigDO, ITAPSysConfigDTO itapSysConfigDTO);

	public ITAPSysConfigDO convertFromITAPSysConfigDTOToITAPSysConfigDO(
			ITAPSysConfigDTO itapSysConfigDTO, ITAPSysConfigDO itapSysConfigDO);

	public ITAPConfAllFilesDTO convertFromITAPConfAllFileDOToITAPConfAllFilesDTO(
			ITAPConfAllFileDO itapConfAllFileDO, ITAPConfAllFilesDTO itapConfAllFilesDTO);

	public ITAPConfAllFileDO convertFromITAPConfAllFilesDTOToITAPConfAllFileDO(
			ITAPConfAllFilesDTO itapConfAllFilesDTO, ITAPConfAllFileDO itapConfAllFileDO);

}
