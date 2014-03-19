package com.cloud.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CMD {
	public void justRun(String cmd) {
		String[] command = {"/bin/bash", "-c",cmd };
		try {
			Runtime.getRuntime().exec (command);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public String getInfo(String cmd){
		String[] command = {"/bin/bash", "-c",cmd };
		 StringBuffer cmdout = new StringBuffer(); 
		 String line=null;
		try{
			 Process process = Runtime.getRuntime().exec (command);
			 
				BufferedReader in = new BufferedReader(new InputStreamReader(
						process.getInputStream()));
				
				while ((line = in.readLine()) != null) {
					
					cmdout.append(line).append(System.getProperty("line.separator"));
				
				}
				in.close();
		
			 
			}catch (java.io.IOException e){
			 System.err.println ("IOException " + e.getMessage());
			}
		return cmdout.toString();
		
	}
}
