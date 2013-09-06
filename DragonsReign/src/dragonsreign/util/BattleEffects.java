package dragonsreign.util;

import dragonsreign.character.Character;
// TODO: Auto-generated Javadoc
/**
 * The Class BattleEffects.
 */
public class BattleEffects {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

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
	
	Character mCharacter;

	// ===========================================================
	// Constructors
	// ===========================================================

	public BattleEffects() {
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
	// Getter & Setter
	// ===========================================================

	// BLEED
	public boolean isBleeding() {
		return mBleeding;
	}

	public void setBleeding(boolean pBleeding) {
		this.mBleeding = pBleeding;
	}

	public float getBleedDamage() {
		return mBleedDamage;
	}

	public void setBleedDamage(float pBleedDamage) {
		this.mBleedDamage = pBleedDamage;
	}

	public int getBleedTurns() {
		return mBleedTurns;
	}

	public void setBleedTurns(int pBleedTurns) {
		this.mBleedTurns = pBleedTurns;
	}

	// BLIND
	public boolean isBlinded() {
		return mBlinded;
	}

	public void setBlinded(boolean pBlinded) {
		this.mBlinded = pBlinded;
	}

	public int getBlindTurns() {
		return mBlindTurns;
	}

	public void setBlindTurns(int pBlindTurns) {
		this.mBlindTurns = pBlindTurns;
	}

	// BURN
	public boolean isBurning() {
		return mBurning;
	}

	public void setBurning(boolean pBurning) {
		this.mBurning = pBurning;
	}

	public int getBurnTurns() {
		return mBurnTurns;
	}

	public void setBurnTurns(int pBurnTurns) {
		this.mBurnTurns = pBurnTurns;
	}

	// CHILL
	public boolean isChilled() {
		return mChilled;
	}

	public void setChilled(boolean pChilled) {
		this.mChilled = pChilled;
	}

	public int getChillTurns() {
		return mChillTurns;
	}

	public void setChillTurns(int pChillTurns) {
		this.mChillTurns = pChillTurns;
	}

	// DAZE
	public boolean isDazed() {
		return mDazed;
	}

	public void setDazed(boolean pDazed) {
		this.mDazed = pDazed;
	}

	public int getDazeTurns() {
		return mDazeTurns;
	}

	public void setDazeTurns(int pDazeTurns) {
		this.mDazeTurns = pDazeTurns;
	}

	// POISON
	public boolean isPoisoned() {
		return mPoisoned;
	}

	public void setPoisoned(boolean pPoisoned) {
		this.mPoisoned = pPoisoned;
	}

	public int getPoisonTurns() {
		return mPoisonTurns;
	}

	public void setPoisonTurns(int pPoisonTurns) {
		this.mPoisonTurns = pPoisonTurns;
	}

	// STUN
	public boolean isStunned() {
		return mStunned;
	}

	public void setStunned(boolean pStunned) {
		this.mStunned = pStunned;
	}

	public int getStunTurns() {
		return mStunTurns;
	}

	public void setStunTurns(int pStunTurns) {
		this.mStunTurns = pStunTurns;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
