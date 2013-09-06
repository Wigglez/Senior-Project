package dragonsreign.scene;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.HorizontalAlign;


import dragonsreign.scene.BaseScene;
import dragonsreign.character.characterclass.WarriorClass;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;

public class InventoryScene extends BaseScene
{

	private MenuScene inventoryChildScene;
	
	private int health;
	private int mana;
	private int xp;
	

	private Sprite character1Portrait, character2Portrait,character3Portrait, 
				   inventoryGrid, equipmentArea, statsArea, exitButton;
	
	private Rectangle character1HealthBar, character1ManaBar, character1XpBar,
					  character2HealthBar, character2ManaBar, character2XpBar,
					  character3HealthBar, character3ManaBar, character3XpBar;
	
	private Text strengthText, dexterityText, intelligenceText, 
				 vitalityText, damageText, armorText;


	private WarriorClass warriorCharacter;
	
	@Override
	public void createScene() 
	{
		inventoryChildScene = new MenuScene(camera);
		warriorCharacter = new WarriorClass();
		
		health = 100;
		mana = 50;
		xp = 25;
		////////////////////////////////////////////////////////////////////////////////////
		//Create Touchable Sprites
		////////////////////////////////////////////////////////////////////////////////////
		character1Portrait = new Sprite(0, 0, resourcesManager.character1Portrait, this.engine.getVertexBufferObjectManager())
		{
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) 
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		
                		break;

                }
                return true;
           
            }
        };

		character2Portrait = new Sprite(0, 0, resourcesManager.character2Portrait, this.engine.getVertexBufferObjectManager())		
		{
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{         	
                	case TouchEvent.ACTION_DOWN:
                		
                		/*
                		strengthText.setText("Str: " + warriorCharacter.getBaseStats().getStrength());
                		dexterityText.setText("Dex: " + warriorCharacter.getBaseStats().getDexterity());
                		intelligenceText.setText("Int: " + warriorCharacter.getBaseStats().getIntelligence());
                		vitalityText.setText("Vit: " + warriorCharacter.getBaseStats().getVitality());
                		damageText.setText("Dmg: " + warriorCharacter.getBaseStats().getDamage());
                		armorText.setText("Armor: " + warriorCharacter.getBaseStats().getArmor());
                		*/
                		break;

                }
                return true;
           
            }
		};
		character3Portrait = new Sprite(0, 0, resourcesManager.character3Portrait, this.engine.getVertexBufferObjectManager())
		{
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		strengthText.setText("Str: " + 2000);
                		break;

                }
                return true;
           
            }
		};
		
		exitButton = new Sprite(0, 0, resourcesManager.exitButton, this.engine.getVertexBufferObjectManager())
		{
            @Override
            public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY)
            {
            	switch (pSceneTouchEvent.getAction()) 
            	{
                	case TouchEvent.ACTION_DOWN:
                		onBackKeyPressed();
                		
					break;

                }
                return true;
           
            }
		};
		////////////////////////////////////////////////////////////////////////////////////
		//Register the Touch Areas
		////////////////////////////////////////////////////////////////////////////////////
		registerTouchArea(character1Portrait);
		registerTouchArea(character2Portrait);
		registerTouchArea(character3Portrait);
		registerTouchArea(exitButton);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Create Sprites
		////////////////////////////////////////////////////////////////////////////////////
		inventoryGrid = new Sprite(0, 0, resourcesManager.inventoryGid, this.engine.getVertexBufferObjectManager());
		
		
		
		////////////////////////////////////////////////////////////////////////////////////
		//Resource Bars
		////////////////////////////////////////////////////////////////////////////////////
		character1HealthBar = new Rectangle(0,0,health * 1,20,this.engine.getVertexBufferObjectManager());
		character1HealthBar.setColor(1.0f, 0, 0);
		character1ManaBar = new Rectangle(0,0,mana * 1,20,this.engine.getVertexBufferObjectManager());
		character1ManaBar.setColor(0, 0, 1.0f);
		character1XpBar = new Rectangle(0,0,xp * 1,20,this.engine.getVertexBufferObjectManager());
		character1XpBar.setColor(0, 1.0f, 1.0f);
		
		character2HealthBar = new Rectangle(0,0,health * 1,20,this.engine.getVertexBufferObjectManager());
		character2HealthBar.setColor(1.0f, 0, 0);
		character2ManaBar = new Rectangle(0,0,mana * 1,20,this.engine.getVertexBufferObjectManager());
		character2ManaBar.setColor(0, 0, 1.0f);
		character2XpBar = new Rectangle(0,0,xp * 1,20,this.engine.getVertexBufferObjectManager());
		character2XpBar.setColor(0, 1.0f, 1.0f);
		
		character3HealthBar = new Rectangle(0,0,health * 1,20,this.engine.getVertexBufferObjectManager());
		character3HealthBar.setColor(1.0f, 0, 0);
		character3ManaBar = new Rectangle(0,0,mana * 1,20,this.engine.getVertexBufferObjectManager());
		character3ManaBar.setColor(0, 0, 1.0f);
		character3XpBar = new Rectangle(0,0,xp * 1,20,this.engine.getVertexBufferObjectManager());
		character3XpBar.setColor(0, 1.0f, 1.0f);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Set Positions
		////////////////////////////////////////////////////////////////////////////////////
		character1Portrait.setPosition(0, 50);
		character2Portrait.setPosition(250, 50);
		character3Portrait.setPosition(500, 50);
		
		inventoryGrid.setPosition(420, 140);
		
		character1HealthBar.setPosition(60, 50);
		character1ManaBar.setPosition(60, 70);
		character1XpBar.setPosition(60, 90);
		
		character2HealthBar.setPosition(310, 50);
		character2ManaBar.setPosition(310, 70);
		character2XpBar.setPosition(310, 90);
		
		character3HealthBar.setPosition(560, 50);
		character3ManaBar.setPosition(560, 70);
		character3XpBar.setPosition(560, 90);
		
		exitButton.setPosition(-12,-12);
		exitButton.setScale(0.5f);
		////////////////////////////////////////////////////////////////////////////////////
		//Attach Sprites
		////////////////////////////////////////////////////////////////////////////////////
		attachChild(character1Portrait);
		attachChild(character2Portrait);
		attachChild(character3Portrait);
		
		attachChild(inventoryGrid);
		
		attachChild(character1HealthBar);
		attachChild(character1ManaBar);
		attachChild(character1XpBar);
		
		attachChild(character2HealthBar);
		attachChild(character2ManaBar);
		attachChild(character2XpBar);
		
		attachChild(character3HealthBar);
		attachChild(character3ManaBar);
		attachChild(character3XpBar);
		
		attachChild(exitButton);
		
		setChildScene(inventoryChildScene);
		
		
		createInventoryChildScene();
		
	}

	public void createInventoryChildScene()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Set up Child Scene
		////////////////////////////////////////////////////////////////////////////////////
		createTeamMemberOneStatsArea();
		inventoryChildScene.setPosition(0, 140);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Create Sprites
		////////////////////////////////////////////////////////////////////////////////////
		equipmentArea = new Sprite(0, 0, resourcesManager.equipmentArea, this.engine.getVertexBufferObjectManager()); 
		statsArea = new Sprite(0, 0, resourcesManager.statsArea, this.engine.getVertexBufferObjectManager());

		////////////////////////////////////////////////////////////////////////////////////
		//Attach entities
		////////////////////////////////////////////////////////////////////////////////////
		
		
		inventoryChildScene.attachChild(equipmentArea);
		inventoryChildScene.attachChild(statsArea);
		
		
		inventoryChildScene.setBackgroundEnabled(false);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Set Positions
		////////////////////////////////////////////////////////////////////////////////////
		
		equipmentArea.setPosition(210, 0);
		statsArea.setPosition(0, 0);
		
		showTeamMemberOneStatsArea();

		inventoryChildScene.setVisible(true);

	}

	private void createTeamMemberOneStatsArea()
	{
		strengthText = new Text(40,10, resourcesManager.inventoryFont, "" ,150, new TextOptions(HorizontalAlign.RIGHT), vbom);
		strengthText.setText("Str: ");
		
		dexterityText = new Text(40,10, resourcesManager.inventoryFont, "" ,150, new TextOptions(), vbom);
		dexterityText.setText("Dex: ");
		
		intelligenceText = new Text(40,10, resourcesManager.inventoryFont, "" ,150, new TextOptions(), vbom);
		intelligenceText.setText("Int: ");
		
		vitalityText = new Text(40,10, resourcesManager.inventoryFont, "" ,150, new TextOptions(), vbom);
		vitalityText.setText("Vit: ");
		
		damageText = new Text(40,10, resourcesManager.inventoryFont, "" ,150, new TextOptions(), vbom);
		damageText.setText("Dmg: ");
		
		armorText = new Text(40,10, resourcesManager.inventoryFont, "" ,150, new TextOptions(), vbom);
		armorText.setText("Armor: ");
	}
	private void createTeamMemberTwoStatsArea()
	{
	
	}
	private void createTeamMemberThreeStatsArea()
	{
	
	}
	private void createTeamMemberOneEquipmentArea()
	{
	
	}
	private void createTeamMemberTwoEquipmentArea()
	{
	
	}
	private void createTeamMemberThreeEquipmentArea()
	{
	
	}
	private void showTeamMemberOneStatsArea()
	{
		
		strengthText.setPosition(10, 30);
		dexterityText.setPosition(10, 80);
		intelligenceText.setPosition(10, 130);
		vitalityText.setPosition(10, 180);
		damageText.setPosition(10, 230);
		armorText.setPosition(10, 280);
		
		
		
		
		inventoryChildScene.attachChild(strengthText);
		inventoryChildScene.attachChild(dexterityText);
		inventoryChildScene.attachChild(intelligenceText);
		inventoryChildScene.attachChild(vitalityText);
		inventoryChildScene.attachChild(damageText);
		inventoryChildScene.attachChild(armorText);
		
	}
	private void showTeamMemberTwoStatsArea()
	{
		
	}
	private void showTeamMemberThreeStatsArea()
	{
		
	}
	private void showTeamMemberOneEquipmentArea()
	{
		
	}
	private void showTeamMemberTwoEquipmentArea()
	{
		
	}
	private void showTeamMemberThreeEquipmentArea()
	{
		
	}
	@Override
	public void onBackKeyPressed() 
	{
		SceneManager.getInstance().setScene(SceneManager.SceneType.SCENE_GAME);
		
	}

	@Override
	public SceneType getSceneType() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disposeScene() 
	{
		// TODO Auto-generated method stub
		
	}

	
	

}
