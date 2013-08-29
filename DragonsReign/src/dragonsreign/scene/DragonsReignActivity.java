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
import dragonsreign.character.characterclass.WarriorClass;

// TODO: Auto-generated Javadoc
/**
 * The Class DragonsReignActivity.
 */
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


	protected ResourceManager resourceManager;
	/** The m camera. */
	protected Camera mCamera;

	/** The m font. */
	protected Font mFont;

	/** The m character test. */
	protected WarriorClass mCharacterTest;

	/** The m base health. */
	protected String mBaseHealth;

	/** The m base mana. */
	protected String mBaseResource;

	/** The m prefix warrior stats. */
	protected String mPrefixStats;

	/** The m prefix stat health. */
	protected String mPrefixStatHealth;

	/** The m prefix stat mana. */
	protected String mPrefixStatMana;

	/** The m prefix stat energy. */
	protected String mPrefixStatEnergy;

	/** The m prefix stat stamina. */
	protected String mPrefixStatStamina;

	/** The m prefix warrior resources. */
	protected String mPrefixResources;

	/** The m prefix stat strength. */
	protected String mPrefixStatStrength;

	/** The m prefix stat dexterity. */
	protected String mPrefixStatDexterity;

	/** The m prefix stat intelligence. */
	protected String mPrefixStatIntelligence;

	/** The m prefix stat vitality. */
	protected String mPrefixStatVitality;

	/** The m prefix stat damage. */
	protected String mPrefixStatDamage;

	/** The m prefix stat armor. */
	protected String mPrefixStatArmor;

	/** The m warrior stats. */
	protected String mStats;

	/** The m warrior resources. */
	protected String mResources;

	/** The m base strength. */
	protected String mBaseStrength;

	/** The m base dexterity. */
	protected String mBaseDexterity;

	/** The m base vitality. */
	protected String mBaseVitality;

	/** The m base intelligence. */
	protected String mBaseIntelligence;

	/** The m base damage. */
	protected String mBaseDamage;

	/** The m base armor. */
	protected String mBaseArmor;

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
	/**
	 * Creates the test.
	 */
	public void createTest() {
		mCharacterTest = new WarriorClass();

		mPrefixStats = "Base Stats: ";
		mPrefixStatStrength = "Strength: ";
		mPrefixStatDexterity = "Dexterity: ";
		mPrefixStatIntelligence = "Intelligence: ";
		mPrefixStatVitality = "Vitality: ";
		mPrefixStatDamage = "Damage: ";
		mPrefixStatArmor = "Armor: ";

		mPrefixResources = "Base Resources: ";
		mPrefixStatHealth = "Health: ";
		mPrefixStatMana = "Mana: ";
		mPrefixStatEnergy = "Energy: ";
		mPrefixStatStamina = "Stamina: ";

		mCharacterTest.getBaseStats().setStrength(50);
		mCharacterTest.getBaseStats().setDexterity(45);
		mCharacterTest.getBaseStats().setIntelligence(30);
		mCharacterTest.getBaseStats().setVitality(25);
		mCharacterTest.getBaseStats().setDamage(20);
		mCharacterTest.getBaseStats().setArmor(15);

		mCharacterTest.getBaseResources().setHealth(500);
		mCharacterTest.getBaseResources().setResource(12);
		// Stats
		mBaseStrength = String.valueOf(mCharacterTest.getBaseStats()
				.getStrength());
		mBaseDexterity = String.valueOf(mCharacterTest.getBaseStats()
				.getDexterity());
		mBaseIntelligence = String.valueOf(mCharacterTest.getBaseStats()
				.getIntelligence());
		mBaseVitality = String.valueOf(mCharacterTest.getBaseStats()
				.getVitality());
		mBaseDamage = String.valueOf(mCharacterTest.getBaseStats().getDamage());
		mBaseArmor = String.valueOf(mCharacterTest.getBaseStats().getArmor());

		// Resources
		mBaseHealth = String.valueOf(mCharacterTest.getBaseResources()
				.getHealth());
		mBaseResource = String.valueOf(mCharacterTest.getBaseResources()
				.getResource());

		mStats = mPrefixStats + "\n" + mPrefixStatStrength + mBaseStrength
				+ "\n" + mPrefixStatDexterity + mBaseDexterity + "\n"
				+ mPrefixStatIntelligence + mBaseIntelligence + "\n"
				+ mPrefixStatVitality + mBaseVitality + "\n"
				+ mPrefixStatDamage + mBaseDamage + "\n" + mPrefixStatArmor
				+ mBaseArmor;

		mResources = mPrefixResources + "\n" + mPrefixStatHealth + mBaseHealth
				+ "\n" + mPrefixStatMana + mBaseResource;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
