package dragonsreign.scene;


import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;

import dragonsreign.scene.BaseScene;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;

public class BattleScene extends BaseScene implements IOnMenuItemClickListener
{

	
	private MenuScene battleMenuChildScene, abilitiesChildScene, itemsChildScene;
	private Rectangle character1HealthBar, character2HealthBar;

	private Sprite teamMember1, teamMember2, teamMember3, enemy1, enemy2, enemy3;
	
	private ScaleMenuItemDecorator abilitiesButton, itemsButton, swapButton, 
								   fleeButton,basicAttack, skillOne, skillTwo, 
						 		   skillThree, skillFour, skillFive,
						 		   item1, item2, item3, item4, item5, item6;

	private Text abilitiesText, itemsText,
	 			 swapText, fleeText, 
	 			 basicAttackText, skillOneText, skillTwoText,
	 			 skillThreeText, skillFourText,skillFiveText,
	 			 item1Text,item2Text, item3Text, item4Text,
	 			 item5Text, item6Text;
	
	
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
	    /////////////////////////////////////////////////////////////////////////////////////
	    //Create ChildScenes
	    /////////////////////////////////////////////////////////////////////////////////////
		battleMenuChildScene = new MenuScene(camera);
		abilitiesChildScene = new MenuScene(camera);
		itemsChildScene = new MenuScene(camera);
		
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
		//Create Player and Enemy Sprites
		/////////////////////////////////////////////////////////////////////////////////////
		teamMember1 = new Sprite(0, 0, resourcesManager.teamMember1, this.engine.getVertexBufferObjectManager());
		teamMember2 = new Sprite(0, 0, resourcesManager.teamMember2, this.engine.getVertexBufferObjectManager());
		teamMember3 = new Sprite(0, 0, resourcesManager.teamMember3, this.engine.getVertexBufferObjectManager());
		enemy1 = new Sprite(0, 0, resourcesManager.enemy1, this.engine.getVertexBufferObjectManager());
		enemy2 = new Sprite(0, 0, resourcesManager.enemy2, this.engine.getVertexBufferObjectManager());
		enemy3 = new Sprite(0, 0, resourcesManager.enemy3, this.engine.getVertexBufferObjectManager());
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Set Team Member and Enemy Positions
		/////////////////////////////////////////////////////////////////////////////////////
		teamMember1.setPosition(100, 0);
		teamMember2.setPosition(100, 100);		
		teamMember3.setPosition(100, 200);
		enemy1.setPosition(600, 0);
		enemy2.setPosition(600, 100);
		enemy3.setPosition(600, 200);
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Attach Sprites to the Screen
		/////////////////////////////////////////////////////////////////////////////////////
		attachChild(teamMember1);
		attachChild(teamMember2);
		attachChild(teamMember3);
		attachChild(enemy1);
		attachChild(enemy2);
		attachChild(enemy3);
	
		
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
	
		//setBackground(new Background(Color.BLUE));
		
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

}
