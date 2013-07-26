package Character;

class Warrior extends PlayerCharacter{

	private int currentStamina;
	private int maxStamina;

	private int cleaveLevel;
	private int cleaveCost;

	private int lungeLevel;
	private int lungeCost;

	private int executeLevel;
	private int executeCost;

	private int rendLevel;
	private int rendCost;

	private int warCryLevel;
	private int warCryCost;

	private int skillPoints;

	//H_Helm Helm;
	//H_Upper upper;
	//H_Lower lower;

	Warrior(){
		//TODO
		//set base stats, stamina for warrior
		//loadWarriorSprite



		abilities[0] = "Attack";
		abilities[1] = "Cleave";
		abilities[2] = "Lunge";
		abilities[3] = "Execute";
		abilities[4] = "Rend";
		abilities[5] = "War Cry";

		for(int abltyCntr = 0; abltyCntr < 6; abltyCntr++){
			unlockedAbilities[abltyCntr] = false;
		}

		cleaveLevel = 0;
		cleaveCost = 0;

		lungeLevel = 0;
		lungeCost = 0;

		executeLevel = 0;
		executeCost = 0;

		rendLevel = 0;
		rendCost = 0;

		warCryLevel = 0;
		warCryCost = 0;

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

	void Cleave(){
		if(currentStamina > cleaveCost){
			//do stuff
			if(cleaveLevel == 1){
				//attacks all enemies for 40% base dmg
			}else if(cleaveLevel == 2){
				//attacks all enemies for 60% base dmg
			}else if(cleaveLevel == 3){
				//attacks all enemies for 75% base dmg
			}
			
			currentStamina -= cleaveCost;
		}

	}

	void Lunge(){
		if(currentStamina > lungeCost){
			if(lungeLevel == 1){
				//attacks selected enemy target has a chance to stun
			}else if(lungeLevel == 2){
				//attacks selected enemy target has a chance to stun
			}else if(lungeLevel == 3){
				//attacks selected enemy target has a chance to stun
			}
			
			currentStamina -= lungeCost;
		
		}
	}
	void Execute(){
		if(currentStamina > executeCost){
			//do stuff
			if(executeLevel == 1){
				//Completely drains stamina increased dmg based on amount of stamina drained
			}else if(executeLevel == 2){
				//Completely drains stamina increased dmg based on amount of stamina drained
			}else if(executeLevel == 3){
				//Completely drains stamina increased dmg based on amount of stamina drained
			}
			
			currentStamina -= executeCost;
		}
	}

	void Rend(){
		if(currentStamina > rendCost){
			if(rendLevel == 1){
				//no initial dmg bleeds the target for 100% weapon dmg over 3 turns
			}else if(rendLevel == 2){
				//no initial dmg bleeds the target for 125% weapon dmg over 3 turns
			}else if(rendLevel == 3){
				//no initial dmg bleeds the target for 150% weapon dmg over 3 turns
			}
			
			currentStamina -= rendCost;
		}

	}

	void WarCry(){
		if(currentStamina > warCryCost){
			if(warCryLevel == 1){
				//increase party dmg by 15% depletes 50% stamina
			}else if(warCryLevel == 2){
				//increase party dmg by 20% depletes 50% stamina
			}else if(warCryLevel == 3){
				//increase party dmg by 30% depletes 50% stamina
			}
			
			currentStamina -= warCryCost;
		}

	}

	void LevelUp_Cleave(){
		if(skillPoints > 0){
			
			cleaveLevel +=1;
			
			
		}

	}
	
	void LevelUp_Lunge(){
		if(skillPoints > 0){
			
			lungeLevel +=1;
			
		}
	}
	
	void LevelUp_Execute(){
		if(skillPoints > 0){
			
			executeLevel +=1;
			
		}

	}	

	void LevelUp_Rend(){
		if(skillPoints > 0){
			
			rendLevel +=1;
			
		}

	}

	void LevelUp_WarCry(){
		if(skillPoints > 0){
			
			warCryLevel +=1;
			
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