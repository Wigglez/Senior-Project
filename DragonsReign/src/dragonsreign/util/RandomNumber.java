package dragonsreign.util;

import java.util.Random;

public class RandomNumber {
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

	public RandomNumber() {

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
	 * Returns a psuedo-random number between min and max, inclusive. The
	 * difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 * 
	 * @param pMinVal
	 *            Minimum value.
	 * @param pMaxVal
	 *            Maximum value. Must be greater than min.
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

	public static float generateRandomFloat(float pMinVal, float pMaxVal) {
		mRandom = new Random();

		// nextfloat is normally exclusive of the top value (pMaxVal), so add 1
		// to
		// make it inclusive

		int rndFlt = generateRandomInt((int) (pMinVal * 100),
				(int) (pMaxVal * 100));

		float randomNumber = (float) rndFlt / 100.0f;

		return randomNumber;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
