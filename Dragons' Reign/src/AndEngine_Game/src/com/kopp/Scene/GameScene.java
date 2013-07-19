package com.kopp.Scene;


import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.background.Background;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.util.color.Color;

import com.kopp.BaseScene.BaseScene;
import com.kopp.Manager.SceneManager.SceneType;


public class GameScene extends BaseScene
{
	
    @Override
    public void createScene()
    {
    	setBackground(new Background(Color.BLUE));

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
}
