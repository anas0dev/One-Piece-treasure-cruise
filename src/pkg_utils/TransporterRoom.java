/**
* This class contains characters in the game which allow the player to talk 
* with characters. In case the player give an item to a characters if it's 
* the correct the characters give help to player
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019)
*/

package src.pkg_utils;

public class TransporterRoom extends Room{
	
	
       /**
	* @param description String description of this room.
	* @param scenario The Scenario that's used in the Game class.
	**/
	public TransporterRoom(String name,String description,String image){
		super(name,description,image);
		
	}
	
       /**
	* @return a random room using the findRandomRoom() method.
	**/
	@Override
	public Room getExit(String direction){
		return findRandomRoom();
	}
	
       /**
	* @return a random room using the Scenario given in this class's constructor
	**/
	public Room findRandomRoom(){
		Scenario a=new Scenario();
		return a.getRandomRoom();
	}
	
}
