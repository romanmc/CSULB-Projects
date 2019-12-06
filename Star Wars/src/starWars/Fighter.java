package starWars;
/**
 * decorator for enemy that gives the enemy +1 maxHp
 * and +1 dmg
 * @author Roman
 *
 */
public class Fighter extends EnemyDecorator {
	/**
	 * constructor that makes a character
	 * @param chara
	 */
	public Fighter(Character chara) {
		super(chara);
	}
	/**
	 * gets the maxHp of the character +1
	 */
	@Override
	public int getMaxHP() {
		return chara.getMaxHP() + 1;
	}
	/**
	 * gets the added dmg of the character +1
	 */
	@Override
	public int getAddDmg() {
		return chara.getAddDmg() + 1;
	}
	/**
	 * gets the name of the character
	 */
	@Override
	public String getName() {
		return chara.getName();
	}
	/**
	 * gets the level of the character
	 */
	@Override
	public int getLevel() {
		return chara.getLevel();
	}
	/**
	 * gets the current hp of the character
	 */
	@Override
	public int getHP() {
		return chara.getHP();
	}
	/**
	 * gets the item of the character
	 */
	@Override
	public Item getItem() {
		return chara.getItem();
	}
	@Override
	public void attack(Character e) {
		chara.attack(e);
	}
	@Override
	public void takeDamgage(int h) {
		chara.takeDamgage(h);
	}
	@Override
	public void resetHealth() {
		chara.resetHealth();
	}
	@Override
	public void setLevel(int l) {
		chara.setLevel(l);
	}

	
	public String toString() {
		String entity = super.toString() + "(Fighter)";
		return entity;
	}
}
