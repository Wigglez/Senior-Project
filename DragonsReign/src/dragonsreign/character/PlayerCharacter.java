package dragonsreign.character;

import java.util.ArrayList;

import dragonsreign.item.Gear;
import dragonsreign.item.Item;
import dragonsreign.item.consumable.Potion;
import dragonsreign.util.Stats;

public abstract class PlayerCharacter extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// Experience
	protected int mCurrentExperience;

	protected int mSkillPoints;

	protected int mAbilityLevel;
	protected int mAbilityCost;
	protected boolean[] mUnlockedAbility;

	// Items
	protected ArrayList<Item> mEquippedItems = new ArrayList<Item>();
	protected Stats mItemStats;

	// ===========================================================
	// Constructors
	// ===========================================================

	public PlayerCharacter() {
		mAbility = new String[6];
		mUnlockedAbility = new boolean[6];
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// Experience
	public int getCurrentExperience() {
		return mCurrentExperience;
	}

	public void setCurrentExperience(int pCurrentExperience) {
		this.mCurrentExperience = pCurrentExperience;
	}

	// Skill points
	public int getSkillPoints() {
		return mSkillPoints;
	}

	public void setSkillPoints(int pSkillPoints) {
		this.mSkillPoints = pSkillPoints;
	}

	// Abilities
	public int getAbilityLevel() {
		return mAbilityLevel;
	}

	public void setAbilityLevel(int pAbilityLevel) {
		this.mAbilityLevel = pAbilityLevel;
	}

	public int getAbilityCost() {
		return mAbilityCost;
	}

	public void setAbilityCost(int pAbilityCost) {
		this.mAbilityCost = pAbilityCost;
	}

	public boolean[] getUnlockedAbility() {
		return mUnlockedAbility;
	}

	public void setUnlockedAbilities(boolean[] pUnlockedAbility) {
		this.mUnlockedAbility = pUnlockedAbility;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	public abstract void levelUp();

	public abstract void equipItem(Gear pGearPiece);

	// ===========================================================
	// Methods
	// ===========================================================

	public void updateCurrentStats() {
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

	public boolean abilityUnlocked(int pAbilityIndex) {
		if (mUnlockedAbility[pAbilityIndex])
			return true;
		else
			return false;
	}

	// TODO
	public boolean useItem(Potion pPotion) {

		switch (pPotion.getmPotionID()) {
		case MINOR_HEALTH_POTION: case MAJOR_HEALTH_POTION: case SUPERIOR_HEALTH_POTION:
			
			//Check to make sure character isn't at full health
			if(mCurrentResources.getHealth() < mMaxResources.getHealth()){
				//currentHealth = currentHealth + maxHealth * AmountRestored(% of max health)
				mCurrentResources.setHealth((int) (mCurrentResources.getHealth() + mMaxResources.getHealth()*pPotion.getmAmountRestored()));
				
				//Double check currentHealt doesn't exced maxHealth
				if(mCurrentResources.getHealth() < mMaxResources.getHealth()){
					//If it does then set currentHealth to maxHealth
					mCurrentResources.setHealth(mMaxResources.getHealth());
				}
				
				return true;				
			}
			else
				return false;
		case MINOR_RESOURCE_POTION: case MAJOR_RESOURCE_POTION: case SUPERIOR_RESOURCE_POTION:
			
			//Check to make sure character isn't at full Resource
			if(mCurrentResources.getResource() < mMaxResources.getResource()){
				//currentResource = currentResource + maxResource * AmountRestored(% of maxResource)
				mCurrentResources.setResource((int) (mCurrentResources.getResource() + mMaxResources.getResource()*pPotion.getmAmountRestored()));
				
				//Double check currentResource doesn't exced maxResource
				if(mCurrentResources.getResource() < mMaxResources.getResource()){
					//If it does then set currentResource to maxResource
					mCurrentResources.setResource(mMaxResources.getResource());
				}
				
				return true;				
			}
			else
				return false;

		case ANTIDOTE_POTION:
			//TODO send it to battle System

		case BASIC_REVIVE_POTION: case FULL_REVIVE_POTION:
			
			//Character must be dead to use revive
			if(isDead()){
				
				//currentHealth = maxHealth * AmountRestored(% of max health) : 50 or 100%
				mCurrentResources.setHealth((int) (mMaxResources.getHealth()*pPotion.getmAmountRestored()));
				
				//currentResource = maxResource * AmountRestored(% of maxResource) : 50 or 100%
				mCurrentResources.setResource((int) (mMaxResources.getResource()*pPotion.getmAmountRestored()));
				
				return true;
			}
			else
				return false;
		}

		return true;

	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}