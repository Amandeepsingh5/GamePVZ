package model;


@SuppressWarnings("serial")
public class SunFlower extends Plant {
	// Default Health FCharacter multiplies with level to increase max health (Experimental)
	private static final int Health = 25;
	// The solar price of the plant
	private static final int price = 1;
	// Default Sprite for the Plant
	private static final String picture = "images/sunflower.png";
	// Number of turns that have passed since the creation of the SunFlower
	private int chance;
	

	/**
	 * Constructor for SunFlower, which extends the Plant Class
	 * @param level
	 */
	public SunFlower(int level) {
		super((Health * level), level, "F", price, picture);
		chance = 3;
	}
	
	/** 
	 * Generates suns on every third turn since the creation of the plant
	 * @return 5 if sun is generated else returns a 0
	 */
	public int action(Level grid) {
		if((this.chance % 3) == 0){
			chance++;
			return 5;
		}
		chance++;
		return 0;
	}
}
