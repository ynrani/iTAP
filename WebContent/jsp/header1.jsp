<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
	<div class="navbar-header page-scroll">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<img src="img/about/LOGO.png" class="logo">
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav navbar-right">
			<li class="hidden"><a href="#page-top"></a></li>
			<c:if test="${sessionScope.ROLE eq 'ROLE_ADMIN'}">
				<li class="dropdown" style="margin-right: 7px">
					<a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">USERS <span class="caret"></span></a>
					<ul class="main_nav dropdown-menu header-dropdown header-dropdownServices">
						<li style="margin-top: 10px"><a href="./itapCreateUser">ADD USER</a></li>
						<li class="dropdown-li-margin"><a href="./itapViewUsers">VIEW USER</a></li>
					</ul></li>
			</c:if>
			<li class="dropdown" style="margin-right: 7px">
				<a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">SERVICES <span class="caret"></span></a>
				<ul class="main_nav dropdown-menu header-dropdown header-dropdownServices">
					<li style="margin-top: 10px"><a href="#mainContainer" data-tab="service_tab1">AGILE ACCEPTANCE TESTING</a></li>
					<li class="dropdown-li-margin"><a href="#mainContainer" data-tab="service_tab2">FUNCTIONAL TESTING</a></li>
					<li class="dropdown-li-margin"><a href="#mainContainer" data-tab="service_tab3">CROSS BROWSER TESTING</a></li>
					<li class="dropdown-li-margin"><a href="#mainContainer" data-tab="service_tab4">MOBILE TESTING</a></li>
					<li class="dropdown-li-margin"><a href="#mainContainer" data-tab="service_tab5">SERVICES/API TESTING</a></li>
					<li class="dropdown-li-margin"><a href="#mainContainer" data-tab="service_tab6">MAINFRAME TESTING</a></li>
					<li class="dropdown-li-margin dropdown-submenu"><a tabindex="-1" href="#">CONTINUOUS TESTING</a>
						<ul class="dropdown-menu" style="margin-left: 1px; left: 100%;">
							<li><a tabindex="-1" href="./configuration?serverId=1">TASK CONFIG</a></li>
							<li><a href="./itapBuildTrain">BUILD TRAIN</a></li>
							<li><a href="./itapProgress?serId=1">JOB PROGRESS</a></li>
						</ul>
					</li>
					<li class="dropdown-li-margin dropdown-submenu"><a
						tabindex="-1" href="#">Environment</a>
						<ul class="dropdown-menu" style="margin-left: 1px; left: 100%;">
							<li><a tabindex="-1" href="<spring:message code="link.smartfoundry" />" target="_blank">ENV BOOKING</a></li>
							<li><a href="<spring:message code="link.apporbit" />" target="_blank">ENV PROVISION</a></li>
							<li><a href="<spring:message code="link.vcmdb" />" target="_blank">ENV MONITORING</a></li>
							<li><a href="<spring:message code="link.live.itap.head" />" target="_blank">ENV DASHBOARD</a></li>
							<li><a href="<spring:message code="link.vcmdb" />" target="_blank">VISUAL CMDB</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li class="dropdown" style="margin-right: 7px">
				<a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">PRODUCTS <span class="caret"></span></a>
				<ul class="dropdown-menu header-dropdown">
					<li style="margin-top: 10px"><a href="#smart-agile" data-content="c1" class="prod_display">SMART-AGILE</a></li>
					<li class="dropdown-li-margin"><a href="#optik" data-content="c2" class="prod_display">OPTIK</a></li>
					<li class="dropdown-li-margin dropdown-submenu"><a tabindex="-1" href="javascript:void(0)">CAFE</a>
						<ul class="dropdown-menu" style="margin-left: 1px; left: 100%;">
							<li><a tabindex="-1" href="#cafe-next" data-content="c3" class="prod_display">CAFE NEXT</a></li>
							<li><a href="javascript:void(0)">CAFE SELENIUM</a></li>
							<li><a href="javascript:void(0)">CAFE UFT</a></li>
							<li><a href="#cafe-mobile" class="prod_display" data-content="c4">CAFE MOBILE</a>
							</li>
						</ul>
					</li>
					<li class="dropdown-li-margin dropdown-submenu"><a tabindex="-1" href="">Sprintest</a>
						<ul class="dropdown-menu" style="margin-left: 1px; left: 100%;">
							<li><a tabindex="-1" href="#"> XBT</a></li>
							<li><a href="#"> CBF - Selenium</a></li>
							<li><a href="#"> CBF - UFT</a></li>
							<li><a href="#"> CBF - Eggplant</a></li>
							<li><a href="#"> CBF - Seetest</a></li>
						</ul>
					</li>
					<li class="dropdown-li-margin"><a href="#imda" data-content="c6" class="prod_display">IMDA</a></li>
					<li class="dropdown-li-margin"><a href="#twist" data-content="c5" class="prod_display">TWIST</a></li>
				</ul>
			</li>
			<li class="dropdown" style="margin-right: 7px">
				<a class="dropdown-toggle font-style" data-toggle="dropdown" href="#">SETTINGS <span class="caret"></span></a>
				<ul class="dropdown-menu header-dropdown settingDropdown-margin">
					<c:if test="${sessionScope.ROLE eq 'ROLE_ADMIN'}">
						<li style="margin-top: 10px"><a href="./jenkinsConfig">CI CONFIGURATION</a></li>
						<li style="margin-top: 10px"><a href="./envConfig">ENV CONFIGURATION</a></li>
						<li class="dropdown-li-margin"><a href="./config">TOOL CONFIGURATION</a></li>
					</c:if>
					<li class="dropdown-li-margin dropdown-submenu"><a tabindex="-1" href="javascript:void(0)">JOB VIEW</a>
						<ul class="dropdown-menu" style="margin-left: 1px; left: 100%;">
							<li><a href="./configurationView?serId=1">JENKINS</a></li>
							<li><a href="./configurationViewTeamCity?serId=2">TEAMCITY</a></li>
						</ul>
					</li>
					<li class="dropdown-li-margin"><a href="./configurationTrainView">TRAIN VIEW</a></li>
					<li class="dropdown-li-margin"><a href="./newNode">New Node</a></li>
				</ul>
			</li>
			<li style="margin-right: 7px"><a class="page-scroll font-style" href="./itapProgress?serId=1">REPORTS</a></li>
			<!--<li style="margin-right:7px"> <a class="page-scroll font-style" href="#about">ABOUT US</a></li>-->
			<li style="margin-right: 4px"><a class="page-scroll font-style" href="#contact">CONTACT US</a></li>
			<li style="margin-right: 4px"><a href="<spring:message code="link.teamx" />" target="_blank">INNOVATE</a></li>
			<li style="margin-right: 4px">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<a href="javascript:document.getElementById('logout').submit();" title="Logout">LOGOUT</a>
				</c:if>
				<c:url value="/logout?logout=true" var="logoutUrl" />
				<form id="logout" action="${logoutUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</li>
			<div class="clearfix"></div>
		</ul>
	</div><!-- /.navbar-collapse -->
</div>
<div id="ajaxloader" class="modal" style="display: none">
	<div class="center">
		<img alt="" src="assets/img/loader.gif" />
	</div>
</div>