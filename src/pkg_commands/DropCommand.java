package src.pkg_commands;

import src.pkg_characters.*;
public class DropCommand extends Command {

	public DropCommand() {
		// TODO Auto-generated constructor stub
		command = "drop";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(!hasSecondWord()) {
    		gui.print("Drop What ?");
    		return false;
    	}
		
    	String dropItem = getSecondWord();
        if(player.checkItemInTheBag(dropItem) != null){
        	engine.getCurrentRoom().addItems(dropItem, player.checkItemInTheBag(dropItem));
            player.removeItemFromBag(dropItem);
            gui.setBagContain(player.getTotalWeight(), player.getWeight() + player.getTotalWeight());
            gui.println("You dropped " + dropItem);
        }
        else{
            gui.print("Item does'nt present in your bag");
            gui.print("\n");
        }
		return false;
	}

}
