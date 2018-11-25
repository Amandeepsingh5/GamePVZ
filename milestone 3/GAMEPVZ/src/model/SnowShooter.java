/**
 * 
 */
package model;

@SuppressWarnings("serial")
public class SnowShooter extends Plant {
	// Default Health FCharacter multiplies with level to increase max health (Experimental)
	private static final int Health = 40;
	// Default Damage FCharacter multiplies with level to increase damage (Experimental)
	private static final int Damage = 10; 
	// The solar price of the plant
	private static final int price = 4;
	// Default Sprite for the Plant
	private static final String picture = "images/peashooterFreeze.jpg";

	/**
	 * @param level
	 */
	public SnowShooter(int level) {
		super((Health*level), level, "SS", price, picture);
	}

	/**
	 * @return 2 if zombie was successfully attacked else returns 0
	 */
	@Override
	public int action(Level field) {
		return attack(field);
	}

	/**
	 * Moves through the grid to check if there is any zombies in the vicinity
	 * @return 2 if zombie successfully attacked else returns 0
	 */
	private int attack(Level field) {
		// iterates through the field to till it reaches the end of the field
		int x = this.x;
		Character zombie;
		while(field.fieldDimension(x, this.y)){
			if(field.loc_zombie(x, this.y)) {
				zombie = field.getCharacterAt(x, this.y);
				if(zombie instanceof PoleZombie){
					((PoleZombie) zombie).setFrozen(true);
					zombie.takeDamage(Damage * super.level);
					return 2;
				}
				else if(zombie instanceof ExplosiveZombie){
					((ExplosiveZombie) zombie).Freeze(true);
					zombie.takeDamage(Damage * super.level);
					return 2;
				}
				else{
					zombie.takeDamage(2 * Damage);
					return 2;
				}
			}
			x++;
		}
		return 0;	
	}
}
