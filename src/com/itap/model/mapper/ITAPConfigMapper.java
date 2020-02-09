/*---------------------------------------------------------------------------------------
 * Object Name: ITAPConfigMapper.Java
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

import com.itap.exception.ServiceException;
import com.itap.model.DO.ITAPConfigDO;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DO.ITAPBookDtlDO;
import com.itap.model.DO.ITAPEnvDtlDO;
import com.itap.model.DTO.ITAPConfigDTO;
import com.itap.model.DTO.ITAPTrainViewDTO;
import com.itap.model.DTO.ITAPSearchBookingDTO;

public interface ITAPConfigMapper {

	ITAPConfigDTO convertFromITAPConfigDOToITAPConfigDTO(ITAPConfigDO itapConfigDO,
			ITAPConfigDTO itapConfigDTO);

	ITAPConfigDO convertFromITAPConfigDTOToITAPConfigDO(ITAPConfigDTO itapConfigDTO,
			ITAPConfigDO itapConfigDO);

	List<ITAPConfigDTO> convertFromITAPConfigDOsToITAPConfigDTOs(
			List<ITAPConfigDO> itapConfigDOs);

	ITAPTrainViewDTO convertFromITAPTrainViewDOToITAPTrainViewDTO(
			ITAPTrainViewDO itapTrainViewDO, ITAPTrainViewDTO itapTrainViewDTO);

	ITAPTrainViewDO convertFromITAPTrainViewDTOToITAPTrainViewDO(
			ITAPTrainViewDTO itapConfigDTO, ITAPTrainViewDO itapConfigDO);

	List<ITAPTrainViewDTO> convertFromITAPTrainViewDOsToITAPTrainViewDTOs(
			List<ITAPTrainViewDO> itapTrainViewDOs);

	ITAPSearchBookingDTO getFinalCalView(ITAPEnvDtlDO remsEnvDtlDO,
			List<ITAPBookDtlDO> remsBookDtlDOs, List<String> dates,
			ITAPSearchBookingDTO remsSearchBookingDTO) throws ServiceException;

}
