package starWars;
/**
 * an object that is of some use to the hero
 * @author Roman
 *
 */
public class Item {
	/**
	 * name of item
	 */
	private String name;
	/**
	 * constructor for item
	 */
	public Item(Item i) {
		name = i.getName();
	}
	/**
	 * constructor for item with name
	 * @param n name of item
	 */
	public Item(String n) {
		name = n;
	}
	/**
	 * finds the name of the item
	 * @return name of item
	 */
	public String getName() {
		return name;
	}

	public Item clone() {		
		return new Item(this);
	}
	
}
