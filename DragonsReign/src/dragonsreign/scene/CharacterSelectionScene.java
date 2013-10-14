package dragonsreign.scene;


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
import org.andengine.util.HorizontalAlign;
import org.andengine.util.color.Color;

import android.util.Log;


import dragonsreign.scene.BaseScene;
import dragonsreign.util.PartyContainer;
import dragonsreign.character.characterclass.ClericClass;
import dragonsreign.character.characterclass.RangerClass;
import dragonsreign.character.characterclass.WarriorClass;
import dragonsreign.manager.ResourceManager;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SoundManager;
import dragonsreign.manager.SceneManager.SceneType;



public class CharacterSelectionScene extends BaseScene implements IOnMenuItemClickListener
{
	// ===========================================================
	// Constants
	// ===========================================================

	private final int WARRIOR_ID = 0;
	private final int RANGER_ID = 1;
	private final int CLERIC_ID = 2;
	private final int KNIGHT_ID = 3;
	private final int ASSASSIN_ID = 4;
	private final int ENGINEER_ID = 5;
	private final int MAGE_ID = 6;
	
	private final int PLAY_GAME = 7;
	
	private static final float AUTOWRAP_WIDTH = 525;
	
	// ===========================================================
	// Fields
	// ===========================================================

	private HUD characterHUD;
	private Text playerStats[], classButtonText[], classText[],
				 startButtonText;
	
	private MenuScene characterChildScene;
	private Sprite classSprite[];
	
	protected int playerSelected = -1;
	
	protected PartyContainer party;
	
	private IMenuItem classMenuItem[], playGameMenuItem;
    
	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{

		switch (pMenuItem.getID()) {
		case WARRIOR_ID:
			playerSelected = WARRIOR_ID;
			updateHUD();

			return true;
		case RANGER_ID:
			playerSelected = RANGER_ID;
			updateHUD();

			return true;
		case CLERIC_ID:
			playerSelected = CLERIC_ID;
			updateHUD();

			return true;
		case KNIGHT_ID:
			playerSelected = KNIGHT_ID;
			updateHUD();

			return true;
		case ASSASSIN_ID:
			playerSelected = ASSASSIN_ID;
			updateHUD();

			return true;
		case ENGINEER_ID:
			playerSelected = ENGINEER_ID;
			updateHUD();

			return true;
		case MAGE_ID:
			playerSelected = MAGE_ID;
			updateHUD();

			return true;

		case PLAY_GAME:
			if (playerSelected == WARRIOR_ID) {
				((DragonsReignActivity) activity).setParty(WARRIOR_ID);
			} else if (playerSelected == RANGER_ID) {
				((DragonsReignActivity) activity).setParty(RANGER_ID);
			} else if (playerSelected == CLERIC_ID) {
				((DragonsReignActivity) activity).setParty(CLERIC_ID);
			}

			this.disposeScene();
			ResourceManager.getInstance().unloadMenuTextures();
			ResourceManager.getInstance().unloadCharacterSelectGraphics();
			SceneManager.getInstance().setScene(
					SceneManager.SceneType.SCENE_GAME);
			SoundManager.mMenuMusic.stop();
			SoundManager.mMenuThemeMusic.play();

			return true;
		default:
			return false;
		}
	}
	
	@Override
    public void createScene()
    {
    	classText = new Text[7];
		playerStats = new Text[7];
		classButtonText = new Text[7];
		classSprite = new Sprite[7];
		classMenuItem = new IMenuItem[7];
    	
    	createBackground();
    	createHUD();
    	createMenuChildScene();
    }

