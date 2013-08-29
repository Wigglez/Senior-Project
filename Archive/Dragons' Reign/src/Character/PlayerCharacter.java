package Character;

import org.andengine.entity.sprite.Sprite;




abstract class PlayerCharacter extends Character{
	
	Sprite battleSprite;
	Sprite portraitSprite;
	
	int currentExperience;
	int level;
	int experienceToNextLevel;
	
	characterStats gearStats;
	characterStats currentStats;
	
	String[] abilities;
	Boolean[] unlockedAbilities;

	abstract void levelUp();
	abstract void EquipItem(/*Gear gearItem*/);
	
	void updateCurrentStats(){
		currentStats.Dexterity = baseStats.Dexterity + gearStats.Dexterity;
		currentStats.Vitality = baseStats.Vitality + gearStats.Vitality;
		currentStats.Intelligence = baseStats.Intelligence + gearStats.Intelligence;
		currentStats.Strength = baseStats.Strength + gearStats.Strength;
		currentStats.Damage = baseStats.Damage + gearStats.Damage;
		currentStats.Armor = baseStats.Armor + gearStats.Armor;
	}
	
	int getDexterity(){
		return currentStats.Dexterity;
	}
	
	int getVitality(){
		return currentStats.Vitality;
	}
	
	int getIntelligence(){
		return currentStats.Intelligence;
	}
	
	int getStrength(){
		return currentStats.Strength;
	}
	
	int getDamage(){
		return currentStats.Damage;
	}
	
	int getArmor(){
		return currentStats.Armor;
	}
	
	//TODO
	//useItem(consumable item){}
		
	void getAbilityNames(String[] abilities){
		abilities = this.abilities;
	}
	
	Boolean abilityUnlocked(int abilityIdx){
		if(unlockedAbilities[abilityIdx])
			return true;
		else
			return false;
	}
	
	abstract void useAbility(int abilityIdx);
	
	
}