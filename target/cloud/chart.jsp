<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>图表</title>

		<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
		<script src="js/highcharts.js"></script>
<script src="js/exporting.js"></script>
<script type="text/javascript" src="js/login.js"></script>

		<script type="text/javascript">
$(function () {
        $('#container').highcharts({
            title: {
                text: 'Connection',
                x: -20 //center
            },
            subtitle: {
                text: 'sohutest',
                x: -20
            },
            xAxis: {
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            },
            yAxis: {
                title: {
                    text: 'Temperature (°C)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: '°C'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: 'Tokyo',
                data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 100, 26.5, 23.3, 18.3, 13.9, 9.6]
            }]
        });
    });
    

		</script>
	
	</head>
	<body>


<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	<input type="button" value="退出" onclick="postlogout()">
	</body>
</html>
