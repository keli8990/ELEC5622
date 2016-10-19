<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap Admin</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="lib/zoom-fold/common.css" type="text/css" />


<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.bundle.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.min.js"
	type="text/javascript"></script>


<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" type="text/css" href="stylesheets/premium.css">

<link href="stylesheets/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="stylesheets/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">

<script type="text/javascript">
function disp_alert()
{
alert("Appointment comfired!")
}
</script>
</head>
<body class=" theme-blue">
<script type="text/javascript">
	$(document).ready(function() {
		$('div.small_pic a').fancyZoom({scaleImg: true, closeOnClick: true});
		$('#zoom_word_1').fancyZoom({width:400, height:200});
		$('#zoom_word_2').fancyZoom();
		$('#zoom_flash').fancyZoom();
	});
</script>
	<!-- Demo page code -->

	<script type="text/javascript">
		$(function() {
			var match = document.cookie.match(new RegExp('color=([^;]+)'));
			if (match)
				var color = match[1];
			if (color) {
				$('body').removeClass(function(index, css) {
					return (css.match(/\btheme-\S+/g) || []).join(' ')
				})
				$('body').addClass('theme-' + color);
			}

			$('[data-popover="true"]').popover({
				html : true
			});

		});
	</script>
	<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.navbar-default .navbar-brand, .navbar-default .navbar-brand:hover {
	color: #fff;
}
</style>

	<script type="text/javascript">
		$(function() {
			var uls = $('.sidebar-nav > ul > *').clone();
			uls.addClass('visible-xs');
			$('#main-menu').append(uls.clone());
		});
	</script>

	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

	<!-- Le fav and touch icons -->
	<link rel="shortcut icon" href="../assets/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144"
		href="../assets/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114"
		href="../assets/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72"
		href="../assets/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed"
		href="../assets/ico/apple-touch-icon-57-precomposed.png">


	<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
	<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
	<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
	<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
	<!--[if (gt IE 9)|!(IE)]><!-->

	<!--<![endif]-->

	<div class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="" href="index.html"><span class="navbar-brand"><span
					class="fa fa-paper-plane"></span> Aircraft</span></a>
		</div>

		<div class="navbar-collapse collapse" style="height: 1px;">
			<ul id="main-menu" class="nav navbar-nav navbar-right">
				<li class="dropdown hidden-xs"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-user padding-right-small"
						style="position: relative; top: 3px;"></span> ${userdetail.name} <i
						class="fa fa-caret-down"></i>
				</a>

					<ul class="dropdown-menu">
						<li><a href="./">My Account</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Admin Panel</li>
						<li><a href="./">Users</a></li>
						<li><a href="./">Security</a></li>
						<li><a tabindex="-1" href="./">Payments</a></li>
						<li class="divider"></li>
						<li><a tabindex="-1" href="sign-in.html">Logout</a></li>
					</ul></li>
			</ul>

		</div>
	</div>
	</div>


	<div class="sidebar-nav">
		 <ul>
			<li><a href="#" data-target=".dashboard-menu" class="nav-header"
				data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>
					Dashboard<i class="fa fa-collapse"></i></a></li>
			<li><ul class="dashboard-menu nav nav-list collapse in">
					<li><a href="index.html"><span class="fa fa-caret-right"></span>
							Main</a></li>
					<li><a href="appointment_page"><span class="fa fa-caret-right"></span>
							Appointment</a></li>
				</ul></li>

			
			<li><a href="#" data-target=".accounts-menu"
				class="nav-header collapsed" data-toggle="collapse"><i
					class="fa fa-fw fa-briefcase"></i> News <span
					class="label label-info">+2</span></a></li>
			<li><ul class="accounts-menu nav nav-list collapse">
					<li><a href="liftstyle.jsp"><span class="fa fa-caret-right"></span>
							Lift Style</a></li>
					<li><a href="fit.jsp"><span class="fa fa-caret-right"></span>
							Fitness</a></li>
					

		</ul>
	</div>

	<div class="content">
		<div class="header">

			<h1 class="page-title">Appointment</h1>
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="users.html">Appointment</a></li>
				<li class="active">${userdetail.name}</li>
			</ul>

		</div>
		<div class="main-content">

			<div class="row">

				<div class="col-md-10">
	
					<div id="myTabContent" class="tab-content">
					
						<div class="tab-pane active in" id="home">

							<form id="tab">
							<div class="col-md-12">
								<div class="form-group">
									<label>Start Time</label>
									 <div class="input-group date form_datetime col-md-5" data-date="2016-10-22T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                    					<input class="form-control" size="16" type="text" value="" readonly>
                    					<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                					</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label>End Time</label>
									 <div class="input-group date form_datetime col-md-5" data-date="2016-10-22T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                    					<input class="form-control" size="16" type="text" value="" readonly>
                    					<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                					</div>
								</div>
								</div>
								
								<div class="col-md-8">
									<label>Description</label>
									<textarea class="form-control" rows="3"></textarea>
								</div>

								<div class="col-md-8">							
									<label>Further Requirement (Optional)</label>
									<textarea class="form-control" rows="3"></textarea>							
								</div>
								<div class="col-md-4">&nbsp;&nbsp;</div>

							</form>


						</div>

					</div>

					<div class="btn-toolbar list-toolbar">

						
					</div>
			<br>
			<div class="col-md-6">
<!-- buttom here -->
				<a href=" " data-toggle="modal"
							class="btn btn-warning" onclick="disp_alert()"><i
							class="glyphicon glyphicon-pencil"></i> Make the appointment</a>
					</div>
					<br><br>
					</div>
					<br><br>
		</div>
		<footer>
			<hr>

			<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
			<p class="pull-right">
			<a>	Author: Kejin Li</a>
			</p>

			</footer>
	</div>


	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	</script>


</div>

<script type="text/javascript" src="lib/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="lib/bootstrap.min.js"></script>
<script type="text/javascript" src="lib/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="lib/bootstrap-datetimepicker.fr.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
        showMeridian: 1
    });

</script>

</body>
<script type="text/javascript">
	var websocket = null;
	var myDate = new Date();
	var mytime = myDate.toLocaleTimeString();

	if ('WebSocket' in window) {
		websocket = new WebSocket(
				"ws://localhost:8080/JSiento-server/websocket");
	} else {
		alert('brower Not support websocket')
	}
•
	websocket.onerror = function() {
		setMessageInnerHTML("WebSocket connect error");
	};
•
	websocket.onopen = function() {
		setMessageInnerHTML("WebSocket connect success");
	}
•
	websocket.onmessage = function(event) {
		setMessageInnerHTML(event.data);
	}
•
	websocket.onclose = function() {
		setMessageInnerHTML("WebSocket connection close");
	}
€‚
	window.onbeforeunload = function() {
		closeWebSocket();
	}
Š
	function setMessageInnerHTML(innerHTML) {
		document.getElementById('message').innerHTML += mytime + '  '
				+ innerHTML + '\n';
	}

	function closeWebSocket() {
		websocket.close();
	}

	function send() {
		var message = document.getElementById('text').value;
		websocket.send(message);
		document.getElementById('text').value = "";
	}
</script>
</html>
