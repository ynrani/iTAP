/*---------------------------------------------------------------------------------------
 * Object Name: ITAPProgressController.Java
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

package com.itap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Controller
public class ITAPDefectMgmtController {

	private static final Logger LOGGER = Logger.getLogger(ITAPDefectMgmtController.class);

	@RequestMapping(value = "/itapDefect", method = RequestMethod.GET)
	public String itapDefectGet(ModelMap modelmap, HttpServletRequest request,
			HttpServletResponse response) {
		String strReturnPage = "itapDefect";

		return strReturnPage;

	}

}
