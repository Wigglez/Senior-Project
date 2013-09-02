package dragonsreign.item.consumable;

import dragonsreign.item.Item;
import dragonsreign.util.enums.POTIONS;

/**
 * The Class Potion.
 */
public class Potion extends Item {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m potion id. */
	protected POTIONS mPotionID;	
	
	

	/** The m amount restored. */
	protected float mAmountRestored;

	// ===========================================================
	// Constructors
	// ===========================================================

	
	public Potion(POTIONS pPotionID) {
		mPotionID = pPotionID;
		
		switch (mPotionID) {

		case MINOR_HEALTH_POTION:
			// MINOR_HEALTH_POTION
			mName = "Minor Health Potion";
			mDescription = "Restores a small portion of health.";
			
			mAmountRestored = 0.25f;
			
			//mSprite = ResourceManager.do stuff

		case MAJOR_HEALTH_POTION:
			// MAJOR_HEALTH_POTION
			mName = "Major Health Potion";
			mDescription = "Restores a medium portion of health.";
			
			mAmountRestored = 0.5f;
			
			//mSprite = ResourceManager.do stuff

		case SUPERIOR_HEALTH_POTION:
			// SUPERIOR_HEALTH_POTION
			mName = "Superior Health Potion";
			mDescription = "Restores a large portion of health.";
			
			mAmountRestored = 0.75f;
			
			//mSprite = ResourceManager.do stuff

		case MINOR_RESOURCE_POTION:
			// MINOR_RESOURCE_POTION
			mName = "Minor Resource Potion";
			mDescription = "Restores a small portion of resource.";
			
			mAmountRestored = 0.25f;
			
			//mSprite = ResourceManager.do stuff

		case MAJOR_RESOURCE_POTION:
			// MAJOR_RESOURCE_POTION
			mName = "Major Resource Potion";
			mDescription = "Restores a medium portion of resource.";
			
			mAmountRestored = 0.5f;
			
			//mSprite = ResourceManager.do stuff

		case SUPERIOR_RESOURCE_POTION:
			// SUPERIOR_RESOURCE_POTION
			mName = "Superior Resource Potion";
			mDescription = "Restores a large portion of resource.";
			
			mAmountRestored = 0.75f;
			
			//mSprite = ResourceManager.do stuff

		case ANTIDOTE_POTION:
			// ANTIDOTE_POTION
			mName = "Antidote";
			mDescription = "Remove all battle effects.";
			
			mAmountRestored = 0;
			
			//mSprite = ResourceManager.do stuff

		case BASIC_REVIVE_POTION:
			// BASIC_REVIVE_POTION
			mName = "Basic Revive";
			mDescription = "Revive a fallen party member to half health.";
			
			mAmountRestored = 0.5f;
			
			//mSprite = ResourceManager.do stuff

		case FULL_REVIVE_POTION:
			// FULL_REVIVE_POTION
			mName = "Full Revive";
			mDescription = "Revive a fallen party member to full health.";
			
			mAmountRestored = 1.0f;
			
			//mSprite = ResourceManager.do stuff
		}

		
	}

	
	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	public POTIONS getmPotionID() {
		return mPotionID;
	}
	
	public float getmAmountRestored() {
		return mAmountRestored;
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
