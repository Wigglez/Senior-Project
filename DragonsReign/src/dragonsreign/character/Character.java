package dragonsreign.character;

import dragonsreign.util.AbilityData;
import dragonsreign.util.RandomNumber;
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
	
	//Sprite
	protected int mSpriteID;

	
	// All players and enemies have a name
	protected String mName;

	// All players and enemies have a level
	protected int mLevel;

	// Decider of turn order
	protected HASTE mHaste;

	// Ability names
	protected String[] mAbility;

	// For players, the experience that the enemy provides
	// For enemies, the experience that is rewarded to player
	protected int mExperience;

	protected Resources mBaseResources;
	protected Resources mCurrentResources;
	protected Resources mMaxResources;

	protected Stats mBaseStats;
	protected Stats mCurrentStats;

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

		mBaseResources.setHealth(0);
		mBaseResources.setResource(0);

		mBaseStats.setStrength(0);
		mBaseStats.setDexterity(0);
		mBaseStats.setIntelligence(0);
		mBaseStats.setVitality(0);
		mBaseStats.setDamage(0);
		mBaseStats.setArmor(0);

		// Sets the current and max to the base to have initial values
//		mCurrentResources = mBaseResources;
//		mCurrentStats = mBaseStats;
//
//		mMaxResources = mBaseResources;
		
		mAbility = new String[6];
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

	// Sprite ID
	public int getSpriteID() {
		return mSpriteID;
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

	// Not alive
	public boolean isDead() {
		boolean hpDead = this.getCurrentResources().getHealth() <= 0;
		
		return hpDead;
	}

	// Abilities
	public String[] getAbility() {
		return mAbility;
	}

	public void setAbility(String[] pAbility) {
		this.mAbility = pAbility;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public abstract ABILITYFLAGS useAbility(int pAbilityIndex,
			AbilityData pAbilityData);

	// ===========================================================
	// Methods
	// ===========================================================

	public int incomingDamage(int pIncomingDamage) {
		int mitigatedDamage = 0;

		// Higher amounts of armor will yield more mitigation
		float armorModifier = mCurrentStats.getArmor()
				* RandomNumber.generateRandomFloat(0.15f, 0.25f);

		// An armor modifier will never be able to go above half the amount of
		// damage incoming
		int armorModifierCap = pIncomingDamage / 2;

		if (armorModifier <= armorModifierCap) {
			mitigatedDamage = (int) (pIncomingDamage - armorModifier);
		} else {
			mitigatedDamage = armorModifierCap;
		}

		return mitigatedDamage;
	}

	public void AddBuff(Stats pBuff) {
		mCurrentStats.setStrength(mCurrentStats.getStrength()
				+ pBuff.getStrength());
		mCurrentStats.setDexterity(mCurrentStats.getDexterity()
				+ pBuff.getDexterity());
		mCurrentStats.setIntelligence(mCurrentStats.getIntelligence()
				+ pBuff.getIntelligence());
		mCurrentStats.setVitality(mCurrentStats.getVitality()
				+ pBuff.getVitality());
	}

	public void TakeDamage(int pDamage) {

		mCurrentResources.setHealth(mCurrentResources.getHealth() - pDamage);
		
		if (mCurrentResources.getHealth() < 0) {
			mCurrentResources.setHealth(0);
		}

	}

	public void HealPlayer(int pHealAmount) {

		mCurrentResources
				.setHealth(mCurrentResources.getHealth() + pHealAmount);
		
		if (mCurrentResources.getHealth() > mMaxResources.getHealth()) {
			mCurrentResources.setHealth(mMaxResources.getHealth());
		}

	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}