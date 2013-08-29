package Character;


class characterStats{
	int Dexterity;
	int Vitality;
	int Intelligence;
	int Strength;
	int Damage;
	int Armor;
	
	characterStats(){
		Dexterity = Vitality = Intelligence = Strength = Damage = Armor = 0;
				
	}
}

abstract class Character {
	
	protected int currentHealth;
	protected int maxHealth;
	characterStats baseStats;
	
	Character(){
		baseStats = new characterStats();
		currentHealth = 0;
		maxHealth =0;
	}
	
	Character(int Health, int Dex, int Vit, int Intel, int Str, int Dmg, int Armor){
		
		currentHealth = maxHealth = Health;
		baseStats.Dexterity = Dex;
		baseStats.Vitality = Vit;
		baseStats.Intelligence = Intel;
		baseStats.Strength = Str;
		baseStats.Damage = Dmg;
		baseStats.Armor = Armor;
	}
	
	int getCurrentHealth(){
		return currentHealth;
	}
	
	int getMaxHealth(){
		return maxHealth;
	}
}