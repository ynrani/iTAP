<html>

<head resURL="/jenkins/static/ec65755e" data-rooturl="/jenkins" data-resurl="/jenkins/static/ec65755e">
	<title>Jenkins</title>
	<link rel="stylesheet" href="/jenkins/static/ec65755e/css/layout-common.css" type="text/css" />
	<link rel="stylesheet" href="/jenkins/static/ec65755e/css/style.css" type="text/css" />
	<link rel="stylesheet" href="/jenkins/static/ec65755e/css/color.css" type="text/css" />
	<link rel="stylesheet" href="/jenkins/static/ec65755e/css/responsive-grid.css" type="text/css" />
	<link rel="shortcut icon" href="/jenkins/static/ec65755e/favicon.ico" type="image/vnd.microsoft.icon" />
	<link color="black" rel="mask-icon" href="/jenkins/images/mask-icon.svg" />
	
	<script>
		var isRunAsTest = false;
		var rootURL = "/jenkins";
		var resURL = "/jenkins/static/ec65755e";
	</script>
	
	<script src="/jenkins/static/ec65755e/scripts/prototype.js" type="text/javascript"></script>
	<script src="/jenkins/static/ec65755e/scripts/behavior.js" type="text/javascript"></script>
	<script src="/jenkins/adjuncts/ec65755e/org/kohsuke/stapler/bind.js" type="text/javascript"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/yahoo/yahoo-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/dom/dom-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/event/event-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/animation/animation-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/dragdrop/dragdrop-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/container/container-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/connection/connection-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/datasource/datasource-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/autocomplete/autocomplete-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/menu/menu-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/element/element-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/button/button-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/yui/storage/storage-min.js"></script>
	<script src="/jenkins/static/ec65755e/scripts/hudson-behavior.js" type="text/javascript"></script>
	<script src="/jenkins/static/ec65755e/scripts/sortable.js" type="text/javascript"></script>
	
	<script>
		crumb.init("", "");
	</script>
	
	<link rel="stylesheet" href="/jenkins/static/ec65755e/scripts/yui/container/assets/container.css" type="text/css" />
	<link rel="stylesheet" href="/jenkins/static/ec65755e/scripts/yui/assets/skins/sam/skin.css" type="text/css" />
	<link rel="stylesheet" href="/jenkins/static/ec65755e/scripts/yui/container/assets/skins/sam/container.css" type="text/css" />
	<link rel="stylesheet" href="/jenkins/static/ec65755e/scripts/yui/button/assets/skins/sam/button.css" type="text/css" />
	<link rel="stylesheet" href="/jenkins/static/ec65755e/scripts/yui/menu/assets/skins/sam/menu.css" type="text/css" />
	<link rel="search" href="/jenkins/opensearch.xml" type="application/opensearchdescription+xml" title="Jenkins" />
	
	<meta name="ROBOTS" content="INDEX,NOFOLLOW" />
	<script src="/jenkins/adjuncts/ec65755e/org/kohsuke/stapler/jquery/jquery.full.js" type="text/javascript"></script>
	
	<script>
		var Q = jQuery.noConflict()
	</script>
	
	<script src="/jenkins/static/ec65755e/scripts/yui/cookie/cookie-min.js"></script>
	<script src="/jenkins/static/ec65755e/jsbundles/page-init.js" type="text/javascript"></script>
</head>

