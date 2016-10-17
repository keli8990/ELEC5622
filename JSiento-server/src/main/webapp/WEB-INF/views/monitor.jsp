<html>
<head>
<TITLE>JSiento - Monitor affective states</TITLE>
 

<script type="text/javascript"  src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
    function AjaxMonitor() {
        $.ajax({
            url : 'ajaxMonitor.html',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
</script>
 
<script type="text/javascript">
    var intervalId = 0;
    intervalId = setInterval(AjaxMonitor, 10000);
</script>
</head>
 
<body>
	
    <div align="center" >
        <br> <br> ${message} <br> <br>
        <div id="result"></div>
        <br>
    </div>
  
</body>
</html>