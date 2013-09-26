package dragonsreign.character.characterclass;

import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Gear;
import dragonsreign.util.AbilityData;
import dragonsreign.util.RandomNumber;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.ITEMTYPE;

public class RangerClass extends PlayerCharacter {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// protected int mCurrentEnergy;

	protected int mCurrentSkillPoints;

	// ability levels

	protected int mFireArrowLevel;
	protected int mPoisonArrowLevel;
	protected int mSpreadShotLevel;
	protected int mChargedShotLevel;
	protected int mStunArrowLevel;

	// ability costs

	protected int mFireArrowCost;
	protected int mPoisonArrowCost;
	protected int mSpreadShotCost;
	protected int mChargedShotCost;
	protected int mStunArrowCost;

	// ===========================================================
	// Constructors
	// ===========================================================

	public RangerClass() {
		// TODO
		// loadRangerSprite

		mName = "Ranger";
		
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
		
		mMaxResources.setHealth(mBaseResources.getHealth());
		mMaxResources.setResource(mBaseResources.getResource());

		mAbility[0] = "Attack";
		mAbility[1] = "Fire Arrow";
		mAbility[2] = "Poison Arrow";
		mAbility[3] = "Spread Shot";
		mAbility[4] = "Charged Shot";
		mAbility[5] = "Stun Arrow";

		mUnlockedAbility[0] = true; // Basic Attack Unlocked at lvl 1
		mUnlockedAbility[1] = true; // Fire Arrow Unlocked at lvl 1
		mUnlockedAbility[2] = false; // Poison Arrow Unlocked at lvl 10
		mUnlockedAbility[3] = false; // Spread Shot Unlocked at lvl 10
		mUnlockedAbility[4] = false; // Charged Shot Unlocked at lvl 20
		mUnlockedAbility[5] = false; // Stun Arrow Unlocked at lvl 20

		// mCurrentSkillPoints = this.getSkillPoints();

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

		// Starter Gear

		
		 //pItemType pItemLevel pStr pDex pInt pVit pDmg pArmor pIsWeapon
		 
		helmet = new Gear(ITEMTYPE.MEDIUM_HELMET, 1, 3, 10, 2, 4, 0, 6, false);
		chestArmor = new Gear(ITEMTYPE.MEDIUM_CHESTPLATE, 1, 1, 8, 1, 3, 0, 9,false);
		legArmor = new Gear(ITEMTYPE.MEDIUM_LEGS, 1, 5, 5, 3, 4, 0, 5, false);
		weaponHand1 = new Gear(ITEMTYPE.SHORTBOW, 1, 5, 13, 3, 3, 23, 0, true);
		weaponHand2 = null;

		updateItemStats();
		updateCurrentStats();

		// experience
		mLevel = 1;
		mCurrentExperience = 0;
		mExperienceToNextLevel = 100;

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void levelUp() {
		// level up - 3dex, 2 vit, 1 int, 1 str

		// test that you have leveled up
		while (mCurrentExperience >= mExperienceToNextLevel) {
			// increment level
			mLevel += 1;

			// Update base stats
			mBaseStats.setStrength(mBaseStats.getStrength() + 1);
			mBaseStats.setDexterity(mBaseStats.getDexterity() + 3);
			mBaseStats.setIntelligence(mBaseStats.getIntelligence() + 1);
			mBaseStats.setVitality(mBaseStats.getVitality() + 2);

			// Update current stats with new base stats
			updateCurrentStats();

			// Unlock other abilities if character has reached the right level
			if (mLevel == 10) {
				mUnlockedAbility[2] = true;
				mUnlockedAbility[3] = true;
			}
			if (mLevel == 20) {
				mUnlockedAbility[4] = true;
				mUnlockedAbility[5] = true;
			}

			// Reset Experience
			mCurrentExperience -= mExperienceToNextLevel;

			mExperienceToNextLevel += mLevel * 68;
			// lvl 1- 100
			// lvl 2 - 236
			// lvl 3 - 440
			// lvl 4 - 712
			// lvl 5 - 1052
			// lvl 6 - 1460
			// lvl 7 - 1936
			// lvl 8 - 2480
			// lvl 9 - 3092
			// lvl 10 - 3772
			// lvl 11 - 4520
			// lvl 12 - 5336
			// lvl 13 - 6220
			// lvl 14 - 7172
			// lvl 15 - 8192
			// lvl 16 - 9280
			// lvl 17 - 10436
			// lvl 18 - 11660
			// lvl 19 - 12952
			// lvl 20 - 14312

		}

	}

	@Override
	public boolean equipItem(Gear pGearPiece) {

		boolean equipSuccess = false;

		switch (pGearPiece.getItemType()) {
		case MEDIUM_HELMET:

			// unequip helmet
			helmet = pGearPiece;
			equipSuccess = true;

			break;

		case MEDIUM_CHESTPLATE:

			// unequip chest piece
			chestArmor = pGearPiece;
			equipSuccess = true;

			break;

		case MEDIUM_LEGS:

			// Unequip legs
			legArmor = pGearPiece;
			equipSuccess = true;

			break;

		case SHORTBOW:

			// Unequip shortbow
			weaponHand1 = pGearPiece;
			equipSuccess = true;

			break;

		case LONGBOW:

			// Unequip Longbow
			weaponHand1 = pGearPiece;
			equipSuccess = true;

			break;

		case CROSSBOW:

			// Unequip crossbow
			weaponHand1 = pGearPiece;
			equipSuccess = true;

			break;

		default:
			break;
		}

		if (equipSuccess) {
			updateItemStats();
			updateCurrentStats();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public ABILITYFLAGS useAbility(int pAbilityIdx, AbilityData pAbilityData) {
		ABILITYFLAGS returnFlag = null;

		switch (pAbilityIdx) {
		case 0:
			returnFlag = BasicAttack(pAbilityData);
			break;
		case 1:
			returnFlag = FireArrow(pAbilityData);
			break;
		case 2:
			returnFlag = PoisonArrow(pAbilityData);
			break;
		case 3:
			returnFlag = SpreadShot(pAbilityData);
			break;
		case 4:
			returnFlag = ChargedShot(pAbilityData);
			break;
		case 5:
			returnFlag = StunArrow(pAbilityData);
			break;

		}
		
		if (mCurrentResources.getResource() < 0) {
			mCurrentResources.setResource(0);
		}

		return returnFlag;

	}

	// ===========================================================
	// Methods
	// ===========================================================

	public ABILITYFLAGS BasicAttack(AbilityData pAbilityData) {
		// 90% - 110% weapon damage
		float dmg = RandomNumber.generateRandomFloat(
				mCurrentStats.getDamage() * 0.90f,
				mCurrentStats.getDamage() * 1.10f);

		pAbilityData.setDamageDone((int) dmg);

		return ABILITYFLAGS.DAMAGE_SINGLE;

	}

	public ABILITYFLAGS FireArrow(AbilityData pAbilityData) {
		mFireArrowCost = 30;
		if (mCurrentResources.getResource() >= mFireArrowCost) {
			float fireArrowDmg = mCurrentStats.getDamage() * RandomNumber.generateRandomFloat(0.30f, 0.40f) + mCurrentStats.getDexterity() * 0.4f;
			
			float dmg = RandomNumber.generateRandomFloat(
					mCurrentStats.getDamage() * 0.20f,
					mCurrentStats.getDamage() * 0.30f);

			pAbilityData.setDamageDone((int) dmg);

			pAbilityData.setBurnDamage((int) fireArrowDmg);
			pAbilityData.setBurning(true);
			pAbilityData.setBurnTurns(2);

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mFireArrowCost);

			return ABILITYFLAGS.DAMAGE_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;

	}

	public ABILITYFLAGS PoisonArrow(AbilityData pAbilityData) {
		mPoisonArrowCost = 30;
		if (mCurrentResources.getResource() >= mPoisonArrowCost) {
			float poisonArrowDmg = mCurrentStats.getDamage() * RandomNumber.generateRandomFloat(0.30f, 0.40f) + mCurrentStats.getDexterity() * 0.4f;
			
			float dmg = RandomNumber.generateRandomFloat(
					mCurrentStats.getDamage() * 0.20f,
					mCurrentStats.getDamage() * 0.30f);

			pAbilityData.setDamageDone((int) dmg);

			pAbilityData.setPoisonDamage((int) poisonArrowDmg);
			pAbilityData.setPoisoned(true);
			pAbilityData.setPoisonTurns(2);

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mPoisonArrowCost);

			return ABILITYFLAGS.DAMAGE_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS SpreadShot(AbilityData pAbilityData) {
		mSpreadShotCost = 30;
		if (mCurrentResources.getResource() >= mSpreadShotCost) {

			float spreadShotDmg = 0.6f * mCurrentStats.getDamage() + mCurrentStats.getDexterity() * 0.4f;

			pAbilityData.setDamageDone((int) spreadShotDmg);

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mSpreadShotCost);

			return ABILITYFLAGS.DAMAGE_ALL;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS ChargedShot(AbilityData pAbilityData) {
		mChargedShotCost = 60;
		if (mCurrentResources.getResource() >= mChargedShotCost) {

			// TODO
			// NEED TURNS TO IMPLEMENT CHARGE

			float damageMod = mCurrentStats.getDamage()
					* RandomNumber.generateRandomFloat(1.25f, 2f)  + mCurrentStats.getDexterity() * 0.4f;

			pAbilityData.setDamageDone((int) damageMod);
			// Being stunned needs to affect the player instead of the enemy
			

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mChargedShotCost);

			return ABILITYFLAGS.DAMAGE_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS StunArrow(AbilityData pAbilityData) {
		mStunArrowCost = 55;
		if (mCurrentResources.getResource() >= mStunArrowCost) {

			float dmg = 0.75f * mCurrentStats.getDamage()  + mCurrentStats.getDexterity() * 0.4f;

			pAbilityData.setDamageDone((int) dmg);
			pAbilityData.setStunned(true);
			pAbilityData.setStunTurns(2);

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mStunArrowCost);

			return ABILITYFLAGS.DAMAGE_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	// TODO Level up abilities
	// /**
	// * Level up_ fire arrow.
	// */
	// void LevelUp_FireArrow() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mFireArrowLevel += 1;
	// // increase cost of skill
	// }
	//
	// }
	//
	// /**
	// * Level up_ poison arrow.
	// */
	// void LevelUp_PoisonArrow() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mFireArrowLevel += 1;
	// // increase cost of skill
	// }
	// }
	//
	// /**
	// * Level up_ spread shot.
	// */
	// void LevelUp_SpreadShot() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mSpreadShotLevel += 1;
	// // increase cost of skill
	// }
	// }
	//
	// /**
	// * Level up_ charged shot.
	// */
	// void LevelUp_ChargedShot() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mChargedShotLevel += 1;
	// // increase cost of skill
	// }
	// }
	//
	// /**
	// * Level up_ stun arrow.
	// */
	// void LevelUp_StunArrow() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mStunArrowLevel += 1;
	// // increase cost of skill
	// }
	// }

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
