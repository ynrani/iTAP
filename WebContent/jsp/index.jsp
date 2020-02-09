<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>iTAP | Index</title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <link href="css/agency.css" rel="stylesheet"> <!--    <link href="css/ihover.css" rel="stylesheet"> -->
 	
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
 
</head>
<body id="page-top" class="index">

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top ">
    <jsp:include page="header1.jsp"></jsp:include>
    <!-- /.container-fluid -->
</nav>
<!-- Header -->
<br>
	<header id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Indicators -->
	    <div class="container container-width" style="padding: 0 0;">
	        <ol class="carousel-indicators">
	            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	            <li data-target="#myCarousel" data-slide-to="1"></li>
	            <li data-target="#myCarousel" data-slide-to="2"></li>
	            <li data-target="#myCarousel" data-slide-to="3"></li>
	        </ol>
	        <!-- Wrapper for slides -->
	        <div class="carousel-inner" role="listbox">
	            <div class="item active" style="height:100%;float:none">
	                <img src="img/about/slider2.jpg" alt="Chania">
	                <div class="carousel-caption carousal-heading-margin">
	                    <div>
	                        <h1 class="carousal-color"> ONE STOP SHOP FOR ALL AUTOMATION NEEDS</h1>
	                    </div>
	                </div>
	            </div>
	            <div class="item" style="height:100%;float:none">
	                <img src="img/about/slider1.jpg" alt="Chania">
	                <div class="carousel-caption carousal-heading-margin">
	                    <div>
	                        <h1 class="carousal-color">Seamless integration with a host of testing tools and services</h1>
	                    </div>
	                </div>
	            </div>
	            <div class="item" style="height:100%;float:none">
	                <img src="img/about/slider3.jpg" alt="Chania">
	                <div class="carousel-caption carousal-heading-margin">
	                    <div>
	                        <h1 class="carousal-color">SUPPORTS MOBILE AND DESKTOP PLATFORMS</h1>
	                    </div>
	                </div>
	            </div>
	            <div class="item" style="height:100%;float:none">
	                <!--<video width="100%" height="800px" controls> <source src="ITAP.mp4" type="video/mp4"></video> -->
	                <img src="img/about/slider1.jpg" alt="Chania">
	                <div class="carousel-caption carousal-heading-margin">
	                    <div>
	                        <h1 class="carousal-color">CONTINUOUS TEST ENGINE</h1>          
	                    </div>
	                </div>
	            </div>
	        </div>
	        <!-- Left and right controls -->
	        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
	            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	            <span class="sr-only">Previous</span>
	        </a>
	        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	            <span class="sr-only">Next</span>
	        </a>
	    </div>
	</header>

	<!-- Services Section -->
	<section id="agileTesting">
	    <div class="container sections-margin">
	        <div class="row">
	            <div class="col-lg-12 text-center">
	                <h2 class="section-heading sectionheading-fontfamily">ITAP</h2>
	            </div>
	        </div>
	        <div class="row">
	            <div class="" id="featuresList">
	                <div class="col-md-4">
	                    <ul class="">
	                        <li>Unmanned execution through orchestrated continuous testing module</li>
	                        <li>Self service automation delivery platform enabled for DevOps and Digital automation requirements</li>
	                        <li>Integration with Test Management Tools and comprehensive reporting & analytics capabilities</li>
	                    </ul>
	                </div>
	                <div class="col-md-4">
	                    <ul class="">
	                    	<li>Comes with enriching features of configurable continuous
	                            automation functions to support DevOps work needs and Pre-Existing integrations
	                        </li>
	                        <li>Seamless adoption to mobile and omni-channel platforms/technologies with right in-house test 
	                        	environment with Mobile technologies and cloud environment for digital 
	                        </li>
	                    </ul>
	                </div>
	                <div class="col-md-4">
	                    <ul class="">
	                        <li>Built for progressive automation with capability to drive
	                            BDD, UI, services/APIs and backend test automation across the lifecycle
	                        </li>
	                        <li><!--<i class="fa fa-circle" style="font-size: xx-small;"></i> -->Enriching features including 
	                        	script-less solutions for ease of use, embedded quality gates, scheduler for unattended test runs, 
	                        	On-Demand Infrastructure provisions
	                        </li>
	                  	</ul>
	               	</div>
	                <!--<p>Self service automation delivery platform enabled for DevOps and Digital automation requirements
	                    Comes with enriching features of configurable continuous automation functions to support DevOps work
	                    needs and Pre-Existing integrations seamless adoption to mobile and omni-channel platforms/technologies with 
	                    right in-house test environment with Mobile technologies and cloud environment for digital Built for 
	                    progressive automation with capability to drive BDD, UI, services/APIs and backend test automation across the 
	                    lifecycle Enriching features including script-less solutions for ease of use, embedded quality gates, 
	                    scheduler for unattended test runs, On-Demand Infrastructure provisions Integration with Test Management 
	                    Tools and comprehensive reporting & analytics capabilities</p>-->
	                <!-- <p class="text-muted textleft" style="margin-top:20px"></p>
	                <p class="text-muted textleft" style="margin-top:20px"></p>
	                <p class="text-muted textleft" style="margin-top:20px"></p>
	                <p class="text-muted textleft" style="margin-top:20px"></p>-->
	            </div>
	        </div>
	        <div>
	            <div class="row" style="padding-top: 50px;">
	                <div class="col-md-12 agileTesting_icons text-center">
	                    <div class="col-md-6 col-xs-6 producst-border">
	                        <img src="img/about/PRODUCTS.png" class="image-center">
	                        <h3>Services</h3>
	                    </div>
	                    <div class="col-md-6 col-xs-6 ">
	                        <img src="img/about/SERVICES.png" class="image-center">
	                        <h3>Products</h3>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>
	
	<section id="functionalTesting">
	    <div class="services-header" id="mainContainer">
	        <div class="col-lg-12 text-center">
	            <img src="img/about/SERVICES.png">
	            <h4 class="section-heading sectionheading-fontfamily">SERVICES</h4>
	        </div>
	        <div class="clearfix"></div>
	    </div>
	    <div id="services_tabs" class="container sections-margin services_cont">
	        <div class="row text-center">
	            <nav class="services_nav">
	                <a href="#" class="active" data-tab="service_tab1">AGILE</a>
	                <a href="#" data-tab="service_tab2">FUNCTIONAL</a>
	                <a href="#" data-tab="service_tab3">CROSS BROWSER</a>
	                <a href="#" data-tab="service_tab4">MOBILE</a>
	                <a href="#" data-tab="service_tab5">API</a>
	                <a href="#" data-tab="service_tab6">MAINFRAME TESTING</a>
	            </nav>
	        </div>
	        <div class="services_tabs">
	            <div class="row text-justify services-top service_tab1" id="mobile">
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m1.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted ">BDD driven Acceptance Testing</p>
	                    <p class="text-muted ">Automated Acceptance criteria defined in story</p>
	                    <p class="text-muted ">Centralized management of features</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m2.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Story acceptance criteria defined in Gherkhin Language</p>
	                    <p class="text-muted text-align">Gherkhin format - Given, when, then</p>
	                    <p class="text-muted text-align">Acceptance test reports at multiple levels</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M3.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Organize and manage features</p>
	                    <p class="text-muted text-align">Structured Acceptance test reports</p>
	                    <p class="text-muted text-align">Supports Progression Automation within Sprints</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M4.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">BDD driven Progression Automation of Features within Sprints</p>
	                    <p class="text-muted text-align">Integration with Agile project management tools</p>
	                    <p class="text-muted text-align">Integrated with Rally and HP ALM</p>
	                </div>
	            </div>
	            <div class="row text-center services-top service_tab2" style="display:none;" id="devops">
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m1.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Selenium based scriptless as well as scripted automation frameworks</p>
	                    <p class="text-muted text-align">Supports regression, multibrowser testing and faster script development</p>
	                    <p class="text-muted text-align">Reusable and easy to maintain</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m2.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">UFT based test automation framework Supports Desktop, Web, Java, .NET and 
	                    	Mainframe applications</p>
	                    <p class="text-muted text-align">Component based test design technique</p>
	                    <p class="text-muted text-align">Supports regression, multibrowser testing and faster script development
	                    </p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M3.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Integration with HP ALM using simple web interface or Excel add-in</p>
	                    <p class="text-muted text-align">Scheduled test execution for unmanned execution</p>
	                    <p class="text-muted text-align">Reduces dependency on automation testing skills through scriptless automation
	                    </p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M4.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Integrated with Saucelabs and Browserstack for cloud based front end testing
	                    </p>
	                    <p class="text-muted text-align">Integrated with Seetest and Perfecto for mobile testing</p>
	                    <p class="text-muted text-align">Integrates with Jenkins for continuous testing
	                    </p>
	                </div>
	            </div>
	            <div class="row text-center services-top service_tab3" style="display:none;" id="devops">
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m1.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Selenium based automated front end testing tool</p>
	                    <p class="text-muted text-align">Supports regression, multibrowser testing and faster script development</p>
	                    <p class="text-muted text-align">Compatible with multiple operating system and browser combinations</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m2.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Works on open source technology</p>
	                    <p class="text-muted text-align">Scriptless record and play feature for automated test case generation</p>
	                    <p class="text-muted text-align">Supports parallel execution on multiple systems</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M3.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Inter browser user interface comparison</p>
	                    <p class="text-muted text-align">Inter environment site analysis</p>
	                    <p class="text-muted text-align">Website UI analysis against base version</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M4.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Intergrated with Saucelabs and Browserstack for cloub based testing</p>
	                    <p class="text-muted text-align">Integrated with Seetest and Perfecto for mobile testing</p>
	                    <p class="text-muted text-align">Automated screenshot capture, scheduler and auto-rerun facility</p>
	                </div>
	            </div>
	            <div class="row text-center services-top service_tab4" style="display:none;" id="devops">
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m1.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Supports Native, Web and Hybrid mobile application automation</p>
	                    <p class="text-muted text-align">Support for Mobiles - Android and iOS</p>
	                    <p class="text-muted text-align">Coverage for Functional, Regression, Cross browser testing</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m2.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Single Script. Multiple Labs. Cross platform testing.</p>
	                    <p class="text-muted text-align">Execution control through a single XML or Excel file</p>
	                    <p class="text-muted text-align">Build and easily mainten test scripts across app changes or platform/OS
	                    	 changes</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M3.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Customizable and easy to read reports</p>
	                    <p class="text-muted text-align">Seamless integration with cloud device providers like - Perfecto, SeeTest</p>
	                    <p class="text-muted text-align">Integrated with ALM for Reporting</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M4.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Works with CI tools like Jenkins</p>
	                    <p class="text-muted text-align">UFT, Selenium, Java Enabled</p>
	                    <p class="text-muted text-align">Supporting sequential or parallel execution</p>
	                </div>
	            </div>
	            <div class="row text-center services-top service_tab5" style="display:none;" id="devops">
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m1.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Enables communication and data exchange between two separate software 
	                    	systems</p>
	                    <p class="text-muted text-align">Rest API supports both XML and JSON format</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m2.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Work on SoapUI using Groovy script and VB script</p>
	                    <p class="text-muted text-align">Twist supports Rest API testing</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M3.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Capture the response from a web services</p>
	                    <p class="text-muted text-align">Verifies the behaviour of the API which is considering the
	                        pre-defined external environment conditions</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M4.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Exports the response in the XML format</p>
	                    <p class="text-muted text-align">XPath assertion applies a specified XPath expression to the
	                        received message and validates the resulting nodes against an expected value</p>
	                </div>
	            </div>
	            <div class="row text-center services-top service_tab6" style="display:none;" id="devops">
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m1.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Accelerated automation solution platform</p>
	                    <p class="text-muted text-align">Scheduled job trains</p>
	                    <p class="text-muted text-align">Easy configuration of Job Train</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/m2.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">DevOps enabled Continuous Testing</p>
	                    <p class="text-muted text-align">Automated defect management</p>
	                    <p class="text-muted text-align">Smart configurator</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M3.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">One click end-to-end execution</p>
	                    <p class="text-muted text-align">Left Shift to capture testing quality</p>
	                    <p class="text-muted text-align">Intelligent analytics and decision making</p>
	                </div>
	                <div class="col-md-3 col-xs-6 col-sm-6">
	                    <img src="img/about/M4.png" alt="defaultImage" class="services-image-width">
	                    <p class="text-muted text-align">Smart assets</p>
	                    <p class="text-muted text-align">Real Time CIA Design and Orchestration capability</p>
	                    <p class="text-muted text-align">Quality gates embedded within continuous testing</p>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>

	<section id="mobileTesting">
	    <div class="sections-margin">
	        <div class="row">
	            <div class="services-header">
	                <div class="col-lg-12 text-center">
	                    <img src="img/about/PRODUCTS.png">
	                    <h4 class="section-heading sectionheading-fontfamily">PRODUCTS</h4>
	                </div>
	                <div class="clearfix"></div>
	            </div>
	        </div>
	    </div>
	    <div class="products_items">
	        <div class="p_item col-md-6 col-xs-12 left p1" id="smart-agile">
	            <div class="p_content c1p" data-content="c1">
	                <h3 style="font-size: 30px;">SMART-AGILE</h3>
	            </div>
	            <div class="p_content_hover c1">
	                <div style="display: table-cell;vertical-align: middle;">
	                    <h3>SMART AGILE</h3>
	                    <p>
	                        SmartAgile Automation Framework implements the BDD approach for automating
	                        the Acceptance Criteria defined in the User Stories ensuring "Progression Automation" of
	                        features being developed within the Sprints. The progression automation of features for the
	                        current sprints also functions as "Regression tests" of future sprints. SmartAgile automation
	                        framework interfaces with Rally for importing Acceptance Criteria, creating feature definition
	                        files automatically and also integrates with CIA (Continuous Integration Automation)
	                        <a href="http://in-pnq-coe07:8090/CSS_BDD/" target="_blank"  style="font-size:18px">Launch Application</a>
	                    </p>
	                </div>
	
	            </div>
	        </div>
	        <div class="p_item col-md-6 col-xs-12 left p2" id="optik">
	            <div class="p_content c2p" data-content="c2">
	                <h3 style="font-size: 30px;">OPTIK</h3>
	            </div>
	            <div class="p_content_hover c2">
	                <div style="display: table-cell;vertical-align: middle;">
	                    <h3>Optik</h3>
	                    <p style="font-size:16px">Hybrid, reusable, platform independent, automated front end testing tool
	                        that bridges the gap between increasing demand for automated solutions and scarcity of
	                        automation resources. It sports multiple features and doubles up as a functional test automation
	                        tool as well as a multi OS/browser UI comparison tool. It can run on multiple PCs and devices in
	                        parallel and save time and efforts in a testing project
	                        <a href="http://in-pnq-coe19:8081/OPTIK/landing" target="_blank" style="font-size:18px">Launch Application
	                        </a>
	                    </p>
	                </div>
	            </div>
	        </div>
	        <div class="p_item col-md-6 col-xs-12 left p3" id="cafe-next">
	            <div class="p_content c3p" data-content="c3">
	                <h3 style="font-size: 30px;">CAFE NEXT</h3>
	            </div>
	            <div class="p_content_hover c3">
	                <div style="display: table-cell;vertical-align: middle;">
	                    <h3>CAFE NEXT</h3>
	                    <p style="font-size:16px">A unified test design and automation solution. It's a customizable
	                        framework working over the UFT engine. Supports parallel execution, multi browser execution and
	                        also mobile using Seetest. CI enabled with Jenkins and can be easily extended with other tools.
	                        Based on BPT/ Reusable component based architecture. Generates automatically english like
	                        functional test cases and automation test cases at the same time and are integrated with ALM.
	                        Suitable for both SDLC and Progressive automation. Dependency on Automation skillet/expertize is
	                        reduced to a greater extent
	                        <a href="http://in-pnq-coe30/cafenext_v3/login.php" target="_blank" style="font-size:18px">Launch
	                            Application</a>
	                    </p>
	                </div>
	            </div>
	        </div>
	        <div class="p_item col-md-6 col-xs-12 left p4" id="cafe-mobile">
	            <div class="p_content c4p" data-content="c4">
	                <h3 style="font-size: 30px;">CAFE MOBILE</h3>
	            </div>
	            <div class="p_content_hover c4">
	                <div style="display: table-cell;vertical-align: middle;">
	                    <h3>CAFE MOBILE</h3>
	                    <p style="font-size:16px">Cafe Mobile is a customizable framework working over UFT engine that
	                        provides automation capabilities for latest and popular Mobile platforms. This flexible
	                        framework Supports Execution for Functional, Cross browser and Cross platform testing over
	                        Mobile Browsers, Native App testing over handheld devices, Emulators and Cloud Devices. <a
	                                href="cafemobile/index.html" target="_blank"  style="font-size:18px">Launch Application</a>
	                    </p>
	                </div>
	            </div>
	        </div>
	        <div class="p_item col-md-6 col-xs-12 left p5" id="twist">
	            <div class="p_content c5p" data-content="c5">
	                <h3 style="font-size: 30px;">TWIST</h3>
	            </div>
	            <div class="p_content_hover c5">
	                <div style="display: table-cell;vertical-align: middle;">
	                    <h3>TWIST</h3>
	                    <p style="font-size:16px">Quick, easy and flexible XPath based approach to testing SOAP, XML, Json
	                        messages using TWIST
	                        tool by request and response XMLs
	                        <br>Key Features<br>
	                        End to end Web service and API testing solution<br>
	                        Template based test case execution<br>
	                        Easy to create and modify test data and assertion without opening the tool<br>
	                        Quick and easy to change the endpoint for execution<br>
	                        Allows saving the request and response file for future references<br>
	                        Underlying extensible code is used in groovy and VB scripting
	                        <a href="TWIST/TWIST/index.html" target="_blank"  style="font-size:18px">Launch Application</a>
	                    </p>
	                </div>
	            </div>
	        </div>
	        <div class="p_item col-md-6 col-xs-12 left p6" id="imda">
	            <div class="p_content c6p" data-content="c6">
	                <h3 style="font-size: 30px;">IMDA</h3>
	            </div>
	            <div class="p_content_hover c6">
	                <div style="display: table-cell;vertical-align: middle;">
	                    <h3>IMDA</h3>
	                    <p style="font-size:16px">Intelligent Mainframe Data Accelerator (IMDA) reduces the dependency on
	                        automation skills through use of keywords and built-in libraries. It can reult in reduction of
	                        up to 80-85% efforts in coding through script-less automation. It integrates with mainframe
	                        emulators' recording capabilities to build the test automation suite and can be clubbed with
	                        other automation tools like QTP, Selenium
	                        <!--<a href="Cafe_Selenium/Cafe_Selenium/index.html" style="font-size:18px">Launch Application</a>-->
	                        <a href="cafemobile/comingsoon.html" target="_blank" style="font-size:18px">Launch Application</a>
	                    </p>
	                </div>
	            </div>
	        </div>
	         <div class="clearfix"></div>
	    </div>
	</section>
 	<div class="clearfix"></div>
 
	<section class="capabilities">
	    <div class="text-center p10"></div>
	    <div class="row">
	        <div class="container">
	            <div class="col-md-4">
	                <div class="cap_container">
	                    <div class="media">
	                        <p class="media-left cap_lt media-middle"> Approximately</p>
	                        <p class="media-left cap_speed">5x</p>
	                        <div class="media-body">
	                            <p class="text-justify">faster test script authoring through script-less test automation solutions</p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="col-md-4">
	                <div class="cap_container">
	                    <div class="media">
	                        <p class="media-left cap_lt media-middle"> Upto </p>
	                        <p class="media-left cap_speed"> 50% </p>
	                        <div class="media-body">
	                            <p class="text-justify">reduction in overall test execution efforts in front end testing due
	                                to parallel testing capability</p>
	                        </div>
	                    </div>
	                    <div class="clearfix"></div>
	                </div>
	            </div>
	            <div class=" col-md-4">
	                <div class="cap_container">
	                    <div class="media">
	                        <p class="media-left cap_lt media-middle"> Upto </p>
	                        <p class="media-left cap_speed"> 30% </p>
	                        <div class="media-body">
	                            <p class="text-justify">improvement in scrum team velocity through agile test automation techniques</p>
	                        </div>
	                    </div>
	                </div>
	            </div>
	            <div class="clearfix"></div>
	            <div class="cap_vdo_container col-md-9 col-xs-12 center-block">
	                <div class="col-md-8">
	                    <div class="cap_vdo">
	                        <!-- <img class="img-responsive" src="img/about/vdo_temp.png"alt=""> -->
	                        <video width="500" id="vdotag" controls>
	                            <source src="ITAP.mp4" type="video/mp4">
	                        </video>
	                    </div>
	                </div>
	                <div class="col-md-4 text-center">
	                    <div class="col-md-12 cap_icons">
	                        <div class="cap_vdo_item col-sm-6 col-md-12 col-xs-12">
	                            <div class="cap-icon">
	                                <img class="img-responsive" src="img/about/correct.png" alt="">
	                            </div>
	                            <div class="cap-content">Script-less Automations! <br> Manual testers can</div>
	                        </div>
	                        <div class="cap_vdo_item col-sm-6 col-md-12 col-xs-12">
	                            <div class="cap-icon">
	                                <img class="img-responsive" src="img/about/conti.png" alt="">
	                            </div>
	                            <div class="cap-content">Script-less Automations! <br> Manual testers can </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="clearfix"></div>
	                <!--<div class="cap_footer">
	                    <p> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam at corporis dignissimos dolores
	                        doloribus eaque est facere facilis fugiat fugit id, inventore ipsam laudantium magnam natus nihil
	                        odio officia porro quibusdam quis, repellendus sit, tempore ullam unde ut vero voluptatem!
	                        Asperiores culpa distinctio illo illum in iusto, laboriosam nihil quas? </p>
	                </div>-->
	            </div>
	        </div>
		</div>
	</section>
	
	<!--<section class="about_us" id="about">
	<div class="about_bg">
		<div class="row"><div class="container"><h3>About Us</h3>
				<div class="about_content"> 
					<div class="col-md-6"> 
						<p>	Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dicta, iste. Architecto aperiam harum ut, vel quaerat tempore 
						commodi voluptate obcaecati laboriosam expedita minima odio itaque quod ratione sapiente corporis ea quae odit nulla dolores 
						dolorem aspernatur. Consectetur obcaecati ipsum eaque libero officiis natus, a eos. Officiis voluptates, nostrum beatae. Eligendi</p>
					</div>
					<div class="col-md-6">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo voluptatibus hic sunt iure voluptatum velit ipsa? 
						Nam eos beatae, voluptas, nostrum earum in repudiandae cum quam vitae quia repellat ipsa eveniet harum velit soluta aut quaerat 
						doloribus excepturi? Error quas, ad dicta animi nesciunt quibusdam, optio repellendus odit quaerat voluptatibus!</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>-->
	<section class="contact_us " id="contact">
	    <div class="contact_bg">
	        <div class="row">
	            <div class="container text-center">
	                <h3>Contact Us</h3>
	                <!--<span class="contact_tagline text-italic">Lorem ipsum dolor sit amet, consectetur.</span>-->
	                     <div class="contact_content">
	                    <p>AutoHUB is an initiative by the FS Testing Technology Center Of Excellence
	                            <br>For any queries or assistance on AutoHUB, please send an email to 
	                        		<a class="contact_mail" href="mailto:testingtcoe_itap.fssbu@capgemini.com" target="_top">
	                        		testingtcoe_itap.fssbu@capgemini.com</a>
	                    </p>
	                    <div class="col-md-6 col-sm-6 text-right contact_right_p">
		                    <p>Lorem ipsum dolor sit amet. <br>Lorem ipsum dolor. <br>Lorem ipsum dolor sit. </p>
	                    </div>
	                    <div class="col-md-6 col-sm-6 text-left contact_left_p">
		                    <p>Lorem ipsum dolor sit amet. <br> Lorem ipsum dolor sit amet. <br>Lorem ipsum dolor sit amet. 
		                    	<br>Lorem ipsum dolor sit amet.<br>
		                    </p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</section>
	
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>   
	</footer>
	
	<!-- Portfolio Modals -->
	<!-- Use the modals below to showcase details about your portfolio projects! -->
	<!-- Portfolio Modal 1 -->
	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	
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
	    $('#myCarousel').on('slide', function () {
	        $('.blocky').fadeIn(600).animate({marginLeft: "+=12%"}, 200).animate({marginLeft: "-=15%"}, 300).animate({marginLeft: "+=4%"}, 600);
	    })
	    // $('.carousel').carousel();
	    //    $('.carousel').on('slide.bs.carousel', function () {  $('.carousel-caption').animate({  
	    //		marginLeft: "+=20%", fontSize: "1px", opacity: 0, width:"100%"}, 50);
	    //     });
	    //     $('.carousel').on('slid.bs.carousel', function () {  $('.carousel-caption').animate({
	    //             marginLeft: 0, fontSize: "55px", opacity: 0.8}, 600);
	    //     });
	    $('#cafeNextLaunch').click(function () {
	        var redirectWindow = window.open('Cafe_Next/index.html');
	        redirectWindow.location;
	    });
	    $('#cafeMobileLaunch').click(function () {
	        var redirectWindow = window.open('cafemobile/index.html');
	        redirectWindow.location;
	    });
	    $('#cafeUFTClickLaunch').click(function () {
	        var redirectWindow = window.open('Cafe_UFT/Cafe_UFT/index.html');
	        redirectWindow.location;
	    });
	    $('#cafeSeleiumnlaunch').click(function () {
	        var redirectWindow = window.open('Cafe_Selenium/Cafe_Selenium/index.html');
	        redirectWindow.location;
	    });
	
	    $('#twistlaunch').click(function () {
	        var redirectWindow = window.open('TWIST/TWIST/index.html ');
	        redirectWindow.location;
	    });
	    $("#devopsMain").click(function (event) {
	        var id = event.id;
	        console.log(id);
	        $("#devops").show();
	        $("#mobile").hide();
	        document.getElementById('devopsMain').style.color = '#00A2fe';
	    });
	
	    $(window).resize(function () {
	        location.reload();
	    });
	
	    $(".p_item").mouseenter(function () {
                var data_content = $(this).children('.p_content').attr("data-content");
//                $(this).children('.p_content').fadeOut(function () { $("." + data_content).fadeIn();})
                $(this).children('.p_content').css({'display': 'none'});
                if ($(window).width() < 768) {
                    $(this).height("auto");
                }
                $("." + data_content).fadeIn();
            }
	    );
	
	    $(".prod_display").click( function () {
            var data_anchor = $(this).attr("href");
            var data_content=$(this).attr("data-content");
//          $(this).children('.p_content').fadeOut(function () { $("." + data_content).fadeIn(); })
	         $('html, body').animate({
	             scrollTop: $(data_anchor).offset().top-100
	         }, 1000);                
         	 $(".p_item").children('.p_content.' + data_content + 'p').css({'display': 'none'});
	         $(".p_content_hover").not("." + data_content).fadeOut();
	          if ($(window).width() < 768) {
	              $(".p_item").height("auto");
	          }
       		  $("." + data_content).fadeIn();
            }
	    );
	
	    $(".p_item").mouseleave(function () {
	          var data_content = $(this).children('.p_content').attr("data-content");
	          $("." + data_content).fadeOut(function () {
	              $("." + data_content + "p").fadeIn();
	          })
	          if ($(window).width() < 768) {
	              $(this).height(100);
	          }
	      });
	
	    $(".services_nav a").click(function (event) {
	        event.preventDefault();
	        var tab = $(this).attr("data-tab");
	        $("." + tab).siblings().css({'display': 'none'});
	        // $("."+tab).siblings().hide(function(){
	        $("." + tab).fadeIn();
	        // });
	        $(this).siblings().removeClass("active");
	        $(this).addClass("active");
	    });
	
	    $(".main_nav a").click(function (event) {
	        var tab = $(this).attr("data-tab");
	        $("." + tab).siblings().css({'display': 'none'});
	        // $("."+tab).siblings().hide(function(){
	        $("." + tab).fadeIn();
	        // });
	        var active_link = $(".services_nav a[data-tab=" + tab + "]");
	        $(active_link).siblings().removeClass("active");
	        $(active_link).addClass("active");
	    });
	
	    $(document).ready(function() {
			$("#ajaxloader").hide();
		} );
	</script>
	
</body>
</html>