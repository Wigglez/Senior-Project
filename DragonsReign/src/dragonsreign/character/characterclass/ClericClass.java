/*
 * 
 */
package dragonsreign.character.characterclass;
import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Gear;
import dragonsreign.util.Stats;
import dragonsreign.util.enums.ITEMTYPE;

public class ClericClass extends PlayerCharacter {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mCurrentSkillPoints;
		
	//ability levels
	protected int mHealLifeSyphonLevel;
	protected int mReviveLevel;
	protected int mHealingChantLevel;
	protected int mEmpowerLevel;
	protected int mMendLevel;
	
	//ability costs
	protected int mHealLifeSyphonCost;
	protected int mReviveCost;
	protected int mHealingChantCost;
	protected int mEmpowerCost;
	protected int mMendCost;
	
	

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

		mUnlockedAbility[0] = true; //basic attack unlocked at lvl 1
		mUnlockedAbility[1] = true; // Heal/Lifesysphon unlocked at lvl 1
		mUnlockedAbility[2] = false; //revive unlocked at lvl 10
		mUnlockedAbility[3] = false; //healing chant unlocked at lvl 10
		mUnlockedAbility[4] = false; //empower unlocked at lvl 20
		mUnlockedAbility[5] = false; //mend unlocked at lvl 20

		//mCurrentSkillPoints = this.getSkillPoints();

		//ability levels
		
		mHealLifeSyphonLevel = 0;
		mReviveLevel = 0;
		mHealingChantLevel = 0;
		mEmpowerLevel = 0;
		mMendLevel = 0;
		
		//ability costs
		
		mHealLifeSyphonCost = 0;
		mReviveCost = 0;
		mHealingChantCost = 0;
		mEmpowerCost = 0;
		mMendCost = 0;
		
		//starter gear
		helmet = new Gear(ITEMTYPE.LIGHT_HELMET, 1/*item lvl*/, 2/*str*/, 3/*dex*/, 10/*int*/, 4/*vit*/, 0/*dmg*/, 2/*armor*/,false/*is wpn*/);
		chestArmor = new Gear(ITEMTYPE.LIGHT_CHESTPLATE, 1/*item lvl*/, 1/*str*/, 1/*dex*/, 8/*int*/, 3/*vit*/, 0/*dmg*/, 4/*armor*/, false/*is wpn*/);
		legArmor = new Gear(ITEMTYPE.LIGHT_LEGS, 1/*item lvl*/, 3/*str*/, 5/*dex*/, 5/*int*/, 4/*vit*/, 0/*dmg*/, 2/*armor*/,false/*is wpn*/);
		weaponHand1 = new Gear(ITEMTYPE.WAND, 1/*item lvl*/, 2/*str*/, 5/*dex*/, 13/*int*/, 3/*vit*/, 20/*dmg*/, 0/*armor*/,true/*is wpn*/);	
		weaponHand2 = null;
		
		updateItemStats();
		updateCurrentStats();
		
		//experience
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
		//level up - 1 dex, 2 vit, 3 int, 1 str
		
		//Test that you have leveled up
		while(mCurrentExperience >= mExperienceToNextLevel){
			//increment level
			mLevel +=1;
			
			//update base stats
			mBaseStats.setStrength(mBaseStats.getStrength() + 1);
			mBaseStats.setDexterity(mBaseStats.getDexterity() + 1);
			mBaseStats.setIntelligence(mBaseStats.getIntelligence() + 3);
			mBaseStats.setVitality(mBaseStats.getVitality() + 2);
			
			//update current stats wih new base stats
			updateCurrentStats();
			
			//unlock other abilities if character has reached the right level
			if (mLevel ==10){
				mUnlockedAbility[2] = true;
				mUnlockedAbility[3] = true;
			}
			
			if (mLevel ==20){
				mUnlockedAbility[4] = true;
				mUnlockedAbility[5] = true;
			}
			
			//reset experience
			mCurrentExperience -=mExperienceToNextLevel;
			
			mExperienceToNextLevel +=mLevel *68;
			
		}

	}

	
	@Override
	public boolean equipItem(Gear pGearPiece) {
		boolean equipSuccess = false;
		
		switch (pGearPiece.getItemType()){
		case LIGHT_HELMET:
			
			//unequip helmet
			helmet = pGearPiece;
			equipSuccess = true;
			
			break;
			
		case LIGHT_CHESTPLATE:
			
			//unequip chestplate
			chestArmor = pGearPiece;
			equipSuccess = true;
			
			break;
		
		case LIGHT_LEGS:
			
			//unequip legs
			legArmor = pGearPiece;
			equipSuccess = true;
			
			break;
			
		case WAND:
			
			//unequip wand
			weaponHand1 = pGearPiece;
			equipSuccess = true;
			
			break;
			
		case ORB:
			
			//unequip orb
			weaponHand2 = pGearPiece;
			equipSuccess = true;
			
			break;
			
		case STAFF:
			
			
			if (weaponHand2 == null){
				//unequip weaponHand1
				weaponHand1 = pGearPiece;
				equipSuccess = true;
				
			} else{
				//unequip weaponHand1 &weaponHand2
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
		if (this.getCurrentResources().getResource() > mHealLifeSyphonCost) {
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

			mCurrentResources.setResource(mCurrentResources.getResource() - mHealLifeSyphonCost);
		}

	}

	/**
	 * Revive.
	 */
	public void Revive() {
		if (this.getCurrentResources().getResource() > mReviveCost) {
			// revive
			if (mReviveLevel == 1) {
				// revive targeted party member
			} else if (mReviveLevel == 2) {
				// revive targeted party member
			} else if (mReviveLevel == 3) {
				// revive targeted party member
			}

			mCurrentResources.setResource(mCurrentResources.getResource() - mReviveCost);
		}
	}

	/**
	 * Healing chant.
	 */
	public void HealingChant() {
		if (this.getCurrentResources().getResource() > mHealingChantCost) {

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

			mCurrentResources.setResource(mCurrentResources.getResource() - mHealingChantCost);
		}

	}

	/**
	 * Empower.
	 */
	public void Empower() {
		if (this.getCurrentResources().getResource() > mEmpowerCost) {

			if (mEmpowerLevel == 1) {
				// boost to all primary stats of entire party
			} else if (mEmpowerLevel == 2) {
				// boost to all primary stats of entire party
			} else if (mEmpowerLevel == 3) {
				// boost to all primary stats of entire party
			}

			mCurrentResources.setResource(mCurrentResources.getResource() - mEmpowerCost);
		}
	}

	/**
	 * Mend.
	 */
	public void Mend() {
		if (this.getCurrentResources().getResource() > mMendCost) {

			if (mMendLevel == 1) {
				// heals targeted party member gradually over time
			} else if (mMendLevel == 2) {
				// heals targeted party member gradually over time
			} else if (mMendLevel == 3) {
				// heals targeted party member gradually over time
			}

			mCurrentResources.setResource(mCurrentResources.getResource() - mMendCost);
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
