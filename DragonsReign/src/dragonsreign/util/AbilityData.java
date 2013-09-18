package dragonsreign.util;

public class AbilityData {
	// All ability data is temporary data
	protected int mNumOfWaitTurns;
	protected int mDamageDone;
	protected int mHealingDone;
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

	AbilityData() {

		mNumOfWaitTurns = 0;
		mDamageDone = 0;
		mHealingDone = 0;
		mBuff = new Stats();

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

	// Wait turns
	public int getNumOfWaitTurns() {
		return mNumOfWaitTurns;
	}

	public void setNumOfWaitTurns(int pNumOfWaitTurns) {
		this.mNumOfWaitTurns = pNumOfWaitTurns;
	}

	// Damage
	public int getDamageDone() {
		return mDamageDone;
	}

	public void setDamageDone(int pDamageDone) {
		this.mDamageDone = pDamageDone;
	}

	// Healing
	public int getHealingDone() {
		return mHealingDone;
	}

	public void setHealingDone(int pHealingDone) {
		this.mHealingDone = pHealingDone;
	}

	// Buff
	public Stats getBuff() {
		return mBuff;
	}

	public void setBuff(Stats pBuff) {
		this.mBuff = pBuff;
	}

	public int getBuffTurns() {
		return mBuffTurns;
	}

	public void setBuffTurns(int pBuffTurns) {
		this.mBuffTurns = pBuffTurns;
	}
	
	public boolean isBuffed() {
		return mBleeding;
	}

	public void setBuffed(boolean pBleeding) {
		this.mBleeding = pBleeding;
	}

	// Bleeding
	public boolean isBleeding() {
		return mBleeding;
	}

	public void setBleeding(boolean pBleeding) {
		this.mBleeding = pBleeding;
	}

	public int getBleedTurns() {
		return mBleedTurns;
	}

	public void setBleedTurns(int pBleedTurns) {
		this.mBleedTurns = pBleedTurns;
	}

	public float getBleedDamage() {
		return mBleedDamage;
	}

	public void setBleedDamage(float pBleedDamage) {
		this.mBleedDamage = pBleedDamage;
	}

	// Blind
	public boolean ismBlinded() {
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

	// Burn
	public boolean ismBurning() {
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

	public float getBurnDamage() {
		return mBurnDamage;
	}

	public void setBurnDamage(float pBurnDamage) {
		this.mBurnDamage = pBurnDamage;
	}

	// Chilled
	public boolean ismChilled() {
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

	// Dazed
	public boolean ismDazed() {
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

	// Poison
	public boolean ismPoisoned() {
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

	public float getPoisonDamage() {
		return mPoisonDamage;
	}

	public void setPoisonDamage(float pPoisonDamage) {
		this.mPoisonDamage = pPoisonDamage;
	}

	// Stun
	public boolean ismStunned() {
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

}
