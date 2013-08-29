/*
 * 
 */
package dragonsreign.item;

import dragonsreign.util.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemEquipment.
 */
public class Gear extends Item {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m stats. */
	protected Stats mItemStats;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new gear.
	 * 
	 * @param pName
	 *            the name
	 * @param pStrength
	 *            the strength
	 * @param pDexterity
	 *            the dexterity
	 * @param pIntelligence
	 *            the intelligence
	 * @param pVitality
	 *            the vitality
	 * @param pDamage
	 *            the damage
	 * @param pArmor
	 *            the armor
	 */
	public Gear(String pName, int pStrength, int pDexterity, int pIntelligence,
			int pVitality, int pDamage, int pArmor) {
		super(pName);

		this.mItemStats.setStrength(pStrength);
		this.mItemStats.setDexterity(pDexterity);
		this.mItemStats.setIntelligence(pIntelligence);
		this.mItemStats.setVitality(pVitality);
		this.mItemStats.setDamage(pDamage);
		this.mItemStats.setArmor(pArmor);

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Gets the stats.
	 * 
	 * @return the stats
	 */
	public Stats getItemStats() {
		return mItemStats;
	}

	/**
	 * Sets the stats.
	 * 
	 * @param pItemStats
	 *            the new stats
	 */
	public void setItemStats(Stats pItemStats) {
		this.mItemStats = pItemStats;
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
