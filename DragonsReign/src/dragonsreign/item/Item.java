package dragonsreign.item;

import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.region.ITextureRegion;

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
	
	protected ITextureRegion mIcon;

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
	
	public ITextureRegion getIcon(){
		return mIcon;
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