	@Override
    public void onBackKeyPressed()
    {
    	SceneManager.getInstance().setScene(SceneManager.SceneType.SCENE_MENU);
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
	
	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	
	private void createBackground() {
		setBackground(new Background(Color.BLUE));
	}
    
	private void createHUD() {
		characterHUD = new HUD();
		
		////////////////////////////////////////////////////////////////////////////////////
	    //Create Class Description Texts
	    ////////////////////////////////////////////////////////////////////////////////////
		classText[WARRIOR_ID] = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		classText[WARRIOR_ID].setText("Master of brute force melee combat, capable of frightening the foe with appearance alone.");
		
		classText[RANGER_ID] = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		classText[RANGER_ID].setText("Master of ranged attacks, capable of killing with pinpoint precision from afar.");
		
		classText[CLERIC_ID] = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		classText[CLERIC_ID].setText("Master of healing magics, capable of giving the wounded another chance at life.");
		
		classText[KNIGHT_ID] = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		classText[KNIGHT_ID].setText("Knight class not yet implemented.");
		
		classText[ASSASSIN_ID] = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		classText[ASSASSIN_ID].setText("Assassin class not yet implemented.");
		
		classText[ENGINEER_ID] = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		classText[ENGINEER_ID].setText("Engineer class not yet implemented.");
		
		classText[MAGE_ID] = new Text(250, 250, resourcesManager.font, "" ,150, new TextOptions(AutoWrap.WORDS,AUTOWRAP_WIDTH,HorizontalAlign.LEFT), vbom);
		classText[MAGE_ID].setText("Mage class not yet implemented.");
	    
		////////////////////////////////////////////////////////////////////////////////////
		//Attach Class Description Texts
		////////////////////////////////////////////////////////////////////////////////////
		characterHUD.attachChild(classText[WARRIOR_ID]);
		characterHUD.attachChild(classText[RANGER_ID]);
		characterHUD.attachChild(classText[CLERIC_ID]);
		characterHUD.attachChild(classText[KNIGHT_ID]);
		characterHUD.attachChild(classText[ASSASSIN_ID]);
		characterHUD.attachChild(classText[ENGINEER_ID]);
		characterHUD.attachChild(classText[MAGE_ID]);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Hide Class Description Texts Until Called
		////////////////////////////////////////////////////////////////////////////////////
		classText[WARRIOR_ID].setVisible(false);
		classText[RANGER_ID].setVisible(false);
		classText[CLERIC_ID].setVisible(false);
		classText[KNIGHT_ID].setVisible(false);
		classText[ASSASSIN_ID].setVisible(false);
		classText[ENGINEER_ID].setVisible(false);
		classText[MAGE_ID].setVisible(false);
		
		playerStats[WARRIOR_ID] = new Text(0, 0, resourcesManager.font, "", 150,
				new TextOptions(HorizontalAlign.LEFT), vbom);
		playerStats[RANGER_ID] = new Text(0, 0, resourcesManager.font, "", 150,
				new TextOptions(HorizontalAlign.LEFT), vbom);
		playerStats[CLERIC_ID] = new Text(0, 0, resourcesManager.font, "", 150,
				new TextOptions(HorizontalAlign.LEFT), vbom);
		playerStats[KNIGHT_ID] = new Text(0, 0, resourcesManager.font, "", 150,
				new TextOptions(HorizontalAlign.LEFT), vbom);
		playerStats[ASSASSIN_ID] = new Text(0, 0, resourcesManager.font, "", 150,
				new TextOptions(HorizontalAlign.LEFT), vbom);
		playerStats[ENGINEER_ID] = new Text(0, 0, resourcesManager.font, "", 150,
				new TextOptions(HorizontalAlign.LEFT), vbom);
		playerStats[MAGE_ID] = new Text(0, 0, resourcesManager.font, "", 150,
				new TextOptions(HorizontalAlign.LEFT), vbom);

		playerStats[WARRIOR_ID].setPosition(250, 10);
		playerStats[RANGER_ID].setPosition(250, 10);
		playerStats[CLERIC_ID].setPosition(250, 10);
		playerStats[KNIGHT_ID].setPosition(250, 10);
		playerStats[ASSASSIN_ID].setPosition(250, 10);
		playerStats[ENGINEER_ID].setPosition(250, 10);
		playerStats[MAGE_ID].setPosition(250, 10);
		
		characterHUD.attachChild(playerStats[WARRIOR_ID]);
		characterHUD.attachChild(playerStats[RANGER_ID]);
		characterHUD.attachChild(playerStats[CLERIC_ID]);
		characterHUD.attachChild(playerStats[KNIGHT_ID]);
		characterHUD.attachChild(playerStats[ASSASSIN_ID]);
		characterHUD.attachChild(playerStats[ENGINEER_ID]);
		characterHUD.attachChild(playerStats[MAGE_ID]);
		
		playerStats[WARRIOR_ID].setVisible(false);
		playerStats[RANGER_ID].setVisible(false);
		playerStats[CLERIC_ID].setVisible(false);
		playerStats[KNIGHT_ID].setVisible(false);
		playerStats[ASSASSIN_ID].setVisible(false);
		playerStats[ENGINEER_ID].setVisible(false);
		playerStats[MAGE_ID].setVisible(false);

	    camera.setHUD(characterHUD);
	}
	
	private void createMenuChildScene() {
	    characterChildScene = new MenuScene(camera);
	    characterChildScene.setPosition(0, 0);
	   
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Character Selection Menu Button Items
	    ////////////////////////////////////////////////////////////////////////////////////
	    classMenuItem[WARRIOR_ID] = new ScaleMenuItemDecorator(new SpriteMenuItem(WARRIOR_ID, resourcesManager.warriorButton, vbom), 1.2f, 1);
	    classMenuItem[RANGER_ID] = new ScaleMenuItemDecorator(new SpriteMenuItem(RANGER_ID, resourcesManager.rangerButton, vbom), 1.2f, 1);
	    classMenuItem[CLERIC_ID] = new ScaleMenuItemDecorator(new SpriteMenuItem(CLERIC_ID, resourcesManager.clericButton, vbom), 1.2f, 1);
	    classMenuItem[KNIGHT_ID] = new ScaleMenuItemDecorator(new SpriteMenuItem(KNIGHT_ID, resourcesManager.knightButton, vbom), 1.2f, 1);
	    classMenuItem[ASSASSIN_ID] = new ScaleMenuItemDecorator(new SpriteMenuItem(ASSASSIN_ID, resourcesManager.assassinButton, vbom), 1.2f, 1);
	    classMenuItem[ENGINEER_ID] = new ScaleMenuItemDecorator(new SpriteMenuItem(ENGINEER_ID, resourcesManager.engineerButton, vbom), 1.2f, 1);
	    classMenuItem[MAGE_ID] = new ScaleMenuItemDecorator(new SpriteMenuItem(MAGE_ID, resourcesManager.mageButton, vbom), 1.2f, 1);
	   
	    playGameMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(PLAY_GAME, resourcesManager.playGameButton, vbom), 1.2f, 1);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Character Selection Sprite Class Portraits
	    ////////////////////////////////////////////////////////////////////////////////////
	    classSprite[WARRIOR_ID] = new Sprite(0, 0, resourcesManager.warriorCharacter, this.engine.getVertexBufferObjectManager());
	    //classSprite[RANGER_ID] = new Sprite(0, 0, resourcesManager.rangerCharacter, this.engine.getVertexBufferObjectManager());
	    //classSprite[CLERIC_ID] = new Sprite(0, 0, resourcesManager.clericCharacter, this.engine.getVertexBufferObjectManager());
	    //classSprite[KNIGHT_ID] = new Sprite(0, 0, resourcesManager.knightCharacter, this.engine.getVertexBufferObjectManager());
	    //classSprite[ASSASSIN_ID] = new Sprite(0, 0, resourcesManager.assassinCharacter, this.engine.getVertexBufferObjectManager());
	    //classSprite[ENGINEER_ID] = new Sprite(0, 0, resourcesManager.engineerCharacter, this.engine.getVertexBufferObjectManager());
	    //classSprite[MAGE_ID] = new Sprite(0, 0, resourcesManager.mageCharacter, this.engine.getVertexBufferObjectManager());
	    
	    /////////////////////////////////////////////////////////////////////////////////////
	    //Create Button Texts
	    /////////////////////////////////////////////////////////////////////////////////////
	    classButtonText[WARRIOR_ID] = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		classButtonText[WARRIOR_ID].setText("Warrior");
		
		classButtonText[RANGER_ID] = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		classButtonText[RANGER_ID].setText("Ranger");
		
		classButtonText[CLERIC_ID] = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		classButtonText[CLERIC_ID].setText("Cleric");
		
		classButtonText[KNIGHT_ID] = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		classButtonText[KNIGHT_ID].setText("Knight");

		classButtonText[ASSASSIN_ID] = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		classButtonText[ASSASSIN_ID].setText("Assassin");
		
		classButtonText[ENGINEER_ID] = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		classButtonText[ENGINEER_ID].setText("Engineer");
		
		classButtonText[MAGE_ID] = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		classButtonText[MAGE_ID].setText("Mage");
		
		startButtonText = new Text(10,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
		startButtonText.setText("Start Game");
		
		////////////////////////////////////////////////////////////////////////////////////
	    //Add Button Texts to Buttons
	    ////////////////////////////////////////////////////////////////////////////////////
		classMenuItem[WARRIOR_ID].attachChild(classButtonText[WARRIOR_ID]);
		classMenuItem[RANGER_ID].attachChild(classButtonText[RANGER_ID]);
		classMenuItem[CLERIC_ID].attachChild(classButtonText[CLERIC_ID]);
		classMenuItem[KNIGHT_ID].attachChild(classButtonText[KNIGHT_ID]);
		classMenuItem[ASSASSIN_ID].attachChild(classButtonText[ASSASSIN_ID]);
		classMenuItem[ENGINEER_ID].attachChild(classButtonText[ENGINEER_ID]);
		classMenuItem[MAGE_ID].attachChild(classButtonText[MAGE_ID]);
	    
	    playGameMenuItem.attachChild(startButtonText);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Add Buttons to Character Selection Scene
	    ////////////////////////////////////////////////////////////////////////////////////
	    characterChildScene.addMenuItem(classMenuItem[WARRIOR_ID]);
	    characterChildScene.addMenuItem(classMenuItem[RANGER_ID]);
	    characterChildScene.addMenuItem(classMenuItem[CLERIC_ID]);
	    characterChildScene.addMenuItem(classMenuItem[KNIGHT_ID]);
	    characterChildScene.addMenuItem(classMenuItem[ASSASSIN_ID]);
	    characterChildScene.addMenuItem(classMenuItem[ENGINEER_ID]);
	    characterChildScene.addMenuItem(classMenuItem[MAGE_ID]);
	    
	    characterChildScene.addMenuItem(playGameMenuItem);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Attach Sprite Class Portraits to Character Selection Scene
	    ////////////////////////////////////////////////////////////////////////////////////
	    characterChildScene.attachChild(classSprite[WARRIOR_ID]);
	    //characterChildScene.attachChild(classSprite[RANGER_ID]);
	    //characterChildScene.attachChild(classSprite[CLERIC_ID]);
	    //characterChildScene.attachChild(classSprite[KNIGHT_ID]);
	    //characterChildScene.attachChild(classSprite[ASSASSIN_ID]);
	    //characterChildScene.attachChild(classSprite[ENGINEER_ID]);
	    //characterChildScene.attachChild(classSprite[MAGE_ID]);
	    
	    characterChildScene.buildAnimations();
	    characterChildScene.setBackgroundEnabled(false);
	    
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Set Position of Character Selection Buttons
	    ////////////////////////////////////////////////////////////////////////////////////
	    classMenuItem[WARRIOR_ID].setPosition(25, 20);
	    classMenuItem[RANGER_ID].setPosition(25, 85);
	    classMenuItem[CLERIC_ID].setPosition(25, 150);
	    classMenuItem[KNIGHT_ID].setPosition(25, 215);
	    classMenuItem[ASSASSIN_ID].setPosition(25, 280);
	    classMenuItem[ENGINEER_ID].setPosition(25, 345);
	    classMenuItem[MAGE_ID].setPosition(25, 410);
	    
	    playGameMenuItem.setPosition(575, 410);
	    
	    ////////////////////////////////////////////////////////////////////////////////////
	    //Set Position of Sprite Class Portraits
	    ////////////////////////////////////////////////////////////////////////////////////
	    classSprite[WARRIOR_ID].setPosition(600, 20);
	    //classSprite[RANGER_ID].setPosition(200, 20);
	    //classSprite[CLERIC_ID].setPosition(200, 20);
	    //classSprite[KNIGHT_ID].setPosition(200, 20);
	    //classSprite[ASSASSIN_ID].setPosition(200, 20);
	    //classSprite[ENGINEER_ID].setPosition(200, 20);
	    //classSprite[MAGE_ID].setPosition(200, 20);
	    
	    classSprite[WARRIOR_ID].setVisible(false);
	    //classSprite[RANGER_ID].setVisible(false);
	    //classSprite[CLERIC_ID].setVisible(false);
	    //classSprite[KNIGHT_ID].setVisible(false);
	    //classSprite[ASSASSIN_ID].setVisible(false);
	    //classSprite[ENGINEER_ID].setVisible(false);
	    //classSprite[MAGE_ID].setVisible(false);
	   
	    playGameMenuItem.setVisible(false);
	    
	    characterChildScene.setOnMenuItemClickListener(this);
	    
	    setChildScene(characterChildScene);
	}
	
	private void updateHUD() {
		if (playerSelected == WARRIOR_ID) {
			playerStats[WARRIOR_ID].setText("Strength: "
							+ ((DragonsReignActivity)activity).getWarrior().getBaseStats().getStrength() + "\n"
							+ "Dexterity: "
							+ ((DragonsReignActivity)activity).getWarrior().getBaseStats().getDexterity()
							+ "\n" + "Intelligence: "
							+ ((DragonsReignActivity)activity).getWarrior().getBaseStats().getIntelligence()
							+ "\n" + "Vitality: "
							+ ((DragonsReignActivity)activity).getWarrior().getBaseStats().getVitality());

			classSprite[WARRIOR_ID].setVisible(true);
			//classSprite[RANGER_ID].setVisible(false);
			//classSprite[CLERIC_ID].setVisible(true);
			//classSprite[KNIGHT_ID].setVisible(false);
			//classSprite[ASSASSIN_ID].setVisible(false);
			//classSprite[ENGINEER_ID].setVisible(false);
			//classSprite[MAGE_ID].setVisible(false);
			
			classText[WARRIOR_ID].setVisible(true);
			classText[RANGER_ID].setVisible(false);
			classText[CLERIC_ID].setVisible(false);
			classText[KNIGHT_ID].setVisible(false);
			classText[ASSASSIN_ID].setVisible(false);
			classText[ENGINEER_ID].setVisible(false);
			classText[MAGE_ID].setVisible(false);
			
			playerStats[WARRIOR_ID].setVisible(true);
			playerStats[RANGER_ID].setVisible(false);
			playerStats[CLERIC_ID].setVisible(false);
			playerStats[KNIGHT_ID].setVisible(false); 
			playerStats[ASSASSIN_ID].setVisible(false);
			playerStats[ENGINEER_ID].setVisible(false);
			playerStats[MAGE_ID].setVisible(false);
			
			playGameMenuItem.setVisible(true);
			
		} else if (playerSelected == RANGER_ID) {
			playerStats[RANGER_ID].setText("Strength: "
					+ ((DragonsReignActivity)activity).getRanger().getBaseStats().getStrength() + "\n"
					+ "Dexterity: "
					+ ((DragonsReignActivity)activity).getRanger().getBaseStats().getDexterity() + "\n"
					+ "Intelligence: "
					+ ((DragonsReignActivity)activity).getRanger().getBaseStats().getIntelligence() + "\n"
					+ "Vitality: " + ((DragonsReignActivity)activity).getRanger().getBaseStats().getVitality());

			classSprite[WARRIOR_ID].setVisible(false);
			//classSprite[RANGER_ID].setVisible(true);
			//classSprite[CLERIC_ID].setVisible(false);
			//classSprite[KNIGHT_ID].setVisible(false);
			//classSprite[ASSASSIN_ID].setVisible(false);
			//classSprite[ENGINEER_ID].setVisible(false);
			//classSprite[MAGE_ID].setVisible(false);
			
			classText[WARRIOR_ID].setVisible(false);
			classText[RANGER_ID].setVisible(true);
			classText[CLERIC_ID].setVisible(false);
			classText[KNIGHT_ID].setVisible(false);
			classText[ASSASSIN_ID].setVisible(false);
			classText[ENGINEER_ID].setVisible(false);
			classText[MAGE_ID].setVisible(false);
			
			playerStats[WARRIOR_ID].setVisible(false);
			playerStats[RANGER_ID].setVisible(true);
			playerStats[CLERIC_ID].setVisible(false);
			playerStats[KNIGHT_ID].setVisible(false); 
			playerStats[ASSASSIN_ID].setVisible(false);
			playerStats[ENGINEER_ID].setVisible(false);
			playerStats[MAGE_ID].setVisible(false);
			
			playGameMenuItem.setVisible(true);

		} else if (playerSelected == CLERIC_ID) {
			playerStats[CLERIC_ID].setText("Strength: "
					+ ((DragonsReignActivity)activity).getCleric().getBaseStats().getStrength() + "\n"
					+ "Dexterity: "
					+ ((DragonsReignActivity)activity).getCleric().getBaseStats().getDexterity() + "\n"
					+ "Intelligence: "
					+ ((DragonsReignActivity)activity).getCleric().getBaseStats().getIntelligence() + "\n"
					+ "Vitality: " + ((DragonsReignActivity)activity).getCleric().getBaseStats().getVitality());

			classSprite[WARRIOR_ID].setVisible(false);
			//classSprite[RANGER_ID].setVisible(false);
			//classSprite[CLERIC_ID].setVisible(true);
			//classSprite[KNIGHT_ID].setVisible(false);
			//classSprite[ASSASSIN_ID].setVisible(false);
			//classSprite[ENGINEER_ID].setVisible(false);
			//classSprite[MAGE_ID].setVisible(false);
			
			classText[WARRIOR_ID].setVisible(false);
			classText[RANGER_ID].setVisible(false);
			classText[CLERIC_ID].setVisible(true);
			classText[KNIGHT_ID].setVisible(false);
			classText[ASSASSIN_ID].setVisible(false);
			classText[ENGINEER_ID].setVisible(false);
			classText[MAGE_ID].setVisible(false);
			
			playerStats[WARRIOR_ID].setVisible(false);
			playerStats[RANGER_ID].setVisible(false);
			playerStats[CLERIC_ID].setVisible(true);
			playerStats[KNIGHT_ID].setVisible(false); 
			playerStats[ASSASSIN_ID].setVisible(false);
			playerStats[ENGINEER_ID].setVisible(false);
			playerStats[MAGE_ID].setVisible(false);
			
			playGameMenuItem.setVisible(true);
			
		} else if (playerSelected == KNIGHT_ID) {
			classSprite[WARRIOR_ID].setVisible(false);
			//classSprite[RANGER_ID].setVisible(false);
			//classSprite[CLERIC_ID].setVisible(false);
			//classSprite[KNIGHT_ID].setVisible(true);
			//classSprite[ASSASSIN_ID].setVisible(false);
			//classSprite[ENGINEER_ID].setVisible(false);
			//classSprite[MAGE_ID].setVisible(false);
			
			classText[WARRIOR_ID].setVisible(false);
			classText[RANGER_ID].setVisible(false);
			classText[CLERIC_ID].setVisible(false);
			classText[KNIGHT_ID].setVisible(true);
			classText[ASSASSIN_ID].setVisible(false);
			classText[ENGINEER_ID].setVisible(false);
			classText[MAGE_ID].setVisible(false);
			
			playerStats[WARRIOR_ID].setVisible(false);
			playerStats[RANGER_ID].setVisible(false);
			playerStats[CLERIC_ID].setVisible(false);
			playerStats[KNIGHT_ID].setVisible(false); // will be true
			playerStats[ASSASSIN_ID].setVisible(false);
			playerStats[ENGINEER_ID].setVisible(false);
			playerStats[MAGE_ID].setVisible(false);
			
			playGameMenuItem.setVisible(false);
			
		} else if (playerSelected == ASSASSIN_ID) {
			classSprite[WARRIOR_ID].setVisible(false);
			//classSprite[RANGER_ID].setVisible(false);
			//classSprite[CLERIC_ID].setVisible(false);
			//classSprite[KNIGHT_ID].setVisible(false);
			//classSprite[ASSASSIN_ID].setVisible(true);
			//classSprite[ENGINEER_ID].setVisible(false);
			//classSprite[MAGE_ID].setVisible(false);
			
			classText[WARRIOR_ID].setVisible(false);
			classText[RANGER_ID].setVisible(false);
			classText[CLERIC_ID].setVisible(false);
			classText[KNIGHT_ID].setVisible(false);
			classText[ASSASSIN_ID].setVisible(true);
			classText[ENGINEER_ID].setVisible(false);
			classText[MAGE_ID].setVisible(false);
			
			playerStats[WARRIOR_ID].setVisible(false);
			playerStats[RANGER_ID].setVisible(false);
			playerStats[CLERIC_ID].setVisible(false);
			playerStats[KNIGHT_ID].setVisible(false); 
			playerStats[ASSASSIN_ID].setVisible(false); // will be true
			playerStats[ENGINEER_ID].setVisible(false);
			playerStats[MAGE_ID].setVisible(false);
			
			playGameMenuItem.setVisible(false);
			
		} else if (playerSelected == ENGINEER_ID) {
			classSprite[WARRIOR_ID].setVisible(false);
			//classSprite[RANGER_ID].setVisible(false);
			//classSprite[CLERIC_ID].setVisible(false);
			//classSprite[KNIGHT_ID].setVisible(false);
			//classSprite[ASSASSIN_ID].setVisible(false);
			//classSprite[ENGINEER_ID].setVisible(true);
			//classSprite[MAGE_ID].setVisible(false);
			
			classText[WARRIOR_ID].setVisible(false);
			classText[RANGER_ID].setVisible(false);
			classText[CLERIC_ID].setVisible(false);
			classText[KNIGHT_ID].setVisible(false);
			classText[ASSASSIN_ID].setVisible(false);
			classText[ENGINEER_ID].setVisible(true);
			classText[MAGE_ID].setVisible(false);
			
			playerStats[WARRIOR_ID].setVisible(false);
			playerStats[RANGER_ID].setVisible(false);
			playerStats[CLERIC_ID].setVisible(false);
			playerStats[KNIGHT_ID].setVisible(false); 
			playerStats[ASSASSIN_ID].setVisible(false); 
			playerStats[ENGINEER_ID].setVisible(false); // will be true
			playerStats[MAGE_ID].setVisible(false);
			
			playGameMenuItem.setVisible(false);
			
		} else if (playerSelected == MAGE_ID) {
			classSprite[WARRIOR_ID].setVisible(false);
			//classSprite[RANGER_ID].setVisible(false);
			//classSprite[CLERIC_ID].setVisible(false);
			//classSprite[KNIGHT_ID].setVisible(false);
			//classSprite[ASSASSIN_ID].setVisible(false);
			//classSprite[ENGINEER_ID].setVisible(false);
			//classSprite[MAGE_ID].setVisible(true);
			
			classText[WARRIOR_ID].setVisible(false);
			classText[RANGER_ID].setVisible(false);
			classText[CLERIC_ID].setVisible(false);
			classText[KNIGHT_ID].setVisible(false);
			classText[ASSASSIN_ID].setVisible(false);
			classText[ENGINEER_ID].setVisible(false);
			classText[MAGE_ID].setVisible(true);
			
			playerStats[WARRIOR_ID].setVisible(false);
			playerStats[RANGER_ID].setVisible(false);
			playerStats[CLERIC_ID].setVisible(false);
			playerStats[KNIGHT_ID].setVisible(false); 
			playerStats[ASSASSIN_ID].setVisible(false); 
			playerStats[ENGINEER_ID].setVisible(false); 
			playerStats[MAGE_ID].setVisible(false); // will be true
			
			playGameMenuItem.setVisible(false);
		}
	}
}
