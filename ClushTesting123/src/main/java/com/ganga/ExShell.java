package com.ganga;

import java.io.File;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import org.clamshellcli.api.Shell;

public class ExShell implements Shell{

	public void plug(Context plug) {
		System.out.println("The shell input operations");
		IOConsole console = plug.getIoConsole();
	    if (console == null) {
	      throw new RuntimeException(String.format("%nUnable to find required IOConsole component in plugins directory [%s].Exiting...%n", new Object[] { ((File)plug.getValue("pluginsDir")).getName() }));
	    }
	    console.plug(plug);
	}

	public void exec(Context ctx) {
		System.out.println("Basic operation is started for shell");
	}
}
