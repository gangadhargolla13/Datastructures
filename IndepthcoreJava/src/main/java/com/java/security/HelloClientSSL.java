package com.java.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.Security;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class HelloClientSSL {

	public static void main(String[] args) {
        try {
            Security.addProvider(
                new com.sun.net.ssl.internal.ssl.Provider());            
            SSLSocketFactory sslFact =
                (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket s =
               (SSLSocket)sslFact.createSocket(args.length == 0 ? "127.0.0.1" : args[0], 8181);
            OutputStream out = s.getOutputStream();
            BufferedReader in = new BufferedReader (
                                 new InputStreamReader(s.getInputStream()));
            String str = in.readLine();
            System.out.println("Socket message: " + str);
            in.close();
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
    }
}
