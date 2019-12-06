package starWars;
/**
 * the basic unit of any character in the game
 * @author Roman
 *
 */
public abstract class Entity implements Character{
	/**
	 * the name of the character
	 */
	private String name;
	/**
	 * the level of the character
	 */
	private int level;
	/**
	 * the max Hit Points of the character
	 */
	private int maxHp;
	/**
	 * the current Hit Points of the character
	 */
	private int hp;
	/**
	 * the constructor of entity
	 * @param n name of the entity
	 * @param l level of the entity
	 * @param m max hit points of the entity
	 */
	public Entity(String n, int l, int m) {
		name = n;
		level = l;
		maxHp = m;
		hp = maxHp;
	}
	/**
	 * all entities will need to be able to attack
	 * @param e which entity will be attacking
	 */
	public abstract void attack(Character e);
	/**
	 * finds the name of the entity
	 * @return the name of the entity
	 */
	public String getName() {
		return name;
	}
	/**
	 * finds the level of the entity
	 * @return the level of the entity
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * finds the current hit points of the entity
	 * @return the current hit points of the entity
	 */
	public int getHP() {
		return hp;
	}
	/**
	 * finds the max hit points of the entity
	 * @return the max hit points of the entity
	 */
	public int getMaxHP() {
		return maxHp;
	}
	/**
	 * increases the current level of the entity by 1
	 */
	public void increaseLevel() {
		level += 1;
	}
	/**
	 * finds additional damage for decorators
	 * @return additional damage
	 */
	public int getAddDmg() {
		return 0;
	}
	/**
	 * increases the current hit points some amount with a maximum
	 * of raising current hit points to max hit points of that 
	 * entity
	 * @param h the amount of hit points that are being added to the
	 * current hit points
	 */
	public void heal(int h) {		
		if (hp <= (maxHp - h)){
			hp += h;
		}
		else {
			hp = maxHp;
		}
	}
	/**
	 * decreases the current hit points some amount
	 * @param h the amount of hit points that are being subtracted to the
	 * current hit points
	 */
	public void takeDamgage(int h) {
		hp = hp - h;
	}
	/**
	 * increases the max hit points some amount
	 * @param h the amount of hit points that are being added to the
	 * max hit points
	 */
	public void increaseMaxHP(int h) {
		maxHp = maxHp + h;
	}
	/**
	 * decreases the max hit points some amount
	 * @param h the amount of hit points that are being subtract to the
	 * max hit points
	 */
	public void decreaseMaxHP(int h) {
		maxHp = maxHp - h;
	}
	/**
	 * displays the name, level, current hit points, and max hit points of
	 * the entity
	 */
	public void display() {
		System.out.println( name );
		System.out.println("Lvl: " + level );
		System.out.println("HP: " + hp + "/" + maxHp );
	}
	
	public String toStringz() {
		String entity = name + "level: " + String.valueOf(level) + "hp: " + String.valueOf(maxHp);
		return entity;
	}
	
}
