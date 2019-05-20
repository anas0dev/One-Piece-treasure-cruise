package src.pkg_commands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCommand extends Command {

	public TestCommand() {
		// TODO Auto-generated constructor stub
		command = "test";
	}
	
	@Override
	public boolean execute(Player player) {
		// TODO Auto-generated method stub
		if (!hasSecondWord()) {
            gui.println("\n<usage> you have to put a file name ");
            return false;
        }
		
        String line = null;
        String fileName = "testFiles/" + getSecondWord();
        
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                engine.interpretCommand(engine.getParser().getCommand(line));
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
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
