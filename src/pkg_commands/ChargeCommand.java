package src.pkg_commands;
import src.pkg_characters.*;

public class ChargeCommand extends Command {

	public ChargeCommand() {
		// TODO Auto-generated constructor stub
		command = "charge";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (player.checkItemInTheBag("beamer") != null) {
            if (player.checkItemInTheBag("ammo") != null) {
                player.removeItemFromBag("ammo");
                engine.setBeamerCharged(engine.getCurrentRoom());
            } else {
                gui.println("You are OUT OF AMMO");
            }
        } else {
            gui.println("You must have a beamer first");
        }
		return false;
	}

}
