<%@page import="com.itap.model.DTO.JenkinsConfigDTO"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

	<form:form id="jenkinsConfigForm" name="jenkinsConfigForm" action="${pageContext.request.contextPath}/jenkinsConfig" method="POST" modelAttribute="jenkinsConfigDTO">
		<section id="services" class="bg-color first_section">
		    <div class="container" style="margin-bottom: -83px;">
		        <div class="row">
		            <div class="col-md-12"><h1 class="configg-heading label-color headingfont-size">CI CONFIGURATION</h1></div>
		        </div>
		   	</div>
		</section>
	    <%-- myTempVal :<form:input path="myTempVal" class="form-control borderform " id="jenkinsName1" /> 
	    <form:hidden path="teamCityServerId"/> <form:hidden path="teamCityActionBy"/> <form:hidden path="teamCityCiName"/> --%>
		<div>	 
			<div class="container">
				<div class="row"></div>
			</div>
		</div>
	
	    <div class="container container-margin">
	        <div class="panel-group" style="margin-bottom: 5px;" id="accordion"> 
				<c:forEach items="${jenkinsConfigDTO.jenkinsDTOList}" var="jenkinsDTOList" varStatus="status">
				  	<div class="panel" >	
		               	<form:hidden path="jenkinsDTOList[${status.index}].jenkinsId"/> 
						<form:hidden path="jenkinsDTOList[${status.index}].actionBy"/>
						<%-- <form:hidden path="jenkinsDTOList[${status.index}].ciName"/> --%>
		               	<div id="collapse3"  style="margin-top: 4px;" class="col-md-12 code-coverage border-color">
		                   	<div class="row">
		                    	<div class="form-group col-md-5 col-xs-5" style="margin-bottom: 5px;padding-right: 5px;"> 
				                    <label class=" col-sm-1 control-label" style="padding-right: 9px; padding-left:3px;">CI Name:</label>
				          	        <div style="padding-right: 16px; padding-left:8px;" class="col-md-4">
				           		  		<form:input type="text" path="jenkinsDTOList[${status.index}].jenkinsName" class="form-control borderform " id="jenkinsName" />
				                    </div>
				                    <label class=" col-sm-1 control-label" style="padding-right: 16px; padding-left:11px;">CI URL:</label>
				                    <div style="padding-right: 16px; padding-left:8px;" class="col-md-6">
				                        <form:input path="jenkinsDTOList[${status.index}].url" class="form-control borderform " />
				                    </div>
			                    </div> 
			                    <div class="form-group col-md-5 col-xs-5"  style="margin-bottom: 5px; padding-right: 2px; padding-left:0px;"> 
		                        	<label  class=" col-sm-2 control-label" style="padding-right: 0px; padding-left:1px;">User Name:</label>
		                            <div class="col-md-4"  style="padding-right: 6px; padding-left:0px;" >
		                                <form:input path="jenkinsDTOList[${status.index}].userName" class="form-control borderform " id="userName" />
		                            </div>
		                            <label  class=" col-sm-2 control-label">CI Password:</label>
		                            <div class="col-md-4"  style="padding-right: 6px; padding-left:6px;">
		                                <form:input path="jenkinsDTOList[${status.index}].pass" class="form-control borderform" id="pass" />                                
		                            </div>                           
			                     </div>
			                     <div class="form-group col-md-2 col-xs-2"  style="margin-bottom: 5px;padding-right: 1px; padding-left:0px; ">
		                        	<div class="col-md-9">
		                            	<form:select path="jenkinsDTOList[${status.index}].ciName" class="form-control borderform setting-input">
		                            		<form:option value="${jenkinsDTOList.ciName}">${jenkinsDTOList.ciName}</form:option>
		                            		<c:choose>
		                            			<c:when test="${jenkinsDTOList.ciName == 'Jenkins'}">
		                            				<form:option value="TeamCity">TeamCity</form:option>
		                            			</c:when>
		                            			<c:otherwise>
		                            				<form:option value="Jenkins">Jenkins</form:option>
		                            			</c:otherwise>
		                            		</c:choose>
			                            </form:select>
									</div>
		                           	<div class="col-md-3" style="margin-bottom: 5px;padding-right: 1px; padding-left:0px; ">
		                           		<a class="btn btn-danger" href="./deleteCIEngine?cIId=${jenkinsDTOList.jenkinsId}" onclick="loadAjax();">Delete</a>
									</div>
			                    </div> 
			            	</div>
			         	</div>
			   		</div> 
		      	</c:forEach>
	        </div>
		</div>
	 	<div>	 
			<div class="container">
				<div class="row">
				  	<div class="col-md-12 col-xs-12 pull-right text-right" style="margin:0px 20px 0px 0px">
			            <button type="button" class="btn btn-primary" id="executeBtn"  onclick="addNewRow();">Add</button>
			            <button type="submit" class="btn btn-primary" id="executeBtn"  onclick="loadAjax();">Submit</button>     
		        	</div>
				</div>
			</div>
		</div>
		 
		 <!-- <div>	 
			<div class="container">
				<div class="row">
				  <div class="col-md-12 col-xs-12 pull-right text-right" style="margin:0px 20px 0px 0px">
		            <button type="submit" class="btn btn-primary" id="addNew"  onclick="addConfiguration();">Add </button>
		        </div>
				</div>
			</div>
		 </div> -->
		
		<footer>
	    		<jsp:include page="footer.jsp"></jsp:include>
	    </footer>
	</form:form>
 
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
		
		var status=1;
		function addNewRow() {

	        var newRow =  "<div class='panel' id='newRow_"+status+"'>"	            
			+"<div id='collapse31'  style='margin-top: 4px;' class='col-md-12 code-coverage border-color'>"
            +"<div class='row'>"
                 +"<div class='form-group col-md-5 col-xs-5' style='margin-bottom: 5px;padding-right: 5px;'>"
                     +"<label style='padding-right: 9px; padding-left:3px;' class=' col-sm-1 control-label'>CI Name:</label>"
                         +"<div style='padding-right: 16px; padding-left:8px;' class='col-md-4'>"
							+"<input type='text' name='ciViewNameList' class='form-control borderform'/>"
                             +"</div>"
                         +"<label    class='col-sm-1 control-label'  style='padding-right: 16px; padding-left:11px;'>CI URL:</label>"
                         +"<div style='padding-right: 16px; padding-left:8px;' class='col-md-6'>"
                         +"<input type='text' name='ciCityUrl'class='form-control borderform'/>"
                             +"</div>"
                         +"</div>"
                     +"<div class='form-group col-md-5 col-xs-5'  style='margin-bottom: 5px; padding-right: 2px; padding-left:0px;'>"
                     +"<label class='col-sm-2 control-label' style='padding-right: 0px; padding-left:1px;'>CI User Name:</label>"
                     	+"<div  class='col-md-4'  style='padding-right: 6px; padding-left:0px;' >"
                         +"<input type='text' name='ciUserNameList' class='form-control borderform'/>"
                             +"</div>"
                         +"<label  class='col-sm-2 control-label'>CI Password:</label>"
                         +"<div class='col-md-4'  style='padding-right: 6px; padding-left:6px;'>"
                         +" <input type='text' name='ciPassList' class='form-control borderform'/>"
                             +"</div>"
                         +"</div>"
                         
                         +"<div class='form-group col-md-2 col-xs-2'  style='margin-bottom: 5px;padding-right: 1px; padding-left:0px; '>"
                         
                         +"<div class='col-md-9'>"
                         +"<select name=\"ciType\" class='form-control borderform setting-input'>"
                         +"<option value=\"Jenkins\">Jenkins</option>"
                         +"<option value=\"TeamCity\">TeamCity</option>"
                         +"</select>"
                         +"</div>"
                         +"<div  class='col-md-3' style='margin-bottom: 5px;padding-right: 1px; padding-left:0px; '>"
                         +"<input type='button' class=\"btn btn-primary\" onclick='removeElement(newRow_"+status+");' value='Remove'>"
                         +"</div>"
                         +"</div>"
                         
                     +"</div>"
             +"</div>"
         +"</div>";                       /*    required=\"required\"  */
         $("#accordion").append(newRow);
         status++;                       //alert(status);
		}
		
		function deleteData(elementId) {
			alert(elementId);
		}
		
		function removeElement(elemtId) {	
			$("#"+elemtId.id).remove();
		}
		
	</script>
</body>
</html>