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
package com.itap.model.mapper.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itap.model.DO.ITAPUserAppAccessDO;
import com.itap.model.DO.ITAPUserDtlDO;
import com.itap.model.DTO.ITAPUserAppAccessDTO;
import com.itap.model.DTO.ITAPUserDtlDTO;
import com.itap.model.mapper.ITAPUserDtlMapper;

@Component
@Service("smartFoundryUserDtlMapper")
public class ITAPUserDtlMapperImpl implements ITAPUserDtlMapper
{
	@Override
	public ITAPUserDtlDTO convertFromITAPUserDtlDOToITAPUserDtlDTO(ITAPUserDtlDO smartFoundryUserDtlDO,
			ITAPUserDtlDTO smartFoundryUserDtlDTO) {
		try {
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getUserId())) {
				smartFoundryUserDtlDTO.setUserId(smartFoundryUserDtlDO.getUserId());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getActionBy())) {
				smartFoundryUserDtlDTO.setActionBy(smartFoundryUserDtlDO.getActionBy());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getEnabled())) {
				smartFoundryUserDtlDTO.setEnabled(smartFoundryUserDtlDO.getEnabled());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getPassWord())) {
				smartFoundryUserDtlDTO.setPassWord(smartFoundryUserDtlDO.getPassWord());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getUserAccess())) {
				smartFoundryUserDtlDTO.setUserAccess(smartFoundryUserDtlDO.getUserAccess());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getUserEmail())) {
				smartFoundryUserDtlDTO.setUserEmail(smartFoundryUserDtlDO.getUserEmail());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getUserName())) {
				smartFoundryUserDtlDTO.setUserName(smartFoundryUserDtlDO.getUserName());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getUserPh())) {
				smartFoundryUserDtlDTO.setUserPh(smartFoundryUserDtlDO.getUserPh());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getUserSts())) {
				smartFoundryUserDtlDTO.setUserSts(smartFoundryUserDtlDO.getUserSts());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDO.getUserType())) {
				smartFoundryUserDtlDTO.setUserType(smartFoundryUserDtlDO.getUserType());
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return smartFoundryUserDtlDTO;
	}

	@Override
	public ITAPUserDtlDO convertFromITAPUserDtlDTOToITAPUserDtlDO(ITAPUserDtlDTO smartFoundryUserDtlDTO,
			ITAPUserDtlDO smartFoundryUserDtlDO) {
		try {
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getUserId())) {
				smartFoundryUserDtlDO.setUserId(smartFoundryUserDtlDTO.getUserId());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getActionBy())) {
				smartFoundryUserDtlDO.setActionBy(smartFoundryUserDtlDTO.getActionBy());
			} else {
				smartFoundryUserDtlDO.setActionBy(smartFoundryUserDtlDTO.getUserId());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getEnabled())) {
				smartFoundryUserDtlDO.setEnabled(smartFoundryUserDtlDTO.getEnabled());
			} else {
				smartFoundryUserDtlDO.setEnabled("1");
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getPassWord())) {
				smartFoundryUserDtlDO.setPassWord(smartFoundryUserDtlDTO.getPassWord());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getUserAccess())) {
				smartFoundryUserDtlDO.setUserAccess(smartFoundryUserDtlDTO.getUserAccess());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getUserEmail())) {
				smartFoundryUserDtlDO.setUserEmail(smartFoundryUserDtlDTO.getUserEmail());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getUserName())) {
				smartFoundryUserDtlDO.setUserName(smartFoundryUserDtlDTO.getUserName());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getUserPh())) {
				smartFoundryUserDtlDO.setUserPh(smartFoundryUserDtlDTO.getUserPh());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getUserSts())) {
				smartFoundryUserDtlDO.setUserSts(smartFoundryUserDtlDTO.getUserSts());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserDtlDTO.getUserType())) {
				smartFoundryUserDtlDO.setUserType(smartFoundryUserDtlDTO.getUserType());
			} else {
				smartFoundryUserDtlDO.setUserType("ROLE_USER");
			}

			smartFoundryUserDtlDO.setActionBy(smartFoundryUserDtlDTO.getActionBy());
			smartFoundryUserDtlDO.setActionDt(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return smartFoundryUserDtlDO;
	}

	@Override
	public List<ITAPUserDtlDTO> converITAPUserDtlDOsToITAPUserDtlDTOs(List<ITAPUserDtlDO> smartFoundryUserDtlDOs) {

		ITAPUserDtlDTO smartFoundryUserDtlDTO = null;
		List<ITAPUserDtlDTO> smartFoundryUserDtlDTOs = null;
		if (null != smartFoundryUserDtlDOs) {
			smartFoundryUserDtlDTOs = new ArrayList<ITAPUserDtlDTO>();
			for (ITAPUserDtlDO smartFoundryUserDtlDO : smartFoundryUserDtlDOs) {
				smartFoundryUserDtlDTO = new ITAPUserDtlDTO();
				smartFoundryUserDtlDTO = convertFromITAPUserDtlDOToITAPUserDtlDTO(smartFoundryUserDtlDO, smartFoundryUserDtlDTO);
				smartFoundryUserDtlDTOs.add(smartFoundryUserDtlDTO);
			}

		}
		return smartFoundryUserDtlDTOs;
	}

	@Override
	public ITAPUserAppAccessDTO convertFromITAPUserAppAccessDOToITAPUserAppAccessDTO(
			ITAPUserAppAccessDO smartFoundryUserAppAccessDO, ITAPUserAppAccessDTO smartFoundryUserAppAccessDTO) {
		try {
			if (smartFoundryUserAppAccessDO.getId() > 0) {
				smartFoundryUserAppAccessDTO.setId(String.valueOf(smartFoundryUserAppAccessDO.getId()));
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDO.getActionBy())) {
				smartFoundryUserAppAccessDTO.setActionBy(smartFoundryUserAppAccessDO.getActionBy());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDO.getAppId())) {
				smartFoundryUserAppAccessDTO.setAppId(smartFoundryUserAppAccessDO.getAppId());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDO.getUserAccess())) {
				smartFoundryUserAppAccessDTO.setUserAccess(smartFoundryUserAppAccessDO.getUserAccess());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDO.getUserId())) {
				smartFoundryUserAppAccessDTO.setUserId(smartFoundryUserAppAccessDO.getUserId());
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return smartFoundryUserAppAccessDTO;
	}

	@Override
	public ITAPUserAppAccessDO convertFromITAPUserAppAccessDTOToITAPUserAppAccessDO(
			ITAPUserAppAccessDTO smartFoundryUserAppAccessDTO, ITAPUserAppAccessDO smartFoundryUserAppAccessDO) {
		try {
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDTO.getId())) {
				smartFoundryUserAppAccessDO.setId(Long.parseLong(smartFoundryUserAppAccessDTO.getId()));
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDTO.getActionBy())) {
				smartFoundryUserAppAccessDO.setActionBy(smartFoundryUserAppAccessDTO.getActionBy());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDTO.getAppId())) {
				smartFoundryUserAppAccessDO.setAppId(smartFoundryUserAppAccessDTO.getAppId());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDTO.getUserAccess())) {
				smartFoundryUserAppAccessDO.setUserAccess(smartFoundryUserAppAccessDTO.getUserAccess());
			}
			if (StringUtils.isNotEmpty(smartFoundryUserAppAccessDTO.getUserId())) {
				smartFoundryUserAppAccessDO.setUserId(smartFoundryUserAppAccessDTO.getUserId());
			}

			smartFoundryUserAppAccessDO.setActionBy(smartFoundryUserAppAccessDO.getActionBy());
			smartFoundryUserAppAccessDO.setActionDt(new Timestamp(new Date().getTime()));

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return smartFoundryUserAppAccessDO;
	}

	@Override
	public List<ITAPUserAppAccessDTO> convertFromITAPUserAppAccessDOsToITAPUserAppAccessDTOs(
			List<ITAPUserAppAccessDO> smartFoundryUserAppAccessDOs) {

		ITAPUserAppAccessDTO smartFoundryUserAppAccessDTO = null;
		List<ITAPUserAppAccessDTO> smartFoundryUserAppAccessDTOs = null;
		if (null != smartFoundryUserAppAccessDOs) {
			smartFoundryUserAppAccessDTOs = new ArrayList<ITAPUserAppAccessDTO>();
			for (ITAPUserAppAccessDO smartFoundryUserAppAccessDO : smartFoundryUserAppAccessDOs) {
				smartFoundryUserAppAccessDTO = new ITAPUserAppAccessDTO();
				smartFoundryUserAppAccessDTO = convertFromITAPUserAppAccessDOToITAPUserAppAccessDTO(smartFoundryUserAppAccessDO,
						smartFoundryUserAppAccessDTO);
				smartFoundryUserAppAccessDTOs.add(smartFoundryUserAppAccessDTO);
			}

		}
		return smartFoundryUserAppAccessDTOs;
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
 * Total Long Fields in DO = 0
 *
 * Total List Fields in DO = 1
 *
 * Above Fields does not include count for ActionBy and ActionDate Fields and Serial Version Id
 **/

