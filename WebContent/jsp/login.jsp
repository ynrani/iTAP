<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
    <title>iTAP | Login</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
  
    <!-- BOOTSTRAP STYLES-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    
    <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    
    <!-- GOOGLE FONTS-->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css" />

</head>
<body style="background-color: white;">
    <div class="container">
        <div class="row text-center " style="padding-top:100px;">
            <div class="col-md-12">
                <img src="assets/img/logo-cap.jpg" />
            </div>
        </div>
       	<div class="row ">      
	    	<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">        
	        	<div class="panel-body">
	            	<form:form id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/itaplogin" method="post" autocomplete="on"> 
						<hr/> 
						<h5>
							<% if(request.getParameter("auth")!=null && request.getParameter("auth").equals("fail")){
							 	out.println("Invalid Username or Password");
							}		
							else if(request.getParameter("logout")!=null && request.getParameter("logout").equals("true")){
								out.println("Logout Successfully");
							}
							else if(request.getParameter("session")!=null && request.getParameter("session").equals("expired")){
								out.println("Session Expired");
							}else if(request.getParameter("session")!=null && request.getParameter("session").equals("alreadyLogged")){
								out.println("User Already Logged In");
							}
							%>	
						</h5><br/>
	                   	<div class="form-group input-group">
	                    	<span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
	                       	<input type="text" name="userid" required="required" class="form-control" placeholder="Your Username " />
	                    </div>
	                    <div class="form-group input-group">
	                          <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
	                          <input type="password" name="password" required="required" class="form-control"  placeholder="Your Password" />
	                    </div>
	                    <div class="form-group">
	                             <label class="checkbox-inline"><input type="checkbox" /> Remember me </label>
	                    </div>
	                    <div class="form-group">
	                    	<input type="submit" value="Login Now" class="btn btn-primary"/> 
	                    </div>
		                <hr/>
	              	</form:form>
	        	</div>
	     	</div>
	 	</div>
  	</div>

<script type="text/javascript"> 
 //loginValidation();
 
 	window.history.forward();
	function noBack() {
		window.history.forward();
	} 
	$(document).ready(function() {
		$("#ajaxloader").hide();
	});
 
</script>
</body>
</html>
