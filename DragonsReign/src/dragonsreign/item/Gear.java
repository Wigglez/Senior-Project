/*
 * Notes: Gear is not balanced properly yet
 * Since all classes are not implemented each armor/weapon
 * has increased stats for the implemented classes(Warrior, Ranger, Cleric)
 * for their respected gear pieces since there is no crossover between them
 */
package dragonsreign.item;

import java.util.Random;

import dragonsreign.util.Stats;
import dragonsreign.util.enums.ITEMTYPE;

// TODO: Auto-generated Javadoc
/**
 * The Class Gear.
 */
public class Gear extends Item {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m stats. */
	protected Stats mItemStats;
	
	private ITEMTYPE mItemType;
	
	private int mItemLevel;
	
	private boolean isWeapon = false;
	private boolean isArmor = false;
	
	private int mSlotID;
	

	// ===========================================================
	// Constructors
	// ===========================================================

	
	public Gear(ITEMTYPE pItemType, int PlyrLevel){
		
		Random rand = new Random();
		//Item Level can be [PlyrLevel - 2, PlyrLevel + 3] 
		int itemLvlDiff = rand.nextInt(6); // range is [0,5]
		itemLvlDiff -= 2; // shift range so it can be in [-2, +3]
		mItemLevel = PlyrLevel + itemLvlDiff; //Add difference to player level
		if(mItemLevel < 1)//Sanity check: if PlyrLevel is extremely low item level might be -1 or 0
			mItemLevel = 1;
		
		
		
		//Set ItemType
		mItemType = pItemType;
		
		switch(mItemType){
		
		case LIGHT_HEMLT:
			//Light Helmet
			//For Cleric & Mage
			//Primary Int, Normal Vit, Low Str/Dex
			//No Damage(Armor Piece)
			//Low Armor range b/c its a light piece
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
			
			//mSprite = ResourceManager.do stuff
			
		case LIGHT_CHESTPLATE:
			//Light Chest Plate
			//For Cleric & Mage
			//Primary Int, Normal Vit, Low Str/Dex
			//No Damage(Armor Piece)
			//Low Armor range b/c its a light piece
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
			
			//mSprite = ResourceManager.do stuff
		
		case LIGHT_LEGS:
			//Light Leg Armor
			//For Cleric & Mage
			//Primary Int, Normal Vit, Low Str/Dex
			//No Damage(Armor Piece)
			//Low Armor range b/c its a light piece
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
			
			//mSprite = ResourceManager.do stuff
			
		case MEDIUM_HEMLT:
			//Medium Helmet
			//For Ranger, Assassin, and Engineer
			//Ranger:
			//Primary Dex, Normal Vit, Low Str/Int
			//No Damage(Armor Piece)
			//Medium Armor range b/c its a Medium piece
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
			
			//mSprite = ResourceManager.do stuff
			
		case MEDIUM_CHESTPLATE:
			//Meduim Chest Plate
			//For Ranger, Assassin, and Engineer
			//Ranger:
			//Primary Dex, Normal Vit, Low Str/Int
			//No Damage(Armor Piece)
			//Medium Armor range b/c its a Medium piece
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
			
			//mSprite = ResourceManager.do stuff
			
		case MEDIUM_LEGS:
			//Meduim Leg Armor
			//For Ranger, Assassin, and Engineer
			//Ranger:
			//Primary Dex, Normal Vit, Low Str/Int
			//No Damage(Armor Piece)
			//Medium Armor range b/c its a Medium piece
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
			
			//mSprite = ResourceManager.do stuff
			
		case HEAVY_HEMLET:
			//Heavy Hemlet
			//For Warrior & Knight
			//Warrior:
			//Primary Str, Normal Vit, Low Dex/Int
			//No Damage(Armor Piece)
			//High Armor range b/c its a Heavy piece
			mName = "Heavy Hemlet";
			mDescription = "";
			
			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(0);
			mItemStats.setArmor(randHighStat());
			
			isWeapon = false;
			isArmor = true;
			
			//mSprite = ResourceManager.do stuff
			
		case HEAVY_CHESTPLATE:
			//Heavy Chest Plate
			//For Warrior & Knight
			//Warrior:
			//Primary Str, Normal Vit, Low Dex/Int
			//No Damage(Armor Piece)
			//High Armor range b/c its a Heavy piece
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
			
			//mSprite = ResourceManager.do stuff
			
			
		case HEAVYA_LEGS:
			//Heavy Leg Armor
			//For Warrior & Knight
			//Warrior:
			//Primary Str, Normal Vit, Low Dex/Int
			//No Damage(Armor Piece)
			//High Armor range b/c its a Heavy piece
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
			
			//mSprite = ResourceManager.do stuff
			
		case ONE_HANDED_SWORD:
		
			//One Handed sword
			//For Warrior, Knight, and Assassin
			mName = "One Handed sword";
			mDescription =  "";
			
			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);
			
			isWeapon = true;
			isArmor = false;
			
			//mSprite = ResourceManager.do stuff
			
		case ONE_HANDED_AXE:
			//One handed axe
			//For Warrior, Knight, and Assassin
			mName = "One handed axe";
			mDescription =  "";
			
			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);
			
