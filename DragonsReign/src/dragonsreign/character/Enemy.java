package dragonsreign.character;

import java.io.StringReader;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import dragonsreign.util.RandomInt;
import dragonsreign.util.enums.ENEMIES;
import dragonsreign.util.enums.HASTE;
import dragonsreign.util.xml.EnemyHandler;
import dragonsreign.util.xml.MinimizeXMLParser;

public class Enemy extends Character {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// Enemies enumeration
	protected ENEMIES mEnemy;

	// The amount of enemies in a battle
	protected int mEnemyCount;

	// Gold that the enemy gives
	protected int mGoldReward;

	// Experience that the enemy gives
	protected int mExperienceReward;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Enemy() {
		mEnemyCount = 0;
		mGoldReward = 0;
		mExperienceReward = 0;
	}

	public Enemy(int pPlayerLevel) {
		// TODO
		// Figure out goldreward and experiencereward scaling

		switch (mEnemy) {
		// PLAINS [0-19]
		case ENEMY_TRIBESMAN:
			mID = 0;
			mName = "Tribesman";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Spear Toss";
			mBaseResources.setHealth(50);

			break;

		case ENEMY_MAGGOT:
			mID = 1;
			mName = "Maggot";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Bite";
			mBaseResources.setHealth(50);

			break;

		case ENEMY_LION:
			mID = 2;
			mName = "Lion";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Maul"; // Applies a bleed effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_CHEETAH:
			mID = 3;
			mName = "Cheetah";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_FAST;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Pounce"; // Applies a daze effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_RHINO:
			mID = 4;
			mName = "Rhino";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Charge"; // Applies a stun effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_WASP:
			mID = 5;
			mName = "Wasp";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_FAST;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Sting"; // Applies a poison effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_AIR_ELEMENTAL:
			mID = 6;
			mName = "Air Elemental";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_FAST;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Gust"; // Applies a daze effect
			mBaseResources.setHealth(50);

			break;

		// MOUNTAINS [20-39]
		case ENEMY_ESKIMO:
			mID = 20;
			mName = "Eskimo";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "UNDETERMINED"; // GDD has no skill available
			mBaseResources.setHealth(50);

			break;

		case ENEMY_YETI:
			mID = 21;
			mName = "Yeti";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Snowball"; // Applies a chill effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_MAMMOTH:
			mID = 22;
			mName = "Mammoth";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_SLOW;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Charge"; // Applies a stun effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_DIRE_WOLF:
			mID = 23;
			mName = "Dire Wolf";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_FAST;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Go for the Throat"; // Applies a bleed effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_DWARF:
			mID = 24;
			mName = "Dwarf";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Axe Toss";
			mBaseResources.setHealth(50);

			break;

		case ENEMY_RAM:
			mID = 25;
			mName = "Ram";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_FAST;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Headbutt"; // Applies a daze effect
			mBaseResources.setHealth(50);

			break;

		case ENEMY_ICE_ELEMENTAL:
			mID = 26;
			mName = "Ice Elemental";
			mLevel = 1;
			mHaste = HASTE.HASTE_TYPE_NORMAL;
			mExperience = 1;
			mAbility[0] = "Basic Attack";
			mAbility[1] = "Icicle"; // Applies a chill effect
			mBaseResources.setHealth(50);

			break;
		}

		randEnemyCount();
		randEnemyLevels(pPlayerLevel);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// Enemy count
	public int getEnemyCount() {
		return mEnemyCount;
	}

	public void setEnemyCount(int pEnemyCount) {
		this.mEnemyCount = pEnemyCount;
	}

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
	public void useAbility(int pAbilityIndex) {
		// TODO Auto-generated method stub

	}

	// ===========================================================
	// Methods
	// ===========================================================

	// Determines the amount of enemies in the current battle
	public void randEnemyCount() {
		// Randomly pick a number of enemies in a range of 1-3
		int randomNumber = RandomInt.generateRandomInt(1, 3);

		switch (randomNumber) {
		case 1:
			mEnemyCount = 1;

			break;
		case 2:
			mEnemyCount = 2;

			break;
		case 3:
			mEnemyCount = 3;

			break;
		}
	}

	public void randEnemy() {
		// TODO
		// Get player's current zone to dictate which enemies are generated
		// if(mCurrentZone == ZONE_PLAINS)

		// Need to finish
		switch (mEnemyCount) {
		case 1:

		}
	}

	// Determines the levels of all enemies in the current battle
	public void randEnemyLevels(int pPlayerLevel) {
		// Use a range to give one above and one below chance
		int randomNumber = RandomInt.generateRandomInt(1, 3);

		switch (randomNumber) {
		case 1:
			mLevel = pPlayerLevel - 1;

			break;
		case 2:
			mLevel = pPlayerLevel;

			break;
		case 3:
			mLevel = pPlayerLevel + 1;

			break;
		}
	}

	// Currently unused, should be referenced for items
	public void loadEnemies() throws Exception {
		try {
			MinimizeXMLParser parser = new MinimizeXMLParser();
			parser.setElementHandler(new EnemyHandler());
			parser.parse(new InputSource(new StringReader(
					"assets/xml/enemies.xml")));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
