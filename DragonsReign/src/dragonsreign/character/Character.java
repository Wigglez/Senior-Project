/*
 * 
 */
package dragonsreign.character;

import dragonsreign.util.Resources;
import dragonsreign.util.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class Character.
 */
public abstract class Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m base resources. */
	protected Resources mBaseResources;

	/** The m max resources. */
	protected Resources mMaxResources;

	/** The m base stats. */
	protected Stats mBaseStats;

	/** The m max stats. */
	protected Stats mMaxStats;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new character.
	 */
	public Character() {
		mBaseResources = new Resources();
		mBaseStats = new Stats();

		mBaseResources.setHealth(0);
		mBaseResources.setResource(0);

		mBaseStats.setStrength(0);
		mBaseStats.setDexterity(0);
		mBaseStats.setIntelligence(0);
		mBaseStats.setVitality(0);
		mBaseStats.setDamage(0);
		mBaseStats.setArmor(0);

		// Sets the max to what is currently the base
		mMaxResources = mBaseResources;
		mMaxStats = mBaseStats;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================
	/**
	 * Gets the base resources.
	 * 
	 * @return the base resources
	 */
	public Resources getBaseResources() {
		return mBaseResources;
	}

	/**
	 * Sets the base resources.
	 * 
	 * @param pBaseResources
	 *            the new base resources
	 */
	public void setBaseResources(Resources pBaseResources) {
		this.mBaseResources = pBaseResources;
	}

	/**
	 * Gets the base stats.
	 * 
	 * @return the base stats
	 */
	public Stats getBaseStats() {
		return mBaseStats;
	}

	/**
	 * Sets the base stats.
	 * 
	 * @param pBaseStats
	 *            the new base stats
	 */
	public void setBaseStats(Stats pBaseStats) {
		this.mBaseStats = pBaseStats;
	}

	/**
	 * Gets the max resources.
	 * 
	 * @return the max resources
	 */
	public Resources getMaxResources() {
		return mMaxResources;
	}

	/**
	 * Sets the max resources.
	 * 
	 * @param pMaxResources
	 *            the new max resources
	 */
	public void setMaxResources(Resources pMaxResources) {
		this.mMaxResources = pMaxResources;
	}

	/**
	 * Gets the max stats.
	 * 
	 * @return the max stats
	 */
	public Stats getMaxStats() {
		return mMaxStats;
	}

	/**
	 * Sets the max stats.
	 * 
	 * @param pMaxStats
	 *            the new max stats
	 */
	public void setMaxStats(Stats pMaxStats) {
		this.mMaxStats = pMaxStats;
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