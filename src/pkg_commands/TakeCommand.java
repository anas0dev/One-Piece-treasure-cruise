/**
 * Implementation of the 'take' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;

import src.pkg_characters.*;

public class TakeCommand extends Command {

	public TakeCommand() {
		// TODO Auto-generated constructor stub
		command = "take";
	}
	
	/**
	* This function allow to the player to pick up things in the room 
	* 
	*  @param player
	*/
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(!hasSecondWord()) {
    		gui.print("take What ?");
    		return false;
    	}
        String newItem = getSecondWord();
        if(engine.getCurrentRoom().checkItemInTheRoom(newItem) != null){
        	if(player.checkWeight(player, engine.getCurrentRoom().checkItemInTheRoom(newItem))){
                if(engine.getCurrentRoom().checkItemInTheRoom(newItem).getName() == "money"){
                    player.setSolde(engine.getCurrentRoom().checkItemInTheRoom(newItem).getPrice() + player.getSolde());
                    gui.setSolde(player.getSolde());
                    gui.print("You are rich !");
                }
                else if(engine.getCurrentRoom().checkItemInTheRoom(newItem).getName() == "magicKey"){
                    player.setMagicKeys(player.getMagicKeys() + 1);
                    gui.setKeys(player.getMagicKeys());
                    engine.getCurrentRoom().removeItems(newItem);
                    gui.println("Good find out other key");
                }
                else{
        		    player.addItemToBag(player, engine.getCurrentRoom().checkItemInTheRoom(newItem));
        		    engine.getCurrentRoom().removeItems(newItem);
                    gui.setBagContain(player.getTotalWeight(),player.getWeight() + player.getTotalWeight());
                    gui.println("You just took a " + newItem);
                }

        	}else {
                gui.print("You cannot pick up this item it's too heavy");
                gui.print("\n");
        	}
        }else{
            gui.print("You cannot carry this item maybe does'nt exist");
            gui.print("\n");
        }  
		return false;
	}

}
