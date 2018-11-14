
package model;


@SuppressWarnings("serial")
public abstract class Plant extends Character{

	protected int price;


	public Plant( int level,int maximumH, String string, int price, String picture) {
		super(maximumH, level, string, true, picture);
		this.price = price;
	}

	/**
	 * @return the cost of the plant
	 */
	public int price(){
		return price;
	}
	
	/**
	 * Checks if string matches a plant name and if the are enough sun points
	 * @param string - a string that defines what type of plant it is
	 * @param suns - the current amount of sun points
	 * @return Plant -returns the plant or null
	 */
	public Plant getPlant(String string, int suns) {				//should use an enum instead of a string...
		Plant plant = null;
		if(string.equals("sunflower")){
			plant = new SunFlower(level);
		}

		else if (string.equals("shooter")){
			plant = new PeaShooter(level);
		}

		else{
			return null;
		}
		// Check if there are enough suns for the plant
		if(plant.price() > suns){
			return null;
		}
		else{
			return plant;
		}
	}


	public Object clone()throws CloneNotSupportedException{

		Plant clone = (Plant)super.clone();
		clone.price = this.price;
		return clone;
	}

}