/*
 * Notes: Gear is not balanced properly yet
 * Since all classes are not implemented each armor/weapon
 * has increased stats for the implemented classes(Warrior, Ranger, Cleric)
 * for their respected gear pieces since there is no crossover between them
 */
package dragonsreign.item;

import java.util.Random;

import dragonsreign.manager.ResourceManager;
import dragonsreign.util.RandomNumber;
import dragonsreign.util.Stats;
import dragonsreign.util.enums.ITEMTYPE;

public class Gear extends Item {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	protected Stats mItemStats;

	private ITEMTYPE mItemType;

	private int mItemLevel;

	private boolean isWeapon = false;
	private boolean isArmor = false;

	private int mSlotID;

	// ===========================================================
	// Constructors
	// ===========================================================

	public Gear(ITEMTYPE pItemType, int PlyrLevel) {

		// Item Level can be [PlyrLevel - 2, PlyrLevel + 3]
		int itemLvlDiff = RandomNumber.generateRandomInt(-2, 3);
		mItemLevel = PlyrLevel + itemLvlDiff; // Add difference to player level
		if (mItemLevel < 1)// Sanity check: if PlyrLevel is extremely low item
			mItemLevel = 1; // level might be -1 or 0

		// Set ItemType
		mItemType = pItemType;

		mItemStats = new Stats();

		switch (mItemType) {

		case LIGHT_HELMET:
			// Light Helmet
			// For Cleric & Mage
			// Primary Int, Normal Vit, Low Str/Dex
			// No Damage(Armor Piece)
			// Low Armor range b/c its a light piece
			mName = "Light Helmet";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randLowStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().lightHelm;

			break;
		case LIGHT_CHESTPLATE:
			// Light Chest Plate
			// For Cleric & Mage
			// Primary Int, Normal Vit, Low Str/Dex
			// No Damage(Armor Piece)
			// Low Armor range b/c its a light piece
			mName = "Light Chest Plate";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randLowStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().lightUpper;

			break;
		case LIGHT_LEGS:
			// Light Leg Armor
			// For Cleric & Mage
			// Primary Int, Normal Vit, Low Str/Dex
			// No Damage(Armor Piece)
			// Low Armor range b/c its a light piece
			mName = "Light Leg Armor";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randLowStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().lightLower;

			break;
		case MEDIUM_HELMET:
			// Medium Helmet
			// For Ranger, Assassin, and Engineer
			// Ranger:
			// Primary Dex, Normal Vit, Low Str/Int
			// No Damage(Armor Piece)
			// Medium Armor range b/c its a Medium piece
			mName = "Medium Helmet";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randHighStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randMedStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().mediumHelm;

			break;
		case MEDIUM_CHESTPLATE:
			// Meduim Chest Plate
			// For Ranger, Assassin, and Engineer
			// Ranger:
			// Primary Dex, Normal Vit, Low Str/Int
			// No Damage(Armor Piece)
			// Medium Armor range b/c its a Medium piece
			mName = "Meduim Chest Plate";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randHighStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randMedStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().mediumUpper;

			break;
		case MEDIUM_LEGS:
			// Meduim Leg Armor
			// For Ranger, Assassin, and Engineer
			// Ranger:
			// Primary Dex, Normal Vit, Low Str/Int
			// No Damage(Armor Piece)
			// Medium Armor range b/c its a Medium piece
			mName = "Meduim Leg Armor";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randHighStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randMedStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().mediumLower;

			break;
		case HEAVY_HELMET:
			// Heavy Helmet
			// For Warrior & Knight
			// Warrior:
			// Primary Str, Normal Vit, Low Dex/Int
			// No Damage(Armor Piece)
			// High Armor range b/c its a Heavy piece
			mName = "Heavy Helmet";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randHighStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().heavyHelm;

			break;
		case HEAVY_CHESTPLATE:
			// Heavy Chest Plate
			// For Warrior & Knight
			// Warrior:
			// Primary Str, Normal Vit, Low Dex/Int
			// No Damage(Armor Piece)
			// High Armor range b/c its a Heavy piece
			mName = "Heavy Chest Plate";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randHighStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().heavyUpper;

			break;
		case HEAVY_LEGS:
			// Heavy Leg Armor
			// For Warrior & Knight
			// Warrior:
			// Primary Str, Normal Vit, Low Dex/Int
			// No Damage(Armor Piece)
			// High Armor range b/c its a Heavy piece
			mName = "Heavy Leg Armor";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randHighStat());

			isWeapon = false;
			isArmor = true;

			mIcon = ResourceManager.getInstance().heavyLower;

			break;
		case ONE_HANDED_SWORD:

			// One Handed sword
			// For Warrior, Knight, and Assassin
			mName = "One Handed sword";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().sword_1h;

			break;
		case ONE_HANDED_AXE:
			// One handed axe
			// For Warrior, Knight, and Assassin
			mName = "One handed axe";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().axe_1h;

			break;
		case ONE_HANDED_MACE:
			// One Handed Mace
			// For Warrior, Knight, and Assassin
			mName = "One Handed Mace";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().mace_1h;

			break;
		case TWO_HANDED_SWORD:
			// Two Handed Sword
			// For Warrior
			mName = "Two Handed Sword";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().sword_2h;

			break;
		case TWO_HANDED_AXE:
			// Two Handed Axe
			// For Warrior
			mName = "Two Handed Axe";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().axe_2h;

			break;
		case TWO_HANDED_MACE:
			// Two Handed Maces
			// For Warrior
			mName = "Two Handed Maces";
			mDescription = "";

			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().mace_2h;

			break;
		case LONGBOW:
			// Longbow
			// For Ranger
			mName = "Longbow";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randHighStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().longbow1;

			break;
		case SHORTBOW:
			// Shortbow
			// For Ranger
			mName = "Shortbow";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randHighStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().shortbow;

			break;
		case CROSSBOW:
			// Crossbow
			// For Ranger
			mName = "Crossbow";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randHighStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().crossbow;

			break;
		case WAND:
			// Wand
			// For Cleric & Mage
			mName = "Wand";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randLowStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().wand;

			break;
		case ORB:
			// Orb
			// For Cleric & Mage
			mName = "Orb";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randLowStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().orb;

			break;
		case STAFF:
			// Staff
			// For Cleric & Mage
			mName = "Staff";
			mDescription = "";

			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randLowStat());
			mItemStats.setArmor(0);

