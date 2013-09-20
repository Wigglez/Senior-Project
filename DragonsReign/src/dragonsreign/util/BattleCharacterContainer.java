package dragonsreign.util;

import dragonsreign.character.Character;
import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.consumable.Potion;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.HASTE;

public class BattleCharacterContainer {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private Character mCharacter;

	protected int mNumOfWaitTurns;

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

	protected float mBleedDamage;
	protected float mBurnDamage;
	protected float mPoisonDamage;

	// ===========================================================
	// Constructors
	// ===========================================================

	public BattleCharacterContainer() {

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public Character getCharacter() {
		return mCharacter;
	}

	public int getmNumOfWaitTurns() {
		return mNumOfWaitTurns;
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

	public HASTE getHasate() {
		return mCharacter.getHaste();
	}

	public int getHealth() {
		return mCharacter.getCurrentResources().getHealth();
	}

	public int getResource() {
		return mCharacter.getCurrentResources().getResource();
	}

	public boolean isDead() {
		return mCharacter.isDead();
	}

	public String[] getAbilityNames() {
		return mCharacter.getAbility();
	}

	public ABILITYFLAGS useAbility(int pAbilityIndex, AbilityData pAbilityData) {
		return mCharacter.useAbility(pAbilityIndex, pAbilityData);
	}

	public boolean useItem(Potion pPotion) {
		return ((PlayerCharacter) mCharacter).useItem(pPotion);
	}

	public void takeDamage(AbilityData pIncomingDmg) {
		// mCharacter.takeDamage()??

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
			mBlindTurns = pIncomingDmg.getChillTurns();

		}
		if (pIncomingDmg.isDazed()) {

			mDazed = true;
			mDazeTurns = pIncomingDmg.getDazeTurns();

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
			mBuff = pIncomingDmg.getBuff();
			mCharacter.AddBuff(mBuff);
			mBuffTurns = pIncomingDmg.getBuffTurns();

		}
		if (pIncomingDmg.isHealed()) {

			// mCharacter.Heal(pIncomingDmg.getHealingDone();

		}
	}

	public void ApplyBattleEffects() {

		if (mBleeding) {
		}
		if (mBlinded) {
		}
		if (mBurning) {
		}
		if (mChilled) {
		}
		if (mDazed) {
		}
		if (mPoisoned) {
		}
		if (mStunned) {
		}
		if (mBuffed) {
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
