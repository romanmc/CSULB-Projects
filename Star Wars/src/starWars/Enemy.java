package starWars;

import java.util.Random;
/**
 * the enemies that will fight the hero
 * @author Roman
 *
 */
public class Enemy extends Entity{
	/**
	 * the item that the enemy will drop when it is
	 * defeated
	 */
	private Item item;
	/**
	 * constructor of enemy
	 * @param n name of the enemy
	 * @param l level of the enemy
	 * @param m max hit points of the enemy
	 * @param i item that the enemy will drop
	 */
	public Enemy(String n, int l, int m, Item i) {
		super( n, l, m );
		item = i;
	}
	/**
	 * the attack that the enemy will perform on the hero
	 * @param e the character that the enemy will be attacking
	 */
	public void attack(Character e) {
		Random randDmg = new Random();
		int dmg = randDmg.nextInt(( 5 - 1 ) + 1 ) + this.getAddDmg();
		e.takeDamgage(dmg);
	}
	/**
	 * gets the item that the enemy will drop
	 * @return the item that the enemy will drop
	 */
	public Item getItem() {
		return item;
	}
	
	public String toStringz() {
		String entity = super.toStringz() + "Item: " + item;
		return entity;
	}
}
