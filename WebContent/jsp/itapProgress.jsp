<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>iTAP | Progress</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/itapTesting.css" rel="stylesheet">

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

	<section class="upperDiv">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-xs-12 col-s-12">
					<div class="col-md-7 col-xs-6 col-md-push-2"><h2 class="heading">AUTOHUB CONTINUOUS TEST MODULE</h2></div>
					<div class="col-md-5 col-xs-6  text-right"><img src="img/about/Graph36px.png" onclick="showIframe();" class="toggleImage"></div>
				</div>
			</div>
			 <div class="row fame-top" style="margin-top: 10px;"
				id="iframeContent">
				<div class="col-md-12 col-xs-12 col-s-12 imgg">
					<iframe src="<spring:message code="link.live.itap.progress1"/>"
						width="100%" height="700px" scrolling="yes" style="border: 1px solid grey;"></iframe>
				</div>
				<div class="col-md-12  text-right">
					<span class="logDefects" id="executeBtn"> <a href="./fetchDefect"> View log Defects</a></span>
				</div>
			</div>
			<div class="row fame-top" style="margin-top: 10px; display: none"
				id="iframeContentProgress">
				<div class="col-md-12 col-xs-12 col-s-12 imgg">
					<iframe src="<spring:message code="link.live.itap.progress1" />"
						width="100%" height="700px" scrolling="yes" style="border: 1px solid grey;"></iframe>
				</div>
			</div> 
		</div>
	</section>
 
	 <form:form id="itapProgressForm" name="itapProgressForm" action="${pageContext.request.contextPath}/itapProgress"	method="post" modelAttribute="itapProgressDTO">
	 
	 	<section class="section-padding">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
				 		<div class="form-group col-md-6 col-xs-12">
                            <label for="envType" class=" col-md-3 control-label">Project Name :</label>
                            <div class="col-md-6">
                               <form:select path="projName" id="projName" class="form-control">
								<form:option value="">- Select -</form:option>
								<c:forEach items="${itapProgressDTO.allProjs}" var="allProjs">
				    			    <form:option value="${allProjs}">${allProjs}</form:option>
							    </c:forEach>
							</form:select>
                            </div>
                        </div> 
	 				</div>
				</div>
			</div>
		</section>
 		
 		<section class="section-padding">
	 	<div class="row" style="margin-bottom: 20px">
			<div class="col-md-12 col-md-offset-5 col-xs-8 col-xs-offset-4"><h3>TEST PROGRESS</h3></div>
			<div style="display: none" id="mobilePreview">
				<div class="form-group show col-md-12 col-xs-10 col-xs-offset-4"></div>
			</div>
		</div>
 		</section>
 		
		<section class="section-padding">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-3 col-xs-12 col-s-12" id="jobs">
							<form:select path="allJobs" class="form-control borderform config-hostname"  multiple="true" id="allJobs"  style="height: 195px;">
							 </form:select>
						</div>
	 					<div class="col-md-8 col-xs-12 col-s-12 col-md-offset-1" id="bdd">
							<div class="table-responsive">
								 <table class="table table-condensed table-striped table-bordered table-hover no-margin" id="jobDetails"></table>
							</div>
						</div>
						
						<div class="col-md-8 col-xs-12 col-s-12 col-md-offset-1" id="console">
							<div class="table-responsive">
								 <table class="table table-condensed table-striped table-bordered table-hover no-margin" id="consoleText"></table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		<section class="section-padding">
		 	<div class="row" style="margin-bottom: 20px">
				<div style="display: none" id="mobilePreview">
					<div class="form-group show col-md-12 col-xs-10 col-xs-offset-4"></div>
				</div>
			</div>
 		</section>

	</form:form>	
	
		<div id="junitModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"></button>
					<h4 class="modal-title">Junit Execution Status</h4>
				</div>
				<div class="modal-body">
					<div class="table-responsive" id="junitModalContentDiv">
						
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
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
		$(document).ready(function() {
			function onHover() {
				$("#progressImage").attr('src', "img/about/Progress1.png");
			}
			function offHover() {
				$("#progressImage").attr('src', "img/about/Progress.png");
			}
		});

		function showIframe() {
			$("#iframeContent").slideToggle("fast");
		}

		function showIframeProgress() {
			$("#iframeContentProgress").slideToggle("slow");
		}
		
		function optikClick() { // document.getElementById("unitTesting").style.color="blue";
			$("#optik").show();
			$("#bdd").hide();
		};
		 
		$(window).resize(function() {
			if ($(window).width() <= 320 || $(window).width() <= 768) {
				$(".sidebarr").hide();
				$("#mobilePreview").css("display", "block");
			}
			if ($(window).width() <= 768) {
				$(".sidebarr").hide();
				$("#mobilePreview").css("display", "block");
			}
			if ($(window).width() >= 1024) {
				$(".sidebarr").show();
				$("#mobilePreview").css("display", "none");
			}
		});
	
  /*   	  function loadJobs(jobName){
  		 	var baseUrl='${jenkinsUrl}/job/'+jobName+'/';
      	 	var totalBuils=0;
      	 	$.ajax({
        	         url: baseUrl +'/api/json',
        	    	 data: 'lastBuild?tree=builds[number,url]&jsonp=callBack',
        	         jsonpCallback: "callBack",
        			 contentType: 'application/json; charset=utf-8',
        	         dataType: 'jsonp',
        			 success: function (data) {
        	 		 if(data == "") {
        	 			console.log('No Data');
        				} else {
        	 				totalBuils = data.builds[0].number;
        	 				loadAllJobs(totalBuils,jobName);			 
        			   }
        			 },
        	       });
      		} */
    	  
    	   function loadJobs(jobName){
    		  loadAjax();
    		 	var baseUrl='${jenkinsUrl}/job/'+jobName+'/';
        	 	var totalBuils=0;
        	 	$.ajax({
          	         url: baseUrl +'/api/json',
          	    	 data: 'lastBuild?tree=builds[number,url]&jsonp=callBack',
          	         jsonpCallback: "callBack",
          			 contentType: 'application/json; charset=utf-8',
          	         dataType: 'jsonp',
          			 success: function (data) {
	          			 $("#ajaxloader").hide();
	          	 		 if(data == "") {
	          	 		 	console.log('No Data');
	          			 } 
	          	 		 else {
	          				console.log(data);
	          			 }
          			 },
          	       });
        		}
		 
  		function loadAllJobs(totalBuils,jobName){
   			loadAjax();
  	 	  	var baseUrl='${jenkinsUrl}/job/'+jobName+'/';
    	 	var totalBuils=1;
 			
			if (0 < totalBuils) {
				var viewHtmlData1 = "";
				var viewHtmlData = "<table class='table table-condensed table-striped table-bordered table-hover no-margin' ><thead>";
				viewHtmlData += "	<tr>";
				viewHtmlData += "		<th>#</th>";
				viewHtmlData += "		<th>Job Name</th>";
				viewHtmlData += "		<th>Status</th>";
				viewHtmlData += "		<th>Time</th>";
				viewHtmlData += "		<th>Duriation</th>";
				viewHtmlData += "		<th>Console Log</th>";				
				viewHtmlData += "	</tr></thead><tbody>";
				var buldNo = 1;
				for ( var i = 0; i < totalBuils; i++) {
					if (1 == buldNo) {
						buldNo = totalBuils;
					}
					$.ajax({
						url : baseUrl + buldNo + '/api/json',
						data : 'jsonp=callBack',
						jsonpCallback : "callBack",
						contentType : 'application/json; charset=utf-8',
						dataType : 'jsonp',
						success : function(data) {
							$("#ajaxloader").hide();
							if (data == "") {
								alert('No Data');
							} else {
								var myObject = data;
								
								viewHtmlData1 += "<tr>";
								viewHtmlData1 += "<td class=''>"+ (i + 1) + "</td>";
								viewHtmlData1 += "<td class=''><a href='"+myObject.url+"'>" + myObject.fullDisplayName + "</a></td>";
								viewHtmlData1 += "<td class=''>" + myObject.result + "</td>";
								viewHtmlData1 += "<td class=''>"+ getTime(myObject.timestamp)+ "</td>";
								viewHtmlData1 += "<td class=''>"+ msToTime(myObject.duration)+ "</td>";
								viewHtmlData1 += "<td class=''><a href='' onclick='loadConsole('"+myObject.fullDisplayName+"','"+myObject.number+"');'>" + View + "</a></td>";
								viewHtmlData1 += "</tr>";
							}
						},
					});
					buldNo--;
				}
				viewHtmlData += viewHtmlData1+"</tbody></table>";
				document.getElementById('jobDetails').innerHTML = viewHtmlData;s
				console.log(viewHtmlData);
			}
		}

		function getTime(ms) {
			return new Date(ms).toDateString();
		}

		function msToTime(ms) {
			var seconds = (ms / 1000);
			var minutes = parseInt(seconds / 60, 10);
			seconds = seconds % 60;
			minutes = minutes % 60;
			if (0 == minutes) {
				return seconds.toFixed(0) + ' sec';
			} else {
				return minutes + ' min ' + seconds.toFixed(0) + ' sec';
			}
		}

		/* $(document).ready(function() {
		    $('#projName').change(function() {
		        var selectedValue = $(this).val();
		        var servletUrl = 'configurationAllJobs?serId=1&projName=' + selectedValue;
		        var jobsFromJenkins = '';
		        $.getJSON(servletUrl, function(jobs) {
		             var jobsUl = $('#jobs');
		            $('>span', jobsUl).remove(); // Clean old options first.
		            $('>li', jobsUl).remove();
		            if (jobs) {
		                 $.each(jobs, function(value, value) {
		                	  jobsFromJenkins += '<li class="col-xs-12 aside-list asider-border aside-list-top listStyle" id="'+value
		                	 					+' "><span class="list-cursorStyle scroll-span">' + value + '</span></li>';
		                	 			console.log(jobsFromJenkins);
		                	//	$("#jobs").append($("<option></option>").val(value).html(value));
		                });
		        	 $('#jobs').append(jobsFromJenkins);
		            }
		        });
		        loadJobs('1_Cyclos_Code_Checkout');
		    });
		}); */

		$(document).ready(function() {
			$('#projName') .change( function() {
						loadAjax();
						var selectedValue = $(this) .val();
						var servletUrl = 'configurationAllJobs?serId=1&projName=' + selectedValue;
						$.getJSON(servletUrl, function(options) {
								var provSpec = $('#allJobs');
								$('>option',provSpec).remove(); // Clean old options first.
								$("#ajaxloader").hide();
								if (options) {
									$.each(options,function(value,value) {
										provSpec.append($('<option/>').val(value).text(value));
									});
								} else {
									provSpec.append($('<option/>').text("Please select Job"));
								}
							});
					});
		});

		$('#allJobs').click(function(event) {
			loadJobsFromServer($(this).val());
		});
		
		function loadJobsFromServer(jobName){
			loadAjax();
  		 	$.ajax({
  		 			url:"itapGetLast5Builds?serId=1&job="+jobName,
	            	type:'GET',
	            	dataType: 'json',
	            	success: function(data) {
	            		$("#ajaxloader").hide();
	            		var viewHtmlData = "<table class='table table-condensed table-striped table-bordered table-hover no-margin' ><thead>";
      					viewHtmlData += "	<tr>";
      					viewHtmlData += "		<th>#</th>";
      					viewHtmlData += "		<th>Job Name</th>";
      					viewHtmlData += "		<th>Status</th>";
      					viewHtmlData += "		<th>Time</th>";
      					viewHtmlData += "		<th>Duration</th>";
      					viewHtmlData += "		<th>Console Log</th>";
      					viewHtmlData += "		<th>Junit Log</th>";
      					viewHtmlData += "	</tr></thead><tbody>";	
      					
        			if(data == "") {
        	 			console.log('No Data');
        	 			viewHtmlData += "	<tr>No Records Found</tr>";	
      					viewHtmlData += "</tbody></table>";
      					document.getElementById('jobDetails').innerHTML = viewHtmlData;
        				} else {
        				 
          					for ( var i = 0; i < data.length; i++) {
								var myObject = data;
								var jobName = myObject[i].jobName;
								var len = jobName.length;
								jobName = jobName.substring(0, len - 3);
								jobName = jobName + "";
								var jobNo = myObject[i].jobNo;
								jobNo = jobNo.substring(1, jobNo.length);
								jobNo = jobNo + "";
								viewHtmlData += "<tr>";
								viewHtmlData += "<td class=''>"+ myObject[i].jobNo + "</td>";
								viewHtmlData += "<td class=''>" + myObject[i].jobName + "</td>";
								viewHtmlData += "<td class=''>" + myObject[i].jobSts + "</td>";
								viewHtmlData += "<td class=''>"+ myObject[i].jobTime+ "</td>";
								viewHtmlData += "<td class=''>"+ myObject[i].jobDuri+ "</td>";
						 		viewHtmlData += "<td class=''><a href='"+ myObject[i].jobConsoleUrl+"' target='_NEW'> View </a></td>";
						 		viewHtmlData += '<td class=""> <button type="button"   onclick="getJunitForBuild('
									+ "'"
									+ jobName
									+ "'"
									+ ','
									+ "'"
									+ jobNo
									+ "'"
									+ ');"> View </button></td>';
								viewHtmlData += "</tr>";
          					}
          					viewHtmlData += "</tbody></table>";
          					document.getElementById('jobDetails').innerHTML = viewHtmlData;
          		   	  }
        		    },
        	    });
      		}
		 	
			$('#executeBtn').click(function() {
				//window.location = './fetchDefect';
			});
		 
			$(document).ready(function() {
				$("#ajaxloader").hide();
				$('#junitModal').modal('hide');
			} );
			function getJunitForBuild(jobName, buildNo) {
				var jenkinUrl = '${jenkinsUrl}/job/' + jobName + '/' + buildNo;
				var serverUrl = '${pageContext.request.contextPath}'
						+ "/junitReport";
				$.ajax({
					type : "GET",
					dataType : 'text',
					url : serverUrl,
					data : {
						'jenkinUrl' : jenkinUrl
					},
					async : false,
					success : function(data) {
						if (data =="no job found") {
						var	viewHtmlData = '<h4><span class="label label-danger">!! Some  issue  is there . May be job is not abvailble with jenkins server.  </span></h4>';
							
							document.getElementById('junitModalContentDiv').innerHTML = viewHtmlData;
							$('#junitModal').modal('show')
						} else {
							var obj = JSON.parse(data);
							
							var testSuiteStatus=obj.hasOwnProperty("testResult");
							createBodyForJunitDetailsTable(obj.testResult,testSuiteStatus)
							$('#junitModal').modal('show')
						}
					}
				});

			}
			function createBodyForJunitDetailsTable(testJsonObj,testSuiteStatus) {
				var viewHtmlData="";
			if(testSuiteStatus)
				{
				 viewHtmlData+= "<table class='table table-condensed table-striped table-bordered table-hover no-margin' ><thead>";
				viewHtmlData += "	<tr>";
				viewHtmlData += "		<th>Pass Count</th>";
				viewHtmlData += "		<th>Fail Count</th>";
				viewHtmlData += "		<th>Skip Count</th>";
				viewHtmlData += "		<th>Status</th>";
				viewHtmlData += "	</tr></thead><tbody>";
				 viewHtmlData += "<tr>";
					viewHtmlData += "<td class='text-success'>"
						+ testJsonObj["passCount"] + "</td>";
				viewHtmlData += "<td class='text-danger'>"
						+ testJsonObj["failCount"] + "</td>";
		
				viewHtmlData += "<td class='text-warning'>"
						+ testJsonObj["skipCount"] + "</td>";
				viewHtmlData += "<td class='text-info'>"
						+ calculatePercentage(testJsonObj["passCount"],
								testJsonObj["failCount"], testJsonObj["skipCount"])
						+ "% </td>";

				viewHtmlData += "	</tr></tbody></table>";
				}
			else{
				viewHtmlData += '<h4><span class="label label-warning">!! No Test Records found for  this build </span></h4>';
					
			}
				document.getElementById('junitModalContentDiv').innerHTML = viewHtmlData;
			}
			function calculatePercentage(passCount, failCount, skipCount) {
				var passPercentage = ((passCount / (passCount + failCount + skipCount)) * 100);

				return passPercentage;

			}
	</script>
</body>
</html>