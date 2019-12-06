package starWars;

import java.util.Random;
/**
 * functionality for an enemy that has the ability
 * to attack with force
 * @author Roman
 *
 */
public class ForceEnemy extends Enemy{
	/**
	 * constructor for a force enemy
	 * @param n the name of the force enemy
	 * @param l the level of the force enemy
	 * @param m the max hit points that the force enemy is on
	 * @param i the item that the force enemy will drop
 	 */
	public ForceEnemy(String n, int l, int m, Item i) {
		super( n, l, m, i);
	}
	/**
	 * the force enemy using the force to attack
	 */
	public void attack(Entity e) {
		Force enemyAttack = new Force();
		Random randAttack = new Random();
		int attackChoice = randAttack.nextInt(( 3 - 1 ) + 1 );
		if ( attackChoice == 1 ) {
			int dmg = enemyAttack.forceChoke();
			e.takeDamgage(dmg);
			
		}
		else if ( attackChoice == 2 ) {
			int dmg = enemyAttack.forcePush();
			e.takeDamgage(dmg);
			
		}
		else {
			int dmg = enemyAttack.forceSlam();
			e.takeDamgage(dmg);
			
		}
		
		
	}
	

	
}
