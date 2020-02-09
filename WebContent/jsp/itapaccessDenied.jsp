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
 		
	 <section id="services" class="bg-color first_section">
	    <div class="container" style="margin-bottom: -83px;">
	        <div class="row">
	            <div class="col-md-12">
	                <h1 class="configg-heading label-color headingfont-size">403 ACCESS DENIED</h1>
	            </div>
	        </div>
	  	</div>
	 </section>

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
	/* 	collapse_in('coll_in_user');
		menu_highlight_top('user');
		menu_highlight('add_user');
		active_li('actv_user'); */
		
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