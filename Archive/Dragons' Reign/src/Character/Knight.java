package Character;

public class Knight extends PlayerCharacter{
	private int currentStamina;
	private int maxStamina;

	private int shieldSlamLevel;
	private int shieldSlamCost;

	private int tauntLevel;
	private int tauntCost;

	private int defensiveStanceLevel;
	private int defensiveStanceCost;
	
	private int battleCryLevel;
	private int battleCryCost;
	
	private int retaliateLevel;
	private int retaliateCost;

	private int skillPoints;

	//H_Helm Helm;
	//H_Upper upper;
	//H_Lower lower;

	Knight(){
		//TODO
		//set base stats, stamina for knight
		//loadKnightSprite



		abilities[0] = "Attack";
		abilities[1] = "Shield Slam";
		abilities[2] = "Taunt";
		abilities[3] = "Defensive Stance";
		abilities[4] = "Battle Cry";
		abilities[5] = "Retaliate";

		for(int abltyCntr = 0; abltyCntr < 6; abltyCntr++){
			unlockedAbilities[abltyCntr] = false;
		}

		shieldSlamLevel = 0;
		shieldSlamCost = 0;

		tauntLevel = 0;
		tauntCost = 0;

		defensiveStanceLevel = 0;
		defensiveStanceCost = 0;

		battleCryLevel = 0;
		battleCryCost = 0;
		
		retaliateLevel = 0;
		retaliateCost = 0;
		
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

	void ShieldSlam(){
		if(currentStamina > shieldSlamCost){
			//do stuff
			if(shieldSlamLevel == 1){
				//Chance to stun
			}else if(shieldSlamLevel == 2){
				
			}else if(shieldSlamLevel == 3){
				
			}
			
			currentStamina -= shieldSlamCost;
		}

	}

	void Taunt(){
		if(currentStamina > tauntCost){
			//taunt
			if(tauntLevel == 1){
				//Taunts an enemy for one turn
			}else if (tauntLevel == 2){
				
			}else if(tauntLevel == 3){
				
			}
			
			currentStamina -= tauntCost;
		}
	}

	void DefensiveStance(){
		if(currentStamina > defensiveStanceCost){
			
			if(defensiveStanceLevel ==1){
				//Increases defenses
			}else if(defensiveStanceLevel ==2){
				
			}else if(defensiveStanceLevel == 3){
				
			}
			
			currentStamina -= defensiveStanceCost;
		}

	}


	void BattleCry(){
		if(currentStamina > battleCryCost){
			
			if(battleCryLevel ==1){
				//Increase base vitality of all party members
			}else if(battleCryLevel==2){
				
			}else if(battleCryLevel==3){
				
			}
			
			currentStamina -= battleCryCost;
		}
	}
	void Retaliate(){
		if(currentStamina > retaliateCost){
			
			if(retaliateLevel ==1){
				//returns damage dealt
				//has a 3 turn cooldown
				//has a capped damage 
			}else if(retaliateLevel==2){
				
			}else if(retaliateLevel==3){
				
			}
			
			currentStamina -= retaliateCost;
		}
	}
	void LevelUp_ShieldSlam(){
		if(skillPoints > 0){
			
			shieldSlamLevel +=1;
			//increase cost of skill
		}

	}
	
	void LevelUp_Taunt(){
		if(skillPoints > 0){
			
			tauntLevel +=1;
			//increase cost of skill
		}
	}
	
	void LevelUp_DefensiveStance(){
		if(skillPoints > 0){
			
			defensiveStanceLevel +=1;
			//increase cost of skill
		}
	}	

	void LevelUp_Retaliate(){
		if(skillPoints > 0){
			
			retaliateLevel +=1;
			//increase cost of skill
		}
	}

	void LevelUp_BattleCry(){
		if(skillPoints > 0){
			
			battleCryLevel +=1;
			//increase cost of skill
		}
	}
	
	int getcurrentStamina(){
		return currentStamina;
	}
	
	int getmaxStamina(){
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
