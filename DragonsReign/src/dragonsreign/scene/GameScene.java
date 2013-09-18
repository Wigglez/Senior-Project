package dragonsreign.scene;



import java.util.ArrayList;
import java.util.HashMap;

import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.extension.tmx.TMXLayer;
import org.andengine.extension.tmx.TMXLoader;
import org.andengine.extension.tmx.TMXObject;
import org.andengine.extension.tmx.TMXObjectGroup;
import org.andengine.extension.tmx.TMXObjectGroupProperty;
import org.andengine.extension.tmx.TMXObjectProperty;
import org.andengine.extension.tmx.TMXProperties;
import org.andengine.extension.tmx.TMXTile;
import org.andengine.extension.tmx.TMXTileProperty;
import org.andengine.extension.tmx.TMXTiledMap;
import org.andengine.extension.tmx.util.constants.TMXConstants;
import org.andengine.extension.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.andengine.extension.tmx.util.exception.TMXLoadException;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import dragonsreign.scene.BaseScene;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;
import dragonsreign.scene.DragonsReignActivity;

public class GameScene extends BaseScene implements IOnMenuItemClickListener
{
	
	
	private final int GAME_BACKPACK = 0;
	private final int GAME_MAP = 1;


	private DragonsReignActivity context;
	private MenuScene gameChildScene;
	private ScaleMenuItemDecorator backpackHUDItem, mapHUDItem;

	public TMXLayer mTMXMapTouchLayer;
	private TMXLoader TMXloader;
	private TMXTiledMap mTMXTiledMap;
	private ArrayList<TMXObject> mTMXObjects = new ArrayList<TMXObject>();;
	protected ArrayList<TMXTile> mTopTiles = new ArrayList<TMXTile>();
	private ArrayList<TMXTile> mChangingTiles = new ArrayList<TMXTile>();
	private ArrayList<TMXTile> mCollideTiles = new ArrayList<TMXTile>();
	private ArrayList<TMXTile> mExitTiles = new ArrayList<TMXTile>();
	private ArrayList<TMXObjectGroup> TMXGroupObjects = new ArrayList<TMXObjectGroup>();
	public ArrayList<TMXTile> mAnimationTiles = new ArrayList<TMXTile>();
	

	public GameScene(final DragonsReignActivity pMain)
	{
		this.context = pMain;
        if(context == null)
        {
        	Debug.e("Contex is null");
        }
	}

	private void createGameChildScene()
	{
		gameChildScene = new MenuScene(camera);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Set up Child Scene
		////////////////////////////////////////////////////////////////////////////////////
		
		gameChildScene.setPosition(0, 0);
		
		////////////////////////////////////////////////////////////////////////////////////
		//Create Menu Items
		////////////////////////////////////////////////////////////////////////////////////
		backpackHUDItem = new ScaleMenuItemDecorator(new SpriteMenuItem(GAME_BACKPACK, resourcesManager.backPack, vbom), 1.2f, 1);
		mapHUDItem = new ScaleMenuItemDecorator(new SpriteMenuItem(GAME_MAP, resourcesManager.worldMap, vbom), 1.2f, 1);
		
		
		backpackHUDItem.setAlpha(0.75f);
		mapHUDItem.setAlpha(0.75f);
		////////////////////////////////////////////////////////////////////////////////////
		//Create Sprites
		////////////////////////////////////////////////////////////////////////////////////

		

        
		////////////////////////////////////////////////////////////////////////////////////
		//Attach entities
		////////////////////////////////////////////////////////////////////////////////////
		gameChildScene.addMenuItem(backpackHUDItem);
		gameChildScene.addMenuItem(mapHUDItem);		

		
		////////////////////////////////////////////////////////////////////////////////////
		//Set Positions
		////////////////////////////////////////////////////////////////////////////////////
		backpackHUDItem.setPosition(730, 410);
		mapHUDItem.setPosition(730, 5);

		
		
		gameChildScene.setBackgroundEnabled(false);
	    
		gameChildScene.setOnMenuItemClickListener(this);
		setChildScene(gameChildScene);
		
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{
		switch(pMenuItem.getID())
		{
	        case GAME_BACKPACK:
	        	SceneManager.getInstance().loadInventoryScene(engine);
	            return true;
	        case GAME_MAP:
	        	SceneManager.getInstance().loadBattleScene(engine);
	        	return true;
	        default:
	            return false;
		}
	
	}

	@Override
    public void createScene()
    {
    	setBackground(new Background(Color.BLACK));
    	createGameChildScene();
    	mAnimationTiles = new ArrayList<TMXTile>();
		mChangingTiles = new ArrayList<TMXTile>();
 
	
		try 
		{
			final TMXLoader tmxLoader = new TMXLoader(activity.getAssets(), ((DragonsReignActivity) activity).getTextureManager(), TextureOptions.BILINEAR_PREMULTIPLYALPHA, ((DragonsReignActivity) activity).getVertexBufferObjectManager());
			this.mTMXTiledMap = tmxLoader.loadFromAsset("tmx/Mountain.tmx");
			
			
		} 
		catch (final TMXLoadException tmxle)
		{
			Debug.e(tmxle);
			
		} 
		
		final TMXLayer tmxLayer2 = this.mTMXTiledMap.getTMXLayers().get(1);
		final TMXLayer tmxLayer = this.mTMXTiledMap.getTMXLayers().get(0);
		
		this.attachChild(tmxLayer);
		this.attachChild(tmxLayer2);

    }

    @Override
    public void onBackKeyPressed()
    {
    	gameChildScene.setIgnoreUpdate(false);
    	setChildScene(gameChildScene);
    }

    @Override
    public SceneType getSceneType()
    {
    	return SceneType.SCENE_GAME;
    }

    @Override
    public void disposeScene()
    {
        this.detachSelf();
        this.dispose();
        
    }

    //TODO: Create onPause(), onResume(), 
}
