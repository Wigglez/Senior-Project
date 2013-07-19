package com.kopp.Scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;

import com.kopp.BaseScene.BaseScene;
import com.kopp.Game.MainGameActivity;
import com.kopp.Manager.SceneManager;
import com.kopp.Manager.SceneManager.SceneType;

public class MainMenuScene extends BaseScene implements IOnMenuItemClickListener
{

	private MenuScene menuChildScene;
	private MainGameActivity main;
	private final int MENU_PLAY = 0;
	private final int MENU_EXIT = 1;
	
	private Text playButtonText, exitButtonText;
	
	
	private void createMenuChildScene()
	{
	    menuChildScene = new MenuScene(camera);
	    menuChildScene.setPosition(0, 0);
	    
	    final IMenuItem playMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_PLAY, resourcesManager.playButton, vbom), 1.2f, 1);
	    final IMenuItem exitMenuItem = new ScaleMenuItemDecorator(new SpriteMenuItem(MENU_EXIT, resourcesManager.optionsButton, vbom), 1.2f, 1);
	    
	    playButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
	    playButtonText.setText("Play");
		
	    exitButtonText = new Text(40,10, resourcesManager.font, "" ,150, new TextOptions(), vbom);
	    exitButtonText.setText("Exit");
		
	    menuChildScene.addMenuItem(playMenuItem);
	    menuChildScene.addMenuItem(exitMenuItem);
	    
	    playMenuItem.attachChild(playButtonText);
	    exitMenuItem.attachChild(exitButtonText);
	    
	    menuChildScene.buildAnimations();
	    menuChildScene.setBackgroundEnabled(false);
	    
	    playMenuItem.setPosition(200, 225);
	    exitMenuItem.setPosition(200, 325);
	    
	    menuChildScene.setOnMenuItemClickListener(this);
	    
	    setChildScene(menuChildScene);
	}
	private void createBackground()
	{
	    attachChild(new Sprite(0, 0, resourcesManager.menuBackgroundRegion, vbom)
	    {
	        @Override
	        protected void preDraw(GLState pGLState, Camera pCamera) 
	        {
	            super.preDraw(pGLState, pCamera);
	            pGLState.enableDither();
	        }
	    });
	}

	@Override
	public void createScene() 
	{
		createBackground();
		createMenuChildScene();
	}

	@Override
	public void onBackKeyPressed() 
	{
		System.exit(0);
	}

	@Override
	public SceneType getSceneType() 
	{
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene() 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem, float pMenuItemLocalX, float pMenuItemLocalY)
	{
		switch(pMenuItem.getID())
		{
	        case MENU_PLAY:
	        	//Load Game Scene!
	            SceneManager.getInstance().LoadCharacterScene(engine);
	            return true;
	        case MENU_EXIT:
	        	System.exit(0);
	            return true;
	        default:
	            return false;
	    }
	}
	
}
