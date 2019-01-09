package com.ericsson.bss.rm.eps.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.core.AnInputController;

import com.ericsson.bss.rm.eps.util.EpsCliConstants;


/**
 * This is an implementation of the InputController for the EPS CLI. This implementation parses command-line input from Context(KEY_INPUT_LINE) value.
 * It parses the input using JSon notation. The command-line input is expected to be of the form:
 * <code>cmd param0:value para1:value1 ... paramN:valueN</code> The controller parses the input line and dispatches the parsed command and params to a
 * Command instance on the classpath.
 */
public class EpsController extends AnInputController 
{
    private Map<String, Command> commands;
    public static final String COMMAND_WITH_SINGLE_ARG = "command";
    public static final String EXIT_COMMAND = "exit";
    public static final String LOG_FILE_LOC = "";

   // @Override
    public boolean handle(Context ctx)
    {
        String cmdLine = (String) ctx.getValue(Context.KEY_COMMAND_LINE_INPUT);
        boolean multipleSingleCommands = false;
        boolean repeatedOption = false;
        Map<String, Object> argsMap = new HashMap<String, Object>();
        String cmdName = null;

        if (cmdLine != null && !cmdLine.trim().isEmpty())
        {
            cmdLine = cmdLine.trim();
            String[] tokens = cmdLine.split("[ ]+(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            cmdName = tokens[0];

            String option = null;
            String optionValue = null;

            // if there are arguments
            if (tokens.length > 1)
            {
                String[] argsString = Arrays.copyOfRange(tokens, 1, tokens.length);

                for (String args : argsString)
                {
                    if (args.contains("=") == true)
                    {
                        option = args.substring(0, args.indexOf('='));
                        if (argsMap.get(option) != null)
                        {
                            repeatedOption = true;
                        }
                        optionValue = args.substring(args.indexOf('=') + 1);
                        argsMap.put(option, StringUtils.strip(optionValue, "\""));
                    }
                    else
                    {
                        if (argsMap.get(COMMAND_WITH_SINGLE_ARG) != null)
                        {
                            multipleSingleCommands = true;
                        }
                        argsMap.put(COMMAND_WITH_SINGLE_ARG, args);
                    }
                }
            }
        }

        return launchCommand(ctx, repeatedOption, multipleSingleCommands, argsMap, cmdName);
    }

    private boolean launchCommand(Context ctx, boolean repeatedOption, boolean multipleSingleCommands, Map<String, Object> argsMap, String cmdName)
    {
        Command cmd = null;
        boolean handled = false;

        if (commands != null && (cmd = commands.get(cmdName)) != null)
        {
            ctx.putValue(Context.KEY_COMMAND_LINE_ARGS, argsMap);

            if (multipleSingleCommands)
            {
                argsMap.put(EpsCliConstants.ERROR_INDICATOR_IN_COMMAND_STRUCTURE, EpsCliConstants.MULTIPLE_COMMANDS);
            }
            else if (repeatedOption)
            {
                argsMap.put(EpsCliConstants.ERROR_INDICATOR_IN_COMMAND_STRUCTURE, EpsCliConstants.REPEATED_OPTION);
            }
            try
            {
                if (!cmdName.equals(EXIT_COMMAND) && ctx.getValue(EpsCliConstants.EXPLICIT_ERROR_CODE) != null)
                {
                    ctx.removeValue(EpsCliConstants.EXPLICIT_ERROR_CODE);
                }
                cmd.execute(ctx);
            }
            catch (Exception se)
            {
                printException(se, ctx);
            }
            handled = true;
        }
        else
        {
            handled = false;
        }

        return handled;
    }

   // @Override
    public void plug(Context plug)
    {
        super.plug(plug);

        List<Command> epsCommands = new ArrayList<Command>();

        epsCommands.addAll(plug.getCommandsByNamespace(EpsCliConstants.DEFAULT_NAMESPACE));

        if (epsCommands.size() > 0)
        {
            commands = plug.mapCommands(epsCommands);

            Set<String> cmdHints = new TreeSet<String>();

            // plug each Command instance and collect input hints
            for (Command cmd : epsCommands)
            {
                cmd.plug(plug);
                cmdHints.addAll(collectInputHintsEps(cmd));
            }

            // save expected command input hints
            setExpectedInputs(cmdHints.toArray(new String[0]));
        }
        else
        {
            plug.getIoConsole().writeOutput(
                    String.format("%nNo commands were found for input controller"));
        }
    }

    private void printException(Exception ex, Context ctx)
    {
        ctx.getIoConsole().writeOutput(String.format("%n%s%n", "Internal Error occured while executing the command."));
        ctx.getIoConsole().writeOutput(String.format("%n%s%n%n", "Details : " + ex.getLocalizedMessage()));
    }

    /**
     * This method collects the hints that are attached to a command and format them as "cmdName", "cmdName option1", "cmdName option2", etc.
     * 
     * @param cmd
     *            the command to document
     * @return a Set<String> containing the hints.
     */
    protected Set<String> collectInputHintsEps(Command cmd)
    {
        Command.Descriptor desc = cmd.getDescriptor();

        if (desc == null)
        {
            return null;
        }

        Set<String> result = new TreeSet<String>();
        String cmdName = desc.getName();

        Map<String, String> args = desc.getArguments();

        if (args != null)
        {
        
            
                StringBuilder sb = new StringBuilder();
                sb.append(cmdName);

                for (String hint : args.keySet())
                {
                    sb.append(" ");
                    sb.append(hint);
                }

                result.add(String.format("%s", sb.toString()));

            }
           /* else if ( cmd.getCommandHintType().equals(CommandHintType.MULTIPLE))
            {
                result.add(desc.getName());

                for (String hint : args.keySet())
                {
                    // split hints in case they are as "option1, option2, etc"
                    String[] hintSet = hint.split("\\s*,\\s*");

                    for (String hintVal : hintSet)
                    {
                        result.add(String.format("%s %s", cmdName, hintVal));
                    }
                }
            }*/
        return result;
    }
}
