package src.pkg_commands;

public class FireCommand extends Command {

	public FireCommand() {
		// TODO Auto-generated constructor stub
		command = "fire";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(engine.getBeamerCharged() != null){
            engine.setCurrentRoom(engine.getBeamerCharged());
            gui.println("You was teleported to " + engine.getCurrentRoom().getDescription());
            gui.println("You Maybe Missed those "+engine.getCurrentRoom().getItemsDescription());
            if(engine.getCurrentRoom().getImageName()!=null){
                gui.showImage(engine.getCurrentRoom().getImageName());
            }
        }
        else{
            gui.println("charge your beamer before please");
        }
		return false;
	}

}