			isWeapon = true;
			isArmor = false;
			
			//mSprite = ResourceManager.do stuff
			
		case ONE_HANDED_MACE:
			//One Handed Mace
			//For Warrior, Knight, and Assassin
			mName = "One Handed Mace";
			mDescription =  "";
			
			mItemStats.setStrength(randHighStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);
			
			isWeapon = true;
			isArmor = false;
			
			//mSprite = ResourceManager.do stuff
			
		case TWO_HANDED_SWORD:
			//Two Handed Sword
			//For Warrior
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
			
			//mSprite = ResourceManager.do stuff
			
		case TWO_HANDED_AXE:
			//Two Handed Axe
			//For Warrior
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
			
			//mSprite = ResourceManager.do stuff
			
		case TWO_HANDED_MACE:
			//Two Handed Maces
			//For Warrior
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
			
			//mSprite = ResourceManager.do stuff
			
		case LONGBOW:
			//Longbow
			//For Ranger
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
			
			//mSprite = ResourceManager.do stuff
			
			
		case SHORTOBOW:
			//Shortbow
			//For Ranger
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
			
			//mSprite = ResourceManager.do stuff
			
		case CROSSBOW:
			//Crossbow
			//For Ranger
			mName = "";
			mDescription = "";
			
			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randHighStat());
			mItemStats.setIntelligence(randLowStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randHighStat());
			mItemStats.setArmor(0);
			
			isWeapon = true;
			isArmor = false;
			
			//mSprite = ResourceManager.do stuff
			
		case WAND:
			//Wand
			//For Cleric & Mage
			mName = "";
			mDescription = "";
			
			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randLowStat());
			mItemStats.setArmor(0);
			
			isWeapon = true;
			isArmor = false;
			
			//mSprite = ResourceManager.do stuff
			
		case ORB:
			//Orb
			//For Cleric & Mage
			mName = "";
			mDescription = "";
			
			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randLowStat());
			mItemStats.setArmor(0);
			
			isWeapon = true;
			isArmor = false;
			
			//mSprite = ResourceManager.do stuff
			
		case STAFF:
			//Staff
			//For Cleric & Mage
			mName = "";
			mDescription = "";
			
			mItemStats.setStrength(randLowStat());
			mItemStats.setDexterity(randLowStat());
			mItemStats.setIntelligence(randHighStat());
			mItemStats.setVitality(randMedStat());
			mItemStats.setDamage(randLowStat());
			mItemStats.setArmor(0);
			
			isWeapon = true;
			isArmor = false;
			
			//mSprite = ResourceManager.do stuff
				
		}
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public Stats getItemStats() {
		return mItemStats;
	}
		
	public boolean isArmor(){
		return isArmor;
	}

	public boolean IsWeapon(){
		return isWeapon;
	}	

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	
	//Randomly Generate stat between [10-25]
	private int randHighStat(){
		Random rand = new Random();
		
		int HighStat = rand.nextInt(16) + 10; //[10-25]
		HighStat += (mItemLevel * 5);
		
		return HighStat;
	}

	//Randomly Generate stat between [1-15]
	private int randMedStat(){		
		Random rand = new Random();
		
		int MedStat = rand.nextInt(15) + 1; //[1-15]
		MedStat += (mItemLevel * 5);
		
		return MedStat;
	}

	//Randomly Generate stat between [1-10]
	private int randLowStat(){		
		Random rand = new Random();
		
		int LowStat = rand.nextInt(10) + 1; //[1-10]
		LowStat += (mItemLevel * 5);
		
		return LowStat;
	}
	
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
