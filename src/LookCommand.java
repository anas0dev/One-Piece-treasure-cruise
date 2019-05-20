package src;

public class LookCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.print(engine.getCurrentRoom().getLongDescription());
        gui.print("\n");
		return false;
	}

}
