package com.itap.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.itap.constant.ITAPConstants;
import com.itap.model.DTO.ITAPConfigDTO;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * API: http://in-pnq-coe30:9090/jenkins/api/?
 * 
 * LIST JOBS: http://in-pnq-coe30:9090/jenkins/api/xml
 * 
 * COPY JOB: Create AA_TEST_JOB1 by copying AA_TEST_JOB0 curl -H
 * "Content-Type:application/xml"
 * "http://in-pnq-coe30:9090/jenkins/createItem?name=AA_TEST_JOB1&mode=copy&from=AA_TEST_JOB0"
 * 
 * DELETE JOB: curl -X POST
 * "http://in-pnq-coe30:9090/jenkins/job/AA_TEST_JOB1/doDelete"
 * 
 * READ JOB: curl "http://in-pnq-coe30:9090/jenkins/job/Cyclos131/config.xml" >
 * config.xml
 * 
 * CREATE JOB: Create AA_TEST_JOB2 by using xml for configuration curl -X POST
 * -H "Content-Type:application/xml" -d
 * "<project><builders/><publishers/><buildWrappers/></project>"
 * "http://in-pnq-coe30:9090/jenkins/createItem?name=AA_TEST_JOB2" curl -X POST
 * -H "Content-Type:application/xml" -d @config.xml
 * "http://in-pnq-coe30:9090/jenkins/createItem?name=AA_TEST_JOB3"
 * 
 * @author sizu
 * 
 */
public class CreateJenkinsJob {
	public static void main(String[] args) throws InterruptedException {

		String url = "http://in-pnq-coe40:9090/jenkins/";
		String[] jobs = listJobs(url);
		List<String> jobss = new ArrayList<String>();
		String name = null;

		for (String job : jobs) {
			String[] names = job.split("name>");
			String[] colors = job.split("color>");

			if (names.length == 3) {
				name = names[1];
				name = name.substring(0, name.length() - 2);

			}

			if (colors.length == 3) {
				String color = colors[1];
				color = color.substring(0, color.length() - 2);

			}
			if (colors.length == 3 || names.length == 3) {
				jobss.add(name);
			}
		}

		for (String string : jobss) {

			if (string.equalsIgnoreCase("13_Cyclos_Selenium_Mobile_Testing")) {
			} else if (string.equalsIgnoreCase("13_Cyclos_Selenium_Mobile_Testing_CyclosTest")) {
			} else if (string.equalsIgnoreCase("14_Cyclos_Autohub_Cafe_Sel_UFT")) {
			} else if (string.equalsIgnoreCase("16_Cyclos_Data_Output_UFT")) {
			} else if (string.equalsIgnoreCase("19_Cyclos_Cafe_Mobile_External_Sel_Data")) {
			} else if (string.equalsIgnoreCase("1_Cyclos_Code_Checkout")) {
			} else if (string.equalsIgnoreCase("4_Cyclos_Environment_Precheck")) {
			} else if (string.equalsIgnoreCase("5_Cyclos_Build_Package")) {
			} else if (string.equalsIgnoreCase("BubbleTestSuiteSep_APITESTING_Policy Center_Job")) {
			} else if (string.equalsIgnoreCase("BubbleTestSuiteSepdas_UFT_Policy Center_Job")) {
			} else if (string.equalsIgnoreCase("BubbleTestSuiteSep_BDD_ODS_Job")) {
			} else {
				System.out.println("Delete before");
				deleteJob(url, string);
				System.out.println("Delete After");
				Thread.sleep(2000);
			}

		}
		// System.out.println("First Job:" + jobList.get(0));

		// System.out.println("Check 1: Delete Cyclos131 (created manually)");
		// deleteJob("http://in-pnq-coe30:9090/jenkins", "Cyclos131");

		// System.out.println("Check 2: Create Cyclos131 by copying first job");
		// copyJob("http://in-pnq-coe30:9090/jenkins", "Cyclos131",
		// jobList.get(0)); //
		// deleteJob("http://in-pnq-coe30:9090/jenkins", "Cyclos131");

		// System.out.println("Check 3: Create Cyclos132 by using a generic xml configuration");
		// createJob("http://in-pnq-coe30:9090/jenkins", "Cyclos132",
		// "<project><builders/><publishers/><buildWrappers/></project>"); //
		// deleteJob("http://in-pnq-coe30:9090/jenkins", "Cyclos132");

		// System.out.println("Check 4: Create Cyclos133 by using the xml configuration from the first job (similar to copyJob)");
		// String configXML = readJob("http://in-pnq-coe30:9090/jenkins",
		// jobList.get(0));

		// String url =
		// "http://in-pnq-coe02.corp.capgemini.com:7171/svn/CoE/TCOE/ITAP/CyclosWorkSpace/cyclos";
		// String projName = "Cyclos_Test";
		/*
		 * createJob("http://in-pnq-coe30:9090/jenkins", "Cyclos_Test",
		 * getJobCreateXml(projName, url, null));
		 */

		// String jsonResponse =
		// readAnyXmlFromJenkins("http://in-pnq-coe30:9090/jenkins/job/10_Cyclos_API_Test/22/api/xml");

		// HttpResponse responseCodeBuildJob =
		// buildJob("http://in-pnq-coe30:9090/jenkins","10_Cyclos_API_Test");

		// deleteJob("http://in-pnq-coe30:9090/jenkins", "Cyclos133");
	}

