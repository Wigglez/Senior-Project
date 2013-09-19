package dragonsreign.scene;



import java.util.ArrayList;
import java.util.HashMap;

import javax.microedition.khronos.opengles.GL10;

import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.ZoomCamera;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl.IOnScreenControlListener;
import org.andengine.engine.camera.hud.controls.DigitalOnScreenControl;
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.AnimatedSprite;
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

import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.Constants;
import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import android.content.res.AssetManager;

import dragonsreign.scene.BaseScene;
import dragonsreign.manager.ResourceManager;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;
import dragonsreign.scene.DragonsReignActivity;

public class GameScene extends BaseScene implements IOnMenuItemClickListener, IOnScreenControlListener
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
	private AnimatedSprite player;

	private PhysicsHandler physicsHandler;
	private TMXLayer layer;
	
	private float lastPlayerX;
	
	private boolean mCollide;
	
	
	//private BoundCamera camera;
	private enum PlayerDirection
	{
        NONE,
        UP,
        DOWN,
        LEFT,
        RIGHT
	}
	private PlayerDirection playerDirection = PlayerDirection.DOWN;
	private DigitalOnScreenControl mDigitalOnScreenControl;
	
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
		//camera = new Camera(0,0, ((DragonsReignActivity)activity).CAMERA_WIDTH, ((DragonsReignActivity)activity).CAMERA_HEIGHT);
    	setBackground(new Background(Color.BLACK));
    	createGameChildScene();
    	mAnimationTiles = new ArrayList<TMXTile>();
		mChangingTiles = new ArrayList<TMXTile>();
		mCollideTiles = new ArrayList<TMXTile>();
		mTMXObjects = new ArrayList<TMXObject>();
		TMXGroupObjects = new ArrayList<TMXObjectGroup>();
		
		try 
		{
			final TMXLoader tmxLoader = new TMXLoader(((DragonsReignActivity)activity).getAssets(), ((DragonsReignActivity)activity).getTextureManager(), ((DragonsReignActivity)activity).getVertexBufferObjectManager(), new ITMXTilePropertiesListener() 
			{
				@Override
	            public void onTMXTileWithPropertiesCreated(final TMXTiledMap pTMXTiledMap, final TMXLayer pTMXLayer, final TMXTile pTMXTile, final TMXProperties<TMXTileProperty> pTMXTileProperties) 
				{
					for (int i = 0; i < pTMXTileProperties.size(); i++) 
					{
						
//						if(pTMXTileProperties.get(i).getName().contentEquals("COLLISION"))
//						{
//							mCollideTiles.add(pTMXTile);
//						}
							
					}
	            }
			});
			this.mTMXTiledMap = tmxLoader.loadFromAsset("tmx/desert2.tmx");
		}
		catch (final TMXLoadException tmxle)
		{
			Debug.e(tmxle);
			
		} 
		for (int i = 0; i < this.mTMXTiledMap.getTMXLayers().size(); i++)
		{
            layer = this.mTMXTiledMap.getTMXLayers().get(i);
            if (!layer.getTMXLayerProperties().containsTMXProperty("COLLISION", "true"))
            attachChild(layer);
		}

		
		
