package com.java.security;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(8181);
			Socket s = socket.accept();
			PrintWriter writer = new PrintWriter(s.getOutputStream(), true);
			writer.println("i have to help naresh!");
			System.out.println("we are going to close socket");
			s.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
