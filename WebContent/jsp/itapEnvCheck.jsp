<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>iTAP | Check Env</title>
</head>

<body>	 
<div  style="padding: 12px 0px 0px 0px; ">
  <div class="panel-group" id="accordion" style=" margin-top: 20px;">
	<form:form id="itapEnvCheckForm" name="itapEnvCheckForm" action="${pageContext.request.contextPath}/itapEnvCheck" modelAttribute="remsSearchBookingDTO">  
    <!-- /. ROW  -->  <!-- /. ROW  -->
	<c:choose>
		<c:when test="${remsSearchBookingDTO ne null}">		
			<!-- /. ROW  -->
         	<div style="padding: 0px 14px 0px 10px;">
                <div>
                 	<a style="color:#1422A1" href="http://in-pnq-coe15:8080/SmartFoundry/" target="_blank">Click Here to see complete details about this Environment</a>
                 </div>
           		 <div class="scrollingX table-responsive">
		 		  <!-- Table -->
				  <table id="tableSort" class="table table-striped table-bordered" style="font-size: xx-small;">
			  		  <thead>
							<tr>
								<th style="padding-right: 20px;"><strong>Application Name</strong></th>
								<th style="padding-right: 20px;"><strong>Environment Name</strong></th>
								<c:forEach items="${remsSearchBookingDTO.passedDates}" var="passedDates" varStatus="status">
									<th style="padding-right: 20px;"><strong>${passedDates}</strong> </th>
								</c:forEach>		
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${remsSearchBookingDTO.listITAPBookEnvDTO}" var="listITAPBookEnvDTO" varStatus="status">
								<tr>
									<td align="left">${listITAPBookEnvDTO.appName}</td>
									<td align="left">${listITAPBookEnvDTO.envName}</td>
									<c:forEach items="${listITAPBookEnvDTO.avilableDates}" var="avilableDates" varStatus="status">
										<c:if test="${!fn:contains(avilableDates, '_')}">
											<td align="left">
												<a class="btn btn-success" style="padding: 3px 3px; font-size: xx-small;" href="#" >Available</a>
											</td>
										</c:if>
										<c:if test="${fn:contains(avilableDates, 'S')}">
											<td align="left">
												<a style="padding: 3px 3px; font-size: xx-small;" class="btn btn-warning" href="#"  >Booked</a>
						 					</td>
										</c:if>
										<c:if test="${fn:contains(avilableDates, 'D')}">
											<td  align="left">
												<a style="padding: 3px 3px; font-size: xx-small;" class="btn btn-danger" href="#">Booked</a>
									 		</td>
										</c:if>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			  	</div>
			</div>
				<div class="row">
                    <div class="col-md-12"></div>
                </div> 
			</c:when>
			<c:otherwise>
				<h3 style="float: left; width: 40%; border: 0; font-size: 14px; color: black; padding-top: 15px"> Not Found</h3>
				<br/>
			</c:otherwise>
		</c:choose>
        <!--/.ROW-->
        
     	</form:form>
      </div>
      </div>  	
       
	<script src="js/jquery.js"></script>
	
	 <!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
 	   
	 <!-- BOOTSTRAP SCRIPTS FOR TABLE SORT -->
 	<script type="text/javascript">
		$(document).ready(function() {
			$("#ajaxloader").hide();
		});
		
		$(document).ready( function() {
			$('.dropdown-toggle').dropdown();
		}); 
	</script>
</body>
</html>