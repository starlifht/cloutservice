<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="Shortcut Icon" href="images/logo_50x34.png"/>
<title>云测试</title>
</head>
<body>
<h1>WELCOME TO CLOUDTEST</h1>

<form action="test_Login_doLogin" method="post">
		用户：<input name="username" required="required"><br><br>
		密码：<input type="password" required="required" name="password"><br><br> 
		<input type="submit" value="登陆">
</form>
</body>
</html>