package src;

public class TalkCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.println(engine.getCurrentRoom().getCharactersHi());
		return false;
	}

}
