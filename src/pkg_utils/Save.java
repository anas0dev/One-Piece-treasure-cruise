/**
* This class contains characters in the game which allow the player to talk 
* with characters. In case the player give an item to a characters if it's 
* the correct the characters give help to player
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/

package src.pkg_utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Defaut constructor 
 */
public class Save {
 
    
     /**
    * Saves the current progress
    * @param string for the command
    * @return 
    */
    public void save(String elementTosave) {
        try (FileWriter writer = new FileWriter("savedGames/actualGame.txt", true);
                BufferedWriter bw = new BufferedWriter(writer)) {

            bw.write(elementTosave + "\n");

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
    
    /**
    * Rename a file
    * @param string for the file name
    * @return 
    */
    public void rename(String fileName) {
        File f1 = new File("savedGames/actualGame.txt");
        File f2 = new File("savedGames/"+fileName);
        boolean b = f1.renameTo(f2);
        if (b) {
            System.out.println("Saved");
        } else {
            System.out.println("Error");
        }
    }
    
    /**
    * Clear the save
    * @param
    * @return 
    */
    public void clearFile(){
        PrintWriter writer=null;
        try {
            writer = new PrintWriter("savedGames/actualGame.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }

}
