package com.itap.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itap.model.DTO.ITAPConfigDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * <projects href="/app/rest/projects"/> <vcsRoots href="/app/rest/vcs-roots"/>
 * <builds href="/app/rest/builds"/> <users href="/app/rest/users"/> <userGroups
 * href="/app/rest/userGroups"/> <agents href="/app/rest/agents"/> <buildQueue
 * href="/app/rest/buildQueue"/> <agentPools href="/app/rest/agentPools"/>
 * 
 * http://in-pnq-coe30:11000/app/rest/buildTypes
 * 
 * http://in-pnq-coe30:11000/action.html?add2Queue=Cyc01_CyclosBDD
 * 
 * 
 */
public class CreateTeamCityJob {
	/*
	 * public static void main(String[] args) {
	 * 
	 * // String responseCodeBuildJob = //
	 * buildJobNormal1("http://in-pnq-coe30:11000/", // "Cyc01_CodeCoverage");
	 * // System.out.println(responseCodeBuildJob);
	 * 
	 * String[] responseCodeBuildJob2 =
	 * listProjectJobs("http://in-pnq-coe30:11000/", "Cyc01"); for (String
	 * string : responseCodeBuildJob2) { System.out.println("@@@@@"); Pattern p
	 * = Pattern.compile("\"([^\"]*)\""); Matcher m = p.matcher(string); while
	 * (m.find()) { System.out.println(m.group(1)); System.out.println("####");
	 * } }
	 * 
	 * // deleteJob("http://in-pnq-coe30:9090/jenkins", "Cyclos133");
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// List<String> str = allListProjectJobs("http://in-pnq-coe30:11000/");

		// deleteJob("http://in-pnq-coe30:11000/",
		// "SSSSProject_SCM_SSSSJobName_123");

		// deleteJobFromTeamCity("http://in-pnq-coe30:11000/",
		// "TempProject1_APITEST_TempJob1_123");
		ITAPConfigDTO iTAPConfigDTO = new ITAPConfigDTO();
		iTAPConfigDTO.setProjName("PuneProject11111");
		iTAPConfigDTO.setJobName("PuneJob111111");
		createProject("http://in-pnq-coe30:11000/", iTAPConfigDTO);
		buildJobNormal1("http://in-pnq-coe30:11000/", "TEST_PuneJob111111111111");
		// createAndbuildProjectJobs("http://in-pnq-coe30:11000/", "AAAAaa",
		// "PuneProject_123");
	}

	public static String buildJobNormal1(String url, String newJobName) {

		if (url.endsWith("/")) {
			url = url + "action.html?add2Queue=" + newJobName;
		} else {
			url = url + "/action.html?add2Queue=" + newJobName;
		}

		Client client = Client.create();
		client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
				"Cap@1234"));
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		System.out.println("Response readJob:::::" + url + "action.html?add2Queue=" + newJobName);
		return jsonResponse;
	}

	public static List<String> allListProjectJobs(String url) {
		String tempUrl = "";
		if (url.endsWith("/")) {
			tempUrl = url + "app/rest/projects";
		} else {
			tempUrl = url + "/app/rest/projects";
		}

		List<String> jobList = new ArrayList<String>();
		Client client = Client.create();
		client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
				"Cap@1234"));
		WebResource webResource = client.resource(tempUrl);
		ClientResponse response = webResource.get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();

		String subStrings = jsonResponse.substring(jsonResponse.indexOf("/projects") + 11,
				jsonResponse.indexOf("</projects>"));

		String jobs[] = subStrings.split("<project"); // etc

		List<String> projectId = new ArrayList<String>();
		for (String job : jobs) {
			Pattern p = Pattern.compile("\"([^\"]*)\"");
			Matcher m = p.matcher(job);
			int i = 0;
			while (m.find()) {
				switch (i) {
				case 0:
					if (!m.group(1).equalsIgnoreCase("_Root")) {
						String str = m.group(0);
						projectId.add(str.substring(1, str.lastIndexOf("\"")));
					}
					break;
				default:
					break;
				}
				i++;
			}
			i = 0;
		}
		for (String project : projectId) {
			try {
				String jobsList[] = listProjectJobs(url, project);
				for (String job : jobsList) {
					jobList.add(job);
				}

			} catch (Exception e) {

				// e.printStackTrace();
			}
			// will
			// contain jobs
		}

		return jobList;
	}

	public static String[] listProjectJobs(String url, String projId) {

		if (url.endsWith("/")) {
			url = url + "app/rest/projects/id:" + projId;
		} else {
			url = url + "/app/rest/projects/id:" + projId;
		}

		Client client = Client.create();
		client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
				"Cap@1234"));
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		// System.out.println("Response listJobs:::::"+jsonResponse);

		// Assume jobs returned are in xml format, TODO using an XML Parser
		// would be better here
		// Get name from <job><name>...
		String[] jobs = null;
		String temp = "";
		try {

			temp = jsonResponse.substring(jsonResponse.indexOf("<buildTypes"),
					jsonResponse.indexOf("</buildTypes>"));

			jobs = temp.split("<buildType "); // etc
		} catch (Exception e) {

		}
		// will
		// contain jobs

		return Arrays.copyOfRange(jobs, 1, jobs.length);
	}

	public static void createProject(String url, ITAPConfigDTO iTAPConfigDTO) {
		String projectUrl = "";
		System.out.println(url + "   :: createProject ::: " + iTAPConfigDTO.getProjName() + "_"
				+ iTAPConfigDTO.getJobName());
		if (url.endsWith("/")) {
			projectUrl = url + "httpAuth/app/rest/projects";
		} else {
			projectUrl = url + "/httpAuth/app/rest/projects";
		}

		String configXML2 = getProjectCreationXml(iTAPConfigDTO) + "";

		Client client = Client.create();
		client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
				"Cap@1234"));
		WebResource webResource = client.resource(projectUrl);
		ClientResponse response = webResource.type("application/xml").post(ClientResponse.class,
				configXML2);
		String jsonResponse = response.getEntity(String.class);
		System.out.println(jsonResponse);
		client.destroy();
	}

	public static void createAndbuildProjectJobs(String url, String jobName, String parentId) {

		String urlTemp = "";
		if (url.endsWith("/")) {
			urlTemp = url + "httpAuth/app/rest/buildTypes";
		} else {
			urlTemp = url + "/httpAuth/app/rest/buildTypes";
		}
		String str = getProjectJobsXml(jobName, parentId);

		Client client = Client.create();
		client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
				"Cap@1234"));
		WebResource webResource = client.resource(urlTemp);
		ClientResponse response = webResource.type("application/xml").post(ClientResponse.class,
				str);
		String jsonResponse = response.getEntity(String.class);

		client.destroy();
		System.out.println(jsonResponse);

	}

	public static void deleteJobFromTeamCity(String url, String buildId) {

		String urlTemp = "";
		if (url.endsWith("/")) {
			urlTemp = url + "httpAuth/app/rest/buildTypes/" + buildId;

		} else {
			urlTemp = url + "/httpAuth/app/rest/buildTypes/" + buildId;
		}
		// + "/httpAuth/app/rest/buildTypes/" + buildId;
		Client client = Client.create();
		client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
				"Cap@1234"));

		WebResource webResource = client.resource(urlTemp);
		ClientResponse response = webResource.delete(ClientResponse.class);
		response.getEntity(String.class);
		client.destroy();
	}

	/*
	 * public static void createProjectJobs(String url, String jobName, String
	 * projectId, String asdf) { String jobUrl = url +
	 * "/httpAuth/app/rest/projects"; String configXML2 =
	 * getProjectJobsXml(jobName, projectName);
	 * 
	 * // String conf = //
	 * "<newProjectDescription name='NewProjectUsingCopy1' id='newProjectId1'><parentProject locator='id:Cyc01'/><sourceProject locator='id:Cyc01'/></newProjectDescription>"
	 * ;
	 * 
	 * Client client = Client.create(); client.addFilter(new
	 * com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
	 * "Cap@1234")); WebResource webResource = client.resource(jobUrl);
	 * ClientResponse response =
	 * webResource.type("application/xml").post(ClientResponse.class,
	 * configXML2); String jsonResponse = response.getEntity(String.class);
	 * 
	 * client.destroy(); System.out.println(jsonResponse);
	 * 
	 * }
	 */

