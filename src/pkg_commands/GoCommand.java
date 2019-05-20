/**
 * Implementation of the 'go' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;

import src.pkg_characters.Player;
import src.pkg_utils.*;
public class GoCommand extends Command {
	
	public GoCommand() {
		command = "go";
	}
	
	/** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message. Returns always 'false'.
     * 
     * @param player
     */
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(hasSecondWord()) {
            String direction = getSecondWord();

            // Try to leave current room.
            Room nextRoom = engine.getCurrentRoom().getExit(direction);
            gui.getEngine().getDisplacement().push(engine.getCurrentRoom());
            if (nextRoom == null)
                gui.println("There is no door!");
            else {
            	player.setLocation(nextRoom);
            	engine.setCurrentRoom(nextRoom);
                gui.println(engine.getCurrentRoom().getLongDescription());
                
                gui.setButtonColor(engine.getCurrentRoom().getExitButton());
                gui.setTitle(engine.getCurrentRoom().getName());
                gui.showImage(engine.getCurrentRoom().getImageName());
                if(engine.getCurrentRoom().getImageName() != null)
                    gui.showImage(engine.getCurrentRoom().getImageName());
            }
        }
        else {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
        }
		return false;
	}

}
