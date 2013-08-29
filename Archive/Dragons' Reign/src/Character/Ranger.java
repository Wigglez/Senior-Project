package Character;

public class Ranger extends PlayerCharacter{
	private int currentEnergy;
	private int maxEnergy;

	private int fireArrowLevel;
	private int fireArrowCost;

	private int poisonArrowLevel;
	private int poisonArrowCost;

	private int spreadShotLevel;
	private int spreadShotCost;

	private int chargedShotLevel;
	private int chargedShotCost;

	private int stunArrowLevel;
	private int stunArrowCost;

	private int skillPoints;

	//M_Helm Helm;
	//M_Upper upper;
	//M_Lower lower;

	Ranger(){
		//TODO
		//set base stats, energy for ranger
		//loadRangerSprite



		abilities[0] = "Attack";
		abilities[1] = "Fire Arrow";
		abilities[2] = "Poison Arrow";
		abilities[3] = "Spread Shot";
		abilities[4] = "Charged Shot";
		abilities[5] = "Stun Arrow";

		for(int abltyCntr = 0; abltyCntr < 6; abltyCntr++){
			unlockedAbilities[abltyCntr] = false;
		}

		fireArrowLevel = 0;
		fireArrowCost = 0;

		poisonArrowLevel = 0;
		poisonArrowCost = 0;

		spreadShotLevel = 0;
		spreadShotCost = 0;

		chargedShotLevel = 0;
		chargedShotCost = 0;

		stunArrowLevel = 0;
		stunArrowCost = 0;

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

	void FireArrow(){
		if(currentEnergy > fireArrowCost){
			//do stuff
			if(fireArrowLevel == 1){
				//less base dmg then basic attack has chance to apply burn
			}else if(fireArrowLevel == 2){
				
			}else if(fireArrowLevel == 3){
				
			}
			
			currentEnergy -= fireArrowCost;
		}

	}

	void PoisonArrow(){
		if(currentEnergy > poisonArrowCost){
			//poisonArrow
			if(poisonArrowLevel == 1){
				//less base dmg then basic attack has chance to apply poison
			}else if (poisonArrowLevel == 2){
				
			}else if(poisonArrowLevel == 3){
				
			}
			
			currentEnergy -= poisonArrowCost;
		}
	}

	void SpreadShot(){
		if(currentEnergy > spreadShotCost){
			
			if(spreadShotLevel ==1){
				//attacks all enemies for 75% base dmg
			}else if(spreadShotLevel ==2){
				
			}else if(spreadShotLevel == 3){
				
			}
			
			currentEnergy -= spreadShotCost;
		}

	}

	void ChargedShot(){
		if(currentEnergy > chargedShotCost){
			
			if(chargedShotLevel ==1){
				//charges for one turn and has a chance to deal 2-5 times dmg
			}else if(chargedShotLevel==2){
				
			}else if(chargedShotLevel==3){
				
			}
			
			currentEnergy -= chargedShotCost;
		}
	}
	void StunArrow(){
		if(currentEnergy > stunArrowCost){
			
			if(stunArrowLevel ==1){
				//no initial dmg chance to stun
			}else if(stunArrowLevel==2){
				
			}else if(stunArrowLevel==3){
				
			}
			
			currentEnergy -= stunArrowCost;
		}
	}

	void LevelUp_FireArrow(){
		if(skillPoints > 0){
			
			fireArrowLevel +=1;
			//increase cost of skill
		}

	}
	
	void LevelUp_PoisonArrow(){
		if(skillPoints > 0){
			
			poisonArrowLevel +=1;
			//increase cost of skill
		}
	}
	
	void LevelUp_SpreadShot(){
		if(skillPoints > 0){
			
			spreadShotLevel +=1;
			//increase cost of skill
		}
	}	

	void LevelUp_ChargedShot(){
		if(skillPoints > 0){
			
			chargedShotLevel +=1;
			//increase cost of skill
		}
	}

	void LevelUp_StunArrow(){
		if(skillPoints > 0){
			
			stunArrowLevel +=1;
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
