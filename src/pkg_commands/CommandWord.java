/**
* Representations for all the valid command words for the game. 
* 
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/
package src.pkg_commands;

public enum CommandWord
{
    // A value for each command word, plus one for unrecognised
    // commands.
    GO(new GoCommand()), QUIT(new QuitCommand()), HELP(new HelpCommand()), LOOK(new LookCommand()), EAT(new EatCommand()), BACK(new BackCommand()), TEST(new TestCommand()), TAKE(new TakeCommand()), DROP(new DropCommand()), INVENTORY(new InventoryCommand()),OPEN(new OpenCommand()),PAY(new PayCommand()),CHARGE(new ChargeCommand()),FIRE(new FireCommand()),TALK(new TalkCommand()),GIVE(new GiveCommand()),ATTACK(new AttackCommand()),HIRE(new HireCommand()),RECOVER(new RecoverCommand()),SAVE(new SaveCommand()),UNKNOWN(new UnknownCommand());
	
	//The commandString
    private Command command;
    
    /**
    * Initialise with the corresponding command word.
    * 
    * @param commandWord The command string.
    */ 
    CommandWord(Command command){
        this.command = command;
    }
    
    /**
	 * Get the command
	 */
    public Command get() {
    	return this.command;
    }
    /**
    * @return The command word as a string.
    */
    public String toString(){
        return this.name().toLowerCase();
    }
}