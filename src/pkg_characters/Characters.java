/**
* This class contains characters in the game which allow the player to talk 
* with characters. In case the player give an item to a characters if it's 
* the correct the characters give help to player
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/

package src.pkg_characters;
import src.pkg_items.*;

public class Characters{
	
	private String 	name;
	private String  printHi;
	private Item    item;
	private String  printHelp;
	
	/**
	 * Default constructor for characters who are helpful for the player
	 * @name the name of the characters
	 * @printHi the salutation of the characters
	 * @printHelp the help given to the player
	 * @item the item must have to get the help of the characters
	 * */
	public Characters(String name,String printHi,String printHelp,Item item){
		this.name      =name;
		this.printHi   =printHi;
		this.printHelp =printHelp;
		this.item      =item;
	}
	/**
	 * This method set the name of the characters
	 * @name the new name to be replaced
	 * */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * This method get the name of the characters
	 * @return the name of the characters
	 * */
	public String getName() {
		return this.name;
	}
	/**
	 * This method set the string to print when the player talk to the charcaters
	 * @printHi the new String hello
	 * */
	public void setHello(String printHi){
		this.printHi=printHi;
	}
	/**
	 * This method get the string to print when the player talk to the charcaters
	 * @return the String Hi
	 * */
	 public String getHello(){
		return this.printHi;
	}
	 /**
	 * This method set the string to help when the player give the right item to the charcaters
	 * @printHelp the String to help
	 * */
	 public void setHelp(String printHelp){
		this.printHelp=printHelp;
	}
	 /**
	 * This method get the string to help when the player give the right item to the charcaters
	 * @return the String to help
	 * */
	 public String getHelp(){
		return this.printHelp;
	}
	 /**
	 * This method set the item must be given by the player
	 * @item the item 
	 * */
	 public void setItem(Item item){
		this.item=item;
	}
	 /**
	 * This method get the item must be given by the player
	 * @return the item 
	 * */
	 public Item getItem() {
		return this.item;
	}

}