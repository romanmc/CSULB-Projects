package starWars;

public abstract class EnemyDecorator implements Character {

	public final Character chara;
	
	public EnemyDecorator(Character chara) {
		super();
		this.chara = chara;
	}
	@Override
	public int getMaxHP() {
		System.out.println((chara.getMaxHP()) + ":max hp dec");

		return chara.getMaxHP();
	}

	@Override
	public int getAddDmg() {
		return chara.getAddDmg();
	}
	
	public String toStringz() {
		String entity = chara.toStringz() + "(ED)";
		return entity;
	}
}
