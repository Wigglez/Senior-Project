/*
 * 
 */
package dragonsreign.character.characterclass;

import dragonsreign.character.PlayerCharacter;
import dragonsreign.util.BattleEffects;

// TODO: Auto-generated Javadoc
/**
 * The Class Warrior.
 */
public class WarriorClass extends PlayerCharacter {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m current skill points. */
	protected int mCurrentSkillPoints;

	// Ability levels
	/** The m cleave level. */
	protected int mCleaveLevel;

	/** The m lunge level. */
	protected int mLungeLevel;

	/** The m execute level. */
	protected int mExecuteLevel;

	/** The m rend level. */
	protected int mRendLevel;

	/** The m war cry level. */
	protected int mWarCryLevel;

	// Ability costs

	/** The m cleave cost. */
	protected int mCleaveCost;

	/** The m lunge cost. */
	protected int mLungeCost;

	/** The m execute cost. */
	protected int mExecuteCost;

	/** The m rend cost. */
	protected int mRendCost;

	/** The m war cry cost. */
	protected int mWarCryCost;

	/** The m apply battle effect. */
	protected BattleEffects mApplyBattleEffect;

	// H_Helm Helm;
	// H_Upper upper;
	// H_Lower lower;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new warrior.
	 */
	public WarriorClass() {
		// TODO
		// set base stats, stamina for warrior
		// loadWarriorSprite

		mBaseStats.setStrength(9);
		mBaseStats.setDexterity(2);
		mBaseStats.setIntelligence(2);
		mBaseStats.setVitality(7);
		mBaseStats.setDamage(0);
		mBaseStats.setArmor(0);
		
		//mCurrentStats.setStrength(mBaseStats.getStrength());
		//mCurrentStats.setDexterity(mBaseStats.getDexterity());
		//mCurrentStats.setIntelligence(mBaseStats.getIntelligence());
		//mCurrentStats.setVitality(mBaseStats.getVitality());
		//mCurrentStats.setDamage(mBaseStats.getDamage());
		//mCurrentStats.setArmor(mBaseStats.getArmor());

		//mBaseResources.setHealth(10 * mCurrentStats.getVitality());
		//mBaseResources.setResource(100);
		
		//mCurrentResources.setHealth(mBaseResources.getHealth());
		//mCurrentResources.setResource(mBaseResources.getResource());
		
		//mCurrentStamina = mCurrentResources.getResource();

		mAbility[0] = "Attack";
		mAbility[1] = "Cleave";
		mAbility[2] = "Lunge";
		mAbility[3] = "Execute";
		mAbility[4] = "Rend";
		mAbility[5] = "War Cry";

		for (int abilityCount = 0; abilityCount < 6; abilityCount++) {
			mUnlockedAbility[abilityCount] = false;
		}

		// mCurrentSkillPoints = this.getSkillPoints();

		// Ability levels

		mCleaveLevel = 0;
		mLungeLevel = 0;
		mExecuteLevel = 0;
		mRendLevel = 0;
		mWarCryLevel = 0;

		// Ability costs
		mCleaveCost = 0;
		mLungeCost = 0;
		mExecuteCost = 0;
		mRendCost = 0;
		mWarCryCost = 0;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see dragonsreign.character.PlayerCharacter#levelUp()
	 */
	@Override
	public void levelUp() {
		// TODO Auto-generated method stub

		// Figure levels that you learn abilities
		// Determine increment of base stats
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dragonsreign.character.PlayerCharacter#EquipItem()
	 */
	/**
	 * Equip item.
	 */
	@Override
	public void equipItem() {
		// TODO Auto-generated method stub

		// Create item/gear classes
		// on equip alter gearStats, sum of gear pieces
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dragonsreign.character.PlayerCharacter#useAbility(int)
	 */
	@Override
	public void useAbility(int abilityIdx) {
		// TODO Auto-generated method stub

	}

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Load character.
	 * 
	 * @param pLevel
	 *            the level
	 * @param pCurrentExperience
	 *            the current experience
	 */
	public void LoadCharacter(int pLevel, int pCurrentExperience /*
																 * helm, upper,
																 * lower
																 */) {
		// equip gear

		for (int currentLvl = 1; currentLvl <= pLevel; currentLvl++) {
			levelUp();
		}
	}

	/**
	 * Basic attack.
	 */
	public void BasicAttack() {
		// weapon dmg

	}

	/**
	 * Cleave.
	 */
	public void Cleave() {
		if (mCurrentStamina > mCleaveCost) {
			// do stuff
			if (mCleaveLevel == 1) {
				// attacks all enemies for 40% base dmg
			} else if (mCleaveLevel == 2) {
				// attacks all enemies for 60% base dmg
			} else if (mCleaveLevel == 3) {
				// attacks all enemies for 75% base dmg
			}

			mCurrentStamina -= mCleaveCost;
		}

	}

	/**
	 * Lunge.
	 */
	public void Lunge() {
		if (mCurrentStamina > mLungeCost) {
			if (mLungeLevel == 1) {
				// attacks selected enemy target and stuns
				mApplyBattleEffect.setStunned(true);
				mApplyBattleEffect.setStunTurns(2);
			} else if (mLungeLevel == 2) {
				// attacks selected enemy target and stuns
				mApplyBattleEffect.setStunned(true);
				mApplyBattleEffect.setStunTurns(2);
			} else if (mLungeLevel == 3) {
				// attacks selected enemy target and stuns
				mApplyBattleEffect.setStunned(true);
				mApplyBattleEffect.setStunTurns(2);
			}

			mCurrentStamina -= mLungeCost;

		}
	}

	/**
	 * Execute.
	 */
	public void Execute() {
		if (mCurrentStamina > mExecuteCost) {
			// do stuff
			if (mExecuteLevel == 1) {
				// Completely drains stamina increased dmg based on amount of
				// stamina drained
			} else if (mExecuteLevel == 2) {
				// Completely drains stamina increased dmg based on amount of
				// stamina drained
			} else if (mExecuteLevel == 3) {
				// Completely drains stamina increased dmg based on amount of
				// stamina drained
			}

			mCurrentStamina -= mExecuteCost;
		}
	}

	/**
	 * Rend.
	 */
	public void Rend() {
		if (mCurrentStamina > mRendCost) {
			if (mRendLevel == 1) {
				// bleeds the target for 100% weapon dmg over 3 turns
				mApplyBattleEffect.setBleeding(true);
				mApplyBattleEffect.setBleedDamage(1.0f * this.getCurrentStats()
						.getDamage());
				mApplyBattleEffect.setBleedTurns(3);
			} else if (mRendLevel == 2) {
				// bleeds the target for 125% weapon dmg over 3 turns
				mApplyBattleEffect.setBleeding(true);
				mApplyBattleEffect.setBleedDamage(1.25f * this
						.getCurrentStats().getDamage());
				mApplyBattleEffect.setBleedTurns(3);
			} else if (mRendLevel == 3) {
				// bleeds the target for 150% weapon dmg over 3 turns
				mApplyBattleEffect.setBleeding(true);
				mApplyBattleEffect.setBleedDamage(1.5f * this.getCurrentStats()
						.getDamage());
				mApplyBattleEffect.setBleedTurns(3);
			}

			mCurrentStamina -= mRendCost;
		}

	}

	/**
	 * War cry.
	 */
	public void WarCry() {
		if (mCurrentStamina > mWarCryCost) {
			if (mWarCryLevel == 1) {
				// increase party dmg by 15% depletes 50% stamina
			} else if (mWarCryLevel == 2) {
				// increase party dmg by 20% depletes 50% stamina
			} else if (mWarCryLevel == 3) {
				// increase party dmg by 30% depletes 50% stamina
			}

			mCurrentStamina -= mWarCryCost;
		}

	}

	/**
	 * Level up_ cleave.
	 */
	public void LevelUp_Cleave() {
		if (mCurrentSkillPoints > 0) {

			mCleaveLevel += 1;

		}

	}

	/**
	 * Level up_ lunge.
	 */
	public void LevelUp_Lunge() {
		if (mCurrentSkillPoints > 0) {

			mLungeLevel += 1;

		}
	}

	/**
	 * Level up_ execute.
	 */
	public void LevelUp_Execute() {
		if (mCurrentSkillPoints > 0) {

			mExecuteLevel += 1;

		}

	}

	/**
	 * Level up_ rend.
	 */
	public void LevelUp_Rend() {
		if (mCurrentSkillPoints > 0) {

			mRendLevel += 1;

		}

	}

	/**
	 * Level up_ war cry.
	 */
	public void LevelUp_WarCry() {
		if (mCurrentSkillPoints > 0) {

			mWarCryLevel += 1;

		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
