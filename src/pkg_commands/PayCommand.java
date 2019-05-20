/**
 * Implementation of the 'pay' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;
import src.pkg_characters.*;

public class PayCommand extends Command {

	public PayCommand() {
		// TODO Auto-generated constructor stub
		command = "pay";
	}
	
	/**
	 * This function allows the player to pay bills to have exits room
	 * other case he lose
	 * 
	 * @param player
	 */
	@Override
	public boolean execute(Player player) {
        // TODO Auto-generated method stub
        
		if(player.getLocation() == engine.getScenario().getRoomByName("elMourouj")){
            if(player.getSolde()-10 >= 0){
                player.setSolde(player.getSolde() - 10);
                gui.setSolde(player.getSolde());
                gui.println("Thank you see you soon");
                engine.getScenario().getRoomByName("elMourouj").setExits("southEast", engine.getScenario().getRoomByName("laMarsa"));
                engine.getScenario().getRoomByName("elMourouj").setExits("southWest", engine.getScenario().getRoomByName("rafel"));
                gui.setButtonColor(engine.getCurrentRoom().getExitButton());
            }else{
                gui.println("You don't have enough money sorry");
                new QuitCommand();
            }
        }
		return false;
	}

}
