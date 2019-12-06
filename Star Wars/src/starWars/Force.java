package starWars;

import java.util.Random;
/**
 * how a hero or enemy will use a force attack
 * @author Roman
 *
 */
public class Force {
	/**
	 * the different options for a force attack
	 */
	private static final String FORCE_MENU = 
			"1. Force Push\n2. Force Choke\n3. Force Slam";
	/**
	 * randomizes the damage for a force push attack
	 * @return the number that the damage will do
	 */
	public int forcePush() {
		Random randDmg = new Random();
		int dmg = randDmg.nextInt(( 7 - 5 ) + 1 );
		return dmg;
	}
	/**
	 * randomizes the damage for a force choke attack
	 * @return the number that the damage will do
	 */
	public int forceChoke() {
		Random randDmg = new Random();
		int dmg = randDmg.nextInt(( 10 - 1 ) + 1 );
		return dmg;
	}
	/**
	 * randomizes the damage for a force slam attack
	 * @return the number that the damage will do
	 */
	public int forceSlam() {
		Random randDmg = new Random();
		int dmg = randDmg.nextInt(( 8 - 4 ) + 1 );
		return dmg;
	}
	
}