<body data-model-type="hudson.model.ComputerSet" id="jenkins"
	class="yui-skin-sam jenkins-2.11 two-column" data-version="2.11">
	<a href="#skip2content" class="skiplink">Skip to content</a>
	<div id="page-head">
		<div id="header">
			<div class="logo">
				<a id="jenkins-home-link" href="/jenkins/"><img
					src="/jenkins/static/ec65755e/images/headshot.png" alt="title"
					id="jenkins-head-icon" /><img
					src="/jenkins/static/ec65755e/images/title.png" alt="title"
					width="139" id="jenkins-name-icon" height="34" /></a>
			</div>
			<div class="login"></div>
			<div class="searchbox hidden-xs">
				<form method="get" name="search" action="/jenkins/computer/search/"
					style="position: relative;" class="no-json">
					<div id="search-box-minWidth"></div>
					<div id="search-box-sizer"></div>
					<div id="searchform">
						<input name="q" placeholder="search" id="search-box"
							class="has-default-text" /> <a
							href="http://wiki.jenkins-ci.org/display/JENKINS/Search+Box"><img
							src="/jenkins/static/ec65755e/images/16x16/help.png"
							style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a>
						<div id="search-box-completion"></div>
						<script>
							createSearchBox("/jenkins/computer/search/");
						</script>
					</div>
				</form>
			</div>
		</div>
		<div id="breadcrumbBar">
			<tr id="top-nav">
				<td id="left-top-nav" colspan="2"><link rel="stylesheet"
						href="/jenkins/adjuncts/ec65755e/lib/layout/breadcrumbs.css"
						type="text/css"/>
					<script src="/jenkins/adjuncts/ec65755e/lib/layout/breadcrumbs.js"
						type="text/javascript"></script>
					<div class="top-sticker noedge">
						<div class="top-sticker-inner">
							<div id="right-top-nav"></div>
							<ul id="breadcrumbs">
								<li class="item"><a href="/jenkins/"
									class="model-link inside">Jenkins</a></li>
								<li href="/jenkins/" class="children"></li>
								<li class="item"><a href="/jenkins/computer/"
									class=" inside">Nodes</a></li>
								<li href="/jenkins/computer/" class="children"></li>
							</ul>
							<div id="breadcrumb-menu-target"></div>
						</div>
					</div></td>
			</tr>
		</div>
	</div>
	<div id="page-body" class="clear">
		<div id="side-panel">
			<div id="tasks">
				<div class="task">
					<a href="/jenkins/" class="task-icon-link"><img
						src="/jenkins/static/ec65755e/images/24x24/up.png"
						style="width: 24px; height: 24px; width: 24px; height: 24px; margin: 2px;"
						class="icon-up icon-md" /></a> <a href="/jenkins/" class="task-link">Back
						to Dashboard</a>
				</div>
				<div class="task">
					<a href="/jenkins/manage" class="task-icon-link"><img
						src="/jenkins/static/ec65755e/images/24x24/gear2.png"
						style="width: 24px; height: 24px; width: 24px; height: 24px; margin: 2px;"
						class="icon-gear2 icon-md" /></a> <a href="/jenkins/manage"
						class="task-link">Manage Jenkins</a>
				</div>
				<div class="task">
					<a href="new" class="task-icon-link"><img
						src="/jenkins/static/ec65755e/images/24x24/new-computer.png"
						style="width: 24px; height: 24px; width: 24px; height: 24px; margin: 2px;"
						class="icon-new-computer icon-md" /></a> <a href="new"
						class="task-link">New Node</a>
				</div>
				<div class="task">
					<a href="configure" class="task-icon-link"><img
						src="/jenkins/static/ec65755e/images/24x24/gear2.png"
						style="width: 24px; height: 24px; width: 24px; height: 24px; margin: 2px;"
						class="icon-gear2 icon-md" /></a> <a href="configure"
						class="task-link">Configure</a>
				</div>
			</div>
			<div id="buildQueue"
				class="container-fluid pane-frame track-mouse expanded">
				<div class="row">
					<div class="col-xs-24 pane-header">
						<a href="/jenkins/toggleCollapse?paneId=buildQueue"
							title="collapse" class="collapse"><img
							src="/jenkins/static/ec65755e/images/16x16/collapse.png"
							alt="collapse" style="width: 16px; height: 16px;"
							class="icon-collapse icon-sm" /></a>Build Queue
					</div>
				</div>
				<div class="row pane-content">
					<table class="pane ">
						<tr>
							<td class="pane" colspan="2">No builds in the queue.</td>
						</tr>
					</table>
				</div>
			</div>
			<script defer="defer">
				refreshPart('buildQueue', "/jenkins/ajaxBuildQueue");
			</script>
			<div id="executors"
				class="container-fluid pane-frame track-mouse expanded">
				<div class="row">
					<div class="col-xs-24 pane-header">
						<a href="/jenkins/toggleCollapse?paneId=executors"
							title="collapse" class="collapse"><img
							src="/jenkins/static/ec65755e/images/16x16/collapse.png"
							alt="collapse" style="width: 16px; height: 16px;"
							class="icon-collapse icon-sm" /></a><a href='/jenkins/computer/'>Build
							Executor Status</a>
					</div>
				</div>
				<div class="row pane-content">
					<table class="pane ">
						<colgroup>
							<col width="30" />
							<col width="200*" />
							<col width="24" />
						</colgroup>
						<tr></tr>
						<tr>
							<td class="pane" align="right" style="vertical-align: top">1</td>
							<td class="pane">Idle</td>
							<td class="pane"></td>
							<td class="pane"></td>
						</tr>
						<tr>
							<td class="pane" align="right" style="vertical-align: top">2</td>
							<td class="pane">Idle</td>
							<td class="pane"></td>
							<td class="pane"></td>
						</tr>
					</table>
				</div>
			</div>
			<script defer="defer">
				refreshPart('executors', "/jenkins/ajaxExecutors");
			</script>
		</div>
		<div id="main-panel">
			<a name="skip2content"></a>
			<form method="post" name="config" action="doCreateItem">
				<table width="100%">
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">Name</td>
						<td class="setting-main"><input
							checkMessage="Name is mandatory" name="name" type="text"
							class="setting-input   required" value="dasf" /></td>
						<td class="setting-help"><a
							helpURL="/jenkins/descriptor/hudson.slaves.DumbSlave/help/name"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: Name" style="width: 16px; height: 16px;"
								class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">Description</td>
						<td class="setting-main"><input name="_.nodeDescription"
							type="text" class="setting-input   " value="" /></td>
						<td class="setting-help"><a
							helpURL="/jenkins/help/system-config/master-slave/description.html"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: Description"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name"># of executors</td>
						<td class="setting-main"><input checkDependsOn="" default="1"
							min="1" step="1"
							checkUrl="/jenkins/descriptorByName/hudson.slaves.DumbSlave/checkNumExecutors"
							name="_.numExecutors" type="number"
							class="setting-input validated positive-number" value="1" /></td>
						<td class="setting-help"><a
							helpURL="/jenkins/descriptor/hudson.slaves.DumbSlave/help/numExecutors"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: # of executors"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">Remote root directory</td>
						<td class="setting-main"><input checkDependsOn=""
							checkUrl="/jenkins/descriptorByName/hudson.slaves.DumbSlave/checkRemoteFS"
							name="_.remoteFS" type="text" class="setting-input validated  "
							value="" /></td>
						<td class="setting-help"><a
							helpURL="/jenkins/descriptor/hudson.slaves.DumbSlave/help/remoteFS"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: Remote root directory"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">Labels</td>
						<td class="setting-main"><input name="_.labelString"
							type="text" class="setting-input   " value="" /></td>
						<td class="setting-help"><a
							helpURL="/jenkins/descriptor/hudson.slaves.DumbSlave/help/labelString"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: Labels"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">Usage</td>
						<td class="setting-main"><select name="mode"
							class="setting-input"><option value="NORMAL">Use
									this node as much as possible</option>
								<option value="EXCLUSIVE">Only build jobs with label
									expressions matching this node</option></select></td>
						<td class="setting-help"><a
							helpURL="/jenkins/help/system-config/master-slave/usage.html"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: Usage" style="width: 16px; height: 16px;"
								class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">Launch method</td>
						<td class="setting-main"><select
							class="setting-input dropdownList"><option
									value="hudson.slaves.JNLPLauncher">Launch agent via
									Java Web Start</option>
								<option value="hudson.slaves.CommandLauncher">Launch
									agent via execution of command on the master</option>
								<option value="hudson.plugins.sshslaves.SSHLauncher">Launch
									slave agents on Unix machines via SSH</option>
								<option value="hudson.os.windows.ManagedWindowsServiceLauncher">Let
									Jenkins control this Windows slave as a Windows service</option></select></td>
						<td class="setting-help"><a
							helpURL="/jenkins/descriptor/hudson.slaves.DumbSlave/help/launcher"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: Launch method"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="dropdownList-container">
						<td colspan="2"></td>
						<td colspan="2"><table width="100%" name="slave.launcher">
								<tr class="dropdownList-start rowvg-start"></tr>
								<tr style="display: none">
									<td><input name="stapler-class" type="hidden"
										value="hudson.slaves.JNLPLauncher" /><input name="$class"
										type="hidden" value="hudson.slaves.JNLPLauncher" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td><script
											src="/jenkins/adjuncts/ec65755e/lib/form/advanced/advanced.js"
											type="text/javascript"></script>
										<div style="" class="advancedLink">
											<span style="display: none" id="id29281"><img
												src="/jenkins/static/ec65755e/images/24x24/notepad.png"
												tooltip="One or more fields in this block have been edited."
												style="width: 24px; height: 24px; vertical-align: baseline"
												class="icon-notepad icon-md" /></span> <input type="button"
												value="Advanced..." class="advanced-button advancedButton" />
										</div>
										<table class="advancedBody">
											<tbody>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Tunnel connection through</td>
													<td class="setting-main"><input name="_.tunnel"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/help/system-config/master-slave/jnlp-tunnel.html"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Tunnel connection through"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">JVM options</td>
													<td class="setting-main"><input name="_.vmargs"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.slaves.JNLPLauncher/help/vmargs"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: JVM options"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
											</tbody>
										</table></td>
									<td></td>
								</tr>
								<tr class="dropdownList-end rowvg-end"></tr>
								<tr class="dropdownList-start rowvg-start"></tr>
								<tr style="display: none">
									<td><input name="stapler-class" type="hidden"
										value="hudson.slaves.CommandLauncher" /><input name="$class"
										type="hidden" value="hudson.slaves.CommandLauncher" /></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Launch command</td>
									<td class="setting-main"><input checkDependsOn=""
										checkUrl="/jenkins/descriptorByName/hudson.slaves.CommandLauncher/checkCommand"
										name="_.command" type="text" class="setting-input validated  "
										value="" /></td>
									<td class="setting-help"><a
										helpURL="/jenkins/descriptor/hudson.slaves.CommandLauncher/help/command"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: Launch command"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr class="dropdownList-end rowvg-end"></tr>
								<tr class="dropdownList-start rowvg-start"></tr>
								<tr style="display: none">
									<td><input name="stapler-class" type="hidden"
										value="hudson.plugins.sshslaves.SSHLauncher" /><input
										name="$class" type="hidden"
										value="hudson.plugins.sshslaves.SSHLauncher" /></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Host</td>
									<td class="setting-main"><input name="_.host" type="text"
										class="setting-input   " value="" /></td>
									<td class="setting-no-help"></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Credentials</td>
									<td class="setting-main"><link rel="stylesheet"
											href="/jenkins/adjuncts/ec65755e/lib/credentials/select/select.css"
											type="text/css" />
										<script
											src="/jenkins/adjuncts/ec65755e/lib/credentials/select/select.js"
											type="text/javascript"></script>
										<div class="credentials-select-control">
											<div
												class="credentials-select-content-select credentials-select-content-active">
												<script
													src="/jenkins/adjuncts/ec65755e/lib/form/select/select.js"
													type="text/javascript"></script>


												<select
													fillUrl="/jenkins/descriptorByName/hudson.plugins.sshslaves.SSHLauncher/fillCredentialsIdItems"
													fillDependsOn="host port" name="_.credentialsId"
													class="setting-input  select  credentials-select" value=""></select> 
												<button class="credentials-add" type="button"
													onclick="return window.credentials.add();">
													<img
														src="/jenkins/static/ec65755e/plugin/credentials/images/16x16/new-credential.png"
														alt="" /> Add
												</button>
											</div>
										</div>
										<script></script></td>
									<td class="setting-help"><a
										helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/credentialsId"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: Credentials"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td><div style="" class="advancedLink">
											<span style="display: none" id="id29282"><img
												src="/jenkins/static/ec65755e/images/24x24/notepad.png"
												tooltip="One or more fields in this block have been edited."
												style="width: 24px; height: 24px; vertical-align: baseline"
												class="icon-notepad icon-md" /></span> <input type="button"
												value="Advanced..." class="advanced-button advancedButton" />
										</div>
										<table class="advancedBody">
											<tbody>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Port</td>
													<td class="setting-main"><input default="22"
														name="_.port" type="text" class="setting-input   "
														value="22" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/port"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Port"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">JavaPath</td>
													<td class="setting-main"><input name="_.javaPath"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/javaPath"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: JavaPath"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">JVM Options</td>
													<td class="setting-main"><input name="_.jvmOptions"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/jvmOptions"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: JVM Options"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Prefix Start Slave Command</td>
													<td class="setting-main"><input
														name="_.prefixStartSlaveCmd" type="text"
														class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/prefixStartSlaveCmd"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Prefix Start Slave Command"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Suffix Start Slave Command</td>
													<td class="setting-main"><input
														name="_.suffixStartSlaveCmd" type="text"
														class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/suffixStartSlaveCmd"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Suffix Start Slave Command"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Connection Timeout in Seconds</td>
													<td class="setting-main"><input
														name="launchTimeoutSeconds" type="text"
														class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/launchTimeoutSeconds"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Connection Timeout in Seconds"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Maximum Number of Retries</td>
													<td class="setting-main"><input name="maxNumRetries"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/maxNumRetries"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Maximum Number of Retries"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Seconds To Wait Between
														Retries</td>
													<td class="setting-main"><input name="retryWaitTime"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.plugins.sshslaves.SSHConnector/help/retryWaitTime"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Seconds To Wait Between Retries"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
											</tbody>
										</table></td>
									<td></td>
								</tr>
								<tr class="dropdownList-end rowvg-end"></tr>
								<tr class="dropdownList-start rowvg-start"></tr>
								<tr style="display: none">
									<td><input name="stapler-class" type="hidden"
										value="hudson.os.windows.ManagedWindowsServiceLauncher" /><input
										name="$class" type="hidden"
										value="hudson.os.windows.ManagedWindowsServiceLauncher" /></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name"></td>
									<td class="setting-main">This launch method relies on DCOM
										and is often associated with <a
										href="https://wiki.jenkins-ci.org/display/JENKINS/Windows+slaves+fail+to+start+via+DCOM"
										target="_blank">subtle problems</a>. Consider using <b>Launch
											slave agents using Java Web Start</b> instead, which also permits
										installation as a Windows service but is generally considered
										more reliable.
									</td>
									<td class="setting-no-help"></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Administrator user name</td>
									<td class="setting-main"><input name="_.userName"
										type="text" class="setting-input   " value="" /></td>
									<td class="setting-help"><a
										helpURL="/jenkins/descriptor/hudson.os.windows.ManagedWindowsServiceLauncher/help/userName"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: Administrator user name"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Password</td>
									<td class="setting-main"><input name="_.password"
										type="password" class="setting-input " value="" /></td>
									<td class="setting-no-help"></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Host</td>
									<td class="setting-main"><input name="_.host" type="text"
										class="setting-input   " value="" /></td>
									<td class="setting-help"><a
										helpURL="/jenkins/descriptor/hudson.os.windows.ManagedWindowsServiceLauncher/help/host"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: Host"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Run service as</td>
									<td class="setting-main"><select
										class="setting-input dropdownList"><option value="0">Use
												Local System User</option>
											<option value="1">Log on using a different account</option>
											<option value="2">Use Administrator account given
												above</option></select></td>
									<td class="setting-no-help"></td>
								</tr>
								<tr class="dropdownList-container">
									<td colspan="2"></td>
									<td colspan="2"><table width="100%" name="account">
											<tr class="dropdownList-start rowvg-start"></tr>
											<tr class="render-on-demand "
												proxy="makeStaplerProxy('/jenkins/$stapler/bound/69fe2bc9-a931-4a23-9bbc-19770c6f5ece','0e3f1b52-f8f0-462b-80bf-6531e7e4aaeb',['render'])"></tr>
											<tr style="display: none">
												<td><input name="stapler-class" type="hidden"
													value="hudson.os.windows.ManagedWindowsServiceAccount$LocalSystem" /><input
													name="$class" type="hidden"
													value="hudson.os.windows.ManagedWindowsServiceAccount$LocalSystem" /></td>
											</tr>
											<tr class="dropdownList-end rowvg-end"></tr>
											<tr class="dropdownList-start rowvg-start"></tr>
											<tr class="render-on-demand "
												proxy="makeStaplerProxy('/jenkins/$stapler/bound/0df754fc-3787-43b7-86eb-84dda26c8b77','0e3f1b52-f8f0-462b-80bf-6531e7e4aaeb',['render'])"></tr>
											<tr style="display: none">
												<td><input name="stapler-class" type="hidden"
													value="hudson.os.windows.ManagedWindowsServiceAccount$AnotherUser" /><input
													name="$class" type="hidden"
													value="hudson.os.windows.ManagedWindowsServiceAccount$AnotherUser" /></td>
											</tr>
											<tr class="dropdownList-end rowvg-end"></tr>
											<tr class="dropdownList-start rowvg-start"></tr>
											<tr class="render-on-demand "
												proxy="makeStaplerProxy('/jenkins/$stapler/bound/75970ae8-742c-4c45-b435-22584ae3c7fe','0e3f1b52-f8f0-462b-80bf-6531e7e4aaeb',['render'])"></tr>
											<tr style="display: none">
												<td><input name="stapler-class" type="hidden"
													value="hudson.os.windows.ManagedWindowsServiceAccount$Administrator" /><input
													name="$class" type="hidden"
													value="hudson.os.windows.ManagedWindowsServiceAccount$Administrator" /></td>
											</tr>
											<tr class="dropdownList-end rowvg-end"></tr>
										</table></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td><div style="" class="advancedLink">
											<span style="display: none" id="id29283"><img
												src="/jenkins/static/ec65755e/images/24x24/notepad.png"
												tooltip="One or more fields in this block have been edited."
												style="width: 24px; height: 24px; vertical-align: baseline"
												class="icon-notepad icon-md" /></span> <input type="button"
												value="Advanced..." class="advanced-button advancedButton" />
										</div>
										<table class="advancedBody">
											<tbody>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">Path to java executable</td>
													<td class="setting-main"><input name="_.javaPath"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-help"><a
														helpURL="/jenkins/descriptor/hudson.os.windows.ManagedWindowsServiceLauncher/help/javaPath"
														href="#" class="help-button"><img
															src="/jenkins/static/ec65755e/images/16x16/help.png"
															alt="Help for feature: Path to java executable"
															style="width: 16px; height: 16px;"
															class="icon-help icon-sm" /></a></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
												<tr class="help-area">
													<td></td>
													<td colspan="2"><div class="help">Loading...</div></td>
													<td></td>
												</tr>
												<tr>
													<td class="setting-leftspace"> </td>
													<td class="setting-name">JVM options</td>
													<td class="setting-main"><input name="_.vmargs"
														type="text" class="setting-input   " value="" /></td>
													<td class="setting-no-help"></td>
												</tr>
												<tr class="validation-error-area">
													<td colspan="2"></td>
													<td></td>
													<td></td>
												</tr>
											</tbody>
										</table></td>
									<td></td>
								</tr>
								<tr class="dropdownList-end rowvg-end"></tr>
							</table></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">Availability</td>
						<td class="setting-main"><select
							class="setting-input dropdownList"><option
									value="hudson.slaves.RetentionStrategy$Always">Keep
									this agent online as much as possible</option>
								<option value="hudson.slaves.SimpleScheduledRetentionStrategy">Take
									this agent online according to a schedule</option>
								<option value="hudson.slaves.RetentionStrategy$Demand">Take
									this agent online when in demand, and offline when idle</option></select></td>
						<td class="setting-help"><a
							helpURL="/jenkins/help/system-config/master-slave/availability.html"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: Availability"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="dropdownList-container">
						<td colspan="2"></td>
						<td colspan="2"><table width="100%"
								name="slave.retentionStrategy">
								<tr class="dropdownList-start rowvg-start"></tr>
								<tr style="display: none">
									<td><input name="stapler-class" type="hidden"
										value="hudson.slaves.RetentionStrategy$Always" /><input
										name="$class" type="hidden"
										value="hudson.slaves.RetentionStrategy$Always" /></td>
								</tr>
								<tr class="dropdownList-end rowvg-end"></tr>
								<tr class="dropdownList-start rowvg-start"></tr>
								<tr style="display: none">
									<td><input name="stapler-class" type="hidden"
										value="hudson.slaves.SimpleScheduledRetentionStrategy" /><input
										name="$class" type="hidden"
										value="hudson.slaves.SimpleScheduledRetentionStrategy" /></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Startup Schedule</td>
									<td class="setting-main"><textarea
											name="retentionStrategy.startTimeSpec" rows="5"
											class="setting-input validated  "
											checkUrl="'/jenkins/retentionStrategy/SimpleScheduledRetentionStrategy/check?value='+encodeURIComponent(this.value)"></textarea>
										<div class="textarea-handle"></div></td>
									<td class="setting-help"><a
										helpURL="/jenkins/descriptor/hudson.triggers.TimerTrigger/help/spec"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: Startup Schedule"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Scheduled Uptime</td>
									<td class="setting-main"><input
										checkMessage="Scheduled Uptime is mandatory and must be a number."
										min="0" name="retentionStrategy.upTimeMins" type="number"
										class="setting-input  required number" value="" /></td>
									<td class="setting-no-help"></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="2"></td>
									<td class="setting-description">The number of minutes to
										keep the node up for. If this is longer than the startup
										schedule, then the node will remain constantly on-line.</td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Keep online while jobs are
										running</td>
									<td class="setting-main"><input
										name="retentionStrategy.keepUpWhenActive" checked="true"
										type="checkbox" class="  " /></td>
									<td class="setting-help"><a
										helpURL="/jenkins/help/system-config/master-slave/demand/keepUpWhenActive.html"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: Keep online while jobs are running"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr class="dropdownList-end rowvg-end"></tr>
								<tr class="dropdownList-start rowvg-start"></tr>
								<tr style="display: none">
									<td><input name="stapler-class" type="hidden"
										value="hudson.slaves.RetentionStrategy$Demand" /><input
										name="$class" type="hidden"
										value="hudson.slaves.RetentionStrategy$Demand" /></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">In demand delay</td>
									<td class="setting-main"><input
										checkMessage="In demand delay is mandatory and must be a number."
										min="0" name="retentionStrategy.inDemandDelay" type="number"
										class="setting-input  required number" value="" /></td>
									<td class="setting-help"><a
										helpURL="/jenkins/help/system-config/master-slave/demand/inDemandDelay.html"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: In demand delay"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr>
									<td class="setting-leftspace"> </td>
									<td class="setting-name">Idle delay</td>
									<td class="setting-main"><input
										checkMessage="Idle delay is mandatory and must be a number."
										min="0" name="retentionStrategy.idleDelay" type="number"
										class="setting-input  required number" value="" /></td>
									<td class="setting-help"><a
										helpURL="/jenkins/help/system-config/master-slave/demand/idleDelay.html"
										href="#" class="help-button"><img
											src="/jenkins/static/ec65755e/images/16x16/help.png"
											alt="Help for feature: Idle delay"
											style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
								</tr>
								<tr class="validation-error-area">
									<td colspan="2"></td>
									<td></td>
									<td></td>
								</tr>
								<tr class="help-area">
									<td></td>
									<td colspan="2"><div class="help">Loading...</div></td>
									<td></td>
								</tr>
								<tr class="dropdownList-end rowvg-end"></tr>
							</table></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<link rel="stylesheet"
						href="/jenkins/adjuncts/ec65755e/lib/form/section_.css"
						type="text/css" />
					<script src=/jenkins/adjuncts/ec65755e/lib/form/section_.js"
						type="text/javascript"></script>
					<tr name="nodeProperties" style="display: none"
						class="row-set-start row-group-start"></tr>
					<tr>
						<td colspan="4"><div class="section-header">Node
								Properties</div></td>
					</tr>
					<tr class="stapler-class-bag">
						<td><input type="hidden" name="stapler-class-bag"
							value="true" /></td>
					</tr>
					<tr class="optional-block-start row-group-start row-set-start"
						hasHelp="false">
						<td colspan="3"><input
							onclick="javascript:updateOptionalBlock(this,true)"
							name="hudson-slaves-EnvironmentVariablesNodeProperty"
							type="checkbox" class="optional-block-control block-control  " /><label
							class="attach-previous">Environment variables</label></td>
						<td class="setting-no-help"></td>
					</tr>
					<tr class="rowvg-start"></tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">List of variables</td>
						<td class="setting-main"><script
								src="/jenkins/adjuncts/ec65755e/lib/form/dragdrop/dragdrop.js"
								type="text/javascript"></script>
							<script
								src="/jenkins/adjuncts/ec65755e/lib/form/repeatable/repeatable.js"
								type="text/javascript"></script>
							<div class="repeated-container">
								<div name="env" class="repeated-chunk to-be-removed">
									<table width="100%">
										<tr>
											<td class="setting-leftspace"> </td>
											<td class="setting-name">Name</td>
											<td class="setting-main"><input name="env.key"
												type="text" class="setting-input   " value="" /></td>
											<td class="setting-no-help"></td>
										</tr>
										<tr class="validation-error-area">
											<td colspan="2"></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td class="setting-leftspace"> </td>
											<td class="setting-name">Value</td>
											<td class="setting-main"><input name="env.value"
												type="text" class="setting-input   " value="" /></td>
											<td class="setting-no-help"></td>
										</tr>
										<tr class="validation-error-area">
											<td colspan="2"></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td class="setting-leftspace"> </td>
											<td class="setting-name"></td>
											<td class="setting-main"><div align="right">
													<input type="button" title="Delete" value="Delete"
														class="repeatable-delete danger" />
												</div></td>
											<td class="setting-no-help"></td>
										</tr>
										<tr class="validation-error-area">
											<td colspan="2"></td>
											<td></td>
											<td></td>
										</tr>
									</table>
								</div>
								<div class="repeatable-insertion-point"></div>
								<input type="button" value="Add" class="repeatable-add" />
							</div></td>
						<td class="setting-help"><a
							helpURL="/jenkins/help/system-config/nodeEnvironmentVariables.html"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: List of variables"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr class="row-set-end rowvg-end optional-block-end row-group-end"></tr>
					<tr class="optional-block-start row-group-start row-set-start"
						hasHelp="false">
						<td colspan="3"><input
							onclick="javascript:updateOptionalBlock(this,true)"
							name="hudson-tools-ToolLocationNodeProperty" type="checkbox"
							class="optional-block-control block-control  " /><label
							class="attach-previous">Tool Locations</label></td>
						<td class="setting-no-help"></td>
					</tr>
					<tr class="rowvg-start"></tr>
					<tr>
						<td class="setting-leftspace"> </td>
						<td class="setting-name">List of tool locations</td>
						<td class="setting-main"><div class="repeated-container">
								<div name="locations" class="repeated-chunk to-be-removed">
									<table width="100%">
										<tr>
											<td class="setting-leftspace"> </td>
											<td class="setting-name">Name</td>
											<td class="setting-main"><select class="setting-input"
												name="locations.key"><option
														value="hudson.tasks.Ant$AntInstallation$DescriptorImpl@ANT">(Ant)
														ANT</option>
													<option
														value="hudson.plugins.sonar.SonarRunnerInstallation$DescriptorImpl@sonar">(SonarQube
														Scanner) sonar</option></select></td>
											<td class="setting-no-help"></td>
										</tr>
										<tr class="validation-error-area">
											<td colspan="2"></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td class="setting-leftspace"> </td>
											<td class="setting-name">Home</td>
											<td class="setting-main"><input name="locations.home"
												type="text" class="setting-input   " value="" /></td>
											<td class="setting-no-help"></td>
										</tr>
										<tr class="validation-error-area">
											<td colspan="2"></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td class="setting-leftspace"> </td>
											<td class="setting-name"></td>
											<td class="setting-main"><div align="right">
													<input type="button" title="Delete" value="Delete"
														class="repeatable-delete danger" />
												</div></td>
											<td class="setting-no-help"></td>
										</tr>
										<tr class="validation-error-area">
											<td colspan="2"></td>
											<td></td>
											<td></td>
										</tr>
									</table>
								</div>
								<div class="repeatable-insertion-point"></div>
								<input type="button" value="Add" class="repeatable-add" />
							</div></td>
						<td class="setting-help"><a
							helpURL="/jenkins/help/tools/tool-location-node-property.html"
							href="#" class="help-button"><img
								src="/jenkins/static/ec65755e/images/16x16/help.png"
								alt="Help for feature: List of tool locations"
								style="width: 16px; height: 16px;" class="icon-help icon-sm" /></a></td>
					</tr>
					<tr class="validation-error-area">
						<td colspan="2"></td>
						<td></td>
						<td></td>
					</tr>
					<tr class="help-area">
						<td></td>
						<td colspan="2"><div class="help">Loading...</div></td>
						<td></td>
					</tr>
					<tr class="row-set-end rowvg-end optional-block-end row-group-end"></tr>
					<tr class="row-set-end row-group-end"></tr>
					<tr>
						<td colspan="4"><input name="type" type="hidden"
							value="hudson.slaves.DumbSlave" /><input name="Submit"
							type="submit" value="Save" class="submit-button primary" /></td>
					</tr>
				</table>
			</form>
			<script src="/jenkins/adjuncts/ec65755e/lib/form/confirm.js"
				type="text/javascript"></script>
		</div>
	</div>
	<footer>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6" id="footer"></div>
				<div class="col-md-18">
					<span class="page_generated">Page generated: Aug 1, 2016
						7:23:38 PM IST</span><span class="rest_api"><a href="api/">REST
							API</a></span><span class="jenkins_ver"><a
						href="http://jenkins-ci.org/">Jenkins ver. 2.11</a></span>
					<div id="l10n-dialog" class="dialog"></div>
					<div id="l10n-footer" style="display: none; float: left">
						<a href="#" onclick="return showTranslationDialog();"><img
							src="/jenkins/static/ec65755e/plugin/translation/flags.png" />
							Help us localize this page </a>
					</div>
					<script>
						var footer = document.getElementById('l10n-footer');
						var f = document.getElementById('footer');
						f.insertBefore(footer, f.firstChild);
						footer.style.display = "block";

						var translation = {};
						translation.bundles = "ivb/scmxOjx0Ql8LR2LvmM1Y76UrpjSMnXD6VhP34kOwItu5f1TOJo6etvRs8Y7f/u2oshPX1Z3RLOdgUFLgyJRkEp6lMfjSTt8c7WKAgBqonZ3fyLtMmhvNn7U7KlUMPmkWGPsmNgJUJX9JtOB9hJiGSd+cr1rccAPJBn341M0ORZB7D+BmuGQ9sV/0x5L3c/o/wQ900ZQVsHsvCW0dPdoZz/v1m0hJM4AD2FD8QTilwtYTelcnjKjjh57xr0LIIeXgjyUJ7sNst8AaaBtt9G+pptd2ujgYN0+rkO/mPCdgyntR3bHo3YFt3g6jiNST7UatLNHzjZ8sHsMbszUz43oNSAY1E5CtDXozEY5GcCKrhVyXlH/olu/4OtBhRGmy1sVIWvHuEf2xi7LvDXuCsCGJ43+tkTgMwCdSvQPP7nG2ESq3nptggE2jRbEBzsWbPS9aFTe3WDokrSOGoG3DVMtfNGKbJF51AFgsGqBu2bEBuDuF3DuGcJJ1qw3qyOgn6CYa1P0YaumxEN0Qjz2BkvPTum4NpQlPfnZyHCxTXoOp8T4Iccy6XDjRcPVGQRgihajvEmdAzWPZ/D/HlFVtUu8I2zJTVqE4aW9O25ChnSYCpotIHvasrJfAl9KI4oyghADWOtkPIAls8ermhypN6pRkXlINpJqIl6mNVyxaK7j+ALJX065ZSaqTAjL6m1PfwLyIHIEDrn07z9IAaw3Ry8C+6XOtX0xSznHp4WZkNwixg+z6yPGk58ZnIO/TM+mIP+Snoxw0BPtaoLvPLGscnT6BDCRCvufZ0h99c+y/kikeght94tJdvSkNZ+1kX6FyIllGspn8eP3bwJehSJ7v3E1Aaj3NdlyI/D8RmeK5W5FvFIXnXwxWO2Sub7nmmE7pNMDuBiiTXhfP/jh8Jrdi3/m8KpVJRIUvuUHsjWLt+ER0HA9RH9w37I019tqXVcjuCVa7Fh5qJTdpLkCmZhIZxP3s1x8AvDWJ7tCqiTYGmGUxttcAH63bJ1XXheYq3kC90qfi1nzV4XDyg9Jq3P7LeDY3io5f0/RR1OIv4845b68OEdI4+iD17xN8rA8J4fFyefXVUgWPWU0xRD8alyRr32+lqTdKNyCChWJcy0LszcE9h/XO6bMjatswkmiT3y1w+KS1a1TBOLrHHo4LY3cmGPNvwdjmH+SMrZLXyryUm0+r9INNc8DQSE2OFrSTihUddpxnpY6bs2C+8ETj9cKPl51sjQdpYo+3A39q5m+5/7VsY5/9gqxas4PcUXP05yIsX1z4S6X61C92y/QEyUQUy/oVFUruuUtT9ymVyY+8Ho6D8mBr+pLrkCjhXOXVrkjuBy9xxsIKjW3eNsQcLZly1Sr3XttN8I6Q1ICZNjvrRNVvlkQvxh76/yxth3VxN41gws6yvdbx9xI+ly8y+zQQV+VnZb9Kl+DnlTb2BSG4CVprjpGDe0pa2uy+Cl8VqO7ux2mf+OUT5oOSBQ/p7zs638j7CDdLkqkLniXrcmU+E+g=";
						translation.detectedLocale = "";

						function showTranslationDialog() {
							if (!translation.launchDialog)
								loadScript("/jenkins/static/ec65755e/plugin/translation/dialog.js");
							else
								translation.launchDialog();
							return false;
						}
					</script>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>