package com.itap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itap.constant.ITAPConstants;
import com.itap.model.DO.ITAPTrainViewDO;
import com.itap.model.DTO.ITAPConfigDTO;
import com.itap.service.ITAPConfigService;

@Controller
@RequestMapping
public class ProjJobDuplicateCheck {

	@Resource(name = "itapConfigService")
	ITAPConfigService itapConfigService;

	@RequestMapping(value = "/projectJobCheck", method = RequestMethod.GET)
	public void configuration(
			@ModelAttribute("itapConfigDTO") ITAPConfigDTO itapConfigDTO,
			@RequestParam(value = ITAPConstants.ID, required = false) String id, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) {

		boolean duplicateStatus = false;
		Map<String, String[]> data = request.getParameterMap();
		String check = "";
		for (Entry<String, String[]> entry : data.entrySet()) {
			if (entry.getKey() != "" && entry.getKey() != null) {
				check = entry.getKey();
			}

		}
		String[] array = check.split("!");
		String projectName = array[0];
		String jobName = array[1];
		HashSet<String> jobsList;
		List<ITAPTrainViewDO> jobsListDB = itapConfigService
				.getJobsByProjectName(projectName);
		try {
			jobsList = createJobList(jobsListDB);
			duplicateStatus = checkExistingJobs(projectName, jobName, jobsList);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("in new controller");

		System.out.println(duplicateStatus);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.println(String.valueOf(duplicateStatus).trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private ArrayList<String> createExpectedJobs(String projectName, String jobName) {

		ArrayList<String> expectedJobList = new ArrayList<String>();
		ArrayList<String> toolList = new ArrayList<String>();
		toolList.add("UFT");
		toolList.add("FUNCTIONAL");
		toolList.add("BDD");
		toolList.add("APITESTING");
		toolList.add("OPTIK");
		// toolList.add("FUNCTIONALTEST");
		for (String tool : toolList) {
			expectedJobList.add(projectName + "_" + tool + "_" + jobName);
		}
		return expectedJobList;
	}

	private boolean checkExistingJobs(String projectName, String jobName, HashSet<String> set) {
		boolean duplicate = false;
		ArrayList<String> expectedJobList = createExpectedJobs(projectName, jobName);

		for (String expJob : expectedJobList) {
			if (set.contains(expJob)) {
				duplicate = true;
				break;

			}
		}
		return duplicate;
	}

	private HashSet<String> createJobList(List<ITAPTrainViewDO> jobsListDB)
			throws ClassNotFoundException, SQLException {
		HashSet<String> jobsList = new HashSet<String>();
		for (ITAPTrainViewDO bean : jobsListDB) {

			String value = bean.getTrainJobs();
			if (value.contains(",")) {
				String[] valueArray = value.split(",");
				for (String str : valueArray) {
					jobsList.add(str);
				}
			} else {
				jobsList.add(value);
			}
		}
		return jobsList;
	}

}
