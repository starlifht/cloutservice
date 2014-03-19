package com.cloud.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cloud.methods.Cook;
import com.cloud.methods.MD5Util;
import com.opensymphony.xwork2.ActionSupport;


public class Login  extends ActionSupport  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2995596794780640849L;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String username;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(){
		response= ServletActionContext.getResponse();
		request= ServletActionContext.getRequest();

	}
	public String doLogin() throws IOException{

	 request.getSession().setAttribute("username", username);
	
	//Cook.addCook(response, "username", username);
	Cook.addCook(response, "token", MD5Util.MD5(username+password));
	//Cookie sdfds=Cook.getCook(request, "username");
	//System.out.print(sdfds.getValue());
	response.sendRedirect("chart.jsp");
	String s="登陆成功";
		PrintWriter out=response.getWriter();
		out.print(s);
		out.flush();
		out.close();
		return "text";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
