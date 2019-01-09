package com.ganga.command;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

public class HelpCmd implements Command {
	private static final String NAMESPACE = "syscmd";
	private static final String CMD_NAME = "help";
	private HelpCmdDescriptor descriptor;

	private class HelpCmdDescriptor implements Command.Descriptor {
		private HelpCmdDescriptor() {
		}

		public String getNamespace() {
			return "syscmd";
		}

		public String getName() {
			return "help";
		}

		public String getDescription() {
			return "Displays help information for available commands.";
		}

		public String getUsage() {
			return "Type 'help' or 'help [command_name]' ";
		}

		public Map<String, String> getArguments() {
			return Collections.emptyMap();
		}
	}

	public Command.Descriptor getDescriptor() {
		return this.descriptor;
	}

	public Object execute(Context ctx) {
		String[] args = (String[]) ctx.getValue("key.commandParams");
		if ((args != null) && (args.length > 0)) {
			printCommandHelp(ctx, args[0].trim());
		} else {
			printAllHelp(ctx);
		}
		ctx.getIoConsole().writeOutput(String.format("%n%n", new Object[0]));
		return null;
	}

	public void plug(Context plug) {
	}

	private void printCommandHelp(Context ctx, String cmdName) {
		Map<String, Command> commands = ctx.mapCommands(ctx.getCommands());
		if (commands != null) {
			Command cmd = (Command) commands.get(cmdName.trim());
			if (cmd != null) {
				printCommandHelp(ctx, cmd);
			} else {
				ctx.getIoConsole().writeOutput(
						String.format(
								"%nHelp for Command [%s] cannot not found.",
								new Object[] { cmdName }));
			}
		}
	}

	private void printCommandHelp(Context ctx, Command cmd) {
		if ((cmd != null) && (cmd.getDescriptor() != null)) {
			ctx.getIoConsole().writeOutput(
					String.format("%nCommand: %s - %s%n", new Object[] {
							cmd.getDescriptor().getName(),
							cmd.getDescriptor().getDescription() }));
			ctx.getIoConsole().writeOutput(
					String.format("Usage: %s", new Object[] { cmd
							.getDescriptor().getUsage() }));
			printCommandParamsDetail(ctx, cmd);
		} else {
			ctx.getIoConsole().writeOutput(
					String.format("%nUnable to display help for command.",
							new Object[0]));
		}
	}

	private void printCommandParamsDetail(Context ctx, Command cmd) {
		Command.Descriptor desc = cmd.getDescriptor();
		if ((desc == null) || (desc.getArguments() == null)) {
			return;
		}
		IOConsole c = ctx.getIoConsole();
		c.writeOutput(String.format("%nOptions:", new Object[0]));
		c.writeOutput(String.format("%n--------", new Object[0]));
		for (Map.Entry<String, String> entry : desc.getArguments().entrySet()) {
			c.writeOutput(String.format("%n%1$25s\t%2$s",
					new Object[] { entry.getKey(), entry.getValue() }));
		}
	}

	private void printAllHelp(Context ctx) {
		IOConsole c = ctx.getIoConsole();
		c.writeOutput(String.format("%nAvailable Commands", new Object[0]));
		c.writeOutput(String.format("%n------------------", new Object[0]));
		List<Command> commands = ctx.getCommands();
		for (Command cmd : commands) {
			c.writeOutput(String.format("%n%1$10s %2$5s %3$s", new Object[] {
					cmd.getDescriptor().getName(), " ",
					cmd.getDescriptor().getDescription() }));
		}
	}
}
