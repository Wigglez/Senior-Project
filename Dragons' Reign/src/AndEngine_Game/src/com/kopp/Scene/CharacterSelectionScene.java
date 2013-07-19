package com.kopp.Scene;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.AutoWrap;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.util.GLState;
import org.andengine.util.HorizontalAlign;
import org.andengine.util.VerticalAlign;
import org.andengine.util.color.Color;

import com.badlogic.gdx.math.Vector2;
import com.kopp.BaseScene.BaseScene;
import com.kopp.Game.MainGameActivity;
import com.kopp.Manager.SceneManager;
import com.kopp.Manager.SceneManager.SceneType;



public class CharacterSelectionScene extends BaseScene implements IOnMenuItemClickListener
{
	private HUD characterHUD;
	private Text warriorText, knightText, 
				 assassinText, clericText, 
				 engineerText, mageText, rangerText,
				 strengthStatText, dexterityStatText,
				 vitalityStatText, intelligenceStatText, 
				 warriorButtonText, rangerButtonText,
				 clericButtonText, knightButtonText,
				 assassinButtonText, engineerButtonText,
				 mageButtonText, startButtonText;
	private PhysicsWorld physicsWorld;
	private MenuScene gameChildScene;
	private Sprite warrior;
	
	private IMenuItem warriorMenuItem, knightMenuItem, 
    				  assassinMenuItem, clericMenuItem, 
    				  engineerMenuItem ,mageMenuItem,
    				  rangerMenuItem, playGameMenuItem;
    
	
	private final int CHARACTER_WARRIOR = 0;
	private final int CHARACTER_KNIGHT = 1;
	private final int CHARACTER_ASSASSIN = 2;
	private final int CHARACTER_CLERIC = 3;
	private final int CHARACTER_ENGINEER = 4;
	private final int CHARACTER_MAGE = 5;
	private final int CHARACTER_RANGER = 6;
	private final int PLAY_GAME = 7;
	
	private static final float AUTOWRAP_WIDTH = 525;
	
