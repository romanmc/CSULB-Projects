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
	/*	try { 
			File enemyFile = new File("/Users/Roman/CSULB-Projects/Star Wars/src/starWars/EnemyList.txt");
			Scanner enemySC = new Scanner(enemyFile);
			ig = ItemGenerator.getInstance();
			
			Map m1 = Map.getInstance();
			Hero newHero = new Hero("Hero", m1);
			
			while ( enemySC.hasNextLine() ) {
				String[] enemyTextList = enemySC.nextLine().split(",");
				
				if ( enemyTextList[2] == "n" ) {
					Enemy newEnemy = new Enemy ( enemyTextList[0], newHero.getLevel(),
							(Integer.parseInt(enemyTextList[1])*newHero.getLevel()), ig.generateItem());
					enemyList.add(newEnemy);
				}
				else {
					ForceEnemy newFEnemy = new ForceEnemy( enemyTextList[0], newHero.getLevel(),
							(Integer.parseInt(enemyTextList[1])*newHero.getLevel()), ig.generateItem());
					enemyList.add(newFEnemy);
				}
			}
			enemySC.close();
		} catch ( FileNotFoundException e ) {
			System.out.println("file not found");
		}*/
		
		Map m1 = Map.getInstance();
		int l = h.getLevel();
		
		String[] names = new String[4];
		names[0] = "Rodian";
		names[1] = "Dathomiri";
		names[2] = "Twi'lek";
		names[3] = "Geonosian";
		
		for ( int n = 0; n < 4; n++ ) {
			Character newChar = new Enemy("", 1, 1, ig.generateItem());
			Enemy newEnemy = new Enemy(names[n], l, 1, ig.generateItem());
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
						newChar = new ForceUser(newEnemy);
					}
					else {
						newChar = new ForceUser(newChar);
					}
				}
				
			}
			enemyList.add(newChar);
			System.out.println(newChar.toStringz());
		}

		/*Character RodianF = new Fighter(new Enemy("Rodian Fighter", newHero.getLevel(), 1, ig.generateItem()));
		enemyList.add(RodianF);
		Character RodianU = new ForceUser(new Enemy("Rodian Force User", newHero.getLevel(), 1, ig.generateItem()));
		enemyList.add(RodianU);
		Character DathomiriF = new Fighter(new Enemy("Dathomiri Fighter", newHero.getLevel(), 2, ig.generateItem()));
		enemyList.add(DathomiriF);
		Character DathomiriU = new ForceUser(new Enemy("Dahtomiri Force User", newHero.getLevel(), 2, ig.generateItem()));
		enemyList.add(DathomiriU);
		Character TwiLekF = new Fighter(new Enemy("Twi'lek Fighter", newHero.getLevel(), 3, ig.generateItem()));
		enemyList.add(TwiLekF);
		Character TwiLekU = new ForceUser(new Enemy("Twi'lek Force User", newHero.getLevel(), 3, ig.generateItem()));
		enemyList.add(TwiLekU);
		Character GeonosianF = new Fighter(new Enemy("Geonosian Fighter", newHero.getLevel(), 4, ig.generateItem()));
		enemyList.add(GeonosianF);
		Character GeonosianU = new ForceUser(new Enemy("Geonosian Force User", newHero.getLevel(), 4, ig.generateItem()));
		enemyList.add(GeonosianU);*/
		

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
		// change to current level of hero
		
		Random rand = new Random();
		Character randEnemy = enemyList.get( rand.nextInt( enemyList.size() ) );
		
		return randEnemy;
	}
	
}
