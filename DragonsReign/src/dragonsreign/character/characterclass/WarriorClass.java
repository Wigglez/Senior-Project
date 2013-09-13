/*
 * 
 */
package dragonsreign.character.characterclass;

import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Gear;
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
		helmet = new Gear(ITEMTYPE.HEAVY_HELMET, 1, 10, 3, 2, 4, 0, 11, false);
		chestArmor = new Gear(ITEMTYPE.HEAVY_CHESTPLATE, 1, 8, 1, 0, 3, 0, 15,
				false);
		legArmor = new Gear(ITEMTYPE.HEAVY_LEGS, 1, 5, 5, 3, 4, 0, 9, false);
		weaponHand1 = new Gear(ITEMTYPE.ONE_HANDED_SWORD, 1, 13, 2, 6, 3, 23,
				0, true);
		weaponHand2 = null;

		updateItemStats();
		updateCurrentStats();
		
		//Experience
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
		// level up - 1 dex, 2 vita, 1 int, 3 str

		//Test that you have leveled up
		while (mCurrentExperience >= mExperienceToNextLevel) {
			//increment level
			mLevel += 1;

			//Update base stats
			mBaseStats.setStrength(mBaseStats.getStrength() + 3);
			mBaseStats.setDexterity(mBaseStats.getDexterity() + 1);
			mBaseStats.setIntelligence(mBaseStats.getIntelligence() + 1);
			mBaseStats.setVitality(mBaseStats.getVitality() + 2);

			//Update current stats with new base stats
			updateCurrentStats();

			//Unlock other abilities if character has reached the right level
			if (mLevel == 10) {
				mUnlockedAbility[2] = true;
				mUnlockedAbility[3] = true;
			}
			if (mLevel == 20) {
				mUnlockedAbility[4] = true;
				mUnlockedAbility[5] = true;
			}
			
			//Reset Experience
			mCurrentExperience -= mExperienceToNextLevel;
			
			
			mExperienceToNextLevel += mLevel * 68;		
			
		}

	}

	@Override
	public boolean equipItem(Gear pGearPiece) {

		boolean equipSuccess = false;

		switch (pGearPiece.getItemType()) {
		case HEAVY_HELMET:

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

			} else if (mLungeLevel == 2) {
				// attacks selected enemy target and stuns

			} else if (mLungeLevel == 3) {
				// attacks selected enemy target and stuns

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

			} else if (mRendLevel == 2) {

			} else if (mRendLevel == 3) {
				// bleeds the target for 150% weapon dmg over 3 turns

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
