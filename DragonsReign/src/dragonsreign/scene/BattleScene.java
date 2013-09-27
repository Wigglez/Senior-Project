package dragonsreign.scene;


import org.andengine.engine.camera.BoundCamera;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import android.util.Log;
import android.widget.Toast;
import dragonsreign.character.Enemy;
import dragonsreign.character.PlayerCharacter;
import dragonsreign.character.characterclass.ClericClass;
import dragonsreign.character.characterclass.RangerClass;
import dragonsreign.character.characterclass.WarriorClass;
import dragonsreign.item.consumable.Potion;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;
import dragonsreign.util.AbilityData;
import dragonsreign.util.BattleCharacterContainer;
import dragonsreign.util.RandomNumber;
import dragonsreign.util.enums.ABILITYFLAGS;
import dragonsreign.util.enums.ENEMIES;
import dragonsreign.util.enums.POTIONS;

public class BattleScene extends BaseScene implements IOnMenuItemClickListener
{

	
	private MenuScene battleMenuChildScene, abilitiesChildScene,
			itemsChildScene;

	private BattleCharacterContainer partyMem[], enemyPlyr[];
	private BattleCharacterContainer focusedPartyMem;
	private int focusPlyrIdx;
	private int enemyCount;
	
	private Boolean playerTurn;
	private BattleCharacterContainer abilityTarget;
	private ABILITYFLAGS targetFlag;
	
	private AbilityData abilityData;

	private Sprite teamMember1, teamMember2, teamMember3, enemy1, enemy2,
			enemy3, leftArrow1, leftArrow2, leftArrow3, rightArrow1,
			rightArrow2, rightArrow3, focusArrow;

	private ScaleMenuItemDecorator abilitiesButton, itemsButton, swapButton,
			fleeButton, basicAttack, skillOne, skillTwo, skillThree, skillFour,
			skillFive, item1, item2, item3, item4, item5, item6;

	private Text abilitiesText, itemsText, swapText, fleeText, basicAttackText,
			skillOneText, skillTwoText, skillThreeText, skillFourText,
			skillFiveText, item1Text, item2Text, item3Text, item4Text,
			item5Text, item6Text, teamMember1Info, teamMember2Info,
			teamMember3Info, enemy1Info, enemy2Info, enemy3Info;

	private BoundCamera mcamera;
	
	private enum BUTTONS
	{
		ABILITIES(0),
		ITEMS(1),
		SWAP(2) ,
		FLEE(3) ,
		BASIC_ATTACK(4) ,
		SKILL_ONE(5) ,
		SKILL_TWO(6) ,
		SKILL_THREE(7) ,
		SKILL_FOUR(8) ,
		SKILL_FIVE(9) ,
		ITEM_1(10) ,
		ITEM_2(11) ,
		ITEM_3(12) ,
		ITEM_4(13) ,
		ITEM_5(14) ,
		ITEM_6(15);
		
		private final int value;
		
		private BUTTONS(final int newValue) 
		{
            value = newValue;
        }

        private final int getValue() 
        { 
        	return value; 
        	
        }
	}

	
	
