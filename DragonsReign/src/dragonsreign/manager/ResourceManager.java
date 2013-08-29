package dragonsreign.manager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.debug.Debug;

import android.graphics.Color;

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
    
    public ITextureRegion companySplashLogo, andEngineLogo;
    private BitmapTextureAtlas splashTextureAtlas;
    
    public ITextureRegion menuBackgroundRegion;
    public ITextureRegion playButton, optionsButton, 
    					  warriorButton, knightButton, 
    					  assassinButton, engineerButton, 
    					  clericButton, mageButton, 
    					  rangerButton, playGameButton, 
    					  warriorCharacter, knightCharacter, 
    					  assassinCharacter, engineerCharacter, 
    					  clericCharacter, mageCharacter,
    					  character1Portrait,character2Portrait,
    					  character3Portrait, backPack,
    					  worldMap, inventoryGid, exitButton,
    					  equipmentArea, statsArea,itemsButton,abilitiesButton,
    					  swapButton, fleeButton, basicAttackButton,
    					  skillOneButton, skillTwoButton,
    					  skillThreeButton, skillFourButton, skillFiveButton,
    					  teamMember1, teamMember2, teamMember3, enemy1, enemy2, enemy3;
    
    private BuildableBitmapTextureAtlas menuTextureAtlas, characterSelectionTextureAtlas, 
    									gameTextureAtlas, battleTextureAtlas, inventoryTextureAtlas;
    
    public Font font, battleFont, inventoryFont;


    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Menu Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadMenuResources()
    {
    	loadMenuGraphics();
        loadMenuAudio();
        loadMenuFonts();
        loadMenuTextures();
    }
    private void loadMenuGraphics()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
    	menuTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	menuBackgroundRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "Background.jpg");
    	playButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "largeMenuButton.png");
    	optionsButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, activity, "largeMenuButton.png");
    	       
    	try 
    	{
    	    this.menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    this.menuTextureAtlas.load();
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
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
	private void loadMenuTextures()
	{
	        menuTextureAtlas.load();
	        
	}
	//////////////////////////////////////////////////////////////////////////
    //Unload Resources for Menu Scene
    //////////////////////////////////////////////////////////////////////////    
    public void unloadMenuTextures()
    {
        menuTextureAtlas.unload();
        menuBackgroundRegion = null;
    	playButton  = null;
    	optionsButton  = null;
    }
    //////////////////////////////////////////////////////////////////////////
    //Load Resources for Character Selection Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadCharacterSelectGraphics()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
    	characterSelectionTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	
    	/////////////////////////////////////////////////////////////////////////////
    	//Character Selection Buttons
    	/////////////////////////////////////////////////////////////////////////////
    	warriorButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    	knightButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    	assassinButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    	engineerButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    	clericButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    	mageButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    	rangerButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    
    	/////////////////////////////////////////////////////////////////////////////
    	//Character Sprites
    	/////////////////////////////////////////////////////////////////////////////
    	warriorCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "warriorCharacter.png");
    	//knightCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "knightCharacter.png");
    	//assassinCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "assassinCharacter.png");
    	//engineerCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "engineerCharacter.png");
    	//clericCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "clericCharacter.png");
    	//mageCharacter = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "mageCharacter.png");
    	
    	
    	playGameButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(characterSelectionTextureAtlas, activity, "menuButton.png");
    	try 
    	{
    	    characterSelectionTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    	
    	characterSelectionTextureAtlas.load();
    }
    public void unloadCharacterSelectGraphics()
    {
    	characterSelectionTextureAtlas.unload();
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
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
    	gameTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	

    	backPack = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "backpack.jpg");
    	
    	worldMap = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, activity, "worldMap.jpg");
    	
    	
    	try 
    	{
    	    gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    	
    	gameTextureAtlas.load();
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
    	gameTextureAtlas.unload();
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
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
    	inventoryTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	
    	
    	
    	character1Portrait = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "portrait.jpg");
    	character2Portrait = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "portrait2.jpg");
    	character3Portrait = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "portrait3.jpg");
    	exitButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "exitButton.png");
    	
    	inventoryGid = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "inventory.png");
    	
    	backPack = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "backpack.jpg");
    	
    	worldMap = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "worldMap.jpg");
    	
    	equipmentArea = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "currentEquipmentSlots.png");
    	
    	statsArea = BitmapTextureAtlasTextureRegionFactory.createFromAsset(inventoryTextureAtlas, activity, "statsArea.png");
    	
    	
    	try 
    	{
    		inventoryTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    	
    	inventoryTextureAtlas.load();
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
    	inventoryTextureAtlas.unload();
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
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/battle/");
    	battleTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	
        //////////////////////////////////////////////////////////////////////////
        //Create Battle Menu Sprites
        //////////////////////////////////////////////////////////////////////////
    	abilitiesButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	itemsButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	swapButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	fleeButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	basicAttackButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	skillOneButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	skillTwoButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	skillThreeButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	skillFourButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	skillFiveButton = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "menuButton.png");
    	
        //////////////////////////////////////////////////////////////////////////
        //Create Battle Sprites
        //////////////////////////////////////////////////////////////////////////
    	teamMember1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "Player.png");
    	teamMember2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "Player.png");
    	teamMember3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "Player.png");
    	enemy1 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "Enemy.png");
    	enemy2 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "Enemy.png");
    	enemy3 = BitmapTextureAtlasTextureRegionFactory.createFromAsset(battleTextureAtlas, activity, "Enemy.png");
    	
    	try 
    	{
    		battleTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    	    
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    	
    	battleTextureAtlas.load();
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
    	battleTextureAtlas.unload();
    }
    //////////////////////////////////////////////////////////////////////////
    //load Resources for Splash Scene
    //////////////////////////////////////////////////////////////////////////
    public void loadSplashScreen()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
    	splashTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 256, 256, TextureOptions.BILINEAR);
    	companySplashLogo = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "splash.png", 0, 0);
    	andEngineLogo = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, activity, "AndEngineLogo.jpg", 0, 0);
    	
    	splashTextureAtlas.load();
    }
    
    public void unloadSplashScreen()
    {
    	splashTextureAtlas.unload();
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