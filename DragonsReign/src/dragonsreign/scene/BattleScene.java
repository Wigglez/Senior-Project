package dragonsreign.scene;


import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.primitive.Rectangle;
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

import dragonsreign.scene.BaseScene;
import dragonsreign.util.BattleCharacterContainer;
import dragonsreign.util.enums.ENEMIES;
import dragonsreign.character.Enemy;
import dragonsreign.character.characterclass.ClericClass;
import dragonsreign.character.characterclass.RangerClass;
import dragonsreign.character.characterclass.WarriorClass;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;

public class BattleScene extends BaseScene implements IOnMenuItemClickListener
{

	
	private MenuScene battleMenuChildScene, abilitiesChildScene, itemsChildScene;
	private BattleCharacterContainer partyMem1, partyMem2, partyMem3, enemyPlyr1, enemyPlyr2, enemyPlyr3;

	private Sprite teamMember1, teamMember2, teamMember3, enemy1, enemy2, enemy3,  leftArrow1, leftArrow2, leftArrow3,
	  rightArrow1, rightArrow2, rightArrow3;
	
	private ScaleMenuItemDecorator abilitiesButton, itemsButton, swapButton, 
								   fleeButton,basicAttack, skillOne, skillTwo, 
						 		   skillThree, skillFour, skillFive,
						 		   item1, item2, item3, item4, item5, item6;


	private Text abilitiesText, itemsText,
	 			 swapText, fleeText, 
	 			 basicAttackText, skillOneText, skillTwoText,
	 			 skillThreeText, skillFourText,skillFiveText,
	 			 item1Text,item2Text, item3Text, item4Text,
	 			 item5Text, item6Text, teamMember1Info, teamMember2Info, teamMember3Info, enemy1Info, enemy2Info, enemy3Info;
	
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
		partyMem1 = new BattleCharacterContainer(new WarriorClass());
		partyMem2 = new BattleCharacterContainer(new RangerClass());
		partyMem3 = new BattleCharacterContainer(new ClericClass());
		
		int totalHealth = partyMem1.getMaxHealth() + partyMem2.getMaxHealth() + partyMem3.getMaxHealth();
		int totalDmg = partyMem1.getCharacter().getCurrentStats().getDamage() + partyMem2.getCharacter().getCurrentStats().getDamage() + partyMem1.getCharacter().getCurrentStats().getDamage();
		int totalArmor = partyMem1.getCharacter().getCurrentStats().getArmor() + partyMem2.getCharacter().getCurrentStats().getArmor() + partyMem3.getCharacter().getCurrentStats().getArmor();
		int plyrLvl = partyMem1.getLevel();
		
		enemyPlyr1 = new BattleCharacterContainer(new Enemy(plyrLvl, totalHealth, totalDmg, totalArmor, ENEMIES.values()[0]));
		enemyPlyr2 = new BattleCharacterContainer(new Enemy(plyrLvl, totalHealth, totalDmg, totalArmor, ENEMIES.values()[0]));
		enemyPlyr3 = new BattleCharacterContainer(new Enemy(plyrLvl, totalHealth, totalDmg, totalArmor, ENEMIES.values()[0]));//ENEMIES.ENEMY_TRIBESMAN));
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create Player and Enemy Sprites
		/////////////////////////////////////////////////////////////////////////////////////
		
