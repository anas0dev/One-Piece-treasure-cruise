/** 
* This class is part of "One piece Treasure-cruise". "World of Zuul" is a simple adventure game.
*
* This parser takes user input and tries to interpret it as a "Zuul"
* command. Every time it is called it takes a line as a String and
* tries to interpret the line as a two word command. It returns the command
* as an object of class Command.
*
* The parser has a set of known command words. It checks user input against
* the known commands, and if the input is not one of the known commands, it
* returns a command object that is marked as an unknown command.
* 
* @author  Université Paris8 Groupe5 
* @version 3.0 (May 2019)
*/

package src.pkg_utils;

import src.pkg_commands.*;
import java.util.StringTokenizer;


public class Parser {

    private CommandWords commands;  
    /**
     * Create a new Parser.
     */
    public Parser() 
    {
        this.commands = new CommandWords();
    }

    /**
     * Get a new command from the user. The command is read by
     * parsing the 'inputLine'.
     */
    public Command getCommand(String inputLine) 
    {
        //String inputLine = "";   // will hold the full input line
        String word1=null;
        String word2=null;
        
       // inputLine = reader.nextLine();

        // Find up to two words on the line.
        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;
        
                
        Command command = this.commands.getCommandWord(word1).get();
        if(command != null) {
            command.setSecondWord(word2);
        }
        return command;

    }

    /**
     * Print out a list of valid command words.
     */
    public String showCommands()
    {
        return "Your command words are:\n\n"+this.commands.getCommandList();
    }
}
