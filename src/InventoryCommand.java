package src;

public class InventoryCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.print(player.showMyBag());
        gui.print("\n");
		return false;
	}

}
