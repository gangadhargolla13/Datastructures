package com.ganga;

import org.clamshellcli.api.Configurator;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import org.clamshellcli.core.AnInputController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExController extends AnInputController {
	private static final Logger logger = LoggerFactory
			.getLogger(ExController.class);

	public boolean handle(Context ctx) {
		boolean handled = false;
		
			String userName = System.getProperty("user.name");
			System.out.println("User name is " + userName);
			System.out.println("Basic Controller operation started!");
			String cmdLine = (String) ctx
					.getValue(Context.KEY_COMMAND_LINE_INPUT);
			logger.info("{'userId':" + userName + ", 'command':" + cmdLine
					+ ", 'status':Requested");
			System.out.println("What is this " + cmdLine);
			try {
			IOConsole console = ctx.getIoConsole();
			String inputLine = (String) ctx.getValue("key.commandlineInput");
			System.out.println("Input line command " + inputLine);
			if ((inputLine != null) && (!inputLine.isEmpty())) {
				console.writeOutput(inputLine + Configurator.VALUE_LINE_SEP);
				handled = true;
			}
			System.out.println("Controll opeation is done");
		} catch (Exception e) {
			logger.error("{'userId':" + userName + ", 'command':" + cmdLine
					+ ", 'status':Failed "+e);
		}
		return handled;
	}

}
