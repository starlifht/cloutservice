package com.cloud.action;



import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.print.attribute.standard.Severity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.cloud.methods.FileOp;
import com.opensymphony.xwork2.ActionSupport;

public class File extends ActionSupport {

	/**
	 * star  读日志
	 */
	private static final long serialVersionUID = 8819931366028996018L;
	private HttpServletResponse response;
	
	private HttpServletRequest request;
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	  public  File() throws  Exception{
		  
		   response=ServletActionContext.getResponse();
		   request=ServletActionContext.getRequest();
		   
		}
	@SuppressWarnings("static-access")
	public String doFile() throws Exception{
		String realPath=ServletActionContext.getServletContext().getRealPath("/");
		//System.out.println("日志路径"+logPath+logName);
	    StringBuffer s=new FileOp().readFile(realPath+"/file/"+fileName);
	    //String s=new FileOp().readFile("d:\\123.txt");
	 //   System.out.println(s);
	  //  request.put("file", s);
	   // s.append("@"+request.getSession().getId()+"@");
	    response.setContentType("text/html;charset=utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setHeader("Cache-Control","no-cache");
		PrintWriter out=response.getWriter();
		out.print(s);
		out.flush();
		out.close();
		return "text";
		
	}
	@SuppressWarnings("static-access")
	public String doLog() throws Exception{
		String realPath=ServletActionContext.getServletContext().getRealPath("/");
		String logPath=realPath+"/log/"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"/";
	//	System.out.println("日志："+logPath);
		String logName=request.getSession().getAttribute("logName").toString();
		//System.out.println("日志路径"+logPath+logName);
	    StringBuffer s=new FileOp().readFile(logPath+logName);
	    //String s=new FileOp().readFile("d:\\123.txt");
		PrintWriter out=response.getWriter();
		out.print(s);
		out.flush();
		out.close();
		return "text";
		
	}
	public String doTopLog() throws Exception{
		String realPath=ServletActionContext.getServletContext().getRealPath("/");
		String logPath=realPath+"/log/"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"/";
	//	System.out.println("日志："+logPath);
	
		//System.out.println("日志路径"+logPath+logName);
	    StringBuffer s=new FileOp().readFile(logPath+"TOP");
	    //String s=new FileOp().readFile("d:\\123.txt");
		PrintWriter out=response.getWriter();
		out.print(s);
		out.flush();
		out.close();
		return "text";
	}

}
