package src;

public class QuitCommand extends Command {

	public QuitCommand() {
		// TODO Auto-generated constructor stub
		command = "quit";
	}
	
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
