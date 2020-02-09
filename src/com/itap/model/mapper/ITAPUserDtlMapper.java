/*---------------------------------------------------------------------------------------
 * Object Name: ITAPUserDtlMapper.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          26/02/16  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2016 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.itap.model.mapper;

import java.util.List;

import com.itap.model.DO.ITAPUserAppAccessDO;
import com.itap.model.DO.ITAPUserDtlDO;
import com.itap.model.DTO.ITAPUserAppAccessDTO;
import com.itap.model.DTO.ITAPUserDtlDTO;

public interface ITAPUserDtlMapper
{
	public ITAPUserDtlDTO convertFromITAPUserDtlDOToITAPUserDtlDTO(ITAPUserDtlDO smartFoundryUserDtlDO,
			ITAPUserDtlDTO smartFoundryUserDtlDTO);

	public ITAPUserDtlDO convertFromITAPUserDtlDTOToITAPUserDtlDO(ITAPUserDtlDTO smartFoundryUserDtlDTO,
			ITAPUserDtlDO smartFoundryUserDtlDO);

	public List<ITAPUserDtlDTO> converITAPUserDtlDOsToITAPUserDtlDTOs(List<ITAPUserDtlDO> smartFoundryUserDtlDO);

	public ITAPUserAppAccessDTO convertFromITAPUserAppAccessDOToITAPUserAppAccessDTO(
			ITAPUserAppAccessDO smartFoundryUserAppAccessDO, ITAPUserAppAccessDTO smartFoundryUserAppAccessDTO);

	public ITAPUserAppAccessDO convertFromITAPUserAppAccessDTOToITAPUserAppAccessDO(
			ITAPUserAppAccessDTO smartFoundryUserAppAccessDTO, ITAPUserAppAccessDO smartFoundryUserAppAccessDO);

	public List<ITAPUserAppAccessDTO> convertFromITAPUserAppAccessDOsToITAPUserAppAccessDTOs(
			List<ITAPUserAppAccessDO> smartFoundryUserAppAccessDOs);

}
