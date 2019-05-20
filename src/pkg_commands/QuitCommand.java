/**
 * Implementation of the 'quit' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;
import src.pkg_characters.*;

public class QuitCommand extends Command {

	public QuitCommand() {
		// TODO Auto-generated constructor stub
		command = "quit";
	}
	
	/**
	* Print goodbye and enable the entry field
	* 
	* @param player
	*/
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub		
		if (hasSecondWord()) {
			gui.println("Quit what?");
		}else {
			engine.getSave().clearFile();
	        engine.getCurrentRoom().setImageName("src/images/lose.jpg");
	        gui.showImage(engine.getCurrentRoom().getImageName());
			gui.println("Youu Loose !\nThank you for playing.  Good bye !");
	        gui.enable(false);
		}
		return false;
	}

}
