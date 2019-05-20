/**
 * Implementation of the 'eat' user command.
 * 
 * @author  Université Paris8 Groupe5 
 * @version 3.0 (May 2019)
 */
package src.pkg_commands;

import src.pkg_characters.*;
public class EatCommand extends Command {

	public EatCommand() {
		// TODO Auto-generated constructor stub
		command = "eat";
	}
	
	/**
	 * This function allow the user to things eatable of course in his bag
	 * 
	 * @param player
	 */
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(!hasSecondWord()) {
    		gui.print("Eat What ?");
    		return false;
    	}
		
    	String eatItem = getSecondWord();
        String[] validItemToEat = {"cookie", "apple", "kiwi", "banana", "amande", "avocat", "orange", "watermelon"};
        
        for(int i = 0; i < validItemToEat.length; i++){
            if(eatItem.equals(validItemToEat[i])){
            	if(player.checkItemInTheBag(eatItem) != null){
                    if(player.checkItemInTheBag(eatItem).getName() == "cookie"){
                        gui.println("You eaten a " + eatItem);
                        player.setStrength(player.getStrength() + player.checkItemInTheBag("cookie").getPrice());
                        gui.setStrength(player.getStrength() + player.checkItemInTheBag("cookie").getPrice());
                        player.removeItemFromBag(eatItem);
                        player.setWeight((player.getWeight() * 2));
                        gui.setBagContain(player.getTotalWeight(), player.getWeight());
                    } 
                    else{
                        gui.println("You had eaten a " + eatItem);
                        player.setStrength(player.getStrength() + player.checkItemInTheBag(eatItem).getPrice());
                        gui.setStrength(player.getStrength());
                        player.removeItemFromBag(eatItem);
                        gui.setBagContain(player.getTotalWeight(), player.getWeight() + player.getTotalWeight());
                    }
            		
                }
            	else {
            		gui.print("Item does't exist in you bag");
            	}
            }
        }
		return false;
	}

}
