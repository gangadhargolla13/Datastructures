package com.java.log;

import com.ganga.log.logmanagement.ProgrammaticDailyRollingLogFilesExample;

public class GopiTest {

	public void printTwoLogs(){
		System.out.println("Calling from Gopitest");
		ProgrammaticDailyRollingLogFilesExample ex = new ProgrammaticDailyRollingLogFilesExample();
		ex.writeLogMsg(GopiTest.class.getName(), "Ganesh Kumar");
	}
}
