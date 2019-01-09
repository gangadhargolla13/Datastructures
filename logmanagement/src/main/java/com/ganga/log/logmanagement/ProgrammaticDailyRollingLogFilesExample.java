package com.ganga.log.logmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProgrammaticDailyRollingLogFilesExample {

	public void writeLogMsg(String className){
		Logger logger = LoggerFactory.getLogger(className);
		logger.getClass();
		logger.debug(className+"str");
		logger.info("this is a information log message");
		logger.warn("this is a warning log message");
		logger.warn("this is a warning log message from gangadhar");
		try{
			int c = 90/0;
			System.out.println(c);
		}catch(ArithmeticException e){
			logger.error("Error testing", e);
		}
	}
	public void writeLogMsg(String className,String message){
		Logger logger = LoggerFactory.getLogger(className);
		logger.debug("Debug "+message);
		logger.info("Info -->"+message);
		logger.warn("this is a warning log message from gopi jithendra");
	}
	/*public static void main(String[] args) {
		Logger logger = Logger.getLogger(ProgrammaticDailyRollingLogFilesExample.class);
		logger.debug("this is a debug log message");
		logger.info("this is a information log message");
		logger.warn("this is a warning log message");
		logger.warn("this is a warning log message from gangadhar");
	}*/
	
	/*public void writeLogMsg(String className){
		Logger logger = Logger.getLogger(className);
		logger.debug("this is a debug log message");
		logger.info("this is a information log message");
		logger.warn("this is a warning log message");
		logger.warn("this is a warning log message from gangadhar");
	}*/
}