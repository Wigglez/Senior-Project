package dragonsreign.character.characterclass;

import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Gear;
import dragonsreign.manager.ResourceManager;
import dragonsreign.util.AbilityData;
import dragonsreign.util.RandomNumber;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.ITEMTYPE;

public class ClericClass extends PlayerCharacter {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mCurrentSkillPoints;

	// ability levels
	protected int mLifeSiphonLevel;
	protected int mMendLevel;
	protected int mReviveLevel;
	protected int mHealingChantLevel;
	protected int mEmpowerLevel;

	// ability costs
	protected int mLifeSiphonCost;
	protected int mMendCost;
	protected int mReviveCost;
	protected int mHealingChantCost;
	protected int mEmpowerCost;

	// ===========================================================
	// Constructors
	// ===========================================================

	public ClericClass() {
		// loadClericSprite

		mName = "Cleric";
		mSprite = ResourceManager.getInstance().clericCharacter;
		mPortrait = ResourceManager.getInstance().clericPortrait;

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
		
		mMaxResources.setHealth(mBaseResources.getHealth());
		mMaxResources.setResource(mBaseResources.getResource());

		mAbility[0] = "Attack";
		mAbility[1] = "Mend";
		mAbility[2] = "Life Siphon";
		mAbility[3] = "Revive";
		mAbility[4] = "Healing Chant";
		mAbility[5] = "Empower";

		mUnlockedAbility[0] = true; // basic attack unlocked at lvl 1
		mUnlockedAbility[1] = true; // mend unlocked at lvl 1
		mUnlockedAbility[2] = false; // Life Siphon unlocked at lvl 10
		mUnlockedAbility[3] = false; // revive unlocked at lvl 10
		mUnlockedAbility[4] = false; // healing chant unlocked at lvl 20
		mUnlockedAbility[5] = false; // empower unlocked at lvl 20

		// mCurrentSkillPoints = this.getSkillPoints();

		// ability levels

		mLifeSiphonLevel = 0;
		mMendLevel = 0;
		mReviveLevel = 0;
		mHealingChantLevel = 0;
		mEmpowerLevel = 0;

		// ability costs

		mLifeSiphonCost = 0;
		mMendCost = 0;
		mReviveCost = 0;
		mHealingChantCost = 0;
		mEmpowerCost = 0;

		// starter gear
		//pItemType pItemLevel pStr pDex pInt pVit pDmg pArmor pIsWeapon
		helmet = new Gear(ITEMTYPE.LIGHT_HELMET, 1, 2, 3, 10, 4, 0, 2, false);
		chestArmor = new Gear(ITEMTYPE.LIGHT_CHESTPLATE, 1, 1, 1, 8, 3, 0, 4, false);
		legArmor = new Gear(ITEMTYPE.LIGHT_LEGS, 1, 3, 5, 5, 4, 0, 2, false);
		weaponHand1 = new Gear(ITEMTYPE.WAND, 1, 2, 5, 13, 3, 20, 0, true);
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
		// level up - 1 dex, 2 vit, 3 int, 1 str

		// Test that you have leveled up
		while (mCurrentExperience >= mExperienceToNextLevel) {
			// increment level
			mLevel += 1;

			// update base stats
			mBaseStats.setStrength(mBaseStats.getStrength() + 1);
			mBaseStats.setDexterity(mBaseStats.getDexterity() + 1);
			mBaseStats.setIntelligence(mBaseStats.getIntelligence() + 3);
			mBaseStats.setVitality(mBaseStats.getVitality() + 2);

			// update current stats wih new base stats
			updateCurrentStats();

			// unlock other abilities if character has reached the right level
			if (mLevel == 10) {
				mUnlockedAbility[2] = true;
				mUnlockedAbility[3] = true;
			}

			if (mLevel == 20) {
				mUnlockedAbility[4] = true;
				mUnlockedAbility[5] = true;
			}

			// reset experience
			mCurrentExperience -= mExperienceToNextLevel;

			mExperienceToNextLevel += mLevel * 68;

		}

	}

