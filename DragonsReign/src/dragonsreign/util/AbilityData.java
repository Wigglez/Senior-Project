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

	public void setDamageDone(int mDamageDone) {
		this.mDamageDone = mDamageDone;
	}

	// Healing
	public int getHealingDone() {
		return mHealingDone;
	}

	public void setHealingDone(int mHealingDone) {
		this.mHealingDone = mHealingDone;
	}

	// Buff
	public Stats getBuff() {
		return mBuff;
	}

	public void setBuff(Stats mBuff) {
		this.mBuff = mBuff;
	}

	// Bleeding
	public boolean ismBleeding() {
		return mBleeding;
	}

	public void setBleeding(boolean mBleeding) {
		this.mBleeding = mBleeding;
	}

	public int getBleedTurns() {
		return mBleedTurns;
	}

	public void setBleedTurns(int mBleedTurns) {
		this.mBleedTurns = mBleedTurns;
	}

	public float getBleedDamage() {
		return mBleedDamage;
	}

	public void setBleedDamage(float mBleedDamage) {
		this.mBleedDamage = mBleedDamage;
	}

	// Blind
	public boolean ismBlinded() {
		return mBlinded;
	}

	public void setBlinded(boolean mBlinded) {
		this.mBlinded = mBlinded;
	}

	public int getBlindTurns() {
		return mBlindTurns;
	}

	public void setBlindTurns(int mBlindTurns) {
		this.mBlindTurns = mBlindTurns;
	}

	// Burn
	public boolean ismBurning() {
		return mBurning;
	}

	public void setBurning(boolean mBurning) {
		this.mBurning = mBurning;
	}

	public int getBurnTurns() {
		return mBurnTurns;
	}

	public void setBurnTurns(int mBurnTurns) {
		this.mBurnTurns = mBurnTurns;
	}

	public float getBurnDamage() {
		return mBurnDamage;
	}

	public void setBurnDamage(float mBurnDamage) {
		this.mBurnDamage = mBurnDamage;
	}

	// Chilled
	public boolean ismChilled() {
		return mChilled;
	}

	public void setChilled(boolean mChilled) {
		this.mChilled = mChilled;
	}

	public int getChillTurns() {
		return mChillTurns;
	}

	public void setChillTurns(int mChillTurns) {
		this.mChillTurns = mChillTurns;
	}

	// Dazed
	public boolean ismDazed() {
		return mDazed;
	}

	public void setDazed(boolean mDazed) {
		this.mDazed = mDazed;
	}

	public int getDazeTurns() {
		return mDazeTurns;
	}

	public void setDazeTurns(int mDazeTurns) {
		this.mDazeTurns = mDazeTurns;
	}

	// Poison
	public boolean ismPoisoned() {
		return mPoisoned;
	}

	public void setPoisoned(boolean mPoisoned) {
		this.mPoisoned = mPoisoned;
	}

	public int getPoisonTurns() {
		return mPoisonTurns;
	}

	public void setPoisonTurns(int mPoisonTurns) {
		this.mPoisonTurns = mPoisonTurns;
	}

	public float getPoisonDamage() {
		return mPoisonDamage;
	}

	public void setPoisonDamage(float mPoisonDamage) {
		this.mPoisonDamage = mPoisonDamage;
	}

	// Stun
	public boolean ismStunned() {
		return mStunned;
	}

	public void setStunned(boolean mStunned) {
		this.mStunned = mStunned;
	}

	public int getStunTurns() {
		return mStunTurns;
	}

	public void setStunTurns(int mStunTurns) {
		this.mStunTurns = mStunTurns;
	}

}
