package dragonsreign.manager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePack;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackLoader;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackTextureRegionLibrary;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.TexturePackerTextureRegion;
import org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception.TexturePackParseException;

import android.graphics.Color;

import dragonsreign.texturepacker.AnimatedCharacter;
import dragonsreign.texturepacker.ClericAnimatedSprite;
import dragonsreign.texturepacker.MenuAssets;
import dragonsreign.texturepacker.GameAssets;
import dragonsreign.texturepacker.BattleAssets;
import dragonsreign.texturepacker.RangerAnimatedSprite;
import dragonsreign.texturepacker.WarriorAnimatedSprite;

import dragonsreign.scene.DragonsReignActivity;;


public class ResourceManager
{
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------
    
    private static final ResourceManager INSTANCE = new ResourceManager();
    
    public Engine engine;
    public DragonsReignActivity activity;
    public Camera camera;
    public VertexBufferObjectManager vbom;
    
    private TexturePackTextureRegionLibrary texturePackLibrary;
    private TexturePack texturePack;

	public ITextureRegion menuBackgroundRegion, characterSelectBackground,
			plainsBattleBackground, mountainsBattleBackground, playButton,
			optionsButton, companySplashLogo, warriorButton, knightButton,
			andEngineLogo, assassinButton, engineerButton, clericButton,
			mageButton, rangerButton, playGameButton, warriorCharacter,
			rangerCharacter, knightCharacter, assassinCharacter,
			engineerCharacter, clericCharacter, mageCharacter,
			character1Portrait, character2Portrait, character3Portrait,
			backPack, worldMap, inventoryArea, exitButton, equipmentArea,
			statsArea, itemsButton, abilitiesButton, swapButton, fleeButton,
			basicAttackButton, skillOneButton, skillTwoButton,
			skillThreeButton, skillFourButton, skillFiveButton, teamMember1,
			teamMember2, teamMember3, enemy1, enemy2, enemy3, warriorPlayer,
			DPADBacking, DPADKnob, leftArrow1, leftArrow2, leftArrow3,
			focusArrow, rightArrow1, rightArrow2, rightArrow3, Up_DPAD,
			Down_DPAD, Left_DPAD, Right_DPAD, Center_DPAD;
	
	public ITextureRegion amulet, heavyHelm,
			heavyLower, heavyUpper, lightHelm, lightLower, lightUpper,
			mediumHelm, mediumLower, mediumUpper, ring, shield;
	
	// weapons
	public ITextureRegion axe_1h, mace_1h, sword_1h, axe_2h, mace_2h, sword_2h,
			longbow1, arrow, bolt, crossbow, dagger, longbow2, orb, quiver,
			shortbow, staff, wand;
	// potions
	public ITextureRegion fullRevive, basicRevive, majorHealth, majorResource,
			minorHealth, minorResource, superiorHealth, superiorResource;
    
    public Font font, whiteFont, battleFont, inventoryFont;

	public TiledTextureRegion mWarriorTextureRegion, mClericTextureRegion, mRangerTextureRegion;

	private TexturePackTextureRegionLibrary mWarriorTexturePackTextureRegionLibrary, mClericTexturePackTextureRegionLibrary, mRangerTexturePackTextureRegionLibrary;


    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Menu Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadMenuResources()
    {
    	loadMenuGraphics();
        loadMenuAudio();
        loadMenuFonts();
        //sound stuff
        SoundManager.loadSounds(engine, activity);
        
    }
    private void loadMenuGraphics()
    {
    	try
    	{
    		texturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/menu/").loadFromAsset(activity.getAssets(), "MenuAssets.xml");
            texturePack.loadTexture();
            texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
    		
    	}
    	catch(final TexturePackParseException e)
    	{
    		Debug.e(e);
    	}
    	
    	menuBackgroundRegion = texturePackLibrary.get(MenuAssets.TITLE_ID);
    	playButton = texturePackLibrary.get(MenuAssets.LARGEMENUBUTTON_ID);
    	optionsButton = texturePackLibrary.get(MenuAssets.LARGEMENUBUTTON_ID);
    
    }
    private void loadMenuAudio()
    {
        
    }   
    private void loadMenuFonts()
    {
        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        final ITexture secondFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
        
        font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Zwiebelfisch.ttf", 30, true, Color.BLACK, 2, Color.BLACK);
        font.load();
        
        whiteFont = FontFactory.createStrokeFromAsset(activity.getFontManager(), secondFontTexture, activity.getAssets(), "Zwiebelfisch.ttf", 30, true, Color.WHITE, 0, Color.WHITE);
        whiteFont.load();
    }

