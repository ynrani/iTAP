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
<title>iTAP | Job List</title>
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
<link href="css/bootstrap.min.css" rel="styleshee" type="text/css" />
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
					<h1 class="configg-heading label-color headingfont-size">CI JOBS</h1>
				</div>
			</div>
		</div>
		<!-- <div class="modal alert-danger" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
			<div class="modal-content"> -->
			<div id="myModal" class="modal fade">
  		<div class="modal-dialog">
   				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">Warning</h4>
					</div>
					<div class="modal-body">Are you sure want to delete All Selected Jobs</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
						<input type="button" id="confirmDelete" class="btn btn-danger btn-sm" onclick="deleteSelectedJobs();" value="Yes" />
						<!-- <button id="yes" type="button" class="btn btn-danger"> Yes</button> -->
					</div>
				</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
		</div>
	</section>

	<form:form id="itapConfigDTOForm" name="itapConfigDTOForm" action="${pageContext.request.contextPath}/configuration" method="POST"
	 modelAttribute="itapConfigDTO">

		<input type="hidden" name="serId" value="1" /> 		
		<div class="container">
		<!-- /.modal -->
			<div class="panel-group" id="accordion" style="margin-top: 20px;">
				<c:choose>
					<c:when test="${itapConfigDTOs ne null}">
						<table id="tableSort" class="table table-striped table-bordered">
							<thead>
								<tr>
									<th style="width:10%;"><input type="checkbox" id="check_main_1" onchange="selectAllTable();" /> &nbsp;
										<input type="button" id="deleteAll" class="btn btn-danger btn-xs" onclick="showModal();"
										disabled="disabled" value="Delete"></input></th>
									<th>Edit</th>
									<th>Delete</th>
									<th>Job Name</th>
									<th>Status</th>
									<th>Build ?</th>
								</tr>
							</thead>
							<tbody id="body">
								<c:forEach items="${itapConfigDTOs}" var="itapConfigDTOs"
									varStatus="status">
									<tr>
										<td align="left">
											<form:checkbox id="check_${status.index}" path="allJobs" value="${itapConfigDTOs.jobName}" 
											onclick="checkToDelete(check_${status.index});"/>
										</td>
										<td align="left" id="td_${status.index}"><a class="btn btn-success" 
											id="check_${status.index}_Edit" href="./configuration?id=${itapConfigDTOs.jobName}&serverId=1"
											 onclick="loadAjax();">Edit</a></td>
										<td align="left"><a class="btn btn-danger" id="check_${status.index}_Del" 
											href="./deleteConfiguration?id=${itapConfigDTOs.jobName}&serverId=1"
											onclick="loadAjax();">Delete</a></td>
										<td align="left">${itapConfigDTOs.jobName}</td>
										<td align="left">${itapConfigDTOs.sts}</td>
										<td align="left"><a class="btn btn-success" id="check_${status.index}_Build" 
											href="./configurationJobBuild?id=${itapConfigDTOs.jobName}&serId=1"
											onclick="loadAjax();">Build</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<div class="col-md-12">
							<h1 class="page-subhead-line">No Jobs are available</h1>
						</div>
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
	<script charset="utf-8" type="text/javascript">

	var deleteJobsCounter = 0;	
	
	function showModal(){	
		$('#myModal').modal({
        	show: true
        }); 
	}
	
	function selectAllTable() {
		var selectVals = $("#tableSort_info").text()+"";
		var nons = parseInt(selectVals.substring(selectVals.lastIndexOf("of")+2, selectVals.lastIndexOf("ent")));
		var tem = 0;
		for(i=0;i<nons;i++) {	
			tem = i;
			var tempId = "check_"+i;
			var edit=tempId+"_Edit";
			var del=tempId+"_Del";
			var build=tempId+"_Build";
			if($('#check_main_1').prop("checked") == true) {
				deleteJobsCounter = deleteJobsCounter+1;
				$('#'+build).attr( "disabled", true);
				$('#'+edit).attr( "disabled", true);
				$('#'+del).attr( "disabled", true);
				$('#'+tempId).closest('tr').find('a').addClass('disabled'); //document.getElementById(tempId).checked=true;
				$('#'+tempId).prop("checked",true);
			}
			else {
				deleteJobsCounter = deleteJobsCounter-1;
				$('#'+build).attr( "disabled", false);
				$('#'+edit).attr( "disabled", false);
				$('#'+del).attr( "disabled", false);
				$('#'+tempId).closest('tr').find('a').removeClass('disabled');
				$('#'+tempId).prop("checked",false); //document.getElementById(tempId).checked=false;
			}
		}	
		enableDelete();	
	}
	
	function deleteSelectedJobs() {
		var url = "./deleteMultipleConfiguration" ;//obj.href;
		document.getElementById('itapConfigDTOForm').action = url;
		document.getElementById('itapConfigDTOForm').submit(); 
	} 
	
	function enableDelete() { 
		var checkArray= $('#body').find('tr').find('input[type=checkbox]');
		var size=checkArray.length;
		var temp = 0;
		for(i=0;i<size;i++) {
			if(checkArray[i].checked == true){ //$('deleteAll').attr( "disabled", false );
				$("#deleteAll").prop('disabled', false); //$('input[type="submit"]').prop('disabled', false);
				break;
			}
			temp++;
		}
		if(temp == size) {
			$("#deleteAll").prop('disabled', true);
		}
	}

	function checkToDelete(id){
		var check_id=id.id;
		var edit=id.id+"_Edit";
		var del=id.id+"_Del";
		var build=id.id+"_Build";
	 	if($('#'+check_id).prop("checked") == true){
	 	$('#'+check_id).closest('tr').find('a').addClass('disabled'); //document.getElementById(edit).disabled;
	 		deleteJobsCounter = deleteJobsCounter+1;
	 		$('#td_0').attr( "disabled", true ); //$('#td1').attr( "disabled", true );
	 		$('#'+edit).attr( "disabled", true );
	 		$('#'+del).attr( "disabled", true);
	 		$('#'+build).attr( "disabled", true);
	    }
	    else{
	 		deleteJobsCounter = deleteJobsCounter-1; //document.getElementById(edit).enabled;
	    	$('#check_main_1').prop( "checked", false);
	    	$('#'+edit).attr( "disabled", false );
	    	$('#'+del).attr( "disabled", false);
	    	$('#'+build).attr( "disabled", false);
	    	$('#'+check_id).closest('tr').find('a').removeClass('disabled');
	    } 
	 	enableDelete();
	}

    $(document).ready(function() {
    	 $('#tableSort').DataTable();
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
        $('#myModal').modal({
        	show: false
         });  
      
    });
  	function checkboxCheck(){
     	if(document.getElementById("#sourceconfigId").checked){
   			alert("hello");   
      	}     
 	}
     
   	$(document).ready(function() {
 		$("#ajaxloader").hide();
 	});

</script>
</body>
</html>