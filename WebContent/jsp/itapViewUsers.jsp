<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>iTAP | View Users</title>
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

<!-- BOOTSTRAP CSS FOR TABLE SORT -->
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
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
				<div class="col-md-12"><h1 class="configg-heading label-color headingfont-size">VIEW USERS</h1></div>
			</div>
		</div>
	</section>

	<form:form id="itapViewUsersForm" name="itapViewUsersForm" action="${pageContext.request.contextPath}/itapViewUsers" modelAttribute="itapUserDtlDTO">
	  	<!-- START MAIN -->
	   	<div class="container">
	   
			 <!-- START PAGE SIDEBAR -->
			 <%--        <jsp:include page="Navi.jsp"></jsp:include> --%>
			 <!-- END PAGE SIDEBAR -->      
			 <div class="panel-group" id="accordion" style="margin-top: 20px;">
		    	<c:choose>
		    		<c:when test="${itapUserDtlDTOs ne null}">      
		           		<table id="tableSort" class="table table-striped table-bordered" >
							<thead>
								<tr>
									<th>Edit</th>
									<th>Delete</th>
									<th>User ID</th>
									<th>User Name</th>
									<th>User Email</th>
									<th>User Phone</th>
									<th>User Type</th> <!-- 	<th>User Access</th> <th>User Status</th> <th>Applications</th> -->
							  	</tr>
							</thead>
							<tbody id="body">
								<c:forEach items="${itapUserDtlDTOs}" var="itapUserDtlDTOs" varStatus="status">
				                	<tr>
				                    	<td align="left"><a class="btn btn-success" href="./itapCreateUser?id=${itapUserDtlDTOs.userId}"  onclick="loadAjax();">Edit</a></td>
				                   		<td align="left"> <a class="btn btn-danger" href="javascript:deleteSel('./itapDeleteUser?id=${itapUserDtlDTOs.userId}');" >Delete</a>  </td>
				                    	<td align="left">${itapUserDtlDTOs.userId}</td>
				                    	<td align="left">${itapUserDtlDTOs.userName}</td>
				                    	<td align="left">${itapUserDtlDTOs.userEmail}</td>
				                    	<td align="left">${itapUserDtlDTOs.userPh}</td>
				                    	<td align="left">${itapUserDtlDTOs.userType}</td>
					                 	<%--  <td align="left">${itapUserDtlDTOs.userAccess}</td> 
					                    	  <td align="left">${itapUserDtlDTOs.userSts}</td> 
					                    	  <c:if test="${itapUserDtlDTOs.userType eq 'ROLE_ENV_OWNR'}">
					                    	  	<td align="left"><a class="btn btn-warning" href="./itapViewAllocApp?id=${itapUserDtlDTOs.userId}"   onclick="loadAjax();">Applications</a></td>
					                    	  </c:if>
					                    	  <c:if test="${itapUserDtlDTOs.userType ne 'ROLE_ENV_OWNR'}">
					                    		 <td align="left"><a class="btn btn-danger" href="#" >Not Allowed</a></td>
					                    	  </c:if> --%>
				                  	</tr>
				                </c:forEach>
							</tbody>
						</table>
					</c:when>
			        <c:otherwise>
				       <div class="col-md-12">
						<h1 class="page-subhead-line">No User(s) are available </h1></div>
				   </c:otherwise>
				</c:choose>
		  	</div>
 		</div>
	</form:form>				 
                    		 
 	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
 	</footer>
     
    <script charset="utf-8" src="js/jquery.js"></script>
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

	<!-- BOOTSTRAP SCRIPTS FOR TABLE SORT -->
	<script charset="utf-8" src="js/jquery.dataTables.min.js"></script>
	<script src="js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/agency.js"></script>
	<script>
	function deleteSel(url,from){
		$("#myModal").modal('show');
		$('#from').html(from).fadeIn();
		$('#url').attr('id', url);
		$(".del").click(function(){
			window.location.href = $(".del").attr("id");
		});
	}  		 /* 	active_li('actv_user'); */
	 
	$(document).ready(function() {
		 $('#tableSort').DataTable();
		$("#ajaxloader").hide();
	} );

	</script>

</body>
</html>
