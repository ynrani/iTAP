package com.itap.service;

import java.util.List;

import com.itap.model.DTO.ITAPUserAppAccessDTO;
import com.itap.model.DTO.ITAPUserDtlDTO;
import com.itap.exception.ServiceException;

public interface ITAPUserService {

	ITAPUserDtlDTO selectUserToEdit(String id, ITAPUserDtlDTO itapUserDtlDTO)
			throws ServiceException;

	String saveUserDetails(ITAPUserDtlDTO itapUserDtlDTO) throws ServiceException;

	Long itapViewUserCnt(String attribute, ITAPUserDtlDTO itapUserDtlDTO) throws ServiceException;

	List<ITAPUserDtlDTO> itapViewUser(int offSet, int recordsperpage, boolean b, String attribute,
			ITAPUserDtlDTO itapUserDtlDTO) throws ServiceException;

	String daleteUser(String id) throws ServiceException;

	/*ITAPUserAppAccessDTO selectUserAccessToEdit(String id, ITAPUserAppAccessDTO itapUserAppAccessDTO)
			throws ServiceException;

	String saveUserAccessDetails(ITAPUserAppAccessDTO itapUserAppAccessDTO) throws ServiceException;

	Long itapViewAllocAppCnt(String userId, ITAPUserAppAccessDTO itapUserAppAccessDTO)
			throws ServiceException;

	List<ITAPUserAppAccessDTO> itapViewAllocApp(int offSet, int recordsperpage, boolean b,
			String attribute, ITAPUserAppAccessDTO itapUserAppAccessDTO) throws ServiceException;

	String daleteAllocApp(String id) throws ServiceException;

	String itapCheckAllApp(String appId, String userId) throws ServiceException;

	String itapCheckUserAvail(String userId) throws ServiceException;*/

}
