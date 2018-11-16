package model;



public abstract class Zombie extends Character {
	

	public Zombie(int maxHealth, int level, String string, String picture) {
		super(maxHealth, level, string, false, picture);
		
	}
	
	
	/**
	 * Attacks the Character object passed causing damage
	 * @param Character
	 */
	protected abstract void attack(Character Character);
	
	/**
	 * move() method moves the zombie to the left in the grid
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
	 * @returns picture if the health has fallen below 40% of max health
	 */
	 public String getPicture(){
		String  p = super.picture;
		return p;
		 }
		 
	 
	 
	 public Object clone()throws CloneNotSupportedException{
		 Zombie clone = (Zombie)super.clone();
		 return clone;
	 }
	
}