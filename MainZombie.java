package model;

@SuppressWarnings("serial")
public abstract class MainZombie extends Character {
	protected String crackedSprite;

	public MainZombie(int maxHealth, int level, String string, String sprite, String crackedSprite) {
		super(maxHealth, level, string, false, sprite);
		this.crackedSprite = crackedSprite;
	}

	/**
	 * Attacks the Character object passed causing damage
	 * @param Character
	 */
	protected abstract void attack(Character Character);

	/**
	 * Moves the zombie to the left in the grid
	 * @param grid - the level that suplies the character location
	 */
	protected int move(Level grid) {
		//zombies walk to the left
		if(grid.fieldDimension(x-1, y)){
			if(grid.plantAt(this.x - 1, this.y)){
				return 0;
			}
			else {
				//grid.getCharactersAt(this.x, this.y).remove(this);
				this.x = this.x -1;
				//grid.getCharactersAt(this.x, this.y).add(this);
				return 1;
			}
		}
		else{
			return -1;
		}
	}
	/**
	 * Returns the cracked sprite if the health falls to certain point
	 * @returns a cracked sprite if the health has fallen below 40% of max health
	 */
	public String getSprite(){
		if(super.isCracked()){
			return crackedSprite;
		}
		else{
			return super.sprite;
		}

	}

	public Object clone()throws CloneNotSupportedException{
		MainZombie clone = (MainZombie)super.clone();
		clone.crackedSprite = this.crackedSprite;
		return clone;
	}

}