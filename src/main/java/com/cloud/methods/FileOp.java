package com.cloud.methods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileOp {
	public static  StringBuffer readFile(String url) throws Exception {
		String line = null;
		StringBuffer s=new StringBuffer();
		FileInputStream f = new FileInputStream(url);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(f,"UTF-8")); // 

		while ((line = input.readLine()) != null) { 
		
			//s.append(line);
			
			s.append(line).append(System.getProperty("line.separator"));
			//System.out.println(s);
		}

		input.close();

		return s;
	}
	public static void saveFile(String url,String content) throws Exception{
		FileWriter fileWriter = new FileWriter(url, false);

		//fileWriter.write(content);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(content);
		bufferedWriter.flush();
		fileWriter.flush();
		fileWriter.close();
	
	}
	public static void main(String[] args) {
            try {
				System.out.println(readFile("c:\\HTTP.jmx"));
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}

}
