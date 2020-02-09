<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>iTAP | ENVIRONMENT</title>
	<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
	
	<link href="css/bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->

    <link href="css/enviorment.css" rel="stylesheet">
    <link href="css/multiselect.css" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
</head>
<body>
	<header>
		<nav class="navbar navbar-default navbar-fixed-top ">
		 <jsp:include page="header.jsp"></jsp:include>
		<!-- /.container-fluid -->
		</nav>
	</header>

	<form:form id="itapEnvDTOForm" name="itapEnvDTOForm" action="${pageContext.request.contextPath}/envConfig"	method="POST" modelAttribute="itapEnvConfigDTO">
		<section id="services" class="bg-color first_section">
		    <div class="container" style="margin-bottom: -83px;">
		        <div class="row">
		            <div class="col-md-12">
		                <h1 class="configg-heading label-color headingfont-size">ENVIRONMENT SETUP/CONFIGURATION</h1>
		            </div>
		        </div>
		   	</div>
		</section>	
		<form:hidden path="envConfigId"/>
		<form:hidden path="actionBy"/>
		<div>	 
			<div class="container">
				<div class="row">
				</div>
			</div>
		</div>
	    <div class="container container-margin">
	        <div class="panel-group" id="accordion">
				<div class="panel">
	               <div id="collapse3" class="col-md-12 code-coverage border-color">
	                    <div class="row">
	                        <div class="form-group col-md-12 col-xs-12">
	                            <label  class=" col-md-3 control-label">Name:</label>
	                            <div class="col-md-3">
	                            	<form:input path="envName" class="form-control borderform " id="envName" />
	                            </div>
	                            <label for="envDesc" class="control-label col-md-2 col-md-offset-1">Description:</label>
	                            <div class="col-md-3">
	                            	<form:textarea path="envDesc" class="form-control borderform" id="envDesc" />
	                            </div>
	                        </div>
	                        <div class="form-group col-md-12 col-xs-12">
	                            <label  class=" col-md-3 control-label">Host:</label>
	                            <div class="col-md-3">
	                            	<form:input path="envHost" class="form-control borderform " id="envHost" />
	                            </div>
	                            <label for="envIp" class="control-label col-md-2 col-md-offset-1">IP:</label>
	                            <div class="col-md-3">
	                            	<form:input path="envIp" class="form-control borderform" id="envIp" />
	                            </div>
	                        </div>
	                        <div class="form-group col-md-12 col-xs-12">
	                            <label  class=" col-md-3 control-label">SSL:</label>
	                            <div class="col-md-3">
	                            	<form:input path="envSsl" class="form-control borderform " id="envSsl" />
	                            </div>
	                            <label for="envUserName" class="control-label col-md-2 col-md-offset-1">UserName:</label>
	                            <div class="col-md-3">
	                            	<form:input path="envUserName" class="form-control borderform" id="envUserName" />
	                            </div>
	                        </div>
	                        <div class="form-group col-md-12 col-xs-12">
	                        	<label for="envPassowrd" class="col-md-3 control-label">Password:</label>
	                            <div class="col-md-3">
	                            	<form:password path="envPassowrd" class="form-control borderform" id="envPassowrd" />
	                            </div>
	                        </div>
	                        <div class="form-group col-md-12 col-xs-12">
	                            <label for="envType" class=" col-md-6 control-label">Environment Type:</label>
	                            <div class="form-group col-md-6 col-md-pull-3 col-xs-12">
	                                <form:select path="envType" class="form-control borderform config-hostname" id="envType">
										<form:option value="">- Select -</form:option>
										<form:option value="SIT">SIT</form:option>
										<form:option value="UAT">UAT</form:option>
								 	</form:select>
	                          	</div>
	                        </div>
	                        <div class="form-group col-md-12 col-xs-12">
	                            <label for="envDockUrl" class="control-label col-md-3">Docker URL:</label>
	                            <div class="col-md-9">
	                                <form:input path="envDockUrl" class="form-control borderform" id="envDockUrl" />
	                            </div>
	                        </div>
	                     </div>
	                </div>
	            </div>
			</div>
		  </div>
	 	  <div>	 
			<div class="container">
				<div class="row">
				 	 <div class="col-md-12 col-xs-12 pull-right text-right" style="margin:0px 20px 0px 0px">
		            	<button type="submit" class="btn btn-primary" id="executeBtn" onclick="loadAjax();">Submit</button>
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
			$('[data-toggle="tooltip"]').tooltip();
            $('#drolist').multiselect({
                nonSelectedText: '--Select any ScriptList--'
            });
            $("#plusClick").click(function () {
                $("#modalInput").val("");
                $("#myModal").modal('show');
            });
            $("#plusClick2").click(function () {
                $("#modalInput").val("");
                $("#myModal2").modal('show');
            });
            $("#saveBtn").click(function () {
                alert($("#modalInput").val());
            });
            $('.testingToggle').click(function () {
                event.stopPropagation();
                $("#funnctionsla").toggle();
                $("#test2").toggle();
            });
		});
			
		$(document).ready(function() {
				$("#ajaxloader").hide();
		}); 
	</script>
</body>
</html>