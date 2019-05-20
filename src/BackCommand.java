package src;

public class BackCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (engine.getDisplacement().isEmpty()) {
            gui.println("You are at the start Point");
            gui.setButtonColor(engine.getCurrentRoom().getExitButton());
        } else {
            engine.setCurrentRoom(engine.getDisplacement().pop());
            gui.println("You back to " + engine.getCurrentRoom().getDescription());
            gui.println("You Maybe Missed those " + engine.getCurrentRoom().getItemsDescription());
            gui.setButtonColor(engine.getCurrentRoom().getExitButton());
            if (engine.getCurrentRoom().getImageName() != null)
                gui.showImage(engine.getCurrentRoom().getImageName());
        }
		return false;
	}

}
