public class Sunflower extends Plant {
	private static final int COST = 25;
	
	private int strength = 15;
	protected int maxHealth = 20;
	
	public Sunflower( Game inOwner) {
		super(inOwner);
		name = "Sunflower";
		cost = COST;
	}

	@Override
	public Action gameFunction() {
		return new Action(2, strength);
	}

}