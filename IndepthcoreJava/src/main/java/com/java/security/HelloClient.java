package com.java.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {

	public static void main(String[] args) {
		try{
			Socket s= new Socket(args.length==0?"127.0.0.1":args[0],8181);
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = reader.readLine();
			System.out.println(str);
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("we are deciding that is not working!");
		}
	}
}
