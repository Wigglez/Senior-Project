package Character;

public class Cleric extends PlayerCharacter{

			private int currentMana;
			private int maxMana;

			private int healLifeSyphonLevel;
			private int healLifeSyphonCost;

			private int reviveLevel;
			private int reviveCost;

			private int healingChantLevel;
			private int healingChantCost;

			private int empowerLevel;
			private int empowerCost;

			private int mendLevel;
			private int mendCost;

			private int skillPoints;

			//L_Helm Helm;
			//L_Upper upper;
			//L_Lower lower;

			Cleric(){
				//TODO
				//set base stats, mana for cleric
				//loadClericSprite



				abilities[0] = "Attack";
				abilities[1] = "Heal/Life Syphon";
				abilities[2] = "Revive";
				abilities[3] = "Healing Chant";
				abilities[4] = "Empower";
				abilities[5] = "Mend";

				for(int abltyCntr = 0; abltyCntr < 6; abltyCntr++){
					unlockedAbilities[abltyCntr] = false;
				}

				healLifeSyphonLevel = 0;
				healLifeSyphonCost = 0;

				reviveLevel = 0;
				reviveCost = 0;

				healingChantLevel = 0;
				healingChantCost = 0;

				empowerLevel = 0;
				empowerCost = 0;

				mendLevel = 0;
				mendCost = 0;

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

			void HealLifeSyphon(){
				if(currentMana > healLifeSyphonCost){
					//do stuff
					if(healLifeSyphonLevel == 1){
						//if enemy targeted siphon life heals cleric for 50% of the dmg done
						//else if friendly target heal
					}else if(healLifeSyphonLevel == 2){
						//if enemy targeted siphon life heals cleric for 50% of the dmg done
						//else if friendly target heal
					}else if(healLifeSyphonLevel == 3){
						//if enemy targeted siphon life heals cleric for 50% of the dmg done
						//else if friendly target heal
					}
					
					currentMana -= healLifeSyphonCost;
				}

			}

			void Revive(){
				if(currentMana > reviveCost){
					//revive
					if(reviveLevel == 1){
						//revive targeted party member
					}else if (reviveLevel == 2){
						//revive targeted party member
					}else if(reviveLevel == 3){
						//revive targeted party member
					}
					
					currentMana -= reviveCost;
				}
			}

			void HealingChant(){
				if(currentMana > healingChantCost){
					
					if(healingChantLevel ==1){
						//charges the spell for one turn then after the turn has elapsed heals entire party
						//costs substantial mana
					}else if(healingChantLevel ==2){
						//charges the spell for one turn then after the turn has elapsed heals entire party
						//costs substantial mana
					}else if(healingChantLevel == 3){
						//charges the spell for one turn then after the turn has elapsed heals entire party
						//costs substantial mana
					}
					
					currentMana -= healingChantCost;
				}

			}

			void Empower(){
				if(currentMana > empowerCost){
					
					if(empowerLevel ==1){
						//boost to all primary stats of entire party
					}else if(empowerLevel==2){
						//boost to all primary stats of entire party
					}else if(empowerLevel==3){
						//boost to all primary stats of entire party
					}
					
					currentMana -= empowerCost;
				}
			}
			void Mend(){
				if(currentMana > mendCost){
					
					if(mendLevel ==1){
						//heals targeted party member gradually over time
					}else if(mendLevel==2){
						//heals targeted party member gradually over time
					}else if(mendLevel==3){
						//heals targeted party member gradually over time
					}
					
					currentMana -= mendCost;
				}
			}

			void LevelUp_HealLifeSyphon(){
				if(skillPoints > 0){
					
					healLifeSyphonLevel +=1;
					//increase cost of skill
				}

			}
			
			void LevelUp_Revive(){
				if(skillPoints > 0){
					
					reviveLevel +=1;
					//increase cost of skill
				}
			}
			
			void LevelUp_HealingChant(){
				if(skillPoints > 0){
					
					healingChantLevel +=1;
					//increase cost of skill
				}
			}	

			void LevelUp_Empower(){
				if(skillPoints > 0){
					
					empowerLevel +=1;
					//increase cost of skill
				}
			}

			void LevelUp_Mend(){
				if(skillPoints > 0){
					
					mendLevel +=1;
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
