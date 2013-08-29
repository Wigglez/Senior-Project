package dragonsreign.item.consumable;

import dragonsreign.character.PlayerCharacter;
import dragonsreign.item.Consumable;
import dragonsreign.util.BattleEffects;
import dragonsreign.util.Resources;
import dragonsreign.util.enums.POTIONS;

// TODO: Auto-generated Javadoc
/**
 * The Class Potion.
 */
public class Potion extends Consumable {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m potion id. */
	protected POTIONS mPotionID;

	/** The m player. */
	protected PlayerCharacter mPlayer;

	/** The m current resources. */
	protected Resources mCurrentResources;

	/** The m max resources. */
	protected Resources mMaxResources;

	/** The m active battle effects. */
	protected BattleEffects mActiveBattleEffects;

	/** The m potion name. */
	protected String mPotionName;

	/** The m potion used. */
	protected int mPotionUsed;

	/** The m health amount restored. */
	protected float mHealthAmountRestored;

	/** The m resource amount restored. */
	protected float mResourceAmountRestored;

	/** The m revive percent. */
	protected float mRevivePercent;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public Potion(String pName, String pDescription) {
		super(pName, pDescription);

		mCurrentResources = mPlayer.getCurrentResources();
		mMaxResources = mPlayer.getMaxResources();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Gets the health amount restored.
	 * 
	 * @return the health amount restored
	 */
	public float getHealthAmountRestored() {
		return mHealthAmountRestored;
	}

	/**
	 * Sets the health amount restored.
	 * 
	 * @param pHealthAmountRestored
	 *            the new health amount restored
	 */
	public void setHealthAmountRestored(float pHealthAmountRestored) {
		this.mHealthAmountRestored = pHealthAmountRestored;
	}

	/**
	 * Gets the resource amount restored.
	 * 
	 * @return the resource amount restored
	 */
	public float getResourceAmountRestored() {
		return mResourceAmountRestored;
	}

	/**
	 * Sets the resource amount restored.
	 * 
	 * @param pResourceAmountRestored
	 *            the new resource amount restored
	 */
	public void setResourceAmountRestored(float pResourceAmountRestored) {
		this.mResourceAmountRestored = pResourceAmountRestored;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Use potion.
	 * 
	 * @param pPotionID
	 *            the potion id
	 */
	public void UsePotion(int pPotionID) {
		pPotionID = mPotionID.getPotionID();

		switch (pPotionID) {

		case 0:
			// MINOR_HEALTH_POTION
			MinorHealthPotion(getName(), getDescription());

		case 1:
			// MAJOR_HEALTH_POTION
			MajorHealthPotion(getName(), getDescription());

		case 2:
			// SUPERIOR_HEALTH_POTION
			SuperiorHealthPotion(getName(), getDescription());

		case 3:
			// MINOR_RESOURCE_POTION
			MinorResourcePotion(getName(), getDescription());

		case 4:
			// MAJOR_RESOURCE_POTION
			MajorResourcePotion(getName(), getDescription());

		case 5:
			// SUPERIOR_RESOURCE_POTION
			SuperiorResourcePotion(getName(), getDescription());

		case 6:
			// ANTIDOTE_POTION
			AntidotePotion(getName(), getDescription());

		case 7:
			// BASIC_REVIVE_POTION
			BasicRevivePotion(getName(), getDescription());

		case 8:
			// FULL_REVIVE_POTION
			FullRevivePotion(getName(), getDescription());
		}
	}

	/**
	 * Minor health potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void MinorHealthPotion(String pName, String pDescription) {
		pName = "Minor Health Potion";
		pDescription = "Restores a small portion of health.";

		if (mCurrentResources.getHealth() >= mMaxResources.getHealth()) {
			// Output message: "Health is already maxed."
		} else {
			// Gets the current health and adds 30% to it
			mHealthAmountRestored = mCurrentResources.getHealth() * 1.3f;

			// Subtract one of the item
		}
	}

	/**
	 * Major health potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void MajorHealthPotion(String pName, String pDescription) {
		pName = "Major Health Potion";
		pDescription = "Restores a medium portion of health.";

		if (mCurrentResources.getHealth() >= mMaxResources.getHealth()) {
			// Output message: "Health is already maxed."
		} else {
			// Gets the current health and adds 50% to it
			mHealthAmountRestored = mCurrentResources.getHealth() * 1.5f;

			// Subtract one of the item
		}
	}

	/**
	 * Superior health potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void SuperiorHealthPotion(String pName, String pDescription) {
		pName = "Superior Health Potion";
		pDescription = "Restores a large portion of health.";

		if (mCurrentResources.getHealth() >= mMaxResources.getHealth()) {
			// Output message: "Health is already maxed."
		} else {
			// Gets the current health and adds 70% to it
			mHealthAmountRestored = mCurrentResources.getHealth() * 1.7f;

			// Subtract one of the item
		}
	}

	/**
	 * Minor resource potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void MinorResourcePotion(String pName, String pDescription) {
		pName = "Minor Resource Potion";
		pDescription = "Restores a small portion of resource.";

		if (mCurrentResources.getResource() >= mMaxResources.getResource()) {
			// Output message: "Resource is already maxed."
		} else {
			// Gets the current resource and adds 30% to it
			mResourceAmountRestored = mCurrentResources.getResource() * 1.3f;

			// Subtract one of the item
		}
	}

	/**
	 * Major resource potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void MajorResourcePotion(String pName, String pDescription) {
		pName = "Major Resource Potion";
		pDescription = "Restores a medium portion of resource.";

		if (mCurrentResources.getResource() >= mMaxResources.getResource()) {
			// Output message: "Resource is already maxed."
		} else {
			// Gets the current resource and adds 50% to it
			mResourceAmountRestored = mCurrentResources.getResource() * 1.5f;

			// Subtract one of the item
		}
	}

	/**
	 * Superior resource potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void SuperiorResourcePotion(String pName, String pDescription) {
		pName = "Superior Resource Potion";
		pDescription = "Restores a large portion of resource.";

		if (mCurrentResources.getResource() >= mMaxResources.getResource()) {
			// Output message: "Resource is already maxed."
		} else {
			// Gets the current resource and adds 70% to it
			mResourceAmountRestored = mCurrentResources.getResource() * 1.7f;

			// Subtract one of the item
		}
	}

	/**
	 * Antidote potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void AntidotePotion(String pName, String pDescription) {
		pName = "Antidote";
		pDescription = "Remove all battle effects.";

		if (!mActiveBattleEffects.isBleeding()
				|| !mActiveBattleEffects.isBlinded()
				|| !mActiveBattleEffects.isBurning()
				|| !mActiveBattleEffects.isChilled()
				|| !mActiveBattleEffects.isDazed()
				|| !mActiveBattleEffects.isPoisoned()
				|| !mActiveBattleEffects.isStunned()) {

			System.out.println("No battle effects present.");
		} else {
			// remove battle effects
			mActiveBattleEffects.setBleeding(false);
			mActiveBattleEffects.setBlinded(false);
			mActiveBattleEffects.setBurning(false);
			mActiveBattleEffects.setChilled(false);
			mActiveBattleEffects.setDazed(false);
			mActiveBattleEffects.setPoisoned(false);
			mActiveBattleEffects.setStunned(false);

			// Subtract one of the item
		}
	}

	/**
	 * Basic revive potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void BasicRevivePotion(String pName, String pDescription) {
		pName = "Basic Revive";
		pDescription = "Revive a fallen party member to half health.";

		if (mCurrentResources.getHealth() > 0) {
			// Output message: "Party member is not dead."
		} else {
			mHealthAmountRestored = mMaxResources.getHealth() * 0.5f;

			// Subtract one of the item
		}
	}

	/**
	 * Full revive potion.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public void FullRevivePotion(String pName, String pDescription) {
		pName = "Full Revive";
		pDescription = "Revive a fallen party member to full health.";

		if (mCurrentResources.getHealth() > 0) {
			// Output message: "Party member is not dead."
		} else {
			mHealthAmountRestored = mMaxResources.getHealth();

			// Subtract one of the item
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
