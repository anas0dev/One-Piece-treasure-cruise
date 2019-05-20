/**
 * Implementation of the 'hire' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;

import src.pkg_characters.*;

public class HireCommand extends Command {

	public HireCommand() {
		// TODO Auto-generated constructor stub
		command = "hire";
	}
	
	/**
	 * This function hire new crew to your ship 
	 * 
	 * @param player
	 */
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if((player.getSolde()-10)>0 ){
            player.setSolde(player.getSolde()-10);
            gui.setSolde(player.getSolde());
            player.setCrewNumber(player.getCrewNumber()+10);
            gui.setCrew(player.getCrewNumber());
            player.setStrength(player.getStrength()+5);
            gui.setStrength(player.getStrength());
            gui.print("Hiring new persons in da crew\n");
        }
        else{
            gui.print("You don't have enough money\n");
        }
		return false;
	}

}
