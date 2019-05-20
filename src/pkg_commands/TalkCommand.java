package src.pkg_commands;

public class TalkCommand extends Command {

	public TalkCommand() {
		// TODO Auto-generated constructor stub
		command = "talk";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		gui.println(engine.getCurrentRoom().getCharactersHi());
		return false;
	}

}
