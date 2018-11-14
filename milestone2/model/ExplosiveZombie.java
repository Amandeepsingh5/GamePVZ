/**
 * 
 */
package model;

@SuppressWarnings("serial")
public class ExplosiveZombie extends Zombie {
	
	private static final int health = 50; 
	
	private static final int damage = 20;
	
	private static final String picture = "images/zombie.png";
	
	
	 
	public ExplosiveZombie(int level) {
		super((health * level), level, "Z", picture);
	
	}

	
	@Override
	protected void attack(Character Character) {
		
		Character.takeDamage(damage * 2);
	}

	
	@Override
	public int action(Level grid) {
		if (super.currentHealth <= 0.2 * super.maximumHealth ){
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
			
	
	public Object clone()throws CloneNotSupportedException{
		 ExplosiveZombie clone = (ExplosiveZombie)super.clone();
		 
		 return clone;
	}

}