	//////////////////////////////////////////////////////////////////////////
    //Unload Resources for Menu Scene
    //////////////////////////////////////////////////////////////////////////    
    public void unloadMenuTextures()
    {
       
        menuBackgroundRegion = null;
    	playButton  = null;
    	optionsButton  = null;
    }
    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Character Selection Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadCharacterSelectGraphics()
    {
    	
    	try
    	{
    		texturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/menu/").loadFromAsset(activity.getAssets(), "MenuAssets.xml");
            texturePack.loadTexture();
            texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
    		
    	}
    	catch(final TexturePackParseException e)
    	{
    		Debug.e(e);
    	}
    	
    	
		/////////////////////////////////////////////////////////////////////////////
		//Character Selection Buttons
		/////////////////////////////////////////////////////////////////////////////
    	warriorButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	knightButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	assassinButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	engineerButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	clericButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	mageButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	rangerButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	
    	playGameButton = texturePackLibrary.get(MenuAssets.MENUBUTTON_ID);
    	
		/////////////////////////////////////////////////////////////////////////////
		//Character Sprites
		/////////////////////////////////////////////////////////////////////////////
    	warriorCharacter = texturePackLibrary.get(MenuAssets.WARRIORBATTLESPRITE_ID);
    	clericCharacter = texturePackLibrary.get(MenuAssets.CLERICBATTLESPRITE_ID);
    	rangerCharacter = texturePackLibrary.get(MenuAssets.RANGERBATTLESPRITE_ID);
    	//knightCharacter = 
    	//assassinCharacter = 
    	//engineerCharacter = 
    	//clericCharacter = 
    	//mageCharacter = 
    	
    	characterSelectBackground = texturePackLibrary.get(MenuAssets.CHAR_SELECT_ID);
    	
    }
    public void unloadCharacterSelectGraphics()
    {
    	warriorButton = null;
    	knightButton  = null;
    	assassinButton  = null;
    	engineerButton = null;
    	clericButton  = null;
    	mageButton  = null;
    	rangerButton  = null;
    	warriorCharacter = null;
    	rangerCharacter = null;
    	clericCharacter = null;
    }
    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Game Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadGameResources()
    {
        loadGameGraphics();
        loadGameFonts();
        loadGameAudio();
    }
    
