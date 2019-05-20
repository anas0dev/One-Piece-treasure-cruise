/**
 * Print out some help information. Here we print some stupid, cryptic message
 * and a list of the command words.
 */
package src.pkg_commands;

import src.pkg_characters.*;

public class HelpCommand extends Command {
	
	public HelpCommand() {
		// TODO Auto-generated constructor stub
		command = "help";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.println("You are lost. You are alone. You wander");
        gui.print(engine.getParser().showCommands());
		return false;
	}

}
