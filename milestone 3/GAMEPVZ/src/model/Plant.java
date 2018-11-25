
package model;

@SuppressWarnings("serial")
public abstract class Plant extends Character{

	protected int price;

	public Plant(int maxHealth, int level, String string, int price, String sprite) {
		super(maxHealth, level, string, true, sprite);
		this.price = price;
	}

	/**
	 * @return the price of the plant
	 */
	public int getprice(){
		return price;
	}

	/**
	 * Clones the Plant
	 * @return clone of the Plant
	 */
	public Object clone()throws CloneNotSupportedException{
		Plant clone = (Plant)super.clone();
		clone.price = this.price;
		return clone;
	}

}