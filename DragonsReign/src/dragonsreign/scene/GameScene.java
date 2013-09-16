package dragonsreign.scene;



import java.util.ArrayList;

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
import org.andengine.extension.tmx.TMXProperties;
import org.andengine.extension.tmx.TMXTile;
import org.andengine.extension.tmx.TMXTileProperty;
import org.andengine.extension.tmx.TMXTiledMap;
import org.andengine.extension.tmx.util.constants.TMXConstants;
import org.andengine.extension.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.andengine.extension.tmx.util.exception.TMXLoadException;

import org.andengine.opengl.texture.TextureOptions;
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
    	
//        if(context == null)
//        {
//        	Debug.e("Contex is null in Create Scene: GameScene");
//        	System.exit(0);
//        }
//    	try {
//			this.TMXloader = new TMXLoader(context.getAssets(), context.getTextureManager(), TextureOptions.BILINEAR_PREMULTIPLYALPHA, context.getVertexBufferObjectManager(), new ITMXTilePropertiesListener() {
//				@Override
//				public void onTMXTileWithPropertiesCreated(final TMXTiledMap pTMXTiledMap, final TMXLayer pTMXLayer, final TMXTile pTMXTile, final TMXProperties<TMXTileProperty> pTMXTileProperties) {
//					//Gets the properties of the tiles from every layer
//					for (int i = 0; i < pTMXTileProperties.size(); i++) 
//						//Gets all the tiles with the property "ANIMATE" that is on the TMXLayer called "Alpha Layer"
//						if(pTMXTileProperties.get(i).getName().contentEquals("ANIMATE") && pTMXLayer.getName().contentEquals("Alpha Layer")) 
//							mAnimationTiles.add(pTMXTile);		
//				}	
//				
//			});
//
//			this.mTMXTiledMap = TMXloader.loadFromAsset("tmx/desert.tmx");
//			
//			
//		} catch (final TMXLoadException e) {
//			Debug.e(e);
//		}
		
//		mTMXObjects = new ArrayList<TMXObject>();
//		TMXGroupObjects = new ArrayList<TMXObjectGroup>();
//		//Get the list of object tiles
//		for (final TMXObjectGroup pGroup : mTMXTiledMap.getTMXObjectGroups()) 
//		{
//			mTMXObjects.addAll(pGroup.getTMXObjects());
//			TMXGroupObjects.add(pGroup); 
//		}
//		
//		for(TMXLayer tmxLayer : this.mTMXTiledMap.getTMXLayers()) 
//		{
//			  this.attachChild(tmxLayer);
//			
//		}
		//Make the camera not exceed the bounds of the TMXEntity. 
//    	mTMXMapTouchLayer = this.mTMXTiledMap.getTMXLayers().get(0);
//		context.mCamera.setBounds(0, 0, mTMXTiledMap.getTileColumns() * mTMXTiledMap.getTileWidth(), mTMXTiledMap.getTileRows() * mTMXTiledMap.getTileHeight());
//		attachChild(mTMXMapTouchLayer);
		//WorldActivity.mWorldCamera.setChaseEntity(mPlayerSprite);
		//Get the collision, exit, and changing tiles from the object sets on the map
//		mCollideTiles = this.getObjectGroupPropertyTiles("COLLIDE",  TMXGroupObjects);	
//		mExitTiles = this.getObjectPropertyTiles("EXIT", mTMXObjects);
//		mChangingTiles = this.getObjectGroupPropertyTiles("Change Layer", TMXGroupObjects);
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
