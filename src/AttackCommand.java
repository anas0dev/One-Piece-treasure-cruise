package src;

public class AttackCommand extends Command {

	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (!hasSecondWord()) {
            gui.print("attack Who ?");
            return false;
        }
        String name = getSecondWord();
        if (engine.getCurrentRoom().checkEnemiesInTheRoom(name).getStrength() < player.getStrength()) {
        	engine.getCurrentRoom().addItems(engine.getCurrentRoom().checkEnemiesInTheRoom(name).getItem().getName(),
        			engine.getCurrentRoom().checkEnemiesInTheRoom(name).getItem());
        	engine.getCurrentRoom().removeEnemy(engine.getCurrentRoom().checkEnemiesInTheRoom(name).getName());
            gui.println("Enemy killed");
        } else {
            if (player.getCrewNumber() - 10 <= 0) {
                player.setLife(player.getLife() - 1);
                gui.setLife(player.getLife());
            } else {
                player.setCrewNumber(player.getCrewNumber() - 10);
                gui.setCrew(player.getCrewNumber());
                gui.println("Enemy kill some of your crew\n");
            }
        }
		return false;
	}

}
