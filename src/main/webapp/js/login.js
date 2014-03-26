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
    var name =document.getElementsByName("username")[0].value;
    var pwd= document.getElementsByName("password")[0].value;
	// $.post("test_Login_doLogin", {
	// Action : "post",
	// ru : rurl,
	// username : "star",
	// password : "888"
	// },
	//
	// function(data, textStatus) {
	//
	// // data 可以是 xmlDoc, jsonObj, html, text, 等等.
	// // this; // 这个Ajax请求的选项配置信息，请参考jQuery.get()说到的this
	// alert(textStatus);
	// if(textStatus)
	// window.location.href = rurl;
	// // alert(rurl);
	// });
   
	var params = {
		ru : rurl,
		username : name,
		password : pwd,
	};
	$.ajax({
		type : "POST",
		url : encodeURI("test_Login_doLogin"),
		data : params,
		async : false,
		success : function(data, textstatus) {
		 
		    if(data=="success"){
		        window.location.href = rurl;  
		        alert("登录成功");
		        }else{
		        alert("登录失败");
		    }
			
					}
	});

}
function postlogout() {
 
 
    $.ajax({
        type : "POST",
        url : encodeURI("test_Login_doLogout"),
        async : false,
        success : function(data, textstatus) {
         
            if(data=="success"){
                 
                alert("退出成功");
                }else{
                alert("退出失败");
            }
            
                    }
    });

}
