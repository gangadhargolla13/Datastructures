package com.java.log;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloExample{

	final static Logger logger = Logger.getLogger(HelloExample.class);

	public static void main(String[] args) {
		
		Properties log4jProperties = new Properties();
		log4jProperties.setProperty("log4j.rootLogger", "ERROR, myConsoleAppender");
		log4jProperties.setProperty("log4j.appender.myConsoleAppender", "org.apache.log4j.ConsoleAppender");
		log4jProperties.setProperty("log4j.appender.myConsoleAppender.layout", "org.apache.log4j.PatternLayout");
		log4jProperties.setProperty("log4j.appender.myConsoleAppender.layout.ConversionPattern", "%-5p %c %x - %m%n");
		PropertyConfigurator.configure(log4jProperties);

		HelloExample obj = new HelloExample();
		//obj.runMe("mkyong");
		Logtesting test = new Logtesting();
           test.runMe("Ganesh", HelloExample.class.getName());
	}
}
