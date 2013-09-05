package dragonsreign.character;

import dragonsreign.util.RandomInt;

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

	// Resources
	public int mHealth;
	public int mResource;
	
	// Stats
	public int mStrength;
	public int mDexterity;
	public int mIntelligence;
	public int mVitality;
	public int mDamage;
	public int mArmor;


	// ===========================================================
	// Constructors
	// ===========================================================

	public Character() {
		mID = 0;
		mName = "";
		mLevel = 0;
		mExperience = 0;
		mHaste = 0;
		
		mHealth = 0;
		mResource = 0;
		
		mStrength = 0;
		mDexterity = 0;
		mIntelligence = 0;
		mVitality = 0;
		mDamage = 0;
		mArmor = 0;
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
	
	// Resource
	public int getHealth() {
		return mHealth;
	}
	
	public void setHealth(int pHealth) {
		this.mHealth = pHealth;
	}
	
	public int getResource() {
		return mResource;
	}
	
	public void setResource(int pResource) {
		this.mResource = pResource;
	}
	
	// Stat
	public int getStrength() {
		return mStrength;
	}
	
	public void setStrength(int pStrength) {
		this.mStrength = pStrength;
	}
	
	public int getDexterity() {
		return mStrength;
	}
	
	public void setDexterity(int pDexterity) {
		this.mDexterity = pDexterity;
	}
	
	public int getIntelligence() {
		return mIntelligence;
	}
	
	public void setIntelligence(int pIntelligence) {
		this.mIntelligence = pIntelligence;
	}
	
	public int getVitality() {
		return mVitality;
	}
	
	public void setVitality(int pVitality) {
		this.mVitality = pVitality;
	}
	
	public int getDamage() {
		return mDamage;
	}
	
	public void setDamage(int pDamage) {
		this.mDamage = pDamage;
	}
	
	public int getArmor() {
		return mArmor;
	}
	
	public void setArmor(int pArmor) {
		this.mArmor = pArmor;
	}

	// Alive
	public boolean getAlive() {
		return (mHealth > 0);
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