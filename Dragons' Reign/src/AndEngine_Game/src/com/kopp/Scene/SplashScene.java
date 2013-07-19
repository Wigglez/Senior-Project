package com.kopp.Scene;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.kopp.BaseScene.BaseScene;
import com.kopp.Manager.SceneManager.SceneType;


public class SplashScene extends BaseScene
{
	private Sprite andEngineSplash, companyLogoSplash;
	
    @Override
    public void createScene()
    {
    	andEngineSplash = new Sprite(0, 0, resourcesManager.andEngineLogo, vbom)
    	{
    	    @Override
    	    protected void preDraw(GLState pGLState, Camera pCamera) 
    	    {
    	       super.preDraw(pGLState, pCamera);
    	       pGLState.enableDither();
    	    }
    	};
    	
    	
    	andEngineSplash.setScale(1.0f);
    	
    	
    	andEngineSplash.setPosition(300, 120);
    	attachChild(andEngineSplash);
    	
    }

    @Override
    public void onBackKeyPressed()
    {

    }

    @Override
    public SceneType getSceneType()
    {
    	return SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene()
    {
    	andEngineSplash.detachSelf();
    	andEngineSplash.dispose();
        this.detachSelf();
        this.dispose();
    }
}