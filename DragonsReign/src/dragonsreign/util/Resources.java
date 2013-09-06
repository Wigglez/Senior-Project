package dragonsreign.util;

public class Resources {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected int mHealth;
	
	protected int mResource;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Resources() {
		mHealth = 0;
		mResource = 0;
	}
	
	public Resources(int pHealth, int pResource) {
		mHealth = pHealth;
		mResource = pResource;
	}
	
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public int getHealth() {
		return mHealth;
	}

	public void setHealth(int pHealth) {
		this.mHealth = pHealth;
	}

	public int getResource() {
		return mResource;
	}

	public void setResource(int pResource) {
		this.mResource = pResource;
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
