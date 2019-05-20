/**
* Class Room - a room in an adventure game.
*
* This class is part of the "World of Zuul" application. 
* "World of Zuul" is a very simple, text based adventure game.  
*
* A "Room" represents one location in the scenery of the game.  It is 
* connected to other rooms via exits.  The exits are labelled north, 
* east, south, west.  For each direction, the room stores a reference
* to the neighboring room, or null if there is no exit in that direction.
* 
* @author  Groupe 5 Université Paris 8
* @version 3.0 (May 2019)
*/

package src.pkg_utils;


import src.pkg_characters.*;
import src.pkg_items.*;

import java.util.HashMap;
import java.util.ArrayList; // import the ArrayList class



public class Room {

    private String name;
    private String description;
    private HashMap<String, Room> exits;
    private String imageName;
    private ItemList items;
    
    /**
    * Create a room described "description". Initially, it has
    * no exits. "description" is something like "a kitchen" or
    * "an open court yard".
    * @param description The room's description.
    */
    public Room(String name,String description,String image){
        this.name=name;
        this.description = description;
        exits = new HashMap<String,Room>();
        imageName=image;
        items = new ItemList();
    }

    public String getName(){
        return this.name;
    }

    /**
    * Define the exits of this room.  Every direction either leads
    * to another room or is null (no exit there).
    * @param String direction.
    * @param Room   neighbor.
    */
    public void setExits(String direction,Room neighbor){
        exits.put(direction, neighbor);
    }
    
    /**
    * Add  items to this room.
    * @param roomName room Name
    * @param Item item.
    */
    public void addItems(String roomName,Item item){
        items.addItem(roomName,item);
    }
    
    public void addCharacters(String roomName,Characters character){
        items.addCharacters(roomName,character);
    }

    public void addEnemies(String roomName,Enemy enemy){
        items.addEnemies(roomName,enemy);
    }
    /**
    * remove items from this room.
    * @param itemName item Name
    */
    public void removeItems(String itemName){
        items.removeItem(itemName);
    }
    
    public void removeEnemy(String name){
        items.removeEnemy(name);
    }
    /**
    * Return a description of the room's exits,
    * for example "Exits: north west".
    * @return A description of the available exits.
    */
    public StringBuilder getExitString(){
        StringBuilder returnString = new StringBuilder("Exits:");
        for(String exit : exits.keySet())
            returnString.append(" "+ exit);
        return returnString;
    }

    public ArrayList<String> getExitButton(){
        ArrayList<String> exiting = new ArrayList<String>(); // Create an ArrayList object
        for(String exit:exits.keySet()){
            exiting.add(exit);
        }
        return exiting;
    }
    /**
    * Return the room that is reached if we go from this
    * room in direction "direction". If there is no room in
    * that direction, return null.
    */
    public Room getExit(String direction){
        return exits.get(direction);
    }
    
    /**
    * Return a long description of this room, of the form:
    * You are in the kitchen.
    * Exits: north west
    * @return A description of the room, including exits.
    */
    public String getLongDescription(){
         return "You are in " + description + ".\n->" + getExitString() + "\n->"+getItemsDescription() +"\n->" + getCharactersDescription()+"\n->"+getEnemiesDescription() +"\n------------------------------------------------------------------------------------------------------\n";
    }
    
    /**
    * Return a few description of this room, of the form:
    * You are in the boat.
    * @return A description of the room
    */
    public String getDescription()
    {
        return description;
    }
    /**
    * This method return Item object if it's present in the room 
    */
    public Item checkItemInTheRoom(String name) {
    	return items.checkItemInList(name);
    }
    /**
     * This method return Enemy object if it's present in the room 
     */
    public Enemy checkEnemiesInTheRoom(String name){
        return items.checkEnemiesInTheRoom(name);
    }
    /**
     * This method return Characters object if it's present in the room 
     */
    public Characters checkCharatersInTheRoom(String nameRoom){
        return items.checkCharatersInTheRoom(nameRoom);
    }
    /**
    * This method allows to get all items description from ItemList 
    */
    public String getItemsDescription() {
		return "Items :"+items.getItemsDescription();
    }
    /**
     * This method allows to get all Characters description from ItemList 
     */
    public String getCharactersDescription() {
		return "Characters :"+items.getCharactersDescription();
    }
    /**
     * This method allows to get all Enemies description from ItemList 
     */
    public String getEnemiesDescription(){
        return "Enemies :"+items.getEnemiesDescription();
    }
    /**
     * This method get The Hi string of  characters
     **/
    public String getCharactersHi(){
        return items.getHi()+"\n";
    }
    /**
     * This method return the item of character
     **/
    public String giveCharactersItem(Item item){
        if(items.giveCharactersItem(item)!="false"){
            return items.giveCharactersItem(item);
        }
        else{
            return "This is not the item that i search but i'll keep it\n";
        }
    }
    /**
     * This method set the exits of the room
     **/
    public void setExitByDescription(String direction,String Description){
        exits.put(direction, exits.get(Description));
    }
    /**
     * set image name
     */
    public void setImageName(String imageName){
        this.imageName=imageName;
    }
    /**
    * get image name
    */
	public String getImageName() {
		return imageName;
	}
}
