<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link rel="Shortcut Icon" href="images/logo_50x34.png" />
<title>云测试</title>
</head>
<body>
	<h1>WELCOME TO CLOUDTEST</h1>

	<form>
		用户：<input name="username" required="required"><br>
		<br> 密码：<input type="password" required="required"
			name="password"><br>
		<br> <input type="button" value="登陆" onclick="postlogin()">

	</form>
</body>
<footer>20140320150900</footer>
</html>