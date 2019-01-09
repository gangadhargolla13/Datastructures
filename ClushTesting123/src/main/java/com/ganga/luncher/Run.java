package com.ganga.luncher;

import java.io.File;
import java.util.Map;

import org.clamshellcli.api.Configurator;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.Shell;
import org.clamshellcli.core.Clamshell;
import org.clamshellcli.core.ShellContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Run {
	private static final Logger logger = LoggerFactory.getLogger(Run.class);
	public static void main(String[] args)
		    throws Exception
		  {
		logger.info("Logshimpent is proccessed");
		    Context context = ShellContext.createInstance();
		    Configurator config = context.getConfigurator();
		    Map<String, String> propsMap = config.getPropertiesMap();
		    String libDirName = (String)propsMap.get("libDir");
		    String pluginsDirName = (String)propsMap.get("pluginsDir");
		    
		    File libDir = new File(libDirName);
		    if (!libDir.exists())
		    {
		      System.out.printf("%nLib directory [%s] not found. ClamShell-Cli will exit.%n%n", new Object[] { libDir.getCanonicalPath() });
		      System.exit(1);
		    }
		    context.putValue("libDir", libDir);
		    
		    ClassLoader parent = Thread.currentThread().getContextClassLoader();
		    ClassLoader cl = Clamshell.Runtime.createClassLoaderForPath(new File[] { libDir }, parent);
		    Thread.currentThread().setContextClassLoader(cl);
		    
		    File pluginsDir = new File(pluginsDirName);
		    if (!pluginsDir.exists())
		    {
		    	System.out.println("Gangadhars");
		      System.out.printf("%nPugins directory [%s] not found. ClamShell-Cli will exit.%n%n", new Object[] { pluginsDir.getCanonicalPath() });
		      System.exit(1);
		    }
		    context.putValue("pluginsDir", pluginsDir);
		    
		    context.putValue("key.InputStream", System.in);
		    context.putValue("key.OutputStream", System.out);
		    if (context.getPlugins().size() > 0)
		    {
		      Shell shell = context.getShell();
		      System.out.println("Basic Shell operation "+shell.getClass().getName());
		      if (context.getShell() != null)
		      {
		        shell.plug(context);
		      }
		      else
		      {
		        System.out.printf("%nNo Shell component found in plugins directory [%s]. ClamShell-Cli will exit now.%n", new Object[] { pluginsDir.getCanonicalPath() });
		        
		        System.exit(1);
		      }
		    }
		    else
		    {
		      System.out.printf("%nNo plugins found in [%s]. ClamShell-Cli will exit now.%n%n", new Object[] { pluginsDir.getCanonicalPath() });
		      System.exit(1);
		    }
		    logger.info("The validation is completed!");
		  }
}
