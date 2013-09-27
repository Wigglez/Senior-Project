package dragonsreign.character;

import dragonsreign.util.AbilityData;
import dragonsreign.util.RandomNumber;
import dragonsreign.util.Resources;
import dragonsreign.util.Stats;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.ENEMIES;
import dragonsreign.util.enums.HASTE;

public class Enemy extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// Enemies enumeration
	protected ENEMIES mEnemyType;

	// Gold that the enemy gives
	protected int mGoldReward;

	// Experience that the enemy gives
	protected int mExperienceReward;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Enemy() {
		mGoldReward = 0;
		mExperienceReward = 0;
	}

	/**
	 * Creates an Enemy specified by pEnemyType Enemy Level, Health, Damage, and
	 * Armor are all scaled off of Player party as a whole
	 * 
	 * @param pPlayerLevel
	 *            Player's current level.
	 * @param pPlayerHealth
	 *            Accumulative party max health.
	 * @param pPlayerDamage
	 *            Accumulative party damage.
	 * @param pPlayerArmor
	 *            Accumulative party armor
	 * @param pEnemyType
	 *            The desired enemy to create
	 */
	public Enemy(int pPlayerLevel, int pPlayerHealth, int pPlayerDamage,
			int pPlayerArmor, ENEMIES pEnemyType) {

		// Player Health/Damage/Armor are sums of party as a whole
		// Average out Attributes
		pPlayerHealth /= 3;
		pPlayerDamage /= 3;
		pPlayerArmor /= 3;

		// TODO
		// Figure out goldreward and experiencereward scaling

		mEnemyType = pEnemyType;
		randEnemyLevel(pPlayerLevel);
		randEnemyExpReward(pPlayerLevel);
		randEnemyHealth(pPlayerHealth);

		switch (mEnemyType) {
		// Damage/Armor Thresholds
		// Slow enemies
		// Damage: .01 - .15
		// Armor: .20 - .50
		//
		// Normal enemies
		// Damage: .10 - .25
		// Armor: .10 - .25

		// Fast enemies
		// Damage: .20 - .50
		// Armor: .01 - .15
		//

		// PLAINS [0-19]
		case ENEMY_TRIBESMAN:
			mID = 0;
			mName = "Tribesman";
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Spear Toss";

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.15f, .20f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.10f, .15f)));

			break;

		case ENEMY_MAGGOT:
			mID = 1;
			mName = "Maggot";
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Bite";

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.05f, .10f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.20f, .35f)));

			break;

		case ENEMY_LION:
			mID = 2;
			mName = "Lion";
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Maul"; // Applies a bleed effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.20f, .25f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.15f, .20f)));

			break;

		case ENEMY_CHEETAH:
			mID = 3;
			mName = "Cheetah";
			mHaste = HASTE.HASTE_TYPE_FAST;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Pounce"; // Applies a daze effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.40f, .50f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.04f, .07f)));

			break;

		case ENEMY_RHINO:
			mID = 4;
			mName = "Rhino";
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Charge"; // Applies a stun effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.01f, .03f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.45f, .50f)));

			break;

		case ENEMY_WASP:
			mID = 5;
			mName = "Wasp";
			mHaste = HASTE.HASTE_TYPE_FAST;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Sting"; // Applies a poison effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.25f, .35f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.07f, .15f)));

			break;

		case ENEMY_AIR_ELEMENTAL:
			mID = 6;
			mName = "Air Elemental";
			mHaste = HASTE.HASTE_TYPE_FAST;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Gust"; // Applies a daze effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.45f, .50f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.10f, .15f)));

			break;

		// MOUNTAINS [20-39]
		case ENEMY_ESKIMO:
			mID = 20;
			mName = "Eskimo";
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Spear Throw";

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.10f, .15f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.15f, .20f)));

			break;

		case ENEMY_YETI:
			mID = 21;
			mName = "Yeti";
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Snowball"; // Applies a chill effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.10f, .15f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.20f, .25f)));

			break;

		case ENEMY_MAMMOTH:
			mID = 22;
			mName = "Mammoth";
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Charge"; // Applies a stun effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.12f, .15f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.35f, .40f)));

			break;

		case ENEMY_DIRE_WOLF:
			mID = 23;
			mName = "Dire Wolf";
			mHaste = HASTE.HASTE_TYPE_FAST;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Go for the Throat"; // Applies a bleed effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.35f, .45f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.07f, .11f)));

			break;

		case ENEMY_DWARF:
			mID = 24;
			mName = "Dwarf";
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Axe Toss";

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.15f, .20f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.10f, .15f)));

			break;

		case ENEMY_RAM:
			mID = 25;
			mName = "Ram";
			mHaste = HASTE.HASTE_TYPE_FAST;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Headbutt"; // Applies a daze effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.20f, .30f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.09f, .13f)));

			break;

		case ENEMY_ICE_ELEMENTAL:
			mID = 26;
			mName = "Ice Elemental";
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Icicle"; // Applies a chill effect

			mCurrentStats.setDamage((int) (pPlayerDamage * RandomNumber
					.generateRandomFloat(.20f, .25f)));
			mCurrentStats.setArmor((int) (pPlayerArmor * RandomNumber
					.generateRandomFloat(.20f, .25f)));

			break;
		}

		//Sanity check
		if(mCurrentStats.getDamage() == 0)
			mCurrentStats.setDamage(1);
		
		if(mCurrentStats.getArmor() == 0)
			mCurrentStats.setArmor(1);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// Gold reward
	public int getGoldReward() {
		return mGoldReward;
	}

	public void setGoldReward(int pGoldReward) {
		this.mGoldReward = pGoldReward;
	}

	// Experience reward
	public int getExperienceReward() {
		return mExperienceReward;
	}

	public void setExperienceReward(int pExperienceReward) {
		this.mExperienceReward = pExperienceReward;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public ABILITYFLAGS useAbility(int pAbilityIndex, AbilityData pAbilityData) {
		if (pAbilityIndex == 0) {
			BasicAttack(pAbilityData);
		}
		if (pAbilityIndex == 1) {
			if (mID == 0 || mID == 1 || mID == 20 || mID == 24) {
				NormalAttack(pAbilityData);
			}
			if (mID == 2 || mID == 23) {
				BleedAttack(pAbilityData);
			}
			// if(){
			// BlindAttack(pAbilityData);
			// }
			// if(){
			// BurnAttack(pAbilityData);
			// }
			if (mID == 21 || mID == 26) {
				ChillAttack(pAbilityData);
			}
			if (mID == 3 || mID == 6 || mID == 25) {
				DazeAttack(pAbilityData);
			}
			if (mID == 5) {
				PoisonAttack(pAbilityData);
			}
			if (mID == 4 || mID == 22) {
				StunAttack(pAbilityData);
			}
		}
		return ABILITYFLAGS.DAMAGE_SINGLE;
	}

	public void BasicAttack(AbilityData pAbilityData) {

		float dmg = RandomNumber.generateRandomFloat(
				mCurrentStats.getDamage() * 0.90f,
				mCurrentStats.getDamage() * 1.10f);

		pAbilityData.setDamageDone((int) dmg);

	}

	public void NormalAttack(AbilityData pAbilityData) {

		float dmg = RandomNumber.generateRandomFloat(
				mCurrentStats.getDamage() * 0.90f,
				mCurrentStats.getDamage() * 1.20f);

		pAbilityData.setDamageDone((int) dmg);

	}

	public void BleedAttack(AbilityData pAbilityData) {

		float dmg = RandomNumber.generateRandomFloat(
				mCurrentStats.getDamage() * 0.30f,
				mCurrentStats.getDamage() * 0.35f);

		pAbilityData.setDamageDone((int) dmg);

		float bleedDmg = RandomNumber.generateRandomFloat(
				mCurrentStats.getDamage() * 0.40f,
				mCurrentStats.getDamage() * 0.45f);

		pAbilityData.setBleedDamage((int) bleedDmg);
		pAbilityData.setBleeding(true);
		pAbilityData.setBleedTurns(2);

	}

	public void BlindAttack(AbilityData pAbilityData) {

		pAbilityData.setBlinded(true);
		pAbilityData.setBlindTurns(2);

	}

	public void BurnAttack(AbilityData pAbilityData) {

	}

	public void ChillAttack(AbilityData pAbilityData) {

		pAbilityData.setChilled(true);
		pAbilityData.setChillTurns(2);

	}

	public void DazeAttack(AbilityData pAbilityData) {

		pAbilityData.setDazed(true);
		pAbilityData.setDazeTurns(2);
	}

	public void PoisonAttack(AbilityData pAbilityData) {

		float poisonDmg = RandomNumber.generateRandomFloat(
				mCurrentStats.getDamage() * 0.50f,
				mCurrentStats.getDamage() * 0.65f);

		pAbilityData.setPoisonDamage((int) poisonDmg);
		pAbilityData.setPoisoned(true);
		pAbilityData.setPoisonTurns(2);

	}

	public void StunAttack(AbilityData pAbilityData) {
		pAbilityData.setStunned(true);
		pAbilityData.setStunTurns(1);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// Determines the amount of enemies in the current battle
	/******************************************************************
	 * *********************************************************************
	 * //TODO Put into battle scene // public void randEnemyCount() { // //
	 * Randomly pick a number of enemies in a range of 1-3 // int randomNumber =
	 * RandomNumber.generateRandomInt(1, 3); // // mEnemyCount = randomNumber;
	 * // }
	 * *********************************************************************
	 */

	// /////////////////////////////////////////////////////////////////////////////////
	// Currently unused, should be referenced for items
	// public void loadEnemies() throws Exception {
	// try {
	// MinimizeXMLParser parser = new MinimizeXMLParser();
	// parser.setElementHandler(new EnemyHandler());
	// parser.parse(new InputSource(new StringReader(
	// "assets/xml/enemies.xml")));
	// } catch (ParserConfigurationException e) {
	// e.printStackTrace();
	// } catch (SAXException e) {
	// e.printStackTrace();
	// } catch (FactoryConfigurationError e) {
	// e.printStackTrace();
	// }
	// }
	// //////////////////////////////////////////////////////////////////////////////////

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	// Determines the levels of all enemies in the current battle
	private void randEnemyLevel(int pPlayerLevel) {
		// Use a range to give one above and one below chance
		int randomNumber = RandomNumber.generateRandomInt(1, 7);

		switch (randomNumber) {
		case 1:
		case 2:
			mLevel = pPlayerLevel - 1;

			break;
		case 3:
		case 4:
		case 5:
			mLevel = pPlayerLevel;

			break;
		case 6:
		case 7:
			mLevel = pPlayerLevel + 1;

			break;
		}
		
		if(mLevel < 1){
			mLevel = 1;
		}
	}

	private void randEnemyExpReward(int pPlayerLevel) {
		int plyExp = 100;
		for (int currentLvl = 2; currentLvl <= pPlayerLevel; currentLvl++) {
			plyExp += mLevel * 68;
		}

		mExperienceReward = (int) (plyExp * RandomNumber.generateRandomFloat(
				.05f, 0.1f));

	}

	// TODO add gold when shops and currency are implemented
	// private void randEnemyGoldReward(int pPlayerLevel) {
	//
	// }

	private void randEnemyHealth(int pPlayerHealth) {
		
		float rndF = RandomNumber.generateRandomFloat(.75f, 1.25f);
		float healthVal = (float) pPlayerHealth
				* rndF;
		mCurrentResources.setHealth((int) healthVal);
		mMaxResources.setHealth((int) healthVal);

	}

}
