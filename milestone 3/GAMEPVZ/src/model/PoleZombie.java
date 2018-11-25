package model;

@SuppressWarnings("serial")
public class PoleZombie extends MainZombie {
	// Default Health FCharacter multiplies with level to increase max health (Experimental)
	private static final int Health = 50; 
	// Default Damage FCharacter multiplies with level to increase damage (Experimental)
	private static final int Damage = 10; 
	// false if zombie can jump
	private boolean jumper;
	// boolean frozen to see if the zombie has been frozen
	private boolean Freeze;
	// Default Sprite for the Zombie
	private static final String Picture = "images/PoleZombie.png";
	// Cracked Sprite for the Zombie
	private static final String BloodyPicture = "images/damagedPoleZombie.png";

	/**
	 * Constructor for PoleZombie based on the level
	 * @param level
	 */
	public PoleZombie(int level) {
		super((Health * level), level, "PZ", Picture, BloodyPicture);
		this.jumper = false;
		this.Freeze = false;
	}


	/**
	 * @param boolean, true to prevent jumping, false otherwise
	 */
	public void setjumper(boolean jumper) {
		this.jumper = jumper;
	}


	/* (non-Javadoc)
	 * @see model.Character#act()
	 */
	@Override
	public int action(Level field) {

		int move = move(field);

		if(move == 0){
			Character leftCharacter = field.getCharacterAt(x - 1, y);
			attack(leftCharacter);
			return 2;
		}
		else{
			return move;
		}
	}

	/* (non-Javadoc)
	 * @see model.Zombie#attack(model.Character)
	 */
	@Override
	protected void attack(Character Character) {

		Character.takeDamage(Damage * super.level);
	}

	/**
	 * Moves the zombie to the left in the grid
	 * @param field - the level that suplies the character location
	 */
	protected int move(Level field){
		if(this.Freeze){
			return super.move(field);
		}
		else{
			int i = 0;
			while(i<2 && super.move(field) > 0){
				i++;	
			}
			if(i<2){
				return jump(field);
			}
			else{
				return 1;
			}

		}


	}
	/**
	 * Makes the zombie jump a plant
	 * @return 1 if the jump is successful
	 */
	private int jump(Level field){
		if(!this.jumper){
			if(field.fieldDimension(x - 2, y)){
				if(field.plantAt(x-2, y)){
					return 0;
				}
				else{
					field.getCharactersAt(this.x, this.y).remove(this);
					this.x = this.x - 2;
					field.getCharactersAt(this.x, this.y).add(this);
					this.jumper = true;
					return 1;
				}
			}else{
				return -1;
			}
		}else{
			return 0;
		}
	}


	/**
	 * Sets if the zombie is froozen
	 * @param Freeze the Freeze to set
	 */
	public void setFrozen(boolean Freeze) {
		this.Freeze = Freeze;
	}
	/**
	 * Returns the state of the zombie
	 * @return true if the zombie is froozen
	 */
	public boolean Freeze() {
		return this.Freeze;
	}

	/**
	 * Clones Pole Zombie and its state
	 * @return clone of the Pole Zombie and its state
	 */
	public Object clone()throws CloneNotSupportedException{
		PoleZombie clone = (PoleZombie)super.clone();
		clone.Freeze = this.Freeze;
		clone.jumper = this.jumper;
		return clone;
	}

}
