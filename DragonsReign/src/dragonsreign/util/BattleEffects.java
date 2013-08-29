package dragonsreign.util;

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

	/** The m bleeding. */
	protected boolean mBleeding;

	/** The m blinded. */
	protected boolean mBlinded;

	/** The m burning. */
	protected boolean mBurning;

	/** The m chilled. */
	protected boolean mChilled;

	/** The m dazed. */
	protected boolean mDazed;

	/** The m poisoned. */
	protected boolean mPoisoned;

	/** The m stunned. */
	protected boolean mStunned;

	/** The m bleed turns. */
	protected int mBleedTurns;

	/** The m blind turns. */
	protected int mBlindTurns;

	/** The m burn turns. */
	protected int mBurnTurns;

	/** The m chill turns. */
	protected int mChillTurns;

	/** The m daze turns. */
	protected int mDazeTurns;

	/** The m poison turns. */
	protected int mPoisonTurns;

	/** The m stun turns. */
	protected int mStunTurns;

	/** The m bleed damage. */
	protected float mBleedDamage;

	/** The m burn damage. */
	protected float mBurnDamage;

	/** The m poison damage. */
	protected float mPoisonDamage;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new battle effects.
	 */
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

	/**
	 * Checks if is bleeding.
	 * 
	 * @return true, if is bleeding
	 */
	public boolean isBleeding() {
		return mBleeding;
	}

	/**
	 * Sets the bleeding.
	 * 
	 * @param pBleeding
	 *            the new bleeding
	 */
	public void setBleeding(boolean pBleeding) {
		this.mBleeding = pBleeding;
	}

	/**
	 * Gets the bleed damage.
	 * 
	 * @return the bleed damage
	 */
	public float getBleedDamage() {
		return mBleedDamage;
	}

	/**
	 * Sets the bleed damage.
	 * 
	 * @param pBleedDamage
	 *            the new bleed damage
	 */
	public void setBleedDamage(float pBleedDamage) {
		this.mBleedDamage = pBleedDamage;
	}

	/**
	 * Gets the bleed turns.
	 * 
	 * @return the bleed turns
	 */
	public int getBleedTurns() {
		return mBleedTurns;
	}

	/**
	 * Sets the bleed turns.
	 * 
	 * @param pBleedTurns
	 *            the new bleed turns
	 */
	public void setBleedTurns(int pBleedTurns) {
		this.mBleedTurns = pBleedTurns;
	}

	// BLIND

	/**
	 * Checks if is blinded.
	 * 
	 * @return true, if is blinded
	 */
	public boolean isBlinded() {
		return mBlinded;
	}

	/**
	 * Sets the blinded.
	 * 
	 * @param pBlinded
	 *            the new blinded
	 */
	public void setBlinded(boolean pBlinded) {
		this.mBlinded = pBlinded;
	}

	/**
	 * Gets the blind turns.
	 * 
	 * @return the blind turns
	 */
	public int getBlindTurns() {
		return mBlindTurns;
	}

	/**
	 * Sets the blind turns.
	 * 
	 * @param pBlindTurns
	 *            the new blind turns
	 */
	public void setBlindTurns(int pBlindTurns) {
		this.mBlindTurns = pBlindTurns;
	}

	// BURN

	/**
	 * Checks if is burning.
	 * 
	 * @return true, if is burning
	 */
	public boolean isBurning() {
		return mBurning;
	}

	/**
	 * Sets the burning.
	 * 
	 * @param pBurning
	 *            the new burning
	 */
	public void setBurning(boolean pBurning) {
		this.mBurning = pBurning;
	}

	/**
	 * Gets the burn turns.
	 * 
	 * @return the burn turns
	 */
	public int getBurnTurns() {
		return mBurnTurns;
	}

	/**
	 * Sets the burn turns.
	 * 
	 * @param pBurnTurns
	 *            the new burn turns
	 */
	public void setBurnTurns(int pBurnTurns) {
		this.mBurnTurns = pBurnTurns;
	}

	// CHILL

	/**
	 * Checks if is chilled.
	 * 
	 * @return true, if is chilled
	 */
	public boolean isChilled() {
		return mChilled;
	}

	/**
	 * Sets the chilled.
	 * 
	 * @param pChilled
	 *            the new chilled
	 */
	public void setChilled(boolean pChilled) {
		this.mChilled = pChilled;
	}

	/**
	 * Gets the chill turns.
	 * 
	 * @return the chill turns
	 */
	public int getChillTurns() {
		return mChillTurns;
	}

	/**
	 * Sets the chill turns.
	 * 
	 * @param pChillTurns
	 *            the new chill turns
	 */
	public void setChillTurns(int pChillTurns) {
		this.mChillTurns = pChillTurns;
	}

	// DAZE

	/**
	 * Checks if is dazed.
	 * 
	 * @return true, if is dazed
	 */
	public boolean isDazed() {
		return mDazed;
	}

	/**
	 * Sets the dazed.
	 * 
	 * @param pDazed
	 *            the new dazed
	 */
	public void setDazed(boolean pDazed) {
		this.mDazed = pDazed;
	}

	/**
	 * Gets the daze turns.
	 * 
	 * @return the daze turns
	 */
	public int getDazeTurns() {
		return mDazeTurns;
	}

	/**
	 * Sets the daze turns.
	 * 
	 * @param pDazeTurns
	 *            the new daze turns
	 */
	public void setDazeTurns(int pDazeTurns) {
		this.mDazeTurns = pDazeTurns;
	}

	// POISON

	/**
	 * Checks if is poisoned.
	 * 
	 * @return true, if is poisoned
	 */
	public boolean isPoisoned() {
		return mPoisoned;
	}

	/**
	 * Sets the poisoned.
	 * 
	 * @param pPoisoned
	 *            the new poisoned
	 */
	public void setPoisoned(boolean pPoisoned) {
		this.mPoisoned = pPoisoned;
	}

	/**
	 * Gets the poison turns.
	 * 
	 * @return the poison turns
	 */
	public int getPoisonTurns() {
		return mPoisonTurns;
	}

	/**
	 * Sets the poison turns.
	 * 
	 * @param pPoisonTurns
	 *            the new poison turns
	 */
	public void setPoisonTurns(int pPoisonTurns) {
		this.mPoisonTurns = pPoisonTurns;
	}

	// STUN

	/**
	 * Checks if is stunned.
	 * 
	 * @return true, if is stunned
	 */
	public boolean isStunned() {
		return mStunned;
	}

	/**
	 * Sets the stunned.
	 * 
	 * @param pStunned
	 *            the new stunned
	 */
	public void setStunned(boolean pStunned) {
		this.mStunned = pStunned;
	}

	/**
	 * Gets the stun turns.
	 * 
	 * @return the stun turns
	 */
	public int getStunTurns() {
		return mStunTurns;
	}

	/**
	 * Sets the stun turns.
	 * 
	 * @param pStunTurns
	 *            the new stun turns
	 */
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