    private void loadGameGraphics()
    {
    	
    	try
    	{
    		texturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/game/").loadFromAsset(activity.getAssets(), "GameAssets.xml");
            texturePack.loadTexture();
            texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
           
			//Warrior texture packer
			TexturePack spriteSheetWarriorTexturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/Characters/").loadFromAsset(activity.getAssets(), "WarriorAnimatedSprite.xml");
			spriteSheetWarriorTexturePack.loadTexture();
			mWarriorTexturePackTextureRegionLibrary = spriteSheetWarriorTexturePack.getTexturePackTextureRegionLibrary();
			
			//Cleric texture packer
			TexturePack spriteSheetClericTexturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/Characters/").loadFromAsset(activity.getAssets(), "ClericAnimatedSprite.xml");
			spriteSheetClericTexturePack.loadTexture();
			mClericTexturePackTextureRegionLibrary = spriteSheetClericTexturePack.getTexturePackTextureRegionLibrary();
			
			//Ranger texture packer
			TexturePack spriteSheetRangerTexturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/Characters/").loadFromAsset(activity.getAssets(), "RangerAnimatedSprite.xml");
			spriteSheetRangerTexturePack.loadTexture();
			mRangerTexturePackTextureRegionLibrary = spriteSheetRangerTexturePack.getTexturePackTextureRegionLibrary();
    	}
    	catch(final TexturePackParseException e)
    	{
    		Debug.e(e);
    	}
    	
    	//Creating Warrior tiled region 
		TexturePackerTextureRegion WarriorTextureRegion = mWarriorTexturePackTextureRegionLibrary.get(WarriorAnimatedSprite.WARYAR_ID);
		
		mWarriorTextureRegion = TiledTextureRegion.create(WarriorTextureRegion.getTexture(),
		(int)WarriorTextureRegion.getTextureX(), (int)WarriorTextureRegion.getTextureY(), (int)WarriorTextureRegion.getWidth(), (int)WarriorTextureRegion.getHeight(), 3, 4, WarriorTextureRegion.isRotated());
    	
		//Creating Cleric tiled region 
		TexturePackerTextureRegion ClericTextureRegion = mClericTexturePackTextureRegionLibrary.get(ClericAnimatedSprite.CLERIC_ID);
		
		mClericTextureRegion = TiledTextureRegion.create(ClericTextureRegion.getTexture(),
		(int)ClericTextureRegion.getTextureX(), (int)ClericTextureRegion.getTextureY(), (int)ClericTextureRegion.getWidth(), (int)ClericTextureRegion.getHeight(), 3, 4, ClericTextureRegion.isRotated());
		
		//Creating Ranger tiled region 
		TexturePackerTextureRegion RangerTextureRegion = mRangerTexturePackTextureRegionLibrary.get(RangerAnimatedSprite.RANGER_ID);
		
		mRangerTextureRegion = TiledTextureRegion.create(RangerTextureRegion.getTexture(),
		(int)RangerTextureRegion.getTextureX(), (int)RangerTextureRegion.getTextureY(), (int)RangerTextureRegion.getWidth(), (int)RangerTextureRegion.getHeight(), 3, 4, RangerTextureRegion.isRotated());

    	
    	backPack = texturePackLibrary.get(GameAssets.BACKPACK_ID);
    	
    	worldMap = texturePackLibrary.get(GameAssets.WORLDMAP_ID);
    	
    	
    
    	
    	 
    	DPADBacking = texturePackLibrary.get(GameAssets.ONSCREEN_CONTROL_BASE_ID);
    	
    	DPADKnob = texturePackLibrary.get(GameAssets.ONSCREEN_CONTROL_KNOB_ID);
    	

    	
        //////////////////////////////////////////////////////////////////////////
        //Load TMX Stuff
        //////////////////////////////////////////////////////////////////////////
    	
    	
    }
    
    private void loadGameFonts()
    {
        
    }
    
    private void loadGameAudio()
    {
        
    }
    //////////////////////////////////////////////////////////////////////////
    //Unload Resources for Game Scene
    //////////////////////////////////////////////////////////////////////////
    public void unloadGameTextures()
    {
    	//TODO: Unload Game Textures
    	//gameTextureAtlas.unload();
    }
    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Inventory Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadInventoryResources()
    {
        loadInventoryGraphics();
        loadInventoryFonts();
        loadInventoryAudio();
    }
    
