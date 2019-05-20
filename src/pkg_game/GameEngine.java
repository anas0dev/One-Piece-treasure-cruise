
/**
*  This class is part of the "World of Zuul" application. 
*  "World of Zuul" is a very simple, text based adventure game.
* 
*  This class creates all rooms, creates the parser and starts
*  the game.  It also evaluates and executes the commands that 
*  the parser returns.
* 
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/
package src.pkg_game;

import src.pkg_utils.*;
import src.pkg_characters.*;
import src.pkg_commands.*;
import java.util.Stack;
import java.time.LocalTime;

public class GameEngine {

    private Parser parser;
	private Room currentRoom;
	private UserInterface gui;
    private Stack<Room> displacement;
	private Player player;
	private Room beamerCharged;
	private Scenario scenario;
	private Save save;

    /**
     * Create the game and initialise its internal map.
     */
    public GameEngine() {
        parser = new Parser();
        displacement = new Stack<Room>();
        player = new Player("sangoku", 250, currentRoom, 50, 50, 0, 30, 3);
        scenario = new Scenario();
        currentRoom = scenario.getStartRoom();
        save = new Save();
    }

    /***
     * The play function that allow to get real time the player will have 20 minute
     * to win or he will die the crew also die every 1 minutes if he hav'nt
     * resources he must eat
     * 
     * @param userInterface
     */
    public void play(UserInterface userInterface) {
        setGUI(userInterface);
        printWelcome();
        int finish = 0;
        // Maybe giving some extra time
        LocalTime time = LocalTime.now();
        LocalTime localTime3 = time.plusMinutes(10);
        LocalTime breakfeastTime = time.plusMinutes(1);

        do {
            LocalTime currentTime = LocalTime.now();
            if (currentTime.getMinute() == localTime3.getMinute()) {
                new QuitCommand();
                finish = 1;
            }
            if (currentTime.getMinute() == breakfeastTime.getMinute()) {
                player.setStrength(player.getStrength() - 10);
                gui.setStrength(player.getStrength());
                breakfeastTime = currentTime.plusMinutes(1);
            }

            if (player.getStrength() <= 0 || player.getLife() == 0) {
                new QuitCommand();
                finish = 1;
            }
            if (player.checkItemInTheBag("OnePiece") != null) {
                winGame();
                finish = 1;
            }
        } while (finish != 1);
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        gui.print("\n");
        gui.println("Welcome to One Piece treasure cruise!");
        gui.println("One Piece is a Fantastic adventure game.");
        gui.println("You must find ou 4 key to get to the final room and kill the boss\nif you pick up the coin you'll win");
        gui.println("Type 'help' if you need help.");
        gui.println(currentRoom.getLongDescription());
        gui.showImage(currentRoom.getImageName());
    }

    /**
     * Given a command, process (that is: execute) the command. If this command ends
     * the game, true is returned, otherwise false is returned.
     * 
     * @param command
     */
    public void interpretCommand(Command command) {
    	command.setGui(this.gui);
    	command.setEngine(this);
    	command.execute(player);

        save.save(command.getCommand() + " " + command.getSecondWord());
    }
  
    /**
     * Print wining case and enable the entry fields 
     */
    private void winGame() {
        save.clearFile();
        currentRoom.setImageName("src/images/win.jpg");
        gui.showImage(currentRoom.getImageName());
		gui.println("Youu WINNNNNNNN!\nThank you for playing.  Good bye !");
        gui.enable(false);
    }
    
    /**
     * Get the save
     */
    public Save getSave() {
		return save;
	}

    /**
     * Set the save
     * 
     * @param save
     */
	public void setSave(Save save) {
		this.save = save;
	}
    
	/**
	 * Get the beamerCharged
	 */
    public Room getBeamerCharged() {
		return beamerCharged;
	}

    /**
     * Set the beamerCharged
     * 
     * @param beamerCharged
     */
	public void setBeamerCharged(Room beamerCharged) {
		this.beamerCharged = beamerCharged;
	}
    
	/**
	 * Get the displacement
	 */
    public Stack<Room> getDisplacement() {
		return displacement;
	}

    /**
     * Set the displacement
     * 
     * @param displacement
     */
	public void setDisplacement(Stack<Room> displacement) {
		this.displacement = displacement;
	}
	
	/**
	 * Get the scenario
	 */
	public Scenario getScenario() {
		return scenario;
	}
	
	/**
	 * Get the parser
	 */
    public Player getPlayer() {
		return player;
	}

    /**
     * Set the parser
     * 
     * @param player
     */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Set the scenario
	 * 
	 * @param scenario
	 */
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	

	/**
	 * Get the parser
	 */
    public Parser getParser() {
		return parser;
	}

    /**
     * Set the parser
     * 
     * @param parser
     */
	public void setParser(Parser parser) {
		this.parser = parser;
	}
	
	/**
	 * Get the currentRoom
	 */
	public Room getCurrentRoom() {
		return currentRoom;
	}

	/**
	 * Set the crrentRoom
	 * 
	 * @param currentRoom
	 */
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	/**
     * Set the userInterface
     * 
     * @param userInterface
     */
    public void setGUI(UserInterface userInterface) {
        gui = userInterface;
    }
}
