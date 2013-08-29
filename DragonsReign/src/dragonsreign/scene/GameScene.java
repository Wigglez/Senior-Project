package dragonsreign.scene;



import org.andengine.entity.scene.background.Background;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;

import org.andengine.util.color.Color;

import dragonsreign.scene.BaseScene;
import dragonsreign.manager.SceneManager;
import dragonsreign.manager.SceneManager.SceneType;


public class GameScene extends BaseScene implements IOnMenuItemClickListener
{
	
	
	private final int GAME_BACKPACK = 0;
	private final int GAME_MAP = 1;



	private MenuScene gameChildScene;
	private ScaleMenuItemDecorator backpackHUDItem, mapHUDItem;

	
	
	
	
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
