package com.itap.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itap.constant.ITAPConstants;
import com.itap.exception.BaseException;
import com.itap.model.DO.MasterSlaveDetailsDO;
import com.itap.service.ITAPMasterSlaveService;

@Controller
public class ITAPMasterSlaveController {
	// private static final Logger LOGGER =
	// Logger.getLogger(ITAPNewNodeController.class);

	private static final Logger LOGGER = Logger.getLogger(ITAPMasterSlaveController.class);

	@Autowired
	private ITAPMasterSlaveService masterSlaveService;/* Application Pages */

	@RequestMapping(value = "/newNode", method = RequestMethod.GET)
	public String configurationSysGet(

	@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		String strReturnPage = "newNode";

		return strReturnPage;
	}

	@RequestMapping(value = "/viewNodes", method = RequestMethod.GET)
	public String viewNodes(ModelMap modelmap, HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		modelmap.addAttribute("demo", "welcome");

		try {
			List<MasterSlaveDetailsDO> list = masterSlaveService.getAllMasterSlaveNodes();

			modelmap.addAttribute("masterSlaveDO", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String strReturnPage = "viewNodes";
		return strReturnPage;
	}
}
