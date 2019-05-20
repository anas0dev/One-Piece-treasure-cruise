/**
 * Implementation of the 'look' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;
import src.pkg_characters.*;

public class LookCommand extends Command {

	public LookCommand() {
		// TODO Auto-generated constructor stub
		command = "look";
	}
	/**
	* Print the long description of the room
	* 
	* @param player
	*/
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.print(engine.getCurrentRoom().getLongDescription());
        gui.print("\n");
		return false;
	}

}
