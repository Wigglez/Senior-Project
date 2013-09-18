package dragonsreign.character;

import java.util.ArrayList;

import dragonsreign.item.Gear;
import dragonsreign.item.Item;
import dragonsreign.item.consumable.Potion;
import dragonsreign.util.RandomNumber;
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
	protected int mExperienceToNextLevel;

	protected int mSkillPoints;

	protected int mAbilityLevel;
	protected int mAbilityCost;
	protected boolean[] mUnlockedAbility;

	// Items
	protected ArrayList<Item> mEquippedItems = new ArrayList<Item>();
	protected Stats mItemStats;

	protected Gear helmet;
	protected Gear chestArmor;
	protected Gear legArmor;
	protected Gear weaponHand1;
	protected Gear weaponHand2;

	// ===========================================================
	// Constructors
	// ===========================================================

	public PlayerCharacter() {
		mAbility = new String[6];
		mUnlockedAbility = new boolean[6];
		
		mBaseStats = new Stats();
		mItemStats = new Stats();
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

	public void gainExperience(int pExperienceGained) {
		mCurrentExperience += pExperienceGained;
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

	public abstract boolean equipItem(Gear pGearPiece);

	// ===========================================================
	// Methods
	// ===========================================================

	public void LoadCharacter(int pLevel, int pCurrentExperience, Gear pHelmet,
			Gear pChestPlate, Gear pLegArmor, Gear pWeapon1, Gear pWeapon2) {
		
		mCurrentExperience = pCurrentExperience;			

		for (int currentLvl = 2; currentLvl <= pLevel; currentLvl++) {
			mCurrentExperience += mLevel * 68; 
		}
		
		levelUp();
		
		helmet = pHelmet;
		chestArmor = pChestPlate;
		legArmor = pLegArmor;
		weaponHand1 = pWeapon1;
		weaponHand2 = pWeapon2;
		
		updateItemStats();
		updateCurrentStats();
	}

	// Update item stats by summing the respected stats of each individual gear
	// piece
	public void updateItemStats() {

		mItemStats.setStrength(helmet.getItemStats().getStrength()
				+ chestArmor.getItemStats().getStrength()
				+ legArmor.getItemStats().getStrength()
				+ weaponHand1.getItemStats().getStrength());

		mItemStats.setDexterity(helmet.getItemStats().getDexterity()
				+ chestArmor.getItemStats().getDexterity()
				+ legArmor.getItemStats().getDexterity()
				+ weaponHand1.getItemStats().getDexterity());

		mItemStats.setIntelligence(helmet.getItemStats().getIntelligence()
				+ chestArmor.getItemStats().getIntelligence()
				+ legArmor.getItemStats().getIntelligence()
				+ weaponHand1.getItemStats().getIntelligence());

		mItemStats.setVitality(helmet.getItemStats().getVitality()
				+ chestArmor.getItemStats().getVitality()
				+ legArmor.getItemStats().getVitality()
				+ weaponHand1.getItemStats().getVitality());

		mItemStats.setDamage(helmet.getItemStats().getDamage()
				+ chestArmor.getItemStats().getDamage()
				+ legArmor.getItemStats().getDamage()
				+ weaponHand1.getItemStats().getDamage());

		mItemStats.setArmor(helmet.getItemStats().getArmor()
				+ chestArmor.getItemStats().getArmor()
				+ legArmor.getItemStats().getArmor()
				+ weaponHand1.getItemStats().getArmor());

		// Only add weaponHand2 stats if you have something equiped
		if (weaponHand2 != null) {

			mItemStats.setStrength(mItemStats.getStrength()
					+ weaponHand2.getItemStats().getStrength());

			mItemStats.setDexterity(mItemStats.getDexterity()
					+ weaponHand2.getItemStats().getDexterity());

			mItemStats.setIntelligence(mItemStats.getIntelligence()
					+ weaponHand2.getItemStats().getIntelligence());

			mItemStats.setVitality(mItemStats.getVitality()
					+ weaponHand2.getItemStats().getVitality());

			mItemStats.setDamage(mItemStats.getDamage()
					+ weaponHand2.getItemStats().getDamage());

			mItemStats.setArmor(mItemStats.getArmor()
					+ weaponHand2.getItemStats().getArmor());
		}
	}

	// Update the current stats by summing character base stats with item stats
	public void updateCurrentStats() {
		mCurrentStats.setStrength(getBaseStats().getStrength()
				+ mItemStats.getStrength());
		mCurrentStats.setDexterity(getBaseStats().getDexterity()
				+ mItemStats.getDexterity());
		mCurrentStats.setIntelligence(getBaseStats().getIntelligence()
				+ mItemStats.getIntelligence());
		mCurrentStats.setVitality(getBaseStats().getVitality()
				+ mItemStats.getVitality());
		mCurrentStats.setDamage(getBaseStats().getDamage()
				+ mItemStats.getDamage());
		mCurrentStats.setArmor(getBaseStats().getArmor()
				+ mItemStats.getArmor());
	}

	// Returns a bool if the ability is unlocked
	public boolean abilityUnlocked(int pAbilityIndex) {
		if (mUnlockedAbility[pAbilityIndex])
			return true;
		else
			return false;
	}

	// Use Potion to add health/resource or revive players
	// Returns a boolean if the item was used successfully
	public boolean useItem(Potion pPotion) {

		switch (pPotion.getPotionID()) {
		case MINOR_HEALTH_POTION:
		case MAJOR_HEALTH_POTION:
		case SUPERIOR_HEALTH_POTION:

			// Check to make sure character isn't at full health
			if (mCurrentResources.getHealth() < mMaxResources.getHealth()) {
				// currentHealth = currentHealth + maxHealth * AmountRestored(%
				// of max health)
				mCurrentResources.setHealth((int) (mCurrentResources
						.getHealth() + mMaxResources.getHealth()
						* pPotion.getAmountRestored()));

				// Double check currentHealt doesn't exced maxHealth
				if (mCurrentResources.getHealth() < mMaxResources.getHealth()) {
					// If it does then set currentHealth to maxHealth
					mCurrentResources.setHealth(mMaxResources.getHealth());
				}

				return true;
			} else
				return false;
		case MINOR_RESOURCE_POTION:
		case MAJOR_RESOURCE_POTION:
		case SUPERIOR_RESOURCE_POTION:

			// Check to make sure character isn't at full Resource
			if (mCurrentResources.getResource() < mMaxResources.getResource()) {
				// currentResource = currentResource + maxResource *
				// AmountRestored(% of maxResource)
				mCurrentResources.setResource((int) (mCurrentResources
						.getResource() + mMaxResources.getResource()
						* pPotion.getAmountRestored()));

				// Double check currentResource doesn't exced maxResource
				if (mCurrentResources.getResource() < mMaxResources
						.getResource()) {
					// If it does then set currentResource to maxResource
					mCurrentResources.setResource(mMaxResources.getResource());
				}

				return true;
			} else
				return false;

		case ANTIDOTE_POTION:
			// TODO send it to battle System

		case BASIC_REVIVE_POTION:
		case FULL_REVIVE_POTION:

			// Character must be dead to use revive
			if (isDead()) {

				// currentHealth = maxHealth * AmountRestored(% of max health) :
				// 50 or 100%
				mCurrentResources
						.setHealth((int) (mMaxResources.getHealth() * pPotion
								.getAmountRestored()));

				// currentResource = maxResource * AmountRestored(% of
				// maxResource) : 50 or 100%
				mCurrentResources.setResource((int) (mMaxResources
						.getResource() * pPotion.getAmountRestored()));

				return true;
			} else
				return false;
		}

		return true;

	}

	// Compare haste to determine turn order
	public boolean compareHasteToEnemy(Enemy pEnemy) {
		// A false turn decision means the enemy goes first
		// A true turn decision means the player goes first
		boolean turnDecision = false;

		switch (pEnemy.getHaste()) {
		case HASTE_TYPE_FAST:
			// Enemy goes first
			turnDecision = false;

			break;
		case HASTE_TYPE_NORMAL:
			// Randomly pick a turn decision in the range
			int randomNumber = RandomNumber.generateRandomInt(1, 10);

			if (randomNumber <= 5) {
				// Player goes first
				turnDecision = true;
			} else if (randomNumber >= 6) {
				// Enemy goes first
				turnDecision = false;
			}

			break;
		case HASTE_TYPE_SLOW:
			// Player goes first
			turnDecision = true;

			break;
		}

		return turnDecision;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}