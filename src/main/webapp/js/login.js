function GetQueryString(name)// get url
{
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

function postlogin() {
	var rurl = GetQueryString("ru");

	$.post("test_Login_doLogin", {
		Action : "post",
		ru : rurl,
		username : "star",
		password : "888"
	},

	function(data, textStatus) {

		// data 可以是 xmlDoc, jsonObj, html, text, 等等.
		// this; // 这个Ajax请求的选项配置信息，请参考jQuery.get()说到的this
		 alert(textStatus);
		 if(textStatus)
		window.location.href = rurl;
		// alert(rurl);
	});
	// $.ajax({
	// url: '<%=basePath%>investmentInvestor!gainInvestWay.action?id='+id,
	// type: 'POST',
	// dataType: 'json',
	// async:false,
	// success: function(data){
	//	
	// }
	// });
	// return cellvalue = investWayDescription;
	// }
}
