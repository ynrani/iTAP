<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iTAP | Defects</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/defectsFinal.css" rel="stylesheet">
<link href="css/multiselect.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css">

</head>
<body>
	<header>
		<nav class="navbar navbar-default navbar-fixed-top ">
			<jsp:include page="header.jsp"></jsp:include>
			<!-- /.container-fluid -->
		</nav>
	</header>
	<section id="services" class="bg-color">
		<div class="container" style="margin-bottom: -83px;">
			<div class="row">
				<div class="col-md-12">
					<h1 class="configg-heading label-color headingfont-size">DEFECTS</h1>
				</div>
			</div>
		</div>
	</section>
	
	<form:form id="itapDefectFormId" name="itapDefectFormName" action="${pageContext.request.contextPath}/raiseDefect" 
		method="post" modelAttribute="itapDefectForm" commandName='itapDefectForm'>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<div class="container container-margin">
			<div class="panel-group" id="accordion">
				<c:forEach var="toolDefects" items="${itapDefectForm.toolDefectsList}" varStatus="toolDefectsCount">
					<div class="panel">
						<div class="panel-heading pannelbottom-border">
							<h4 class="panel-title">
								<div>
									<div class="header bagroundImage" data-toggle="collapse" href='#${toolDefects.toolName}'></div>
									<div class="sideHeadingText">
										<a class="headingfont-size heading-margin">${toolDefects.toolName}</a>
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].toolName" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].projectName" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].releaseNo" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].demandStory" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].host" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].browser" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].iteration" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].environment" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].operatingSystem" />
										<form:hidden path="toolDefectsList[${toolDefectsCount.index}].user" />
									</div>
								</div>
							</h4>
						</div>
						<div id='${toolDefects.toolName}' class="panel-collapse collapse border-color">
							<div class="panel" id="test2">
								<div class="panel-heading pannelbottom-border">
									<h4 class="panel-title testing-submenu">
										<div>
											<div class="plusToggle PlusImageToggle" data-toggle="collapse"
												href="#${toolDefects.toolName}_ALMMAPPING"></div>
											<div class="sideHeadingText">
												<a class="headingfont-size heading-margin">ALM MAPPING</a>
											</div>
										</div>
									</h4>
								</div>	
								<div id='${toolDefects.toolName}_ALMMAPPING' class="panel-collapse collapse">&nbsp;&nbsp;
									<div class="row">
										<form class="form-horizontalcol-md-12 env-margin">
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Release:</label>
												<div class="col-md-3">
													<form:input
														path="toolDefectsList[${toolDefectsCount.index}].releaseNo"
														value="${toolDefects.releaseNo}" class="form-control borderform" />
												</div>
												<label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">
													Iteration:
												</label>
												<div class="col-md-3">
													<form:input path="toolDefectsList[${toolDefectsCount.index}].demandStory"
														value="${toolDefects.demandStory}" class="form-control borderform" />
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Demand Story No:</label>
												<div class="col-md-3">
												<form:input path="toolDefectsList[${toolDefectsCount.index}].host"
														value="${toolDefects.host}" class="form-control borderform" />
												</div>
												<label for="inputPassword3"
													class="control-label col-md-2 col-md-offset-1">Enviorment:</label>
												<div class="col-md-3">
												<form:input path="toolDefectsList[${toolDefectsCount.index}].browser"
														value="${toolDefects.browser}" class="form-control borderform" />
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Host:</label>
												<div class="col-md-3">
												<form:input
														path="toolDefectsList[${toolDefectsCount.index}].iteration"
														value="${toolDefects.iteration}" class="form-control borderform" />
												</div>
												<label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">
													Operating System:
												</label>
												<div class="col-md-3">
												<form:input path="toolDefectsList[${toolDefectsCount.index}].environment"
														value="${toolDefects.environment}" class="form-control borderform" />
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Browser:</label>
												<div class="col-md-3">
												<form:input path="toolDefectsList[${toolDefectsCount.index}].operatingSystem"
														value="${toolDefects.operatingSystem}" class="form-control borderform" />
												</div>
												<label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">
													User:
												</label>
												<div class="col-md-3">
												<form:input path="toolDefectsList[${toolDefectsCount.index}].user" 
														value="${toolDefects.user}" class="form-control borderform" />
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Defect root cause:</label>
												<div class="col-md-3">
													<select class="form-control borderform" >
													  <option>System Failure</option>
													  <option>Test Data Issue</option>
													  <option>Network Connectivity Error</option>
													  <option>DB Connection Error</option>
													</select>
												</div>
									 		</div>
										</form>
									</div>
								</div>	
							</div>

							<c:forEach var="indivudualDefects" items="${toolDefects.defectsList}" varStatus="indivudualDefectsCount">
								<form:hidden path="toolDefectsList[${toolDefectsCount.index}].defectsList[${indivudualDefectsCount.index}].toolName" />
								<form:hidden path="toolDefectsList[${toolDefectsCount.index}].defectsList[${indivudualDefectsCount.index}].projectName" />
								<form:hidden path="toolDefectsList[${toolDefectsCount.index}].defectsList[${indivudualDefectsCount.index}].defectReportXmlName" />
								<form:hidden path="toolDefectsList[${toolDefectsCount.index}].defectsList[${indivudualDefectsCount.index}].testCaseName" />
								<form:hidden path="toolDefectsList[${toolDefectsCount.index}].defectsList[${indivudualDefectsCount.index}].testCaseNumber" />
								<div class="panel" id="test2">
									<div class="panel-heading pannelbottom-border">
										<h4 class="panel-title testing-submenu">
											<div>
												<div class="plusToggle PlusImageToggle" data-toggle="collapse"
													href="#${toolDefects.toolName}_${indivudualDefectsCount.index}"></div>
												<div class="sideHeadingText">
													<a class="headingfont-size heading-margin">${indivudualDefects.testCaseName}</a>
												</div>
											</div>
										</h4>
									</div>
									<div id='${toolDefects.toolName}_${indivudualDefectsCount.index}' class="panel-collapse collapse">&nbsp;&nbsp;
										<div class="row">
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Approved:</label>
												<div class="col-md-3">
													<form:select
														path="toolDefectsList[${toolDefectsCount.index}].defectsList[${indivudualDefectsCount.index}].isApproved"
														value="${indivudualDefects.isApproved}" class="form-control borderform">
														<form:option value="N" label="Don't Log Defect" />
														<form:option value="Y" label="Log Defect" />
													</form:select>
												</div>
												<label for="inputPassword3"
													class="control-label col-md-2 col-md-offset-1">TC_Exec_Status:</label>
												<div class="col-md-3">
													<label for="inputPassword3" class="">${indivudualDefects.testCaseStatus}</label>
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Bug Issue Report:</label>
												<div class="col-md-3">
													<label for="inputPassword3" class="">${indivudualDefects.logDefect}</label>
												</div>
												<label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Tc-Step_Number:</label>
												<div class="col-md-3">
													<form:hidden
														path="toolDefectsList[${toolDefectsCount.index}].defectsList[${indivudualDefectsCount.index}].testCaseStepNumber" />
													<label for="inputPassword3" class="">${indivudualDefects.testCaseStepNumber}</label>
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Tc-Step_Description:</label>
												<div class="col-md-3">
													<label for="inputPassword3" class="">${indivudualDefects.testCaseStepDescription}</label>
												</div>
												<label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Expected_Details:</label>
												<div class="col-md-3">
													<label for="inputPassword3" class="">${indivudualDefects.expectedResults}</label>
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Step_Result:</label>
												<div class="col-md-3">
													<label for="inputPassword3" class="">${indivudualDefects.stepResult}</label>
												</div>
												<label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Step_Screenshot_Filepath:</label>
												<div class="col-md-3">
													<label for="inputPassword3">${indivudualDefects.stepScreenshotPath}</label>
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Actual_Details:</label>
												<div class="col-md-9">
													<label for="inputPassword3" class="">${indivudualDefects.actualResults}</label>
												</div>
											</div>
											<div class="form-group col-md-12 col-xs-12">
												<label for="inputPassword3" class="control-label col-md-3">Step_Exception_Mslog:</label>
												<div class="col-md-9">
													<label for="inputPassword3">${indivudualDefects.stepExceptionLog}</label>
												</div>
											</div>
										</div>
										 
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</form:form>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-6 col-xs-12 col-md-push-9 btn-margin">
					<button type="button" class="btn btn-primary btn-width">RESET</button>
				</div>
				<div class="col-md-6 col-xs-12 col-md-push-4 btn-margin">
					<input type="button" onclick="submitLogDefectForm();" name="SUBMIT" value="submit" id="submit" class="btn btn-primary btn-width">
				</div>
			</div>
		</div>
	</div>

	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Confirmation</h4>
				</div>
				<div class="modal-body">
					<label> Enter the Project Name</label> <input type="text"
						id="modalInput">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="saveBtn">Save</button>
				</div>
			</div>
		</div>
	</div>

	<div id="myModal2" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Confirmation</h4>
				</div>
				<div class="modal-body">
					<label> Enter the Job Name</label> <input type="text" id="modalInput">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="saveBtn">Save</button>
				</div>
			</div>
		</div>
	</div>

	<c:if test="${fn:length(loggedDefectList) gt 0}" >
		<div id="myModal5" class="modal fade" >
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Confirmation</h4>
					</div>
					<div class="modal-body" style="height:500px;width:750px;position:fixed;top: 50%;left: 50%;">
						<label> Raised Defect Details</label>	
						<c:forEach items="${loggedDefectList}" var="defectObj" >
							<p>${defectObj.projectName}</p>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="onsub();" id="bbb">Close</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	
 	<footer>
 		<jsp:include page="footer.jsp"></jsp:include>
     </footer>
     
	<script src="js/jquery.js"></script>
	<script src="js/multiselect.js"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="js/classie.js"></script>
	<script src="js/cbpAnimatedHeader.js"></script>

	<!-- Contact Form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/agency.js"></script>
	<script type="text/javascript">
		function submitLogDefectForm() {
			document.getElementById("itapDefectFormId").submit(); //$("#myModal5").modal('show');
		}

		function onsub() {
			document.getElementById("myModal5").style.display = "none"; //window.location = './itapProgress?serId=1';
		}

		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
			$('#drolist').multiselect({
				nonSelectedText : '--Select any ScriptList--'
			});
			
			$("#plusClick").click(function() {
				$("#modalInput").val("");
				$("#myModal").modal('show');
			});
			
			$("#plusClick2").click(function() {
				$("#modalInput").val("");
				$("#myModal2").modal('show');
			});
			
			$("#saveBtn").click(function() {
				alert($("#modalInput").val());
			});
			
			$('.testingToggle').click(function() {
				event.stopPropagation();
				$("#funnctionsla").toggle();
				$("#test2").toggle();
			});

			$('#saveBtn').click(function() {
				window.location = 'itapTesting.html'
			});

			$('#saveConfigurationBtn').click(function() {
				alert("Configuration Saved");
				window.location = 'index.html'
			});

			$('input,textarea').keypress(function(event) {
				var currentID = "#" + this.id;
				console.log(currentID);
				$(currentID).next().show();
			});

			$('input,textarea').focusout(function(event) {
				var currentID = "#" + this.id;
				console.log(currentID);
				$(currentID).next().hide();
			});
		});
		
		function checkboxCheck() {
			if (document.getElementById("#sourceconfigId").checked) {
				alert("hello");
			}
		}

		$(function() {
			$('.header').click(function() {
				$(this).closest('.bagroundImage').toggleClass('arrowdown');
			});
		});

		$(function() {
			$('.plusToggle').click( function() {
				$(this).closest('.PlusImageToggle').toggleClass('minusImageToggle');
			});
		});
		
		$(document).ready(function() {
			$("#ajaxloader").hide();
		});
		
	</script>
</body>
</html>