/*
 * 
 */
package dragonsreign.character.characterclass;

import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Gear;
import dragonsreign.util.AbilityData;

// TODO: Auto-generated Javadoc
/**
 * The Class Ranger.
 */
public class RangerClass extends PlayerCharacter {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mCurrentEnergy;

	protected int mCurrentSkillPoints;

	protected int mFireArrowLevel;
	protected int mPoisonArrowLevel;
	protected int mSpreadShotLevel;
	protected int mChargedShotLevel;
	protected int mStunArrowLevel;

	protected int mFireArrowCost;
	protected int mPoisonArrowCost;
	protected int mSpreadShotCost;
	protected int mChargedShotCost;
	protected int mStunArrowCost;

	// M_Helm Helm;
	// M_Upper upper;
	// M_Lower lower;

	// ===========================================================
	// Constructors
	// ===========================================================

	public RangerClass() {
		// TODO
		// set base stats, energy for ranger
		// loadRangerSprite
		
		// level up - 3 dex, 2 vita, 1 int, 1 str

		mBaseStats.setStrength(2);
		mBaseStats.setDexterity(9);
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
		
		// mCurrentEnergy = this.getCurrentResources().getEnergy();

		mAbility[0] = "Attack";
		mAbility[1] = "Fire Arrow";
		mAbility[2] = "Poison Arrow";
		mAbility[3] = "Spread Shot";
		mAbility[4] = "Charged Shot";
		mAbility[5] = "Stun Arrow";

		for (int abilityCount = 0; abilityCount < 6; abilityCount++) {
			mUnlockedAbility[abilityCount] = false;
		}

		mCurrentSkillPoints = this.getSkillPoints();

		// Ability levels

		mFireArrowLevel = 0;
		mFireArrowLevel = 0;
		mSpreadShotLevel = 0;
		mChargedShotLevel = 0;
		mStunArrowLevel = 0;

		// Ability costs

		mFireArrowCost = 0;
		mPoisonArrowCost = 0;
		mSpreadShotCost = 0;
		mChargedShotCost = 0;
		mStunArrowCost = 0;
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

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dragonsreign.character.PlayerCharacter#equipItem()
	 */
	@Override
	public boolean equipItem(Gear pGearPiece) {
		return false;
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dragonsreign.character.PlayerCharacter#useAbility(int)
	 */
	@Override
	public void useAbility(int pAbilityIndex, AbilityData pAbilityData) {
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
	 * Fire arrow.
	 */
	public void FireArrow() {
		if (mCurrentEnergy > mFireArrowCost) {
			// do stuff
			if (mFireArrowLevel == 1) {
				// less base dmg then basic attack has chance to apply burn
			} else if (mFireArrowLevel == 2) {

			} else if (mFireArrowLevel == 3) {

			}

			mCurrentEnergy -= mFireArrowCost;
		}

	}

	/**
	 * Poison arrow.
	 */
	public void PoisonArrow() {
		if (mCurrentEnergy > mPoisonArrowCost) {
			// poisonArrow
			if (mPoisonArrowLevel == 1) {
				// less base dmg then basic attack has chance to apply poison
			} else if (mPoisonArrowLevel == 2) {

			} else if (mPoisonArrowLevel == 3) {

			}

			mCurrentEnergy -= mPoisonArrowCost;
		}
	}

	/**
	 * Spread shot.
	 */
	void SpreadShot() {
		if (mCurrentEnergy > mSpreadShotCost) {

			if (mSpreadShotLevel == 1) {
				// attacks all enemies for 75% base dmg
			} else if (mSpreadShotLevel == 2) {

			} else if (mSpreadShotLevel == 3) {

			}

			mCurrentEnergy -= mSpreadShotCost;
		}

	}

	/**
	 * Charged shot.
	 */
	void ChargedShot() {
		if (mCurrentEnergy > mChargedShotCost) {

			if (mChargedShotLevel == 1) {
				// charges for one turn and has a chance to deal 2-5 times dmg
			} else if (mChargedShotLevel == 2) {

			} else if (mChargedShotLevel == 3) {

			}

			mCurrentEnergy -= mChargedShotCost;
		}
	}

	/**
	 * Stun arrow.
	 */
	void StunArrow() {
		if (mCurrentEnergy > mStunArrowCost) {

			if (mStunArrowLevel == 1) {
				// no initial dmg chance to stun
			} else if (mStunArrowLevel == 2) {

			} else if (mStunArrowLevel == 3) {

			}

			mCurrentEnergy -= mStunArrowCost;
		}
	}

	/**
	 * Level up_ fire arrow.
	 */
	void LevelUp_FireArrow() {
		if (mCurrentSkillPoints > 0) {

			mFireArrowLevel += 1;
			// increase cost of skill
		}

	}

	/**
	 * Level up_ poison arrow.
	 */
	void LevelUp_PoisonArrow() {
		if (mCurrentSkillPoints > 0) {

			mFireArrowLevel += 1;
			// increase cost of skill
		}
	}

	/**
	 * Level up_ spread shot.
	 */
	void LevelUp_SpreadShot() {
		if (mCurrentSkillPoints > 0) {

			mSpreadShotLevel += 1;
			// increase cost of skill
		}
	}

	/**
	 * Level up_ charged shot.
	 */
	void LevelUp_ChargedShot() {
		if (mCurrentSkillPoints > 0) {

			mChargedShotLevel += 1;
			// increase cost of skill
		}
	}

	/**
	 * Level up_ stun arrow.
	 */
	void LevelUp_StunArrow() {
		if (mCurrentSkillPoints > 0) {

			mStunArrowLevel += 1;
			// increase cost of skill
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
