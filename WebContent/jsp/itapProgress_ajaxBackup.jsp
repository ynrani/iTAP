<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>
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
<body onload="loadJobs('1_Cyclos_Code_Checkout');">
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
					<div class="col-md-7 col-xs-6 col-md-push-2">
						<h2 class="heading">AUTOHUB CONTIONOUS TEST MODULE</h2>
					</div>
					<div class="col-md-5 col-xs-6  text-right">
						<img src="img/about/Graph36px.png" onclick="showIframe();" class="toggleImage">
					</div>
				</div>
			</div>
			 <div class="row fame-top" style="margin-top: 10px;"
				id="iframeContent">
				<div class="col-md-12 col-xs-12 col-s-12 imgg">
					<iframe src="http://in-pnq-coe05/QvAJAXZfc/opendoc.htm?document=TMCC%20V4.0.qvw&host=QVS%40in-pnq-coe05"
						width="100%" height="600px" scrolling="yes" style="border: 1px solid grey;"></iframe>
				</div>
				<div class="col-md-12  text-right">
					<span class="logDefects" id="executeBtn"> View log Defects</span>
				</div>
			</div>
			<div class="row fame-top" style="margin-top: 10px; display: none"
				id="iframeContentProgress">
				<div class="col-md-12 col-xs-12 col-s-12 imgg">
					<iframe src="http://in-pnq-coe05/QvAJAXZfc/opendoc.htm?document=Jenkins.qvw&host=QVS%40in-pnq-coe05"
						width="100%" height="600px" scrolling="yes" style="border: 1px solid grey;"></iframe>
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
	 	<div class="row" style="margin-bottom: 20px">
			<div class="col-md-12 col-md-offset-5 col-xs-8 col-xs-offset-4"><h3>TEST PROGRESS</h3></div>
		 	<div style="display: none" id="mobilePreview">
				<div class="form-group show col-md-12 col-xs-10 col-xs-offset-4"></div>
			</div>
		</div>
		<section class="section-padding">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-3 col-xs-12 col-s-12 sidebar-text sidebarr">
							<ul class="aside-ul" id="jobs"></ul>
						</div>
	 					<div class="col-md-8 col-xs-12 col-s-12 col-md-offset-1" id="bdd">
							<div class="table-responsive">
								 <table class="table table-condensed table-striped table-bordered table-hover no-margin" id="jobDetails"></table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form:form>	

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
		
		$('li').click(function(e) {
			e.preventDefault();
			var currentID = $(this);
			currentID.parent().find('li').removeClass('active');
			currentID.addClass('active');
		});

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

		function loadJobs(jobName){
			jobName ="1_Cyclos_Code_Checkout";
    		var baseUrl='http://in-pnq-coe30:9090/jenkins/job/1_Cyclos_Code_Checkout/';
    	 	var totalBuils=0;
    	 	
    	 	$.ajax({
      	         url: baseUrl +'/api/json',
      	    	 data: 'lastStableBuild?tree=builds[number,url]&jsonp=callBack',
      	         jsonpCallback: "callBack",
      			 contentType: 'application/json; charset=utf-8',
      	         dataType: 'jsonp',
      			 success: function (data) {
      	 		 if(data == "") {
      					alert('No Data');
      				} 
      	 		 else {
      	 				totalBuils = data.builds[0].number;
      	 				console.log(totalBuils);
      	 				
      	 				if(0 < totalBuils){
      	 				var viewHtmlData = "<table class='table table-condensed table-striped table-bordered table-hover no-margin' ><thead>";
      					viewHtmlData +="	<tr>";
      					viewHtmlData +="		<th>#</th>";
      					viewHtmlData +="		<th>Job Name</th>";
      					viewHtmlData +="		<th>Status</th>";
      					viewHtmlData +="		<th>Time</th>";
      					viewHtmlData +="		<th>Duriation</th>";
      					viewHtmlData +="	</tr></thead><tbody>";
      					var buldNo= 1; 
      		    		for(var i=0;i< totalBuils;i++) {
      		    			if(1 == buldNo){
      		    				buldNo=totalBuils;
      		    			}
      		    			$.ajax({
      		       	         url: baseUrl+buldNo+ '/api/json',
      		       	    	 data: 'jsonp=callBack',
      		       	         jsonpCallback: "callBack",
      		       			 contentType: 'application/json; charset=utf-8',
      		       	         dataType: 'jsonp',
      		       			 success: function (data) {
      		    				console.log(data);   			 
      		       				 if(data == "") {
      		       					alert('No Data');
      		       				} else {
	   		       					var myObject = data;
	   	       					 	 	viewHtmlData +="<tr>";
	   		       							viewHtmlData +="<td class='hidden-phone'>"+(i+1)+"</td>";
	   		       							viewHtmlData +="<td class='hidden-phone'><a href='"+myObject.url+"'>"+myObject.fullDisplayName+"</a></td>";
	   		       							viewHtmlData +="<td class='label label label-danger'>"+myObject.result+"</td>";
	   		       							viewHtmlData +="<td class='label label'>"+getTime(myObject.timestamp)+"</td>";
	   		       							viewHtmlData +="<td class='label label'>"+msToTime(myObject.duration)+"</td>";
	   		    							viewHtmlData +="</tr>";
	   	       					}
      		       			 },
      		       	       });
      		    			buldNo --;
      		    		}
      					viewHtmlData +="</tbody></table>";
      					document.getElementById('jobDetails').innerHTML = viewHtmlData;
      					console.log(viewHtmlData);
      				 }
      			   }
      			 },
      	       });
    		}
    	 
		function getTime(ms) {
			if(ms.length >= 10){ 
				ms = ms.substring(0,10);
				return	new Date(1459069842*1000);
			}else{
				return null;
			}
		}
		
		function msToTime(ms) {
			var seconds = (ms / 1000);
			var minutes = parseInt(seconds / 60, 10);
			seconds = seconds % 60;
			minutes = minutes % 60;
			if (0 == minutes) {
				return seconds + ' sec';
			} else {
				return minutes + ' min ' + seconds + ' sec';
			}
		}
		
		$(document).ready(function() {
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
		                });
                		 $('#jobs').append(jobsFromJenkins);
		            }
		        });
		    });
		});
		
		$(document).ready(function() {
		    $('.listStyle').click(function() {
		    });
		});
		
		
		 $('#executeBtn').click(function() {
				window.location = './fetchDefect';
			});
	</script>
</body>
</html>