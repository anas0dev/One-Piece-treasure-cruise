/**
* This class is part of "One Piece treasure cruise" is a simple, 
* adventure game.
* This Item take a description,weight and a price which can help
* you during the game
* @author  Universit� Paris8 Groupe5
* @version 3.0 (May 2019)
*/

package src.pkg_items;


public class Item {
	
	private String name;
	private String description;
	private int weight;
	private int price;
	
	/**
	 * Default constructor
	 * @name of item
	 * @description of the item
	 * @weight the weight of the item
	 * @price the price of the item
	 **/
	public Item(String name,String description, int weight,int price) {
		this.name=name;
		this.description=description;
		this.weight=weight;
		this.price=price;
	}

	/**
	 * Set the name of the item
	 * @name new name
	 **/
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * Set the weight of the item
	 * @weight new weight
	 **/
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * Set the description of the item
	 * @description new description
	 **/
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Set the price of the item
	 * @price new price
	 **/
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * Get the name of the item 
	 * @return name
	 * */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the description of the item 
	 * @return description
	 * */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Get the price of the item 
	 * @return price
	 * */
	public int getPrice() {
		return this.price;
	}
	
	
	/**
	 * Get the weight of the item 
	 * @return weight
	 * */
	public int getWeight() {
		return this.weight;
	}
}
