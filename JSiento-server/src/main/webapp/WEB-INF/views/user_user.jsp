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
					<li><a href="life_page"><span class="fa fa-caret-right"></span>
							Lift Style</a></li>
					<li><a href="fit_page"><span class="fa fa-caret-right"></span>
							Fitness</a></li>
					

		</ul>
	</div>

	<div class="content">
		<div class="header">

			<h1 class="page-title">User Profile</h1>
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a></li>
				<li><a href="users.html">Users</a></li>
				<li class="active">${userdetail.name}</li>
			</ul>

		</div>
		<div class="main-content">

			<ul class="nav nav-tabs">
				<li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
				<li><a href="#profile" data-toggle="tab">Small talk</a></li>
			</ul>

			<div class="row">
				<div class="col-md-2">
			<div class="small_pic">
                        <a href="#pic_one">
                           <img src="${userdetail.user_img }"  width = "200px" height="250px" class="img-responsive"/>
                        </a>
                    </div>
			</div>
				<div class="col-md-10">
					<br>
					<div id="myTabContent" class="tab-content">
					
						<div class="tab-pane active in" id="home">
						<br><br><br>
						<div class="col-md-5">
									
								
								</div>
							<form id="tab">
							<div class="col-md-3">
								<div class="form-group">
									<label>Username</label>
									<div class="form-control">${userdetail.name}</div>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Age</label>
									<div class="form-control">${userdetail.age}</div>
								</div>
								</div>
								
								<div class="col-md-3">
								<div class="form-group">
									<label>Gender</label>
									<div class="form-control">${userdetail.gender}</div>
								</div>
								</div>
								
								<div class="col-md-3">
								<div class="form-group">
									<label>Job</label>
									<div class="form-control">${userdetail.job_title}</div>
								</div>
								</div>
								
								<div class="col-md-8">
								
									<label>Preference</label>
									<textarea class="form-control" rows="3">${userdetail.food_preference}</textarea>
								
								</div>
								<div class="col-md-4">&nbsp;&nbsp;</div>
								<div class="col-md-8">
								
									<label>Description</label>
									<textarea class="form-control" rows="3" >${userdetail.descp}</textarea>
								
								</div>
							</form>


						</div>

						<div class="tab-pane fade" id="profile">


							<div class="form-group">
								<label>Small Talk</label> <br />

								<div class="input-group">
									<input type="text" class="form-control" placeholder="Hi..."
										id="text"> <span class="input-group-btn">
										<button class="btn btn-default" type="button" onclick="send()">Go!</button>
									</span>
								</div>
								<!-- /input-group -->

								<hr />



								<div class="form-group">
									<label for="comment">Comment:</label>
									<textarea class="form-control" rows="5" id="message"></textarea>
								</div>

							</div>


						</div>
					</div>

					<div class="btn-toolbar list-toolbar">

						
					</div>
					<div class="col-md-6">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
			<div class="col-md-6">
				<a href="${userdetail.call_link}" data-toggle="modal"
							class="btn btn-danger"><i
							class="glyphicon glyphicon-earphone"></i> Call</a>
				<a href="<%=request.getContextPath() %>/userupdate?uid=${userdetail.id}" data-toggle="modal"
							class="btn btn-warning"><i
							class="glyphicon glyphicon-pencil"></i> Update</a>
					<button type="button" class="btn btn-success" data-toggle="modal"
						data-target=".bs-example-modal-lg"><i
							class="glyphicon glyphicon-th-list"></i>&nbsp;Hr Data</button>

					<div class="modal fade bs-example-modal-lg" tabindex="-1"
						role="dialog" aria-labelledby="myLargeModalLabel">
						<div class="modal-dialog modal-lg" role="document">
							<div class="modal-content">
								<table
									class="table table-bordered table-striped table-condensed">
									<thead>
										<tr>
											<th>Hr Max</th>
											<th>Hr Mean</th>
											<th>Hr Min</th>
											<th>Hr Range</th>
											<th>Hr Std</th>
											<th>Hr Variance</th>

											<th>Time</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<c:forEach var="bflist" items="${bflist}">
												<c:choose>
												   <c:when test="${bflist.hrMax>=160}">
												   	<td style="color: red">${bflist.hrMax }</td>
											       </c:when>
													 <c:otherwise>
													 	<td>${bflist.hrMax }</td>
													</c:otherwise> 
                                               </c:choose> 
											   <c:choose>
												   <c:when test="${bflist.hrMean>=160}">
												   	<td style="color: red">${bflist.hrMean }</td>
											       </c:when>
												     <c:when test="${bflist.hrMean<=60}">
												   	<td style="color: blue">${bflist.hrMean }</td>
											       </c:when>
													 <c:otherwise>
													 	<td>${bflist.hrMean }</td>
													</c:otherwise> 
                                               </c:choose> 
                                               <c:choose>
												   <c:when test="${bflist.hrMin<=60}">
												   	<td style="color: blue">${bflist.hrMin }</td>
											       </c:when>
													 <c:otherwise>
													 	<td>${bflist.hrMin }</td>
													</c:otherwise> 
                                               </c:choose> 
												<td class="center">${bflist.hrRange }</td>
												<td class="center">${bflist.hrSTD }</td>
												<td class="center">${bflist.hrVar }</td>

												<td class="center">${bflist.timeStamp }</td>
										</tr>
										</c:forEach>

									</tbody>
								</table>
							</div>
						</div>
					</div>



					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target=".bs-example-modal-l"><i
							class="glyphicon glyphicon-th-list"></i>&nbsp;Sc Data</button>

					<a id="excelDownload" href = "/JSiento-server/download" class="btn btn-primary">
					<i class="glyphicon glyphicon-cloud-download"></i> 
					Export Data</a>

					<div class="modal fade bs-example-modal-l" tabindex="-1"
						role="dialog" aria-labelledby="myLargeModalLabel">
						<div class="modal-dialog modal-lg" role="document">
							<div class="modal-content">
								<table
									class="table table-bordered table-striped table-condensed">
									<thead>
										<tr>
											<th>Sc Max</th>
											<th>Sc Mean</th>
											<th>Sc Min</th>
											<th>Sc Range</th>
											<th>Sc Std</th>
											<th>Sc Variance</th>
											<th>Time</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<c:forEach var="bflist" items="${bflist}">
												<td class="center">${bflist.scMax }</td>
												
												<c:choose>
												   <c:when test="${bflist.scMean>=0}">
												   	<td class="center" style="color: red">${bflist.scMean }</td>
											       </c:when>
												     <c:when test="${bflist.hrMean<0}">
												   	<td class="center" style="color: blue">${bflist.scMean }</td>
											       </c:when>
													 <c:otherwise>
													 	<td>${bflist.hrMean }</td>
													</c:otherwise> 
                                               </c:choose> 
                                               
												<td class="center">${bflist.scMin }</td>
												<td class="center">${bflist.scRange }</td>
												<td class="center">${bflist.scSTD }</td>
												<td class="center">${bflist.scVar }</td>
												<td class="center">${bflist.timeStamp }</td>
										</tr>
										</c:forEach>

									</tbody>

								</table>
							</div>
						</div>
					</div>
					<br><br>
					</div>
					<br><br>
					</div>
					<br><br>
			<div class="col-md-12">		
					
		<canvas id="canvas"></canvas>
	

	

	<script type="text/javascript">
	
        var MONTHS = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        
        var randomScalingFactor = function() {
            return Math.round(Math.random() * 100);
            //return 0;
        };
        var randomColorFactor = function() {
            return Math.round(Math.random() * 255);
        };
        var randomColor = function(opacity) {
            return 'rgba(' + randomColorFactor() + ',' + randomColorFactor() + ',' + randomColorFactor() + ',' + (opacity || '.3') + ')';
        };
        
        var config = {
            type: 'line',
            data: {
                labels: <%=session.getAttribute("sdate")%>,
                datasets: [{
                    label: "Sc Range",
                    
                    data: <%=session.getAttribute("scrange")%>,
                    fill: false,
                   
                },
                {
                    label: "Hr Range",
                    
                    data: <%=session.getAttribute("hrrange")%>,
                    fill: false,
                   
                }, {
                    hidden: true,
                    label: 'Sc Max',
                    data: <%=session.getAttribute("scmax")%>,
                    fill: false,
                }, {
                    hidden: true,
                    label: 'Hr Max',
                    data: <%=session.getAttribute("hrmax")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Sc Mean',
                    data: <%=session.getAttribute("scmean")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Hr Mean',
                    data: <%=session.getAttribute("hrmean")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Sc Min',
                    data: <%=session.getAttribute("scmin")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Hr Min',
                    data: <%=session.getAttribute("hrmin")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Sc STD',
                    data: <%=session.getAttribute("scstd")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Hr STD',
                    data: <%=session.getAttribute("hrstd")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Sc Variance',
                    data: <%=session.getAttribute("scvar")%>,
                    fill: false,
                },{
                    hidden: true,
                    label: 'Hr Variance',
                    data: <%=session.getAttribute("hrvar")%>,
                    fill: false,
                }]
            },
            options: {
                responsive: true,
                title:{
                    display:true,
                    text:'User Hr & Sc Data'
                },
                tooltips: {
                    mode: 'label',
                    callbacks: {
                       
                    }
                },
                hover: {
                    mode: 'dataset'
                },
                scales: {
                    xAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Date'
                        }
                    }],
                    yAxes: [{
                        display: true,
                        scaleLabel: {
                            display: true,
                            labelString: 'Value'
                        },
                        ticks: {
                            suggestedMin: -5,
                            suggestedMax: 5,
                        }
                    }]
                }
            }
        };
        $.each(config.data.datasets, function(i, dataset) {
            dataset.borderColor = randomColor(0.4);
            dataset.backgroundColor = randomColor(0.5);
            dataset.pointBorderColor = randomColor(0.7);
            dataset.pointBackgroundColor = randomColor(0.5);
            dataset.pointBorderWidth = 1;
        });
        window.onload = function() {
            var ctx = document.getElementById("canvas").getContext("2d");
            window.myLine = new Chart(ctx, config);
        };
       
        
    </script>		

			</div>


  
		</div>
		<footer>
			<hr>

			<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
			<p class="pull-right">
				Author: Kejin Li</a>
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
	





</body>
<script type="text/javascript">
	var websocket = null;
	var myDate = new Date();
	var mytime = myDate.toLocaleTimeString();
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new WebSocket(
				"ws://localhost:8080/JSiento-server/websocket");
	} else {
		alert('brower Not support websocket')
	}
	//连接发生错误的回调方法
	websocket.onerror = function() {
		setMessageInnerHTML("WebSocket connect error");
	};
	//连接成功建立的回调方法
	websocket.onopen = function() {
		setMessageInnerHTML("WebSocket connect success");
	}
	//接收到消息的回调方法
	websocket.onmessage = function(event) {
		setMessageInnerHTML(event.data);
	}
	//连接关闭的回调方法
	websocket.onclose = function() {
		setMessageInnerHTML("WebSocket connection close");
	}
	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function() {
		closeWebSocket();
	}
	//将消息显示在网页上
	function setMessageInnerHTML(innerHTML) {
		document.getElementById('message').innerHTML += mytime + '  '
				+ innerHTML + '\n';
	}
	//关闭WebSocket连接
	function closeWebSocket() {
		websocket.close();
	}
	//发送消息
	function send() {
		var message = document.getElementById('text').value;
		websocket.send(message);
		document.getElementById('text').value = "";
	}
</script>
</html>
