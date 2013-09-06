package dragonsreign.character;

import dragonsreign.util.RandomInt;
import dragonsreign.util.Resources;
import dragonsreign.util.Stats;

public abstract class Character {
	// ===========================================================
	// Constants
	// ===========================================================

	protected final static int MAX_LEVEL = 60;

	// ===========================================================
	// Fields
	// ===========================================================

	// All players and enemies have an ID
	protected int mID;

	// All players and enemies have a name
	protected String mName;

	// All players and enemies have a level
	protected int mLevel;

	// Decider of turn order
	protected int mHaste;

	// For players, the experience that the enemy provides
	// For enemies, the experience that is rewarded to player
	protected int mExperience;

	protected Resources mBaseResources;
	protected Resources mCurrentResources;
	protected Resources mMaxResources;

	protected Stats mBaseStats;
	protected Stats mCurrentStats;
	protected Stats mMaxStats;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Character() {
		mID = 0;
		mName = "";
		mLevel = 0;
		mExperience = 0;
		mHaste = 0;

		mBaseResources = new Resources();
		mBaseStats = new Stats();

		mBaseResources.setHealth(0);
		mBaseResources.setResource(0);

		mBaseStats.setStrength(0);
		mBaseStats.setDexterity(0);
		mBaseStats.setIntelligence(0);
		mBaseStats.setVitality(0);
		mBaseStats.setDamage(0);
		mBaseStats.setArmor(0);

		// Sets the current and max to the base to have initial values
		mCurrentResources = mBaseResources;
		mCurrentStats = mBaseStats;

		mMaxResources = mBaseResources;
		mMaxStats = mBaseStats;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ID
	public int getID() {
		return mID;
	}

	public void setID(int pID) {
		this.mID = pID;
	}

	// Name
	public String getName() {
		return mName;
	}

	public void setName(String pName) {
		this.mName = pName;
	}

	// Level
	public int getLevel() {
		return mLevel;
	}

	public void setLevel(int pLevel) {
		this.mLevel = pLevel;
	}

	// Haste
	public int getHaste() {
		return mHaste;
	}

	public void setHaste(int pHaste) {
		this.mHaste = pHaste;
	}

	// Experience
	public int getExperience() {
		return mExperience;
	}

	public void setExperience(int pExperience) {
		this.mExperience = pExperience;
	}

	// Resources
	public Resources getBaseResources() {
		return mBaseResources;
	}

	public void setBaseResources(Resources pBaseResources) {
		this.mBaseResources = pBaseResources;
	}

	public Resources getCurrentResources() {
		return mCurrentResources;
	}

	public void setCurrentResources(Resources pCurrentResources) {
		this.mCurrentResources = pCurrentResources;
	}

	public Resources getMaxResources() {
		return mMaxResources;
	}

	public void setMaxResources(Resources pMaxResources) {
		this.mMaxResources = pMaxResources;
	}
	
	
	// Stats
	public Stats getBaseStats() {
		return mBaseStats;
	}

	public void setBaseStats(Stats pBaseStats) {
		this.mBaseStats = pBaseStats;
	}
	
	public Stats getCurrentStats() {
		return mCurrentStats;
	}

	public void setCurrentStats(Stats pCurrentStats) {
		this.mCurrentStats = pCurrentStats;
	}

	public Stats getMaxStats() {
		return mMaxStats;
	}

	public void setMaxStats(Stats pMaxStats) {
		this.mMaxStats = pMaxStats;
	}

	// Alive
	public boolean isDead() {
		return (this.getCurrentResources().getHealth() < 0);
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// Compare haste to determine turn order
	public boolean compareHasteTo(int pHaste) {
		boolean turnDecision = false;

		// If current character haste is less than the other character's haste
		if (this.mHaste < pHaste) {
			// Enemy goes first
			turnDecision = false;
		} else if (this.mHaste > pHaste) {
			// Player goes first
			turnDecision = true;
		} else if (this.mHaste == pHaste) {
			// Randomly pick a turn decision in the range
			int randomNumber = RandomInt.generateRandomInt(1, 10);

			if (randomNumber <= 5) {
				// Player goes first
				turnDecision = true;
			} else if (randomNumber >= 6) {
				// Enemy goes first
				turnDecision = false;
			}
		}

		return turnDecision;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}