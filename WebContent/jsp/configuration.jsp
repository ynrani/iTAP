<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iTAP | CI Testing</title>

<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/configuration.css" rel="stylesheet">
<link href="css/multiselect.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Roboto"	rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<nav class="navbar navbar-default navbar-fixed-top ">
			<jsp:include page="header.jsp"></jsp:include>
			<!-- /.container-fluid -->
		</nav>
	</header>
	<form:form id="itapConfigDTOForm" name="itapConfigDTOForm"	action="${pageContext.request.contextPath}/configuration" method="post" modelAttribute="itapConfigDTO">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
		<form:hidden path="combinedBrowserCombo" id="combinedBrowserComboId" value="" />
		<form:hidden path="combinedDeviceCombo" id="combinedDeviceComboId" value="" />
		<form:hidden path="toExecuteFlag" id="toExecuteFlagId" value="" />
		<form:hidden path="configId" />
		<section id="services" class="bg-color first_section">
			<div class="container" style="margin-bottom: -83px;">
				<div class="row">
					<div class="col-md-12">
						<h2 class="configg-heading label-color headingfont-size">TASK CONFIGURATION</h2>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<div class="form-group">
							<div class="col-md-4 col-xs-3 col-s-3">
								<label class="label-color">Project Name</label> <label class="label-color" style="color: #FF0000"> *</label>
							</div>
							<div></div>
							<div class="col-md-6 col-xs-6 col-s-6">
								<div class="form-group ">
									<form:select path="projName" id="projName" required="required" class="form-control header-dropdown menu-dropdown">
										<form:option value="">- Select -</form:option>
										<c:forEach items="${itapConfigDTO.allProjs}" var="allProjs">
											<form:option value="${allProjs}">${allProjs}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="col-md-2 col-xs-3 col-s-3">
								<img src="img/about/pluswhite.png" alt="plusImg" class="plusimage" id="plusClick">
							</div>
						</div>
					</div>
					<div class="col-md-6 col-xs-6">
						<div class="form-group">
							<div class="col-md-3 col-xs-3 col-s-3">
								<label class="label-color">Job Name</label> <label class="label-color" style="color: #FF0000"> *</label>
							</div>
							<div class="col-md-6 col-xs-6 col-s-6">
								<div class="form-group ">
									<form:select path="jobName" id="jobName" required="required" class="form-control header-dropdown menu-dropdown">
										<form:option value="">- Select -</form:option>
										<c:forEach items="${itapConfigDTO.allJobs}" var="allJobs">
											<form:option value="${allJobs}">${allJobs}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="col-md-3 col-xs-3 col-s-3 ">
								<img src="img/about/pluswhite.png" alt="plusImg" class="plusImageRight" id="plusClick2">
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<div style="display: none">
			<form:label path="saveStatus" id="saveStatus">${itapConfigDTO.saveStatus} </form:label>
			<!-- <label id="saveStatus"></label> -->
		</div>
		<!-- Container Start -->
		<div class="container container-margin">
			<div id="statusDiv" style="display: none" align="center">
				<label id="statusLabelFail"> Job creation failed . Please try after some time !</label> <label id="statusLabelSuccess"> Jobs created successfully !</label>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<div class="pull-right">
					<a id="expandAll" href="#" class="btn btn-default" role="button">Expand	All</a> <a id="collapseAll" href="#" class="btn btn-default" role="button">Collapse All</a>
				</div>
			</div>
		 	<div class="panel-group" id="jenkinAccordion" style="padding-bottom: 10px;padding-top: 10px;">
				<div class="col-md-6">
					<label class=" col-md-4 control-label">Select CI Engine :</label>
					<div class="col-md-8">
						<form:select class="form-control borderform setting-input"	path="serverId" id="usage">
							<c:forEach items="${itapConfigDTO.ciEnginsList}" var="ciEnginesName">
								<form:option value="${ciEnginesName.jenkinsId}">${ciEnginesName.jenkinsName}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-6" style="padding-top: 10px;padding-bottom: 10px;">&nbsp;</div>
			</div>
			<div class="panel-group" id="blank" >
			&nbsp;
			</div>
			<!-- Panel Group Start  -->
			<div class="panel-group" id="accordion">
				<!-- Panel 1 Start  -->
				<div class="panel ">
					<div class="panel-heading pannelbottom-border">
						<h4 class="panel-title">
							<img src="img/about/tick.png" class="tick-width"> 
								<a data-toggle="collapse" href="#collapse1" class="headingfont-size heading-margin">Source Configuration Management</a>
						</h4>
					</div>
					<div id="collapse1"
						class="panel-collapse collapse col-md-12 code-coverage border-color">
						<div class="row">
							<div class="form-group col-md-12 col-xs-12">
								<label class=" col-md-3 control-label">Source</label>
								<div class="form-group col-md-9">
									<form:select path="source" class="form-control" id="source">
										<form:option value="">- Select -</form:option>
										<form:option value="SVN">SVN</form:option>
										<form:option value="CVS">CVS</form:option>
										<form:option value="GIT-HUB">GIT-HUB</form:option>
									</form:select>
								</div>
							</div>
							<div id="repoUrl1"  class="form-group col-md-12 col-xs-12">
								<label for="repoUrl" class="control-label col-md-3">Repository Url</label>
								<div class="col-md-9">
									<form:input path="repoUrl" class="form-control" id="repoUrl" />
								</div>
							</div>
						</div>
						<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1103px" data-toggle="collapse">
					</div>
				</div>
				<!-- Panel 1 End  -->
				<!-- Panel 2 Start  -->
				<div class="panel">
					<div class="panel-heading pannelbottom-border">
						<h4 class="panel-title">
							<img src="img/about/tick.png" class="tick-width">
							 <a	data-toggle="collapse" href="#collapse2" class="headingfont-size heading-margin">CODE COVERAGE ANALYSIS</a>
						</h4>
					</div>
					<div id="collapse2"	class="panel-collapse collapse col-md-12 code-coverage border-color">
						<div class="col-xs-12 col-md-12">
							<div class="col-md-3">
								<label> Code Coverage</label>
							</div>
							<div class="form-group">
								<div class="form-group col-md-9 col-xs-12">
									<form:select path="codeCvg" id="codeCvg" class="form-control">
										<form:option value="">- Select -</form:option>
										<form:option value="Sonarqube">Sonarqube</form:option>
										<form:option value="Corbetura">Corbetura</form:option>
										<form:option value="CoreTool">Core Tool</form:option>
									</form:select>
								</div>
							</div>
						</div>
						<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1087px" data-toggle="collapse">
					</div>
				</div>
				<!-- Panel 2 End  -->
				<!-- Panel 3 Start  -->
				<div class="panel">
					<div class="panel-heading pannelbottom-border">
						<h4 class="panel-title">
							<img src="img/about/tick.png" class="tick-width"> 
							<a data-toggle="collapse" href="#collapse3"	class="headingfont-size heading-margin">UNIT TEST</a>
						</h4>
					</div>
					<div id="collapse3"	class="panel-collapse collapse col-md-12 border-color code-coverage">
						<div class="col-xs-12 col-md-12">
							<div class="col-md-3">
								<label> Type Of Test</label>
							</div>
							<div class="form-group">
								<div class="form-group col-md-9 col-xs-12">
									<form:select path="testType" id="testType" class="form-control">
										<form:option value="">- Select -</form:option>
										<form:option value="JUnit">JUnit</form:option>
										<form:option value="Others">Others</form:option>
									</form:select>
								</div>
							</div>
						</div>
						<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1087px" data-toggle="collapse">
					</div>
				</div>
				<!-- Panel 3 End  -->
				<!-- Panel 4 Start  -->
				<div class="panel">
					<div class="panel-heading pannelbottom-border">
						<h4 class="panel-title">
							<img src="img/about/tick.png" class="tick-width">
							 <a	data-toggle="collapse" href="#collapse4" class="headingfont-size heading-margin">ENVIRONMENT SETUP</a>
						</h4>
					</div>
					<div id="collapse4"
						class="panel-collapse collapse border-color col-md-12 ">
						<div class="row">
							<div class="col-md-12 env-margin">
								<div class="form-group col-md-4 col-xs-6">
									<div class=" col-md-3 col-xs-12">
										<label class="control-label">Enviorment</label>
									</div>
									<div class="form-group col-md-9 col-xs-12">
										<form:select path="enviorment" id="enviorment" class="form-control">
											<form:option value="">- Select -</form:option>
											<c:forEach items="${itapConfigDTO.allEnvs}" var="allEnvs">
												<form:option value="${allEnvs}">${allEnvs}</form:option>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div id="chkAvil" class="col-md-3 col-xs-2">
									<button type="button" onClick="javascript:chkEnvAvil();" class="btn btn-info">Check Availability</button>
								</div>
							</div>

							<div class="col-md-12 env-margin">
								<div class="form-group col-md-4 col-xs-3">
									<div class="checkbox">
										<label><form:checkbox path="sanity" value="sanity" />Sanity</label>
									</div>
								</div>
								<div class="form-group col-md-4 col-xs-3">
									<div class="checkbox">
										<label><form:checkbox path="docker" value="Docker" />Docker</label>
									</div>
								</div>
							</div>
						</div>
						<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
					</div>
				</div>
				<!-- Panel 4 End  -->
				<!-- Panel 5 Start  -->
				<div class="panel ">
					<div class="panel-heading pannelbottom-border">
						<h4 class="panel-title">
							<img src="img/about/tick.png" class="tick-width">
							 <a	data-toggle="collapse" href="#collapse7" class="headingfont-size heading-margin">Build &amp; Deploy</a>
						</h4>
					</div>
					<div id="collapse7"
						class="panel-collapse collapse col-md-12 code-coverage border-color">
						<div class="col-xs-12 col-md-12">
							<form class="form-horizontal">
								<div class="form-group">
									<div class="form-group col-md-6 col-xs-4">
										<label class="checkbox-inline"> 
											<form:checkbox	path="pckage" value="Package" />Package
										</label>
									</div>
									<div class="form-group col-md-6 col-xs-4">
										<label class="checkbox-inline"> 
										  <form:checkbox path="deployment" value="Deployment" />Deployment
										</label>
									</div>
									<div class="row row-margin">
										<div class="col-md-12">
											<div class="form-group">
												<div class="col-md-6">
													<div class="col-md-6">
														<label>Quality Gate 1:</label>
													</div>
													<div class="col-md-6">
														<div class="form-group col-md-9">
															<form:select path="qualityGate1" class="form-control">
																<form:option value="">- Select -</form:option>
																<form:option value="Code Coverage">Code Coverage</form:option>
																<form:option value="Unit Test">Unit Test</form:option>
																<form:option value="Environment Sanity">Environment Sanity</form:option>
															</form:select>
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-md-6">
														<label>Criteria:</label>
													</div>
													<div class="col-md-6">
														<form:input path="criteria1" class="form-control col-md-4"	id="" />
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row row-margin">
										<div class="col-md-12">
											<div class="form-group">
												<div class="col-md-6">
													<div class="col-md-6">
														<label>Quality Gate 2:</label>
													</div>
													<div class="col-md-6">
														<div class="form-group col-md-9">
															<form:select path="qualityGate2" class="form-control">
																<form:option value="">- Select -</form:option>
																<form:option value="Code Coverage">Code Coverage</form:option>
																<form:option value="Unit Test">Unit Test</form:option>
																<form:option value="Environment Sanity">Environment Sanity</form:option>
															</form:select>
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-md-6">
														<label>Criteria:</label>
													</div>
													<div class="col-md-6">
														<form:input path="criteria2" class="form-control col-md-4" id="criteria2" />
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
						<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
					</div>
				</div>
				<!-- Panel 5 End  -->
				<!-- Panel 6 Start  -->
				<div class="panel">
					<div class="panel-heading pannelbottom-border">
						<h4 class="panel-title">
							<img src="img/about/tick.png" class="tick-width">
							 <a data-toggle="collapse" href="#collapseagain" class="testingToggle headingfont-size heading-margin">Testing</a>
						</h4>
					</div>

					<div id="collapseagain" class="panel-collapse collapse col-md-12 code-coverage border-color">
						<!-- Panel 6.1 Start  -->
						<div class="panel" id="funnctionsla">
							<div class="panel-heading pannelbottom-border">
								<h4 class="panel-title testing-submenu">
									<img src="img/about/Addcopy.png" class="tick-width"> 
									<a data-toggle="collapse" href="#collapse8" class="headingfont-size heading-margin">BDD</a>
								</h4>
							</div>
							<div id="collapse8" class="panel-collapse collapse col-md-12 code-coverage">
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-3">
													<label>Select Column:</label>
												</div>
												<div class="col-md-5">
													<div class="form-group col-md-4">
														<form:select path="bddTestSuiteColumnName" class="form-control" id="bddTestSuiteColumnNameId"
															onchange="getTestColValuesForToolNCol('BDD','bddTestSuiteColumnNameId','bddTestSuiteColumnValueId');">
															<form:option value="None">None</form:option>
															<form:option value="testScenario">Scenario</form:option>
															<form:option value="requirement">Requirement</form:option>
															<form:option value="testCase">Test Case</form:option>
															<form:option value="testSet">Test Set</form:option> 
															<form:option value="manualOrAutoFlag">Auto/Manual</form:option>
															<form:option value="estManualEff">Manual Effort</form:option>
															<form:option value="estAutomateEff">Auto. Effort</form:option>
															<form:option value="priority">Priority</form:option>
															<form:option value="criticality">Criticality</form:option>
															<form:option value="defect">Defect</form:option>
														</form:select>
													</div>
													<div class="form-group col-md-4">
														<form:select path="bddTestSuiteColumnValue" class="form-control" id="bddTestSuiteColumnValueId">
															<form:option value="Select">Select</form:option>
														</form:select>
													</div>
												</div>
												<div class="form-group col-md-2">
													<button type="button" class="btn btn-primary" id="fetchTC"
														onclick="getTestCasesForToolNCol('BDD','bddTestSuiteColumnNameId','bddTestSuiteColumnValueId');">Fetch</button>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" style="padding-left: 1%;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="form-group" style="padding-left: 5px !important;">
													<table id="BDDTestCaseTableId">
														<thead>
															<tr>
																<th style="width: 2%; padding-left: 1px; border-bottom: 1pt solid black;">&nbsp;</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Reference</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Scenario</th>
																<th style="width: 13.5%; padding-left: 1px; border-bottom: 1pt solid black;">Test Case</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Test Set</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Auto/Manual</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Manual Effort</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Auto. Effort</th>
																<th style="width: 6%; padding-left: 1px; border-bottom: 1pt solid black;">Priority</th>
																<th style="width: 7%; padding-left: 1px; border-bottom: 1pt solid black;">Criticality</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Defect</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">TDM Data Exist</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td align="center" colspan="9"><label>&nbsp;</label></td>
															</tr>
															<tr>
																<td align="center" colspan="9"><label>No Test Case.</label></td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
							</div>
						</div>
						<!-- Panel 6.1 End  -->
						<!-- Panel 6.2 Start  -->
						<div class="panel" id="funnctionslb">
							<div class="panel-heading pannelbottom-border">
								<h4 class="panel-title testing-submenu">
									<img src="img/about/Addcopy.png" class="tick-width"> 
									<a data-toggle="collapse" href="#collapse9" class="headingfont-size heading-margin">API Testing</a>
								</h4>
							</div>
							<div id="collapse9" class="panel-collapse collapse col-md-12 code-coverage">

								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-3">
													<label>Select Column:</label>
												</div>
												<div class="col-md-5">
													<div class="form-group col-md-4">
														<form:select path="apiTestSuiteColumnName" class="form-control" id="apiTestSuiteColumnNameId"
															onchange="getTestColValuesForToolNCol('APITESTING','apiTestSuiteColumnNameId','apiTestSuiteColumnValueId');">
															<form:option value="None">None</form:option>
															<form:option value="testScenario">Scenario</form:option>
															<form:option value="requirement">Requirement</form:option>
															<form:option value="testCase">Test Case</form:option>
															<form:option value="testSet">Test Set</form:option>
															<form:option value="manualOrAutoFlag">Auto/Manual</form:option>
															<form:option value="estManualEff">Manual Effort</form:option>
															<form:option value="estAutomateEff">Auto. Effort</form:option>
															<form:option value="priority">Priority</form:option>
															<form:option value="criticality">Criticality</form:option>
															<form:option value="defect">Defect</form:option>
														</form:select>
													</div>
													<div class="form-group col-md-4">
														<form:select path="apiTestSuiteColumnValue" class="form-control" id="apiTestSuiteColumnValueId">
															<form:option value="Select">Select</form:option>
														</form:select>
													</div>
												</div>
												<div class="form-group col-md-2">
													<button type="button" class="btn btn-primary" id="fetchTC"
														onclick="getTestCasesForToolNCol('APITESTING','apiTestSuiteColumnNameId','apiTestSuiteColumnValueId');">Fetch</button>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" style="padding-left: 1%;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="form-group"
													style="padding-left: 5px !important;">
													<table id="APITESTINGTestCaseTableId">
														<thead>
															<tr>
																<th style="width: 2%; padding-left: 1px; border-bottom: 1pt solid black;">&nbsp;</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Reference</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Scenario</th>
																<th style="width: 13.5%; padding-left: 1px; border-bottom: 1pt solid black;">Test Case</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Test Set</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Auto/Manual</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Manual Effort</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Auto. Effort</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Priority</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Criticality</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Defect</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">TDM Data Exist</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td align="center" colspan="9"><label>&nbsp;</label></td>
															</tr>
															<tr>
																<td align="center" colspan="9"><label>No Test Case.</label></td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
							</div>
						</div>
						<!-- Panel 6.2 End  -->
						<!-- Panel 6.3 Start  -->
						<div class="panel" id="test2">
							<div class="panel-heading pannelbottom-border">
								<h4 class="panel-title testing-submenu">
									<img src="img/about/Addcopy.png" class="tick-width">
									 <a data-toggle="collapse" href="#collapse6" class="headingfont-size heading-margin">CROSS BROWSER TESTING</a>
								</h4>
							</div>
							<div id="collapse6" class="panel-collapse collapse">
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-2">
													<label>Test Suite:</label>
												</div>
												<div class="col-md-3">
													<form:select path="testSuite" class="form-control col-md-4" id="OPTIKTSSelectId">
														<form:option label="Select" value="Select" id="Select" />
														<c:forEach items="${itapConfigDTO.optikTestSuiteList}" var="testSuite">
															<form:option label="${testSuite}" value="${testSuite}" id="${testSuite}_TCId" />
														</c:forEach>
													</form:select>
												</div>
												<div class="form-group col-md-2">
													<form:select path="bddTestSuiteColumnName" class="form-control" id="optikTestSuiteColumnNameId" onchange="getTestColValuesForOPTIKNCol();">
														<form:option value="None">None</form:option>
														<form:option value="testScenario">Scenario</form:option>
														<form:option value="requirement">Requirement</form:option>
														<form:option value="testCase">Test Case</form:option>
														<form:option value="testSet">Test Set</form:option>	
														<form:option value="manualOrAutoFlag">Auto/Manual</form:option>
														<form:option value="estManualEff">Manual Effort</form:option>
														<form:option value="estAutomateEff">Auto. Effort</form:option>
														<form:option value="priority">Priority</form:option>
														<form:option value="criticality">Criticality</form:option>
														<form:option value="defect">Defect</form:option>
													</form:select>
												</div>
												<div class="form-group col-md-3">
													<form:select path="optikTestSuiteColumnValue" class="form-control" id="optikTestSuiteColumnValueId">
														<form:option value="Select">Select</form:option>
													</form:select>
												</div>
												<div class="form-group col-md-2">
													<button type="button" class="btn btn-primary" id="fetchTC"
														onclick="getTestCasesForOPTIKNCol('OPTIK','apiTestSuiteColumnNameId','apiTestSuiteColumnValueId');">Fetch</button>
												</div>
											</div>

											<div class="row row-margin" style="padding-left: 1%;">
												<div class="col-md-12">
													<div class="form-group">
														<div class="col-md-12">
															<div class="form-group" style="padding-left: 5px !important;">
																<table id="OPTIKTestCaseTableId">
																	<thead>
																		<tr>
																			<th style="width: 2%; padding-left: 1px; border-bottom: 1pt solid black;">&nbsp;</th>
																			<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Reference</th>
																			<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Scenario</th>
																			<th style="width: 13.5%; padding-left: 1px; border-bottom: 1pt solid black;">Test Case</th>
																			<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Test Set</th>
																			<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Auto/Manual</th>
																			<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Manual Effort</th>
																			<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Auto. Effort</th>
																			<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Priority</th>
																			<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Criticality</th>
																			<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Defect</th>
																			<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">TDM Data Exist</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr>
																			<td align="center" colspan="9"><label>&nbsp;</label></td>
																		</tr>
																		<tr>
																			<td align="center" colspan="9"><label>No Test Case.</label></td>
																		</tr>
																	</tbody>
																</table>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-3">
												<label>Grid Type</label>
											</div>
											<div class="col-md-9">
												<form:select id="gridTypeId" path="gridType" class="form-control" onchange="selectUrl();">
													<form:option data-url="" id="Select" value="Select">- Select -</form:option>
													<c:forEach items="${itapConfigDTO.gridList}" var="grid">
														<form:option data-url="${grid.gridUrl}" id="${grid.gridType}" value="${grid.gridType}">${grid.gridType}</form:option>
													</c:forEach>
												</form:select>
											</div>
										</div>
									</div>
								</div>
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-3">
												<label>Grid Lab URL</label>
											</div>
											<div class="col-md-9">
												<form:select id="gridUrlId" path="gridLabUrl" onchange="getOptionsGivenGrid();" class="form-control col-md-4">
												</form:select>
											</div>
										</div>
									</div>
								</div>
								
								<div class="row row-margin" id="browserSelectionDivId" style="display: none;">									
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-3">
												<label>Operating Sys:</label>
											</div>
											<div class="form-group col-md-9">
												 <div class="col-md-3">
													<label><form:radiobutton path="optExeType" value="FN" />Functional</label>
												</div>
												<div class="col-md-3">
													<label><form:radiobutton path="optExeType" value="UI" />Functional UI </label>
												</div>
											</div>
											<div class="col-md-3">
												<label>Operating Sys:</label>
											</div>
											<div class="col-md-2">
												<form:select path="os" class="form-control col-md-4" onchange="changeBrowser();" id="OSSelectId">
													<form:option label="Select" value="Select" id="Select" />
													<c:forEach items="${itapConfigDTO.osList}" var="os">
														<form:option label="${os.osName}" id="${os.osName}"
															value="${os.osName}" data-osid="${os.osId}">${os.osName}</form:option>
													</c:forEach>
												</form:select>
											</div>
											<div class="col-md-2">
												<label>Browser:</label>
											</div>
											<div class="col-md-2">
												<form:select path="browser" class="form-control col-md-4" id="browserId" onchange="changeVersion();">
													<form:option label="Select" value="Select" id="Select" />
												</form:select>
											</div>
											<div class="col-md-2">
												<table>
													<tr>
														<td><div>
																<form:select path="version" class="form-control col-md-4" id="versionId">
																	<form:option label="Select" value="Select" id="Select" />
																</form:select>
																&nbsp;
															</div></td>
														<td style="vertical-align: top; padding-left: 10px;">
															<input type="button" name="Add" value="Add" class="btn btn-primary" onclick="addBrowser();">
														</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" id="browserSelectedDivId" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-3">
												<label>Selected Browsers</label>
											</div>
											<div class="col-md-6" id="selectedBrowserShow">
												<c:choose>
													<c:when
														test="${fn:length(itapConfigDTO.browserComboList) == 0}">
														<label>No Selections.</label>
													</c:when>
													<c:otherwise>
														<c:forEach items="${itapConfigDTO.browserComboList}" var="browserCombo">

															<div id="browDiv${browserCombo.browser}${browserCombo.operating}${browserCombo.version}"
																data-os="${browserCombo.operating}" data-browser="${browserCombo.browser}"
																data-version="${browserCombo.version}" class="browDivClass">
																<p>
																	<label><img src="img/Delete.png" width="20px" height="20px"
																		id="${browserCombo.browser}${browserCombo.operating}${browserCombo.version}"
																		onclick="deleteBrow(this.id);">&nbsp;On ${browserCombo.operating} Using
																		${browserCombo.browser}-${browserCombo.version}</label>
																</p>
															</div>

														</c:forEach>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" id="mobileSelectionDivId" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-3">
												<label>Device Name:</label>
											</div>
											<div class="col-md-2">
												<form:select path="perfectoDeviceName" class="form-control col-md-4" onchange="getDeviceUdid();" d="perfectoDeviceNameId">
												</form:select>
											</div>
											<div class="col-md-2">
												<table>
													<tr>
														<td><div>
																<form:select path="perfectoDeviceUdid" class="form-control col-md-4" id="perfectoDeviceUdidId">
																	<option id='Select' value='Select'>Select</option>
																</form:select>
																&nbsp;
															</div></td>
														<td style="vertical-align: top; padding-left: 10px;">
															<input type="button" name="Add" value="Add" class="btn btn-primary" onclick="addDevice();">
														</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" id="mobileSelectedDivId" style="display: none;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-3">
												<label>Selected Devices</label>
											</div>
											<div class="col-md-6" id="selectedMobileShow">
												<c:choose>
													<c:when
														test="${fn:length(itapConfigDTO.browserComboList) == 0}">
														<label>No Selections.</label>
													</c:when>
													<c:otherwise>
														<c:forEach items="${itapConfigDTO.browserComboList}" var="browserCombo">

															<div id="browDiv${browserCombo.browser}${browserCombo.operating}${browserCombo.version}"
																data-os="${browserCombo.operating}" data-browser="${browserCombo.browser}"
																data-version="${browserCombo.version}" class="browDivClass">
																<p>
																	<label><img src="img/Delete.png" width="20px" height="20px"
																		id="${browserCombo.browser}${browserCombo.operating}${browserCombo.version}"
																		onclick="deleteBrow(this.id);">&nbsp;On ${browserCombo.operating} Using
																		${browserCombo.browser}-${browserCombo.version}</label>
																</p>
															</div>
														</c:forEach>
													</c:otherwise>
												</c:choose>
											</div>
										</div>
									</div>
								</div>
								<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
							</div>
						</div>
						<!-- Panel 6.3 End  -->
				
						<!-- Panel 6.3.1 Start  -->		
						<div class="panel" id="funnctionslb">
							<div class="panel-heading pannelbottom-border">
								<h4 class="panel-title testing-submenu">
									<img src="img/about/Addcopy.png" class="tick-width"> 
									<a data-toggle="collapse" href="#collapse101" class="headingfont-size heading-margin">SprinTest</a>
								</h4>
							</div>
							<div id="collapse101" class="panel-collapse collapse col-md-12 code-coverage">
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-3">
													<label>Select Column:</label>
												</div>
												<div class="col-md-5">
													<div class="form-group col-md-4">
														<form:select path="sprintTestSuiteColumnName" class="form-control" id="sprintTestSuiteColumnNameId"
															onchange="getTestColValuesForToolNCol('SPT','sprintTestSuiteColumnNameId','sprintTestSuiteColumnValueId');">
															<form:option value="">None</form:option>
															<form:option value="testScenario">Scenario</form:option>
															<form:option value="requirement">Requirement</form:option>
															<form:option value="testCase">Test Case</form:option>
															<form:option value="testSet">Test Set</form:option>	
															<form:option value="manualOrAutoFlag">Auto/Manual</form:option>
															<form:option value="estManualEff">Manual Effort</form:option>
															<form:option value="estAutomateEff">Auto. Effort</form:option>
															<form:option value="priority">Priority</form:option>
															<form:option value="criticality">Criticality</form:option>
															<form:option value="defect">Defect</form:option>
														</form:select>
													</div>
													<div class="form-group col-md-4">
														<form:select path="sprintTestSuiteColumnValue" class="form-control" id="sprintTestSuiteColumnValueId">
															<form:option value="Select">Select</form:option>
														</form:select>
													</div>
												</div>
												<div class="form-group col-md-2">
													<button type="button" class="btn btn-primary" id="fetchTC" onclick="getTestCasesForToolNCol('SPT','sprintTestSuiteColumnNameId','sprintTestSuiteColumnValueId');">Fetch</button>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" style="padding-left: 1%;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="form-group"
													style="padding-left: 5px !important;">
													<table id="SPTTestCaseTableId">
														<thead>
															<tr>
																<th style="width: 2%; padding-left: 1px; border-bottom: 1pt solid black;">&nbsp;</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Reference</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Scenario</th>
																<th style="width: 13.5%; padding-left: 1px; border-bottom: 1pt solid black;">Test Case</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Test Set</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Auto/Manual</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Manual Effort</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Auto. Effort</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Priority</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Criticality</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Defect</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">TDM Data Exist</th>
															</tr>
														</thead>
														<tbody>
															<tr><td align="center" colspan="9"><label>&nbsp;</label></td> </tr>
															<tr> <td align="center" colspan="9"><label>No Test Case.</label></td> </tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
							</div>
						</div>
						<!-- Panel 6.3.1 End  -->
						
						<!-- Panel 6.4 Start  -->
						<div class="panel" id="test3">
							<div class="panel-heading pannelbottom-border">
								<h4 class="panel-title testing-submenu">
									<img src="img/about/Addcopy.png" class="tick-width"> 
									<a data-toggle="collapse" href="#collapse10" class="headingfont-size heading-margin">Functional TESTING</a>
								</h4>
							</div>
							<div id="collapse10" class="panel-collapse collapse">
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-3">
													<label>Select Tool:</label>
												</div>
												<div class="col-md-5">
													<div class="form-group col-md-4">
														<form:select path="toolName" class="form-control" id="toolNameId">
															<form:option value="None">- Select -</form:option>
															<form:option value="UFT">UFT</form:option>
															<form:option value="Selenium">Selenium</form:option>
															<form:option value="Test Complete">Test Complete</form:option>
														</form:select>
													</div>
													<div class="form-group col-md-4">
														<form:select path="toolColumn" class="form-control" onchange="getToolColumnValues();" id="toolColumnId">
															<form:option value="None">None</form:option>
															<form:option value="testScenario">Scenario</form:option>
															<form:option value="requirement">Requirement</form:option>
															<form:option value="testCase">Test Case</form:option>
															<form:option value="testSet">Test Set</form:option>
															<form:option value="manualOrAutoFlag">Auto/Manual</form:option>
															<form:option value="estManualEff">Manual Effort</form:option>
															<form:option value="estAutomateEff">Auto. Effort</form:option>
															<form:option value="priority">Priority</form:option>
															<form:option value="criticality">Criticality</form:option>
															<form:option value="defect">Defect</form:option>		
														</form:select>
													</div>
													<div class="form-group col-md-4">
														<form:select path="toolColumnValue" class="form-control" id="toolColumnValueId">
															<form:option value="None">None</form:option>
														</form:select>
													</div>
												</div>
												<div class="form-group col-md-2">
													<button type="button" class="btn btn-primary" id="fetchTC" onclick="getToolTestCase();">Fetch</button>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" style="padding-left: 1%;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="form-group" style="padding-left: 5px !important;" id="toolSpecificTestCaseSelectDiv">
													<table id="testCaseTableId">
														<thead>
															<tr>
																<th style="width: 2%; padding-left: 1px; border-bottom: 1pt solid black;">&nbsp;</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Reference</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Scenario</th>
																<th style="width: 13.5%; padding-left: 1px; border-bottom: 1pt solid black;">Test Case</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Test Set</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Auto/Manual</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Manual Effort</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Auto. Effort</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Priority</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Criticality</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Defect</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">TDM Data Exist</th>						
															</tr>
														</thead>
														<tbody>
															<tr>
																<td colspan="9">&nbsp;</td>
																<c:choose>
																	<c:when
																		test="${fn:length(itapConfigDTO.toolSpecificTestCase) > 0}">
																		<c:forEach items="${itapConfigDTO.toolSpecificTestCase}" var="testCaseDO" varStatus="counter">
																			<tr style="height: 15px;">
																				<c:if test="${counter.index<10}">
																					<c:choose>
																						<c:when test="${fn:contains(itapConfigDTO.selectedTestCases, testCaseDO.testCase)}">
																				<td style="width: 2%; padding-left: 1px;">
																				<input type="checkbox" id="selectedTestCases0${counter.index+1}" name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}" checked="checked"></td>
																						</c:when>
																						<c:otherwise>
																							<td style="width: 2%; padding-left: 1px;">
																							<input type="checkbox" id="selectedTestCases0${counter.index+1}" name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}"></td>
																						</c:otherwise>
																					</c:choose>
																				</c:if>
																				<c:if test="${counter.index>=10}">
																					<c:choose>
																						<c:when test="${fn:contains(itapConfigDTO.selectedTestCases, testCaseDO.testCase)}">
																							<td style="width: 2%; padding-left: 1px;">
																							<input type="checkbox" id="selectedTestCases${counter.index+1}" name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}" checked="checked"></td>
																						</c:when>
																						<c:otherwise>
																							<td style="width: 2%; padding-left: 1px;">
																							<input type="checkbox" id="selectedTestCases${counter.index+1}" name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}"></td>
																						</c:otherwise>
																					</c:choose>
																				</c:if>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.requirement}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.testScenario}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.testCase}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.manualOrAutoFlag}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.estManualEff}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.estAutomateEff}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.priority}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.criticality}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.defect}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.tdmDataExist}</td>
																			</tr>
																		</c:forEach>
																	</c:when>
																	<c:otherwise>
																		<tr><td colspan="9" style="align: center;" align='center'><label>No Test Case Selected.</label></td></tr>
																	</c:otherwise>
																</c:choose>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-6">
												<div class="col-md-6">
													<label>Quality Gate 1:</label>
												</div>
												<div class="col-md-6">
													<div class="form-group col-md-9">
														<form:select path="ftQalityGate1" class="form-control">
															<form:option value="">- Select -</form:option>
															<form:option value="BDD">BDD</form:option>
															<form:option value="API">API</form:option>
															<form:option value="Functional">Functional</form:option>
														</form:select>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="col-md-6">
													<label>Criteria:</label>
												</div>
												<div class="col-md-6">
													<form:input path="ftCriteria1" class="form-control col-md-4" id="ftCriteria1" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-6">
												<div class="col-md-6">
													<label>Quality Gate 2:</label>
												</div>
												<div class="col-md-6">
													<div class="form-group col-md-9">
														<form:select path="ftQalityGate2" class="form-control">
															<form:option value="">- Select -</form:option>
															<form:option value="BDD">BDD</form:option>
															<form:option value="API">API</form:option>
															<form:option value="Functional">Functional</form:option>
														</form:select>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="col-md-6"> <label>Criteria:</label>
												</div>
												<div class="col-md-6">
													<form:input path="ftCriteria2" class="form-control col-md-4" id="ftCriteria2" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-6">
												<div class="col-md-6">
													<label>Quality Gate 3:</label>
												</div>
												<div class="col-md-6">
													<div class="form-group col-md-9">
														<form:select path="ftQalityGate3" class="form-control">
															<form:option value="">- Select -</form:option>
															<form:option value="BDD">BDD</form:option>
															<form:option value="API">API</form:option>
															<form:option value="Functional">Functional</form:option>
														</form:select>
													</div>
												</div>
											</div>
											<div class="col-md-6">
												<div class="col-md-6">
													<label>Criteria:</label>
												</div>
												<div class="col-md-6">
													<form:input path="ftCriteria3" class="form-control col-md-4" id="ftCriteria3" />
												</div>
											</div>
										</div>
									</div>
								</div>
								<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
							</div>
						</div>
						<!-- Panel 6.4 End  -->
						<!-- Panel 6.5 Start  -->
						<div class="panel" id="funnctionsla2">
							<div class="panel-heading pannelbottom-border">
								<h4 class="panel-title testing-submenu">
									<img src="img/about/Addcopy.png" class="tick-width"> 
									<a data-toggle="collapse" href="#collapseNew" class="headingfont-size heading-margin">Performance Testing</a>
								</h4>
							</div>
							<div id="collapseNew" class="panel-collapse collapse col-md-12 code-coverage">
								<div class="row row-margin">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="col-md-3">
													<label>Select Column:</label>
												</div>
												<div class="col-md-5">
													<div class="form-group col-md-4">
														<form:select path="toolName1" class="form-control" id="toolNameIdPT">
															<option value="None">- Select -</option>
															<option value="LR">LoadRunner</option>
															<option value="NeoLoad">NeoLoad</option>
															<option value="Performance Center">Performance Center</option>
														</form:select>
													</div>
													<div class="form-group col-md-4">
														<select name="performanceTestingDropdown" class="form-control" id="toolColumnIdPT"  onchange="getToolColumnValuesPT();">
															<option value="None">None</option>
															<option value="testScenario">Scenario</option>
															<option value="requirement">Requirement</option>
															<option value="testCase">Test Case</option>
															<option value="testSet">Test Set</option>
															<option value="manualOrAutoFlag">Auto/Manual</option>
															<option value="estManualEff">Manual Effort</option>
															<option value="estAutomateEff">Auto. Effort</option>
															<option value="priority">Priority</option>
															<option value="criticality">Criticality</option>
															<option value="defect">Defect</option>															
														</select>
													</div>
													<div class="form-group col-md-4">
														<select class="form-control"
															id="toolColumnValueIdPT">
															<option value="Select">Select</option>
														</select>
													</div>
												</div>
												<div class="form-group col-md-2">
													<button type="button" class="btn btn-primary" id="fetchTC" onclick="getToolTestCasePT();" >Fetch</button>
												</div>
											</div>
										</div>
									</div>
								</div>

								<div class="row row-margin" style="padding-left: 1%;">
									<div class="col-md-12">
										<div class="form-group">
											<div class="col-md-12">
												<div class="form-group"
													style="padding-left: 5px !important;">
											 		<table id="testCaseTableIdPT">
														<thead>
															<tr>
																<th style="width: 2%; padding-left: 1px; border-bottom: 1pt solid black;">&nbsp;</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Reference</th>
																<th style="width: 12.75%; padding-left: 1px; border-bottom: 1pt solid black;">Scenario</th>
																<th style="width: 13.5%; padding-left: 1px; border-bottom: 1pt solid black;">Test Case</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Test Set</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Auto/Manual</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Manual Effort</th>
																<th style="width: 12%; padding-left: 1px; border-bottom: 1pt solid black;">Est. Auto. Effort</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Priority</th>
																<th style="width: 8%; padding-left: 1px; border-bottom: 1pt solid black;">Criticality</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">Defect</th>
																<th style="width: 10%; padding-left: 1px; border-bottom: 1pt solid black;">TDM Data Exist</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td colspan="9">&nbsp;</td>
																<c:choose>
																	<c:when test="${fn:length(itapConfigDTO.toolSpecificTestCase) > 0}">
																		<c:forEach items="${itapConfigDTO.toolSpecificTestCase}" var="testCaseDO" varStatus="counter">
																			<tr style="height: 15px;">
																				<c:if test="${counter.index<10}">
																					<c:choose>
																						<c:when test="${fn:contains(itapConfigDTO.selectedTestCases, testCaseDO.testCase)}">
																				<td style="width: 2%; padding-left: 1px;">
																				 <input type="checkbox" id="selectedTestCases0${counter.index+1}"
																								name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}" checked="checked"></td>
																						</c:when>
																						<c:otherwise>
																							<td style="width: 2%; padding-left: 1px;">
																							<input type="checkbox" id="selectedTestCases0${counter.index+1}"
																								name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}"></td>
																						</c:otherwise>
																					</c:choose>
																				</c:if>
																				<c:if test="${counter.index>=10}">
																					<c:choose>
																						<c:when test="${fn:contains(itapConfigDTO.selectedTestCases, testCaseDO.testCase)}">
																					<td style="width: 2%; padding-left: 1px;">
																					<input type="checkbox" id="selectedTestCases${counter.index+1}"
																								name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}" checked="checked"></td>
																						</c:when>
																						<c:otherwise>
																							<td style="width: 2%; padding-left: 1px;">
																							<input type="checkbox" id="selectedTestCases${counter.index+1}"
																								name="selectedTestCases[${counter.index}]" value="${testCaseDO.testCase}"></td>
																						</c:otherwise>
																					</c:choose>
																				</c:if>

																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.requirement}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.testScenario}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.testCase}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.manualOrAutoFlag}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.estManualEff}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.estAutomateEff}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.priority}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.criticality}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.defect}</td>
																				<td style="width: 12.75%; padding-left: 1px;">${testCaseDO.tdmDataExist}</td>
																			</tr>
																		</c:forEach>
																	</c:when>
																	<c:otherwise>
																		<tr><td colspan="9" style="align: center;" align='center'><label>No Test Case Selected.</label></td> </tr>
																	</c:otherwise>
																</c:choose>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<img src="img/about/arrowup.png" class="arrow-image" style="margin-left: 1084px" data-toggle="collapse">
							</div>
						</div>
						<!-- Panel 6.5 End -->
					</div>
				</div>
				<!-- Panel 6 End  -->
			</div>
			<!-- Panel Group End  -->

			<!-- popup Start  -->
			<!-- Project popup Start  -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Confirmation</h4>
						</div>
						<div class="modal-body">
							<label> Enter the Project Name : </label> <label class="label-color" style="color: #FF0000"> *</label>
							<form:input path="projName1" id="projName1" onmouseout="saveButtonDisable('projName1')" />
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary " disabled id="saveBtn1">Save</button>
						</div>
					</div>
				</div>
			</div>
			<!-- Project popup End  -->

			<!-- Job popup Start  -->
			<div id="myModal2" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Confirmation</h4>
						</div>
						<div class="modal-body">
							<label> Enter the Job Name : </label> <label class="label-color" style="color: #FF0000"> *</label>
							<form:input path="jobName1" id="jobName1" onmouseout="saveButtonDisable('jobName1')" />
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal" disabled id="saveBtn2">Save</button>
						</div>
					</div>
				</div>
			</div>
			<!-- job popup End  -->
			<!-- popup end  -->
			<!-- button Container Start -->
			<div class="container">
				<div class="row">
					<div id="jobProjectErrorDiv">
						<div>
							<label id="errorLable1"> Project Name can't be empty. !</label>
						</div>
						<div>
							<label id="errorLable2">Job Name can't be empty . !</label>
						</div>
						<div>
							<label id="errorLable3"> Job Name already exists . Please enter different job name . !</label>
						</div>
					</div>
					<div class="col-md-12">
						<div class="col-md-12 col-xs-12 btn-margin pull-right text-right">
							<input type="button" id="saveAndExe" name="saveAndExe" class="btn btn-primary" value="UNRESVETDMDATA" onclick="submitForm('unreserve');" onclick="loadAjax();" /> 
							<input type="button" id="save" name="save" class="btn btn-primary" value="SAVE" onclick="submitForm('save');" onclick="loadAjax();" />
							<input type="button" id="saveAndExe" name="saveAndExe" class="btn btn-primary" value="SAVE & CONTINUE" onclick="submitForm('saveandexe');" onclick="loadAjax();" />
							<button type="button" id="resetButton" onclick="resetCLick()" class="btn btn-primary">RESET</button>
						</div>
					</div>
				</div>
			</div>
			<!-- button Container End -->

			<!-- Env Check Model Start -->
			<div id="envModel" class="modal fade" style="margin: 100px auto 100px;">
				<div class="modal-dialog" style="width: 63%;">
					<div class="modal-content"></div>
				</div>
			</div>
			<div id="envModelAmit" class="modal fade" style="margin: 100px auto 100px;">
				<div class="modal-dialog" style="width: 88%; height: 45%;">
					<div class="modal-content">
						<div style="padding: 0px 14px 0px 10px;">
							<div  class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<a style="color: #1422A1" href="<spring:message code="link.smartfoundry" />" target="_blank">Click Here to see complete details about this Environment</a>
							</div>
							<div class="scrollingX table-responsive">
								<table id="tableSort" class="table table-striped table-bordered" style="font-size: xx-small;">
									<thead id="envHead"> </thead>
									<tbody id="envTbody"> </tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Env Check Model End  -->
		</div>
		<!-- Container End -->
		<form:hidden path="combinedBrowserCombo" id="combinedBrowserComboId" value="" />
		<form:hidden path="toExecuteFlag" id="toExecuteFlagId" value="" />
	</form:form>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
	<script src="js/jquery.js"></script>
	<script src="js/multiselect.js"></script>
	
	<!-- Plugin JavaScript -->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="js/classie.js"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	
	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>
	
	<!-- Custom Theme JavaScript -->
	<script src="js/agency.js"></script>
	
	<!--  configuration js -->
	<script src="js/configuration.js"></script>
</body>
</html>