	public static String[] listJobs(String url) {
		Client client = Client.create();
		// client.addFilter(new
		// com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(USERNAME,
		// PASSWORD));
		WebResource webResource = client.resource(url + "/api/xml");
		ClientResponse response = webResource.get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		// System.out.println("Response listJobs:::::"+jsonResponse);

		// Assume jobs returned are in xml format, TODO using an XML Parser
		// would be better here
		// Get name from <job><name>...
		String[] jobs = jsonResponse.split("job>"); // 1, 3, 5, 7, etc will
													// contain jobs

		return jobs;
	}

	public static String deleteJob(String url, String jobName) {
		Client client = Client.create();
		// client.addFilter(new
		// com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(USERNAME,
		// PASSWORD));
		if (url.endsWith("/")) {
			url = url + "job/" + jobName + "/doDelete";
		} else {
			url = url + "/job/" + jobName + "/doDelete";
		}

		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.post(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		// System.out.println("Response deleteJobs:::::"+jsonResponse);
		return jsonResponse;
	}

	public static String copyJob(String url, String newJobName, String oldJobName) {
		Client client = Client.create();
		// client.addFilter(new
		// com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(USERNAME,
		// PASSWORD));
		if (url.endsWith("/")) {
			url = url + "createItem?name=" + newJobName + "&mode=copy&from=" + oldJobName;
		} else {
			url = url + "/createItem?name=" + newJobName + "&mode=copy&from=" + oldJobName;
		}

		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.type("application/xml").get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		// System.out.println("Response copyJob:::::"+jsonResponse);
		return jsonResponse;
	}

	public static String createJob(String url, String newJobName, String configXML) {
		Client client = Client.create();
		// client.addFilter(new
		// com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(USERNAME,
		// PASSWORD));
		if (url.endsWith("/")) {
			url = url + "createItem?name=" + newJobName;

		} else {
			url = url + "/createItem?name=" + newJobName;
		}
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.type("application/xml").post(ClientResponse.class,
				configXML);
		String jsonResponse = response.getEntity(String.class);

		client.destroy();
		return jsonResponse;
	}

	public static String readJob(String url, String jobName) {
		Client client = Client.create();
		// client.addFilter(new
		// com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(USERNAME,
		// PASSWORD));
		if (url.endsWith("/")) {
			url = url + "job/" + jobName + "/config.xml";
		} else {
			url = url + "/job/" + jobName + "/config.xml";
		}
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		// System.out.println("Response readJob:::::"+jsonResponse);
		return jsonResponse;
	}

	public static String readAnyXmlFromJenkins(String url) {
		Client client = Client.create();
		// client.addFilter(new
		// com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(USERNAME,
		// PASSWORD));
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource.get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		// System.out.println("Response readJob:::::"+jsonResponse);
		return jsonResponse;
	}

	public static String getJobCreateXml(ITAPConfigDTO itapConfigDTO) {

		StringBuffer input = new StringBuffer("<?xml version='1.0' encoding='UTF-8'?>");
		input.append("<project>");
		input.append("<actions/>");
		input.append("<description>");
		input.append(itapConfigDTO.getJobName());
		input.append("</description>");
		input.append("<keepDependencies>false</keepDependencies>");
		input.append("<properties/>");

		// JOB 1 SOURCE CONFIGURATION MANAGEMENT
		if (StringUtils.isNotEmpty(itapConfigDTO.getRepoUrl())) {
			input.append("<scm class=" + "\"" + "hudson.scm.SubversionSCM" + "\"" + " plugin="
					+ "\"" + "subversion@1.54" + "\"" + ">");
			input.append("<locations>");
			input.append("<hudson.scm.SubversionSCM_-ModuleLocation>");
			input.append("<remote>");
			input.append(itapConfigDTO.getRepoUrl());
			input.append("</remote>");
			input.append("<credentialsId>a0495195-3d5e-4ad2-ae79-64d559a83d7a</credentialsId>");
			input.append("<local>.</local>");
			input.append("<depthOption>infinity</depthOption>");
			input.append("<ignoreExternalsOption>false</ignoreExternalsOption>");
			input.append("</hudson.scm.SubversionSCM_-ModuleLocation>");
			input.append("</locations>");
			input.append("<excludedRegions></excludedRegions>");
			input.append("<includedRegions></includedRegions>");
			input.append("<excludedUsers></excludedUsers>");
			input.append("<excludedRevprop></excludedRevprop>");
			input.append("<excludedCommitMessages></excludedCommitMessages>");
			input.append("<workspaceUpdater class=" + "\"" + "hudson.scm.subversion.UpdateUpdater"
					+ "\"" + "/>");
			input.append("<ignoreDirPropChanges>false</ignoreDirPropChanges>");
			input.append("<filterChangelog>false</filterChangelog>");
			input.append("</scm>");
		} else {
			input.append("<scm class=" + "\"" + "hudson.scm.NullSCM" + "\"" + "/>");
		}

		input.append("<canRoam>true</canRoam>");
		input.append("<disabled>false</disabled>");
		input.append("<blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>");
		input.append("<blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>");
		input.append("<triggers/>");
		input.append("<concurrentBuild>false</concurrentBuild>");
		if (StringUtils.isNotEmpty(itapConfigDTO.getToolName())) {
			if ("Selenium".equalsIgnoreCase(itapConfigDTO.getToolName())) {
				input.append("<customWorkspace>E:/AutoHub/Solution/Mobile/CMAF_SeeTest_2_NewXml</customWorkspace>");
			}
		}

		if (StringUtils.isNotEmpty(itapConfigDTO.getSprintTest())) {
			input.append("<customWorkspace>E:\\SprintTest\\SprintestXBT</customWorkspace>");
		}

		input.append("<builders>");

		if (StringUtils.isNotEmpty(itapConfigDTO.getSprintTest())) {

			// batch file execution
			input.append("<hudson.tasks.BatchFile>");
			input.append("<command>");
			input.append("call E:/SprintTest/SprintestXBT/SprintTestExecution-IE-Registry-Setting.bat");
			input.append("</command>");
			input.append("</hudson.tasks.BatchFile>");
		}

		if (StringUtils.isNotEmpty(itapConfigDTO.getSprintTest())) {

			input.append("<hudson.tasks.Ant plugin=" + "\"" + "ant@1.3" + "\"" + ">");
			input.append("<targets/>");
			input.append("<antName>McDonalds Ant</antName>");
			input.append("</hudson.tasks.Ant>");

		}
		// TODO for ant
		if (1 == 2) {
			// SonarQube 2.3 start
			input.append("<hudson.plugins.sonar.SonarRunnerBuilder plugin=" + "\"" + "sonar@2.3"
					+ "\"" + ">");
			input.append("<project/>");
			input.append("<properties>");
			input.append("sonar.projectKey=lar:com.barclays.lar sonar.projectName=LAR sonar.projectVersion=1.0 sonar.sources=src sonar.exclusions=**/bower_components/**, app.js");
			input.append("</properties>");
			input.append("<javaOpts/>");
			input.append("<additionalArguments/>");
			input.append("<jdk>(Inherit From Job)</jdk>");
			input.append("<task/>");
			input.append("</hudson.plugins.sonar.SonarRunnerBuilder>");
			// SonarQube 2.3 end
		}

		// JOB 2 CODE COVERAGE ANALYSIS
		if (StringUtils.isNotEmpty(itapConfigDTO.getCodeCvg())) {

			if (!"CoreTool".equalsIgnoreCase(itapConfigDTO.getCodeCvg())) {

				// batch file execution
				input.append("<hudson.tasks.BatchFile>");
				input.append("<command>");
				input.append("call E:/AutoHub/CyclosWorkSpace/cyclos/CodeCoverage.bat");
				input.append("</command>");
				input.append("</hudson.tasks.BatchFile>");
			}

			if ("CoreTool".equalsIgnoreCase(itapConfigDTO.getCodeCvg())) {

				// batch file execution
				input.append("<hudson.tasks.BatchFile>");
				input.append("<command>");
				input.append("call E:/CoreTools/coretool_exe.bat");
				input.append("</command>");
				input.append("</hudson.tasks.BatchFile>");
			}
		}

		if (StringUtils.isNotEmpty(itapConfigDTO.getDcompare())) {

			// batch file execution
			input.append("<hudson.tasks.BatchFile>");
			input.append("<command>");
			input.append("call E:/yagnesh/invokePerfecto.bat");
			input.append("</command>");
			input.append("</hudson.tasks.BatchFile>");

			// batch file execution
			input.append("<hudson.tasks.BatchFile>");
			input.append("<command>");
			input.append("E:/CMAF_Selenium_Perfecto_NewXml_AutoHUB/InvokeMorganPerfecto.bat");
			input.append("</command>");
			input.append("</hudson.tasks.BatchFile>");
		}

		if (StringUtils.isNotEmpty(itapConfigDTO.getBddSct())) {

			// batch file execution
			input.append("<hudson.tasks.BatchFile>");
			input.append("<command>");
			input.append(ITAPConstants.BDD_BAT_FILE);
			input.append("</command>");
			input.append("</hudson.tasks.BatchFile>");
		}

		if (StringUtils.isNotEmpty(itapConfigDTO.getTestSuite())
				&& !"Select".equalsIgnoreCase(itapConfigDTO.getTestSuite())) {

			// batch file execution
			input.append("<hudson.tasks.BatchFile>");
			input.append("<command>");
			input.append(ITAPConstants.OPTIK_BAT_FILE);
			input.append("</command>");
			input.append("</hudson.tasks.BatchFile>");

			/*
			 * input.append("<hudson.tasks.BatchFile>");
			 * input.append("<command>"); input.append(
			 * "call E:/AutoHub/Solution/Optik/Scripts/Optik_Perfecto_execute.bat"
			 * ); input.append("</command>");
			 * input.append("</hudson.tasks.BatchFile>");
			 */
		}

		// API
		if (StringUtils.isNotEmpty(itapConfigDTO.getApiTest())) {

			// batch file execution
			input.append("<hudson.tasks.BatchFile>");
			input.append("<command>");
			input.append("call E:/AutoHub/Solution/Twist/Scripts/API_Test.bat");
			input.append("</command>");
			input.append("</hudson.tasks.BatchFile>");
		}

		// LR
		if (StringUtils.isNotEmpty(itapConfigDTO.getToolName1())
				&& "LR".equalsIgnoreCase(itapConfigDTO.getToolName1())) {

			// batch file execution
			input.append("<hudson.tasks.BatchFile>");
			input.append("<command>");
			input.append("call E:/PerformanceTestScripts/PerformanceTestScenarios/Load_Testing_McD_start.bat");
			input.append("</command>");
			input.append("</hudson.tasks.BatchFile>");
		}
		// UFT
		if (StringUtils.isNotEmpty(itapConfigDTO.getToolName())
				&& !"None".equalsIgnoreCase(itapConfigDTO.getToolName())) {

			if ("Selenium".equalsIgnoreCase(itapConfigDTO.getToolName())) {
				// Ant execution
				// input.append("<hudson.tasks.Ant plugin= " + "\"" + "ant@1.2"
				// + "\"" + ">");
				// input.append("<targets>run</targets>");
				// input.append("</hudson.tasks.Ant>");

				input.append("<hudson.tasks.BatchFile>");
				input.append("<command>");
				input.append("call E:/AutoHub/Solution/CafeNextSelenium/invokeFile.bat");
				input.append("</command>");
				input.append("</hudson.tasks.BatchFile>");

			} else if ("UFT".equalsIgnoreCase(itapConfigDTO.getToolName())) {
				// batch file execution
				input.append("<hudson.tasks.BatchFile>");
				input.append("<command>");
				input.append(itapConfigDTO.getUftPath());
				input.append("</command>");
				input.append("</hudson.tasks.BatchFile>");

			} else if ("Test Complete".equalsIgnoreCase(itapConfigDTO.getToolName())) {
				input.append("<com.smartbear.jenkins.plugins.testcomplete.TcTestBuilder plugin="
						+ "\"" + "TestComplete@1.4" + "\"" + ">");
				input.append("<suite>");
				input.append("E:/TestComplete 11 Projects/TestComplete/Cyclos/CyclosAppSuite/CyclosAppSuite.pjs");
				input.append("</suite>");
				input.append("<launchType>lcSuite</launchType>");
				input.append("<project/>");
				input.append("<unit/>");
				input.append("<routine/>");
				input.append("<test/>");
				input.append("<executorType>any</executorType>");
				input.append("<executorVersion>any</executorVersion>");
				input.append("<actionOnWarnings>NONE</actionOnWarnings>");
				input.append("<actionOnErrors>MAKE_UNSTABLE</actionOnErrors>");
				input.append("<useTimeout>false</useTimeout>");
				input.append("<timeout/>");
				input.append("<useTCService>false</useTCService>");
				input.append("<userName/>");
				input.append("<userPassword/>");
				input.append("<useActiveSession>false</useActiveSession>");
				input.append("<generateMHT>false</generateMHT>");
				input.append("<publishJUnitReports>true</publishJUnitReports>");
				input.append("</com.smartbear.jenkins.plugins.testcomplete.TcTestBuilder>");
			}
		}
		input.append("</builders>");

		input.append("<publishers>");
		if (StringUtils.isNotEmpty(itapConfigDTO.getPostBuildInvoke())) {
			// TODO pipe line project post build trigger starts
			input.append("<hudson.tasks.BuildTrigger>");
			input.append("<childProjects>");
			input.append(itapConfigDTO.getPostBuildInvoke());
			input.append("</childProjects>");
			input.append("<threshold>");
			input.append("<name>FAILURE</name>");
			input.append("<ordinal>2</ordinal>");
			input.append("<color>RED</color>");
			input.append("<completeBuild>true</completeBuild>");
			input.append("</threshold>");
			input.append("</hudson.tasks.BuildTrigger>");
			// TODO pipe line project post build trigger Ends
		}
		input.append("</publishers>");
		// Selenium
		if (StringUtils.isNotEmpty(itapConfigDTO.getToolName())) {
			if ("Selenium".equalsIgnoreCase(itapConfigDTO.getToolName())) {
				input.append("<buildWrappers>");
				input.append("<org.jenkinsci.plugins.testinprogress.TestInProgressBuildWrapper plugin="
						+ "\"" + "testInProgress@1.4" + "\"" + "/>");
				input.append("</buildWrappers>");
			} else {
				input.append("<buildWrappers/>");
			}
		} else {
			input.append("<buildWrappers/>");
		}

		input.append("</project>");

		return input + "";
	}

	public static HttpResponse buildJob(String jenurl, String jobName) {
		HttpResponse responseCode = null;
		try {

			HttpClient client = HttpClientBuilder.create().build();
			String finalUrl = jenurl + "/job/" + jobName + "/build";
			HttpGet get = new HttpGet(finalUrl);
			responseCode = client.execute(get);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseCode;
	}

	public static HttpResponse buildJob(String jenurl, String jobName, long delay) {
		HttpResponse responseCode = null;
		try {
			String finalUrl = "";
			if (jenurl.endsWith("/")) {
				finalUrl = jenurl + "job/" + jobName + "/build";
			} else {
				finalUrl = jenurl + "/job/" + jobName + "/build";
			}

			HttpClient client = HttpClientBuilder.create().build();

			if (delay > 0) {
				finalUrl = finalUrl + "?delay=" + delay;
			}
			HttpGet get = new HttpGet(finalUrl);
			responseCode = client.execute(get);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseCode;
	}

	public static String getMasterSlavesNodes(String url) {
		Client client = Client.create();
		// client.addFilter(new
		// com.sun.jersey.api.client.filter.HTTPBasicAuthFilter(USERNAME,
		// PASSWORD));
		url = "http://in-pnq-coe37:8080/jenkins";
		WebResource webResource = client.resource(url + "/computer/api/json");
		ClientResponse response = webResource.get(ClientResponse.class);
		String jsonResponse = response.getEntity(String.class);
		client.destroy();
		// System.out.println("Response readJob:::::"+jsonResponse);
		return jsonResponse;
	}
}