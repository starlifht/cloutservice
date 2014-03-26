package com.cloud.methods;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookBook {

	public static void addCook(HttpServletResponse response,String name ,String value){
		 Cookie cookie = new Cookie(name,value);
		 
		 //cookie.setMaxAge(3600);
		  
		 //设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
		  
		 cookie.setPath("/");
		 response.addCookie(cookie);
	}
//	public static String  getCook(HttpServletRequest request,String name){
//		String cookievalue=null;
//		 Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
//		 for(Cookie cookie1 : cookies){
//		   String cookiename=  cookie1.getName();// get the cookie name
//		  //  System.out.println(cookiename+cookievalue);
//		    if(cookiename.equals(name)){
//			    cookievalue= cookie1.getValue(); // get the cookie value
//
//		    }
//		 }
//		return cookievalue;
//	}
	public static Cookie getCook(HttpServletRequest request,String name){
	    Map<String,Cookie> cookieMap = ReadCookieMap(request);
	    if(cookieMap.containsKey(name)){
	        Cookie cookie = (Cookie)cookieMap.get(name);
	        return cookie;
	    }else{
	        return null;
	    }   
	}
	 
	 
	 
	/**
	 * 将cookie封装到Map里面
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
