<%@page import="org.apache.struts2.dispatcher.Dispatcher"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html >
<html>

<head>
<link rel="Shortcut Icon" href="images/logo_50x34.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
html {
	height: 100%;
	width: 100%;
}
body{background-color:#f7f7f7;font:normal 13px 微软雅黑, 黑体, sans-serif;}
h1,h2,h3,h4{
	text-align: center;
}
h4{ background-color:#f7f7f7}
.title {background-color:#21a6ff;color:white;text-align: center;}
#pic {
	text-align: center;
	height: 100%;
	width: 100%;
	position: absolute;
	zIndex: 9999;
}

#pic img {
	margin: 200px 0 0 0;
}

#context {
	margin: 20px auto;
	text-align: center;
	word-wrap: break-word;
	white-space: pre-wrap;
	
}

.graph {
	margin: 0 auto;
	text-align: center;
	border-style: double none;
}
.graph div{border-style:none none ridge none;}
</style>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href=<%=basePath%>>

<title>测试报告</title>

<link rel="Shortcut Icon" href="images/logo_50x34.png" />
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/result.js"></script>

</head>
<body>

	 <div id="pic">
		<img src="images/process.gif">
	</div>
	<script type="text/javascript" >
		var interval=setInterval("Push()",5000);
	</script>

<div class="title">
	<h1>性能测试报告 Testing Report</h1>
	<small>Copyright © 2014 Sohu.com Inc. All Rights Reserved. 搜狐公司 版权所有</small>
	</div>
	<pre id="context">
服务器疯狂运转ing.................................................................
</pre>
	<div class="graph" style="display:none">
	
			<h4>1.平均响应时间走势图(Response Time in ms)</h4>
		<div id="RT">
	
		<img src ="http://192.168.111.50:18080/cloudtest/log/20140208/JMRT5C3B5B84884FC27D9FA27A94C341E481.png"></div>
		<h4>2.TPS走势图(Hits / Second)</h4>
		<div id="TPS"></div>
		<h4>3.吞吐量走势图(Bytes / Second)</h4>
		<div id="BT"></div>
		
	</div>

	<!-- <pre><s:property value="#request.result"/><footer>
Copyright 2012
</footer></pre> -->

</body>

</html>