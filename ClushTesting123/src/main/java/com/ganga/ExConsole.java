package com.ganga;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import jline.CandidateListCompletionHandler;
import jline.ConsoleReader;
import jline.SimpleCompletor;

import org.clamshellcli.api.Configurator;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import org.clamshellcli.api.InputController;
import org.clamshellcli.api.Prompt;
import org.clamshellcli.api.Shell;
import org.clamshellcli.api.SplashScreen;

public class ExConsole implements IOConsole{
	private Context context;
	  private Configurator config;
	  private Shell shell;
	  private Prompt prompt;
	  private ConsoleReader console;
	  private List<InputController> controllers;
	  private boolean controllersAreValid;
	  private InputStream input;
	  private OutputStream output;
	  private Thread consoleThread;
	  private Map<String, String[]> inputHints;
	  
	  
	public void plug(Context plug) {
		this.context = plug;
	    this.config = plug.getConfigurator();
	    this.shell = plug.getShell();
	    this.prompt = plug.getPrompt();
	    this.input = ((this.input = (InputStream)this.context.getValue("key.InputStream")) != null ? this.input : System.in);
	    this.output = ((this.output = (OutputStream)this.context.getValue("key.OutputStream")) != null ? this.output : System.out);
	    this.inputHints = new HashMap();
	    try
	    {
	      this.console = new ConsoleReader(this.input, new OutputStreamWriter(this.output));
	    }
	    catch (IOException ex)
	    {
	      throw new RuntimeException("Unable to initialize the console.  Program will stop now.", ex);
	    }
	    this.controllers = plug.getPluginsByType(InputController.class);
	    if (this.controllers.size() > 0)
	    {
	      for (InputController ctrl : this.controllers) {
	        ctrl.plug(plug);
	      }
	      aggregateExpectedInputs();
	      this.console.setCompletionHandler(new CandidateListCompletionHandler());
	    }
	    else
	    {
	      throw new RuntimeException("Unable to initialize Clamshell-Cli.  No InputController instances found on classpath. Exiting...");
	    }
	    List<SplashScreen> screens = plug.getPluginsByType(SplashScreen.class);
	    if ((screens != null) && (screens.size() > 0)) {
	      for (SplashScreen sc : screens)
	      {
	        sc.plug(plug);
	        sc.render(plug);
	      }
	    }
	    this.consoleThread = createConsoleThread();
	    this.consoleThread.start();
		
	}

	public InputStream getInputStream() {
		return this.input;
	}

	public OutputStream getOutputStream() {
		return this.output;
	}

	public String readInput(String prompt) {
		String result = null;
	    try
	    {
	      result = this.console.readLine(prompt);
	    }
	    catch (IOException ex)
	    {
	      throw new RuntimeException("Unable to read input: ", ex);
	    }
	    return result;
	}

	public void writeOutput(String val) {
		try
	    {
	      this.console.printString(val);
	    }
	    catch (IOException ex)
	    {
	      throw new RuntimeException("Unable to invoke print on console: ", ex);
	    }
		
	}
	
	private Thread createConsoleThread()
	  {
	    Thread t = new Thread(new Runnable()
	    {
	      public void run()
	      {
	        while (!Thread.interrupted())
	        {
	        	ExConsole.this.context.putValue("key.commandParams", null);
	          
	          boolean handled = false;
	          String line = ExConsole.this.readInput(ExConsole.this.prompt.getValue(ExConsole.this.context));
	          if ((line != null) && (!line.trim().isEmpty()))
	          {
	        	  ExConsole.this.context.putValue("key.commandlineInput", line);
	            if (ExConsole.this.controllersExist())
	            {
	              for (InputController controller : ExConsole.this.controllers)
	              {
	                Pattern pattern = controller.respondsTo();
	                Boolean enabled = controller.isEnabled();
	                if ((pattern != null) && (pattern.matcher(line).matches()) && (enabled.booleanValue()))
	                {
	                  boolean ctrlResult = controller.handle(ExConsole.this.context);
	                  handled = (handled) || (ctrlResult);
	                }
	              }
	              if (!handled) {
	            	  ExConsole.this.writeOutput(String.format("%nCommand unhandled. %nNo controller found to respond to [%s].%n%n", new Object[] { line }));
	              }
	            }
	            else
	            {
	            	ExConsole.this.writeOutput(String.format("Warning: no controllers(s) found.%n", new Object[0]));
	            }
	          }
	        }
	      }
	    });
	    return t;
	  }
	  
	  private boolean controllersExist()
	  {
	    return (this.controllers != null) && (this.controllers.size() > 0);
	  }
	private void aggregateExpectedInputs()
	  {
	    List<String> inputs = new ArrayList();
	    for (InputController ctrl : this.controllers)
	    {
	      String[] expectedInputs = ctrl.getExpectedInputs();
	      if (expectedInputs != null) {
	        Collections.addAll(inputs, expectedInputs);
	      }
	    }
	    this.console.addCompletor(new SimpleCompletor((String[])inputs.toArray(new String[0])));
	  }
}
