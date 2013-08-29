package Character;

public class Engineer extends PlayerCharacter{
	
	private int currentStamina;
	private int maxStamina;

	private int smokeBombLevel;
	private int smokeBombCost;

	private int flashBombLevel;
	private int flashBombCost;

	private int incendiaryBombLevel;
	private int incendiaryBombCost;

	private int shrapnelBombLevel;
	private int shrapnelBombCost;

	private int theMotherloadLevel;
	private int theMotherloadCost;

	private int skillPoints;

	//L_Helm Helm;
	//L_Upper upper;
	//L_Lower lower;

	Engineer(){
		//TODO
		//set base stats, stamina for engineer
		//loadEngineerSprite



		abilities[0] = "Attack";
		abilities[1] = "Smoke Bomb";
		abilities[2] = "Flash Bomb";
		abilities[3] = "Incendiary Bomb";
		abilities[4] = "Shrapnel Bomb";
		abilities[5] = "The Motherload";

		for(int abltyCntr = 0; abltyCntr < 6; abltyCntr++){
			unlockedAbilities[abltyCntr] = false;
		}

		smokeBombLevel = 0;
		smokeBombCost = 0;

		flashBombLevel = 0;
		flashBombCost = 0;

		incendiaryBombLevel = 0;
		incendiaryBombCost = 0;

		shrapnelBombLevel = 0;
		shrapnelBombCost = 0;

		theMotherloadLevel = 0;
		theMotherloadCost = 0;

		skillPoints = 0;
	}

	void LoadCharacter(int Lvl, int CurrentXp /*helm, upper, lower*/){
		//equip gear

		for(int curLvl = 1; curLvl <= Lvl; curLvl++){
			levelUp();
		}
	}

	void BasicAttack(){
		//weapon dmg
		

	}

	void SmokeBomb(){
		if(currentStamina > smokeBombCost){
			//do stuff
			if(smokeBombLevel == 1){
				//no dmg
				//has chance to blind all enemies
			}else if(smokeBombLevel == 2){
				//increased chance to blind all enemies
			}else if(smokeBombLevel == 3){
				//increased chance to blind all enemies
			}
			
			currentStamina -= smokeBombCost;
		}

	}

	void FlashBomb(){
		if(currentStamina > flashBombCost){
			if(flashBombLevel == 1){
				//no dmg
				//chance to daze all enemies
			}else if(flashBombLevel == 2){
				//increased chance to daze all enemies
			}else if(flashBombLevel == 3){
				//increased chance to daze all enemies
			}
			
			currentStamina -= flashBombCost;
		
		}
	}
	void IncendiaryBomb(){
		if(currentStamina > incendiaryBombCost){
			//do stuff
			if(incendiaryBombLevel == 1){
				//chance to burn all enemies
			}else if(incendiaryBombLevel == 2){
				//increased chance to burn all enemies
			}else if(incendiaryBombLevel == 3){
				//increased chance to burn all enemies
			}
			
			currentStamina -= incendiaryBombCost;
		}
	}

	void ShrapnelBomb(){
		if(currentStamina > shrapnelBombCost){
			if(shrapnelBombLevel == 1){
				//attacks all enemies
				//chance to apply bleed to all enemies
			}else if(shrapnelBombLevel == 2){
				//increased chance to bleed all enemies
			}else if(shrapnelBombLevel == 3){
				//increased chance to bleed all enemies
			}
			
			currentStamina -= shrapnelBombCost;
		}

	}

	void TheMotherload(){
		if(currentStamina > theMotherloadCost){
			if(theMotherloadLevel == 1){
				//charges for 3 turns
				//detonates and deals massive dmg to all enemies
				//full resource depletion
			}else if(theMotherloadLevel == 2){
				//increased dmg
			}else if(theMotherloadLevel == 3){
				//increased dmg
			}
			
			currentStamina -= theMotherloadCost;
		}

	}

	void LevelUp_SmokeBomb(){
		if(skillPoints > 0){
			
			smokeBombLevel +=1;
			//increase cost of skill
			
		}

	}
	
	void LevelUp_FlashBomb(){
		if(skillPoints > 0){
			
			flashBombLevel +=1;
			//increase cost of skill
		}
	}
	
	void LevelUp_IncendiaryBomb(){
		if(skillPoints > 0){
			
			incendiaryBombLevel +=1;
			//increase cost of skill
		}

	}	

	void LevelUp_ShrapnelBomb(){
		if(skillPoints > 0){
			
			shrapnelBombLevel +=1;
			//increase cost of skill
		}

	}

	void LevelUp_TheMotherload(){
		if(skillPoints > 0){
			
			theMotherloadLevel +=1;
			//increase cost of skill
		}
	}
	
	int getCurrentStamina(){
		return currentStamina;
	}
	
	int getMaxStamina(){
		return maxStamina;
	}
	
	@Override
	void levelUp() {
		// TODO
		//Figure levels that you learn abilities
		//Determine increment of base stats

	}

	@Override
	void EquipItem(/*Gear gearItem*/) {
		// TODO 
		//Create item/gear classes
		//on equip alter gearStats, sum of gear pieces

	}

	@Override
	void useAbility(int abilityIdx) {


	}
}