			isWeapon = true;
			isArmor = false;

			mIcon = ResourceManager.getInstance().staff;

			break;
		}
	}

	public Gear(ITEMTYPE pItemType, int pItemLevel, int pStr, int pDex,
			int pInt, int pVit, int pDmg, int pArmor, boolean pIsWeapon) {

		// Set ItemType
		mItemType = pItemType;

		mItemStats = new Stats();

		mItemLevel = pItemLevel;

		mItemStats.setStrength(pStr);
		mItemStats.setDexterity(pDex);
		mItemStats.setIntelligence(pInt);
		mItemStats.setVitality(pVit);
		mItemStats.setDamage(pDmg);
		mItemStats.setArmor(pArmor);

		if (pIsWeapon) {
			isWeapon = true;
			isArmor = false;
		} else {
			isWeapon = false;
			isArmor = true;
		}

		switch (mItemType) {

		// TODO
		// get sprites for each case
		case LIGHT_HELMET:
			mName = "Light Helmet";
			mDescription = "";

			mIcon = ResourceManager.getInstance().lightHelm;
			break;
		case LIGHT_CHESTPLATE:
			mName = "Light Chest Plate";
			mDescription = "";

			mIcon = ResourceManager.getInstance().lightUpper;
			break;
		case LIGHT_LEGS:
			mName = "Light Leg Armor";
			mDescription = "";
			mIcon = ResourceManager.getInstance().lightLower;
			break;
		case MEDIUM_HELMET:
			mName = "Medium Helmet";
			mDescription = "";
			mIcon = ResourceManager.getInstance().mediumHelm;
			break;
		case MEDIUM_CHESTPLATE:
			mName = "Meduim Chest Plate";
			mDescription = "";
			mIcon = ResourceManager.getInstance().mediumUpper;
			break;
		case MEDIUM_LEGS:
			mName = "Meduim Leg Armor";
			mDescription = "";
			mIcon = ResourceManager.getInstance().mediumLower;
			break;
		case HEAVY_HELMET:
			mName = "Heavy Helmet";
			mDescription = "";

			mIcon = ResourceManager.getInstance().heavyHelm;
			break;
		case HEAVY_CHESTPLATE:
			mName = "Heavy Chest Plate";
			mDescription = "";
			mIcon = ResourceManager.getInstance().heavyUpper;
			break;
		case HEAVY_LEGS:
			mName = "Heavy Leg Armor";
			mDescription = "";
			mIcon = ResourceManager.getInstance().heavyLower;
			break;
		case ONE_HANDED_SWORD:
			mName = "One Handed sword";
			mDescription = "";
			mIcon = ResourceManager.getInstance().sword_1h;
			break;
		case ONE_HANDED_AXE:
			mName = "One handed axe";
			mDescription = "";
			mIcon = ResourceManager.getInstance().axe_1h;
			break;
		case ONE_HANDED_MACE:
			mName = "One Handed Mace";
			mDescription = "";
			mIcon = ResourceManager.getInstance().mace_1h;
			break;
		case TWO_HANDED_SWORD:
			mName = "Two Handed Sword";
			mDescription = "";
			mIcon = ResourceManager.getInstance().sword_2h;
			break;
		case TWO_HANDED_AXE:
			mName = "Two Handed Axe";
			mDescription = "";
			mIcon = ResourceManager.getInstance().axe_2h;
			break;
		case TWO_HANDED_MACE:
			mName = "Two Handed Maces";
			mDescription = "";
			mIcon = ResourceManager.getInstance().mace_2h;
			break;
		case LONGBOW:
			mName = "Longbow";
			mDescription = "";
			mIcon = ResourceManager.getInstance().longbow1;
			break;
		case SHORTBOW:
			mName = "Shortbow";
			mDescription = "";
			mIcon = ResourceManager.getInstance().shortbow;
			break;
		case CROSSBOW:
			mName = "Crossbow";
			mDescription = "";
			mIcon = ResourceManager.getInstance().crossbow;
			break;
		case WAND:
			mName = "Wand";
			mDescription = "";
			mIcon = ResourceManager.getInstance().wand;
			break;
		case ORB:
			mName = "Orb";
			mDescription = "";
			mIcon = ResourceManager.getInstance().orb;

			break;
		case STAFF:
			mName = "Staff";
			mDescription = "";
			mIcon = ResourceManager.getInstance().staff;
			break;
		}

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public ITEMTYPE getItemType() {
		return mItemType;
	}

	public Stats getItemStats() {
		return mItemStats;
	}

	public boolean isArmor() {
		return isArmor;
	}

	public boolean IsWeapon() {
		return isWeapon;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// Randomly Generate stat between [10-25]
	private int randHighStat() {

		int HighStat = RandomNumber.generateRandomInt(15, 40);
		HighStat += (mItemLevel * 2);
		
		return HighStat;
	}

	// Randomly Generate stat between [1-15]
	private int randMedStat() {

		int MedStat = RandomNumber.generateRandomInt(10, 25);
		MedStat += (mItemLevel * 2);

		return MedStat;
	}

	// Randomly Generate stat between [1-10]
	private int randLowStat() {

		int LowStat = RandomNumber.generateRandomInt(1, 15); 
		LowStat += (mItemLevel * 2);

		return LowStat;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
