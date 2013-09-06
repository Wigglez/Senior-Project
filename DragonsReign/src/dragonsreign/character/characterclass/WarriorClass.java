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

	protected int mCurrentSkillPoints;

	// Ability levels
	protected int mCleaveLevel;
	protected int mLungeLevel;
	protected int mExecuteLevel;
	protected int mRendLevel;
	protected int mWarCryLevel;

	// Ability costs
	protected int mCleaveCost;
	protected int mLungeCost;
	protected int mExecuteCost;
	protected int mRendCost;
	protected int mWarCryCost;

	protected BattleEffects mBattleEffects;

	// H_Helm Helm;
	// H_Upper upper;
	// H_Lower lower;

	// ===========================================================
	// Constructors
	// ===========================================================

	public WarriorClass() {
		// TODO
		// set base stats, stamina for warrior
		// loadWarriorSprite

		// Our ID is 0 since we are a warrior

		mBaseStats.setStrength(9);
		mBaseStats.setDexterity(2);
		mBaseStats.setIntelligence(2);
		mBaseStats.setVitality(7);
		mBaseStats.setDamage(0);
		mBaseStats.setArmor(0);

		mCurrentStats.setStrength(mBaseStats.getStrength());
		mCurrentStats.setDexterity(mBaseStats.getDexterity());
		mCurrentStats.setIntelligence(mBaseStats.getIntelligence());
		mCurrentStats.setVitality(mBaseStats.getVitality());
		mCurrentStats.setDamage(mBaseStats.getDamage());
		mCurrentStats.setArmor(mBaseStats.getArmor());

		mBaseResources.setHealth(10 * mCurrentStats.getVitality());
		mBaseResources.setResource(100);

		mCurrentResources.setHealth(mBaseResources.getHealth());
		mCurrentResources.setResource(mBaseResources.getResource());

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

	@Override
	public void levelUp() {
		// Figure levels that you learn abilities
		// Determine increment of base stats
	}

	@Override
	public void equipItem() {
		// Create item/gear classes
		// on equip alter gearStats, sum of gear pieces
	}

	@Override
	public void useAbility(int pAbilityIdx) {
		switch (pAbilityIdx) {
		case 0:
			BasicAttack();
			break;
		case 1:
			Cleave();
			break;
		case 2:
			Lunge();
			break;
		case 3:
			Execute();
			break;
		case 4:
			Rend();
			break;
		case 5:
			WarCry();
			break;
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	public void LoadCharacter(int pLevel, int pCurrentExperience /*
																 * helm, upper,
																 * lower
																 */) {
		// equip gear

		for (int currentLvl = 1; currentLvl <= pLevel; currentLvl++) {
			levelUp();
		}
	}

	public void BasicAttack() {
		// weapon dmg
		mCurrentStats.getDamage();
	}

	public void Cleave() {
		if (this.getCurrentResources().getResource() > mCleaveCost) {
			// do stuff
			if (mCleaveLevel == 1) {
				// attacks all enemies for 40% base dmg
			} else if (mCleaveLevel == 2) {
				// attacks all enemies for 60% base dmg
			} else if (mCleaveLevel == 3) {
				// attacks all enemies for 75% base dmg
			}

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mCleaveCost);
		}
	}

	public void Lunge() {
		if (mCurrentResources.getResource() > mLungeCost) {
			if (mLungeLevel == 1) {
				// attacks selected enemy target and stuns
				mBattleEffects.setStunned(true);
				mBattleEffects.setStunTurns(2);
			} else if (mLungeLevel == 2) {
				// attacks selected enemy target and stuns
				mBattleEffects.setStunned(true);
				mBattleEffects.setStunTurns(2);
			} else if (mLungeLevel == 3) {
				// attacks selected enemy target and stuns
				mBattleEffects.setStunned(true);
				mBattleEffects.setStunTurns(2);
			}

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mLungeCost);
		}
	}

	public void Execute() {
		if (mCurrentResources.getResource() > mExecuteCost) {
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

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mExecuteCost);
		}
	}

	public void Rend() {
		if (mCurrentResources.getResource() > mRendCost) {
			if (mRendLevel == 1) {
				// bleeds the target for 100% weapon dmg over 3 turns
				mBattleEffects.setBleeding(true);
				mBattleEffects.setBleedDamage(1.0f * this.getCurrentStats()
						.getDamage());
				mBattleEffects.setBleedTurns(3);
			} else if (mRendLevel == 2) {
				// bleeds the target for 125% weapon dmg over 3 turns
				mBattleEffects.setBleeding(true);
				mBattleEffects.setBleedDamage(1.25f * this.getCurrentStats()
						.getDamage());
				mBattleEffects.setBleedTurns(3);
			} else if (mRendLevel == 3) {
				// bleeds the target for 150% weapon dmg over 3 turns
				mBattleEffects.setBleeding(true);
				mBattleEffects.setBleedDamage(1.5f * this.getCurrentStats()
						.getDamage());
				mBattleEffects.setBleedTurns(3);
			}

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mRendCost);
		}
	}

	public void WarCry() {
		if (mCurrentResources.getResource() > mWarCryCost) {
			if (mWarCryLevel == 1) {
				// increase party dmg by 15% depletes 50% stamina
			} else if (mWarCryLevel == 2) {
				// increase party dmg by 20% depletes 50% stamina
			} else if (mWarCryLevel == 3) {
				// increase party dmg by 30% depletes 50% stamina
			}

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mWarCryCost);
		}

	}

	public void LevelUp_Cleave() {
		if (mCurrentSkillPoints > 0) {

			mCleaveLevel += 1;

			mCurrentSkillPoints -= 1;
		}
	}

	public void LevelUp_Lunge() {
		if (mCurrentSkillPoints > 0) {

			mLungeLevel += 1;

			mCurrentSkillPoints -= 1;
		}
	}

	public void LevelUp_Execute() {
		if (mCurrentSkillPoints > 0) {

			mExecuteLevel += 1;

			mCurrentSkillPoints -= 1;
		}
	}

	public void LevelUp_Rend() {
		if (mCurrentSkillPoints > 0) {

			mRendLevel += 1;

			mCurrentSkillPoints -= 1;
		}
	}

	public void LevelUp_WarCry() {
		if (mCurrentSkillPoints > 0) {

			mWarCryLevel += 1;

			mCurrentSkillPoints -= 1;
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
