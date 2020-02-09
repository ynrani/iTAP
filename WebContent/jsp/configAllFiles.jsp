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
	
	<form:form id="itapConfAllFileDTOForm" name="itapConfAllFileDTOForm" action="${pageContext.request.contextPath}/configAllFiles" method="POST" modelAttribute="itapConfAllFilesDTO">
	<form:hidden path="confAllFileId"/>
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
            <div class="panel">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                       <img src="img/about/tick.png" class="tick-width"><a data-toggle="collapse"  href="#collapse3"class="headingfont-size heading-margin">CODE COVERAGE ANALYSIS</a>
                    </h4>
                </div>
               <div id="collapse3" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                         <div class="form-group col-md-12 col-xs-12">
                            <label for="ccFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="ccFilePath" class="form-control borderform" id="ccFilePath" />
                             </div>
                            <label for="ccFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="ccFileName" class="form-control borderform" id="ccFileName" />
                             </div>
                        </div>
                     </div>
                </div>
            </div>
			<!-- Panel 1 End -->
			<!-- Panel 1 Start -->
            <div class="panel">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                       <img src="img/about/tick.png" class="tick-width">  <a data-toggle="collapse"  href="#collapse3"class="headingfont-size heading-margin">BDD</a>
                    </h4>
                </div>
               <div id="collapse3" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                         <div class="form-group col-md-12 col-xs-12">
                            <label for="bddFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="bddFilePath" class="form-control borderform" id="bddFilePath" />
                             </div>
                            <label for="bddFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="bddFileName" class="form-control borderform" id="bddFileName" />
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
                       <img src="img/about/tick.png" class="tick-width">  <a data-toggle="collapse"  href="#collapse3"class="headingfont-size heading-margin">API TESTING</a>
                    </h4>
                </div>
               <div id="collapse3" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                         <div class="form-group col-md-12 col-xs-12">
                            <label for="apiFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="apiFilePath" class="form-control borderform" id="apiFilePath" />
                             </div>
                            <label for="apiFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="apiFileName" class="form-control borderform" id="apiFileName" />
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
                       <img src="img/about/tick.png" class="tick-width">  <a data-toggle="collapse"  href="#collapse4"class="headingfont-size heading-margin">CROSS BROWSER TESTING</a>
                    </h4>
                </div>
               <div id="collapse4" class="panel-collapse collapse  col-md-12 code-coverage border-color">
                    <div class="row">
                      <div class="form-group col-md-12 col-xs-12">
                            <label for="optikFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="optikFilePath" class="form-control borderform" id="optikFilePath" />
                             </div>
                            <label for="optikFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="optikFileName" class="form-control borderform" id="optikFileName" />
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
                       <img src="img/about/tick.png" class="tick-width">  <a data-toggle="collapse"  href="#collapse5"class="headingfont-size heading-margin">FUNCTIONAL TESTING : CAFE UFT/Next</a>
                    </h4>
                </div>
               <div id="collapse5" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                      <div class="form-group col-md-12 col-xs-12">
                            <label for="cafeUftFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="cafeUftFilePath" class="form-control borderform" id="cafeUftFilePath" />
                             </div>
                            <label for="cafeUftFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="cafeUftFileName" class="form-control borderform" id="cafeUftFileName" />
                             </div>
                        </div>
                    </div>
            </div>
            </div>
			<!-- Panel 4 End -->
			<!-- Panel 5 Start -->
            <div class="panel ">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                        <img src="img/about/tick.png" class="tick-width"> <a data-toggle="collapse"  href="#collapse6" class="headingfont-size heading-margin">FUNCTIONAL TESTING : CAFE Selenium</a>
                    </h4>
                </div>
                <div id="collapse6" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                      <div class="form-group col-md-12 col-xs-12">
                            <label for="cafeSelFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="cafeSelFilePath" class="form-control borderform" id="cafeSelFilePath" />
                             </div>
                            <label for="cafeSelFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="cafeSelFileName" class="form-control borderform" id="cafeSelFileName" />
                             </div>
                        </div>
                    </div>
                </div>
            </div>
			<!-- Panel 5 End -->
			<!-- Panel 6 Start -->
            <div class="panel ">
                <div class="panel-heading pannelbottom-border">
                    <h4 class="panel-title">
                        <img src="img/about/tick.png" class="tick-width"> <a data-toggle="collapse"  href="#collapse7" class="headingfont-size heading-margin">FUNCTIONAL TESTING : Test Complete</a>
                    </h4>
                </div>
                <div id="collapse7" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                      <div class="form-group col-md-12 col-xs-12">
                            <label for="cafeMobFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="cafeMobFilePath" class="form-control borderform" id="cafeMobFilePath" />
                             </div>
                            <label for="cafeMobFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="cafeMobFileName" class="form-control borderform" id="cafeMobFileName" />
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
                        <img src="img/about/tick.png" class="tick-width"> <a data-toggle="collapse"  href="#collapse8" class="headingfont-size heading-margin">PERFORMANCE TESTING</a>
                    </h4>
                </div>
                <div id="collapse8" class="panel-collapse collapse col-md-12 code-coverage border-color">
                    <div class="row">
                      <div class="form-group col-md-12 col-xs-12">
                            <label for="twistFilePath" class="control-label col-md-2 col-md-offset-1">File Path: </label>
                             <div class="col-md-3">
                                <form:input path="twistFilePath" class="form-control borderform" id="twistFilePath" />
                             </div>
                            <label for="twistFileName" class="control-label col-md-2 col-md-offset-1">File Name: </label>
                             <div class="col-md-3">
                                <form:input path="twistFileName" class="form-control borderform" id="twistFileName" />
                             </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Panel 7 End -->
	    </div>
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