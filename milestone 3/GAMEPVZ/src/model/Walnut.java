package model;

@SuppressWarnings("serial")
public class Walnut extends Plant {

	private static final int HF = 100;
	private static final int COST = 20;
	private static final String picture = "images/walnut.png";
	private static final String BloodyPicture = "images/damagedwalnut2.png";
	
	/**
	 * Constructor for Walnut, which extends the Plant Class
	 * @param level
	 */
	public Walnut(int level) {
		super(HF * level, level, "o", COST, picture);
	}

	
	/* 
	 * Act method for this class
	 * @returns 0 for no movement, 1 for movement and 2 for successful attack
	 */
	@Override
	public int action(Level field) {
		return 0;
		
	}
	
	/**
	 * Returns the cracked sprite if the health falls to certain point
	 * @returns a cracked sprite if the health has fallen below 40% of max health
	 */
	public String getSprite(){
		if(super.isCracked()){
			return BloodyPicture;
		}
		else{
			return super.getSprite();
		}
	}
}
