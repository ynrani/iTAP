/*
 * Object Name : ITAPTdmService.java
 * Modification Block
 * ------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ------------------------------------------------------------------
 * 	1.	  vkrish14		2:22:08 PM				Created
 * ------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.itap.alm.service;

import java.util.List;
import java.util.Set;

import com.itap.model.DTO.ITAPConfigDTO;

/**
 * @author vkrish14
 *
 */
public interface ITAPTdmService{

	

	List<String> getSelectedTestCasesId(ITAPConfigDTO itapConfigDTO);

	void doCheckTestData(List<String> lstTestCaseName);

	Set<String> doCheckTestData(ITAPConfigDTO itapConfigDTO);

	void doCheckTestData(String testCasesIds);

	void unreserveRecordsFromTDM(String testCasesIds);
}
