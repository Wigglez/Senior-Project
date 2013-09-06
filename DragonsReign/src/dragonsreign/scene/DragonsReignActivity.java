/*
 * 
 */
package dragonsreign.scene;

import java.io.IOException;

import org.andengine.engine.Engine;
import org.andengine.engine.LimitedFPSEngine;
import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.font.Font;
import org.andengine.ui.activity.BaseGameActivity;


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

	// ===========================================================
	// Fields
	// ===========================================================


	private WarriorClass mWarriorClass = new WarriorClass();
	private RangerClass mRangerClass = new RangerClass();
	private ClericClass mClericClass = new ClericClass();

	private Camera mCamera;
	private ResourceManager resourceManager;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new dragons reign activity.
	 */
	public DragonsReignActivity() {
		// Cannot instantiate abstract class
		// mCharacterTest = new WarriorClass();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	public WarriorClass getWarriorClass() {
		return mWarriorClass;
	}

	public void setWarriorClass(WarriorClass pWarriorClass) {
		this.mWarriorClass = pWarriorClass;
	}

	public RangerClass getRangerClass() {
		return mRangerClass;
	}

	public void setRangerClass(RangerClass pRangerClass) {
		this.mRangerClass = pRangerClass;
	}

	public ClericClass getClericClass() {
		return mClericClass;
	}

	public void setClericClass(ClericClass pClericClass) {
		this.mClericClass = pClericClass;
	}
	
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
	    mCamera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
	    EngineOptions engineOptions = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,  new FillResolutionPolicy(), this.mCamera);
	    engineOptions.getAudioOptions().setNeedsMusic(true).setNeedsSound(true);
	    engineOptions.setWakeLockOptions(WakeLockOptions.SCREEN_ON);
	    return engineOptions;
	}

	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws IOException
	{
	    ResourceManager.prepareManager(mEngine, this, mCamera, getVertexBufferObjectManager());
	    resourceManager = ResourceManager.getInstance();
	    pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

    public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws IOException
    {
    	
    	SceneManager.getInstance().createSplashScene(pOnCreateSceneCallback);
    	
    	
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
	

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
