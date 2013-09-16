/*
 * 
 */
package dragonsreign.scene;

import java.io.IOException;
import java.util.ArrayList;


import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.BoundCamera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
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
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.ui.activity.BaseGameActivity;
import org.andengine.util.debug.Debug;



import dragonsreign.manager.SceneManager;
import dragonsreign.manager.ResourceManager;


import android.view.KeyEvent;
import dragonsreign.character.characterclass.ClericClass;
import dragonsreign.character.characterclass.RangerClass;
import dragonsreign.character.characterclass.WarriorClass;

public class DragonsReignActivity extends BaseGameActivity {
	// ===========================================================
	// Constants
	// ===========================================================

	/** The Constant CAMERA_WIDTH. */
	protected static final int CAMERA_WIDTH = 800;

	/** The Constant CAMERA_HEIGHT. */
	protected static final int CAMERA_HEIGHT = 480;

	private static DragonsReignActivity INSTANCE = new DragonsReignActivity();


	public static final float FADE_DURATION = 0.5f;
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	public static final long ANIM_SPEED = 150;
	public static final long[] WALK_ANIMATE_DURATION = new long[] {ANIM_SPEED, ANIM_SPEED, ANIM_SPEED, ANIM_SPEED};
	public static final float TOUCH_MOVEMENT_WALKING_SPEED = 0.50f;
	public static final float DPAD_MOVEMENT_WALKING_SPEED = 1f;
	protected static final float CAMERA_SCROLLING = 0.25f;
	private static final int FRAMES_PER_SECOND = 60;
	public static final float RUNNING_SPEED = 0.45f;
	public static final float WALKING_SPEED = 0.65f;
	public static final int Y_COORDINATE = 1;
	public static final int X_COORDINATE = 0;
	public static final int UP_CENTER_TILE = 4;
	public static final int DOWN_CENTER_TILE = 1;
	public static final int RIGHT_CENTER_TILE = 10;
	public static final int LEFT_CENTER_TILE = 7;
	public static final float ANIMATE_TILE_DURATION = 0.5f;
	// ===========================================================
	// Fields
	// ===========================================================

//  private WarriorClass mWarriorClass = new WarriorClass();
//	private RangerClass mRangerClass = new RangerClass();
//	private ClericClass mClericClass = new ClericClass();


	public  BoundCamera mCamera;
	//private ResourceManager resourceManager;

	


	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new dragons reign activity.
	 */
	public DragonsReignActivity() 
	{
		// Cannot instantiate abstract class
		// mCharacterTest = new WarriorClass();
		

	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

//	public WarriorClass getWarriorClass() {
//		return mWarriorClass;
//	}

//	public void setWarriorClass(WarriorClass pWarriorClass) {
//		this.mWarriorClass = pWarriorClass;
//	}
//
//	public RangerClass getRangerClass() {
//		return mRangerClass;
//	}
//
//	public void setRangerClass(RangerClass pRangerClass) {
//		this.mRangerClass = pRangerClass;
//	}
//
//	public ClericClass getClericClass() {
//		return mClericClass;
//	}
//
//	public void setClericClass(ClericClass pClericClass) {
//		this.mClericClass = pClericClass;
//	}
	
	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	
	@Override
	public Engine onCreateEngine(EngineOptions pEngineOptions) 
	{
		
	    return new LimitedFPSEngine(pEngineOptions, 60);
	}
	
    
	public EngineOptions onCreateEngineOptions()
	{
	    mCamera = new BoundCamera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,  new FillResolutionPolicy(), this.mCamera);
	    engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
	    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
	    return engineOptions;
	}

	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException
	{
	    ResourceManager.prepareManager(mEngine, this, mCamera, getVertexBufferObjectManager());
	    pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

    
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException
    {
		SceneManager.getInstance().Initialize(this);
    	SceneManager.getInstance().createSplashScene(pOnCreateSceneCallback);
    	
    	//pOnCreateSceneCallback.onCreateSceneFinished(SceneManager.getInstance().getCurrentScene());
    	
    }

    public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws IOException
    {
    	//Create Splash Scene
    	mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback() 
        {
                public void onTimePassed(final TimerHandler pTimerHandler) 
                {
                    mEngine.unregisterUpdateHandler(pTimerHandler);
                   
                }
        }));
        pOnPopulateSceneCallback.onPopulateSceneFinished();
        
        //Create Menu Scene
        mEngine.registerUpdateHandler(new TimerHandler(2f, new ITimerCallback() 
        {
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                SceneManager.getInstance().loadMenuScene(mEngine);
                
            }
        }));
        pOnPopulateSceneCallback.onPopulateSceneFinished();
        
    }
    
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) 
    {  
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            SceneManager.getInstance().getCurrentScene().onBackKeyPressed();
        }
        return false; 
    }
    
    @Override
    protected void onPause()
    {
    	super.onPause();
          
    }

    @Override
    protected synchronized void onResume()
    {
    	super.onResume();
    }
    
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
            
        if (this.isGameLoaded())
        {
            System.exit(0);    
        }
    }
	

    public static DragonsReignActivity getInstance()
    {
        return INSTANCE ;
    }
	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
