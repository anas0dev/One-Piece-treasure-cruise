/**
* This class is part of "World of Zuul". "World of Zuul" is a simple, 
* adventure game.
* This ItemList class hold Item in a HashMap and it's used by both Player and Room
* To take and drop Thing during the game
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/
package src.pkg_items;

import src.pkg_characters.*;
import java.util.HashMap;

public class ItemList {
	
	private HashMap<String,Item> items;
	private HashMap<String,Characters> characters;
	private HashMap<String,Enemy> enemies;
	/**
	* Default Constructor
	*/
	public ItemList() {
		this.items=new HashMap<String,Item>();
		this.characters=new HashMap<String,Characters>();
		this.enemies=new HashMap<String,Enemy>();
	}
	
	/**
	* Add a new character
	* @param string for the character name
	* @param Character for the new character
	* return 
	*/
	public void addCharacters(String charactersName,Characters character){
		characters.put(charactersName,character);
	}
	
	/**
	* Remove a character
	* @param string for the character name
	* return 
	*/
	public void removeCharacters(String characterName){
		characters.remove(characterName);
	}
	
	/**
	* Add an new enemy
	* @param string for the enemy name
	* @param Enemy for the new enemy
	* return 
	*/
	public void addEnemies(String enemiesName,Enemy enemy){
		enemies.put(enemiesName,enemy);
	}
	
	/**
	* Remove an enemy
	* @param string for the character name
	* @param Character for the new character
	* return 
	*/
	public void removeEnemy(String enemiesName){
		enemies.remove(enemiesName);
	}

	/**
	* This function add Items to The room
	* @param roomName the room name
	* @param item	the object item
	*/
	public void addItem(String roomName,Item item) {	
		items.put(roomName,item);
	}
	/**
	* This function allows to remove items by tagName (itemName)
	* @param itemName name of item
	*/
	public void removeItem(String itemName){
		items.remove(itemName);
	}

	/**
	* This function check if the item is present in the HashMap 
	* @param name name of item
	* @return the object Item
	*/
	public Item checkItemInList(String name){

    	return items.get(name);
	}
	
	/**
	* Checks for the presence of an enemy
	* @param string for the enemy name
	* @return string
	*/
	public Enemy checkEnemiesInTheRoom(String name){
		return enemies.get(name);
	}
	
	/**
	* Checks for the presence of a character
	* @param string for the character name
	* @return string
	*/
	public Characters checkCharatersInTheRoom(String name){
		return characters.get(name);
	}
	/**
	* This function get the item weight
	* @return number 
	*/
	public int getItemWeight(String name){
		if(items.get(name)!= null){
			return (items.get(name)).getWeight();
		}
		return 0;
	}
	/**
	* This function calculate the total of item 
	* @return the total
	*/
	public int getTotalWeight(){
		int total=0;
		for(String x : items.keySet()){
			total+=(items.get(x)).getWeight();
		}
		return total;
	}
	/**
	*  This function return the description of all the items
	* @return all items
	*/
	public StringBuilder getItemsDescription(){
		StringBuilder returnString=new StringBuilder();
		if(items.isEmpty()) 
			return returnString.append(" No items left");
		
		for(Item x : items.values()) 
			returnString.append(" "+x.getName());
		
		return returnString;
	}
	
	/**
	* Get character description
	* @return string
	*/
	public StringBuilder getCharactersDescription(){
		StringBuilder returnString=new StringBuilder();
		if(characters.isEmpty()) 
			return returnString.append("No characters here");
		
		for(Characters x : characters.values()) 
			returnString.append(" "+x.getName());
		
		return returnString;
	}
	
	/**
	* Get character description
	* @return string
	*/
	public StringBuilder getEnemiesDescription(){
		StringBuilder returnString=new StringBuilder();
		if(enemies.isEmpty()) 
			return returnString.append("No Enemies here");
		for(Enemy x : enemies.values()) {
			returnString.append(" "+x.getName());
		}
		return returnString;
	}
	
	/**
	* Get greeting description
	* @return string
	*/
	public StringBuilder getHi(){
		StringBuilder returnString=new StringBuilder();
		if(characters.isEmpty()) 
			return returnString.append("No characters here");
		for(Characters x : characters.values()) 
			returnString.append(x.getName()+":"+x.getHello());
		return returnString;
	}
	
	/**
	* Give item to character
	* @param item
	* @return string
	*/
	public String giveCharactersItem(Item item){

		for(Characters x : characters.values()){
			if((x.getItem()).getName()==item.getName()){
				return x.getHelp();
			}
		}
		return "false";
	}
	
	/**
	* Get help description
	* @param item
	* @return string
	*/
	public StringBuilder getHelp(Item item){
		StringBuilder returnString=new StringBuilder();
		if(characters.isEmpty()) 
			return returnString.append("No characters here");
		for(Characters x : characters.values()) 
			returnString.append("=>"+x.getHelp());

		return returnString;
	}

	
}
