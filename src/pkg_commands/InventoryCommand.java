package src.pkg_commands;

import src.pkg_characters.*;

public class InventoryCommand extends Command {

	public InventoryCommand() {
		// TODO Auto-generated constructor stub
		command = "inventory";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.print(player.showMyBag());
        gui.print("\n");
		return false;
	}

}
