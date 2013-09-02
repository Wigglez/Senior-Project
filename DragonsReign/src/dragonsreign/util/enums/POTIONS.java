package dragonsreign.util.enums;


public enum POTIONS {

	/** The minor health potion. */
	MINOR_HEALTH_POTION(0),

	/** The major health potion. */
	MAJOR_HEALTH_POTION(1),

	/** The superior health potion. */
	SUPERIOR_HEALTH_POTION(2),

	/** The minor resource potion. */
	MINOR_RESOURCE_POTION(3),

	/** The major resource potion. */
	MAJOR_RESOURCE_POTION(4),

	/** The superior resource potion. */
	SUPERIOR_RESOURCE_POTION(5),

	/** The antidote potion. */
	ANTIDOTE_POTION(6),

	/** The basic revive potion. */
	BASIC_REVIVE_POTION(7),

	/** The full revive potion. */
	FULL_REVIVE_POTION(8);

	/** The m potion id. */
	private int mPotionID;

	
	private POTIONS(int pPotionID) {
		this.mPotionID = pPotionID;
	}

	
	public int getPotionID() {
		return mPotionID;
	}
}
