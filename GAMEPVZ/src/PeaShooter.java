package model;

@SuppressWarnings("serial")
public class PeaShooter extends Plant {
	// Default Health FCharacter multiplies with level to increase max health (Experimental)
	private static final int HF = 40;
	// Default Damage FCharacter multiplies with level to increase damage (Experimental)
	private static final int DF = 10; 
	// The solar cost of the plant
	private static final int COST = 2;
	// Default Sprite for the Plant
	private static final String picture = "images/peashooter.png";
	
	/**
	 * @param level
	 */
	public PeaShooter(int level) {
		super((HF * level), level, "S", COST, picture);
	}
	
	/**
	 * @return 2 if zombie was successfully attacked else returns 0
	 */
	public int action(Level grid) {
		return attack(grid);
	}
	
	/**
	 * Moves through the grid to check if there is any zombies in the vicinity
	 * @return 2 if zombie successfully attacked else returns 0
	 */
	private int attack(Level grid) {
		// iterates through the grid to till it reaches the end of the grid
		int x = this.x;
		while(grid.fieldDimension(x, this.y)){
			if(grid.loc_zombie(x, this.y)) {
				grid.getCharacterAt(x, this.y).takeDamage(DF * super.level);
				return 2;
			}
			x++;
		}
		return 0;
	}
}
