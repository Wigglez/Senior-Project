package dragonsreign.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.provider.Settings.System;
import android.widget.Toast;
import dragonsreign.character.Character;
import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.consumable.Potion;
import dragonsreign.scene.BattleScene;
import dragonsreign.scene.DragonsReignActivity;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.HASTE;

public class BattleCharacterContainer {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	static DragonsReignActivity activity;

	private Character mCharacter;

	private boolean hasTurn;

	protected Stats mBuff;

	protected boolean mBleeding;
	protected boolean mBlinded;
	protected boolean mBurning;
	protected boolean mChilled;
	protected boolean mDazed;
	protected boolean mPoisoned;
	protected boolean mStunned;
	protected boolean mBuffed;

	protected int mBleedTurns;
	protected int mBlindTurns;
	protected int mBurnTurns;
	protected int mChillTurns;
	protected int mDazeTurns;
	protected int mPoisonTurns;
	protected int mStunTurns;
	protected int mBuffTurns;

	protected int mBleedDamage;
	protected int mBurnDamage;
	protected int mPoisonDamage;

	protected Stats mChillArmorReduction;
	protected Stats mDazeDamageReduction;

	// ===========================================================
	// Constructors
	// ===========================================================

	public BattleCharacterContainer(Character pCharacter) {
		mCharacter = pCharacter;
		ClearBattleEffects();
		hasTurn = true;

	}
	
	public BattleCharacterContainer(Character pCharacter, DragonsReignActivity pActivity) {
		mCharacter = pCharacter;
		ClearBattleEffects();
		hasTurn = true;
		
		activity = pActivity;

	}
	
