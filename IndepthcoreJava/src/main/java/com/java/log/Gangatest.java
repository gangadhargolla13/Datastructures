package com.java.log;

import com.ganga.log.logmanagement.ProgrammaticDailyRollingLogFilesExample;

public class Gangatest {

	public static void main(String[] args) {
		String dd = Gangatest.class.getName();
		//SLF4JHello.sayHello("Gangadhar", dd);
		System.out.println("Testing log message write");
		ProgrammaticDailyRollingLogFilesExample ex = new ProgrammaticDailyRollingLogFilesExample();
		ex.writeLogMsg(Gangatest.class.getName());
		GopiTest gopi = new GopiTest();
		gopi.printTwoLogs();
		System.out.println("Testing is completed");
	}
}
