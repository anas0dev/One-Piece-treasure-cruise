//import java.util.Stack;

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
    //private Stack<String> deplacement;

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
        gui.print("Bienvenue à " + this.currentRoom.getExitString()+"\n");
        gui.showImage(this.currentRoom.getImageName());
    }

    private void createRooms()
    {

      
        // create the rooms
        Room kokoyashi = new Room("Kokoyashi", "kokoyashi.png");
        
        Room nooberland = new Room("Nooberland", "Nooberland.png");
        nooberland.addTresor(new Item("carte de grand line", 1000));
        nooberland.addTresor(new Item("viande", 20));
        nooberland.addTresor(new Item("or", 100));
        Room wano_kuni = new Room("Wano_kuni", "wanokuni.png");
        wano_kuni.addTresor(new Item("Ponigriphe", 0));
        Room water7 = new Room("Water7", "Water_Seven.png");
        water7.addTresor(new Item("viande", 40));
        Room kalen = new Room("Kalen", "kalen.png");
        kalen.addTresor(new Item("coffre au tresor", 2000));
        Room ortopia = new Room("Ortopia", "Ortopia.png");
        ortopia.addTresor(new Item("or", 50));
        Room alabasta = new Room("Alabasta", "Alabasta.png");
        alabasta.addTresor(new Item("Ponigriphe", 0));
        Room krakenland = new Room("Krakenland", "Krakenland.png");
        krakenland.addTresor(new Item("viande", 10));
        Room amazone_lily = new Room("Amazone_lily", "AmazoneLily.png");
        amazone_lily.addTresor(new Item("carte de vie", 2));
        Room skypia = new Room("Skypia", "skypia.png");
        skypia.addTresor(new Item("Ponigriphe", 0));
        skypia.addTresor(new Item("coffre au tresor", 2000));
        Room paris8 = new Room("Paris8, il semble que vous avez découvert une île absente sur votre carte, et si vous l'exploriez ?", "Paris8.png");
        paris8.addTresor(new Item("l'histoire oblier", 2));
        Room raftel = new Room("Raftel, ~votre log pose n'arrête pas de s'agiter ...~", "raftel.png");
        raftel.addTresor(new Item("one piece", 0));
        
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
        skypia.setExits(paris8, krakenland, kalen, null, null, raftel, null, null);
        paris8.setExits(null, null, skypia, null, null, null, null, null);
        raftel.setExits(null, null, null, null, null, null, skypia, null);

        this.currentRoom = kokoyashi;  // start game outside
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
        Room nextRoom = this.currentRoom.getExit(direction);

        if (nextRoom == null)
            gui.println("There is no door!");
        else {
        	//this.deplacement.add(new String(direction));
            this.currentRoom = nextRoom;
            gui.println(this.currentRoom.getLongDescription());
            gui.println("Vous remarquez des objet a terre, oh il y a :");
            gui.println(this.currentRoom.printTresor());
            if(this.currentRoom.getImageName() != null)
                gui.showImage(this.currentRoom.getImageName());
        }
    }
    /**
     * Cette méthode permet de connaître sa position
     */
    private void look()
    {
    	gui.println("Vous êtes actuellement à " + this.currentRoom.getLongDescription());
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

