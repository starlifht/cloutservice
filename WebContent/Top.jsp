<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE >
<html>
<head>
<link rel="Shortcut Icon" href="images/logo_50x34.png"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务器信息</title>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<style>
body{background-color:#f7f7f7;font:normal 13px 微软雅黑, 黑体, sans-serif;}
h1, h2{
text-align: center;
}

.title {background-color:#21a6ff;color:white;text-align: center;}
#context{
margin:20px auto;
width: 550px;
font:normal 16px Arial,Helvetica,宋体;
line-height:20px;
word-wrap:normal; 
white-space:pre;
}
</style>
<link rel="Shortcut Icon" href="images/logo_50x34.png"/>

</head>

<body>
<div class="title">
<h1>服务器信息 Server Information</h1>
<small>Copyright © 2014 Sohu.com Inc. All Rights Reserved. 搜狐公司 版权所有</small></div>
					<script type="text/javascript">				
				getTop();
					setInterval("getTop()",5000);	 
					function getTop(){
						$.post("test_Top_doTop", function(data, textStatus) {
							this;
							document.getElementById("context").innerHTML = data;
								});	
					}				
					     
					 function Push() {						
							$.post("test_Top_doTop", function(data, textStatus) {this;});
					            $.ajax({
					            type: "POST",
					            url: encodeURI("test_File_doTopLog"),
					            success: function(data) {
					                $('#context').text(data);					 		
					            }
					      });						 
					 }
					 
					 </script>
						<div id="context">等待服务器返回数据..................</div>
</body>
</html>