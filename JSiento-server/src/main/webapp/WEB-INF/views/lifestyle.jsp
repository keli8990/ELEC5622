<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>

    

    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">

</head>
<body class=" theme-blue">

    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
        .section {
	 	 float: left;
  		 margin: 5px;
		 padding: 5px;
		 width: 480px;
		 height: 400px;
		}
		.content {
  		position: relative;
  		min-height: 2160px;
		min-width:1000px;
  		background: #fff;
  		margin-left: 240px;
  		border-left: 1px solid #cccccc;
 		padding: 15px 15px 0px 15px;
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
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Aircraft</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> Jack Smith
                    <i class="fa fa-caret-down"></i>
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
              </ul>
            </li>
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
					
				</ul></li>

			<li data-popover="true"
				data-content="Items in this group require a <strong><a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'>premium license</a><strong>."
				rel="popover" data-placement="right"><a href="#"
				data-target=".premium-menu" class="nav-header collapsed"
				data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i>
					- User List -<i class="fa fa-collapse"></i></a></li>
			<li><ul class="premium-menu nav nav-list collapse">
					<li class="visible-xs visible-sm"><a href="#">- User List -</a></span>
					<li><a href="userslist"><span
							class="fa fa-caret-right"></span> All Users' Info</a></li>
					
				</ul></li>

			<li><a href="#" data-target=".accounts-menu"
				class="nav-header collapsed" data-toggle="collapse"><i
					class="fa fa-fw fa-briefcase"></i> News <span
					class="label label-info">+3</span></a></li>
			<li><ul class="accounts-menu nav nav-list collapse">
					<li><a href="life_page"><span class="fa fa-caret-right"></span>
							Life Style</a></li>
					<li><a href="fit_page"><span class="fa fa-caret-right"></span>
							Fitness</a></li>
					

		</ul>
    </div>

    <div class="content">
        <div class="header">
            
            <h1 class="page-title">Life Style</h1>
                    <ul class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">Life Style</li>
        </ul>

        </div>
        <div class="main-content">
            
 <div class="section">
	
		<h3 style="font-weight:bold"> 1 Choosing healthy food </h3>
			<p>Eating many different healthy foods helps maintain a healthy and interesting diet which provides a range of different nutrients to the body. 
			Eating a variety of foods promotes good health and can help reduce the risk of disease.</p>
	<blockquote><p>1-Choose food that contains minimal amounts of unhealthy fats.</p>
			<p>2-Eat healthy fats in moderation.</p>
			<p>3-Select low sugar and highly refined carbohydrates food.</p>
			<p>4-Eat a variety of different healthy foods.</p>
			<p>5-Incorporate organic foods.</p>
	</blockquote>
	 </div>
	 <div class="section" align=center>
		<img src=".\images\healthyfood.png" width="420" height="380" /></div>
		
<div class="section" align=center>
		<img src=".\images\healthy_ex.png" width="420" height="380" /></div>

 <div class="section">
		<h3 style="font-weight:bold"> 2 Getting some exercise </h3>
		<p>Regular physical activity is one of the most important things you can do for your health.
		 It can help control weight, reduce risk of some disease, strengthen your bones and muscles, 
		 improve your mental health and mood and others. In addition, if you're an older adult, 
		 it can increase your chances of living longer.</p>
	<blockquote><p>1-Go to the gym 3 to 5 times per week. </p>
		 <p>2-Exercise in your neighborhood.</p>
		 <p>3-Enjoy rigorous daily activities. </p>
		 <p>4-Ditch your car.</p>	 
 	</blockquote>
 </div>

		
 <div class="section">
		<h3 style="font-weight:bold"> 3 Avoid unhealthy habits </h3>
		<p>Everyone is talking about the importance of healthy lifestyle for sustaining health. 
		But there are still many typical unhealthy habits - like excess body weight, junk foods, 
		smoking or lack of exercise – were taken part in people’s daily lives.
		 Get rid of some small unhealthy habits may be contributed to your health effectively.</p>
	<blockquote><p>1-Don't skimp on sleep.</p>
		 <p>2-Keep a positive emotion.</p>
		 <p>3-Avoid smoking and alcohol intake. </p>
		 <p>4-Don't skip sunscreen.</p>
		 
	</blockquote>
	</div>
 <div class="section" align=center>
		<img src=".\images\unhealthyhabits.png" width="420" height="380" /></div>
	
<div class="section" align=center>
		<img src=".\images\hygiene.png" width="420" height="380" />
</div>	
 <div class="section">
		<h3 style="font-weight:bold"> 4 Hygiene </h3>
		<p>Hygiene is an important part of life. 
		It practices are employed as preventative measures to reduce the incidence and spreading of diseases. 
		In the manufacture of food, pharmaceutical, cosmetic and other product, good hygiene is a key part of quality assurance.
		 In order to keep healthy, choosing hygiene products and keeping personal clean should be noticed carefully.</p>
 		 </div>

 <div class="section">
		<h3 style="font-weight:bold"> 5 Entertainment </h3>
		<p>Entertainment is a form of activity that holds the attention and interest of an audience, 
		or gives pleasure and delight. It can be an idea or a task, 
		but is more likely to be one of the activities or events that have developed over thousands of years specifically for the purpose of keeping an audience's attention.</p>
	<blockquote><p>1-Music.</p>
		 <p>2-Games.</p>
		 <p>3-Reading. </p>
		 <p>4-Comedy.</p>
		 
	</blockquote>
	</div>
 <div class="section" align=center>
		<img src=".\images\entertainment.png" width="420" height="340" /></div>		 
 
            <footer>
                <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
                <p class="pull-left"> 2014 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
            </footer>
        </div>
    </div>


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
