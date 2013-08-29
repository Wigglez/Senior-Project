package dragonsreign.manager;
import dragonsreign.scene.CharacterSelectionScene;
import dragonsreign.scene.GameScene;
import dragonsreign.scene.InventoryScene;
import dragonsreign.scene.LoadingScene;
import dragonsreign.scene.MainMenuScene;
import dragonsreign.scene.BattleScene;
import dragonsreign.scene.SplashScene;
import dragonsreign.scene.BaseScene;

import org.andengine.engine.Engine;
import org.andengine.engine.handler.timer.ITimerCallback;
import org.andengine.engine.handler.timer.TimerHandler;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;


public class SceneManager
{
    //---------------------------------------------
    // SCENES
    //---------------------------------------------
    
    private BaseScene splashScene, menuScene, characterScene,
    				  gameScene, battleScene, loadingScene, 
    				  inventoryScene;
    
    //---------------------------------------------
    // VARIABLES
    //---------------------------------------------
    
    private static final SceneManager INSTANCE = new SceneManager();
    
    private SceneType currentSceneType = SceneType.SCENE_SPLASH;
    
    private BaseScene currentScene;
    
    private Engine engine = ResourceManager.getInstance().engine;
    
    public enum SceneType
    {
        SCENE_SPLASH,
        SCENE_MENU,
        SCENE_CHARACTER,
        SCENE_GAME,
        SCENE_LOADING,
        SCENE_BATTLE,
        SCENE_INVENTORY
    }
    
    //---------------------------------------------
    // CLASS LOGIC
    //---------------------------------------------
    
    private void setScene(BaseScene scene)
    {
        engine.setScene(scene);
        currentScene = scene;
        currentSceneType = scene.getSceneType();
    }
    
    public void setScene(SceneType sceneType)
    {
        switch (sceneType)
        {
            case SCENE_MENU:
                setScene(menuScene);
                break;
            case SCENE_CHARACTER:
            	setScene(characterScene);
            	break;
            case SCENE_GAME:
                setScene(gameScene);
                break;
            case SCENE_BATTLE:
            	setScene(battleScene);
            	break;
            case SCENE_SPLASH:
                setScene(splashScene);
                break;
            case SCENE_LOADING:
                setScene(loadingScene);
                break;
            case SCENE_INVENTORY:
            	setScene(inventoryScene);
            default:
                break;
        }
    }
    
    //---------------------------------------------
    // Accessors Mutators
    //---------------------------------------------
    
    public static SceneManager getInstance()
    {
        return INSTANCE;
    }
    
    public SceneType getCurrentSceneType()
    {
        return currentSceneType;
    }
    
    public BaseScene getCurrentScene()
    {
        return currentScene;
    }
    public void LoadScenes(final Engine mEngine)
    {
    	//Load Resources
    	ResourceManager.getInstance().loadInventoryResources();
    	ResourceManager.getInstance().loadBattleResources();
    	
    	//Load Scenes
    	loadCharacterScene(mEngine);
    	loadGameScene(mEngine);
    	
    }
    private void createLoadingScene()
    {
    	ResourceManager.getInstance().loadMenuResources();
    	loadingScene = new LoadingScene();
    	setScene(loadingScene);
    }
    public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback)
    {
        ResourceManager.getInstance().loadSplashScreen();
        splashScene = new SplashScene();
        currentScene = splashScene;
        pOnCreateSceneCallback.onCreateSceneFinished(splashScene);
    }

    private void disposeSplashScene()
    {
        ResourceManager.getInstance().unloadSplashScreen();
        splashScene.disposeScene();
        splashScene = null;
    }
    public void createMenuScene()
    {
        
        menuScene = new MainMenuScene();
        disposeSplashScene();
    }

    private void disposeMenuScene()
    {
    	ResourceManager.getInstance().unloadMenuTextures();
    	menuScene.disposeScene();
    	menuScene = null;
    }
    public void loadMenuScene(final Engine mEngine)
    {
    	
    	createLoadingScene();
       	createMenuScene();
    	LoadScenes(mEngine);
        ResourceManager.getInstance().unloadSplashScreen();
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
        {
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                ResourceManager.getInstance().loadMenuResources();
                
                setScene(menuScene);
            }
        }));
    }
    
    private void loadCharacterScene(final Engine mEngine)
    {
    	
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback()
        {
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                //TODO create load Character screen resources
                ResourceManager.getInstance().loadCharacterSelectGraphics();
                characterScene = new CharacterSelectionScene();

            }
        }));
    }
    private void disposeCharacterScene()
    {
    	ResourceManager.getInstance().unloadCharacterSelectGraphics();
    	characterScene.disposeScene();
    	characterScene = null;
    }
    private void loadGameScene(final Engine mEngine)
    {     
        
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
        {
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                ResourceManager.getInstance().loadGameResources();
       
                gameScene = new GameScene();
 
                 
        
            }
        }));
    }
    public void loadBattleScene(final Engine mEngine)
    {
    	
        gameScene.setIgnoreUpdate(true);
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
        {
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                
                battleScene = new BattleScene();
                setScene(battleScene);
            }
        }));
    }
    public void loadInventoryScene(final Engine mEngine)
    {
    	
        gameScene.setIgnoreUpdate(true);
        mEngine.registerUpdateHandler(new TimerHandler(0.1f, new ITimerCallback() 
        {
            public void onTimePassed(final TimerHandler pTimerHandler) 
            {
                mEngine.unregisterUpdateHandler(pTimerHandler);
                inventoryScene = new InventoryScene();
                setScene(inventoryScene);
            }
        }));
    	
    }
  
    
}
