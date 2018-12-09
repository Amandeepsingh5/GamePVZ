package model;

@SuppressWarnings("serial")
public class ExplosiveZombie extends MainZombie {

	private static final int health = 50; 
	// Default Damage FCharacter multiplies with level to increase damage 
	private static final int damage = 20;
	// Default Sprite for the Zombie
	private static final String PICTURE = "images/HealthyExplosiveZombie.jpg";
	// Cracked Sprite for the Zombie
	private static final String BLOODPICTURE = "images/damagedExplosiveZombie.png";
	// boolean frozen to see if the zombie has been frozen
	private boolean Froze;


	public ExplosiveZombie(int level) {
		super((health * level), level, "ZE", PICTURE, BLOODPICTURE);
		Froze = false;
	}

	/* (non-Javadoc)
	 * @see model.Zombie#attack(model.Character)
	 */
	@Override
	protected void attack(Character Character) {
		Character.takeDamage(damage * 2);
	}

	/** 
	 * Act method for this class
	 * @returns 0 for no movement, 1 for movement and 2 for successful attack
	 */
	@Override
	public int action(Level grid) {
		if (super.currentHealth <= 0.2 * super.maximumHealth && !this.Froze){
			explode(grid);
			this.takeDamage(1000);
			return 2;
		}
		int move = super.move(grid);
		if(move == 0){
			//if(grid.inBounds(x-1, y)){				//redundant, checked in move
			//if (grid.plantAt(this.x - 1, this.y)) {
			attack(grid.getCharacterAt(this.x -1, y));
			return 2;
			//}
			//}
			//else{
			//	return -1;
			//}
		}
		else{
			return move;
		}
		//return move;
	}


	/**
	 * causes Character in a surrounding area to explode
	 * @param grid - the level that suplies the character location
	 * @return 
	 */
	private int explode(Level grid){
		Character target;
		for(int i = -1; i < 2; i++){
			for(int j = -1; j < 2; j++){
				target = grid.getCharacterAt(x + i, y + j);
				if(target != null){
					target.takeDamage(1000);
				}
			}
		}
		return 0;
	}


	/**
	 * @param Froze the Froze to set
	 */
	public void Freeze(boolean Froze) {
		this.Froze = Froze;
	}

	/**
	 * Clones Explosive Zombie and its state
	 * @return clone of the Explosive Zombie and its state
	 */
	public Object clone()throws CloneNotSupportedException{
		ExplosiveZombie clone = (ExplosiveZombie)super.clone();
		clone.Froze = this.Froze;
		return clone;
	}

}

