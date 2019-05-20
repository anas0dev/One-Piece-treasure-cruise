/**
 * Implementation of the 'talk' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;
import src.pkg_characters.*;

public class TalkCommand extends Command {

	public TalkCommand() {
		// TODO Auto-generated constructor stub
		command = "talk";
	}
	
	/**
	 * This function allows the player to talk with characters 
	 * 
	 * @param player
	 */
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.println(engine.getCurrentRoom().getCharactersHi());
		return false;
	}

}
