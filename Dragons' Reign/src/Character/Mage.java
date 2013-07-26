package Character;

public class Mage extends PlayerCharacter{
	private int currentMana;
	private int maxMana;

	private int fireBoltLevel;
	private int fireBoltCost;

	private int frostBoltLevel;
	private int frostBoltCost;

	private int lightningBoltLevel;
	private int lightningBoltCost;

	private int manaBarrierLevel;
	private int manaBarrierCost;

	private int meteorLevel;
	private int meteorCost;

	private int skillPoints;

	//L_Helm Helm;
	//L_Upper upper;
	//L_Lower lower;

	Mage(){
		//TODO
		//set base stats, mana for mage
		//loadMageSprite



		abilities[0] = "Attack";
		abilities[1] = "Fire Bolt";
		abilities[2] = "Frost Bolt";
		abilities[3] = "Lightning Bolt";
		abilities[4] = "Mana Barrier";
		abilities[5] = "Meteor";

		for(int abltyCntr = 0; abltyCntr < 6; abltyCntr++){
			unlockedAbilities[abltyCntr] = false;
		}

		fireBoltLevel = 0;
		fireBoltCost = 0;

		frostBoltLevel = 0;
		frostBoltCost = 0;

		lightningBoltLevel = 0;
		lightningBoltCost = 0;

		manaBarrierLevel = 0;
		manaBarrierCost = 0;

		meteorLevel = 0;
		meteorCost = 0;

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

	void FireBolt(){
		if(currentMana > fireBoltCost){
			//do stuff
			if(fireBoltLevel == 1){
				// chance to apply burn
			}else if(fireBoltLevel == 2){
				
			}else if(fireBoltLevel == 3){
				
			}
			
			currentMana -= fireBoltCost;
		}

	}

	void FrostBolt(){
		if(currentMana > frostBoltCost){
			//frostBolt
			if(frostBoltLevel == 1){
				//chance to apply chill
			}else if (frostBoltLevel == 2){
				
			}else if(frostBoltLevel == 3){
				
			}
			
			currentMana -= frostBoltCost;
		}
	}

	void LightningBolt(){
		if(currentMana > lightningBoltCost){
			
			if(lightningBoltLevel ==1){
				// chance to stun
			}else if(lightningBoltLevel ==2){
				
			}else if(lightningBoltLevel == 3){
				
			}
			
			currentMana -= lightningBoltCost;
		}

	}

	void ManaBarrier(){
		if(currentMana > manaBarrierCost){
			
			if(manaBarrierLevel ==1){
				//no mana cost 
				// incoming hits deplete mana instead of health
				//able to be toggled
			}else if(manaBarrierLevel==2){
				//
			}else if(manaBarrierLevel==3){
				//
			}
			
			currentMana -= manaBarrierCost;
		}
	}
	void Meteor(){
		if(currentMana > meteorCost){
			
			if(meteorLevel ==1){
				//attacks all enemies 
				//charges for one turn
				//cost substantial mana
			}else if(meteorLevel==2){
				
			}else if(meteorLevel==3){
				
			}
			
			currentMana -= meteorCost;
		}
	}

	void LevelUp_FireBolt(){
		if(skillPoints > 0){
			
			fireBoltLevel +=1;
			//increase cost of skill
		}

	}
	
	void LevelUp_FrostBolt(){
		if(skillPoints > 0){
			
			frostBoltLevel +=1;
			//increase cost of skill
		}
	}
	
	void LevelUp_LightningBolt(){
		if(skillPoints > 0){
			
			lightningBoltLevel +=1;
			//increase cost of skill
		}
	}	

	void LevelUp_ManaBarrier(){
		if(skillPoints > 0){
			
			manaBarrierLevel +=1;
			//increase cost of skill
		}
	}

	void LevelUp_Meteor(){
		if(skillPoints > 0){
			
			meteorLevel +=1;
			//increase cost of skill
		}
	}
	
	int getCurrentMana(){
		return currentMana;
	}
	
	int getMaxMana(){
		return maxMana;
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
