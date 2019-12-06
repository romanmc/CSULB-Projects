package starWars;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
/**
 * generates a random enemy from a file of predetermined enemies
 * @author Roman
 *
 */
public class EnemyGenerator {
	/**
	 * the list of predetermined enemies that could be generated
	 */
	private ArrayList<Character> enemyList = new ArrayList<Character>();
	/**
	 * the item generator that will generate a random item for the
	 * enemy to drop when it is defeated
	 */
	private ItemGenerator ig;
	/**
	 * makes map a singleton where the instance is null by default
	 */
	private static EnemyGenerator instance = null;
	/**
	 * constructor for enemy generator
	 * @param ig the item generator that will generate a random item for the
	 * enemy to drop when it is defeated
	 */	
	private EnemyGenerator(ItemGenerator ig, Hero h) {

		int l = h.getLevel();
		
		String[] names = new String[4];
		names[0] = "Rodian";
		names[1] = "Dathomiri";
		names[2] = "Twi'lek";
		names[3] = "Geonosian";
		
		for ( int n = 0; n < 4; n++ ) {
			Character newChar = new Enemy("", 1, n+1, ig.generateItem());
			Enemy newEnemy = new Enemy(names[n], l, n+1, ig.generateItem());
			Character newFChar = new ForceEnemy("", 1, n+1, ig.generateItem());
			ForceEnemy newFEnemy = new ForceEnemy(names[n], l, n+1, ig.generateItem());
			for ( int i = 0; i < l; i++ ) {
				Random rand = new Random();
				int random = rand.nextInt(2);
				if ( random == 1 ) {
					if ( i == 0 ) {
						newChar = new Fighter(newEnemy);
					}
					else {
						newChar = new Fighter(newChar);
					}
				}
				else {
					if ( i == 0 ) {
						newChar = new ForceUser(newFEnemy);
					}
					else {
						newChar = new ForceUser(newFChar);
					}
				}
				
			}
			enemyList.add(newChar);
		}
		
	}
	/**
	 * lets the program get a single instance of an item generator
	 * @return the instance
	 */
	public static EnemyGenerator getInstance(ItemGenerator ig, Hero h) {
		if ( instance == null ) {
			instance = new EnemyGenerator(ig, h);
		}
		return instance;
	}
	/**
	 * actually generating a random enemy
	 * @param level the current level of the hero
	 * @return the enemy that was generated
	 */
	public Character generateEnemy( int level ) {
		
		Random rand = new Random();
		Character randEnemy = enemyList.get( rand.nextInt( enemyList.size() ) );
		randEnemy.resetHealth();
		randEnemy.setLevel(level);
		return randEnemy;
	}
	
}