	public BattleCharacterContainer(){
		mCharacter = null;
		ClearBattleEffects();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public Character getCharacter() {
		return mCharacter;
	}

	public boolean hasTurn() {
		return hasTurn;
	}

	public void setHasTurn(boolean pHasTurn) {
		this.hasTurn = pHasTurn;
	}

	// BLEED
	public boolean isBleeding() {
		return mBleeding;
	}

	// BLIND
	public boolean isBlinded() {
		return mBlinded;
	}

	// BURN
	public boolean isBurning() {
		return mBurning;
	}

	// CHILL
	public boolean isChilled() {
		return mChilled;
	}

	// DAZE
	public boolean isDazed() {
		return mDazed;
	}

	// POISON
	public boolean isPoisoned() {
		return mPoisoned;
	}

	// STUN
	public boolean isStunned() {
		return mStunned;
	}

	// BUFF
	public boolean isBuffed() {
		return mBuffed;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	public void ClearBattleEffects() {
		mBleeding = false;
		mBlinded = false;
		mBurning = false;
		mChilled = false;
		mDazed = false;
		mPoisoned = false;
		mStunned = false;

		mBleedTurns = 0;
		mBlindTurns = 0;
		mBurnTurns = 0;
		mChillTurns = 0;
		mDazeTurns = 0;
		mPoisonTurns = 0;
		mStunTurns = 0;

		mBleedDamage = 0;
		mBurnDamage = 0;
		mPoisonDamage = 0;
	}

	public HASTE getHaste() {
		return mCharacter.getHaste();
	}

	public int getCurrentHealth() {
		return mCharacter.getCurrentResources().getHealth();
	}
	
	public int getMaxHealth() {
		return mCharacter.getMaxResources().getHealth();
	}

	public int getCurrentResource() {
		return mCharacter.getCurrentResources().getResource();
	}
	
	public int getMaxResource() {
		return mCharacter.getMaxResources().getResource();
	}

	public int getLevel(){
		return mCharacter.getLevel();
	}
	
	public String getName(){
		return mCharacter.getName();
	}
	public boolean isDead() {
		return mCharacter.isDead();
	}

	public String[] getAbilityNames() {
		return mCharacter.getAbility();
	}

	public ABILITYFLAGS useAbility(int pAbilityIndex, AbilityData pAbilityData) {
		ABILITYFLAGS rtnFlag = mCharacter.useAbility(pAbilityIndex, pAbilityData);
		//If ability flag is NOT_ENOUGH_RESOURCE then they don't lose their turn
		if( rtnFlag == ABILITYFLAGS.NOT_ENOUGH_RESOURCE){
			hasTurn = true;
			//TODO OutPut message "Not Enough Resource"
		} else
			hasTurn = false;
		return rtnFlag;
	}

	public boolean useItem(Potion pPotion) {

		if (((PlayerCharacter) mCharacter).useItem(pPotion)) {
			hasTurn = false;
			return true;
		} else
			return false;
	}

	public void recieveAbilityData(AbilityData pIncomingDmg) {
		mCharacter.TakeDamage(mCharacter.incomingDamage(pIncomingDmg
				.getDamageDone()));

		if (pIncomingDmg.isBleeding()) {

			mBleeding = true;
			mBleedDamage = pIncomingDmg.getBleedDamage();
			mBleedTurns = pIncomingDmg.getBleedTurns();

		}
		if (pIncomingDmg.isBlinded()) {

			mBlinded = true;
			mBlindTurns = pIncomingDmg.getBlindTurns();

		}
		if (pIncomingDmg.isBurning()) {

			mBurning = true;
			mBurnDamage = pIncomingDmg.getBurnDamage();
			mBurnTurns = pIncomingDmg.getBurnTurns();

		}
		if (pIncomingDmg.isChilled()) {

			mChilled = true;
			mChillTurns = pIncomingDmg.getChillTurns();

			mChillArmorReduction = new Stats();
			mChillArmorReduction.setArmor((int) (mCharacter.getCurrentStats()
					.getArmor() * -.2f));
			mCharacter.AddBuff(mChillArmorReduction);

		}
		if (pIncomingDmg.isDazed()) {

			mDazed = true;
			mDazeTurns = pIncomingDmg.getDazeTurns();

			mDazeDamageReduction = new Stats();
			mDazeDamageReduction.setDamage((int) (mCharacter.getCurrentStats()
					.getDamage() * -.2f));

			mCharacter.AddBuff(mDazeDamageReduction);

		}
		if (pIncomingDmg.isPoisoned()) {

			mPoisoned = true;
			mPoisonDamage = pIncomingDmg.getPoisonDamage();
			mPoisonTurns = pIncomingDmg.getPoisonTurns();

		}
		if (pIncomingDmg.isStunned()) {

			mStunned = true;
			mStunTurns = pIncomingDmg.getStunTurns();

		}
		if (pIncomingDmg.isBuffed()) {

			mBuffed = true;
			mBuff = new Stats();
			mBuff = pIncomingDmg.getBuff();
			mCharacter.AddBuff(mBuff);
			mBuffTurns = pIncomingDmg.getBuffTurns();

		}
		if (pIncomingDmg.isHealed()) {

			mCharacter.HealPlayer(pIncomingDmg.getHealingDone());

		}
	}

	public void ApplyBattleEffects() {

		if (mBleeding) {
			// Damage over time
			mCharacter.TakeDamage(mBleedDamage);
			writeToScreen(mCharacter.getName() + " is bleeding and recieved " + mBleedDamage + " damage.");
			mBleedTurns -= 1;
			if (mBleedTurns == 0) {
				mBleeding = false;
				mBleedDamage = 0;
			}
			
		}
		if (mBlinded) {
			// Chance to miss
		}
		if (mBurning) {
			// Damage over time
			mCharacter.TakeDamage(mBurnDamage);
			writeToScreen(mCharacter.getName() + " was burned and recieved " + mBurnDamage + " damage.");
			mBurnTurns -= 1;
			if (mBurnTurns == 0) {
				mBurning = false;
				mBurnDamage = 0;
			}
		}
		if (mChilled) {
			// Lower Armor
			mChillTurns -= 1;
			if (mChillTurns == 0) {

				mChillArmorReduction.setArmor(mChillArmorReduction.getArmor()
						* -1);
				mCharacter.AddBuff(mChillArmorReduction);
				mChilled = false;
			}else{
				writeToScreen(mCharacter.getName() + " is chilled and has their armor reduced");
			}
		}
		if (mDazed) {
			// Lower Damage
			mDazeTurns -= 1;
			if (mDazeTurns == 0) {

				mDazeDamageReduction.setDamage(mDazeDamageReduction.getDamage()
						* -1);
				mCharacter.AddBuff(mDazeDamageReduction);
				mDazed = false;
			}else{
				writeToScreen(mCharacter.getName() + " is dazed and has their damage reduced");
			}
		}
		if (mPoisoned) {
			// Damage over time
			mCharacter.TakeDamage(mPoisonDamage);
			writeToScreen(mCharacter.getName() + " is poisoned and recieved " + mPoisonDamage + " damage.");
			mPoisonTurns -= 1;
			if (mBleedTurns == 0) {
				mPoisoned = false;
				mPoisonDamage = 0;
			}
		}
		if (mStunned) {
			// Blocks Character turn
			hasTurn = false;
			writeToScreen(mCharacter.getName() + " is stunned");
			mStunTurns -= 1;
			if (mStunTurns == 0) {
				mStunned = false;
			}
		}
		if (mBuffed) {
			// Add to stats
			mBuffTurns -= 1;
			if (mBuffTurns == 0) {
				mBuff.setStrength(mBuff.getStrength() * -1);
				mBuff.setDexterity(mBuff.getDexterity() * -1);
				mBuff.setIntelligence(mBuff.getIntelligence() * -1);
				mBuff.setVitality(mBuff.getVitality() * -1);
				mBuff.setDamage(mBuff.getDamage() * -1);
				mBuff.setArmor(mBuff.getArmor() * -1);

				mCharacter.AddBuff(mBuff);
				mBuffed = false;
			}

		}
		
	}
	
	public void writeToScreen(final CharSequence pText) {

		activity.runOnUiThread(new Runnable() {
			public void run() {
				Toast.makeText(activity, pText, Toast.LENGTH_SHORT).show();

			}
		});
	}

		
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
