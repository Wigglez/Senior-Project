/*
 * 
 */
package dragonsreign.character.characterclass;

import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Gear;
import dragonsreign.util.AbilityData;
import dragonsreign.util.RandomNumber;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.ITEMTYPE;

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

	// ===========================================================
	// Constructors
	// ===========================================================

	public WarriorClass() {
		// TODO
		// loadWarriorSprite
		
		mName = "Warrior";

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
		mBaseResources.setExperience(0);

		mCurrentResources.setHealth(mBaseResources.getHealth());
		mCurrentResources.setResource(mBaseResources.getResource());
		mCurrentResources.setExperience(mBaseResources.getExperience());
		
		mMaxResources.setHealth(mBaseResources.getHealth());
		mMaxResources.setResource(mBaseResources.getResource());

		mAbility[0] = "Attack";
		mAbility[1] = "Cleave";
		mAbility[2] = "Lunge";
		mAbility[3] = "Execute";
		mAbility[4] = "Rend";
		mAbility[5] = "War Cry";

		mUnlockedAbility[0] = true; // Basic Attack Unlocked at lvl 1
		mUnlockedAbility[1] = true; // Cleave Unlocked at lvl 1
		mUnlockedAbility[2] = false; // Lunge Unlocked at lvl 10
		mUnlockedAbility[3] = false; // Execute Unlocked at lvl 10
		mUnlockedAbility[4] = false; // Rend Unlocked at lvl 20
		mUnlockedAbility[5] = false; // War Cry Unlocked at lvl 20

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

		// Starter Gear
		//pItemType pItemLevel pStr pDex pInt pVit pDmg pArmor pIsWeapon
		helmet = new Gear(ITEMTYPE.HEAVY_HELMET, 1, 10, 3, 2, 4, 0, 11, false);
		chestArmor = new Gear(ITEMTYPE.HEAVY_CHESTPLATE, 1, 8, 1, 0, 3, 0, 15, false);
		legArmor = new Gear(ITEMTYPE.HEAVY_LEGS, 1, 5, 5, 3, 4, 0, 9, false);
		weaponHand1 = new Gear(ITEMTYPE.ONE_HANDED_SWORD, 1, 13, 2, 6, 3, 23, 0, true);
		weaponHand2 = null;

		updateItemStats();
		updateCurrentStats();

		// Experience
		mLevel = 1;
		mCurrentExperience = mCurrentResources.getExperience();
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
		// level up - 1 dex, 2 vita, 1 int, 3 str

		// Test that you have leveled up
		while (mCurrentExperience >= mExperienceToNextLevel) {
			// increment level
			mLevel += 1;

			// Update base stats
			mBaseStats.setStrength(mBaseStats.getStrength() + 3);
			mBaseStats.setDexterity(mBaseStats.getDexterity() + 1);
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
	public boolean equipItem(Gear pGearPiece, Gear[] removeItems) {

		
		boolean equipSuccess = false;

		switch (pGearPiece.getItemType()) {
		case HEAVY_HELMET:

			removeItems[0] = helmet;
			// unequip helmet
			helmet = pGearPiece;
			equipSuccess = true;

			break;

		case HEAVY_CHESTPLATE:

			// unequip chest piece
			chestArmor = pGearPiece;
			equipSuccess = true;

			break;

		case HEAVY_LEGS:

			// Unequip legs
			legArmor = pGearPiece;
			equipSuccess = true;

			break;

		case ONE_HANDED_SWORD:
		case ONE_HANDED_AXE:
		case ONE_HANDED_MACE:

			if (weaponHand1.equals(null)) {

				weaponHand1 = pGearPiece;
				equipSuccess = true;

			} else if (weaponHand2 == null) {

				weaponHand2 = pGearPiece;
				equipSuccess = true;

			} else {

				// unequip weaponHand1
				weaponHand1 = pGearPiece;
				equipSuccess = true;

			}

			break;

		case TWO_HANDED_SWORD:
		case TWO_HANDED_AXE:
		case TWO_HANDED_MACE:

			if (weaponHand2 == null) {
				// unequip weaponHand1
				weaponHand1 = pGearPiece;
				equipSuccess = true;
			} else {
				// unequip weaponHand1 & weaponHand2
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
			returnFlag = Cleave(pAbilityData);
			break;
		case 2:
			returnFlag = Lunge(pAbilityData);
			break;
		case 3:
			returnFlag = Execute(pAbilityData);
			break;
		case 4:
			returnFlag = Rend(pAbilityData);
			break;
		case 5:
			returnFlag = WarCry(pAbilityData);
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

	public ABILITYFLAGS Cleave(AbilityData pAbilityData) {
		mCleaveCost = 30;
		if (this.getCurrentResources().getResource() >= mCleaveCost) {

			// TODO Tiered Ability
			// // do stuff
			// if (mCleaveLevel == 1) {
			// // attacks all enemies for 40% base dmg
			// } else if (mCleaveLevel == 2) {
			// // attacks all enemies for 60% base dmg
			// } else if (mCleaveLevel == 3) {
			// // attacks all enemies for 75% base dmg
			// }

			float dmg = 0.6f * mCurrentStats.getDamage() + mCurrentStats.getStrength() * 0.4f;

			pAbilityData.setDamageDone((int) dmg);
			pAbilityData.setResourceUsed(mCleaveCost);

//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mCleaveCost);

			return ABILITYFLAGS.DAMAGE_ALL;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS Lunge(AbilityData pAbilityData) {
		mLungeCost = 55;
		if (mCurrentResources.getResource() >= mLungeCost) {

			// TODO Tiered Abili
			// if (mLungeLevel == 1) {
			// // attacks selected enemy target and stuns
			// 50%
			// } else if (mLungeLevel == 2) {
			// // attacks selected enemy target and stuns
			// 75%
			// } else if (mLungeLevel == 3) {
			// // attacks selected enemy target and stuns
			// 100%
			// }

			float dmg = 0.75f * mCurrentStats.getDamage() + mCurrentStats.getStrength() * 0.4f ;

			pAbilityData.setDamageDone((int) dmg);
			pAbilityData.setStunned(true);
			pAbilityData.setStunTurns(2);
			pAbilityData.setResourceUsed(mLungeCost);
			
//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mLungeCost);
			
			

			return ABILITYFLAGS.DAMAGE_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS Execute(AbilityData pAbilityData) {
		mExecuteCost = mCurrentResources.getResource();
		if (mCurrentResources.getResource() >= mExecuteCost) {

			// ////TODO Tiered Ability
			// // do stuff
			// if (mExecuteLevel == 1) {
			// // Completely drains stamina increased dmg based on amount of
			// // stamina drained
			// } else if (mExecuteLevel == 2) {
			// // Completely drains stamina increased dmg based on amount of
			// // stamina drained
			// } else if (mExecuteLevel == 3) {
			// // Completely drains stamina increased dmg based on amount of
			// // stamina drained
			// }

			float excDmgMod = mCurrentResources.getResource()
					/ mMaxResources.getResource();
			excDmgMod += 1;

			float dmg = mCurrentStats.getDamage() * excDmgMod;

			pAbilityData.setDamageDone((int) dmg);
			pAbilityData.setResourceUsed(mExecuteCost);
			
//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mExecuteCost);

			return ABILITYFLAGS.DAMAGE_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS Rend(AbilityData pAbilityData) {
		mRendCost = 40;

		if (mCurrentResources.getResource() >= mRendCost) {

			// //TODO Tiered Ability
			// if (mRendLevel == 1) {
			// // bleeds the target for 100% weapon dmg over 3 turns
			//
			// } else if (mRendLevel == 2) {
			//
			// } else if (mRendLevel == 3) {
			// // bleeds the target for 150% weapon dmg over 3 turns
			//
			// }

			float rendDmg = mCurrentStats.getDamage() * .33f  + mCurrentStats.getStrength() * 0.4f;

			pAbilityData.setBleedDamage((int) rendDmg);
			pAbilityData.setBleeding(true);
			pAbilityData.setBleedTurns(3);
			pAbilityData.setResourceUsed(mRendCost);

			mCurrentResources.setResource(mCurrentResources.getResource()
					- mRendCost);

			return ABILITYFLAGS.DAMAGE_SINGLE;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;
	}

	public ABILITYFLAGS WarCry(AbilityData pAbilityData) {
		mWarCryCost = 50;

		if (mCurrentResources.getResource() >= mWarCryCost) {

			// //TODO Tiered Ability
			// if (mWarCryLevel == 1) {
			// // increase party dmg by 15% depletes 50% stamina
			// } else if (mWarCryLevel == 2) {
			// // increase party dmg by 20% depletes 50% stamina
			// } else if (mWarCryLevel == 3) {
			// // increase party dmg by 30% depletes 50% stamina
			// }

			// War Cry grants 20% of Warrior's damage to the rest of the party
			
			float buffDmg = 0.2f * mCurrentStats.getDamage()  + mCurrentStats.getStrength() * 0.4f;

			pAbilityData.getBuff().setDamage((int) buffDmg);
			pAbilityData.setBuffed(true);
			pAbilityData.setBuffTurns(5);
			pAbilityData.setResourceUsed(mWarCryCost);

//			mCurrentResources.setResource(mCurrentResources.getResource()
//					- mWarCryCost);

			return ABILITYFLAGS.BUFF_ALL;
		} else
			return ABILITYFLAGS.NOT_ENOUGH_RESOURCE;

	}

	// TODO Level up Abilities
	// public void LevelUp_Cleave() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mCleaveLevel += 1;
	//
	// mCurrentSkillPoints -= 1;
	// }
	// }
	//
	// public void LevelUp_Lunge() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mLungeLevel += 1;
	//
	// mCurrentSkillPoints -= 1;
	// }
	// }
	//
	// public void LevelUp_Execute() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mExecuteLevel += 1;
	//
	// mCurrentSkillPoints -= 1;
	// }
	// }
	//
	// public void LevelUp_Rend() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mRendLevel += 1;
	//
	// mCurrentSkillPoints -= 1;
	// }
	// }
	//
	// public void LevelUp_WarCry() {
	// if (mCurrentSkillPoints > 0) {
	//
	// mWarCryLevel += 1;
	//
	// mCurrentSkillPoints -= 1;
	// }
	// }

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
