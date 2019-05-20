/**
 * Implementation of the 'open' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;
import src.pkg_characters.*;

public class OpenCommand extends Command {

	public OpenCommand() {
		// TODO Auto-generated constructor stub
		command = "open";
	}
	
	/**
	 * This function allow the player to open a new exits for a room
	 * 
	 * @param player
	 */
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(player.getLocation() == engine.getScenario().getRoomByName("pontDuJoie")){
            if(player.getMagicKeys() == 4){
            	engine.getScenario().getRoomByName("pontDuJoie").setExits("east", engine.getScenario().getWinRoom());
                gui.println("Door Opening ...");
                gui.setButtonColor(engine.getCurrentRoom().getExitButton());
            }else{
                gui.println("You must have 4 key before \n");
            }
        }
        else if(player.getLocation() == engine.getScenario().getRoomByName("tatami")){
            if(player.checkItemInTheBag("darkaKey") != null){
            	engine.getScenario().getRoomByName("tatami").setExits("north", engine.getScenario().getRoomByName("darka"));
                gui.println("Cool you got the key there a new room north");
                gui.setButtonColor(engine.getCurrentRoom().getExitButton());
            }
        }
        else if(player.getLocation() == engine.getScenario().getRoomByName("krakenland")){
            if(player.checkItemInTheBag("OrtopiaKey") != null){
            	engine.getScenario().getRoomByName("krakenland").setExits("south", engine.getScenario().getRoomByName("ortopia"));
                gui.println("Door south opened ");
                gui.setButtonColor(engine.getCurrentRoom().getExitButton());
            }
        }
		return false;
	}

}
