/**
 * Implementation of the 'back' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;

import src.pkg_characters.*;


public class BackCommand extends Command {
	
	public BackCommand() {
		// TODO Auto-generated constructor stub
		command = "back";
	}

	/**
     * Get you back to the room just before
     * 
     * @param player
     */
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (engine.getDisplacement().isEmpty()) {
            gui.println("You are at the start Point");
            gui.setButtonColor(engine.getCurrentRoom().getExitButton());
        } else {
            engine.setCurrentRoom(engine.getDisplacement().pop());
            gui.println("You back to " + engine.getCurrentRoom().getDescription());
            gui.println("You Maybe Missed those " + engine.getCurrentRoom().getItemsDescription());
            gui.setButtonColor(engine.getCurrentRoom().getExitButton());
            if (engine.getCurrentRoom().getImageName() != null)
                gui.showImage(engine.getCurrentRoom().getImageName());
        }
		return false;
	}

}
