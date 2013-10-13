package dragonsreign.scene;



import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl;
import org.andengine.engine.camera.hud.controls.BaseOnScreenControl.IOnScreenControlListener;
import org.andengine.engine.camera.hud.controls.DigitalOnScreenControl;
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.shape.IAreaShape;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.tmx.TMXLayer;
import org.andengine.extension.tmx.TMXLoader;
import org.andengine.extension.tmx.TMXObject;
import org.andengine.extension.tmx.TMXObjectGroup;
import org.andengine.extension.tmx.TMXProperties;
import org.andengine.extension.tmx.TMXTile;
import org.andengine.extension.tmx.TMXTileProperty;
import org.andengine.extension.tmx.TMXTiledMap;
import org.andengine.extension.tmx.TMXLoader.ITMXTilePropertiesListener;
import org.andengine.extension.tmx.util.exception.TMXLoadException;

import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.physics.box2d.FixedStepPhysicsWorld;

import org.andengine.util.color.Color;
import org.andengine.util.debug.Debug;

import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import dragonsreign.scene.BaseScene;
import dragonsreign.manager.ResourceManager;
import dragonsreign.manager.SceneManager.SceneType;
import dragonsreign.scene.DragonsReignActivity;

public class GameScene extends BaseScene implements IOnMenuItemClickListener, IOnScreenControlListener
{
	
	private final int GAME_BACKPACK = 0;
	private final int GAME_MAP = 1;

	private MenuScene gameChildScene;
	private ScaleMenuItemDecorator backpackHUDItem, mapHUDItem;
	private int PLAYER_VELOCITY = 4;
	
	public String newMapName = "";
	private int playerX;
	private int playerY;
	
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
	public static AnimatedSprite player;

	private PhysicsHandler physicsHandler;
	private TMXLayer layer;
	
	
	public static DigitalOnScreenControl mDigitalOnScreenControl;
	private Body mPlayerBody;
	private PhysicsWorld mPhysicsWorld;
	 
	 
	private IAreaShape bottom;
	private IAreaShape top;
	private IAreaShape left;
	private IAreaShape right;  
	private Rectangle rect;
	
    private FixtureDef boxFixtureDef; 
	private FixtureDef wallFixtureDef;
	
	private BattleScene battleScene;
	private InventoryScene inventoryScene;
	 
