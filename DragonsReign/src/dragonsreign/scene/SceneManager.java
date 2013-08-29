/*
 * 
 */
package dragonsreign.scene;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.ui.activity.BaseGameActivity;

// TODO: Auto-generated Javadoc
/**
 * The Class SceneManager.
 */
public class SceneManager {
	// ===========================================================
	// Constants
	// ===========================================================

	/**
	 * The Enum AllScenes.
	 */
	public enum AllScenes {

		/** The splash. */
		SPLASH,
		/** The menu. */
		MENU,
		/** The game. */
		GAME
	}

	// ===========================================================
	// Fields
	// ===========================================================

	/** The m current scene. */
	protected AllScenes mCurrentScene;

	/** The m activity. */
	protected BaseGameActivity mActivity;

	/** The m engine. */
	protected Engine mEngine;

	/** The m camera. */
	protected Camera mCamera;

	/** The m splash ta. */
	protected BitmapTextureAtlas mSplashTA;

	/** The m splash tr. */
	protected ITextureRegion mSplashTR;

	/** The m splash scene. */
	protected Scene mSplashScene;

	/** The m game scene. */
	protected Scene mGameScene;

	/** The m menu scene. */
	protected Scene mMenuScene;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
	 * Instantiates a new scene manager.
	 * 
	 * @param pActivity
	 *            the activity
	 * @param pEngine
	 *            the engine
	 * @param pCamera
	 *            the camera
	 */
	public SceneManager(BaseGameActivity pActivity, Engine pEngine,
			Camera pCamera) {
		// TODO Auto-generated constructor stub
		this.mActivity = pActivity;
		this.mEngine = pEngine;
		this.mCamera = pCamera;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	/**
	 * Gets the current scene.
	 * 
	 * @return the current scene
	 */
	public AllScenes getCurrentScene() {
		return getCurrentScene();
	}

	/**
	 * Sets the current scene.
	 * 
	 * @param pCurrentScene
	 *            the new current scene
	 */
	public void setCurrentScene(AllScenes pCurrentScene) {
		this.mCurrentScene = pCurrentScene;
		switch (mCurrentScene) {
		case SPLASH:
			break;
		case MENU:
			mEngine.setScene(mMenuScene);
			break;
		case GAME:
			mEngine.setScene(mGameScene);
			break;

		default:
			break;
		}
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Load splash resources.
	 */
	public void loadSplashResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
		mSplashTA = new BitmapTextureAtlas(this.mActivity.getTextureManager(),
				256, 256);
		mSplashTR = BitmapTextureAtlasTextureRegionFactory.createFromAsset(
				mSplashTA, this.mActivity, "splash.png", 0, 0);
		mSplashTA.load();
	}

	/**
	 * Load game resources.
	 */
	public void loadGameResources() {

	}

	/**
	 * Load menu resources.
	 */
	public void loadMenuResources() {

	}

	/**
	 * Creates the splash scene.
	 * 
	 * @return the scene
	 */
	public Scene createSplashScene() {
		mSplashScene = new Scene();
		mSplashScene.setBackground(new Background(1, 1, 1));

		Sprite icon = new Sprite(0, 0, mSplashTR,
				mEngine.getVertexBufferObjectManager());
		icon.setPosition((mCamera.getWidth() - icon.getWidth()) / 2,
				(mCamera.getHeight() - icon.getHeight()) / 2);
		mSplashScene.attachChild(icon);
		return mSplashScene;
	}

	/**
	 * Creates the menu scene.
	 * 
	 * @return the scene
	 */
	public Scene createMenuScene() {
		mMenuScene = new Scene();
		mMenuScene.setBackground(new Background(0, 0, 0));

		Sprite icon = new Sprite(0, 0, mSplashTR,
				mEngine.getVertexBufferObjectManager());
		icon.setPosition((mCamera.getWidth() - icon.getWidth()) / 2,
				(mCamera.getHeight() - icon.getHeight()) / 2);
		mMenuScene.attachChild(icon);
		return mMenuScene;

	}

	/**
	 * Creates the game scene.
	 * 
	 * @return the scene
	 */
	public Scene createGameScene() {
		return null;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

}
