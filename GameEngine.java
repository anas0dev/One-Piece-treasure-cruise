/**
 *  This class is part of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.
 * 
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that 
 *  the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (Jan 2003)
 */
public class GameEngine {
	
	private Parser parser;
    private Room currentRoom;
    private UserInterface gui;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        parser = new Parser();
        createRooms();
    }

    public void setGUI(UserInterface userInterface)
    {
        gui = userInterface;
        printWelcome();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        gui.println("Bienvenue dans One Piece treasure cruise");
        gui.println("Imergez vous dans une odyssée de pirate purement \n"+
        		"ludique et palpitante.");
        gui.println("Le but du jeu est de parcourir toute la mer afin \n"+
        		"de trouver le One Piece et devenir le roi des pirates !");
        gui.println("Les iles connues à ce jour sont les suivantes : \n"+
        		"Alabasta, Amazone Lily, Kokoyashi, Kalen, Krakenland \nNooberland, Ortopia, Raftel, Skypia, Water7, Wano-Kuni \n");
        gui.println("Tapez 'help' si vous avez besoin d'aide.");
        gui.print("Bienvenue à " + currentRoom.getExitString()+"\n");
        gui.showImage(currentRoom.getImageName());
    }

    private void createRooms()
    {

      
        // create the rooms
        Room kokoyashi = new Room("Kokoyashi", "kokoyashi.png");
        Room nooberland = new Room("Nooberland", "nooberland.png");
        Room wano_kuni = new Room("Wano_kuni", "Wano_kuni");
        Room water7 = new Room("Water7", "Water7");
        Room kalen = new Room("Kalen", "Kalen");
        Room ortopia = new Room("Ortopia", "Ortopia");
        Room alabasta = new Room("Alabasta", "Alabasta");
        Room krakenland = new Room("Krakenland", "Krakenland");
        Room amazone_lily = new Room("Amazone_lily", "Amazone_lily");
        Room skypia = new Room("Skypia", "Skypia");
        Room paris8 = new Room("Paris8, il semble que vous avez découvert une île absente sur votre carte, et si vous l'exploriez ?", "Paris8");
        Room rafel = new Room("Rafel, ~votre log pose n'arrête pas de s'agiter ...~", "Rafel");
        
        // initialise room exits
        kokoyashi.setExits(nooberland, null, null, null, null, null, null, null);
        nooberland.setExits(null, water7, kokoyashi, wano_kuni, kalen, alabasta, null, null);
        wano_kuni.setExits(null, nooberland, null, null, null, null, null, null);
        water7.setExits(null, null, null, nooberland, null, null, null, null);
        kalen.setExits(skypia, null, null, null, null, null, null, nooberland);
        ortopia.setExits(krakenland, null, null, kalen, null, amazone_lily, null, null);
        alabasta.setExits(null, null, null, null, null, null, nooberland, null);
        krakenland.setExits(null, null, ortopia, skypia, null, null, null, null);
        amazone_lily.setExits(null, null, null, null, null, null, ortopia, null);
        skypia.setExits(paris8, krakenland, kalen, null, null, rafel, null, null);
        paris8.setExits(null, null, skypia, null, null, null, null, null);
        rafel.setExits(null, null, null, null, null, null, skypia, null);

        currentRoom = kokoyashi;  // start game outside
    }
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = parser.getCommand(commandLine);

        if(command.isUnknown()) {
            gui.println("Je ne comprend pas ce que vous voulez dire...");
            return;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("look"))
            look();
        else if (commandWord.equals("eat"))
            eat();
        else if (commandWord.equals("quit")) {
            if(command.hasSecondWord())
                gui.println("Quit what?");
            else
                endGame();
        }
    }
    private void printHelp() 
    {
        gui.println("Vous êtes perdus sur cette vague merr");
        gui.print("Vos mots de commande sont " + parser.showCommands());
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            gui.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null)
            gui.println("There is no door!");
        else {
            currentRoom = nextRoom;
            gui.println(currentRoom.getLongDescription());
            if(currentRoom.getImageName() != null)
                gui.showImage(currentRoom.getImageName());
        }
    }
    /**
     * Cette méthode permet de connaître sa position
     */
    private void look()
    {
    	gui.println("Vous êtes actuellement à " + currentRoom.getLongDescription());
    }
    
    /**
     * Cette m�thode permet de manger
     */
     private void eat() 
    {
        gui.println("Tu as mangé maintenant et tu n'as plus faim.");
        
    }


    private void endGame()
    {
        gui.println("Merci d'avoir joué, à bientôt !");
        gui.enable(false);
    }

}