	//private BoundCamera camera;
	private enum PlayerDirection
	{
        NONE,
        UP,
        DOWN,
        LEFT,
        RIGHT
	}
	private PlayerDirection playerDirection = PlayerDirection.UP;
	public GameScene()
	{
	
        
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
	        	//SceneManager.getInstance().loadInventoryScene(engine);
	        	inventoryScene = new InventoryScene(this);
	        	setChildScene(inventoryScene);
	            return true;
	        case GAME_MAP:
	        	//SceneManager.getInstance().loadBattleScene(engine);
	        	battleScene = new BattleScene(this);
	        	setChildScene(battleScene);
	        	
	        	return true;
	        default:
	            return false;
		}
	
	}

	@Override
    public void createScene()
    {
    	setBackground(new Background(Color.BLACK));
    	
        //////////////////////////////////////////////////////////////////////
        //Creates and Registers Physics World
        //////////////////////////////////////////////////////////////////////
    	this.mPhysicsWorld = new FixedStepPhysicsWorld(30, new Vector2(0, 0), false, 8, 1);
    	this.registerUpdateHandler(this.mPhysicsWorld);
    	
    	createGameChildScene();

        this.LoadTMX("village");
        
        attachControls();
        

    
	    this.setChildScene(mDigitalOnScreenControl);
	    mDigitalOnScreenControl.setChildScene(gameChildScene);
	
	    camera.updateChaseEntity();
    }

    @Override
    public void onBackKeyPressed()
    {
    	
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
    public void attachControls()
    {
    	mDigitalOnScreenControl = new DigitalOnScreenControl(0, ((DragonsReignActivity)activity).CAMERA_HEIGHT - ResourceManager.getInstance().DPADBacking.getHeight(), this.camera, ResourceManager.getInstance().DPADBacking, ResourceManager.getInstance().DPADKnob, 0.1f, ((DragonsReignActivity)activity).getVertexBufferObjectManager(), new IOnScreenControlListener() 
        {
            @Override
            public void onControlChange(BaseOnScreenControl pBaseOnScreenControl,  float pValueX,  float pValueY) 
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
                    }else{
                    	if (player.isAnimationRunning())
                        {   
                        	player.stopAnimation();
                        	playerDirection = PlayerDirection.NONE;
                        } 
                    }
                    
//                    if(player.getX() >= 198 && player.getX() <= 260 && player.getY() <= 285 && player.getY() >= 260)
//                    {
//                    	detachChild(rect);
//                    	rect.dispose();
//
//						//////////////////////////////////////////////////////////////////////
//						//Detaches TMX Layers From The Scene
//						//////////////////////////////////////////////////////////////////////
//						for (int i = 0; i < mTMXTiledMap.getTMXLayers().size(); i++)
//						{
//						    layer = mTMXTiledMap.getTMXLayers().get(i);
//						    detachChild(layer);
//						   
//						}
//						mPhysicsWorld.reset();
//						LoadTMX("village");
//
//                    }
                    if(player.getX() >= 576 && player.getX() <= 736 && player.getY() <= 672 && player.getY() >= 576)
                    {
                    	detachChild(rect);
                    	rect.dispose();

						//////////////////////////////////////////////////////////////////////
						//Detaches TMX Layers From The Scene
						//////////////////////////////////////////////////////////////////////
						for (int i = 0; i < mTMXTiledMap.getTMXLayers().size(); i++)
						{
						    layer = mTMXTiledMap.getTMXLayers().get(i);
						    detachChild(layer);
						   
						}
						LoadTMX("inn");

                    }
                    
                    mPlayerBody.setLinearVelocity(pValueX * PLAYER_VELOCITY, pValueY * PLAYER_VELOCITY);
                   // Log.e("", "Player X: " + player.getX() + " Player Y: " + player.getY());
            }
        });
	    mDigitalOnScreenControl.getControlBase().setBlendFunction(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
	    mDigitalOnScreenControl.getControlBase().setAlpha(0.5f);
	    mDigitalOnScreenControl.getControlBase().setScaleCenter(0, 128);
	    mDigitalOnScreenControl.getControlBase().setScale(1.25f);
	    mDigitalOnScreenControl.getControlKnob().setScale(1.25f);
	    mDigitalOnScreenControl.refreshControlKnobPosition();
    }
    
    
    //////////////////////////////////////////////////////////////////////
    //Adds Collision shapes around COLLISION Objects
    //////////////////////////////////////////////////////////////////////
    private void createUnwalkableObjects(TMXTiledMap map)
    { 
    	// Loop through the object groups
        for(final TMXObjectGroup group: this.mTMXTiledMap.getTMXObjectGroups())
        {
                if(group.getTMXObjectGroupProperties().containsTMXProperty("COLLISION", "true"))
                {
                        // This is our "wall" layer. Create the boxes from it
                        for(final TMXObject object : group.getTMXObjects()) {
                               rect = new Rectangle(object.getX(), object.getY(),object.getWidth(), object.getHeight(), ((DragonsReignActivity)activity).getVertexBufferObjectManager());
                               boxFixtureDef = PhysicsFactory.createFixtureDef(0, 0, 1f);
                               PhysicsFactory.createBoxBody(this.mPhysicsWorld, rect, BodyType.StaticBody, boxFixtureDef);
                               rect.setVisible(true);
                               this.attachChild(rect);
                        }
                }
        }
    }
	//////////////////////////////////////////////////////////////////////
	//Load new TMX Map
	//////////////////////////////////////////////////////////////////////
    private void LoadTMX(final String mapName)
    {
    	if(mapName == "village")
    	{
    		newMapName = "tmx/village.tmx";
    		playerX = 17;
    		playerY = 42;
    	}
    	else if(mapName == "inn")
    	{
    		newMapName = "tmx/inn.tmx";
    		playerX = 7;
    		playerY = 7;
    	}
    	else if(mapName == "mountains")
    	{
    		newMapName = "tmx/Mountain.tmx";
    		playerX = 7;
    		playerY = 58;
    	}
    	else if(mapName == "plains")
    	{
    		newMapName =  "tmx/plains.tmx";
    		playerX = 7;
    		playerY = 57;
    	}
    	else
    	{
    		newMapName = "tmx/village.tmx";
    		playerX = 17;
    		playerY = 42;
    	}
    	
    					//Use AsyncTask to load TMX map 			 

		//Initializes the TMXLoader and TMX map	
		try 
		{
			TMXloader = new TMXLoader(((DragonsReignActivity)activity).getAssets(), ((DragonsReignActivity)activity).getTextureManager(), ((DragonsReignActivity)activity).getVertexBufferObjectManager(), new ITMXTilePropertiesListener() 
			{
				@Override
	            public void onTMXTileWithPropertiesCreated(final TMXTiledMap pTMXTiledMap, final TMXLayer pTMXLayer, final TMXTile pTMXTile, final TMXProperties<TMXTileProperty> pTMXTileProperties) 
				{
					for (int i = 0; i < pTMXTileProperties.size(); i++) 
					{
						
//										if(pTMXTileProperties.get(i).getName().contentEquals("COLLISION") && pTMXLayer.getName().contentEquals("Alpha Layer"))
//										{
//											mCollideTiles.add(pTMXTile);
//										}
							
					}
	            }
			}); 
			mTMXTiledMap = TMXloader.loadFromAsset(newMapName);
		}
		catch (final TMXLoadException tmxle)
		{
			Debug.e(tmxle);
			
		} 
	    //////////////////////////////////////////////////////////////////////
	    //Adds TMX Layers To The Scene
	    //////////////////////////////////////////////////////////////////////
		for (int i = 0; i < mTMXTiledMap.getTMXLayers().size(); i++)
		{
            layer = mTMXTiledMap.getTMXLayers().get(i);
            attachChild(layer);
		}


		 //////////////////////////////////////////////////////////////////////
	    //Adds Collision shapes around the TMX Layer
	    //////////////////////////////////////////////////////////////////////
		createUnwalkableObjects(mTMXTiledMap);
		

	    //////////////////////////////////////////////////////////////////////
	    //Binds Camera To TMX Layer
	    //////////////////////////////////////////////////////////////////////
        ((BoundCamera) camera).setBounds(0, 0, layer.getWidth(), layer.getHeight());
        ((BoundCamera) camera).setBoundsEnabled(true);
        
//				final float centerX = (camera.getWidth() - ResourceManager.getInstance().mPlayerTextureRegion.getWidth()) / 2;
//		        final float centerY = (camera.getHeight() - ResourceManager.getInstance().mPlayerTextureRegion.getHeight()) / 2;
	
        //////////////////////////////////////////////////////////////////////
        //Adds Bounds
        //////////////////////////////////////////////////////////////////////
        addBounds(layer.getWidth(), layer.getHeight());
        
        //////////////////////////////////////////////////////////////////////
        //Creates and Adds the Animated Sprite, Sets Camera Chase Entity
        //////////////////////////////////////////////////////////////////////
        player = new AnimatedSprite(playerX * 32, playerY * 32, ResourceManager.getInstance().mPlayerTextureRegion, ((DragonsReignActivity)activity).getVertexBufferObjectManager());
        camera.setChaseEntity(player);
        final FixtureDef playerFixtureDef = PhysicsFactory.createFixtureDef(0, 0, 0.5f);
        mPlayerBody = PhysicsFactory.createBoxBody(mPhysicsWorld, player, BodyType.DynamicBody, playerFixtureDef);
        
        //////////////////////////////////////////////////////////////////////
        //Register Physics Connector
        //////////////////////////////////////////////////////////////////////
        mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(player, mPlayerBody, true, false)
        {
	            //////////////////////////////////////////////////////////////////////
	            //Updates Chase Entity
	            //////////////////////////////////////////////////////////////////////
                @Override
                public void onUpdate(float pSecondsElapsed)
                {
                        super.onUpdate(pSecondsElapsed);
                        camera.updateChaseEntity();
                }
        });
        
        physicsHandler = new PhysicsHandler(player);
        player.registerUpdateHandler(physicsHandler);
        attachChild(player);				
				
				
				
    }	
			
			
		
  
    //////////////////////////////////////////////////////////////////////
    //Adds Collision shapes around the TMX Layer
    //////////////////////////////////////////////////////////////////////
	private void addBounds(float width, float height)
	{ 
	    bottom = new Rectangle(0, height - 2, width, 2, ((DragonsReignActivity)activity).getVertexBufferObjectManager());
	    bottom.setVisible(true);
	    top = new Rectangle(0, 0, width, 2, ((DragonsReignActivity)activity).getVertexBufferObjectManager());
	    top.setVisible(true);
	    left = new Rectangle(0, 0, 2, height, ((DragonsReignActivity)activity).getVertexBufferObjectManager());
	    left.setVisible(true);
	    right = new Rectangle(width - 2, 0, 2, height, ((DragonsReignActivity)activity).getVertexBufferObjectManager());     
	    right.setVisible(false);
	    
	    wallFixtureDef = PhysicsFactory.createFixtureDef(0, 0, 1f);
	    PhysicsFactory.createBoxBody(this.mPhysicsWorld, bottom, BodyType.StaticBody, wallFixtureDef);
	    PhysicsFactory.createBoxBody(this.mPhysicsWorld, top, BodyType.StaticBody, wallFixtureDef);
	    PhysicsFactory.createBoxBody(this.mPhysicsWorld, left, BodyType.StaticBody, wallFixtureDef);
	    PhysicsFactory.createBoxBody(this.mPhysicsWorld, right, BodyType.StaticBody, wallFixtureDef);
	
	    this.attachChild(bottom);
	    this.attachChild(top);
	    this.attachChild(left);
	    this.attachChild(right);
	}
    
	public void goBackToGame(){
			Scene scene = getChildScene();
			setChildScene(mDigitalOnScreenControl);
			scene.detachSelf();
			scene.dispose();
			camera.setChaseEntity(player);
		}
}
