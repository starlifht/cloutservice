package com.test.methods;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public  class Tools {

public static  String getDate(){
	return new SimpleDateFormat("yyyyMMdd")
	.format(new Date());
}
public static JSONObject toJson(String s){//转json
	return (JSONObject) JSONValue.parse(s);
	
}
public static String subStr(String response,String str){//截任意字符串
	response=response.replaceAll(" ", "");
	int a=response.indexOf(str);
	int b=response.indexOf(str,a+str.length()+1);
	String flag=response.substring(a+str.length()+1,b-2);

	return flag;
	 	}
public static String subStr(String response,String str1,String str2){//截任意字符串
	response=response.replaceAll(" ", "");
	int a=response.indexOf(str1);
	int b=response.indexOf(str2);
	String flag=response.substring(a+str1.length(),b);

	return flag;
	 	}
public static void runTime(){
	long start = System.currentTimeMillis();

	/*要执行的程序*/
while(true){
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	long end = System.currentTimeMillis();
	System.out.println((end-start)/1000);
}
	
}

public static void main(String[] args) throws Exception {
	//String s="inet addr:192.168.93.163  Bcast:192.168.93.255  Mask:255.255.255.0";
//	s=s.trim();
	//System.out.println(s.replaceAll(" ", ""));
//	System.out.println(s.indexOf("addr:"));
//	System.out.println(s.indexOf("Bcast:"));
//	System.out.println(s.substring(5+new String("addr:").length(),26));
	//System.out.println(subStr(s,"addr:","Bcast"));
//Tools.subStr(s, "status");
//System.out.print(new SimpleDateFormat("yyyyMMdd").format(new Date()));
// Tools.getProperty();
}

}
