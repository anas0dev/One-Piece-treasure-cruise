/**
* This class contains player in the game the player have a crew to help him to find key and
* affront enemies the player have a boat to carry stuff found in the area the purpose of the player 
* is to find one piece legend that's allows him to win the game he can also buy thing
* @author  Université Paris8 Groupe5
* @version 3.0 (May 2019) 
*/

package src.pkg_characters;
import src.pkg_items.*;
import src.pkg_utils.*;

public class Player {
	
	private String 						name;
	private int 						bagWeight;
	private Room   						location;
	private ItemList					bag;
	private int 						solde;
	private int 						crew;
	private int 						magicKeys;
	private int 						strength;
	private int 						life;
	
	/** 
	* Default constructeur for the player
	* @name the of the player
	* @weight the weight of bag
	* @actualRoom the location of the player
	* @solde the money that the player has
	* @magicKeys the number of key owned by the player
	* @strength the strength of the player
	* @life the amount of life for the player
	**/
	public Player(String name,int weight,Room actualRoom,int solde,int crew,int magicKeys,int strength,int life){
		this.name=name;
		this.solde=solde;
		this.bagWeight=weight;
		this.location=actualRoom;
		this.crew=crew;
		this.magicKeys=magicKeys;
		this.strength=strength;
		this.life=life;
		bag=new ItemList();
	}
	/**
	 * This method set the name of the player
	 * @name name of the player 
	 **/
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * This method set the weight of the player
	 * @weight new bag weight
	 **/
	public void setWeight(int weight) {
		this.bagWeight=weight;
	}
	/**
	 * This method set the new location of the player
	 * @actualRoom new location
	 **/
	public void setLocation(Room actualRoom) {
		this.location=actualRoom;
	}
	/**
	 * This method set the new solde of the player
	 * @solde new solde update
	 **/
	public void setSolde(int solde) {
		this.solde=solde;
	}
	/**
	 * This method get the solde of the player
	 * @return solde of player 
	 **/
	public int getSolde() {
		return this.solde;
	}
	/**
	 * This method get the name of the player
	 * @return the name of the player
	 * */
	public String getName() {
		return this.name;
	}
	/**
	 * This method get the weight of the bag
	 * @return the bag weight
	 **/
	public int getWeight() {
		return this.bagWeight;
	}
	
	/**
	 * This method get the location of the player
	 * @return the location of the player
	 **/
	public Room getLocation() {
		return this.location;
	}
	/**
	 * This method get the total weight of bag carry by the player
	 * @return the bag weight
	 **/
	public int getTotalWeight(){
		return bag.getTotalWeight();
	}
	/**
	 * This method get the strength of the player
	 * @return strength of the player
	 **/
	public int getStrength(){
		return this.strength;
	}
	/**
	 * This method set the strength of the player
	 * @strength the new strength
	 **/
	public void setStrength(int strength){
		this.strength=strength;
	}
	/**
	 * This method get the life of the player
	 * @return life of the player
	 **/
	public int getLife(){
		return this.life;
	}
	/**
	 * This method set the life of the player
	 * @life the new life
	 **/
	public void setLife(int life){
		this.life=life;
	}
	/**
	 * This method get the number of number of the crew
	 * @return number of the crew
	 **/
	public int getCrewNumber(){
		return this.crew;
	}
	/**
	 * This method set the crew number of the player
	 * @number the number of crew 
	 **/
	public void setCrewNumber(int number){
		this.crew=number;
	}
	/**
	 * This method get the number of magical keys
	 * @return magical key number
	 **/
	public int getMagicKeys(){
		return this.magicKeys;
	}
	/**
	 * This method set the number of magical keys
	 * @number magical key number
	 **/
	public void setMagicKeys(int number){
		this.magicKeys=number;
	}
	/**
	 * This allow to add item to the bag 
	 * @name the name of the player
	 * @item the item to set
	 **/
	public void addItemToBag(Player name,Item item){
		if(checkWeight(name,item)){
			name.setWeight(name.getWeight()-item.getWeight());
			bag.addItem(item.getName(),item);
		}
	}
	/**
	 * This allow to check the bag weight 
	 * @name the name of the player
	 * @item the item to set
	 **/
	public boolean checkWeight(Player name,Item item) {
		if(name.getWeight()-item.getWeight()>=0) {
			return true;
		}
		return false;
	}
	/**
	 * This method remove item from the bag 
	 * @name the name of the item to remove
	 **/
	public void removeItemFromBag(String name){
		setWeight(getWeight()+bag.getItemWeight(name));
		bag.removeItem(name);
	}
	/**
	 * This method check item presens in the bag 
	 * @name the name of the item 
	 **/
	public Item checkItemInTheBag(String name) {
    	return bag.checkItemInList(name);
  	}
	
	/**
	 * This method return the bag weight of the player with Description
	 * @return a String 
	 **/
	public String showMyBag() {
		return "Your bag contain :" +bag.getItemsDescription()+" Totalise "+ bag.getTotalWeight()+"/"+getWeight()+" Kg";
	}
	
}