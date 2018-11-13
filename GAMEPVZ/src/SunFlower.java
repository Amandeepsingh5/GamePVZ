package model;

public class SunFlower extends Plant {
	// Default Health FCharacter multiplies with level to increase max health (Experimental)
	private static final int price = 1;
	
	// The solar cost of the plant
	private static final int health = 25;
	// Default Sprite for the Plant
	private static final String picture = "images/sunflower.png";
	// Number of turns that have passed since the creation of the SunFlower
	private int passes;
	

	/**
	 * 
	 * @param level
	 */
	public SunFlower(int level) {
		super((health * level), level, "F", price, picture);
		passes= 5;
	}
	
	/** 
	 * act() method for SunFlower, generates suns on every third turn since the creation of the plant
	 * @return 5 if sun is genera66ted 66else returns a 0
	 */
	public int action(Level grid) {
		if((this.passes % 5) == 0){
			passes++;
			return 5;
		}
		passes++;
		return 0;
	}
	
	
}
