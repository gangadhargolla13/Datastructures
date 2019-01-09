package com.java.log;

import org.apache.log4j.Logger;

public class Logtesting {
	public void runMe(String parameter,String name){
		Logger logger = Logger.getLogger(name);
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}

		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

		try{
			int c = 10/0;
			System.out.println(c);
		}catch(Exception e){
			//logger.error("We got exception "+e.getMessage());
			logger.error("We are expection printstack", e);
		}
	}

}
