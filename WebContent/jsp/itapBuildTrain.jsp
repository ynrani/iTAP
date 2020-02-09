<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iTAP | Build Train</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/configuration.css" rel="stylesheet">
<link href="css/multiselect.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		var date = new Date();
		date.setDate(date.getDate());
		$('#dateValueId').datepicker({
			format : 'mm/dd/yyyy',
			startDate : date,
			endDate : "31/12/2050",
			autoclose : true,
			clearBtn : true
		});
	});
</script>

<style type="text/css">
select {
	width: 200px;
	float: left;
}

.controls {
	width: 40px;
	float: left;
	margin: 0px;
}

.controls a {
	background-color: #00A2FE;
	border-radius: 4px;
	border: 2px solid #00A2FE;
	color: #ffffff;
	padding: 2px;
	font-size: 14px;
	text-decoration: none;
	display: inline-block;
	text-align: center;
	margin: 5px;
	width: 20px;
}
</style>

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
					<h1 class="configg-heading label-color headingfont-size">BUILD TRAIN</h1>
				</div>
			</div>
		</div>
	</section>
	<div id="statusDiv" style="display: none" align="center">
	<label id="statusLabelFail"> Job creation failed . Please try after some time !</label> 
	<label id="statusLabelSuccess"> Jobs created successfully !</label>
	</div>
	<form:form id="itapBuildTrainDTOForm" name="itapBuildTrainDTOForm" action="${pageContext.request.contextPath}/itapBuildTrain"
		method="POST" modelAttribute="itapBuildTrainDTO" onSubmit="return selectAll()">

		<div class="container container-margin">
			<div class="panel-group" id="accordion">
				
				<!--  -->
				<form:label path="saveStatus" id="saveStatusLable" style="display:none">${itapBuildTrainDTO.saveStatus}</form:label>
				<input type="hidden" name="serverId" value="1">
				
				<!--  -->
				<div class="panel" id="test3">
					<div id="collapse10" class="panel-collapse">
						<div class="row row-margin">
							<div class="col-md-12">
								<div class="form-group">
									<div class="form-group col-md-6 col-xs-12">
										<label for="envType" class=" col-md-3 control-label">Project Name :</label>
										<div class="col-md-6">
											<form:select path="projName" id="projName" class="form-control">
												<form:option value="">- Select -</form:option>
												<c:forEach items="${itapBuildTrainDTO.allProjs}" var="allProjs">
													<form:option value="${allProjs}">${allProjs}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--  -->
				
				<!--  -->
				<div class="panel" id="test3">
					<div id="collapse10" class="panel-collapse">
						<div class="row row-margin">
							<div class="col-md-12">
								<div class="form-group">
									<div class="form-group col-md-12">
										<label for="envType" class=" col-md-1 control-label">Schedule:</label>
										<div class="col-md-1">
											<form:checkbox path="isToBeScheduled" id="isToBeScheduledId" class="form-control" 
												value="Y" onclick="toggleScheduleInputs();" />
										</div>
										<div class="col-md-3">
											<form:input path="date" id="dateValueId" class="form-control" palceholder="YYYY/MM/DD" 
														disabled="true" maxlength="10" />
										</div>
										<label class="col-md-1 control-label">Hour</label>
										<div class="col-md-2">
											<form:input path="hourToSchedule" id="hourToScheduleId" class="form-control" 
														disabled="true" maxlength="2" />
										</div>
										<label class="col-md-1 control-label">Min</label>
										<div class="col-md-2">
											<form:input path="minutesToSchedule" id="minutesToSchedule" class="form-control"
														 disabled="true" maxlength="2" />
										</div>
									</div>
									<div class="form-group col-md-12">
										<label for="envType" class=" col-md-2 control-label">&nbsp;</label>
										<div class="col-md-10">
											<label>
												<input type="checkbox" name="trackJobs" disabled="disabled" value="trackJobs" 
														id="trackJobs" />Track Jobs 
											</label>
										</div>
									</div>
									<div class="form-group col-md-12">
										<label for="envType" class=" col-md-2 control-label">&nbsp;</label>
										<div class="col-md-2"
											style="width: 10.6667%; padding-left: 12px; padding-right: 12px;">
											<label>
											   <input type="radio" name="runStatus" disabled="disabled" value="onlyOnce"/>OnlyOnce 
											</label>
										</div>
										<div class="col-md-1">
											<label><input type="radio" name="runStatus" value="daily" disabled="disabled"/>Daily
											</label>
										</div>
										<div class="col-md-1" style="width: 10.6667%; padding-left: 12px; padding-right: 12px;">
											<label>
												<input type="radio" disabled="disabled" name="runStatus" value="weekly"/>Weekly
											</label>
										</div>
										<div class="col-md-2">
											<label>
												<input type="radio" disabled="disabled" name="runStatus" value="monthly"/>Monthly 
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--  -->
				
				<!--  -->
				<div class="panel" id="test3">
					<div id="collapse10" class="panel-collapse">
						<div class="row row-margin">
							<div class="col-md-12">
								<div class="form-group">
									<div class="form-group col-md-6 col-xs-12">
										<label for="envType" class=" col-md-3 control-label">Train Name :</label>
										<div class="col-md-6">
											<form:input path="trainName" pattern="\S+" class="form-control borderform" 
												id="trainName" required="required" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--  -->
				
				<!--  -->
				<div class="panel" id="test3">
					<div id="collapse10" class="panel-collapse">
						<div class="row row-margin">
							<div class="col-md-12">
								<div class="form-group">
									<div class="form-group col-md-6 col-xs-12">
										<label for="envType" class=" col-md-3 control-label">Exit on failure :</label>
										<div class="col-md-6">
											<label><form:radiobutton path="trigger"
													value="buildStable" required="required" />Trigger only if
												build is stable</label> <label><form:radiobutton
													path="trigger" value="buildFails" required="required" />Trigger
												even if the build fails</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--  -->
				
				<!--  -->
				<div class="panel" id="test4">
					<div id="collapse11" class="panel-collapse">
						<div class="row row-margin">
							<div class="col-md-12">
								<div class="form-group">
									<div class="col-md-12 col-xs-12" style="padding: 0px 0px 0px 0px;">
										<div class="col-md-6" style="padding: 0px 0px 0px 0px;">
											<div class="form-group col-md-9">
												<label for="envType" class=" col-md-9 control-label">Available Tasks :</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group col-md-9">
												<label for="envType" class=" col-md-9 control-label">Selected Tasks :</label>
											</div>
										</div>
									</div>
									<div class="col-md-12 col-xs-12" style="padding: 0px 0px 0px 0px;">
										<div class="col-md-5" style="padding: 0px 0px 0px 0px;">
											<div class="col-md-12">
												<div class="form-group col-md-12">
													<form:select path="jobsAct" class="form-control borderform config-hostname"
														multiple="true" id="jobsAct" style="height: 195px;">
													</form:select>
												</div>
											</div>
										</div>
										<div class="col-md-1">
											<div class="col-md-1">
												<div class="form-group col-md-1 controls">
													<a href="javascript:moveSelected('jobsAct', 'jobsSel')">&gt;</a>
													<a href="javascript:moveSelected('jobsSel', 'jobsAct')">&lt;</a>
												</div>
											</div>
										</div>
										<div class="col-md-5">
											<div class="col-md-12">
												<div class="form-group col-md-12">
													<form:select path="jobsSel"
														class="form-control borderform config-hostname"
														multiple="true" id="jobsSel" required="required"
														pattern=".{2,}" title="2 Jobs Minimum to build train"
														style="height: 195px;">
													</form:select>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--  -->

			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-12 col-xs-12 btn-margin pull-right text-right">
						<input type="submit" id="exec" name="exec" class="btn btn-primary"
							value="EXECUTE" />
					</div>
				</div>
			</div>
		</div>

	</form:form>

	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>

	<script src="js/jquery.js"></script>
	<script src="js/multiselect.js"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>

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
		function toggleScheduleInputs() {
			var checkBoxValue = document.getElementById("isToBeScheduledId").checked;
			if (checkBoxValue) {
				document.getElementById("dateValueId").disabled = false;
				document.getElementById("hourToScheduleId").disabled = false;
				document.getElementById("minutesToSchedule").disabled = false;

				document.getElementById("trackJobs").disabled = false;
				document.getElementsByName("runStatus")[0].disabled = false;
				document.getElementsByName("runStatus")[1].disabled = false;
				document.getElementsByName("runStatus")[2].disabled = false;
				document.getElementsByName("runStatus")[3].disabled = false;
			} else {
				document.getElementById("dateValueId").disabled = true;
				document.getElementById("hourToScheduleId").disabled = true;
				document.getElementById("minutesToSchedule").disabled = true;

				document.getElementById("trackJobs").disabled = true;
				document.getElementsByName("runStatus")[0].disabled = true;
				document.getElementsByName("runStatus")[1].disabled = true;
				document.getElementsByName("runStatus")[2].disabled = true;
				document.getElementsByName("runStatus")[3].disabled = true;
			}
		}

		$(document).ready(function() {
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
		});
		
		function checkboxCheck() {
			if (document.getElementById("#sourceconfigId").checked) {
				alert("hello");
			}
		}

		function moveAll(from, to) {
			$('#' + from + ' option').remove().appendTo('#' + to);
		}

		function moveSelected(from, to) {
			$('#' + from + ' option:selected').remove().appendTo('#' + to);
		}
		function selectAll() {
			$("select option").attr("selected", "selected");
		}

		function alljobs() {
			var selectedValue = "Cyclos";
			var servletUrl = 'configurationAllJobs?serId=1&projName=' + selectedValue;
			loadAjax();
			$.getJSON(servletUrl, function(options) {
				var provSpec = $('#jobsAct');
				$('>option', provSpec).remove(); // Clean old options first.
				$("#ajaxloader").hide();
				if (options) {
					$.each(options, function(value, value) {
						provSpec.append($('<option/>').val(value).text(value));
					});
				} else {
					provSpec.append($('<option/>')
							.text("Please select Project"));
				}
			});
		}

		$(document).ready(function() {
			$('#projName').change(function() {
				var selectedValue = $(this).val();
				var servletUrl = 'configurationAllJobs?serId=1&projName='+ selectedValue;loadAjax();
				$.getJSON(servletUrl,function(options) {
					var provSpec = $('#jobsAct');
					$('>option',provSpec).remove(); // Clean old options first.
					$("#ajaxloader").hide();
					if (options) {
						$.each(options,function(value,value) {
							provSpec.append($('<option/>').val(value).text(value));
						});
					} else {
						provSpec.append($('<option/>').text("Please select Project"));
					}
				});
			});
		});

		$(document).ready(function() {
			$("#ajaxloader").hide();
			var saveStatus = $("#saveStatusLable")[0].innerText;
			if (saveStatus != null) {
				saveStatus = saveStatus.trim();
			}
			localStorage.setItem("saveStatus", null);
			if (saveStatus == "null" || saveStatus == "") {
			} else if (saveStatus == "success") {
				$("#statusLabelSuccess").css({
					"color" : "#00CC66"
				});
				$("#statusLabelFail").hide();
				$("#statusLabelSuccess").show();
				$("#statusDiv").show();

			} else {
				$("#statusLabelFail").css({
					"color" : "#FF0000"
				});
				$("#statusLabelSuccess").hide();
				$("#statusLabelFail").show();
				$("#statusDiv").show();
			}
		});
	</script>
</body>
</html>