package starWars;

public class ForceUser extends EnemyDecorator {


	
	public ForceUser(Character chara) {
		super(chara);
	}
	@Override
	public int getMaxHP() {
		return chara.getMaxHP() + 2;
	}
	@Override
	public int getAddDmg() {
		return super.getAddDmg() + 1;
	}
	@Override
	public String getName() {
		return chara.getName();
	}
	@Override
	public int getLevel() {
		return chara.getLevel();
	}
	@Override
	public int getHP() {
		return chara.getHP();
	}
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
	
	public String toStringz() {
		String entity = super.toStringz() + "(Force)";
		return entity;
	}
	
}
