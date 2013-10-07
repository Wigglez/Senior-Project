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
	
	protected int mExperience;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Resources() {
		mHealth = 0;
		mResource = 0;
		mExperience = 0;
	}
	
	public Resources(int pHealth, int pResource, int pExperience) {
		mHealth = pHealth;
		mResource = pResource;
		mExperience = pExperience;
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
	
	public int getExperience() {
		return mExperience;
	}

	public void setExperience(int pExperience) {
		this.mExperience = pExperience;
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
