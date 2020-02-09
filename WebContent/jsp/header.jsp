<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <div class="container">
	   <!-- Brand and toggle get grouped for better mobile display -->
	   <div class="navbar-header page-scroll">
	       <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	           <span class="sr-only">Toggle navigation</span>
	           <span class="icon-bar"></span>
	           <span class="icon-bar"></span>
	           <span class="icon-bar"></span>
	       </button>
		   <a href="./index" ><img src="img/about/LOGO.png" class="logo" id="logoNavigation"></a>
       </div>
       <!-- Collect the nav links, forms, and other content for toggling -->
       <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav navbar-right">
               <li class="hidden"><a href="#page-top"></a></li>
               <c:if test="${sessionScope.ROLE eq 'ROLE_ADMIN'}">
         			<li class="dropdown" style="margin-right:7px">
	                   	<a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">USERS
	                       <span class="caret"></span></a>
	                   	<ul class="dropdown-menu header-dropdown-products">
	                       	<li style="margin-top: 10px"><a href="./itapCreateUser"  onclick="loadAjax();">ADD	 USER</a>  </li>
	                       	<li class="dropdown-li-margin"><a href="./itapViewUsers"  onclick="loadAjax();">VIEW USER</a> </li>
	               		</ul>
               		</li>
               </c:if>
               <li class="dropdown" style="margin-right:7px">
                	<a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">SERVICES <span class="caret"></span></a>
                   	<ul class="dropdown-menu header-dropdown-products">
                       <li style="margin-top: 10px"><a href="./index#mainContainer"  onclick="loadAjax();">AGILE ACCEPTANCE TESTING</a>  </li>
                       <li class="dropdown-li-margin"><a href="./index#mainContainer"  onclick="loadAjax();">FUNCTIONAL TESTING</a> </li>
                       <li class="dropdown-li-margin"><a href="./index#mainContainer"  onclick="loadAjax();">CROSS BROWSER TESTING</a></li>
                       <li class="dropdown-li-margin"><a href="./index#mainContainer"  onclick="loadAjax();">MOBILE TESTING</a></li>
                       <li class="dropdown-li-margin"><a href="./index#mainContainer" onclick="loadAjax();">SERVICES/API TESTING</a></li>
                       <li class="dropdown-li-margin"><a href="./index#mainContainer" onclick="loadAjax();">MAINFRAME TESTING</a></li>
		               <li class="dropdown-li-margin dropdown-submenu"><a tabindex="-1" href="#">CONTINUOUS TESTING</a>
							<ul class="dropdown-menu" style="margin-left: 1px;    left: 100%;">
								<li><a tabindex="-1" href="./configuration?serverId=1" onclick="loadAjax();">TASK CONFIG</a></li>
								<li><a href="./itapBuildTrain" onclick="loadAjax();">BUILD TRAIN</a></li>
								<li><a href="./itapProgress?serId=1" onclick="loadAjax();">JOB PROGRESS</a></li>
							 </ul>
			  			</li>
					    <li class="dropdown-li-margin dropdown-submenu"><a tabindex="-1" href="#">Environment</a>
						   <ul class="dropdown-menu" style="margin-left: 1px;    left: 100%;">
							<li><a tabindex="-1" href="<spring:message code="link.smartfoundry" />" target="_blank">ENV BOOKING</a></li>
							<li><a href="<spring:message code="link.apporbit" />" target="_blank">ENV PROVISION</a></li>
							<li><a href="<spring:message code="link.vcmdb" />" target="_blank">ENV MONITORING</a></li>
							<li><a href="<spring:message code="link.live.itap.head" />" target="_blank">ENV DASHBOARD</a></li>
							<li><a href="<spring:message code="link.vcmdb" />" target="_blank">VISUAL CMDB</a></li>
				 		  </ul>
						</li>
                  	 </ul>
               </li>
               <li class="dropdown" style="margin-right:7px">
                   <a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">PRODUCTS <span class="caret"></span></a>
                   <ul class="dropdown-menu header-dropdown">
                       <li style="margin-top: 10px"><a href="./index#smart-agile" onclick="loadAjax();">SMART-AGILE</a></li>
                       <li class="dropdown-li-margin"><a href="./index#optik" onclick="loadAjax();">OPTIK</a></li>
                       <li class="dropdown-li-margin dropdown-submenu" onclick="loadAjax();"><a tabindex="-1" href="">CAFE</a>
                           <ul class="dropdown-menu" style="margin-left:1px ;  left: 100%;">
                               <li><a tabindex="-1" href="./index#CafeNext" onclick="loadAjax();">CAFE NEXT</a></li>
                               <li><a href="./index#cafe" onclick="loadAjax();">CAFE SELENIUM</a></li>
                               <li><a href="./index#cafeUFT" onclick="loadAjax();">CAFE UFT</a></li>
                               <li><a href="./index#mobile" onclick="loadAjax();">CAFE MOBILE</a></li>
                           </ul>
                       </li>
                       <li class="dropdown-li-margin dropdown-submenu" ><a tabindex="-1" href="">Sprintest</a>
                          <ul class="dropdown-menu" style="margin-left:1px ;  left: 100%;">
                               <li><a tabindex="-1" href="#" > XBT</a></li>
                               <li><a href="#"> CBF - Selenium</a></li>
                               <li><a href="#"> CBF - UFT</a></li>
                               <li><a href="#" > CBF - Eggplant</a></li>
                                <li><a href="#" > CBF - Seetest</a></li>
                           </ul>
                       </li>
                       <li class="dropdown-li-margin"><a href="./index#imda" onclick="loadAjax();">IMDA</a></li>
                       <li class="dropdown-li-margin"><a href="./index#twist" onclick="loadAjax();">TWIST</a></li>
                   </ul>
               </li>
               <li class="dropdown" style="margin-right:7px">
                   <a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">SETTINGS<span class="caret"></span></a>
                   <ul class="dropdown-menu header-dropdown header-enviorment header-dropdown-setting">
                   		<c:if test="${sessionScope.ROLE eq 'ROLE_ADMIN'}">
                   			<li style="margin-top: 10px"><a href="./jenkinsConfig" onclick="loadAjax();">CI CONFIGURATION</a></li>
	    					<li style="margin-top: 10px"><a href="./envConfig" onclick="loadAjax();">ENV CONFIGURATION</a></li>
							<li class="dropdown-li-margin"><a href="./config" onclick="loadAjax();">TOOL CONFIGURATION</a></li>
						</c:if>
	 					<li class="dropdown-li-margin dropdown-submenu"><a tabindex="-1" href="javascript:void(0)">JOB VIEW</a>
                       		<ul class="dropdown-menu" style="margin-left:1px;    left: 100%;">
                           		<li><a href="./configurationView?serId=1" onclick="loadAjax();">JENKINS</a></li>
                           		<li><a href="./configurationViewTeamCity?serId=2" onclick="loadAjax();">TEAMCITY</a></li>
                       		</ul>
                   		</li>
						<li class="dropdown-li-margin"><a href="./configurationTrainView" onclick="loadAjax();">TRAIN VIEW</a></li>
                   </ul>
               </li>
				<li style="margin-right:7px"><a class="page-scroll font-style" href="./itapProgress?serId=1">REPORTS</a></li>
               <li style="margin-right:4px"> <a class="page-scroll font-style" href="./index#contact" onclick="loadAjax();">CONTACT US</a> </li>
               <li style="margin-right:4px"><a href="<spring:message code="link.teamx" />" target="_blank">INNOVATE</a></li>
               <li style="margin-right:4px">
	  				<c:if test="${pageContext.request.userPrincipal.name != null}">
	     				<a href="javascript:document.getElementById('logout').submit();" title="Logout" onclick="loadAjax();">LOGOUT</a>
	  				</c:if>
	  				<c:url value="/logout?logout=true" var="logoutUrl" />
					<form id="logout" action="${logoutUrl}" method="post" >
					  		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
 				</li>
           </ul>
       </div>
       <!-- /.navbar-collapse -->
     </div>