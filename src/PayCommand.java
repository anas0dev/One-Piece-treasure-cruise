package src;

public class PayCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(player.getLocation() == engine.getScenario().getRoomByName("elMourouj")){
            if(player.getSolde()-10 >= 0){
                player.setSolde(player.getSolde() - 10);
                gui.setSolde(player.getSolde());
                gui.println("Thank you see you soon");
                engine.getScenario().getRoomByName("elMourouj").setExits("southEast", engine.getScenario().getRoomByName("laMarsa"));
                engine.getScenario().getRoomByName("elMourouj").setExits("southWest", engine.getScenario().getRoomByName("rafel"));
                gui.setButtonColor(engine.getCurrentRoom().getExitButton());
            }else{
                gui.println("You don't have enough money sorry");
                new QuitCommand();
            }
        }
		return false;
	}

}
