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
import dragonsreign.texturepacker.MenuAssets;
import dragonsreign.texturepacker.GameAssets;
import dragonsreign.texturepacker.BattleAssets;

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
    
	public ITextureRegion menuBackgroundRegion, playButton, optionsButton,
			companySplashLogo, warriorButton, knightButton, andEngineLogo,
			assassinButton, engineerButton, clericButton, mageButton,
			rangerButton, playGameButton, warriorCharacter, knightCharacter,
			assassinCharacter, engineerCharacter, clericCharacter,
			mageCharacter, character1Portrait, character2Portrait,
			character3Portrait, backPack, worldMap, inventoryArea, exitButton,
			equipmentArea, statsArea, itemsButton, abilitiesButton, swapButton,
			fleeButton, basicAttackButton, skillOneButton, skillTwoButton,
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
    
    public Font font, battleFont, inventoryFont;

	public TiledTextureRegion mPlayerTextureRegion;

	private TexturePackTextureRegionLibrary mCharactersTexturePackTextureRegionLibrary;


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

        font = FontFactory.createStrokeFromAsset(activity.getFontManager(), mainFontTexture, activity.getAssets(), "Zwiebelfisch.ttf", 30, true, Color.BLACK, 2, Color.BLACK);
        font.load();
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
    	warriorCharacter = texturePackLibrary.get(MenuAssets.WARRIORCHARACTER_ID);
    	//knightCharacter = 
    	//assassinCharacter = 
    	//engineerCharacter = 
    	//clericCharacter = 
    	//mageCharacter = 
    	
    	
    	
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
    		
			//Characters texture packer
			TexturePack spriteSheetCharactersTexturePack = new TexturePackLoader(activity.getTextureManager(), "gfx/Characters/").loadFromAsset(activity.getAssets(), "CharactersTexturePacker.xml");
			spriteSheetCharactersTexturePack.loadTexture();
			mCharactersTexturePackTextureRegionLibrary = spriteSheetCharactersTexturePack.getTexturePackTextureRegionLibrary();
    	}
    	catch(final TexturePackParseException e)
    	{
    		Debug.e(e);
    	}
    	
    	//Creating tiled region 
		TexturePackerTextureRegion HeroTextureRegion = mCharactersTexturePackTextureRegionLibrary.get(AnimatedCharacter.HERO_ID);
		
		mPlayerTextureRegion = TiledTextureRegion.create(HeroTextureRegion.getTexture(),
		(int)HeroTextureRegion.getTextureX(), (int)HeroTextureRegion.getTextureY(), (int)HeroTextureRegion.getWidth(), (int)HeroTextureRegion.getHeight(), 3, 4, HeroTextureRegion.isRotated());
    	
    	
    	backPack = texturePackLibrary.get(GameAssets.BACKPACK_ID);
    	
    	worldMap = texturePackLibrary.get(GameAssets.WORLDMAP_ID);
    	
    	warriorPlayer = texturePackLibrary.get(GameAssets.HERO_ID);
    
    	
    	Up_DPAD = texturePackLibrary.get(GameAssets.UP_DPAD_ID);
    	Down_DPAD = texturePackLibrary.get(GameAssets.DOWN_DPAD_ID);
    	Left_DPAD = texturePackLibrary.get(GameAssets.LEFT_DPAD_ID);
    	Right_DPAD = texturePackLibrary.get(GameAssets.RIGHT_DPAD_ID);
    	Center_DPAD = texturePackLibrary.get(GameAssets.CENTER_DPAD_ID);
    	 
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
    	
    	
    	
    	
    	character1Portrait = texturePackLibrary.get(GameAssets.PORTRAIT_ID);
    	
    	
    	character2Portrait = texturePackLibrary.get(GameAssets.PORTRAIT2_ID);
    	character3Portrait = texturePackLibrary.get(GameAssets.PORTRAIT3_ID);
    	
    	exitButton = texturePackLibrary.get(GameAssets.EXIT_ID);
    	inventoryArea = texturePackLibrary.get(GameAssets.INVENTORY_ID);
    	equipmentArea = texturePackLibrary.get(GameAssets.CURRENTEQUIPMENTSLOTS_ID);
    	statsArea = texturePackLibrary.get(GameAssets.STATSAREA_ID);
    	
    	amulet = texturePackLibrary.get(GameAssets.ARMOR_AMULET_ID);
    	heavyHelm = texturePackLibrary.get(GameAssets.ARMOR_HEAVYHELM_ID);
    	heavyLower = texturePackLibrary.get(GameAssets.ARMOR_HEAVYLOWER_ID);
    	heavyUpper = texturePackLibrary.get(GameAssets.ARMOR_HEAVYUPPER_ID);
    	lightHelm = texturePackLibrary.get(GameAssets.ARMOR_LIGHTHELM_ID);
    	lightLower = texturePackLibrary.get(GameAssets.ARMOR_LIGHTLOWER_ID);
    	lightUpper = texturePackLibrary.get(GameAssets.ARMOR_LIGHTUPPER_ID);
    	mediumHelm = texturePackLibrary.get(GameAssets.ARMOR_MEDIUMHELM_ID);
    	mediumLower = texturePackLibrary.get(GameAssets.ARMOR_MEDIUMLOWER_ID);
    	mediumUpper = texturePackLibrary.get(GameAssets.ARMOR_MEDIUMUPPER_ID);
    	ring = texturePackLibrary.get(GameAssets.ARMOR_RING_ID);
    	shield = texturePackLibrary.get(GameAssets.ARMOR_SHIELD_ID);

		axe_1h = texturePackLibrary.get(GameAssets.WEAPONS_1HAXE_ID);
		mace_1h = texturePackLibrary.get(GameAssets.WEAPONS_1HMACE_ID);
		sword_1h = texturePackLibrary.get(GameAssets.WEAPONS_1HSWORD_ID);
		axe_2h = texturePackLibrary.get(GameAssets.WEAPONS_2HAXE_ID);
		mace_2h = texturePackLibrary.get(GameAssets.WEAPONS_2HMACE_ID);
		sword_2h = texturePackLibrary.get(GameAssets.WEAPONS_2HSWORD_ID);
		longbow1 = texturePackLibrary.get(GameAssets.WEAPONS_LONGBOW1_ID);
		arrow = texturePackLibrary.get(GameAssets.WEAPONS_ARROW_ID);
		bolt = texturePackLibrary.get(GameAssets.WEAPONS_BOLT_ID);
		crossbow = texturePackLibrary.get(GameAssets.WEAPONS_CROSSBOW_ID);
		dagger = texturePackLibrary.get(GameAssets.WEAPONS_DAGGER_ID);
		longbow2 = texturePackLibrary.get(GameAssets.WEAPONS_LONGBOW_ID);
		orb = texturePackLibrary.get(GameAssets.WEAPONS_ORB_ID);
		quiver = texturePackLibrary.get(GameAssets.WEAPONS_QUIVER_ID);
		shortbow = texturePackLibrary.get(GameAssets.WEAPONS_SHORTBOW_ID);
		staff = texturePackLibrary.get(GameAssets.WEAPONS_STAFF_ID);
		wand = texturePackLibrary.get(GameAssets.WEAPONS_WAND_ID);

		fullRevive = texturePackLibrary.get(GameAssets.POTIONS_FULLREVIVE_ID);
		basicRevive = texturePackLibrary.get(GameAssets.POTIONS_HALFREVIVE_ID);
		majorHealth = texturePackLibrary.get(GameAssets.POTIONS_MAJORHEALTH_ID);
		majorResource = texturePackLibrary.get(GameAssets.POTIONS_MAJORRESOURCE_ID);
		minorHealth = texturePackLibrary.get(GameAssets.POTIONS_MINORHEALTH_ID);
		minorResource = texturePackLibrary.get(GameAssets.POTIONS_MINORRESOURCE_ID);
		superiorHealth = texturePackLibrary.get(GameAssets.POTIONS_SUPERIORRESOURCE_ID);
		superiorResource = texturePackLibrary.get(GameAssets.POTIONS_SUPIERIORHEALTH_ID);
    	
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