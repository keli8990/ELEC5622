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
		 height: 650px;
		}
		.content {
  		position: relative;
  		min-height: 2850px;
		min-width:1000px;
  		background: #fff;
  		margin-left: 240px;
  		border-left: 1px solid #cccccc;
 		padding: 15px 15px 0px 15px;
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
					<li class="visible-xs visible-sm"><a href="#">- User List -</a>
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
            
            <h1 class="page-title">Fitness</h1>
                    <ul class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li class="active">Fitness</li>
        </ul>

        </div>
        <div class="main-content">
            
			<h2>What Is Heart Rate?</h2>
				<p>Heart rate, or pulse, is the number of times your heart beats per minute. </p>

				<p>The measurement of the human heart rate is very useful in medicine and science. 
				At rest heart rate can indicate levels of fitness or the presence of disease or stress, 
				during exercise it indicates fitness level and exercise intensity, and the maximum level 
				is a measure of your cardiac capacity and is an indicator of fatigue.</p>

				<p>Normal heart rate varies from person to person. 
				Knowing yours can be an important heart-healthy gauge.</p>


			<h2>Normal Heart Rate Range</h2>
				<p>As you age, changes in the rate and regularity of your pulse can change and may signify a heart condition or other condition that needs to be addressed.
				Below is a chart relating heart rate and age levels.</p>
				<div align=center>
						<img src=".\images\heart_rate_level.png" width="700" height="450" /></div>

		
			<h2>Factors Influencing Heart Rate</h2>
 				<div class="section">
				<blockquote>
					<h4 style="font-weight:bold"> Body Temperature </h4>
					<p>When your body temperature changes, so does your heart rate. Heart rate will increases when heat is gained by the body such as in hot climates and during exercise in order to transfer more heat away from the body.
 						When the body loses heat such as in cold weather or a cold shower, heart rate decreases to preserve core temperature.</p>
				</blockquote>
 				<div align=center>
					<img src=".\images\body_temperature.png" width="460" height="380" /></div>
				</div>

				<div class="section">
				<blockquote>
				<h4 style="font-weight:bold"> Emotion </h4>
				<p>Different emotions may affect the heart rate.
 					For example, when you feel fear that your body naturally responds with a quickening pulse.
 					The same goes for fear, another type of anxiety, which prompts the flight response and releases hormones that make the heart pump faster.</p>
 				</blockquote><br />
 					<div align=center>
						<img src=".\images\emotion.png" width="460" height="380" /></div>
				</div>


				<div class="section">
					<blockquote>
					<h4 style="font-weight:bold"> Eating </h4>
					<p>After you eat a meal, your heart rate increases to aid with digestion. 
					More blood is directed toward the gastrointestinal tract to process the food. 
					When larger quantities of food are consumed, heart rate may be increased.</p>
					</blockquote>
					<br /><br />
 					<div align=center>
					<img src=".\images\eating.png" width="460" height="380" /></div>
					</div>
		
 					<div class="section">
					<blockquote>
						<h4 style="font-weight:bold"> Exercise </h4>
						<p>Like emotional stress, physical stress also can influence heart rate. 
						During exercise, your heart rate goes up to facilitate the increased demand for oxygen and carbon dioxide removal to and from the muscles.
						Heart rate can increase two to three times above resting heart rate depending on the intensity and duration of exercise.</p>
 					</blockquote>
 					<div align=center>
						<img src=".\images\exercise.png" width="460" height="380" /></div>
					</div>

					 <div class="section">
						<blockquote>
						<h4 style="font-weight:bold"> Age </h4>
						<p>As you age, your resting and daily average heart rate does not change significantly.
 						However, your maximum heart rate decreases as you get older due to the physiological effects of aging, 
 						such as telomere shortening and associated deconditioning. </p>
 						</blockquote>
 						<div align=center>
								<img src=".\images\age.png" width="460" height="380" /></div>
					</div>

 					<div class="section">
					<blockquote>
					<h4 style="font-weight:bold"> Medications </h4>
					<p>All types of over the counter, prescription,
 					herbal supplements, and any drugs will have an impact on your heart rate. </p>
 					</blockquote>
 					<br /><br /><br /><br />
 					<div align=center>
							<img src=".\images\medications.png" width="460" height="380" /></div>
					</div>

   						 <footer>
   					
						   <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
      					  <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
    				    <p class="pull-left">© 2014 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
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
