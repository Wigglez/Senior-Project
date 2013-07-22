package characters;




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

	}

	void Cleave(){
		if(currentStamina > cleaveCost){
			//do stuff
			if(cleaveLevel == 1){
				
			}else if(cleaveLevel == 2){
				
			}else if(cleaveLevel == 3){
				
			}
			
			currentStamina -= cleaveCost;
		}

	}

	void Execute(){

	}

	void Rend(){

	}

	void WarCry(){

	}

	void LevelUp_Cleave(){
		if(skillPoints > 0){
			
			cleaveLevel +=1;
			//cleaveCost += 10000000
			
		}

	}
	
	void LevelUp_Lunge(){

	}
	
	void LevelUp_Execute(){

	}	

	void LevelUp_Rend(){

	}

	void LevelUp_WarCry(){

	}
	
	int getCurrentStamina(){
		return currentStamina;
	}
	
	int getMaxStamina(){
		return getMaxStamina;
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