	public static void deleteProject(String url, String projectId) {
		// "http://in-pnq-coe30:11000"
		String deleteUrl = "";
		if (url.endsWith("/")) {
			deleteUrl = url + "httpAuth/app/rest/projects/" + projectId;
		} else {
			deleteUrl = url + "/httpAuth/app/rest/projects/" + projectId;
		}
		// + "/httpAuth/app/rest/projects/" + projectId;

		// String conf =
		// "<newProjectDescription name='NewProjectUsingCopy1' id='newProjectId1'><parentProject locator='id:Cyc01'/><sourceProject locator='id:Cyc01'/></newProjectDescription>";

		Client client = Client.create();
		client.addFilter(new com.sun.jersey.api.client.filter.HTTPBasicAuthFilter("pwatve",
				"Cap@1234"));
		WebResource webResource = client.resource(deleteUrl);
		ClientResponse response = webResource.delete(ClientResponse.class);

		client.destroy();
		// System.out.println(jsonResponse);
	}

	public static String getProjectJobsXml(String jobName, String parentId) {

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
		sb.append("<buildType id=\"");
		sb.append(jobName);
		sb.append("_123");
		sb.append("\" name=\"");
		sb.append(jobName);
		sb.append("\" projectId=\"");
		sb.append(parentId);
		sb.append("\" >");
		sb.append("<vcs-root-entries></vcs-root-entries>");
		sb.append("<settings></settings>");
		sb.append("<parameters></parameters>");
		sb.append("<steps></steps>");
		sb.append("<features></features>");
		sb.append("<triggers></triggers>");
		sb.append("<snapshot-dependencies/>");
		sb.append("<artifact-dependencies/>");
		sb.append("<agent-requirements/>");
		sb.append("<builds href=\"BuildConfigurationHREF\" />");
		sb.append("</buildType>");

		return sb + "";
		/*
		 * StringBuilder sb = new StringBuilder();
		 * sb.append("<newProjectDescription name='"); sb.append(jobName);
		 * sb.append("' id='"); sb.append(jobName); sb.append("_123'>");
		 * sb.append("<parentProject locator='id:"); sb.append(projectName);
		 * sb.append("_123'/>"); sb.append("</newProjectDescription>"); return
		 * sb + "";
		 */
	}

	public static StringBuilder getProjectCreationXml(ITAPConfigDTO iTAPConfigDTO) {

		StringBuilder configXML = new StringBuilder();
		configXML.append("<newProjectDescription name='");
		configXML.append(iTAPConfigDTO.getProjName() + "_" + iTAPConfigDTO.getJobName());
		configXML.append("' id='");
		configXML.append(iTAPConfigDTO.getProjName() + "_123");
		configXML.append("'>");
		configXML.append("</newProjectDescription>");

		return configXML;
	}

}