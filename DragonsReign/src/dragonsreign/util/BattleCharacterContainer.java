package dragonsreign.util;

import dragonsreign.character.Character;

// TODO: Auto-generated Javadoc
/**
 * The Class BattleCharacterContainer.
 */
public class BattleCharacterContainer {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mNumOfWaitTurns;

	protected Stats mBuff;

	protected boolean mBleeding;
	protected boolean mBlinded;
	protected boolean mBurning;
	protected boolean mChilled;
	protected boolean mDazed;
	protected boolean mPoisoned;
	protected boolean mStunned;

	protected int mBleedTurns;
	protected int mBlindTurns;
	protected int mBurnTurns;
	protected int mChillTurns;
	protected int mDazeTurns;
	protected int mPoisonTurns;
	protected int mStunTurns;

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

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	public void ClearBattleEffects(){
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
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
