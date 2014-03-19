package com.cloud.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.jdom.Document;
import org.jdom.Element;

import com.cloud.methods.FileOp;
import com.cloud.methods.Tools;
import com.cloud.methods.XML;
import com.opensymphony.xwork2.ActionSupport;

public class CloudTest extends ActionSupport {

	/**
	 * STAR
	 */
	private static final long serialVersionUID = 4693956738976994996L;
	private String ip;
	private String port;
	private String threads;
	private String path;
	private String loops;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private  static String realPath=ServletActionContext.getServletContext().getRealPath("/")+"/";
	private final String sessionID=ServletActionContext.getRequest().getSession().getId().toString();
	   public  CloudTest() throws  Exception{
	
		  
		   response=ServletActionContext.getResponse();
		   request=ServletActionContext.getRequest();
		
		}
	public String  doTest() throws Exception{
		creatJMX();
		runJMX();
		
//		PrintWriter out=response.getWriter();
//		out.print(ip);
//		out.flush();
//		out.close();
		return "loadtest";
		
	}
	public  void creatJMX() throws Exception{

		Document doc = XML.string2Doc(FileOp.readFile(realPath+"file/demo.jmx").toString());  
	
		ThreadGroup(doc);
		HTTPSamplerProxy(doc);
		 FileOp.saveFile(realPath+"tmp/JMX"+sessionID, XML.doc2String(doc));
	}
	public void runJMX(){
		String logName="JM"+sessionID;
		request.getSession().setAttribute("logName", logName);

		//String params = "/bin/bash "+realPath+"shell/wb.sh " +simul+" "+time+" "+host+" "+realPath+"log/"+" "+logName;
		String params = "/bin/bash "+realPath+"shell/jm.sh "+realPath+" "+sessionID ;
		System.out.println("jmeter参数："+params);
		try {
			 Runtime.getRuntime().exec(params);

		} catch (Exception e) {
			System.err.println("IOException " + e.getMessage());
		}
	}
	@SuppressWarnings("unchecked")
	public  void ThreadGroup(Document doc) {
	   	 Element rootEl = doc.getRootElement().getChild("hashTree");
		        Element ThreadGroup=rootEl.getChild("hashTree").getChild("ThreadGroup");
		        Element loops =  ThreadGroup.getChild("elementProp").getChild("stringProp");
		        loops.setText(this.loops);
		        List<Element> stringProp =  ThreadGroup.getChildren("stringProp");
     
		        for (Element el : stringProp) {
		            //获取name属性值
		            String name = el.getAttributeValue("name");
//		            switch(name){
//		            case "ThreadGroup.num_threads":
//		            	el.setText(this.threads);
//		            	break;		          
//		            }		        
		        }	 
		}
	@SuppressWarnings("unchecked")
	public  void  HTTPSamplerProxy(Document doc){
	 Element rootEl = doc.getRootElement().getChild("hashTree");
		        Element HTTPSamplerProxy=rootEl.getChild("hashTree").getChild("hashTree").getChild("HTTPSamplerProxy");		      
		        List<Element> stringProp =  HTTPSamplerProxy.getChildren("stringProp");
		        for (Element el : stringProp) {	
		            String name = el.getAttributeValue("name");
//		            switch(name){
//		            case "HTTPSampler.domain":
//		            	el.setText(this.ip);
//		            	break;
//		            case "HTTPSampler.port":
//		            	el.setText(this.port);
//		            	break;
//		            case "HTTPSampler.path":
//		            	el.setText(this.path);
//		            	break;
//		            }		         
		      }
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getThreads() {
		return threads;
	}
	public void setThreads(String threads) {
		this.threads = threads;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLoops() {
		return loops;
	}
	public void setLoops(String loops) {
		this.loops = loops;
	}
	

}