		//teamMember1 = partyMem1.getCharacter().getSprite();
		teamMember1 = new Sprite(0, 0, resourcesManager.teamMember1, this.engine.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		//attachChild(leftArrow1);
                		if (leftArrow1.isVisible()){
                			leftArrow1.setVisible(false);
                		}else leftArrow1.setVisible(true);
//                		
//                		
                		break;
                	

                }
                return true;
           
            }
        };
        
      //teamMember2 = partyMem2.getCharacter().getSprite();
		teamMember2 = new Sprite(0, 0, resourcesManager.teamMember2, this.engine.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		//attachChild(leftArrow2);
                		if (leftArrow2.isVisible()){
                			leftArrow2.setVisible(false);
                		}else leftArrow2.setVisible(true);
                	
                	

                }
                return true;
           
            }
        };
        
      //teamMember3 = partyMem3.getCharacter().getSprite();
		teamMember3 = new Sprite(0, 0, resourcesManager.teamMember3, this.engine.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		//attachChild(leftArrow3);
                		if (leftArrow3.isVisible()){
                			leftArrow3.setVisible(false);
                		}else leftArrow3.setVisible(true);
//                		
                		break;
                	

                }
                return true;
           
            }
        };
        
      //enemy1 = enemyPlyr1.getCharacter().getSprite();
		enemy1 = new Sprite(0, 0, resourcesManager.enemy1, this.engine.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		//attachChild(rightArrow1);
                		if (rightArrow1.isVisible()){
                			rightArrow1.setVisible(false);
                		}else rightArrow1.setVisible(true);
                		
                		break;
                	

                }
                return true;
           
            }
        };
        
      //enemy2 = enemyPlyr2.getCharacter().getSprite();
		enemy2 = new Sprite(0, 0, resourcesManager.enemy2, this.engine.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		//attachChild(rightArrow2);
                		if (rightArrow2.isVisible()){
                			rightArrow2.setVisible(false);
                		}else rightArrow2.setVisible(true);
                		
                		break;
                	

                }
                return true;
           
            }
        };
        
      //enemy3 = enemyPlyr3.getCharacter().getSprite();
		enemy3 = new Sprite(0, 0, resourcesManager.enemy3, this.engine.getVertexBufferObjectManager()){
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
					
                		//rightArrow3.setVisible(true);
//					// 	attachChild(rightArrow3);
                		if (rightArrow3.isVisible()){
                			rightArrow3.setVisible(false);
                		}else rightArrow3.setVisible(true);
//                		
                			
                			
                		break;
                	

                }
                return true;
           
            }
        };
		
		leftArrow1 = new Sprite(0, 0, resourcesManager.leftArrow1, this.engine.getVertexBufferObjectManager());
		leftArrow2 = new Sprite(0, 0, resourcesManager.leftArrow2, this.engine.getVertexBufferObjectManager());
		leftArrow3 = new Sprite(0, 0, resourcesManager.leftArrow3, this.engine.getVertexBufferObjectManager());
		
		rightArrow1 = new Sprite(0, 0, resourcesManager.rightArrow1, this.engine.getVertexBufferObjectManager());
		rightArrow2 = new Sprite(0, 0, resourcesManager.rightArrow2, this.engine.getVertexBufferObjectManager());
		rightArrow3 = new Sprite(0, 0, resourcesManager.rightArrow3, this.engine.getVertexBufferObjectManager());
		
		//TODO add names and levels to each
		teamMember1Info = new Text(15,-10, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.RIGHT), vbom);
		teamMember1Info.setScale(.66f);
		teamMember2Info = new Text(15,90, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.RIGHT), vbom);
		teamMember2Info.setScale(.66f);
		teamMember3Info = new Text(15,190, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.RIGHT), vbom);
		teamMember3Info.setScale(.66f);
		
		enemy1Info = new Text(650,10, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.LEFT), vbom);
		enemy1Info.setScale(.66f);
		enemy2Info = new Text(650,110, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.LEFT), vbom);
		enemy2Info.setScale(.66f);
		enemy3Info = new Text(650,210, resourcesManager.battleFont, "", 200, new TextOptions(HorizontalAlign.LEFT), vbom);
		enemy3Info.setScale(.66f);
		
		updateInfoText();
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Set Team Member and Enemy Positions
		/////////////////////////////////////////////////////////////////////////////////////
		teamMember1.setPosition(125, 0);//150
		teamMember2.setPosition(125, 100);		
		teamMember3.setPosition(125, 200);
		enemy1.setPosition(578, 0);//650
		enemy2.setPosition(578, 100);
		enemy3.setPosition(578, 200);
		
		leftArrow1.setPosition(225, 25);
		leftArrow1.setVisible(false);
		leftArrow2.setPosition(225, 125);
		leftArrow2.setVisible(false);
		leftArrow3.setPosition(225, 225);
		leftArrow3.setVisible(false);
		
		rightArrow1.setPosition(511, 25);
		rightArrow1.setVisible(false);
		rightArrow2.setPosition(511, 125);
		rightArrow2.setVisible(false);
		rightArrow3.setPosition(511, 225);
		rightArrow3.setVisible(false);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Register the Touch Areas
		////////////////////////////////////////////////////////////////////////////////////
		registerTouchArea(teamMember1);
		registerTouchArea(teamMember2);
		registerTouchArea(teamMember3);
		registerTouchArea(enemy1);
		registerTouchArea(enemy2);
		registerTouchArea(enemy3);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Sprites to the Screen
		/////////////////////////////////////////////////////////////////////////////////////
		attachChild(teamMember1);
		attachChild(teamMember2);
		attachChild(teamMember3);
		attachChild(enemy1);
		attachChild(enemy2);
		attachChild(enemy3);
	
		attachChild(leftArrow1);
		attachChild(leftArrow2);
		attachChild(leftArrow3);
		attachChild(rightArrow1);
		attachChild(rightArrow2);
		attachChild(rightArrow3);
		
		attachChild(teamMember1Info);
		attachChild(teamMember2Info);
		attachChild(teamMember3Info);
		
		attachChild(enemy1Info);
		attachChild(enemy2Info);
		attachChild(enemy3Info);
		
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Create the Child Scenes
		/////////////////////////////////////////////////////////////////////////////////////
		createBattleView();
		createBattleMenuView();
		createAbilitiesMenuView();
		createItemsMenuView();
	
	}

	public void createBattleView()
	{
	
		setBackground(new Background(Color.BLUE));
		
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
		basicAttackText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		basicAttackText.setText("Attack");
		
		skillOneText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillOneText.setText("Skill One");
		
		skillTwoText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillTwoText.setText("Skill Two");
		
		skillThreeText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillThreeText.setText("Skill Three");
		
		skillFourText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillFourText.setText("Skill Four");
		
		skillFiveText = new Text(20,10, resourcesManager.battleFont, "" ,150, new TextOptions(), vbom);
		skillFiveText.setText("Skill Five");
		
		
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
		if (pMenuItem.getID() == BUTTONS.ABILITIES.getValue()) 
		{
			setChildScene(abilitiesChildScene);
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.ITEMS.getValue()) 
		{
			setChildScene(itemsChildScene);
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.SWAP.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.FLEE.getValue()) 
		{
			onBackKeyPressed();
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.BASIC_ATTACK.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.SKILL_ONE.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.SKILL_TWO.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.SKILL_THREE.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.SKILL_FOUR.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.SKILL_FIVE.getValue()) 
		{
			setChildScene(battleMenuChildScene);
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.ITEM_1.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.ITEM_2.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.ITEM_3.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.ITEM_4.getValue()) 
		{
			return true;
		}
		else if (pMenuItem.getID() == BUTTONS.ITEM_5.getValue()) 
		{
			return true;
		} 
		else if (pMenuItem.getID() == BUTTONS.ITEM_6.getValue()) 
		{
			setChildScene(battleMenuChildScene);
			return true;
		} 
		else 
		{
			return false;
		}
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
	
	private void updateInfoText(){
		
		teamMember1Info.setText(partyMem1.getName() + "\nLvl: " + partyMem1.getLevel() + "\n" + partyMem1.getCurrentHealth() + " / " + partyMem1.getMaxHealth() + "\n" + partyMem1.getCurrentResource() + " / " + partyMem1.getMaxResource());
		teamMember2Info.setText(partyMem2.getName() + "\nLvl: " + partyMem2.getLevel() + "\n" + partyMem2.getCurrentHealth() + " / " + partyMem2.getMaxHealth() + "\n" + partyMem2.getCurrentResource() + " / " + partyMem2.getMaxResource());
		teamMember3Info.setText(partyMem3.getName() + "\nLvl: " + partyMem3.getLevel() + "\n" + partyMem3.getCurrentHealth() + " / " + partyMem3.getMaxHealth() + "\n" + partyMem3.getCurrentResource() + " / " + partyMem3.getMaxResource());

		enemy1Info.setText(enemyPlyr1.getName() + "\nLvl: " + enemyPlyr1.getLevel() + "\n" + enemyPlyr1.getCurrentHealth() + " / " + enemyPlyr1.getMaxHealth());
		enemy2Info.setText(enemyPlyr2.getName() + "\nLvl: " + enemyPlyr2.getLevel() + "\n" + enemyPlyr2.getCurrentHealth() + " / " + enemyPlyr2.getMaxHealth());
		enemy3Info.setText(enemyPlyr3.getName() + "\nLvl: " + enemyPlyr3.getLevel() + "\n" + enemyPlyr3.getCurrentHealth() + " / " + enemyPlyr3.getMaxHealth());

	}

}
