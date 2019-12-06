package starWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Point;
import java.util.Random;
/**
 * the character that the player will control throughout the game
 * @author Roman
 *
 */
public class Hero extends Entity {
	/**
	 * a list of items that the hero currently has
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * the map that the player is currently on
	 */
	private Map map;
	/**
	 * the current location of the player
	 */
	private Point location;
	/**
	 * constructor for the hero
	 * @param n the hero's name
	 * @param m the hero's current map
	 */
	public Hero(String n, Map m) {
		super ( n, 1, 15);
		map = m;
		location = map.findStart();
	}
	/**
	 * the process of the hero attacking an enemy for a random amount of damage
	 * @param e the enemy the hero is attacking
	 */
	public void attack(Character e) {
		Random randDmg = new Random();
		int dmg = randDmg.nextInt(( 5 - 1 ) + 1 );
		e.takeDamgage(dmg);	
	}
	/**
	 * displays the hero's current map and options
	 */
	public void display() {
		super.display();
		System.out.println("Inventory:");
		if (items != null)
		{
			for ( int i = 0; i < items.size(); i++ ) {
				System.out.print((i + 1) + ": ");
				System.out.print(items.get(i).getName());
			}
		}
		
		map.displayMap(location);
		System.out.println("1. Go North");
		System.out.println("2. Go South");
		System.out.println("3. Go East");
		System.out.println("4. Go West");
		System.out.println("5. Quit");
	}
	
	public char charAtLoc() {
		return map.getCharAtLoc(location);
	}
	/**
	 * displays the current items in the hero's inventory
	 */
	public void displayItems() {
		if (items != null){
			for( int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i));
			}
		}
	}
	/**
	 * finds the number of items in the hero's inventory
	 * @return the number of items
	 */
	public int getNumItems() {
		return items.size();
	}
	
	public Map getMap() {
		return map;
	}
	
	public Item getItem() {
		return new Item();
	}
	/**
	 * adds an item to the hero's inventory
	 * @param i the item that will be added
	 * @return checks to make sure the hero's inventory is not full
	 */
	public boolean pickUpItem(Item i) {
		if ( items.size() < 5 ) {
			items.add(i);
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * removes an item from the hero's inventory after it has been used
	 * @param n the name of the item that will be removed
	 */
	public void removeItem(String n) {
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get(i).getName() == n ) {
				items.remove(i);
				break;
			}
		}
	}
	/**
	 * removes the last item in the hero's inventory
	 * @param index the index where the item is stored
	 */
	public void removeItem(int index) {
		items.remove(index - 1);
	}
	/**
	 * finds the first item that is an armor item and removes it from
	 * the hero's inventory
	 * @return the name of the item that was removed
	 */
	public String removeFirstArmorItem() {
		for ( int i = 0; i < items.size(); i++) {
			if ( items.get(i).getName() == "Helmet" || 
					items.get(i).getName() == "Shield" ||
					items.get(i).getName() == "Chestplate" ) {
				String itemName = items.get(i).getName();
				items.remove(i);
				return itemName;
			}
			
		}
		return null;
		
	}
	/**
	 * checks if there is a med kit in the hero's inventory
	 * @return true if there is a med kit in the hero's inventory and
	 * false if not
	 */
	public boolean hasMedKit() {
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get(i).getName() == "Med Kit" ) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * checks if there is a holocron in the hero's inventory
	 * @return true if there is a holocron in the hero's inventory and
	 * false if not
	 */
	public boolean hasHolocron() {
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get(i).getName() == "Holocron" ) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * checks if there is a key in the hero's inventory
	 * @return true if there is a key in the hero's inventory and
	 * false if not
	 */
	public boolean hasKey() {
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get(i).getName() == "Key" ) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * checks if there is a armor in the hero's inventory
	 * @return true if there is a armor in the hero's inventory and
	 * false if not
	 */
	public boolean hasArmor() {
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get(i).getName() == "Helmet" || 
					items.get(i).getName() == "Shield" || 
					items.get(i).getName() == "ChestPlate" ) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * finds the current location of the hero
	 * @return the current location of the hero
	 */
	public Point getLocation() {
		return this.location;
	}
	/**
	 * moves the hero one space north on the map
	 * @return a character to identify that the hero moved north
	 */
	public char goNorth() {
		if ( this.location.y > 0 )
		{
			this.location.y--;
			return 'n';
		}
		else {
			return 'n';
		}

	}
	/**
	 * moves the hero one space south on the map
	 * @return a character to identify that the hero moved south
	 */
	public char goSouth() {
		if ( this.location.y < 5 ) {
			this.location.y++;
			return 's';
		}
		else {
			return 's';
		}

	}
	/**
	 * moves the hero one space east on the map
	 * @return a character to identify that the hero moved east
	 */
	public char goEast() {
		if ( this.location.x < 5 ) {
			this.location.x++;
			return 'e';
		}
		else {
			return 'e';
		}

	}
	/**
	 * moves the hero one space west on the map
	 * @return a character to identify that the hero moved west
	 */
	public char goWest() {
		if ( this.location.x > 0 ) {
			this.location.x--;
			return 'w';
		}
		else {
			return 'w';
		}

	}
	
}
