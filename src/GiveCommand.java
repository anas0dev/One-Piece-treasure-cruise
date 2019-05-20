package src;

public class GiveCommand extends Command {

	public GiveCommand() {
		// TODO Auto-generated constructor stub
		command = "give";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if(!hasSecondWord()){
            gui.print("Give What ?");
            return false;
        }
		
        String givenItem = getSecondWord();
        if(engine.getCurrentRoom().checkCharatersInTheRoom("wanoKuni") != null){
            if(player.getSolde() - engine.getCurrentRoom().checkCharatersInTheRoom("wanoKuni").getItem().getPrice() > 0){
                player.setSolde(player.getSolde() - engine.getCurrentRoom().checkCharatersInTheRoom("wanoKuni").getItem().getPrice());
                gui.setSolde(player.getSolde());
                gui.println(engine.getCurrentRoom().checkCharatersInTheRoom("wanoKuni").getHelp());
            }else{
                gui.println("You don't have enough money Sorry");
            }
        }
        else if(engine.getCurrentRoom().checkCharatersInTheRoom("pontDuJoie") != null){
            if(player.getSolde() - engine.getCurrentRoom().checkCharatersInTheRoom("pontDuJoie").getItem().getPrice() > 0){
                player.setSolde(player.getSolde() - engine.getCurrentRoom().checkCharatersInTheRoom("pontDuJoie").getItem().getPrice());
                gui.setSolde(player.getSolde());
                gui.println(engine.getCurrentRoom().checkCharatersInTheRoom("pontDuJoie").getHelp());
            }else{
                gui.println("You don't have enough money Sorry");
            }
        }
        else{
            if(player.checkItemInTheBag(givenItem) != null){
                gui.print(engine.getCurrentRoom().giveCharactersItem(player.checkItemInTheBag(givenItem)));
                player.removeItemFromBag(givenItem);
                gui.setBagContain(player.getTotalWeight(), player.getWeight() + player.getTotalWeight());
            }
            else{
                gui.print("You don't have this item in your bag !");
            }
        }
		return false;
	}

}
