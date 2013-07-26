package Character;

public class Assassin extends PlayerCharacter{
	private int currentEnergy;
	private int maxEnergy;

	private int eyeGougeLevel;
	private int eyeGougeCost;

	private int throatCutLevel;
	private int throatCutCost;

	private int backstabLevel;
	private int backstabCost;

	private int stealthLevel;
	private int stealthCost;

	private int disembowelLevel;
	private int disembowelCost;

	private int skillPoints;

	//M_Helm Helm;
	//M_Upper upper;
	//M_Lower lower;

	Assassin(){
		//TODO
		//set base stats, energy for assassin
		//loadAssassinSprite



		abilities[0] = "Attack";
		abilities[1] = "Eye Gouge";
		abilities[2] = "Throat Cut";
		abilities[3] = "Backstab";
		abilities[4] = "Stealth";
		abilities[5] = "Disembowel";

		for(int abltyCntr = 0; abltyCntr < 6; abltyCntr++){
			unlockedAbilities[abltyCntr] = false;
		}

		eyeGougeLevel = 0;
		eyeGougeCost = 0;

		throatCutLevel = 0;
		throatCutCost = 0;

		backstabLevel = 0;
		backstabCost = 0;

		stealthLevel = 0;
		stealthCost = 0;

		disembowelLevel = 0;
		disembowelCost = 0;

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

	void EyeGouge(){
		if(currentEnergy > eyeGougeCost){
			//do stuff
			if(eyeGougeLevel == 1){
				//Chance to blind target
			}else if(eyeGougeLevel == 2){
				
			}else if(eyeGougeLevel == 3){
				
			}
			
			currentEnergy -= eyeGougeCost;
		}

	}

	void ThroatCut(){
		if(currentEnergy > throatCutCost){
			//throatCut
			if(throatCutLevel == 1){
				//Chance to bleed the target
			}else if (throatCutLevel == 2){
				
			}else if(throatCutLevel == 3){
				
			}
			
			currentEnergy -= throatCutCost;
		}
	}

	void Backstab(){
		if(currentEnergy > backstabCost){
			
			if(backstabLevel ==1){
				//Charges for one turn and when active it has a chance to deal double dmg
			}else if(backstabLevel ==2){
				
			}else if(backstabLevel == 3){
				
			}
			
			currentEnergy -= backstabCost;
		}

	}

	void Stealth(){
		if(currentEnergy > stealthCost){
			
			if(stealthLevel ==1){
				//Unable to be targeted for one turn
			}else if(stealthLevel==2){
				
			}else if(stealthLevel==3){
				
			}
			
			currentEnergy -= stealthCost;
		}
	}
	void Disembowel(){
		if(currentEnergy > disembowelCost){
			
			if(disembowelLevel ==1){
				//Full depletion of resource dmg based on amount of resource used
			}else if(disembowelLevel==2){
				
			}else if(disembowelLevel==3){
				
			}
			
			currentEnergy -= disembowelCost;
		}
	}

	void LevelUp_EyeGouge(){
		if(skillPoints > 0){
			
			eyeGougeLevel +=1;
			//increase cost of skill
		}

	}
	
	void LevelUp_ThroatCut(){
		if(skillPoints > 0){
			
			throatCutLevel +=1;
			//increase cost of skill
		}
	}
	
	void LevelUp_Backstab(){
		if(skillPoints > 0){
			
			backstabLevel +=1;
			//increase cost of skill
		}
	}	

	void LevelUp_Stealth(){
		if(skillPoints > 0){
			
			stealthLevel +=1;
			//increase cost of skill
		}
	}

	void LevelUp_Disembowel(){
		if(skillPoints > 0){
			
			disembowelLevel +=1;
			//increase cost of skill
		}
	}
	
	int getcurrentEnergy(){
		return currentEnergy;
	}
	
	int getmaxEnergy(){
		return maxEnergy;
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
