package com.ganga;

import java.io.OutputStream;
import java.io.PrintStream;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.SplashScreen;

public class ExSplashScreen implements SplashScreen {

	private static StringBuilder screen;
	 static
	    {
	        screen = new StringBuilder();

	        screen
	                .append(String.format("%n%n"))
	                .append("                                                                                ").append(String.format("%n"))
	                .append("          _|_|_|_|  _|_|_|      _|_|_|        _|_|_|  _|        _|_|_|          ").append(String.format("%n"))
	                .append("          _|        _|    _|  _|            _|        _|          _|            ").append(String.format("%n"))
	                .append("          _|_|_|    _|_|_|      _|_|        _|        _|          _|            ").append(String.format("%n"))
	                .append("          _|        _|              _|      _|        _|          _|            ").append(String.format("%n"))
	                .append("          _|_|_|_|  _|        _|_|_|          _|_|_|  _|_|_|_|  _|_|_|          ").append(String.format("%n"))
	                .append("                                                                                ").append(String.format("%n%n")).append("A command-line tool for EPS")
	                .append(String.format("%n"))
	                .append("OS: ").append(System.getProperty("os.name")).append(", Version: ").append(System.getProperty("os.version"));
	    }

    /*static{
        screen = new StringBuilder();
        screen
            .append(String.format("%n%n"))
            .append("    /#####                                /######    /##   /##").append(String.format("%n"))
            .append("   |__  ##                               /##__  ##  | ##  |__/").append(String.format("%n"))
            .append("      | ##   /######/####    /##   /##  | ##  \\__/  | ##   /##").append(String.format("%n"))
            .append("      | ##  | ##_  ##_  ##  |  ## /##/  | ##        | ##  | ##").append(String.format("%n"))
            .append(" /##  | ##  | ## \\ ## \\ ##   \\  ####/   | ##        | ##  | ##").append(String.format("%n"))
            .append("| ##  | ##  | ## | ## | ##    >##  ##   | ##    ##  | ##  | ##").append(String.format("%n"))
            .append("|  ######/  | ## | ## | ##   /##/\\  ##  |  ######/  | ##  | ##").append(String.format("%n"))
            .append(" \\______/   |__/ |__/ |__/  |__/  \\__/   \\______/   |__/  |__/").append(String.format("%n%n"))
            .append("A command-line tool for JMX").append(String.format("%n"))
            .append("Powered by Clamshell-Cli framework ").append(String.format("%n"))
            .append("http://code.google.com/p/clamshell-cli/").append(String.format("%n%n"))
    
            .append("Java version: ").append(System.getProperty("java.version")).append(String.format("%n"))
            .append("OS: ").append(System.getProperty("os.name")).append(", Version: ").append(System.getProperty("os.version"))

            ;
    }*/
	public void plug(Context ctx) {
		PrintStream out = new PrintStream ((OutputStream)ctx.getValue(Context.KEY_OUTPUT_STREAM));
        out.println(screen);
		
	}

	public void render(Context ctx) {
		// TODO Auto-generated method stub
		
	}

}
