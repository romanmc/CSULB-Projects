package starWars;

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
}