    private void loadInventoryGraphics()
    {
    	
    	try
    	{
    		texturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/game/").loadFromAsset(activity.getAssets(), "GameAssets.xml");
            texturePack.loadTexture();
            texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
    		
    	}
    	catch(final TexturePackParseException e)
    	{
    		Debug.e(e);
    	}
    	
    	
    	
    	
    	character1Portrait = texturePackLibrary.get(GameAssets.WARRIOR_PORTRAIT_ID);
    	
    	
    	character2Portrait = texturePackLibrary.get(GameAssets.CLERIC_PORTRAIT_ID);
    	character3Portrait = texturePackLibrary.get(GameAssets.RANGER_PORTRAIT_ID);
    	
    	exitButton = texturePackLibrary.get(GameAssets.EXIT_ID);
    	inventoryArea = texturePackLibrary.get(GameAssets.INVENTORY_ID);
    	equipmentArea = texturePackLibrary.get(GameAssets.CURRENTEQUIPMENTSLOTS_ID);
    	statsArea = texturePackLibrary.get(GameAssets.STATSAREA_ID);
    	
    	amulet = texturePackLibrary.get(GameAssets.AMULET_ID);
    	heavyHelm = texturePackLibrary.get(GameAssets.HEAVYHELM_ID);
    	heavyLower = texturePackLibrary.get(GameAssets.HEAVYLOWER_ID);
    	heavyUpper = texturePackLibrary.get(GameAssets.HEAVYUPPER_ID);
    	lightHelm = texturePackLibrary.get(GameAssets.LIGHTHELM_ID);
    	lightLower = texturePackLibrary.get(GameAssets.LIGHTLOWER_ID);
    	lightUpper = texturePackLibrary.get(GameAssets.LIGHTUPPER_ID);
    	mediumHelm = texturePackLibrary.get(GameAssets.MEDIUMHELM_ID);
    	mediumLower = texturePackLibrary.get(GameAssets.MEDIUMLOWER_ID);
    	mediumUpper = texturePackLibrary.get(GameAssets.MEDIUMUPPER_ID);
    	ring = texturePackLibrary.get(GameAssets.RING_ID);
    	shield = texturePackLibrary.get(GameAssets.SHIELD_ID);

		axe_1h = texturePackLibrary.get(GameAssets.WEAPON1HAXE_ID);
		mace_1h = texturePackLibrary.get(GameAssets.WEAPON1HMACE_ID);
		sword_1h = texturePackLibrary.get(GameAssets.WEAPON1HSWORD_ID);
		axe_2h = texturePackLibrary.get(GameAssets.WEAPON2HAXE_ID);
		mace_2h = texturePackLibrary.get(GameAssets.WEAPON2HMACE_ID);
		sword_2h = texturePackLibrary.get(GameAssets.WEAPON2HSWORD_ID);
		longbow1 = texturePackLibrary.get(GameAssets.LONGBOW1_ID);
		arrow = texturePackLibrary.get(GameAssets.ARROW_ID);
		bolt = texturePackLibrary.get(GameAssets.BOLT_ID);
		crossbow = texturePackLibrary.get(GameAssets.CROSSBOW_ID);
		dagger = texturePackLibrary.get(GameAssets.DAGGER_ID);
		longbow2 = texturePackLibrary.get(GameAssets.LONGBOW_ID);
		orb = texturePackLibrary.get(GameAssets.ORB_ID);
		quiver = texturePackLibrary.get(GameAssets.QUIVER_ID);
		shortbow = texturePackLibrary.get(GameAssets.SHORTBOW_ID);
		staff = texturePackLibrary.get(GameAssets.STAFF_ID);
		wand = texturePackLibrary.get(GameAssets.WAND_ID);

		fullRevive = texturePackLibrary.get(GameAssets.FULLREVIVE_ID);
		basicRevive = texturePackLibrary.get(GameAssets.HALFREVIVE_ID);
		majorHealth = texturePackLibrary.get(GameAssets.MAJORHEALTH_ID);
		majorResource = texturePackLibrary.get(GameAssets.MAJORRESOURCE_ID);
		minorHealth = texturePackLibrary.get(GameAssets.MINORHEALTH_ID);
		minorResource = texturePackLibrary.get(GameAssets.MINORRESOURCE_ID);
		superiorHealth = texturePackLibrary.get(GameAssets.SUPERIORRESOURCE_ID);
		superiorResource = texturePackLibrary.get(GameAssets.SUPIERIORHEALTH_ID);
    	
    }
    
    private void loadInventoryFonts()
    {
    	FontFactory.setAssetBasePath("font/");
        final ITexture battleFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        inventoryFont = FontFactory.createStrokeFromAsset(activity.getFontManager(), battleFontTexture, activity.getAssets(), "neuropolitical.ttf", 24, true, Color.BLACK, 2, Color.BLACK);
        inventoryFont.load();
    }
    
    private void loadInventoryAudio()
    {
        
    }
    //////////////////////////////////////////////////////////////////////////
    //Unload Resources for Inventory Scene
    //////////////////////////////////////////////////////////////////////////
    public void unloadInventoryTextures()
    {
    	//TODO: Unload Game Textures
    	
    }
    //////////////////////////////////////////////////////////////////////////
    //Load Battle Scene Resources
    //////////////////////////////////////////////////////////////////////////
    
    public void loadBattleResources()
    {
        loadBattleGraphics();
        loadBattleFonts();
        loadBattleAudio();
    }
    