//		//Get the list of object tiles
//		for (final TMXObjectGroup pGroup : mTMXTiledMap.getTMXObjectGroups()) 
//		{
//			mTMXObjects.addAll(pGroup.getTMXObjects());
//			TMXGroupObjects.add(pGroup); 
//		}
//		mCollideTiles = this.getObjectGroupPropertyTiles("COLLIDE",  TMXGroupObjects);

        /* Make the camera not exceed the bounds of the TMXEntity. */
        ((BoundCamera) this.camera).setBounds(0, 0, layer.getWidth(), layer.getHeight());
        ((BoundCamera) this.camera).setBoundsEnabled(true);
        
		final float centerX = (camera.getWidth() - ResourceManager.getInstance().mPlayerTextureRegion.getWidth()) / 2;
        final float centerY = (camera.getHeight() - ResourceManager.getInstance().mPlayerTextureRegion.getHeight()) / 2;
	
        
        /* Create the sprite and add it to the scene. */
        player = new AnimatedSprite(centerX, centerY, ResourceManager.getInstance().mPlayerTextureRegion, ((DragonsReignActivity)activity).getVertexBufferObjectManager());
        camera.setChaseEntity(player);
        physicsHandler = new PhysicsHandler(player);
        player.registerUpdateHandler(physicsHandler);
        attachChild(player);
        //player.setZIndex(10); 
        
        
        mDigitalOnScreenControl = new DigitalOnScreenControl(0, ((DragonsReignActivity)activity).CAMERA_HEIGHT - ResourceManager.getInstance().DPADBacking.getHeight(), this.camera, ResourceManager.getInstance().DPADBacking, ResourceManager.getInstance().DPADKnob, 0.1f, ((DragonsReignActivity)activity).getVertexBufferObjectManager(), new IOnScreenControlListener() 
        {
            @Override
            public void onControlChange(final BaseOnScreenControl pBaseOnScreenControl, final float pValueX, final float pValueY) 
            {
                    if (pValueY == 1){
                            // Up
                            if (playerDirection != PlayerDirection.UP)
                            {
                            	player.animate(new long[]{200, 200, 200}, 0, 2, true);
                            	playerDirection = PlayerDirection.UP;
                            }
                    }else if (pValueY == -1){
                            // Down
                            if (playerDirection != PlayerDirection.DOWN)
                            {
                            	player.animate(new long[]{200, 200, 200}, 3, 5, true);  
                            	playerDirection = PlayerDirection.DOWN;
                            }
                    }else if (pValueX == -1)
                    {
                            // Left
                            if (playerDirection != PlayerDirection.LEFT)
                            {   
                            	player.animate(new long[]{200, 200, 200}, 6, 8, true);
                            	playerDirection = PlayerDirection.LEFT;
                            }
                    }else if (pValueX == 1)
                    {
                            // Right
                            if (playerDirection != PlayerDirection.RIGHT)
                            {
                            	player.animate(new long[]{200, 200, 200}, 9, 11, true);
                            	playerDirection = PlayerDirection.RIGHT;
                            }
                    }else if (mTMXTiledMap.getTMXLayers().get(0).getLocalToSceneTransformation().equals(player.getX()) == mTMXTiledMap.getTMXLayers().get(0).getTMXLayerProperties().containsTMXProperty("COLLIDE", "true"))
                    {
                    	if (player.isAnimationRunning())
                        {   
                    		
                        	player.stopAnimation();
                        	playerDirection = PlayerDirection.NONE;
                        }
                    	
                    }else{
                    	if (player.isAnimationRunning())
                        {   
                        	player.stopAnimation();
                        	playerDirection = PlayerDirection.NONE;
                        } 
                    }
                    physicsHandler.setVelocity(pValueX * 60, pValueY * 60);
            }
    });
    this.mDigitalOnScreenControl.getControlBase().setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
    this.mDigitalOnScreenControl.getControlBase().setAlpha(0.5f);
    this.mDigitalOnScreenControl.getControlBase().setScaleCenter(0, 128);
    this.mDigitalOnScreenControl.getControlBase().setScale(1.25f);
    this.mDigitalOnScreenControl.getControlKnob().setScale(1.25f);
    this.mDigitalOnScreenControl.refreshControlKnobPosition();

    
    this.setChildScene(this.mDigitalOnScreenControl);
    mDigitalOnScreenControl.setChildScene(gameChildScene);

    camera.updateChaseEntity();
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

	@Override
	public void onControlChange(BaseOnScreenControl pBaseOnScreenControl,
			float pValueX, float pValueY) {
		// TODO Auto-generated method stub
		
	}
    
	public ArrayList<TMXTile> getObjectGroupPropertyTiles(String pName, ArrayList<TMXObjectGroup> pTMXObjectGroups)
	{
		ArrayList<TMXTile> ObjectTile = new ArrayList<TMXTile>();
		for (final TMXObjectGroup pObjectGroups : pTMXObjectGroups) {
			// Iterates through the properties and assigns them to the new variable
			for (final TMXObjectGroupProperty pGroupProperties : pObjectGroups.getTMXObjectGroupProperties()) {
				//Sees if any of the elements have this condition
				if (pGroupProperties.getName().contains(pName)) {
					for (final TMXObject pObjectTiles : pObjectGroups.getTMXObjects()) {
						int ObjectX = pObjectTiles.getX();
						int ObjectY = pObjectTiles.getY();
						// Gets the number of rows and columns in the object
						int ObjectRows = pObjectTiles.getHeight() / DragonsReignActivity.getInstance().TILE_HEIGHT;
						int ObjectColumns = pObjectTiles.getWidth() / DragonsReignActivity.getInstance().TILE_WIDTH;
						
						for (int TileRow = 0; TileRow < ObjectRows; TileRow++) {
							for (int TileColumn = 0; TileColumn < ObjectColumns; TileColumn++) {
								float lObjectTileX = ObjectX + TileColumn * DragonsReignActivity.getInstance().TILE_WIDTH;
								float lObjectTileY = ObjectY + TileRow * DragonsReignActivity.getInstance().TILE_HEIGHT;
								ObjectTile.add(mTMXTiledMap.getTMXLayers().get(0).getTMXTileAt(lObjectTileX, lObjectTileY));						
							}							 
						}
					}
				}			
			}
		}
		return ObjectTile;
	}
	
	

	
    //TODO: Create onPause(), onResume(), 
}
