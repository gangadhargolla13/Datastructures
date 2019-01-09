package com.ericsson.bss.rm.eps.util;

import java.util.Collections;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;

public class ExitCmd implements Command
{
	  private static final String NAMESPACE = "syscmd";
	  private static final String ACTION_NAME = "exit";
	  
	  public Object execute(Context ctx)
	  {
	    System.exit(0);
	    return null;
	  }
	  
	  public void plug(Context plug) {}
	  
	  public Command.Descriptor getDescriptor(){
	        return new Command.Descriptor() {
	             public String getNamespace() {return NAMESPACE;}
	            
	        
	            public String getName() {
	                return ACTION_NAME;
	            }

	           
	            public String getDescription() {
	               return "Prints clamshell exit";
	            }

	           
	            public String getUsage() {
	                return "Type 'exit'";
	            }

	         
	            public Map<String, String> getArguments() {
	                return Collections.emptyMap();
	            }
	        };
	    }
}
