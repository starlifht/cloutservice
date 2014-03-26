package com.cloud.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cloud.methods.CookBook;
import com.cloud.methods.MD5tool;
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
	private String ru;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRu() {
		return ru;
	}
	public void setRu(String ru) {
		this.ru = ru;
	}
	public String doLogin() throws IOException, ServletException{

	 request.getSession().setAttribute("username", username);
	String token=MD5tool.MD5(username+password);
	String result;
	//Cook.addCook(response, "username", username);
	if(token.equals("tr11x0s8r0t23rr4xf3t19r10223s400")){
	CookBook.addCook(response, "token", token);
	//Cookie sdfds=Cook.getCook(request, "username");
	//System.out.print(sdfds.getValue());
	//response.sendRedirect(response.encodeURL("Top.jsp"));

	result="success";}else{
		result="fail";
	}
		PrintWriter out=response.getWriter();
		out.print(result);
		out.flush();
		out.close();
		return "text";
	}
	public String doLogout() throws IOException, ServletException{

		// request.getSession().setAttribute("username", username);
		
		//Cook.addCook(response, "username", username);
		CookBook.delCook(response, "token");
		//Cookie sdfds=Cook.getCook(request, "username");
		//System.out.print(sdfds.getValue());
		//response.sendRedirect(response.encodeURL("Top.jsp"));

		   String s="success";
			PrintWriter out=response.getWriter();
			out.print(s);
			out.flush();
			out.close();
			return "text";
		}
}
