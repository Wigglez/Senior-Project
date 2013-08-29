package dragonsreign.item;

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

	/** The m name. */
	protected String mName;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new item.
	 * 
	 * @param pName
	 *            the name
	 */
	protected Item(String pName) {
		this.setName(pName);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return mName;
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the new name
	 */
	public void setName(String pName) {
		this.mName = pName;
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
