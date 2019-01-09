package com.java.strings.v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandExcecute {

	public static void main(String[] args) {
		try{
			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec("/opt/eps/cli/test.sh");
			BufferedReader stdInput = new BufferedReader(new 
				     InputStreamReader(p.getInputStream()));
			String s = null;
			while ((s = stdInput.readLine()) != null) {
			    System.out.println("The security status is " +s);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
