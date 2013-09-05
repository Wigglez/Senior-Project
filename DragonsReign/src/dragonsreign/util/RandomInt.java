package dragonsreign.util;

import java.util.Random;

public class RandomInt {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	static Random mRandom;
	
	// ===========================================================
	// Constructors
	// ===========================================================

	public RandomInt() {
		
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Returns a psuedo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param pMinVal Minimum value.
	 * @param pMaxVal Maximum value.  Must be greater than min.
	 * @return Integer between pMinVal and pMaxVal, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int generateRandomInt(int pMinVal, int pMaxVal) {
		mRandom = new Random();

		// nextInt is normally exclusive of the top value (pMaxVal), so add 1 to
		// make it inclusive

		int randomNumber = mRandom.nextInt((pMaxVal - pMinVal) + 1) + pMinVal;
		
		return randomNumber;
	}
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
