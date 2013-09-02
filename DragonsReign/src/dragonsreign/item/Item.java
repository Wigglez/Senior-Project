package dragonsreign.item;

import org.andengine.entity.sprite.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Item.
 */
public abstract class Item {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected String mName;
	
	protected String mDescription;
	
	protected Sprite mSprite;

	// ===========================================================
	// Constructors
	// ===========================================================

	
	protected Item() {
		
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	
	public String getName() {
		return mName;
	}
	

	public String getDescription() {
		return mDescription;
	}
	
	public Sprite getSprite(){
		return mSprite;
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