    private void loadBattleGraphics()
    {
    	try
    	{
    		texturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/battle/").loadFromAsset(activity.getAssets(), "BattleAssets.xml");
            texturePack.loadTexture();
            texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
    		
    	}
    	catch(final TexturePackParseException e)
    	{
    		Debug.e(e);
    	}
    	
    	
    	
        //////////////////////////////////////////////////////////////////////////
        //Create Battle Menu Sprites
        //////////////////////////////////////////////////////////////////////////
    	abilitiesButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	itemsButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	swapButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	fleeButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	basicAttackButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	skillOneButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	skillTwoButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	skillThreeButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	skillFourButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	skillFiveButton = texturePackLibrary.get(BattleAssets.MENUBUTTON_ID);
    	
    	//////////////////////////////////////////////////////////////////////////
    	//Create Battle Sprites
    	//////////////////////////////////////////////////////////////////////////
    	teamMember1 = texturePackLibrary.get(BattleAssets.PLAYER_ID);
    	teamMember2 = texturePackLibrary.get(BattleAssets.PLAYER_ID);
    	teamMember3 = texturePackLibrary.get(BattleAssets.PLAYER_ID);
    	enemy1 = texturePackLibrary.get(BattleAssets.ENEMY_ID);
    	enemy2 = texturePackLibrary.get(BattleAssets.ENEMY_ID);
    	enemy3 = texturePackLibrary.get(BattleAssets.ENEMY_ID);
    	rightArrow1 = texturePackLibrary.get(BattleAssets.RIGHTARROW_ID);
    	rightArrow2 = texturePackLibrary.get(BattleAssets.RIGHTARROW_ID);
    	rightArrow3 = texturePackLibrary.get(BattleAssets.RIGHTARROW_ID);
    	leftArrow1 = texturePackLibrary.get(BattleAssets.LEFTARROW_ID);
    	leftArrow2 = texturePackLibrary.get(BattleAssets.LEFTARROW_ID);
    	leftArrow3 = texturePackLibrary.get(BattleAssets.LEFTARROW_ID);
    	focusArrow = texturePackLibrary.get(BattleAssets.FOCUSARROW_ID);
    	
    	
    	plainsBattleBackground = texturePackLibrary.get(BattleAssets.PLAINS_ID);
    	mountainsBattleBackground = texturePackLibrary.get(BattleAssets.MOUNTAINS_ID);
    }
   
    
    private void loadBattleFonts()
    {
    	 FontFactory.setAssetBasePath("font/");
         final ITexture battleFontTexture = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

         battleFont = FontFactory.createStrokeFromAsset(activity.getFontManager(), battleFontTexture, activity.getAssets(), "Zwiebelfisch.ttf", 30, true, Color.BLACK, 2, Color.BLACK);
         battleFont.load();
    }
    
    private void loadBattleAudio()
    {
        
    }
    //////////////////////////////////////////////////////////////////////////
    //Unload Resources for Game Scene
    //////////////////////////////////////////////////////////////////////////
    public void unloadBattleTextures()
    {
    	//TODO: Unload Game Textures
    	
    }
    //////////////////////////////////////////////////////////////////////////
    //load Resources for Splash Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadSplashScreen()
    {
    	
    	try
    	{
    		texturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/menu/").loadFromAsset(activity.getAssets(), "MenuAssets.xml");
            texturePack.loadTexture();
            texturePackLibrary = texturePack.getTexturePackTextureRegionLibrary();
    		
    	}
    	catch(final TexturePackParseException e)
    	{
    		Debug.e(e);
    	}
    	
    	
    	
    	andEngineLogo = texturePackLibrary.get(MenuAssets.ANDENGINELOGO_ID);
    	
    	
    }
    
    public void unloadSplashScreen()
    {
    	//splashTextureAtlas.unload();
    	companySplashLogo = null;
    	andEngineLogo = null;
    }
   
    
    /**
     * @param engine
     * @param activity
     * @param camera
     * @param vbom
     * We use this method at beginning of game loading, to prepare Resources Manager properly,
     * setting all needed parameters, so we can latter access them from different classes (eg. scenes)
     */
    public static void prepareManager(Engine engine, DragonsReignActivity activity, Camera camera, VertexBufferObjectManager vbom)
    {
        getInstance().engine = engine;
        getInstance().activity = activity;
        getInstance().camera = camera;
        getInstance().vbom = vbom;
    }
    
    //---------------------------------------------
    // GETTERS AND SETTERS
    //---------------------------------------------
    
    public static ResourceManager getInstance()
    {
        return INSTANCE;
    }
}