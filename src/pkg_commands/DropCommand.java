/**
 * Implementation of the 'drop' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;

import src.pkg_characters.*;
public class DropCommand extends Command {

	public DropCommand() {
		// TODO Auto-generated constructor stub
		command = "drop";
	}
	
	/**
	* This function allow to the player to drop things from his bag in the acual room 
	* 
	* @param player
	*/
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(!hasSecondWord()) {
    		gui.print("Drop What ?");
    		return false;
    	}
		
    	String dropItem = getSecondWord();
        if(player.checkItemInTheBag(dropItem) != null){
        	engine.getCurrentRoom().addItems(dropItem, player.checkItemInTheBag(dropItem));
            player.removeItemFromBag(dropItem);
            gui.setBagContain(player.getTotalWeight(), player.getWeight() + player.getTotalWeight());
            gui.println("You dropped " + dropItem);
        }
        else{
            gui.print("Item does'nt present in your bag");
            gui.print("\n");
        }
		return false;
	}

}
