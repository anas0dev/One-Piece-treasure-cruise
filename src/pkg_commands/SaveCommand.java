/**
 * Implementation of the 'save' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;

import src.pkg_characters.*;

public class SaveCommand extends Command {

	public SaveCommand() {
		// TODO Auto-generated constructor stub
		command = "save";
	}
	
	/**
	 * this methode save the progression in the file
	 * 
	 *  @param player
	 */
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (!hasSecondWord()) {
            gui.println("<usage> you have to put a file name ");
            return false;
        }
		engine.getSave().rename(getSecondWord());
		
		return false;
	}

}
