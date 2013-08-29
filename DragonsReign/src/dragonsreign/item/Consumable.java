package dragonsreign.item;

// TODO: Auto-generated Javadoc
/**
 * The Class Consumable.
 */
public abstract class Consumable extends Item {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m description. */
	protected String mDescription;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new consumable.
	 * 
	 * @param pName
	 *            the name
	 * @param pDescription
	 *            the description
	 */
	public Consumable(String pName, String pDescription) {
		super(pName);
		this.mDescription = pDescription;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return mDescription;
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
