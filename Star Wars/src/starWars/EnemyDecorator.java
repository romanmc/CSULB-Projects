package starWars;

public abstract class EnemyDecorator implements Character {

	public final Character chara;
	
	public EnemyDecorator(Character chara) {
		super();
		this.chara = chara;
	}
	@Override
	public int getMaxHP() {
		return 0;
	}
	@Override
	public int getAddDmg() {
		return 0;
	}
	
	public String toStringz() {
		String entity = chara.toStringz() + "(ED)";
		return entity;
	}
}
