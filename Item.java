
public class Item {
	//private String name;
	private String description;
	private int valeur;
	
	public Item(/*String name,*/ String description, int valeur) {
		//this.setName(name);
		this.setDescription(description);
		this.setValeur(valeur);
	}




	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}




	public int getValeur() {
		return valeur;
	}




	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
