package dragonsreign.character;

import dragonsreign.util.AbilityData;
import dragonsreign.util.Resources;
import dragonsreign.util.Stats;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.HASTE;

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
	protected HASTE mHaste;
	
	//Ability names
	protected String[] mAbility;

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
		mHaste = HASTE.HASTE_TYPE_NORMAL;

		mBaseResources = new Resources();
		mCurrentResources = new Resources();
		mMaxResources = new Resources();
		
		mBaseStats = new Stats();
		mCurrentStats = new Stats();
		mMaxStats = new Stats();

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
	public HASTE getHaste() {
		return mHaste;
	}

	public void setHaste(HASTE pHaste) {
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
	
	//Abilities
	public String[] getAbility() {
		return mAbility;
	}

	public void setAbility(String[] pAbility) {
		this.mAbility = pAbility;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public abstract ABILITYFLAGS useAbility(int pAbilityIndex, AbilityData pAbilityData);

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}