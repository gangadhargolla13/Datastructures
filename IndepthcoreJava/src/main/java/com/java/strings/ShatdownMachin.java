package com.java.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShatdownMachin {

	public static void main(String[] args) {
		try{
			Runtime run = Runtime.getRuntime();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter No. of Seconds after which You want your Computer to Shutdown :");
	        long a=Long.parseLong(reader.readLine());
	        Process process = run.exec("shutdown -s -t "+a);
	        System.out.println(process.exitValue());
	        System.exit(0);
		}catch(Exception e){
			
		}
	}
}
