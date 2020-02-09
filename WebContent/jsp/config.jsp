<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>iTAP | Config</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="css/config.css" rel="stylesheet">
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
	            <div class="col-md-12">
	                <h1 class="configg-heading label-color headingfont-size">CONFIG PAGE</h1>
	            </div>
	        </div>
	    </div>
	</section>
	
	<form:form id="itapSysConfigDTOForm" name="itapSysConfigDTOForm" action="${pageContext.request.contextPath}/config" 
				method="POST" modelAttribute="itapSysConfigDTO">
	<form:hidden path="sysConfigId"/>
	<form:hidden path="actionBy"/>
	<div>	 
		<div class="container">
			<div class="row">
			</div>
		</div>
	</div>
    <div class="container container-margin">
    	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
	            <div class="pull-right"> <a id="expandAll" href="#" class="btn btn-default" role="button">Expand All</a>
	                <a id="collapseAll" href="#" class="btn btn-default" role="button">Collapse All</a>
	            </div>
       	</div>
        <div class="panel-group" id="accordion">
        	<!-- Panel 1 Start -->
            <div class="panel ">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                        <img src="img/about/tick.png" class="tick-width"><a data-toggle="collapse"  href="#collapse1" class="headingfont-size heading-margin">Source Configuration Management</a>
                    </h4>
                </div>
                <div id="collapse1" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                        <div class="form-group col-md-12 col-xs-12">
							<label class=" col-md-3 control-label">Source</label>
							<div class="form-group col-md-9">
								<form:select path="scmSource" class="form-control" id="scmSource">
									<form:option value="">- Select -</form:option>
									<form:option value="SVN">SVN</form:option>
								</form:select>
							</div>
						</div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-3 control-label">URL</label>
                            <div class="col-md-9">
                                <form:input path="scmUrl" class="form-control borderform" id="scmUrl" />
                            </div>
                        </div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label for="scmUserName" class="control-label col-md-3">UserName:</label>
                            <div class="col-md-3">
                                <form:input path="scmUserName" class="form-control borderform" id="scmUserName" />
                            </div>
                            <label for="scmPassowrd" class="control-label col-md-2 col-md-offset-1">Password:</label>
                            <div class="col-md-3">
                                <form:password path="scmPassowrd"  class="form-control borderform" id="scmPassowrd" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			<!-- Panel 1 End -->
			<!-- Panel 2 Start -->
            <div class="panel">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                        <img src="img/about/tick.png" class="tick-width"> <a  data-toggle="collapse"  href="#collapse2" class="headingfont-size heading-margin">DATABASE</a>
                    </h4>
                </div>
                 <div id="collapse2" class="panel-collapse collapse  col-md-12 code-coverage  border-color">
                    <div class="row">
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-6 control-label">Host Name</label>
                            <div class="col-md-6 col-md-pull-3">
                               <form:input path="dbHostName"  class="form-control config-hostname borderform" id="dbHostName" />
                            </div>
                        </div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label for="inputPassword3" class="control-label col-md-3">UserName:</label>
                            <div class="col-md-3">
                                <form:input path="dbUserName" class="form-control borderform" id="dbUserName" />
                            </div>
                            <label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Password:</label>
                            <div class="col-md-3">
                                <form:password path="dbPassowrd" class="form-control borderform" id="dbPassowrd" />
                            </div>
                        </div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-6 control-label">Port No:</label>
                            <div class="col-md-6 col-md-pull-3">
                                <form:input path="dbPort"  class="form-control config-hostname borderform" id="dbPort" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			<!-- Panel 2 End -->
			<!-- Panel 3 Start -->
            <div class="panel">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                       <img src="img/about/tick.png" class="tick-width">  <a data-toggle="collapse"  href="#collapse3"class="headingfont-size heading-margin">BDD</a>
                    </h4>
                </div>
               <div id="collapse3" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-6 control-label">Test Managment Tool:</label>
                            <div class="form-group col-md-6 col-md-pull-3 col-xs-12">
                                    <form:select path="bddTstMgmtTool" class="form-control borderform config-hostname" id="bddTstMgmtTool">
										<form:option value="">- Select -</form:option>
										<form:option value="JIRA">JIRA</form:option>
										<form:option value="RALLY">RALLY</form:option>
										<form:option value="ALM">ALM</form:option>
									</form:select>
                                </div>
                        </div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label for="inputPassword3" class="control-label col-md-3">URL:</label>
                            <div class="col-md-9">
                                <form:input path="bddUrl" class="form-control borderform" id="bddUrl" />
                            </div>
                        </div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-3 control-label">UserName:</label>
                            <div class="col-md-3">
                                <form:input path="bddUserName" class="form-control borderform " id="bddUserName" />
                            </div>
                            <label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Password:</label>
                            <div class="col-md-3">
                                <form:password path="bddPassowrd" class="form-control borderform" id="bddPassowrd" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			<!-- Panel 3 End -->
			<!-- Panel 4 Start -->
			 <div class="panel">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                       <img src="img/about/tick.png" class="tick-width">  <a data-toggle="collapse"  href="#collapse4"class="headingfont-size heading-margin">OPTIK</a>
                    </h4>
                </div>
               <div id="collapse4" class="panel-collapse collapse  col-md-12 code-coverage border-color">
                    <div class="row">
                      <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-3 control-label">GRID:</label>
                            <div class="col-md-3">
                                <form:input path="optGrd" class="form-control borderform " id="optGrd" />
                            </div>
                            <label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">TestCases:</label>
                            <div class="col-md-3">
                                <form:input path="optTstCase" class="form-control borderform " id="optTstCase" />
                            </div>
                        </div>
                         <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-6 control-label">Results:</label>
                            <div class="col-md-6 col-md-pull-3">
                                <form:input path="scmPassowrd" class="form-control config-hostname borderform" id="scmPassowrd" />
                            </div>
                        </div>
                    </div>
                </div>
			</div>
            </div>
			<!-- Panel 4 End -->
			<!-- Panel 5 Start -->
		     <div class="panel">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                       <img src="img/about/tick.png" class="tick-width">  <a data-toggle="collapse"  href="#collapse5"class="headingfont-size heading-margin">CAFE UFT/Next</a>
                    </h4>
                </div>
               <div id="collapse5" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                     <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-3 control-label">Test Cases:</label>
                            <div class="col-md-3">
                                <form:input path="cafNxtTstCase" class="form-control borderform " id="cafNxtTstCase" />
                            </div>
                            <label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Results:</label>
                            <div class="col-md-3">
                                <form:input path="cafNxtResult" class="form-control borderform " id="cafNxtResult" />
                            </div>
                        </div>
                    </div>
                    <img src="img/about/arrowup.png" class="arrow-image"  style="margin-left:1103px" data-toggle="collapse"  href="#collapse1">
                </div>
            </div>
			<!-- Panel 5 End -->
			<!-- Panel 6 Start -->
            <div class="panel ">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                        <img src="img/about/tick.png" class="tick-width"> <a data-toggle="collapse"  href="#collapse6" class="headingfont-size heading-margin">CAFE Selenium</a>
                    </h4>
                </div>
                <div id="collapse6" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                         <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-6 control-label">Eclipse Path:</label>
                            <div class="col-md-6 col-md-pull-3">
                                <form:input path="cafSeleEclPath" class="form-control config-hostname borderform" id="cafSeleEclPath" disabled="disabled"/>
                            </div>
                        </div>
                     <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-3 control-label">TestCases:</label>
                            <div class="col-md-3">
                                <input type="password" class="form-control borderform" id="inputPassword3">
                            </div>
                            <label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Results:</label>
                            <div class="col-md-3">
                                <form:input path="cafSeleTstCase" class="form-control borderform" id="cafSeleTstCase" disabled="disabled"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			<!-- Panel 6 End -->
			<!-- Panel 7 Start -->
            <div class="panel ">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                        <img src="img/about/tick.png" class="tick-width"> <a data-toggle="collapse"  href="#collapse7" class="headingfont-size heading-margin">CAFE MOBILE</a>
                    </h4>
                </div>
                <div id="collapse7" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-6 control-label">Mobile Automation Tool:</label>
                            <div class="form-group col-md-6 col-md-pull-3 col-xs-12">
                                    <form:select path="cafMobAutoTool" class="form-control borderform config-hostname" id="cafMobAutoTool" disabled="disabled">
										<form:option value="">- Select -</form:option>
										<form:option value="XYZ">XYZ</form:option>
										<form:option value="ABC">ABC</form:option>
									</form:select>
                                </div>
                        </div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-3 control-label">UserName:</label>
                            <div class="col-md-3">
                                <form:input path="cafMobTstCase" class="form-control borderform" id="cafMobTstCase" disabled="disabled"/>
                            </div>
                            <label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Password:</label>
                            <div class="col-md-3">
                                <form:input path="cafMobResult" class="form-control borderform" id="cafMobResult" disabled="disabled"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
			<!-- Panel 7 End -->
			<!-- Panel 8 Start -->
			<div class="panel ">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                        <img src="img/about/tick.png" class="tick-width"> <a data-toggle="collapse"  href="#collapse8" class="headingfont-size heading-margin">TWIST</a>
                    </h4>
                </div>
                <div id="collapse8" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-6 control-label">Twist Mobile Automation Tool:</label>
                            <div class="form-group col-md-6 col-md-pull-3 col-xs-12">
                                    <form:select path="twistXpathGen" class="form-control borderform config-hostname" id="twistXpathGen">
												<form:option value="">- Select -</form:option>
												<form:option value="SoupUI">SoupUI</form:option>
												<form:option value="RestAPI">RestAPI</form:option>
									</form:select>
                                </div>
                        </div>
                        <div class="form-group col-md-12 col-xs-12">
                            <label  class=" col-md-3 control-label">UserName:</label>
                            <div class="col-md-3">
                               <form:input path="twistTstCase" class="form-control borderform" id="twistTstCase" />
                            </div>
                            <label for="inputPassword3" class="control-label col-md-2 col-md-offset-1">Password:</label>
                            <div class="col-md-3">
                                <form:input path="twistResult" class="form-control borderform" id="twistResult" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Panel 8 End -->
	    </div>
		<div class="container">
		 <div class="row">
		     <div class="col-md-12">
			     <div class="col-md-6 col-xs-12 col-md-push-9 btn-margin">
			         <button type="button" class="btn btn-primary btn-width">RESET</button>
			     </div>
			     <div class="col-md-6 col-xs-12 col-md-push-4 btn-margin">
			        <input type="submit" class="btn btn-primary btn-width" value="SUBMIT"  onclick="loadAjax();"/>
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
<script  type="text/javascript">

	$(function () {			
	    $('a[data-toggle="collapse"]').on('click',function(){
			var objectID=$(this).attr('href');
			if($(objectID).hasClass('in')){
	             $(objectID).collapse('hide');
			}else{
	             $(objectID).collapse('show');
			}
	    });
	    
	    $('#expandAll').on('click',function(){
	        $('a[data-toggle="collapse"]').each(function(){
	            var objectID=$(this).attr('href');
	            if($(objectID).hasClass('in')===false)
	            {
	                 $(objectID).collapse('show');
	            }
	        });
	    });
	    
	    $('#collapseAll').on('click',function(){
	        $('a[data-toggle="collapse"]').each(function(){
	            var objectID=$(this).attr('href');
	            $(objectID).collapse('hide');
	        });
	    });
	});
		
    $(document).ready(function() {
        $('#drolist').multiselect({
            nonSelectedText :'--Select any ScriptList--'
        });
        $( "#plusClick" ).click(function() {
            $("#modalInput").val("");
            $("#myModal").modal('show');
        });
		$( "#plusClick2" ).click(function() {
            $("#modalInput").val("");
            $("#myModal2").modal('show');
        });
        $( "#saveBtn" ).click(function() {
          alert($("#modalInput").val());
        });  
        $('.testingToggle').click(function() {
            event.stopPropagation();
            $("#funnctionsla").toggle();
            $("#test2").toggle();
  	});
      
    $('#executeBtn').click(function() {
   		window.location='itapTesting.html' 
  	});
        
    });
      function checkboxCheck(){
            if(document.getElementById("#sourceconfigId").checked){
             alert("hello");   
            } 
        }

      $(document).ready(function() {
  		$("#ajaxloader").hide();
  	} );
</script>
</body>
</html>