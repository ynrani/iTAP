package com.itap.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itap.model.DTO.ITAPDefectDTO;
import com.itap.model.DTO.ITAPDefectForm;
import com.itap.model.DTO.ITAPToolDefects;
import com.itap.service.impl.ITAPDefectLoggerServiceImpl;

@Controller
public class ITAPDefectLoggerController {
	
	private static final Logger LOGGER = Logger.getLogger(ITAPDefectLoggerController.class);
	
	@Resource(name = "itapDefectLoggerService")
	com.itap.service.ITAPDefectLoggerService itapDefectLoggerService;
	
	/**
	 * This method fetches the defects fromITAP folder.s
	 * 
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return String
	 */ 
	@RequestMapping(value = "/fetchDefect", method = RequestMethod.GET)
	public String fetchDefects(ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			List<ITAPToolDefects> defectList = new ITAPDefectLoggerServiceImpl().getDefectsList();
			ITAPDefectForm itapDefectForm = new ITAPDefectForm();
			itapDefectForm.setToolDefectsList(defectList);
		    modelmap.addAttribute("itapDefectForm", itapDefectForm);
			return "itapDefect";
		} catch (Exception e) {
			LOGGER.error("Error in fetchDefects method : "+e.getMessage());
			ITAPDefectForm itapDefectForm = new ITAPDefectForm();
			itapDefectForm.setError("Sorry.There seems to be an internal-error.Contact your administrator.");
			modelmap.addAttribute("itapDefectForm", itapDefectForm);
			return "itapDefect";
		}
	}
	
	/**
	 * This method saves the defects and logs them in ALM.
	 * 
	 * @param itapDefectForm
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping(value = "/raiseDefect", method = RequestMethod.POST)
	public String logDefect(final ITAPDefectForm itapDefectForm,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		try{
			List<ITAPDefectDTO> loggedDefects = itapDefectLoggerService.logDefects(itapDefectForm.getToolDefectsList());
			
			System.err.println("--------------------------------------------------------");
			System.err.println("Total Defects Raised : "+loggedDefects.size());
			
			List<ITAPToolDefects> defectList = new ITAPDefectLoggerServiceImpl().getDefectsList();
			itapDefectForm.setToolDefectsList(defectList);
			modelMap.addAttribute("itapDefectForm", itapDefectForm);
			modelMap.addAttribute("loggedDefectList", loggedDefects);
			return "itapDefect";
		} catch (Exception e) {
			LOGGER.error("Error in logDefect method : "+e.getMessage());
			return "itapDefect";
		}
	}
}
