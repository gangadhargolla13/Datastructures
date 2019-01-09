package com.ganga.command;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimeCmd implements Command{
	private static final String NAMESPACE = "syscmd";
    private static final String ACTION_NAME = "time";
    private static final Logger logger = LoggerFactory.getLogger(TimeCmd.class);
    @Override
    public Object execute(Context ctx) {
    	String userName = System.getProperty("user.name");
    	String cmdLine = (String) ctx
				.getValue(Context.KEY_COMMAND_LINE_INPUT);
    	try{
    	System.out.println("I am gangadhar");
        IOConsole console = ctx.getIoConsole();
        console.writeOutput(String.format("%n%s%n%n",new Date().toString()));
    	}
    	catch(Exception e){
    		logger.error("{'userId':" + userName + ", 'command':" + cmdLine
					+ ", 'status':Failed "+e);
    	}
        return null;
    }

   @Override
    public void plug(Context plug) {
    	System.out.println("I am mallikarjuna");
        // no load-time setup needed
    }
    
    @Override
    public Command.Descriptor getDescriptor(){
        return new Command.Descriptor() {
             public String getNamespace() {return NAMESPACE;}
            public String getName() {
                return ACTION_NAME;
            }
            public String getDescription() {
               return "Prints current date/time";
            }
            public String getUsage() {
                return "Type 'time'";
            }
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
    }
}
