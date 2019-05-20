package src.pkg_commands;
import src.pkg_game.*;
import src.pkg_utils.*;
import src.pkg_characters.*;
/**
* This class is the main class of the "World of Zuul" application. 
* "World of Zuul" is a very simple, text based adventure game.  
*
* This class holds information about a command that was issued by the user.
* A command currently consists of two strings: a command word and a second
* word (for example, if the command was "take map", then the two strings
* obviously are "take" and "map").
* 
* The way this is used is: Commands are already checked for being valid
* command words. If the user entered an invalid command (a word that is not
* known) then the command word is <null>.
*
* If the command had only one word, then the second word is <null>.
* 
* @author  Universit� Paris8 Groupe5
* @version 3.0 (May 2019)
*/

public abstract class Command
{
//    private CommandWord commandWord;
	protected String command;
    private String secondWord;
    protected UserInterface gui;
    protected GameEngine engine;
    
	/**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command()
    {
        secondWord = null;
    }
    
    public Command(String secondWord)
    {
//        this.commandWord = firstWord;
        this.secondWord = secondWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     */
//    public CommandWord getCommandWord()
//    {
//        return commandWord;
//    }

    /**
     * Return the second word of this command. Returns null if there was no
     * second word.
     */
    public String getSecondWord()
    {
        return secondWord;
    }
    
    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String secondWord)
    {
        this.secondWord = secondWord;
    }

    /**
     * Return true if this command was not understood.
     */
//    public boolean isUnknown()
//    {
//        return (commandWord == CommandWord.UNKNOWN);
//    }

    /**
     * Return true if the command has a second word.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
    
    public UserInterface getGui() {
		return gui;
	}

	public void setGui(UserInterface gui) {
		this.gui = gui;
	}
	
	public GameEngine getEngine() {
		return engine;
	}

	public void setEngine(GameEngine engine) {
		this.engine = engine;
	}
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}
    
    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     * @return True, if game should exit; false otherwise.
     */
    public abstract boolean execute(Player player);
}

