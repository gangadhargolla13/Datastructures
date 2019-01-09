package com.ganga.clush.ClushTesting;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

public class TimeCmd implements Command {
    private static final String NAMESPACE = "syscmd";
    private static final String ACTION_NAME = "time1";

    //@Override
    public Object execute(Context ctx) {
    	System.out.println("I am gangadhar");
        IOConsole console = ctx.getIoConsole();
        console.writeOutput(String.format("%n%s%n%n",new Date().toString()));
        return null;
    }

   //@Override
    public void plug(Context plug) {
    	System.out.println("I am mallikarjuna");
        // no load-time setup needed
    }
    
    //@Override
    public Command.Descriptor getDescriptor(){
        return new Command.Descriptor() {
             public String getNamespace() {return NAMESPACE;}
            
        
            public String getName() {
                return ACTION_NAME;
            }

           
            public String getDescription() {
               return "Prints current date/time1";
            }

           
            public String getUsage() {
                return "Type 'time1'";
            }

         
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
    }
}
