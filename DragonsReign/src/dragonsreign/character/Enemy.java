package dragonsreign.character;

import dragonsreign.item.Item;
import dragonsreign.util.Stats;

// TODO: Auto-generated Javadoc
/**
 * The Class Enemy.
 */
public class Enemy extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m level. */
	protected int mLevel;

	/** The m base stats. */
	protected Stats mBaseStats;

	/** The m item drop. */
	protected Item mItemDrop;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new enemy.
	 */
	public Enemy() {
		mLevel = 0;

		mBaseStats.setStrength(0);
		mBaseStats.setArmor(0);
		mBaseStats.setDamage(0);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Gets the level.
	 * 
	 * @return the level
	 */
	public int getLevel() {
		return mLevel;
	}

	/**
	 * Sets the level.
	 * 
	 * @param pLevel
	 *            the new level
	 */
	public void setLevel(int pLevel) {
		this.mLevel = pLevel;
	}

	/**
	 * Gets the item drop.
	 * 
	 * @return the item drop
	 */
	public Item getItemDrop() {
		return mItemDrop;
	}

	/**
	 * Sets the item drop.
	 * 
	 * @param pItemDrop
	 *            the new item drop
	 */
	public void setItemDrop(Item pItemDrop) {
		this.mItemDrop = pItemDrop;
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
