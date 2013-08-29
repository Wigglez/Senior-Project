/*
 * 
 */
package dragonsreign.character;

import org.andengine.entity.sprite.Sprite;

import dragonsreign.util.Resources;
import dragonsreign.util.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerCharacter.
 */
public abstract class PlayerCharacter extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// Sprites

	/** The m battle sprite. */
	protected Sprite mBattleSprite;

	/** The m portrait sprite. */
	protected Sprite mPortraitSprite;

	// Experience

	/** The m current experience. */
	protected int mCurrentExperience;

	/** The m experience to next level. */
	protected int mExperienceToNextLevel;

	// Levels

	/** The m level. */
	protected int mLevel;

	// Stats

	/** The m item stats. */
	protected Stats mItemStats;

	/** The m current stats. */
	protected Stats mCurrentStats;

	/** The m current resources. */
	protected Resources mCurrentResources;

	/** The skill points. */
	protected int mSkillPoints;

	/** The m ability level. */
	protected int mAbilityLevel;

	/** The m ability cost. */
	protected int mAbilityCost;

	/** The m ability id. */
	protected String[] mAbility;

	/** The m unlocked abilities. */
	protected boolean[] mUnlockedAbility;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new player character.
	 */
	public PlayerCharacter() {

		mAbility = new String[6];
		mUnlockedAbility = new boolean[6];

		this.setLevel(1);

		this.setSkillPoints(0);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Gets the battle sprite.
	 * 
	 * @return the battle sprite
	 */
	public Sprite getBattleSprite() {
		return mBattleSprite;
	}

	/**
	 * Sets the battle sprite.
	 * 
	 * @param pBattleSprite
	 *            the new battle sprite
	 */
	public void setBattleSprite(Sprite pBattleSprite) {
		this.mBattleSprite = pBattleSprite;
	}

	/**
	 * Gets the portrait sprite.
	 * 
	 * @return the portrait sprite
	 */
	public Sprite getPortraitSprite() {
		return mPortraitSprite;
	}

	/**
	 * Sets the portrait sprite.
	 * 
	 * @param pPortraitSprite
	 *            the new portrait sprite
	 */
	public void setPortraitSprite(Sprite pPortraitSprite) {
		this.mPortraitSprite = pPortraitSprite;
	}

	/**
	 * Gets the current experience.
	 * 
	 * @return the current experience
	 */
	public int getCurrentExperience() {
		return mCurrentExperience;
	}

	/**
	 * Sets the current experience.
	 * 
	 * @param pCurrentExperience
	 *            the new current experience
	 */
	public void setCurrentExperience(int pCurrentExperience) {
		this.mCurrentExperience = pCurrentExperience;
	}

	/**
	 * Gets the experience to next level.
	 * 
	 * @return the experience to next level
	 */
	public int getExperienceToNextLevel() {
		return mExperienceToNextLevel;
	}

	/**
	 * Sets the experience to next level.
	 * 
	 * @param pExperienceToNextLevel
	 *            the new experience to next level
	 */
	public void setExperienceToNextLevel(int pExperienceToNextLevel) {
		this.mExperienceToNextLevel = pExperienceToNextLevel;
	}

	/**
	 * Gets the level.
	 * 
	 * @return the level
	 */
	public int getLevel() {
		return mLevel;
	}

	/**
	 * Sets the level.
	 * 
	 * @param pLevel
	 *            the new level
	 */
	public void setLevel(int pLevel) {
		this.mLevel = pLevel;
	}

	/**
	 * Gets the item stats.
	 * 
	 * @return the item stats
	 */
	public Stats getItemStats() {
		return mItemStats;
	}

	/**
	 * Sets the item stats.
	 * 
	 * @param pItemStats
	 *            the new item stats
	 */
	public void setItemStats(Stats pItemStats) {
		this.mItemStats = pItemStats;
	}

	/**
	 * Gets the current stats.
	 * 
	 * @return the current stats
	 */
	public Stats getCurrentStats() {
		return mCurrentStats;
	}

	/**
	 * Sets the current stats.
	 * 
	 * @param pCurrentStats
	 *            the new current stats
	 */
	public void setCurrentStats(Stats pCurrentStats) {
		this.mCurrentStats = pCurrentStats;
	}

	/**
	 * Gets the current resources.
	 * 
	 * @return the current resources
	 */
	public Resources getCurrentResources() {
		return mCurrentResources;
	}

	/**
	 * Sets the current resources.
	 * 
	 * @param pCurrentResources
	 *            the new current resources
	 */
	public void setCurrentResources(Resources pCurrentResources) {
		this.mCurrentResources = pCurrentResources;
	}

	/**
	 * Gets the skill points.
	 * 
	 * @return the skill points
	 */
	public int getSkillPoints() {
		return mSkillPoints;
	}

	/**
	 * Sets the skill points.
	 * 
	 * @param pSkillPoints
	 *            the new skill points
	 */
	public void setSkillPoints(int pSkillPoints) {
		this.mSkillPoints = pSkillPoints;
	}

	/**
	 * Gets the ability level.
	 * 
	 * @return the ability level
	 */
	public int getAbilityLevel() {
		return mAbilityLevel;
	}

	/**
	 * Sets the ability level.
	 * 
	 * @param pAbilityLevel
	 *            the new ability level
	 */
	public void setAbilityLevel(int pAbilityLevel) {
		this.mAbilityLevel = pAbilityLevel;
	}

	/**
	 * Gets the ability cost.
	 * 
	 * @return the ability cost
	 */
	public int getAbilityCost() {
		return mAbilityCost;
	}

	/**
	 * Sets the ability cost.
	 * 
	 * @param pAbilityCost
	 *            the new ability cost
	 */
	public void setAbilityCost(int pAbilityCost) {
		this.mAbilityCost = pAbilityCost;
	}

	/**
	 * Gets the abilities.
	 * 
	 * @return the abilities
	 */
	public String[] getAbility() {
		return mAbility;
	}

	/**
	 * Sets the abilities.
	 * 
	 * @param pAbility
	 *            the new ability
	 */
	public void setAbility(String[] pAbility) {
		this.mAbility = pAbility;
	}

	/**
	 * Gets the unlocked abilities.
	 * 
	 * @return the unlocked abilities
	 */
	public boolean[] getUnlockedAbility() {
		return mUnlockedAbility;
	}

	/**
	 * Sets the unlocked abilities.
	 * 
	 * @param pUnlockedAbility
	 *            the new unlocked abilities
	 */
	public void setUnlockedAbilities(boolean[] pUnlockedAbility) {
		this.mUnlockedAbility = pUnlockedAbility;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	/**
	 * Level up.
	 */
	public abstract void levelUp();

	/**
	 * Equip item.
	 */
	public abstract void equipItem(/* Item pEquipItem */);

	/**
	 * Use ability.
	 * 
	 * @param pAbilityIndex
	 *            the ability index
	 */
	public abstract void useAbility(int pAbilityIndex);

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Update current stats.
	 */
	protected void updateCurrentStats() {
		mCurrentStats.setStrength(this.getBaseStats().getStrength()
				+ mItemStats.getStrength());
		mCurrentStats.setDexterity(this.getBaseStats().getDexterity()
				+ mItemStats.getDexterity());
		mCurrentStats.setIntelligence(this.getBaseStats().getIntelligence()
				+ mItemStats.getIntelligence());
		mCurrentStats.setVitality(this.getBaseStats().getVitality()
				+ mItemStats.getVitality());
		mCurrentStats.setDamage(this.getBaseStats().getDamage()
				+ mItemStats.getDamage());
		mCurrentStats.setArmor(this.getBaseStats().getArmor()
				+ mItemStats.getArmor());
	}

	/**
	 * Ability unlocked.
	 * 
	 * @param pAbilityIndex
	 *            the ability index
	 * @return the boolean
	 */
	public boolean abilityUnlocked(int pAbilityIndex) {
		if (mUnlockedAbility[pAbilityIndex])
			return true;
		else
			return false;
	}

	// TODO
	// useItem(consumable item){}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}