	@Override
	public void createScene() 
	{
		camera.setChaseEntity(null);
		camera.offsetCenter(camera.getCenterX() * -1, camera.getCenterY() * -1);
		
		mcamera = new BoundCamera(0, 0, ((DragonsReignActivity)activity).CAMERA_WIDTH, ((DragonsReignActivity)activity).CAMERA_HEIGHT);
	    /////////////////////////////////////////////////////////////////////////////////////
	    //Create ChildScenes
	    /////////////////////////////////////////////////////////////////////////////////////
		battleMenuChildScene = new MenuScene(mcamera);
		abilitiesChildScene = new MenuScene(mcamera);
		itemsChildScene = new MenuScene(mcamera);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Set First Child Scene
		/////////////////////////////////////////////////////////////////////////////////////
		setChildScene(battleMenuChildScene);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Add On Menu Item Click Listeners For Each Child Scene
		/////////////////////////////////////////////////////////////////////////////////////
		battleMenuChildScene.setOnMenuItemClickListener(this);
		abilitiesChildScene.setOnMenuItemClickListener(this);
		itemsChildScene.setOnMenuItemClickListener(this);
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Players of the battle
		/////////////////////////////////////////////////////////////////////////////////////		
		partyMem = new BattleCharacterContainer[3];
		enemyPlyr = new BattleCharacterContainer[3];
		
		partyMem[0] = new BattleCharacterContainer(new WarriorClass());
		partyMem[1] = new BattleCharacterContainer(new RangerClass());
		partyMem[2] = new BattleCharacterContainer(new ClericClass());
		
		generateRandomEnemies();
		
		focusedPartyMem = new BattleCharacterContainer();
		
		// Don't give focus to a non-existent or dead party member when we start a new battle
		// If first party member exists
		if (partyMem[0] != null) {
			// First party member is not dead
			if (!partyMem[0].isDead()) {
				// Receive focus
				focusPlyrIdx = 0;
			} else if (partyMem[0].isDead()) {
				// First party member is dead, pass focus

				// If second party member exists
				if (partyMem[1] != null) {
					// Second party member is not dead
					if (!partyMem[1].isDead()) {
						// Receive focus
						focusPlyrIdx = 1;
					} else if (partyMem[1].isDead()) {
						// Second party member is dead, pass focus

						// If third party member exists
						if (partyMem[2] != null) {
							// Third party member is not dead
							if (!partyMem[2].isDead()) {
								// Receive focus
								focusPlyrIdx = 2;
							}
						}
					}
				}
			}
		}
		
		focusedPartyMem = partyMem[focusPlyrIdx];
		
		abilityTarget  = new BattleCharacterContainer();
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Player and Enemy Sprites
		/////////////////////////////////////////////////////////////////////////////////////
		
		if (partyMem[0] != null) {
			//teamMember1 = partyMem1.getCharacter().getSprite();
			teamMember1 = new Sprite(0, 0, resourcesManager.teamMember1,
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						
						abilityTarget = partyMem[0];
						clearTargetSelection();
						
						applyAbilityData();
						break;
	
					}
					return true;
	
				}
			};
		}

		if (partyMem[1] != null) {
			// teamMember2 = partyMem2.getCharacter().getSprite();
			teamMember2 = new Sprite(0, 0, resourcesManager.teamMember2,
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						
						abilityTarget = partyMem[1];
						clearTargetSelection();
						
						applyAbilityData();
						
						break;
	
					}
					return true;
	
				}
			};
		}

		if (partyMem[2] != null) {
			// teamMember3 = partyMem3.getCharacter().getSprite();
			teamMember3 = new Sprite(0, 0, resourcesManager.teamMember3,
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						
						abilityTarget = partyMem[2];
						clearTargetSelection();
						
						applyAbilityData();
						break;
	
					}
					return true;
	
				}
			};
		}

		if (enemyPlyr[0] != null) {
			// enemy1 = enemyPlyr1.getCharacter().getSprite();
			enemy1 = new Sprite(0, 0, resourcesManager.enemy1,
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX,
						final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:
						
						abilityTarget = enemyPlyr[0];
						clearTargetSelection();

						applyAbilityData();
						break;

					}
					return true;

				}
			};
			
		}
		
		if (enemyPlyr[1] != null) {
			// enemy2 = enemyPlyr2.getCharacter().getSprite();
			enemy2 = new Sprite(0, 0, resourcesManager.enemy2,
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX,
						final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:

						abilityTarget = enemyPlyr[1];
						clearTargetSelection();

						applyAbilityData();
						break;

					}
					return true;

				}
			};
		}
		
		if (enemyPlyr[2] != null) {
			// enemy3 = enemyPlyr3.getCharacter().getSprite();
			enemy3 = new Sprite(0, 0, resourcesManager.enemy3,
					this.engine.getVertexBufferObjectManager()) {
				@Override
				public boolean onAreaTouched(final TouchEvent pSceneTouchEvent,
						final float pTouchAreaLocalX,
						final float pTouchAreaLocalY) {
					switch (pSceneTouchEvent.getAction()) {
					case TouchEvent.ACTION_DOWN:

						abilityTarget = enemyPlyr[2];
						clearTargetSelection();

						applyAbilityData();
						break;

					}
					return true;

				}
			};
		}
		
		leftArrow1 = new Sprite(0, 0, resourcesManager.leftArrow1, this.engine.getVertexBufferObjectManager());
		leftArrow2 = new Sprite(0, 0, resourcesManager.leftArrow2, this.engine.getVertexBufferObjectManager());
		leftArrow3 = new Sprite(0, 0, resourcesManager.leftArrow3, this.engine.getVertexBufferObjectManager());
		
		rightArrow1 = new Sprite(0, 0, resourcesManager.rightArrow1, this.engine.getVertexBufferObjectManager());
		rightArrow2 = new Sprite(0, 0, resourcesManager.rightArrow2, this.engine.getVertexBufferObjectManager());
		rightArrow3 = new Sprite(0, 0, resourcesManager.rightArrow3, this.engine.getVertexBufferObjectManager());
		
		focusArrow = new Sprite(0, 0, resourcesManager.focusArrow, this.engine.getVertexBufferObjectManager());
		focusArrow.setVisible(false);
		focusArrow.setPosition(225, (focusPlyrIdx * 100) + 25);
		
		//TODO add names and levels to each
		if (partyMem[0] != null) {
			teamMember1Info = new Text(15,-10, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.RIGHT), vbom);
			teamMember1Info.setScale(.66f);
		}
		if (partyMem[1] != null) {
			teamMember2Info = new Text(15,90, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.RIGHT), vbom);
			teamMember2Info.setScale(.66f);
		}
		if (partyMem[2] != null) {
			teamMember3Info = new Text(15,190, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.RIGHT), vbom);
			teamMember3Info.setScale(.66f);
		}

		if (enemyPlyr[0] != null) {
			enemy1Info = new Text(650,10, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.LEFT), vbom);
			enemy1Info.setScale(.66f);
		}
		if (enemyPlyr[1] != null) {
			enemy2Info = new Text(650,110, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.LEFT), vbom);
			enemy2Info.setScale(.66f);
		}
		if (enemyPlyr[2] != null) {
			enemy3Info = new Text(650,210, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.LEFT), vbom);
			enemy3Info.setScale(.66f);
		}
		
		updateInfoText();
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Set Team Member and Enemy Positions
		/////////////////////////////////////////////////////////////////////////////////////
		if (partyMem[0] != null) {
			teamMember1.setPosition(125, 0);// 150

			leftArrow1.setPosition(225, 25);
			leftArrow1.setVisible(false);
		}
		if (partyMem[1] != null) {
			teamMember2.setPosition(125, 100);

			leftArrow2.setPosition(225, 125);
			leftArrow2.setVisible(false);
		}
		if (partyMem[2] != null) {
			teamMember3.setPosition(125, 200);

			leftArrow3.setPosition(225, 225);
			leftArrow3.setVisible(false);
		}

		if (enemyPlyr[0] != null) {
			enemy1.setPosition(578, 0);// 650

			rightArrow1.setPosition(511, 25);
			rightArrow1.setVisible(false);
		}
		if (enemyPlyr[1] != null) {
			enemy2.setPosition(578, 100);

			rightArrow2.setPosition(511, 125);
			rightArrow2.setVisible(false);
		}
		if (enemyPlyr[2] != null) {
			enemy3.setPosition(578, 200);

			rightArrow3.setPosition(511, 225);
			rightArrow3.setVisible(false);
		}
		
		////////////////////////////////////////////////////////////////////////////////////
		//Register the Touch Areas
		////////////////////////////////////////////////////////////////////////////////////
