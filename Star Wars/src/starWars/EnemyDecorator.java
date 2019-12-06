package starWars;
/**
 * decorates enemy's with two different options (fighter and force user)
 * @author Roman
 *
 */
public abstract class EnemyDecorator implements Character {
	/**
	 * an instance of a base unit for the game
	 */
	public final Character chara;
	/**
	 * constructor that uses a character to make it
	 * @param chara
	 */
	public EnemyDecorator(Character chara) {
		super();
		this.chara = chara;
	}
	/**
	 * gets the max HP of the current character
	 */
	@Override
	public int getMaxHP() {
		System.out.println((chara.getMaxHP()) + ":max hp dec");

		return chara.getMaxHP();
	}
	/**
	 * gets the added damage to the character
	 */
	@Override
	public int getAddDmg() {
		return chara.getAddDmg();
	}
	/**
	 * formats the enemy decorator into a string to test
	 */
	public String toStringz() {
		String entity = chara.toStringz() + "(ED)";
		return entity;
	}
}
