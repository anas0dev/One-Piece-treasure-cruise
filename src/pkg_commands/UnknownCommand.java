/**
 * Implementation of the 'unknown' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;
import src.pkg_characters.*;

public class UnknownCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.println("I do not understand !!");
		return false;
	}

}
