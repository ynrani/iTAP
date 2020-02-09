<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iTAP | CI Config</title>

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

	<section id="services" class="bg-color first_section">
		<div class="container" style="margin-bottom: -83px;">
			<div class="row">
				<div class="col-md-12"> <h1 class="configg-heading label-color headingfont-size">New Node CONFIGURATION</h1> </div>
			</div>
		</div>
	</section>
	
	<div>
		<div class="container">
			<div class="row"></div>
		</div>
	</div>
	
	<div class="container container-margin">
		<div class="panel-group" id="accordion">
			<div class="panel">
				<div id="collapse3" class="col-md-12 code-coverage border-color">
					<div style="padding-left: 0px;" class="row">
						<div class="form-group col-md-12 col-xs-12">
							<div class="col-md-5">
								<label class=" col-md-4 control-label">Name:</label>
								<div class="col-md-8">
									<input type="text" name="nodeName" class="form-control borderform " id="nodeName" />
								</div>
							</div>
							<div class="col-md-1">&nbsp;</div>
							<div class="col-md-6">
								<label class=" col-md-3 control-label">Description:</label>
								<div class="col-md-9">
									<input type="text" name="description" class="form-control borderform " id="description" />
								</div>
							</div>
						</div>
						<div class="form-group col-md-12 col-xs-12">
							<div class="col-md-5">
								<label class=" col-md-4 control-label"># of executors:</label>
								<div class="col-md-8">
									<input type="text" name="executors" class="form-control borderform " id="executors" />
								</div>
							</div>
							<div class="col-md-1">&nbsp;</div>
							<div class="col-md-6">
								<label class=" col-md-3 control-label">Remote root directory:</label>
								<div class="col-md-9">
									<input type="text" name="remoteRootDirectory" class="form-control borderform" id="remoteRootDirectory" />
								</div>
							</div>
						</div>
						<div class="form-group col-md-12 col-xs-12">
							<div class="col-md-5">
								<label class=" col-md-4 control-label">Labels:</label>
								<div class="col-md-8">
									<input type="text" name="labels" class="form-control borderform " id="labels" />
								</div>
							</div>
							<div class="col-md-1">&nbsp;</div>
							<div class="col-md-6">
								<label class=" col-md-3 control-label">Usage:</label>
								<div class="col-md-9">
									<select class="form-control borderform setting-input" name="usage" id="usage">
										<option value="">- Select -</option>
										<option value="NORMAL">Use this node as much as possible</option>
										<option value="EXCLUSIVE">Only build jobs with label expressions matching this node</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group col-md-12 col-xs-12">
							<div class="col-md-10">
								<label class=" col-md-2 control-label">Launch method:</label>
								<div class="col-md-6">
									<select class="form-control borderform setting-input" id="usage" onclick="hideAndShow()">	
										 <option value="select">select</option>
										 <option value="hudson.slaves.JNLPLauncher">Launch agent via Java Web Start</option>
										 <option value="hudson.slaves.CommandLauncher">Launch agent via execution of command on the master</option>
										 <option value="hudson.plugins.sshslaves.SSHLauncher">Launch slave agents on Unix machines via SSH</option>
										 <option value="hudson.os.windows.ManagedWindowsServiceLauncher">Let Jenkins control this Windows slave as a Windows service</option>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group col-md-12 col-xs-12" id="jnlplauncher">
							<div class="col-md-2"></div>
							<div class="col-md-10">
								<!-- <label class=" col-md-2 control-label">Launch method:</label><div class="col-md-6">Launch agent via Java Web Start</div> -->
							</div>
						</div>
						
						<div class="form-group col-md-12 col-xs-12" id="commandLauncher">
							<div class="col-md-2"></div>
							<div class="col-md-10">
								<label class=" col-md-2 control-label">Launch command:</label>
								<div class="col-md-6">
									<input type="text" name="commandName"class="form-control borderform" id="commandName" />
								</div>
							</div>
						</div>
						
						<div class="form-group col-md-12 col-xs-12" id="sshlauncher">
							<div class="col-md-2"></div>	
							<div class="col-md-10">
								<div class="col-md-12">
									<label class=" col-md-2 control-label">Host:</label>
									<div class="col-md-6">
										<input type="text" name="hostName" class="form-control borderform" id="hostName" />
									</div>
								</div>
								<!-- <div style="margin-top: 10px;" class="col-md-12">
									<label class=" col-md-2 control-label">Credentials:</label>
									<div class="col-md-6">
										<select class="form-control borderform setting-input" id="credential">
											<option>here is option</option>
										</select>
									</div>
								</div> -->
							</div>							
						</div>
						<div class="form-group col-md-12 col-xs-12" id="managedWindowsServiceLauncher">
							<div class="col-md-2"></div>
							<div class="col-md-10">
								This launch method relies on DCOM and is often associated with subtle problems.
								Consider using Launch slave agents using Java Web Start instead, 
								which also permits installation as a Windows service but is generally considered more reliable.											
								<div style="margin-top: 10px;" class="col-md-12">
									<label class=" col-md-2 control-label">Administrator user name:</label>
									<div class="col-md-6">
										<input type="text" name="adminUserName" class="form-control borderform" id="adminUserName" />
									</div>
								</div>
								<div style="margin-top: 10px;" class="col-md-12">
									<label class=" col-md-2 control-label">Password:</label>
									<div class="col-md-6">
										<input type="text" name="adminUserName" class="form-control borderform" id="password" />
									</div>
								</div>
								<div style="margin-top: 10px;" class="col-md-12">
									<label class=" col-md-2 control-label">Host:</label>
									<div class="col-md-6">
										<input type="text" name="host" class="form-control borderform" id="host" />
									</div>
								</div>
								<div style="margin-top: 10px;" class="col-md-12">
									<label class=" col-md-2 control-label">Run service as:</label>
									<div class="col-md-6">
										<select class="form-control borderform setting-input" id="runServiceAs">
											<option value="0">Use Local System User</option>
											<option value="1">Log on using a different account</option>
											<option value="2">Use Administrator account given above</option>
										</select>
									</div>
								</div>
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
				<div class="col-md-12 col-xs-12 pull-right text-right" style="margin: 0px 20px 0px 0px">select</div>
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
	
	function hideAndShow() {		
		var data = $("#usage").find().context.activeElement.value+"";
		if(data=='select') {
			$("#jnlplauncher").hide();
			$("#commandLauncher").hide();
			$("#sshlauncher").hide();
			$("#managedWindowsServiceLauncher").hide();
		}
		if(data=='hudson.slaves.JNLPLauncher') {
			$("#jnlplauncher").show();
			$("#commandLauncher").hide();
			$("#sshlauncher").hide();
			$("#managedWindowsServiceLauncher").hide();
		}
		else if(data=='hudson.slaves.CommandLauncher') {
			$("#commandLauncher").show();
			$("#jnlplauncher").hide();
			$("#sshlauncher").hide();
			$("#managedWindowsServiceLauncher").hide();
		}
		else if(data=='hudson.plugins.sshslaves.SSHLauncher') {
			$("#sshlauncher").show();
			$("#jnlplauncher").hide();
			$("#commandLauncher").hide();
			$("#managedWindowsServiceLauncher").hide();
		}
		else if(data=='hudson.os.windows.ManagedWindowsServiceLauncher') {
			$("#managedWindowsServiceLauncher").show();
			$("#jnlplauncher").hide();
			$("#commandLauncher").hide();
			$("#sshlauncher").hide();
		}
	}	
	
	$(document).ready(function() {
		$("#jnlplauncher").hide();
		$("#commandLauncher").hide();
		$("#sshlauncher").hide();
		$("#managedWindowsServiceLauncher").hide();
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
	});
	
	</script>
</body>
</html>