//		if (partyMem[0] != null) {
//			registerTouchArea(teamMember1);
//		}
//		if (partyMem[1] != null) {
//			registerTouchArea(teamMember2);
//		}
//		if (partyMem[2] != null) {
//			registerTouchArea(teamMember3);
//		}
//		
//		if (enemyPlyr[0] != null) {
//			registerTouchArea(enemy1);
//		}
//		if (enemyPlyr[1] != null) {
//			registerTouchArea(enemy2);
//		}
//		if (enemyPlyr[2] != null) {
//			registerTouchArea(enemy3);
//		}
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Sprites to the Screen
		/////////////////////////////////////////////////////////////////////////////////////
		
		if (partyMem[0] != null) {
			attachChild(teamMember1);
			attachChild(leftArrow1);
			attachChild(teamMember1Info);
		}
		if (partyMem[1] != null) {
			attachChild(teamMember2);
			attachChild(leftArrow2);
			attachChild(teamMember2Info);
		}
		if (partyMem[2] != null) {
			attachChild(teamMember3);
			attachChild(leftArrow3);
			attachChild(teamMember3Info);
		}

		if (enemyPlyr[0] != null) {
			attachChild(enemy1);
			attachChild(rightArrow1);
			attachChild(enemy1Info);
		}
		if (enemyPlyr[1] != null) {
			attachChild(enemy2);
			attachChild(rightArrow2);
			attachChild(enemy2Info);
		}
		if (enemyPlyr[2] != null) {
			attachChild(enemy3);
			attachChild(rightArrow3);
			attachChild(enemy3Info);
		}
		
		attachChild(focusArrow);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create the Child Scenes
		/////////////////////////////////////////////////////////////////////////////////////
		createBattleView();
		createBattleMenuView();
		createAbilitiesMenuView();
		createItemsMenuView();
		
		hasteCheck();
		//BattleLoop();
		
	
	}

	public void createBattleView()
	{
	
		setBackground(new Background(Color.RED));
		
	}
	public void createBattleMenuView()
	{
		
		battleMenuChildScene.setPosition(0, 300);
		battleMenuChildScene.setBackgroundEnabled(false);
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Battle Menu Buttons
		/////////////////////////////////////////////////////////////////////////////////////
		abilitiesButton = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ABILITIES.getValue(), resourcesManager.abilitiesButton, vbom), 1.0f, 1);
		itemsButton = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ITEMS.getValue(), resourcesManager.itemsButton, vbom), 1.2f, 1);
		swapButton = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.SWAP.getValue(), resourcesManager.swapButton, vbom), 1.2f, 1);
		fleeButton = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.FLEE.getValue(), resourcesManager.fleeButton, vbom), 1.2f, 1);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Button Texts
		/////////////////////////////////////////////////////////////////////////////////////
		abilitiesText = new Text(40,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		abilitiesText.setText("Abilities");
		
		itemsText = new Text(40,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		itemsText.setText("Items");
		
		swapText = new Text(40,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		swapText.setText("Swap");
		
		fleeText = new Text(40,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		fleeText.setText("Flee");
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Button Texts to Buttons
		/////////////////////////////////////////////////////////////////////////////////////
		abilitiesButton.attachChild(abilitiesText);
		itemsButton.attachChild(itemsText);
		swapButton.attachChild(swapText);
		fleeButton.attachChild(fleeText);
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Set Button Positions
		/////////////////////////////////////////////////////////////////////////////////////
		abilitiesButton.setPosition(100, 20);
		itemsButton.setPosition(500, 20);
		swapButton.setPosition(100, 100);
		fleeButton.setPosition(500, 100);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Buttons to Child Scene
		/////////////////////////////////////////////////////////////////////////////////////
		battleMenuChildScene.addMenuItem(abilitiesButton);
		battleMenuChildScene.addMenuItem(itemsButton);
		battleMenuChildScene.addMenuItem(swapButton);
		battleMenuChildScene.addMenuItem(fleeButton);
		
		
		battleMenuChildScene.setVisible(true);

	}
	public void createAbilitiesMenuView()
	{

		abilitiesChildScene.setPosition(0, 300);
		abilitiesChildScene.setBackgroundEnabled(false);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Battle Menu Buttons
		/////////////////////////////////////////////////////////////////////////////////////
		basicAttack = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.BASIC_ATTACK.getValue(), resourcesManager.basicAttackButton, vbom), 1.2f, 1);
		skillOne = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.SKILL_ONE.getValue(), resourcesManager.skillOneButton, vbom), 1.2f, 1);
		skillTwo = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.SKILL_TWO.getValue(), resourcesManager.skillTwoButton, vbom), 1.2f, 1);
		skillThree = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.SKILL_THREE.getValue(), resourcesManager.skillThreeButton, vbom), 1.2f, 1);
		skillFour = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.SKILL_FOUR.getValue(), resourcesManager.skillFourButton, vbom), 1.2f, 1);
		skillFive = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.SKILL_FIVE.getValue(), resourcesManager.skillFiveButton, vbom), 1.2f, 1);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Button Texts
		/////////////////////////////////////////////////////////////////////////////////////
		String[] plyrAbilities = focusedPartyMem.getAbilityNames();
		basicAttackText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		basicAttackText.setText(plyrAbilities[0]);
		
		skillOneText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillOneText.setText(plyrAbilities[1]);
		
		skillTwoText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillTwoText.setText(plyrAbilities[2]);
		
		skillThreeText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillThreeText.setText(plyrAbilities[3]);
		
		skillFourText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillFourText.setText(plyrAbilities[4]);
		
		skillFiveText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillFiveText.setText(plyrAbilities[5]);
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Button Texts to Buttons
		/////////////////////////////////////////////////////////////////////////////////////
		basicAttack.attachChild(basicAttackText);
		skillOne.attachChild(skillOneText);
		skillTwo.attachChild(skillTwoText);
		skillThree.attachChild(skillThreeText);
		skillFour.attachChild(skillFourText);
		skillFive.attachChild(skillFiveText);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Set Button Positions
		/////////////////////////////////////////////////////////////////////////////////////
		basicAttack.setPosition(50, 20);
		skillOne.setPosition(50, 100);
		skillTwo.setPosition(300, 20);
		skillThree.setPosition(300, 100);
		skillFour.setPosition(550, 20);
		skillFive.setPosition(550, 100);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Buttons to Child Scene
		/////////////////////////////////////////////////////////////////////////////////////
		abilitiesChildScene.addMenuItem(basicAttack);
		abilitiesChildScene.addMenuItem(skillOne);
		abilitiesChildScene.addMenuItem(skillTwo);
		abilitiesChildScene.addMenuItem(skillThree);
		abilitiesChildScene.addMenuItem(skillFour);
		abilitiesChildScene.addMenuItem(skillFive);

	}
	public void createItemsMenuView()
	{
		itemsChildScene.setPosition(0, 300);
		itemsChildScene.setBackgroundEnabled(false);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Battle Menu Buttons
		/////////////////////////////////////////////////////////////////////////////////////
		item1 = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ITEM_1.getValue(), resourcesManager.basicAttackButton, vbom), 1.2f, 1);
		item2 = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ITEM_2.getValue(), resourcesManager.skillOneButton, vbom), 1.2f, 1);
		item3 = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ITEM_3.getValue(), resourcesManager.skillTwoButton, vbom), 1.2f, 1);
		item4 = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ITEM_4.getValue(), resourcesManager.skillThreeButton, vbom), 1.2f, 1);
		item5 = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ITEM_5.getValue(), resourcesManager.skillFourButton, vbom), 1.2f, 1);
		item6 = new ScaleMenuItemDecorator(new SpriteMenuItem(BUTTONS.ITEM_6.getValue(), resourcesManager.skillFiveButton, vbom), 1.2f, 1);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Button Texts
		/////////////////////////////////////////////////////////////////////////////////////
		item1Text = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		item1Text.setText("Item 1");
		
		item2Text = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		item2Text.setText("Item 2");
		
		item3Text = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		item3Text.setText("Item 3");
		
		item4Text = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		item4Text.setText("Item 4");
		
		item5Text = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		item5Text.setText("Item 5");
		
		item6Text = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		item6Text.setText("Item 6");
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Button Texts to Buttons
		/////////////////////////////////////////////////////////////////////////////////////
		item1.attachChild(item1Text);
		item2.attachChild(item2Text);
		item3.attachChild(item3Text);
		item4.attachChild(item4Text);
		item5.attachChild(item5Text);
		item6.attachChild(item6Text);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Set Button Positions
		/////////////////////////////////////////////////////////////////////////////////////
		item1.setPosition(50, 20);
		item2.setPosition(50, 100);
		item3.setPosition(300, 20);
		item4.setPosition(300, 100);
		item5.setPosition(550, 20);
		item6.setPosition(550, 100);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Buttons to Child Scene
		/////////////////////////////////////////////////////////////////////////////////////
		itemsChildScene.addMenuItem(item1);
		itemsChildScene.addMenuItem(item2);
		itemsChildScene.addMenuItem(item3);
		itemsChildScene.addMenuItem(item4);
		itemsChildScene.addMenuItem(item5);
		itemsChildScene.addMenuItem(item6);
	
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY) 
	{
		if (pMenuItem.getID() == BUTTONS.ABILITIES.getValue()) {
			setChildScene(abilitiesChildScene);
			return true;
		} else if (pMenuItem.getID() == BUTTONS.ITEMS.getValue()) {
			setChildScene(itemsChildScene);
			return true;
		} else if (pMenuItem.getID() == BUTTONS.SWAP.getValue()) {

			swap();

			return true;
		} else if (pMenuItem.getID() == BUTTONS.FLEE.getValue()) {

			int avgEnemyLevel = 0;

			for (int enemyIdx = 0; enemyIdx < enemyCount; enemyIdx++) {

				if (enemyPlyr[enemyIdx] != null)
					avgEnemyLevel += enemyPlyr[enemyIdx].getLevel();
			}

			avgEnemyLevel /= enemyCount;
			
			
			int fleeChanceCalc = RandomNumber.generateRandomInt(1, 100);
			int chanceToFlee = 0;
			if (partyMem[0].getLevel() > avgEnemyLevel) {
				chanceToFlee = 75;
			} else if (partyMem[0].getLevel() == avgEnemyLevel) {
				chanceToFlee = 50;
			} else if (partyMem[0].getLevel() < avgEnemyLevel) {
				chanceToFlee = 25;
			}

			if (fleeChanceCalc <= chanceToFlee) {
				writeToScreen("Successfully fled the battle.", 1);

				onBackKeyPressed();
			} else {
				writeToScreen("Cannot flee the battle.", 1);

				partyMem[0].setHasTurn(false);
				partyMem[1].setHasTurn(false);
				partyMem[2].setHasTurn(false);
			}
			
			return true;
		} else if (pMenuItem.getID() == BUTTONS.BASIC_ATTACK.getValue()) {
			
			abilityData = new AbilityData();
						
			targetFlag = focusedPartyMem.useAbility(0, abilityData);
			
			targetSelect();
			return true;
		} else if (pMenuItem.getID() == BUTTONS.SKILL_ONE.getValue()) {
			abilityData = new AbilityData();
			
			targetFlag = focusedPartyMem.useAbility(1, abilityData);
			
			targetSelect();
			return true;
		} else if (pMenuItem.getID() == BUTTONS.SKILL_TWO.getValue()) {
			abilityData = new AbilityData();
			
			targetFlag = focusedPartyMem.useAbility(2, abilityData);
			
			targetSelect();
			return true;
		} else if (pMenuItem.getID() == BUTTONS.SKILL_THREE.getValue()) {
			abilityData = new AbilityData();
			
			targetFlag = focusedPartyMem.useAbility(3, abilityData);
			
			targetSelect();
			return true;
		} else if (pMenuItem.getID() == BUTTONS.SKILL_FOUR.getValue()) {
			abilityData = new AbilityData();
			
			targetFlag = focusedPartyMem.useAbility(4, abilityData);
			
			targetSelect();
			return true;
		} else if (pMenuItem.getID() == BUTTONS.SKILL_FIVE.getValue()) {
			abilityData = new AbilityData();
			
			targetFlag = focusedPartyMem.useAbility(5, abilityData);
			
			targetSelect();
			setChildScene(battleMenuChildScene);
			return true;
		} else if (pMenuItem.getID() == BUTTONS.ITEM_1.getValue()) {
			return true;
		} else if (pMenuItem.getID() == BUTTONS.ITEM_2.getValue()) {
			return true;
		} else if (pMenuItem.getID() == BUTTONS.ITEM_3.getValue()) {
			return true;
		} else if (pMenuItem.getID() == BUTTONS.ITEM_4.getValue()) {
			return true;
		} else if (pMenuItem.getID() == BUTTONS.ITEM_5.getValue()) {
			return true;
		} else if (pMenuItem.getID() == BUTTONS.ITEM_6.getValue()) {
			setChildScene(battleMenuChildScene);
			return true;
		} else {
			return false;
		}
	}
	
	private void swap() {
		do {
			focusPlyrIdx += 1;
			if (focusPlyrIdx > 2)
				focusPlyrIdx = 0;
			focusedPartyMem = partyMem[focusPlyrIdx];

		} while (!(focusedPartyMem.hasTurn()) || focusedPartyMem.isDead());

		updateAbilityButtons();
		focusArrow.setVisible(true);
		focusArrow.setPosition(225, (focusPlyrIdx * 100) + 25);
		
	}

	@Override
	public void onBackKeyPressed() 
	{
		// TODO Auto-generated method stub
		SceneManager.getInstance().setScene(SceneManager.SceneType.SCENE_GAME);
		
	}

	@Override
	public SceneType getSceneType() {
		// TODO Auto-generated method stub
		return SceneType.SCENE_BATTLE;
	}

	@Override
	public void disposeScene() {
		// TODO Auto-generated method stub
		
	}
	
	private void generateRandomEnemies(){
		int accumulativeHealth = partyMem[0].getMaxHealth() + partyMem[1].getMaxHealth() + partyMem[2].getMaxHealth();
		int accumulativeDmg = partyMem[0].getCharacter().getCurrentStats().getDamage() + partyMem[1].getCharacter().getCurrentStats().getDamage() + partyMem[2].getCharacter().getCurrentStats().getDamage();
		int accumulativeArmor = partyMem[0].getCharacter().getCurrentStats().getArmor() + partyMem[1].getCharacter().getCurrentStats().getArmor() + partyMem[2].getCharacter().getCurrentStats().getArmor();
		int plyrLvl = partyMem[0].getLevel();
		
		enemyCount = RandomNumber.generateRandomInt(1, 3);
		
		switch (enemyCount) {
		case 1:
			enemyPlyr[0] = new BattleCharacterContainer(new Enemy(plyrLvl,
																accumulativeHealth,
																accumulativeDmg,
																accumulativeArmor,
																ENEMIES.values()[RandomNumber.generateRandomInt(0, 6)]));
			enemyPlyr[1] = null;
			enemyPlyr[2] = null;
			break;
		case 2:
			enemyPlyr[0] = new BattleCharacterContainer(new Enemy(plyrLvl,
																accumulativeHealth, 
																accumulativeDmg,
																accumulativeArmor,
																ENEMIES.values()[RandomNumber.generateRandomInt(0, 6)]));
			enemyPlyr[1] = new BattleCharacterContainer(new Enemy(plyrLvl,
																accumulativeHealth,
																accumulativeDmg,
																accumulativeArmor,
																ENEMIES.values()[RandomNumber.generateRandomInt(0, 6)]));
			enemyPlyr[2] = null;
			break;
		case 3:

			enemyPlyr[0] = new BattleCharacterContainer(new Enemy(plyrLvl,
																accumulativeHealth,
																accumulativeDmg,
																accumulativeArmor,
																ENEMIES.values()[RandomNumber.generateRandomInt(0, 6)]));
			enemyPlyr[1] = new BattleCharacterContainer(new Enemy(plyrLvl,
																accumulativeHealth,
																accumulativeDmg,
																accumulativeArmor,
																ENEMIES.values()[RandomNumber.generateRandomInt(0, 6)]));
			enemyPlyr[2] = new BattleCharacterContainer(new Enemy(plyrLvl,
																accumulativeHealth,
																accumulativeDmg,
																accumulativeArmor,
																ENEMIES.values()[RandomNumber.generateRandomInt(0, 6)]));

			break;
		}
	}
	private void updateInfoText(){
		
		if(partyMem[0] != null){
			teamMember1Info.setText(partyMem[0].getName() + "\nLvl: " + partyMem[0].getLevel() + "\n" + partyMem[0].getCurrentHealth() + " / " + partyMem[0].getMaxHealth() + "\n" + partyMem[0].getCurrentResource() + " / " + partyMem[0].getMaxResource());
		}
		if(partyMem[1] != null){
			teamMember2Info.setText(partyMem[1].getName() + "\nLvl: " + partyMem[1].getLevel() + "\n" + partyMem[1].getCurrentHealth() + " / " + partyMem[1].getMaxHealth() + "\n" + partyMem[1].getCurrentResource() + " / " + partyMem[1].getMaxResource());
		}
		if(partyMem[2] != null){
			teamMember3Info.setText(partyMem[2].getName() + "\nLvl: " + partyMem[2].getLevel() + "\n" + partyMem[2].getCurrentHealth() + " / " + partyMem[2].getMaxHealth() + "\n" + partyMem[2].getCurrentResource() + " / " + partyMem[2].getMaxResource());
		}
		
		if(enemyPlyr[0] != null){
			enemy1Info.setText(enemyPlyr[0].getName() + "\nLvl: " + enemyPlyr[0].getLevel() + "\n" + enemyPlyr[0].getCurrentHealth() + " / " + enemyPlyr[0].getMaxHealth());
			Log.e("Enemy 1", enemyPlyr[0].getName() + " damage = " + enemyPlyr[0].getCharacter().getCurrentStats().getDamage());
			Log.e("Enemy 1", enemyPlyr[0].getName() + " armor = " + enemyPlyr[0].getCharacter().getCurrentStats().getArmor());
		}
		if(enemyPlyr[1] != null){
			enemy2Info.setText(enemyPlyr[1].getName() + "\nLvl: " + enemyPlyr[1].getLevel() + "\n" + enemyPlyr[1].getCurrentHealth() + " / " + enemyPlyr[1].getMaxHealth());
			Log.e("Enemy 2", enemyPlyr[1].getName() + " damage = " + enemyPlyr[1].getCharacter().getCurrentStats().getDamage());
			Log.e("Enemy 2", enemyPlyr[1].getName() + " armor = " + enemyPlyr[1].getCharacter().getCurrentStats().getArmor());
		}
		if(enemyPlyr[2] != null){
			enemy3Info.setText(enemyPlyr[2].getName() + "\nLvl: " + enemyPlyr[2].getLevel() + "\n" + enemyPlyr[2].getCurrentHealth() + " / " + enemyPlyr[2].getMaxHealth());
			Log.e("Enemy 3", enemyPlyr[2].getName() + " damage = " + enemyPlyr[2].getCharacter().getCurrentStats().getDamage());
			Log.e("Enemy 3", enemyPlyr[2].getName() + " armor = " + enemyPlyr[2].getCharacter().getCurrentStats().getArmor());
		}

	}
	
	private void writeToScreen(final CharSequence pText, final int pToastLength) {
		activity.runOnUiThread(new Runnable() {
			public void run() {
				if(pToastLength == 0)
					Toast.makeText(activity, pText, Toast.LENGTH_SHORT).show();
				
				if(pToastLength >= 1)
				Toast.makeText(activity, pText, Toast.LENGTH_LONG).show();
			}
		});

	}
	
	private void updateAbilityButtons(){
		String[] plyrAbilities = focusedPartyMem.getAbilityNames();
		
		basicAttackText.setText(plyrAbilities[0]);
		
		skillOneText.setText(plyrAbilities[1]);
		
		skillTwoText.setText(plyrAbilities[2]);
		
		skillThreeText.setText(plyrAbilities[3]);
		
		skillFourText.setText(plyrAbilities[4]);
		
		skillFiveText.setText(plyrAbilities[5]);
	}
	
	
	private void hasteCheck(){
		playerTurn = ((PlayerCharacter)(focusedPartyMem.getCharacter())).compareHasteToEnemy((Enemy) enemyPlyr[0].getCharacter());
		if(playerTurn){
			writeToScreen("Your turn.", 0);
			focusArrow.setVisible(true);
		} else {
			writeToScreen("Enemy's turn.", 0);
			
		}
		
	}
	
	private void BattleLoop(){
		while (true) {
			if (playerTurn) {
				playerTurn();
			} else {
				enemyTurn();
			}
		}
	}
	
	private void playerTurn(){
		
	}
	
	private void enemyTurn(){
		
	}
	
	private void targetSelect(){
		switch(targetFlag) {
		
		case BUFF_ALL:
			
			applyAbilityData();
			break;
		case DAMAGE_ALL:
		case DAMAGE_HEAL_SINGLE:
		case DAMAGE_SINGLE:

			if (enemyPlyr[0] != null && !enemyPlyr[0].isDead()) {
				registerTouchArea(enemy1);
				rightArrow1.setVisible(true);
			}
			if (enemyPlyr[1] != null && !enemyPlyr[1].isDead()) {
				registerTouchArea(enemy2);
				rightArrow2.setVisible(true);
			}
			if (enemyPlyr[2] != null && !enemyPlyr[2].isDead()) {
				registerTouchArea(enemy3);
				rightArrow3.setVisible(true);
			}

			break;
			
		// UNUSED FOR DEMO
		case DEBUFF:
			break;
		case HEAL_ALL:
		case HEAL_SINGLE:
		
			//party member exists & they are not dead & current health is less than max health they  can be healed
			if (partyMem[0] != null && !partyMem[0].isDead() && (partyMem[0].getCurrentHealth() < partyMem[0].getMaxHealth())) {
				registerTouchArea(teamMember1);
				leftArrow1.setVisible(true);
			}

			if (partyMem[1] != null && !partyMem[1].isDead() && (partyMem[1].getCurrentHealth() < partyMem[1].getMaxHealth())) {
				registerTouchArea(teamMember2);
				leftArrow2.setVisible(true);
			}

			if (partyMem[2] != null && !partyMem[2].isDead() && (partyMem[2].getCurrentHealth() < partyMem[2].getMaxHealth())) {
				registerTouchArea(teamMember3);
				leftArrow3.setVisible(true);
			}
			
			break;
		case NOT_ENOUGH_RESOURCE:
			writeToScreen("Insufficient resource.", 0);
			setChildScene(battleMenuChildScene);
			break;
		case REVIVE:
			if (partyMem[0] != null && partyMem[0].isDead()) {
				registerTouchArea(teamMember1);
				leftArrow1.setVisible(true);
			}

			if (partyMem[1] != null && partyMem[1].isDead()) {
				registerTouchArea(teamMember2);
				leftArrow2.setVisible(true);
			}

			if (partyMem[2] != null && partyMem[2].isDead()) {
				registerTouchArea(teamMember3);
				leftArrow3.setVisible(true);
			}
			
			
			break;
		// UNUSED FOR DEMO
		case SELF_CAST:
			break;
		
		}
	}
	
	private void clearTargetSelection(){
		if(partyMem[0] != null){
			unregisterTouchArea(teamMember1);			
		}
		
		if(partyMem[1] != null){
			unregisterTouchArea(teamMember2);
			
		}
		if(partyMem[2] != null){
			unregisterTouchArea(teamMember3);
			
		}
		if(enemyPlyr[0] != null){
			unregisterTouchArea(enemy1);
			
		}
		if(enemyPlyr[1] != null){
			unregisterTouchArea(enemy2);
			
		}
		if(enemyPlyr[2] != null){
			unregisterTouchArea(enemy3);
			
		}
		
		leftArrow1.setVisible(false);
		leftArrow2.setVisible(false);
		leftArrow3.setVisible(false);
		
		rightArrow1.setVisible(false);
		rightArrow2.setVisible(false);
		rightArrow3.setVisible(false);
		
	}

	private void applyAbilityData(){
		
		switch (targetFlag) {
		case BUFF_ALL:
			if (partyMem[0] != null) {
				partyMem[0].recieveAbilityData(abilityData);
			}

			if (partyMem[1] != null) {
				partyMem[1].recieveAbilityData(abilityData);

			}
			if (partyMem[2] != null) {
				partyMem[2].recieveAbilityData(abilityData);

			}
			break;
		case DAMAGE_ALL:
			if (enemyPlyr[0] != null) {
				enemyPlyr[0].recieveAbilityData(abilityData);
			}
			if (enemyPlyr[1] != null) {
				enemyPlyr[1].recieveAbilityData(abilityData);
			}
			if (enemyPlyr[2] != null) {
				enemyPlyr[2].recieveAbilityData(abilityData);
			}
			break;

		case DAMAGE_HEAL_SINGLE:
			abilityTarget.recieveAbilityData(abilityData);

			abilityData
					.setHealingDone((int) (abilityData.getDamageDone() / 2.0f));
			abilityData.setHealed(true);
			abilityData.setDamageDone(0);

			focusedPartyMem.recieveAbilityData(abilityData);

			break;
		case DAMAGE_SINGLE:
			abilityTarget.recieveAbilityData(abilityData);
			break;
		case DEBUFF:
			break;
		case HEAL_ALL:
			if (partyMem[0] != null) {
				partyMem[0].recieveAbilityData(abilityData);
			}

			if (partyMem[1] != null) {
				partyMem[1].recieveAbilityData(abilityData);

			}
			if (partyMem[2] != null) {
				partyMem[2].recieveAbilityData(abilityData);

			}
			break;
		case HEAL_SINGLE:
			abilityTarget.recieveAbilityData(abilityData);
			break;
		case NOT_ENOUGH_RESOURCE:
			break;
		case REVIVE:
			abilityTarget.useItem(new Potion(POTIONS.BASIC_REVIVE_POTION));
			break;
		case SELF_CAST:
			break;

		}
		
		updateInfoText();
		
		if(playerTurn){
			swap();
		}
	}
}
