package starWars;
/**
 * interface for all units in the game
 * @author Roman
 *
 */
public interface Character {

	int getMaxHP();
	int getAddDmg();
	String getName();
	int getLevel();
	int getHP();
	Item getItem();
	void attack(Character e);
	void takeDamgage(int h);
	String toStringz();
	void resetHealth();
	void setLevel(int l);
}
