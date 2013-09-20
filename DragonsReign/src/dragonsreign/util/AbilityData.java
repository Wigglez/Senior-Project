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
	protected boolean mHealed;

	protected int mBleedTurns;
	protected int mBlindTurns;
	protected int mBurnTurns;
	protected int mChillTurns;
	protected int mDazeTurns;
	protected int mPoisonTurns;
	protected int mStunTurns;
	protected int mBuffTurns;
	protected int mHealTurns;

	protected int mBleedDamage;
	protected int mBurnDamage;
	protected int mPoisonDamage;

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
		mBuffed = false;
		mHealed = false;

		mBleedTurns = 0;
		mBlindTurns = 0;
		mBurnTurns = 0;
		mChillTurns = 0;
		mDazeTurns = 0;
		mPoisonTurns = 0;
		mStunTurns = 0;
		mBuffTurns = 0;
		mHealTurns = 0;

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
	
	public int getHealTurns() {
		return mBleedTurns;
	}

	public void setHealTurns(int pHealTurns) {
		this.mHealTurns = pHealTurns;
	}
	
	public boolean isHealed() {
		return mHealed;
	}

	public void setHealed(boolean pHealed) {
		this.mHealed = pHealed;
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
		return mBuffed;
	}

	public void setBuffed(boolean pBuffed) {
		this.mBuffed = pBuffed;
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

	public int getBleedDamage() {
		return mBleedDamage;
	}

	public void setBleedDamage(int pBleedDamage) {
		this.mBleedDamage = pBleedDamage;
	}

	// Blind
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

	// Burn
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

	public int getBurnDamage() {
		return mBurnDamage;
	}

	public void setBurnDamage(int pBurnDamage) {
		this.mBurnDamage = pBurnDamage;
	}

	// Chilled
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

	// Dazed
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

	// Poison
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

	public int getPoisonDamage() {
		return mPoisonDamage;
	}

	public void setPoisonDamage(int pPoisonDamage) {
		this.mPoisonDamage = pPoisonDamage;
	}

	// Stun
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

}
