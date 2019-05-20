package src;
/**
* Representations for all the valid command words for the game. 
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/
public enum CommandWord
{
    // A value for each command word, plus one for unrecognised
    // commands.
    GO(new GoCommand()), QUIT(new QuitCommand()), HELP(new HelpCommand()), LOOK(new LookCommand()), EAT(new EatCommand()), BACK(new BackCommand()), TEST(new TestCommand());//, TAKE("take"), DROP("drop"), CHECK("check"),OPEN("open"),PAY("pay"),CHARGE("charge"),FIRE("fire"),TALK("talk"),GIVE("give"),ATTACK("attack"),HIRE("hire"),RECOVER("recover"),SAVE("save"),UNKNOWN("?");
	
	//The commandString
    private Command command;
    
    /**
    * Initialise with the corresponding command word.
    * @param commandWord The command string.
    */ 
    CommandWord(Command command){
        this.command = command;
    }
    
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