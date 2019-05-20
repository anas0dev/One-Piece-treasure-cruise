/**
* This class contains Enemies in the game which try to kill the player  
* The player must be stronger to kill them in the final room he have to kill 
* the enemy to pick up the coin named "One Piece"
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/

package src.pkg_characters;
import src.pkg_items.*;

public class Enemy extends Characters{
	
	private int     strength;
	/**
	 * Default constructor enemy
	 * @name the name of the enemy
	 * @printHi the String to say hi of the enemy
	 * @printHelp the String help of the enemy
	 * @item The item carry by the enemy
	 * @strength the strength of the enemy
	 **/
	public Enemy(String name,String printHi,String printHelp,Item item,int strength){
        super(name, printHi, printHelp, item);
        this.strength=strength;
    }
    /**
     * This method return the strength of the enemy
     * @return the strength of the enemy
     **/
    public int getStrength(){
        return this.strength;
    }
    /**
     * This method set the new strength of the enemy
     * @strength the new strength
     **/
    public void setStrength(int strength){
        this.strength=strength;
    }

}