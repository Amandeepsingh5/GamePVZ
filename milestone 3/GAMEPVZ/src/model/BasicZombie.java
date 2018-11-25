package model;


@SuppressWarnings("serial")
public class BasicZombie extends MainZombie {
	private static final int Health = 50; 
	// Default Damage FCharacter multiplies with level to increase damage (Experimental)
	private static final int Damage = 10; 
	// Default Sprite for the Zombie
	private static final String picture = "images/damagedExplosiveZombie.png";
	// Cracked Sprite for the Zombie
	private static final String ZombieHurt = "images/damagedZombie.png";


	/**
	 * Constructor for BasicZombie based on the level
	 * @param level
	 */
	public BasicZombie(int level) {
		super((Health * level), level, "Z", picture, ZombieHurt);
	}

	/** 
	 * makes the zombie move or attack
	 * @returns 2 if the zombie attacks or returns 1 if zombie moves.
	 */
	public int action(Level field){
		int move = super.move(field);
		if(move == 0){						//only true if there is a plant at x-1, y
			//if (field.inBounds(x-1, y)){		//redundant
				Character target;
				//if(field.plantAt(x-1, y)){	//redundant
					target = field.getCharacterAt(x-1, y);
					attack(target);
					return 2;
		}
		else{
			return move;
		}
	}


	/**
	 * Attacks the Character object passed causing damage
	 * @param Character
	 */
	protected void attack(Character Character) {
		Character.takeDamage(Damage * super.level);
	}
	/**
	 * @return 0 as in this version the player does not get to play zombie, Maybe implement it in future versions
	 */
	protected int move(Level field){
		return super.move(field);
	}


}
