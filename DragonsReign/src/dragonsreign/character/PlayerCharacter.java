package dragonsreign.character;

import java.io.File;
import java.util.ArrayList;

import org.andengine.entity.sprite.Sprite;

import dragonsreign.item.Item;

public abstract class PlayerCharacter extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// All defined jobs are available in the jobs directory
	@SuppressWarnings("serial")
	public static final ArrayList<String> AVAILABLEJOBS = new ArrayList<String>() {
		{
			for(String s : new File("data/characters/jobs").list()) {
				if(new File("data/characters/jobs/" + s + "/jobs.xml").exists()) {
					this.add(s);
				}
			}
		}
	};
	
	// ===========================================================
	// Fields
	// ===========================================================

	// Job
	protected String mJobName;
	
	// Sprites
	protected Sprite mBattleSprite;
	protected Sprite mPortraitSprite;

	// Experience
	protected int mCurrentExperience;

	protected int mSkillPoints;

	protected int mAbilityLevel;
	protected int mAbilityCost;
	protected String[] mAbility;
	protected boolean[] mUnlockedAbility;

	// Items
	protected ArrayList<Item> mEquippedItems = new ArrayList<Item>();

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

	// Sprites
	public Sprite getBattleSprite() {
		return mBattleSprite;
	}

	public void setBattleSprite(Sprite pBattleSprite) {
		this.mBattleSprite = pBattleSprite;
	}

	public Sprite getPortraitSprite() {
		return mPortraitSprite;
	}

	public void setPortraitSprite(Sprite pPortraitSprite) {
		this.mPortraitSprite = pPortraitSprite;
	}

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

	public void loadJob(String pJobName) {
		mJobName = pJobName;
		
		if(mLevel == 1) {
			try {
				if(mJobName == "warrior") {
					
				} else if(mJobName == "ranger") {
					
				} else if(mJobName == "cleric") {
					
				} 
			} catch(Exception e) {
				System.err.println("Cannot find file: " + "data/characters/jobs/" + mJobName + "Job.xml" + "\n" + "Job not loaded.");
			}
		}
	}
	
	/*
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
	} */

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