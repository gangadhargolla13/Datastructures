package com.java.security;

import java.io.PrintWriter;
import java.security.Security;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class HelloServerSSL {

	public static void main(String[] args) throws Exception {
		SSLServerSocket s = null;
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory
				.getDefault();
		s = (SSLServerSocket) factory.createServerSocket(8118);
		SSLSocket socket = (SSLSocket) s.accept();
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		out.println("Hello on a SSL socket");
		socket.close();
	}
}