	@Override
	public boolean equipItem(Gear pGearPiece, Gear[] removeItems) {
		boolean equipSuccess = false;

		
		
		switch (pGearPiece.getItemType()) {
		case LIGHT_HELMET:

			// unequip helmet
			if (helmet != null)
				removeItems[0] = new Gear(helmet);

			helmet = pGearPiece;
			equipSuccess = true;

			break;

		case LIGHT_CHESTPLATE:

			// unequip chestplate
			if (chestArmor != null)
				removeItems[0] = new Gear(chestArmor);

			chestArmor = pGearPiece;
			equipSuccess = true;

			break;

		case LIGHT_LEGS:

			// unequip legs
			if (legArmor != null)
				removeItems[0] = new Gear(legArmor);

			legArmor = pGearPiece;
			equipSuccess = true;

			break;

		case WAND:

			// unequip wand
			if (weaponHand1 != null)
				removeItems[0] = new Gear(weaponHand1);

			weaponHand1 = pGearPiece;
			equipSuccess = true;

			break;

		case ORB:

			// unequip orb
			if (weaponHand2 != null)
				removeItems[0] = new Gear(weaponHand2);

			weaponHand2 = pGearPiece;
			equipSuccess = true;

			break;

		case STAFF:

			if (weaponHand2 == null) {
				// unequip weaponHand1
				removeItems[0] = new Gear(weaponHand1);
				
				weaponHand1 = pGearPiece;
				equipSuccess = true;

			} else {
				// unequip weaponHand1 &weaponHand2
				removeItems[0] = new Gear(weaponHand1);
				removeItems[1] = new Gear(weaponHand2);
				
				weaponHand1 = pGearPiece;
				equipSuccess = true;
			}

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
			returnFlag = Mend(pAbilityData);
			break;

		case 2:
			returnFlag = LifeSiphon(pAbilityData);
			break;

		case 3:
			returnFlag = Revive(pAbilityData);
			break;

		case 4:
			returnFlag = HealingChant(pAbilityData);
			break;

		case 5:
			returnFlag = Empower(pAbilityData);
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

	public ABILITYFLAGS Mend(AbilityData pAbilityData) {
		mMendCost = 15;

		if (this.getCurrentResources().getResource() >= mMendCost) {
			// TODO
			// NEED TURNS FOR HEAL OVER TIME

			// Arbitrary as hell, see if it works out
			float mendHeal = mCurrentStats.getIntelligence() * 0.75f;

			pAbilityData.setHealingDone((int) mendHeal);
			pAbilityData.setHealed(true);
			pAbilityData.setResourceUsed(mMendCost);

//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mMendCost);

			return ABILITYFLAGS.HEAL_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS LifeSiphon(AbilityData pAbilityData) {
		mLifeSiphonCost = 30;
		if (this.getCurrentResources().getResource() >= mLifeSiphonCost) {

			float siphonDmg = (float) (mCurrentStats.getDamage() * 0.50)  + mCurrentStats.getIntelligence() * 0.4f;

			pAbilityData.setDamageDone((int) siphonDmg);
			pAbilityData.setResourceUsed(mLifeSiphonCost);

//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mLifeSiphonCost);

			return ABILITYFLAGS.DAMAGE_HEAL_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;

	}

	public ABILITYFLAGS Revive(AbilityData pAbilityData) {
		mReviveCost = 75;

		if (this.getCurrentResources().getResource() >= mReviveCost) {

			// TODO
			// Revive player at 50% health
			// Need targeted player

			pAbilityData.setResourceUsed(mReviveCost);

//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mReviveCost);

			return ABILITYFLAGS.REVIVE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS HealingChant(AbilityData pAbilityData) {
		mHealingChantCost = 80;
		if (this.getCurrentResources().getResource() >= mHealingChantCost) {

			// heals 60% max health
			float healingChantAmount = mMaxResources.getHealth() * 0.60f   + mCurrentStats.getIntelligence() * 0.4f;

			pAbilityData.setHealingDone((int) healingChantAmount);
			pAbilityData.setResourceUsed(mHealingChantCost);

//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mHealingChantCost);

			return ABILITYFLAGS.HEAL_ALL;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;

	}

	public ABILITYFLAGS Empower(AbilityData pAbilityData) {
		mEmpowerCost = 50;
		if (this.getCurrentResources().getResource() >= mEmpowerCost) {

			// Empower grants 20% bonus stats to party members

			float buffStrStat = 0.2f * mCurrentStats.getStrength() + mCurrentStats.getIntelligence() * 0.4f;
			float buffDexStat = 0.2f * mCurrentStats.getDexterity() + mCurrentStats.getIntelligence() * 0.4f;
			float buffIntStat = 0.2f * mCurrentStats.getIntelligence() + mCurrentStats.getIntelligence() * 0.4f;
			float buffVitStat = 0.2f * mCurrentStats.getVitality() + mCurrentStats.getIntelligence() * 0.4f;

			pAbilityData.getBuff().setStrength((int) buffStrStat);
			pAbilityData.getBuff().setDexterity((int) buffDexStat);
			pAbilityData.getBuff().setIntelligence((int) buffIntStat);
			pAbilityData.getBuff().setVitality((int) buffVitStat);

			pAbilityData.setBuffed(true);
			pAbilityData.setBuffTurns(5);
			pAbilityData.setResourceUsed(mEmpowerCost);

//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mEmpowerCost);

			return ABILITYFLAGS.BUFF_ALL;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}
	// TODO Level up Abilities
	// /**
	// * Level up_ heal life Siphon.
	// */
	// public void LevelUp_HealLifeSiphon() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mHealLifeSiphonLevel += 1;
	// // increase cost of skill
	// }
	//
	// }
	//
	// /**
	// * Level up_ revive.
	// */
	// public void LevelUp_Revive() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mReviveLevel += 1;
	// // increase cost of skill
	// }
	// }
	//
	// /**
	// * Level up_ healing chant.
	// */
	// public void LevelUp_HealingChant() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mHealingChantLevel += 1;
	// // increase cost of skill
	// }
	// }
	//
	// /**
	// * Level up_ empower.
	// */
	// public void LevelUp_Empower() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mEmpowerLevel += 1;
	// // increase cost of skill
	// }
	// }
	//
	// /**
	// * Level up_ mend.
	// */
	// public void LevelUp_Mend() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mMendLevel += 1;
	// // increase cost of skill
	// }
	// }

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
