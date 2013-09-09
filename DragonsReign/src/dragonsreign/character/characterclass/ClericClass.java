/*
 * 
 */
package dragonsreign.character.characterclass;
import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Gear;

public class ClericClass extends PlayerCharacter {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mCurrentMana;
	
	protected int mHealLifeSyphonLevel;
	protected int mReviveLevel;
	protected int mHealingChantLevel;
	protected int mEmpowerLevel;
	protected int mMendLevel;
	
	protected int mHealLifeSyphonCost;
	protected int mReviveCost;
	protected int mHealingChantCost;
	protected int mEmpowerCost;
	protected int mMendCost;
	
	protected int mCurrentSkillPoints;

	// L_Helm Helm;
	// L_Upper upper;
	// L_Lower lower;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ClericClass() {
		// TODO
		// set base stats, mana for cleric
		// loadClericSprite
		
		// level up - 1 dex, 2 vita, 3 int, 1 str

		mBaseStats.setStrength(2);
		mBaseStats.setDexterity(2);
		mBaseStats.setIntelligence(9);
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
		mAbility[1] = "Heal/Life Syphon";
		mAbility[2] = "Revive";
		mAbility[3] = "Healing Chant";
		mAbility[4] = "Empower";
		mAbility[5] = "Mend";

		for (int abltyCntr = 0; abltyCntr < 6; abltyCntr++) {
			mUnlockedAbility[abltyCntr] = false;
		}

		mCurrentSkillPoints = this.getSkillPoints();

		mHealLifeSyphonLevel = 0;
		mHealLifeSyphonCost = 0;

		mReviveLevel = 0;
		mReviveCost = 0;

		mHealingChantLevel = 0;
		mHealingChantCost = 0;

		mEmpowerLevel = 0;
		mEmpowerCost = 0;

		mMendLevel = 0;
		mMendCost = 0;

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
	public void equipItem(Gear pGearPiece) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dragonsreign.character.PlayerCharacter#useAbility(int)
	 */
	@Override
	public void useAbility(int pAbilityIndex) {
		// TODO Auto-generated method stub

	}

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Load character.
	 * 
	 * @param Lvl
	 *            the lvl
	 * @param CurrentXp
	 *            the current xp
	 */
	public void LoadCharacter(int Lvl, int CurrentXp /* helm, upper, lower */) {
		// equip gear

		for (int curLvl = 1; curLvl <= Lvl; curLvl++) {
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
	 * Heal life syphon.
	 */
	public void HealLifeSyphon() {
		if (mCurrentMana > mHealLifeSyphonCost) {
			// do stuff
			if (mHealLifeSyphonLevel == 1) {
				// if enemy targeted siphon life heals cleric for 50% of the dmg
				// done
				// else if friendly target heal
			} else if (mHealLifeSyphonLevel == 2) {
				// if enemy targeted siphon life heals cleric for 50% of the dmg
				// done
				// else if friendly target heal
			} else if (mHealLifeSyphonLevel == 3) {
				// if enemy targeted siphon life heals cleric for 50% of the dmg
				// done
				// else if friendly target heal
			}

			mCurrentMana -= mHealLifeSyphonCost;
		}

	}

	/**
	 * Revive.
	 */
	public void Revive() {
		if (mCurrentMana > mReviveCost) {
			// revive
			if (mReviveLevel == 1) {
				// revive targeted party member
			} else if (mReviveLevel == 2) {
				// revive targeted party member
			} else if (mReviveLevel == 3) {
				// revive targeted party member
			}

			mCurrentMana -= mReviveCost;
		}
	}

	/**
	 * Healing chant.
	 */
	public void HealingChant() {
		if (mCurrentMana > mHealingChantCost) {

			if (mHealingChantLevel == 1) {
				// charges the spell for one turn then after the turn has
				// elapsed heals entire party
				// costs substantial mana
			} else if (mHealingChantLevel == 2) {
				// charges the spell for one turn then after the turn has
				// elapsed heals entire party
				// costs substantial mana
			} else if (mHealingChantLevel == 3) {
				// charges the spell for one turn then after the turn has
				// elapsed heals entire party
				// costs substantial mana
			}

			mCurrentMana -= mHealingChantCost;
		}

	}

	/**
	 * Empower.
	 */
	public void Empower() {
		if (mCurrentMana > mEmpowerCost) {

			if (mEmpowerLevel == 1) {
				// boost to all primary stats of entire party
			} else if (mEmpowerLevel == 2) {
				// boost to all primary stats of entire party
			} else if (mEmpowerLevel == 3) {
				// boost to all primary stats of entire party
			}

			mCurrentMana -= mEmpowerCost;
		}
	}

	/**
	 * Mend.
	 */
	public void Mend() {
		if (mCurrentMana > mMendCost) {

			if (mMendLevel == 1) {
				// heals targeted party member gradually over time
			} else if (mMendLevel == 2) {
				// heals targeted party member gradually over time
			} else if (mMendLevel == 3) {
				// heals targeted party member gradually over time
			}

			mCurrentMana -= mMendCost;
		}
	}

	/**
	 * Level up_ heal life syphon.
	 */
	public void LevelUp_HealLifeSyphon() {
		if (mCurrentSkillPoints > 0) {

			mHealLifeSyphonLevel += 1;
			// increase cost of skill
		}

	}

	/**
	 * Level up_ revive.
	 */
	public void LevelUp_Revive() {
		if (mCurrentSkillPoints > 0) {

			mReviveLevel += 1;
			// increase cost of skill
		}
	}

	/**
	 * Level up_ healing chant.
	 */
	public void LevelUp_HealingChant() {
		if (mCurrentSkillPoints > 0) {

			mHealingChantLevel += 1;
			// increase cost of skill
		}
	}

	/**
	 * Level up_ empower.
	 */
	public void LevelUp_Empower() {
		if (mCurrentSkillPoints > 0) {

			mEmpowerLevel += 1;
			// increase cost of skill
		}
	}

	/**
	 * Level up_ mend.
	 */
	public void LevelUp_Mend() {
		if (mCurrentSkillPoints > 0) {

			mMendLevel += 1;
			// increase cost of skill
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
