package dragonsreign.character;

import java.util.ArrayList;

import org.andengine.entity.sprite.Sprite;

import dragonsreign.character.characterclass.ClericClass;
import dragonsreign.character.characterclass.RangerClass;
import dragonsreign.character.characterclass.WarriorClass;
import dragonsreign.item.Item;
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
	protected String[] mAbility;
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

	public String[] getAbility() {
		return mAbility;
	}

	public void setAbility(String[] pAbility) {
		this.mAbility = pAbility;
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

	public abstract void equipItem(/* Item pEquipItem */);

	public abstract void useAbility(int pAbilityIndex);

	// ===========================================================
	// Methods
	// ===========================================================

	public void updateCurrentStats() {
		mCurrentStats.setStrength(this.getCurrentStats().getStrength()
				+ mItemStats.getStrength());
		mCurrentStats.setDexterity(this.getCurrentStats().getDexterity()
				+ mItemStats.getDexterity());
		mCurrentStats.setIntelligence(this.getCurrentStats().getIntelligence()
				+ mItemStats.getIntelligence());
		mCurrentStats.setVitality(this.getCurrentStats().getVitality()
				+ mItemStats.getVitality());
		mCurrentStats.setDamage(this.getCurrentStats().getDamage()
				+ mItemStats.getDamage());
		mCurrentStats.setArmor(this.getCurrentStats().getArmor()
				+ mItemStats.getArmor());
	}

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