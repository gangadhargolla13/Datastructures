package com.java.log;

import org.apache.log4j.Logger;

public class SLF4JHello {
  
    public  void sayHello(String name) {
    	 final Logger slf4jLogger = Logger.getLogger(SLF4JHello.class);
    	 slf4jLogger.info("Hi,{} "+name);
        //slf4jLogger.info("Hi, {}", name);
        slf4jLogger.info("Welcome to the HelloWorld example of SLF4J");
        slf4jLogger.warn("Welcome to the HelloWorld example of SLF4J");
    }

   
    public static void main(String[] args) {
        SLF4JHello slf4jHello = new SLF4JHello();
        slf4jHello.sayHello("srccodes.com");
    }
}
