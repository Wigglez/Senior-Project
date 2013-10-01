package dragonsreign.manager;

import java.io.IOException;

import org.andengine.audio.music.Music;
import org.andengine.audio.music.MusicFactory;
import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.engine.Engine;

import android.content.Context;

public class SoundManager {
	public static Sound mPunchSound;
	
	public static Music mMenuThemeMusic, mBattleMusic, mMenuMusic;
	
	SoundManager(){
		
	}
	
	public static void loadSounds(Engine engine, Context context){
		SoundFactory.setAssetBasePath("mfx/sounds/");
		try {
			// Here we will create our sound file through the use of AndEngine's SoundFactory
			mPunchSound = SoundFactory.createSoundFromAsset(engine.getSoundManager(), context, "punch.wav");// #31 on word doc
			mPunchSound.setVolume(100);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		MusicFactory.setAssetBasePath("mfx/music/");
	try {
		// Here we will create our sound file through the use of AndEngine's MusicFactory
		mMenuThemeMusic = MusicFactory.createMusicFromAsset(engine.getMusicManager(), context, "backgroundMusic.ogg");//#6 on word doc
		
		// Set theme music looping to true so it starts over when the mp3 reaches its duration
		mMenuThemeMusic.setLooping(true);
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
		}
	
	try {
		// Here we will create our sound file through the use of AndEngine's MusicFactory
		mBattleMusic = MusicFactory.createMusicFromAsset(engine.getMusicManager(), context, "BattleMusic.wav");//#9 on word doc
		
		// Set theme music looping to true so it starts over when the mp3 reaches its duration
		mBattleMusic.setLooping(true);
		mBattleMusic.setVolume((float) .75);
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	try {
		// Here we will create our sound file through the use of AndEngine's MusicFactory
		mMenuMusic = MusicFactory.createMusicFromAsset(engine.getMusicManager(), context, "menuMusic.wav");// #1 on word doc
		
		// Set theme music looping to true so it starts over when the mp3 reaches its duration
		mMenuMusic.setLooping(true);
		//mMenuMusic.setVolume((float) .75);
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
