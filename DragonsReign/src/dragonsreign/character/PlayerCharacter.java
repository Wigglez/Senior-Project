package dragonsreign.character;

import java.util.ArrayList;

import org.andengine.opengl.texture.region.ITextureRegion;

import android.util.Log;

import dragonsreign.item.Gear;
import dragonsreign.item.Item;
import dragonsreign.item.consumable.Potion;
import dragonsreign.util.RandomNumber;
import dragonsreign.util.Stats;

/*
 * Flee Calc:
 * 
 * Top right (battle scene) enemy level above character by 1 level - 25% chance to flee
 * Top right (battle scene) enemy level same as character level - 50% chance to flee
 * Top right (battle scene) enemy level below character by 1 - 75% chance to flee
 */
public abstract class PlayerCharacter extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	//Portrait
	protected ITextureRegion mPortrait;
	// Experience
	protected int mCurrentExperience;
	protected int mExperienceToNextLevel;

	protected int mSkillPoints;

	protected int mAbilityLevel;
	protected int mAbilityCost;
	protected boolean[] mUnlockedAbility;

	// Items
	protected ArrayList<Gear> mEquipmentSlots = new ArrayList<Gear>();
	protected Stats mItemStats;

	protected Gear helmet;
	protected Gear chestArmor;
	protected Gear legArmor;
	protected Gear weaponHand1;
	protected Gear weaponHand2;
	protected Gear jewelry;

	// ===========================================================
	// Constructors
	// ===========================================================

	public PlayerCharacter() {
		
		mUnlockedAbility = new boolean[6];
		
		mBaseStats = new Stats();
		mItemStats = new Stats();
		
		// helmet = 0
		// chestarmor = 1
		// leg armor = 2
		// weaponhand1 = 3
		// weaponhand2 = 4
		// jewelry = 5
		mEquipmentSlots.add(helmet);
		mEquipmentSlots.add(chestArmor);
		mEquipmentSlots.add(legArmor);
		mEquipmentSlots.add(weaponHand1);
		mEquipmentSlots.add(weaponHand2);
		mEquipmentSlots.add(jewelry);
		
		Log.e("Equipment slots", mEquipmentSlots.toString());
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public ArrayList<Gear> getEquipmentSlots() {
		  return mEquipmentSlots;
	}
	
	public ITextureRegion getPortrait(){
		return mPortrait;
	}
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

	public abstract boolean equipItem(Gear pGearPiece, Gear[] returnItem);

	// ===========================================================
	// Methods
	// ===========================================================

	public void LoadCharacter(int pLevel, int pCurrentExperience, Gear pHelmet,
			Gear pChestPlate, Gear pLegArmor, Gear pWeapon1, Gear pWeapon2) {
		
		mCurrentExperience = pCurrentExperience;			

		for (int currentLvl = 2; currentLvl <= pLevel; currentLvl++) {
			mCurrentExperience += mLevel * 68; 
		}
		
		//Reach level based on experience
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

		mItemStats.setStrength(0);
		mItemStats.setDexterity(0);
		mItemStats.setIntelligence(0);
		mItemStats.setVitality(0);
		mItemStats.setDamage(0);
		mItemStats.setArmor(0);
		
		// Only add helmet stats if you have something equipped
		if (helmet != null) {
			mItemStats.setStrength(mItemStats.getStrength()
					+ helmet.getItemStats().getStrength());

			mItemStats.setDexterity(mItemStats.getDexterity()
					+ helmet.getItemStats().getDexterity());

			mItemStats.setIntelligence(mItemStats.getIntelligence()
					+ helmet.getItemStats().getIntelligence());

			mItemStats.setVitality(mItemStats.getVitality()
					+ helmet.getItemStats().getVitality());

			mItemStats.setDamage(mItemStats.getDamage()
					+ helmet.getItemStats().getDamage());

			mItemStats.setArmor(mItemStats.getArmor()
					+ helmet.getItemStats().getArmor());
		}
		
		// Only add chestArmor stats if you have something equipped
		if (chestArmor != null) {
			mItemStats.setStrength(mItemStats.getStrength()
					+ chestArmor.getItemStats().getStrength());

			mItemStats.setDexterity(mItemStats.getDexterity()
					+ chestArmor.getItemStats().getDexterity());

			mItemStats.setIntelligence(mItemStats.getIntelligence()
					+ chestArmor.getItemStats().getIntelligence());

			mItemStats.setVitality(mItemStats.getVitality()
					+ chestArmor.getItemStats().getVitality());

			mItemStats.setDamage(mItemStats.getDamage()
					+ chestArmor.getItemStats().getDamage());

			mItemStats.setArmor(mItemStats.getArmor()
					+ chestArmor.getItemStats().getArmor());
		}
		
		// Only add legArmor stats if you have something equipped
		if (legArmor != null) {
			mItemStats.setStrength(mItemStats.getStrength()
					+ legArmor.getItemStats().getStrength());

			mItemStats.setDexterity(mItemStats.getDexterity()
					+ legArmor.getItemStats().getDexterity());

			mItemStats.setIntelligence(mItemStats.getIntelligence()
					+ legArmor.getItemStats().getIntelligence());

			mItemStats.setVitality(mItemStats.getVitality()
					+ legArmor.getItemStats().getVitality());

			mItemStats.setDamage(mItemStats.getDamage()
					+ legArmor.getItemStats().getDamage());

			mItemStats.setArmor(mItemStats.getArmor()
					+ legArmor.getItemStats().getArmor());
		}
		
		// Only add jewelry stats if you have something equipped
		if (jewelry != null) {
			mItemStats.setStrength(mItemStats.getStrength()
					+ jewelry.getItemStats().getStrength());

			mItemStats.setDexterity(mItemStats.getDexterity()
					+ jewelry.getItemStats().getDexterity());

			mItemStats.setIntelligence(mItemStats.getIntelligence()
					+ jewelry.getItemStats().getIntelligence());

			mItemStats.setVitality(mItemStats.getVitality()
					+ jewelry.getItemStats().getVitality());

			mItemStats.setDamage(mItemStats.getDamage()
					+ jewelry.getItemStats().getDamage());

			mItemStats.setArmor(mItemStats.getArmor()
					+ jewelry.getItemStats().getArmor());
		}
		
		// Only add weaponHand1 stats if you have something equipped
		if(weaponHand1 != null) {
			mItemStats.setStrength(mItemStats.getStrength()
					+ weaponHand1.getItemStats().getStrength());

			mItemStats.setDexterity(mItemStats.getDexterity()
					+ weaponHand1.getItemStats().getDexterity());

			mItemStats.setIntelligence(mItemStats.getIntelligence()
					+ weaponHand1.getItemStats().getIntelligence());

			mItemStats.setVitality(mItemStats.getVitality()
					+ weaponHand1.getItemStats().getVitality());

			mItemStats.setDamage(mItemStats.getDamage()
					+ weaponHand1.getItemStats().getDamage());

			mItemStats.setArmor(mItemStats.getArmor()
					+ weaponHand1.getItemStats().getArmor());
		}

		// Only add weaponHand2 stats if you have something equipped
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