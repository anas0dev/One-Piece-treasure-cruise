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
    GO(new GoCommand());//, QUIT("quit"), HELP("help"), LOOK("look"), EAT("eat"), BACK("back"), TEST("test"), TAKE("take"), DROP("drop"), CHECK("check"),OPEN("open"),PAY("pay"),CHARGE("charge"),FIRE("fire"),TALK("talk"),GIVE("give"),ATTACK("attack"),HIRE("hire"),RECOVER("recover"),SAVE("save"),UNKNOWN("?");
	
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
//    public String toString(){
//        return commandString;
//    }
}