	private void createMenuChildScene()
	{
	    gameChildScene = new MenuScene(camera);
	    gameChildScene.setPosition(0, 0);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Character Selection Menu Button Items
	    ////////////////////////////////////////////////////////////////////////////////////
	    warriorMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHARACTER_WARRIOR, resourcesManager.warriorButton, vbom), 1.2f, 1);
	    knightMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHARACTER_KNIGHT, resourcesManager.knightButton, vbom), 1.2f, 1);
	    assassinMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHARACTER_ASSASSIN, resourcesManager.assassinButton, vbom), 1.2f, 1);
	    clericMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHARACTER_CLERIC, resourcesManager.clericButton, vbom), 1.2f, 1);
	    engineerMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHARACTER_ENGINEER, resourcesManager.engineerButton, vbom), 1.2f, 1);
	    mageMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHARACTER_MAGE, resourcesManager.mageButton, vbom), 1.2f, 1);
	    rangerMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(CHARACTER_RANGER, resourcesManager.rangerButton, vbom), 1.2f, 1);
	    playGameMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAY_GAME, resourcesManager.playGameButton, vbom), 1.2f, 1);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Character Selection Sprite Class Portraits
	    ////////////////////////////////////////////////////////////////////////////////////
	    warrior = new Sprite(0, 0, resourcesManager.warriorCharacter, this.engine.getVertexBufferObjectManager());
	   // final Sprite knight = new Sprite(50, 50, resourcesManager.knightCharacter, this.engine.getVertexBufferObjectManager());
	    //final Sprite assassin = new Sprite(50, 50, resourcesManager.assassinCharacter, this.engine.getVertexBufferObjectManager());
	    //final Sprite engineer = new Sprite(50, 50, resourcesManager.engineerCharacter, this.engine.getVertexBufferObjectManager());
	   // final Sprite cleric = new Sprite(50, 50, resourcesManager.clericCharacter, this.engine.getVertexBufferObjectManager());
	   //final Sprite mage = new Sprite(50, 50, resourcesManager.mageCharacter, this.engine.getVertexBufferObjectManager());
	    
	    /////////////////////////////////////////////////////////////////////////////////////
	    //Create Button Texts
	    /////////////////////////////////////////////////////////////////////////////////////
	    warriorButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		warriorButtonText.setText("Warrior");
		
		rangerButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		rangerButtonText.setText("Ranger");
		
		clericButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		clericButtonText.setText("Cleric");
		
		knightButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		knightButtonText.setText("Knight");

		assassinButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		assassinButtonText.setText("Assassin");
		
		engineerButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		engineerButtonText.setText("Engineer");
		
		mageButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		mageButtonText.setText("Mage");
		
		startButtonText = new Text(10,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		startButtonText.setText("Start Game");
		
		////////////////////////////////////////////////////////////////////////////////////
	    //Add Button Texts to Buttons
	    ////////////////////////////////////////////////////////////////////////////////////
	    warriorMenuItem.attachChild(warriorButtonText);
	    rangerMenuItem.attachChild(rangerButtonText);
	    clericMenuItem.attachChild(clericButtonText);
	    knightMenuItem.attachChild(knightButtonText);
	    assassinMenuItem.attachChild(assassinButtonText);
	    engineerMenuItem.attachChild(engineerButtonText);
	    mageMenuItem.attachChild(mageButtonText);
	    playGameMenuItem.attachChild(startButtonText);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Add Buttons to Character Selection Scene
	    ////////////////////////////////////////////////////////////////////////////////////
	    gameChildScene.addMenuItem(warriorMenuItem);
	    gameChildScene.addMenuItem(knightMenuItem);
	    gameChildScene.addMenuItem(assassinMenuItem);
	    gameChildScene.addMenuItem(clericMenuItem);
	    gameChildScene.addMenuItem(engineerMenuItem);
	    gameChildScene.addMenuItem(mageMenuItem);
	    gameChildScene.addMenuItem(rangerMenuItem);
	    gameChildScene.addMenuItem(playGameMenuItem);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Attach Sprite Class Portraits to Character Selection Scene
	    ////////////////////////////////////////////////////////////////////////////////////
	    gameChildScene.attachChild(warrior);
	    //gameChildScene.attachChild(knight);
	    //gameChildScene.attachChild(assassin);
	    //gameChildScene.attachChild(engineer);
	    //gameChildScene.attachChild(cleric);
	    //gameChildScene.attachChild(mage);
	    
	    gameChildScene.buildAnimations();
	    gameChildScene.setBackgroundEnabled(false);
	    
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Set Position of Character Selection Buttons
	    ////////////////////////////////////////////////////////////////////////////////////
	    warriorMenuItem.setPosition(25, 20);
	    rangerMenuItem.setPosition(25, 85);
	    clericMenuItem.setPosition(25, 150);
	    knightMenuItem.setPosition(25, 215);
	    assassinMenuItem.setPosition(25, 280);
	    engineerMenuItem.setPosition(25, 345);
	    mageMenuItem.setPosition(25, 410);
	    
	    playGameMenuItem.setPosition(575, 410);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Set Position of Sprite Class Portraits
	    ////////////////////////////////////////////////////////////////////////////////////
	    warrior.setPosition(200, 20);
	    warrior.setVisible(false);
	   
	    playGameMenuItem.setVisible(false);
	    
	    gameChildScene.setOnMenuItemClickListener(this);
	    
	    setChildScene(gameChildScene);
	}

	private void createBackground()
	{
	    setBackground(new Background(Color.BLUE));
	}
	
	private void createHUD()
	{
		characterHUD = new HUD();
		
		
		////////////////////////////////////////////////////////////////////////////////////
	    //Create Class Description Texts
	    ////////////////////////////////////////////////////////////////////////////////////
		warriorText = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		warriorText.setText("This is an auto wrapped text that will be used to describe the Warrior class");
		
		knightText = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		knightText.setText("This is an auto wrapped text that will be used to describe the Knight class");
		
		assassinText = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		assassinText.setText("This is an auto wrapped text that will be used to describe the Assassin class");
		
		clericText = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		clericText.setText("This is an auto wrapped text that will be used to describe the Cleric class");
		
		engineerText = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		engineerText.setText("This is an auto wrapped text that will be used to describe the Engineer class");
		
		mageText = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		mageText.setText("This is an auto wrapped text that will be used to describe the Mage class");
	    
		rangerText = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		rangerText.setText("This is an auto wrapped text that will be used to describe the Ranger class");
		////////////////////////////////////////////////////////////////////////////////////
	    //Create Stats Texts
	    ////////////////////////////////////////////////////////////////////////////////////
		strengthStatText = new Text(375, 25, resourcesManager.font, "" ,150, new TextOptions(HorizontalAlign.RIGHT), vbom);
		strengthStatText.setText("Strength: ");
		
		dexterityStatText = new Text(375, 65, resourcesManager.font, "" ,150, new TextOptions(HorizontalAlign.RIGHT), vbom);
		dexterityStatText.setText("Dexterity: ");
		
		vitalityStatText = new Text(375, 105, resourcesManager.font, "" ,150, new TextOptions(HorizontalAlign.RIGHT), vbom);
		vitalityStatText.setText("Vitality: ");
		
		intelligenceStatText = new Text(375, 145, resourcesManager.font, "" ,150, new TextOptions(HorizontalAlign.RIGHT), vbom);
		intelligenceStatText.setText("Intelligence: ");
		
		////////////////////////////////////////////////////////////////////////////////////
	    //Attach Class Description Texts
	    ////////////////////////////////////////////////////////////////////////////////////
	    characterHUD.attachChild(warriorText);
	    characterHUD.attachChild(knightText);
	    characterHUD.attachChild(assassinText);
	    characterHUD.attachChild(clericText);
	    characterHUD.attachChild(engineerText);
	    characterHUD.attachChild(mageText);
	    characterHUD.attachChild(rangerText);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Attach Stats Texts
	    ////////////////////////////////////////////////////////////////////////////////////
	    characterHUD.attachChild(intelligenceStatText);
	    characterHUD.attachChild(vitalityStatText);
	    characterHUD.attachChild(dexterityStatText);
	    characterHUD.attachChild(strengthStatText);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Hide Class Description Texts Until Called
	    ////////////////////////////////////////////////////////////////////////////////////
	    warriorText.setVisible(false);
	    knightText.setVisible(false);
	    assassinText.setVisible(false);
	    clericText.setVisible(false);
	    engineerText.setVisible(false);
	    mageText.setVisible(false);
	    rangerText.setVisible(false);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Hide Class Description Texts Until Called
	    ////////////////////////////////////////////////////////////////////////////////////
	    intelligenceStatText.setVisible(false);
	    vitalityStatText.setVisible(false);
	    dexterityStatText.setVisible(false);
	    strengthStatText.setVisible(false);
	    
	    camera.setHUD(characterHUD);
	}
	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{
		
		switch(pMenuItem.getID())
		{
	        case CHARACTER_WARRIOR:
	        	showWarriorText();
	            return true;
	        case CHARACTER_KNIGHT:
	        	showKnightText();
	            return true;
	        case CHARACTER_ASSASSIN:
	        	showAssassinText();
	            return true;
	        case CHARACTER_CLERIC:
	        	showClericText();
	            return true;
	        case CHARACTER_ENGINEER:
	        	showEngineerText();
	            return true;
	        case CHARACTER_MAGE:
	        	showMageText();
	        	return true;
	        case CHARACTER_RANGER:
	        	showRangerText();
	        	return true;
	        case PLAY_GAME:
	        	this.disposeScene();
	        	SceneManager.getInstance().loadGameScene(engine);
	            return true;
	        default:
	            return false;
	    }
	}
	private void showWarriorText()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Show Play Button, Warrior Class Description and Image
		////////////////////////////////////////////////////////////////////////////////////
		playGameMenuItem.setVisible(true);
		warriorText.setVisible(true);
		warrior.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Show Stats
		////////////////////////////////////////////////////////////////////////////////////
	    intelligenceStatText.setVisible(true);
	    vitalityStatText.setVisible(true);
	    dexterityStatText.setVisible(true);
	    strengthStatText.setVisible(true);
	    
    	if(knightText.isVisible())
    	{
    		knightText.setVisible(false);
    	}
    	if(assassinText.isVisible())
    	{
    		assassinText.setVisible(false);
    	}
    	if(clericText.isVisible())
    	{
    		clericText.setVisible(false);
    	}
    	if(engineerText.isVisible())
    	{
    		engineerText.setVisible(false);
    	}
    	if(mageText.isVisible())
    	{
    		mageText.setVisible(false);
    	}
    	if(rangerText.isVisible())
    	{
    		rangerText.setVisible(false);
    	}
	}
	private void showKnightText()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Show Play Button, Knight Class Description and Image
		////////////////////////////////////////////////////////////////////////////////////
		playGameMenuItem.setVisible(true);
		knightText.setVisible(true);
		warrior.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Show Stats
		////////////////////////////////////////////////////////////////////////////////////
	    intelligenceStatText.setVisible(true);
	    vitalityStatText.setVisible(true);
	    dexterityStatText.setVisible(true);
	    strengthStatText.setVisible(true);
	    
    	if(warriorText.isVisible())
    	{
    		warriorText.setVisible(false);
    	}
    	if(assassinText.isVisible())
    	{
    		assassinText.setVisible(false);
    	}
    	if(clericText.isVisible())
    	{
    		clericText.setVisible(false);
    	}
    	if(engineerText.isVisible())
    	{
    		engineerText.setVisible(false);
    	}
    	if(mageText.isVisible())
    	{
    		mageText.setVisible(false);
    	}
    	if(rangerText.isVisible())
    	{
    		rangerText.setVisible(false);
    	}
	}
	private void showAssassinText()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Show Play Button, Assassin Class Description and Image
		////////////////////////////////////////////////////////////////////////////////////
		playGameMenuItem.setVisible(true);
		assassinText.setVisible(true);
		warrior.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Show Stats
		////////////////////////////////////////////////////////////////////////////////////
	    intelligenceStatText.setVisible(true);
	    vitalityStatText.setVisible(true);
	    dexterityStatText.setVisible(true);
	    strengthStatText.setVisible(true);
    	if(warriorText.isVisible())
    	{
    		warriorText.setVisible(false);
    	}
    	if(knightText.isVisible())
    	{
    		knightText.setVisible(false);
    	}
    	if(clericText.isVisible())
    	{
    		clericText.setVisible(false);
    	}
    	if(engineerText.isVisible())
    	{
    		engineerText.setVisible(false);
    	}
    	if(mageText.isVisible())
    	{
    		mageText.setVisible(false);
    	}
    	if(rangerText.isVisible())
    	{
    		rangerText.setVisible(false);
    	}
	}
	private void showClericText()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Show Play Button, Cleric Class Description and Image
		////////////////////////////////////////////////////////////////////////////////////
		playGameMenuItem.setVisible(true);
		clericText.setVisible(true);
		warrior.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Show Stats
		////////////////////////////////////////////////////////////////////////////////////
	    intelligenceStatText.setVisible(true);
	    vitalityStatText.setVisible(true);
	    dexterityStatText.setVisible(true);
	    strengthStatText.setVisible(true);
    	if(warriorText.isVisible())
    	{
    		warriorText.setVisible(false);
    	}
    	if(knightText.isVisible())
    	{
    		knightText.setVisible(false);
    	}
    	if(assassinText.isVisible())
    	{
    		assassinText.setVisible(false);
    	}
    	if(engineerText.isVisible())
    	{
    		engineerText.setVisible(false);
    	}
    	if(mageText.isVisible())
    	{
    		mageText.setVisible(false);
    	}
    	if(rangerText.isVisible())
    	{
    		rangerText.setVisible(false);
    	}
	}
	private void showEngineerText()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Show Play Button, Engineer Class Description and Image
		////////////////////////////////////////////////////////////////////////////////////
		playGameMenuItem.setVisible(true);
		engineerText.setVisible(true);
		warrior.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Show Stats
		////////////////////////////////////////////////////////////////////////////////////
	    intelligenceStatText.setVisible(true);
	    vitalityStatText.setVisible(true);
	    dexterityStatText.setVisible(true);
	    strengthStatText.setVisible(true);
    	if(warriorText.isVisible())
    	{
    		warriorText.setVisible(false);
    	}
    	if(knightText.isVisible())
    	{
    		knightText.setVisible(false);
    	}
    	if(clericText.isVisible())
    	{
    		clericText.setVisible(false);
    	}
    	if(assassinText.isVisible())
    	{
    		assassinText.setVisible(false);
    	}
    	if(mageText.isVisible())
    	{
    		mageText.setVisible(false);
    	}
    	if(rangerText.isVisible())
    	{
    		rangerText.setVisible(false);
    	}
	}
	private void showMageText()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Show Play Button, Mage Class Description and Image
		////////////////////////////////////////////////////////////////////////////////////
		playGameMenuItem.setVisible(true);
		mageText.setVisible(true);
		warrior.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Show Stats
		////////////////////////////////////////////////////////////////////////////////////
	    intelligenceStatText.setVisible(true);
	    vitalityStatText.setVisible(true);
	    dexterityStatText.setVisible(true);
	    strengthStatText.setVisible(true);
    	if(warriorText.isVisible())
    	{
    		warriorText.setVisible(false);
    	}
    	if(knightText.isVisible())
    	{
    		knightText.setVisible(false);
    	}
    	if(clericText.isVisible())
    	{
    		clericText.setVisible(false);
    	}
    	if(engineerText.isVisible())
    	{
    		engineerText.setVisible(false);
    	}
    	if(assassinText.isVisible())
    	{
    		assassinText.setVisible(false);
    	}
    	if(rangerText.isVisible())
    	{
    		rangerText.setVisible(false);
    	}
	}
	private void showRangerText()
	{
		////////////////////////////////////////////////////////////////////////////////////
		//Show Play Button, Mage Class Description and Image
		////////////////////////////////////////////////////////////////////////////////////
		playGameMenuItem.setVisible(true);
		rangerText.setVisible(true);
		warrior.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Show Stats
		////////////////////////////////////////////////////////////////////////////////////
		intelligenceStatText.setVisible(true);
		vitalityStatText.setVisible(true);
		dexterityStatText.setVisible(true);
		strengthStatText.setVisible(true);
		if(warriorText.isVisible())
		{
			warriorText.setVisible(false);
		}
		if(knightText.isVisible())
		{
			knightText.setVisible(false);
		}
		if(clericText.isVisible())
		{
			clericText.setVisible(false);
		}
		if(engineerText.isVisible())
		{
			engineerText.setVisible(false);
		}
		if(assassinText.isVisible())
		{
			assassinText.setVisible(false);
		}
		if(mageText.isVisible())
    	{
    		mageText.setVisible(false);
    	}
		
	}
	private void createPhysics()
	{
	    physicsWorld = new FixedStepPhysicsWorld(60, new Vector2(0, -17), false); 
	    registerUpdateHandler(physicsWorld);
	}
    @Override
    public void createScene()
    {
    	
    	createBackground();
        createHUD();
        createMenuChildScene();
        createPhysics();
    }

    @Override
    public void onBackKeyPressed()
    {
    	SceneManager.getInstance().loadMenuScene(engine);
    }

 
    @Override
    public SceneType getSceneType()
    {
        return SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene()
    {
    	camera.setHUD(null);
        camera.setCenter(400, 240);

        // TODO code responsible for disposing scene
        // removing all game scene objects.
    }
    
}
