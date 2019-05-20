package src.pkg_commands;


public class SaveCommand extends Command {

	public SaveCommand() {
		// TODO Auto-generated constructor stub
		command = "save";
	}

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (!hasSecondWord()) {
            gui.println("<usage> you have to put a file name ");
            return false;
        }
		engine.getSave().rename(getSecondWord());
		
		return false;
	}

}
