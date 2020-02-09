<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iTAP | Add Users</title>
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">

<!-- Bootstrap Core CSS -->
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

   
  	<!-- START FORM  -->
		<form:form id="itapUserDtlDTOForm" name="itapUserDtlDTOForm" action="${pageContext.request.contextPath}/itapCreateUser" 
			method="POST"	modelAttribute="itapUserDtlDTO">
		
		<section id="services" class="bg-color first_section">
	    <div class="container" style="margin-bottom: -83px;">
	        <div class="row">
	            <div class="col-md-12">
	                <h1 class="configg-heading label-color headingfont-size">ADD USER</h1>
	            </div>
	        </div>
	       </div>
		</section>
		 <div>	 
			<div class="container">
				<div class="row">
				</div>
			</div>
		</div>
		
        <!-- START panel-default  -->
      	<div class="container container-margin">
              <div class="panel-group" id="accordion">
              	<div class="panel">	
              		<div id="collapse3" class="col-md-12 code-coverage border-color">
                    	<div class="row">
                    		<div class="form-group col-md-12 col-xs-12">
                     			<label class=" col-md-3 control-label">User ID: </label>
					 				<div class="col-md-3">                                            
                           				<form:input path="userId" maxlength="30" class="form-control borderform"/>
	                       					<span id="msg1" style="color: #e32;">User Id already exists.</span>
                      				</div>		 
					 			<label class="col-md-3 control-label col-md-2 col-md-offset-1">Name:
					 				<span class="asterisk_input"></span>
					 			</label>
				 				<div class="col-md-3">                                            
                            		<form:input path="userName" maxlength="30" class="form-control borderform"/>
			        			</div>		 
							</div>
							<div class="form-group col-md-12 col-xs-12">                                        
		                   		<label class="col-md-3 control-label">Password:<span class="asterisk_input">  </span></label>
		                       	<div class="col-md-3">
		                          	<form:password path="passWord"  maxlength="50" class="form-control borderform"/>
		                      	</div>
			                    <label class="col-md-3 control-label col-md-2 col-md-offset-1">User Type:</label>
			                  	<span class="asterisk_input"></span>
	                      		<div class="col-md-3">                                                                                            
	                           		<div class="radio">
										<label>
											<form:radiobutton path="userType" id="userType1" class="iradio_minimal-grey" 
												value="ROLE_ADMIN"/>Admin
										</label>
										<label>
											<form:radiobutton path="userType" id="userType3" class="iradio_minimal-grey"  
												value="ROLE_USER"/>User
										</label>
									</div>       
	                           	</div>
							</div> 
                     		 <div class="form-group col-md-12 col-xs-12">
	                     		<label class="col-md-3 control-label">User Phone:<span class="asterisk_input">  </span></label>
					 			<div class="col-md-3">                                            
                            		<form:input path="userPh" data-maxsize="20" class="form-control phoneNo borderform"  
                            			data-error="That Phone no is invalid"  />
					        		<span id="spnPhoneStatus"></span>  
			               			<span class="help-block">The acceptable values are "+/-0123456789 and ,".</span>                                     
                       			</div>		 
						   		<label class="col-md-3 control-label col-md-2 col-md-offset-1" >User Email:
						   			<span class="asterisk_input">  </span></label>
						 		<div class="col-md-3">                                            
	                         		<form:input path="userEmail" placeholder="Enter email" maxlength="50"
	                         			 class="form-control borderform"  />
				              		<span class="help-block">example@domain.com</span>                                        
	                       		</div>		
                          	</div> 
   				        </div>
                  		<!-- END panel-body  -->	 
					 	<form:hidden path="actionBy"/>
			   		 	<form:hidden path="enabled"/>
						<div class="container">
							<div class="row">
							 	<div class="col-md-12 col-xs-12 pull-right text-right" style="margin:0px 20px 0px 0px">
						        	<input type="submit" class="btn btn-primary pull-right" value="Submit" id="submit"  
						        		onclick="loadAjax();"/>
						       	</div>
							</div>
						</div>
          		 	</div>
            	 	<!-- END panel-default  -->	    
 				</div>
 			</div>
 		</div>
 		<!-- END panel-default  -->
  	</form:form>
  	<!-- END FORM  -->
 
     <footer>
 		<jsp:include page="footer.jsp"></jsp:include>
    </footer>
     <!-- END MAIN   -->
      
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    
    <!-- JQUERY SCRIPTS -->
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

	<script>
		$(document).ready(function() {
			 var userId= $('#userId').val();
	  	     if("" != userId){
	  	    	$("#userId").attr("readonly", true);
	  	    	$("#reset").attr("disabled", true);
	  	     }else if("" == userId){
	  	    	$("#userId").attr("readonly", false);
	  	     }
		});
		
		$(document).ready(function() {
			 $("#msg1").hide();
	  	     $('#userId').change(function() {
	  	     var selectedValue = $(this).val();
	  	     var servletUrl = 'itapCheckUserAvail?name=' + selectedValue;
	  	      $.ajax({url: servletUrl, success: function(msg){
	  	    	if (msg != "") {
		            	$("#submit").attr("disabled", true);
		            	$("#msg1").show();
		            } else {
		            	$("#submit").attr("disabled", false);
		            	$("#msg1").hide(); 
		            }
	  		    }});
	    	        
	  	    });
	  	});
		
		$(document).ready(function() {
			$("#ajaxloader").hide();
		} );
	</script>

</body>
</html>
