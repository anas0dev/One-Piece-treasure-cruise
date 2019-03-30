package src;

import java.util.HashMap;

public class ItemList {
	
	private HashMap<String,Item> items;
	
	public ItemList() {
		this.items=new HashMap<String,Item>();
	}
	
	public void addItem(String roomName,Item item) {
		items.put(roomName,item);
	}

	public void removeItem(String itemName){
		items.remove(itemName);
	}

	public Item checkItemInList(String name){
		if(items.get(name)==null) {
    		return null;
    	}
    	return items.get(name);
	}

	public int getItemWeight(String name){
		if(items.get(name)!= null){
			return (items.get(name)).getWeight();
		}
		return 0;
	}
	
	public int getTotalWeight(){
		int total=0;
		for(String x : items.keySet()){
			total+=(items.get(x)).getWeight();
		}
		return total;
	}
	public StringBuilder getItemsDescription(){
		StringBuilder returnString=new StringBuilder();
		if(items.isEmpty()) 
			return returnString.append(" No items left");
		
		for(Item x : items.values()) 
			returnString.append(" "+x.getName());
		
		return returnString;
	}
	
	
}
