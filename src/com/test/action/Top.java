package com.test.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.methods.CMD;



public class Top  extends ActionSupport{

	/**
	 * STAR
	 */
	private static final long serialVersionUID = -7474626195903201834L;
	private HttpServletResponse response;
	private HttpServletRequest request;
	public Top(){
		response= ServletActionContext.getResponse();
		request= ServletActionContext.getRequest();

	}
	public String doTop() throws IOException{
		String s=new CMD().getInfo("top -b -n 1");
		String realPath=request.getSession().getServletContext().getRealPath("/")+"/";
		String logName="TOP";
	
		String Params="/bin/bash "+realPath+"shell/top.sh "+logName+" "+realPath+"log/";
	    System.out.print("TOP命令：：："+Params);
		try {
			Runtime.getRuntime().exec(Params);
		} catch (IOException e) {
			
			e.printStackTrace(); 
		}
	
	
		PrintWriter out=response.getWriter();
		out.print(s);
		out.flush();
		out.close();

	

		return "text";
	}
	}
