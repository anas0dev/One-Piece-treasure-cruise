package src.pkg_commands;
import src.pkg_characters.*;

public class UnknownCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.println("I do not understand !!");
		return false;
	}

}
