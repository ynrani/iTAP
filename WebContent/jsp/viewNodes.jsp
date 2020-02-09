<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<title>iTAP | Train List</title>
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
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css" />

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
				<div class="col-md-12">
					<h1 class="configg-heading label-color headingfont-size">Jenkins Master Slave Configuration</h1>
				</div>
			</div>
		</div>
	</section>

	<form:form id="itapConfigDTOForm" name="itapConfigDTOForm" action="${pageContext.request.contextPath}/asdf">
		<div class="container">
			<div class="panel-group" id="accordion" style="margin-top: 20px;">
				<table id="tableSort" class="table table-striped table-bordered">
					<thead>
						<tr>   
  							<th>Name</th>
							<th>Architecture</th>
							<th>Clock Difference</th>
							<th>Free Swap Space</th>
							<th>Free Temp Space</th>
							<th>Response Time</th>
						</tr>
					</thead>
					<tbody id="body">
						 <c:forEach items="${masterSlaveDO}" var="masterNodes" varStatus="status"> 
						<tr>
							<td align="left">${masterNodes.name}</td>
							<td align="left">second</td>
							<td align="left">third</td>
							<td align="left">Fourth</td>
							<td align="left">fifth</td>
							<td align="left">Build</td>
						</tr>
						</c:forEach>

					</tbody>
				</table>
				<div class="col-md-12">
					<h1 class="page-subhead-line">No Trains are available</h1>
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

			<!-- BOOTSTRAP SCRIPTS FOR TABLE SORT -->
			<script src="js/jquery.dataTables.min.js"></script>
			<script src="js/dataTables.bootstrap.min.js"></script>

			<!-- Custom Theme JavaScript -->
			<script src="js/agency.js"></script>
			<script type="text/javascript">
				
			</script>
</body>
</html>