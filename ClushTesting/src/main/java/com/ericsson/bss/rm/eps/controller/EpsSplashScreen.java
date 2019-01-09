package com.ericsson.bss.rm.eps.controller;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.SplashScreen;



public class EpsSplashScreen implements SplashScreen
{
	private static final Logger logger = LoggerFactory.getLogger(EpsSplashScreen.class);
    private static StringBuilder screen;
    /*static
    {
    	logger.debug("The specific splashScreen operation");
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
    }*/

   // @Override
    public void render(Context ctx)
    {
        PrintStream out = null;
        try
        {
            out = new PrintStream((OutputStream) ctx.getValue(Context.KEY_OUTPUT_STREAM), false, "UTF-8");
            out.println(screen);
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
    }

   // @Override
    public void plug(Context plug)
    {
    	System.out.println("Hello world");
    	logger.debug("The specific splashScreen operation");
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
}
