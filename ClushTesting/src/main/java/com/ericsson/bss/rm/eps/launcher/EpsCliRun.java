package com.ericsson.bss.rm.eps.launcher;

import java.io.File;
import java.util.Map;

import org.clamshellcli.api.Configurator;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.Shell;
import org.clamshellcli.core.ShellContext;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/

/*import com.ericsson.eps.notification.LogLevel;
import com.ericsson.eps.notification.NotificationLogger;
import com.ericsson.eps.notification.NotificationLoggerFactory;*/

public class EpsCliRun
{
    //private static final Logger logger = LoggerFactory.getLogger(EpsCliRun.class);
    private static final String CLASS_NAME = EpsCliRun.class.getName();
    public static String userName = null;
    public static String password = null;

    public static void main(String[] args) throws Exception
    {
    	System.out.println("Operation is started");
        userName = args[0];
        password = args[1];
        
        Context context = ShellContext.createInstance();
        Configurator config = context.getConfigurator();
        Map<String, String> propsMap = config.getPropertiesMap();

        String libDirName = propsMap.get("libDir");
        String pluginsDirName = propsMap.get("pluginsDir");

        File libDir = new File(libDirName);
        if (!libDir.exists())
        {
        	//logger.debug("Lib directory [%s] not found. ClamShell-Cli will exit.%n%n",new Object[] { libDir.getCanonicalPath() });
            /*logger.postNotification(CLASS_NAME, LogLevel.ERROR, "%nLib directory [%s] not found. ClamShell-Cli will exit.%n%n", new Object[]
            { libDir.getCanonicalPath() });*/
            System.exit(1);
        }
        context.putValue("libDir", libDir);

        File pluginsDir = new File(pluginsDirName);
        context.putValue("pluginsDir", pluginsDir);

        context.putValue("key.InputStream", System.in);
        context.putValue("key.OutputStream", System.out);
        
        if (context.getPlugins().size() > 0)
        {
            Shell shell = context.getShell();
            if (context.getShell() != null)
            {
                shell.plug(context);
            }
            else
            {
            	//logger.debug("Lib directory [%s] not found. ClamShell-Cli will exit.%n%n",new Object[] { pluginsDir.getCanonicalPath() });
               /*// logger.postNotification(CLASS_NAME, LogLevel.ERROR, "%nNo Shell component found in plugins directory [%s]. ClamShell-Cli will exit now.%n", new Object[]
                { pluginsDir.getCanonicalPath() });*/
                System.exit(1);
            }
        }
        else
        {
        	//logger.debug("No plugins found in [%s]. ClamShell-Cli will exit now.%n%n",new Object[] { pluginsDir.getCanonicalPath() });
            /*//logger.postNotification(CLASS_NAME, LogLevel.ERROR, "%nNo plugins found in [%s]. ClamShell-Cli will exit now.%n%n", new Object[]
            { pluginsDir.getCanonicalPath() });*/
            System.exit(1);
        }
    }
}
