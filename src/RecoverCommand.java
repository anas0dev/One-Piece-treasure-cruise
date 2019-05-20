package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class RecoverCommand extends Command {
	
	public RecoverCommand() {
		// TODO Auto-generated constructor stub
		command = "recover";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (!hasSecondWord()) {
            gui.println("\n<usage> you have to put a file name ");
            return false;
        }
		
		engine.getSave().clearFile();
		engine.setDisplacement(new Stack<Room>());
		engine.setScenario(new Scenario());
		engine.setCurrentRoom(engine.getScenario().getStartRoom());
		engine.setPlayer(new Player("sangoku", 250, engine.getCurrentRoom(), 50, 50, 4, 800, 3));
		
        String line = null;
        String fileName = "savedGames/" + getSecondWord();
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                engine.interpretCommand(engine.getParser().getCommand(line));
            }  
            bufferedReader.close();         
        }
        catch(FileNotFoundException e) {
            gui.println("Unable to open file >" + fileName);
            return false;
        }
        catch(IOException e) {
        	gui.println("Error reading file >" + fileName);
        	return false;
        }
		return false;
	}

}
