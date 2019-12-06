package starWars;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
/**
 * generates a random item from the list of items in the ItemList.txt file
 * @author Roman
 *
 */
public class ItemGenerator extends Item{
	/**
	 * list of items that could possibly be generated
	 */
	private ArrayList<Item> itemList = new ArrayList<Item>();
	/**
	 * makes map a singleton where the instance is null by default
	 */
	private static ItemGenerator instance = null;
	/**
	 * constructor for the item generator -- finds the file that has the
	 * predetermined list of items
	 */
	private ItemGenerator() {
		
		super();
		try {
			File itemFile = new File("/Users/Roman/CSULB-Projects/Star Wars/src/starWars/ItemList.txt");
			
			Scanner itemSC = new Scanner(itemFile);
			
			while (itemSC.hasNextLine()) {
				Item newItem = new Item(itemSC.nextLine());

				itemList.add(newItem);
			
			}
			
			itemSC.close();
		} catch ( FileNotFoundException e ) {
			System.out.println("File not found");
		}

		
	}
	/**
	 * lets the program get a single instance of an item generator
	 * @return the instance
	 */
	public static ItemGenerator getInstance() {
		if ( instance == null ) {
			instance = new ItemGenerator();
		}
		return instance;
	}
	/**
	 * picks a random item from the file
	 * @return the random item
	 */
	public Item generateItem() {
		
		Random rand = new Random();
		Item randItem = itemList.get(rand.nextInt(itemList.size())).clone();
		
		return randItem;
	}
	
}
