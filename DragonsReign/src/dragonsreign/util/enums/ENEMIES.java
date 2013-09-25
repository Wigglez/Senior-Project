package dragonsreign.util.enums;

public enum ENEMIES {
	// ===========================================================
	// Constants
	// ===========================================================

	// PLAINS
	ENEMY_TRIBESMAN(0),
	ENEMY_MAGGOT(1),
	ENEMY_LION(2),
	ENEMY_CHEETAH(3),
	ENEMY_RHINO(4),
	ENEMY_WASP(5),
	ENEMY_AIR_ELEMENTAL(6),
	
	// MOUNTAINS
	ENEMY_ESKIMO(20),
	ENEMY_YETI(21),
	ENEMY_MAMMOTH(22),
	ENEMY_DIRE_WOLF(23),
	ENEMY_DWARF(24),
	ENEMY_RAM(25),
	ENEMY_ICE_ELEMENTAL(26);
	
	// Unused for demo, available for full game
	
	/* CAVES
	ENEMY_LAND_SHARK,
	ENEMY_TURTLE,
	ENEMY_NAGA,
	ENEMY_SNAKE,
	ENEMY_WATER_ELEMENTAL, */
	
	/* DESERT
	ENEMY_SANDMAN,
	ENEMY_CACTUS,
	ENEMY_CORPION,
	ENEMY_BUZZARD,
	ENEMY_GOLEM,
	ENEMY_LIZARD,
	ENEMY_FIRE_ELEMENTAL, */
	
	/* FOREST
	ENEMY_ELF,
	ENEMY_WOLF,
	ENEMY_FAE,
	ENEMY_TREANT,
	ENEMY_BEAR,
	ENEMY_OOZE,
	ENEMY_BATTLE_FROG; */
	
	
	private final int value;
	
	private ENEMIES(final int newValue) 
	{
        value = newValue;
    }

    private final int getValue() 
    { 
    	return value; 
    	
    }
	
	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

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
