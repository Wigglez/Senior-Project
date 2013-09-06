package dragonsreign.util;

public class Stats {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mStrength;
	protected int mDexterity;
	protected int mIntelligence;
	protected int mVitality;
	protected int mDamage;
	protected int mArmor;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Stats() {
		mStrength = 0;
		mDexterity = 0;
		mIntelligence = 0;
		mVitality = 0;
		mDamage = 0;
		mArmor = 0;
	}

	public Stats(int pStrength, int pDexterity, int pIntelligence,
			int pVitality, int pDamage, int pArmor) {
		mStrength = pStrength;
		mDexterity = pDexterity;
		mIntelligence = pIntelligence;
		mVitality = pVitality;
		mDamage = pDamage;
		mArmor = pArmor;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// Strength
	public int getStrength() {
		return mStrength;
	}

	public void setStrength(int pStrength) {
		this.mStrength = pStrength;
	}

	// Dexterity
	public int getDexterity() {
		return mDexterity;
	}

	public void setDexterity(int pDexterity) {
		this.mDexterity = pDexterity;
	}

	// Intelligence
	public int getIntelligence() {
		return mIntelligence;
	}

	public void setIntelligence(int pIntelligence) {
		this.mIntelligence = pIntelligence;
	}

	// Vitality
	public int getVitality() {
		return mVitality;
	}

	public void setVitality(int pVitality) {
		this.mVitality = pVitality;
	}

	// Damage
	public int getDamage() {
		return mDamage;
	}

	public void setDamage(int pDamage) {
		this.mDamage = pDamage;
	}

	// Armor
	public int getArmor() {
		return mArmor;
	}

	public void setArmor(int pArmor) {
		this.mArmor = pArmor;
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
